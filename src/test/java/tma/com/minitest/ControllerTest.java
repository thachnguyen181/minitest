package tma.com.minitest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.verifyNoMoreInteractions;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import org.joda.time.DateTime;
import org.joda.time.format.DateTimeFormat;
import org.joda.time.format.DateTimeFormatter;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import tma.com.controller.ResponseController;
import tma.com.dto.HeaderDataDTO;
import tma.com.dto.IndexDTO;
import tma.com.dto.ResponseDTO;
import tma.com.dto.SheetDataDTO;
import tma.com.service.ResponseService;

@RunWith(MockitoJUnitRunner.class)
public class ControllerTest {

	@InjectMocks
	private ResponseController responseController;
	
	@Mock
	private ResponseService responseService;
	
	private MockMvc mockMvc;
	
	private String getAllUrl = "/response";
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		mockMvc = MockMvcBuilders.standaloneSetup(responseController)
				.addPlaceholderValue("/response", getAllUrl)
                .build();		
	}
	
	@Test
	public void testInsertDataSuccess() throws Exception {
		
		ResponseDTO responseDto = new ResponseDTO();
		
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
//				indexDto.setUpdatedAt(new Timestamp(System.currentTimeMillis()));
				indexDto.setUpdatedAt(new DateTime().getMillis());
				listIndex.add(indexDto);
				
				List<SheetDataDTO> listSheetData = new ArrayList<SheetDataDTO>();
				SheetDataDTO sheetDataDto = new SheetDataDTO();
				sheetDataDto.setSheetName("sheetTest");
				sheetDataDto.setGeoLevel("TEST_CODE");
				sheetDataDto.setListHeaderData(listHeaderData);
				sheetDataDto.setListRowData(listRowData);
				listSheetData.add(sheetDataDto);
				
				responseDto.setSubmitAction("TEST_AND_TEST");
				responseDto.setDataSourceName("Test Survey");
				responseDto.setYear(2019);
				responseDto.setListIndex(listIndex);
				responseDto.setStatisticType("PREVALENCE");
				responseDto.setPercentage(true);
				responseDto.setFileName("prev_child_diab_2019b.xls");
				responseDto.setListSheetData(listSheetData);
				responseDto.setS3KeyName("test/test/prev_child_diab_2011b.xls");
				
		when(responseService.getData(responseDto)).thenReturn("!Save");
		String data = toJsonString(responseDto);
		mockMvc.perform(
				post(getAllUrl)
					.contentType(MediaType.APPLICATION_JSON)
					.content(data))
				.andExpect(status().isOk());
				//.andExpect(header().string("location", containsString("http://localhost/response")));
		
		verify(responseService, times(1)).getData(responseDto);
        verifyNoMoreInteractions(responseService);
	}
	
	public static String toJsonString(Object obj) {
		GsonBuilder gsonBuilder = new GsonBuilder();
		gsonBuilder.serializeNulls();
		Gson gson = gsonBuilder.create();
		return gson.toJson(obj);
	}
	
}
