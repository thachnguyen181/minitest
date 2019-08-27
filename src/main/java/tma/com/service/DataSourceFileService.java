package tma.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.ResponseDTO;
import tma.com.dto.SheetDataDTO;
import tma.com.model.DataSourceFile;
import tma.com.model.DataSourceName;
import tma.com.repository.IDataSourceFileRepository;

@Service
public class DataSourceFileService implements IDataSourceFileService {

	@Autowired
	private IDataSourceFileRepository dataSourceFileRepository;

	@Autowired
	private IDataSourceNameService dataSourceNameService;

	@Autowired
	private IIndexService indexService;

	@Autowired
	private IGeoLevelLookupService geoLevelLookupService;
	
	@Override
	public DataSourceFile save(ResponseDTO responseDto) {
		// TODO Auto-generated method stub
		
		DataSourceName dataSourceName = dataSourceNameService.save(responseDto.getDataSourceName());
		
		DataSourceFile dataSourceFile = new DataSourceFile();
		dataSourceFile.setDataSourceName(dataSourceName);
		dataSourceFile.setFileName(responseDto.getFileName());
		dataSourceFile.setYear(responseDto.getYear());
		dataSourceFile.setPercentage(responseDto.isPercentage());
		dataSourceFile.setSubmitAction(responseDto.getSubmitAction());
		dataSourceFile.setStatisticType(responseDto.getStatisticType());
		dataSourceFile.setS3KeyName(responseDto.getS3KeyName());

		dataSourceFile = dataSourceFileRepository.save(dataSourceFile);
		
		indexService.save(responseDto.getListIndex(), dataSourceName);
		
		for (SheetDataDTO sheetDataDto : responseDto.getListSheetData()) {
			geoLevelLookupService.save(sheetDataDto, dataSourceFile, dataSourceName);
		}
		
		return dataSourceFile;
	}
}
