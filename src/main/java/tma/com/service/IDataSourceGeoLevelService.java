package tma.com.service;

import java.util.List;

import tma.com.dto.HeaderDataDTO;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.model.DataSourceFile;
import tma.com.model.DataSourceGeoLevel;
import tma.com.model.DataSourceName;
import tma.com.model.GeoLevelLookup;

public interface IDataSourceGeoLevelService {

	public DataSourceGeoLevel save(GeoLevelLookup geoLevelLookup, 
			DataSourceFile dataSourceFile, 
			DataSourceName dataSourceName, 
			List<HeaderDataDTO> listHeaderData, 
			List<List<String>> listRowData);
}
