package tma.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.HeaderDataDTO;
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
import tma.com.repository.IResponseRepository;

@Service
public class ResponseService implements IResponseService{
	
	@Autowired
	private IResponseRepository responseRepository;
	
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
	private IAggregatedDataCategoryRepository aggregatedDataCategoryRespository;
	
	private DataSourceName dataSourceName;
	private DataSourceFile dataSourceFile;
	//private Index index;
	private GeoLevelLookup geoLevelLookup;
	private AggregatedData aggregatedData;
	private AggregatedDataCategory aggregatedDataCategory;

	@Override
	public ResponseDTO getData(ResponseDTO responseDto) {
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
				dataSourceFileRepository.save(dataSourceFile);
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
							if (sheetDataDto.getListHeaderData() != null) {
								/*for (HeaderDataDTO headerDataDto: sheetDataDto.getListHeaderData()) {
									DataSourceColumnDefinition dataSourceColumnDefinition = new DataSourceColumnDefinition();
									dataSourceColumnDefinition.setCategory(headerDataDto.getCategory());
									dataSourceColumnDefinition.setName(headerDataDto.getNameInExcelFile());
									dataSourceColumnDefinition.setUiName(headerDataDto.getNameForUI());
									dataSourceColumnDefinition.setDataSourceName(dataSourceName);
									dataSourceColumnDefinition = dataSourceColumnDefinitionRepository.save(dataSourceColumnDefinition);
									
									if (sheetDataDto.getListRowData() != null) {
										for (String row : sheetDataDto.getListRowData()) {
											
										}
										if (headerDataDto.getCategory() == "overall") {
											
										}
									}
								}*/
								
								//List<String> listDataValue = sheetDataDto.getListRowData().subList(2,  sheetDataDto.getListRowData().size());
								//list<double> listNumericData = listDataValue.Select(x => double.Parse(x))dataSourceGeoLevel.ToList();
							
								for (int i = 0; i < sheetDataDto.getListHeaderData().size(); i++) {
									DataSourceColumnDefinition dataSourceColumnDefinition = new DataSourceColumnDefinition();
									dataSourceColumnDefinition.setCategory(sheetDataDto.getListHeaderData().get(i).getCategory());
									dataSourceColumnDefinition.setName(sheetDataDto.getListHeaderData().get(i).getNameInExcelFile());
									dataSourceColumnDefinition.setUiName(sheetDataDto.getListHeaderData().get(i).getNameForUI());
									dataSourceColumnDefinition.setDataSourceName(dataSourceName);
									dataSourceColumnDefinition = dataSourceColumnDefinitionRepository.save(dataSourceColumnDefinition);
									
									if (sheetDataDto.getListRowData() != null) {
										aggregatedData = new AggregatedData();
										aggregatedData.setGeoLevelState(sheetDataDto.getListRowData().get(0));
										aggregatedData.setGeoLevelName(sheetDataDto.getListRowData().get(1));
										aggregatedData.setDataSourceGeoLevel(dataSourceGeoLevel); //Check(?)
										aggregatedDataCategory = new AggregatedDataCategory();
										if (sheetDataDto.getListHeaderData().get(i).getCategory() == "OVERALL") {
											aggregatedData.setOverall(Double.parseDouble(sheetDataDto.getListRowData().get(i)));
											aggregatedData = aggregatedDataRepository.save(aggregatedData);
										} else if (sheetDataDto.getListHeaderData().get(i).getCategory() == "BE_EXCLUED" || 
												sheetDataDto.getListHeaderData().get(i).getCategory() == "GEO") {
											
										} else {
											aggregatedDataCategory.setDataValue(Double.parseDouble(sheetDataDto.getListRowData().get(i)));
										}
										
										/*if (headerDataDto.getCategory() == "overall") {
											
										}*/
									}
								}
							}
						}
					}
				}
			}
		}
		return responseRepository.save(responseDto) ;
	}
	
	/*public Boolean insert(ResponseDTO responseDto) {
		// TODO Auto-generated method stub
		
		if (responseDto != null) {
			if(responseDto.getListIndex() != null) {
				for (int i = 0; i < responseDto.getListIndex().size(); i ++) {
					Index index = responseDto.getListIndex()[i];
					indexRepo.save(index);
				}
			}
		}
		//aggregatedData.set
		//aggregatedData.set
		return null;
	}*/
	
	// Convert String list to Double list
	
}
