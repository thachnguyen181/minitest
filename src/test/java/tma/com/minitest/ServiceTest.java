package tma.com.minitest;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.joda.time.DateTime;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

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
import tma.com.service.ResponseService;

@RunWith(MockitoJUnitRunner.class)
public class ServiceTest {

	@InjectMocks
	private ResponseService repsonseService;
	
	@Mock
	private IDataSourceNameRepository dataSourceNameRepository;

	@Mock
	private IDataSourceFileRepository dataSourceFileRepository;

	@Mock
	private IIndexRepository indexRepository;

	@Mock
	private IDataSourceIndexRepository dataSourceIndexRepository;

	@Mock
	private IGeoLevelLookupRepository geoLevelLookupRepository;

	@Mock
	private IDataSourceGeoLevelRepository dataSourceGeoLevelRepository;

	@Mock
	private IDataSourceColumnDefinitionRepository dataSourceColumnDefinitionRepository;

	@Mock
	private IAggregatedDataRepository aggregatedDataRepository;

	@Mock
	private IAggregatedDataCategoryRepository aggregatedDataCategoryRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
	}
	
	@Test
	public void testSaveDataSuccessful() throws Exception{
		//----------------------Set up data----------------------//
		List<HeaderDataDTO> listHeaderData = new ArrayList<HeaderDataDTO>();		
		HeaderDataDTO headerDataDto1 = new HeaderDataDTO();
		headerDataDto1.setNameInExcelFile("st");
		headerDataDto1.setNameForUI("st");
		headerDataDto1.setCategory("BE_EXCLUDED");
		listHeaderData.add(headerDataDto1);
		
		HeaderDataDTO headerDataDto2 = new HeaderDataDTO();
		headerDataDto2.setNameInExcelFile("zip");
		headerDataDto2.setNameForUI("zip");
		headerDataDto2.setCategory("GEO");
		listHeaderData.add(headerDataDto2);
		
		HeaderDataDTO headerDataDto3 = new HeaderDataDTO();
		headerDataDto3.setNameInExcelFile("overall");
		headerDataDto3.setNameForUI("overall");
		headerDataDto3.setCategory("OVERALL");
		listHeaderData.add(headerDataDto3);
		
		HeaderDataDTO headerDataDto4 = new HeaderDataDTO();
		headerDataDto4.setNameInExcelFile("test1");
		headerDataDto4.setNameForUI("test1");
		headerDataDto4.setCategory("Test1");
		listHeaderData.add(headerDataDto4);
		
		HeaderDataDTO headerDataDto5 = new HeaderDataDTO();
		headerDataDto5.setNameInExcelFile("test1");
		headerDataDto5.setNameForUI("test1");
		headerDataDto5.setCategory("Test1");
		listHeaderData.add(headerDataDto5);
		
		List<String> rowData = Arrays.asList("TT", "12345", "0.001588407621957103", "0.0014352833776099638", "0.0015129458294841252");
		List<List<String>> listRowData = new ArrayList<List<String>>();
		listRowData.add(rowData);
		
		List<IndexDTO> listIndex = new ArrayList<IndexDTO>();
		IndexDTO indexDto = new IndexDTO();		
		indexDto.setId(1);
		indexDto.setIndexName("test_index");
		indexDto.setDisplayName("test_index");
		indexDto.setCreateAt(new DateTime().getMillis());
		indexDto.setUpdatedAt(new DateTime().getMillis());	
		listIndex.add(indexDto);
		
		List<SheetDataDTO> listSheetData = new ArrayList<SheetDataDTO>();
		SheetDataDTO sheetDataDto = new SheetDataDTO();
		sheetDataDto.setSheetName("sheetTest");
		sheetDataDto.setGeoLevel("TEST_CODE");
		sheetDataDto.setListHeaderData(listHeaderData);
		sheetDataDto.setListRowData(listRowData);
		listSheetData.add(sheetDataDto);
		
		ResponseDTO responseDto = new ResponseDTO();
		responseDto.setSubmitAction("TEST_AND_TEST");
		responseDto.setDataSourceName("Test Survey");
		responseDto.setYear(2019);
		responseDto.setListIndex(listIndex);
		responseDto.setStatisticType("PREVALENCE");
		responseDto.setPercentage(true);
		responseDto.setFileName("prev_child_diab_2019b.xls");
		responseDto.setListSheetData(listSheetData);
		responseDto.setS3KeyName("test/test/prev_child_diab_2011b.xls");
		
		//----------------------Get result for mock----------------------//
		DataSourceName dataSourceName = new DataSourceName();
		dataSourceName.setName(responseDto.getDataSourceName());
		when(dataSourceNameRepository.findByName(responseDto.getDataSourceName())).thenReturn(dataSourceName);
		when(dataSourceNameRepository.save(dataSourceName)).thenReturn(dataSourceName);
		
		verify(dataSourceNameRepository, times(1)).findByName(responseDto.getDataSourceName());
		verify(dataSourceNameRepository, times(1)).save(dataSourceName);
		
		DataSourceFile dataSourceFile = new DataSourceFile();
		dataSourceFile.setDataSourceName(dataSourceName);
		dataSourceFile.setFileName(responseDto.getFileName());
		dataSourceFile.setFileName(responseDto.getFileName());
		dataSourceFile.setYear(responseDto.getYear());
		dataSourceFile.setPercentage(responseDto.isPercentage());
		dataSourceFile.setSubmitAction(responseDto.getSubmitAction());
		dataSourceFile.setStatisticType(responseDto.getStatisticType());
		dataSourceFile.setS3KeyName(responseDto.getS3KeyName());
		when(dataSourceFileRepository.save(dataSourceFile)).thenReturn(dataSourceFile);

		for (IndexDTO indexDTO : responseDto.getListIndex()) {
			Index index = new Index();
			index.setDisplayName(indexDTO.getDisplayName());
			index.setIndexName(indexDTO.getIndexName());
			index.setCreatedAt(new Date());
			index.setUpdatedAt(new Date());
			when(indexRepository.save(index)).thenReturn(index);
			
			DataSourceIndex dataSourceIndex = new DataSourceIndex();
			dataSourceIndex.setDataSourceName(dataSourceName);
			dataSourceIndex.setIndex(index);
			when(dataSourceIndexRepository.save(dataSourceIndex)).thenReturn(dataSourceIndex);
		}
		
		for (SheetDataDTO sheetDataDTO : responseDto.getListSheetData()) {
			GeoLevelLookup geoLevelLookup = new GeoLevelLookup();
			geoLevelLookup.setGeoName(sheetDataDTO.getGeoLevel());
			when(geoLevelLookupRepository.save(geoLevelLookup)).thenReturn(geoLevelLookup);
			
			DataSourceGeoLevel dataSourceGeoLevel = new DataSourceGeoLevel();
			dataSourceGeoLevel.setDataSourceFile(dataSourceFile);
			dataSourceGeoLevel.setGeoLevelLookup(geoLevelLookup);
			when(dataSourceGeoLevelRepository.save(dataSourceGeoLevel)).thenReturn(dataSourceGeoLevel);
			
			AggregatedData aggregatedData = null;
			for (int i = 2; i < sheetDataDTO.getListHeaderData().size(); i++) {
				if (sheetDataDto.getListHeaderData().get(i).getCategory().equals("OVERALL")) {
					for (List<String> row : sheetDataDto.getListRowData()) {
						aggregatedData = new AggregatedData();
						aggregatedData.setGeoLevelState(row.get(0));
						aggregatedData.setGeoLevelName(row.get(1));
						aggregatedData.setDataSourceGeoLevel(dataSourceGeoLevel); // Check(?)
						aggregatedData
								.setOverall(Double.parseDouble(row.get(i)));

						when(aggregatedData = aggregatedDataRepository.save(aggregatedData)).thenReturn(aggregatedData);
					}								
				}
			}
			for (int i = 0; i < sheetDataDTO.getListHeaderData().size(); i++) {
				DataSourceColumnDefinition dataSourceColumnDefinition = new DataSourceColumnDefinition();
				dataSourceColumnDefinition
						.setCategory(sheetDataDTO.getListHeaderData().get(i).getCategory());
				dataSourceColumnDefinition
						.setName(sheetDataDTO.getListHeaderData().get(i).getNameInExcelFile());
				dataSourceColumnDefinition
						.setUiName(sheetDataDTO.getListHeaderData().get(i).getNameForUI());
				dataSourceColumnDefinition.setDataSourceName(dataSourceName);

				when(dataSourceColumnDefinitionRepository
						.save(dataSourceColumnDefinition)).thenReturn(dataSourceColumnDefinition);
				
				List<String> stringList = Arrays.asList("OVERALL", "BE_EXCLUDED", "GEO");
				if (!stringList
						.contains(sheetDataDto.getListHeaderData().get(i).getCategory())) {
					AggregatedDataCategory aggregatedDataCategory = new AggregatedDataCategory();
					aggregatedDataCategory
							.setDataSourceColumnDefinition(dataSourceColumnDefinition);
					aggregatedDataCategory.setAggregatedData(aggregatedData);
					for (List<String> row : sheetDataDTO.getListRowData()) {
						aggregatedDataCategory.setDataValue(
								Double.parseDouble(row.get(i)));
						
						when(aggregatedDataCategoryRepository.save(aggregatedDataCategory)).thenReturn(aggregatedDataCategory);
					}										
				}
			}		
		}
		verify(dataSourceNameRepository, times(1)).save(dataSourceName);
		verify(dataSourceFileRepository, times(1)).save(dataSourceFile);
		verify(indexRepository, times(1)).save(any());
		//verify(dataSourceIndexRepository, times(1)).save(dataSourceIndex);
		//geoLevelLookupRepository;
		//dataSourceGeoLevelRepository;
		//dataSourceColumnDefinitionRepository;
		//aggregatedDataRepository;
		//aggregatedDataCategoryRepository;


		String message = repsonseService.getData(responseDto);
		assertEquals("!Save", message);
	}
}
