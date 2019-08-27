package tma.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.HeaderDataDTO;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.model.DataSourceFile;
import tma.com.model.DataSourceGeoLevel;
import tma.com.model.DataSourceName;
import tma.com.model.GeoLevelLookup;
import tma.com.repository.IDataSourceGeoLevelRepository;

@Service
public class DataSourceGeoLevelService implements IDataSourceGeoLevelService{

	@Autowired
	private IDataSourceGeoLevelRepository dataSourceGeoLevelRepository;
	
	@Autowired
	private IAggregatedDataService aggregatedData;
	
	@Override
	public DataSourceGeoLevel save(GeoLevelLookup geoLevelLookup, 
			DataSourceFile dataSourceFile, 
			DataSourceName dataSourceName, 
			List<HeaderDataDTO> listHeaderData, 
			List<List<String>> listRowData) {
		// TODO Auto-generated method stub
		
		DataSourceGeoLevel dataSourceGeoLevel = new DataSourceGeoLevel();
		dataSourceGeoLevel.setGeoLevelLookup(geoLevelLookup);
		dataSourceGeoLevel.setDataSourceFile(dataSourceFile);
		dataSourceGeoLevel = dataSourceGeoLevelRepository.save(dataSourceGeoLevel);
		
		aggregatedData.save(dataSourceGeoLevel, dataSourceName, listHeaderData, listRowData);
		
		return dataSourceGeoLevel;
	}

}
