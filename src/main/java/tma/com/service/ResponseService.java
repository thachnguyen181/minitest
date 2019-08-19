package tma.com.service;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.IndexDTO;
import tma.com.dto.ResponseDTO;
import tma.com.dto.SheetDataDTO;
import tma.com.model.AggregatedData;
import tma.com.model.AggregatedDataCategory;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.model.DataSourceFile;
import tma.com.model.DataSourceGeoLevel;
import tma.com.model.DataSourceIndex;
import tma.com.model.DataSourceName;
import tma.com.model.GeoLevelLookup;
import tma.com.model.Index;
import tma.com.repository.IAggregatedDataCategoryRepository;
import tma.com.repository.IAggregatedDataRepository;
import tma.com.repository.IDataSourceColumnDefinitionRepository;
import tma.com.repository.IDataSourceFileRepository;
import tma.com.repository.IDataSourceGeoLevelRepository;
import tma.com.repository.IDataSourceIndexRepository;
import tma.com.repository.IDataSourceNameRepository;
import tma.com.repository.IGeoLevelLookupRepository;
import tma.com.repository.IIndexRepository;

@Service
public class ResponseService implements IResponseService {

	@Autowired
	private IDataSourceNameRepository dataSourceNameRepository;

	@Autowired
	private IDataSourceFileRepository dataSourceFileRepository;

	@Autowired
	private IIndexRepository indexRepository;

	@Autowired
	private IDataSourceIndexRepository dataSourceIndexRepository;

	@Autowired
	private IGeoLevelLookupRepository geoLevelLookupRepository;

	@Autowired
	private IDataSourceGeoLevelRepository dataSourceGeoLevelRepository;

	@Autowired
	private IDataSourceColumnDefinitionRepository dataSourceColumnDefinitionRepository;

	@Autowired
	private IAggregatedDataRepository aggregatedDataRepository;

	@Autowired
	private IAggregatedDataCategoryRepository aggregatedDataCategoryRepository;

	private DataSourceName dataSourceName;
	private DataSourceFile dataSourceFile;
	// private Index index;
	private GeoLevelLookup geoLevelLookup;
	private AggregatedData aggregatedData;
	private AggregatedDataCategory aggregatedDataCategory;

	@Override
	public String getData(ResponseDTO responseDto) {
		// TODO Auto-generated method stub

		if (responseDto != null) {
			if (responseDto.getDataSourceName() != "") {

				// data_source_name
				if (dataSourceNameRepository.findByName(responseDto.getDataSourceName()) != null) {
					dataSourceName = dataSourceNameRepository.findByName(responseDto.getDataSourceName());
				} else {
					dataSourceName = new DataSourceName();
					dataSourceName.setName(responseDto.getDataSourceName());

					dataSourceName = dataSourceNameRepository.save(dataSourceName);
				}

				// data_source_file
				dataSourceFile = new DataSourceFile();
				dataSourceFile.setDataSourceName(dataSourceName);
				dataSourceFile.setFileName(responseDto.getFileName());
				dataSourceFile.setYear(responseDto.getYear());
				dataSourceFile.setPercentage(responseDto.isPercentage());
				dataSourceFile.setSubmitAction(responseDto.getSubmitAction());
				dataSourceFile.setStatisticType(responseDto.getStatisticType());
				dataSourceFile.setS3KeyName(responseDto.getS3KeyName());

				dataSourceFile = dataSourceFileRepository.save(dataSourceFile);
			} else {
				return "DataSourceName is null";
			}

			// index
			if (responseDto.getListIndex() != null) {
				for (IndexDTO indexDto : responseDto.getListIndex()) {
					Index index = new Index();
					index.setDisplayName(indexDto.getDisplayName());
					index.setIndexName(indexDto.getIndexName());
					index.setCreatedAt(new Date());
					index.setUpdatedAt(new Date());

					index = indexRepository.save(index);

					// data_source_index
					// Check(data_source_name)?
					DataSourceIndex dataSourceIndex = new DataSourceIndex();
					dataSourceIndex.setDataSourceName(dataSourceName);
					dataSourceIndex.setIndex(index);

					dataSourceIndexRepository.save(dataSourceIndex);
				}
			} else {
				return "ListIndex is null";
			}

			// geo_level_lookup
			if (responseDto.getListSheetData() != null) {
				for (SheetDataDTO sheetDataDto : responseDto.getListSheetData()) {
					if (sheetDataDto.getGeoLevel() != "") {
						if (geoLevelLookupRepository.findByName(sheetDataDto.getGeoLevel()) != null) {
							geoLevelLookup = geoLevelLookupRepository.findByName(sheetDataDto.getGeoLevel());
						} else {
							geoLevelLookup = new GeoLevelLookup();
							geoLevelLookup.setGeoName(sheetDataDto.getGeoLevel());

							geoLevelLookup = geoLevelLookupRepository.save(geoLevelLookup);
						}

						// data_source_geo_level
						// Check(data_source_file)?
						DataSourceGeoLevel dataSourceGeoLevel = new DataSourceGeoLevel();
						dataSourceGeoLevel.setDataSourceFile(dataSourceFile);
						dataSourceGeoLevel.setGeoLevelLookup(geoLevelLookup);

						dataSourceGeoLevel = dataSourceGeoLevelRepository.save(dataSourceGeoLevel);

						// data_source_column_definition
						if (dataSourceName != null) {
							List<String> stringList = Arrays.asList("OVERALL", "BE_EXCLUED", "GEO");
							if (sheetDataDto.getListHeaderData() != null) {
								for (int i = 2; i < sheetDataDto.getListHeaderData().size(); i++) {
									if (sheetDataDto.getListHeaderData().get(i).getCategory() == "OVERALL") {
										// CheckListRowData(?)
										for (List<String> rowData : sheetDataDto.getListRowData()) {
											aggregatedData = new AggregatedData();
											aggregatedData.setGeoLevelState(rowData.get(0));
											aggregatedData.setGeoLevelName(rowData.get(1));
											aggregatedData.setDataSourceGeoLevel(dataSourceGeoLevel); // Check(?)
											aggregatedData
													.setOverall(Double.parseDouble(rowData.get(i)));

											aggregatedData = aggregatedDataRepository.save(aggregatedData);
										}								
									}
								}

								for (int i = 0; i < sheetDataDto.getListHeaderData().size(); i++) {
									DataSourceColumnDefinition dataSourceColumnDefinition = new DataSourceColumnDefinition();
									dataSourceColumnDefinition
											.setCategory(sheetDataDto.getListHeaderData().get(i).getCategory());
									dataSourceColumnDefinition
											.setName(sheetDataDto.getListHeaderData().get(i).getNameInExcelFile());
									dataSourceColumnDefinition
											.setUiName(sheetDataDto.getListHeaderData().get(i).getNameForUI());
									dataSourceColumnDefinition.setDataSourceName(dataSourceName);

									dataSourceColumnDefinition = dataSourceColumnDefinitionRepository
											.save(dataSourceColumnDefinition);

									if (sheetDataDto.getListRowData() != null) {
										if (!stringList
												.contains(sheetDataDto.getListHeaderData().get(i).getCategory())) {
											aggregatedDataCategory = new AggregatedDataCategory();
											aggregatedDataCategory
													.setDataSourceColumnDefinition(dataSourceColumnDefinition);
											aggregatedDataCategory.setAggregatedData(aggregatedData);
											for (List<String> rowData : sheetDataDto.getListRowData()) {
												aggregatedDataCategory.setDataValue(
														Double.parseDouble(rowData.get(i)));
											}
											
											aggregatedDataCategoryRepository.save(aggregatedDataCategory);
										}
									} else {
										return "ListRowData is null";
									}
								}
							} else {
								return "ListHeaderData is null";
							}
						}
					} else {
						return "GeoLevel is null";
					}
				}
			} else {
				return "ListSheetData is null";
			}
		} else {
			return "responseDto is null";
		}
		return "Save!";
	}
}
