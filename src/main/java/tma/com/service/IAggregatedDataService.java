package tma.com.service;

import java.util.List;

import tma.com.dto.HeaderDataDTO;
import tma.com.model.AggregatedData;
import tma.com.model.DataSourceGeoLevel;
import tma.com.model.DataSourceName;

public interface IAggregatedDataService {

	public AggregatedData save(DataSourceGeoLevel dataSourceGeoLevel,
			DataSourceName dataSourceName,
			List<HeaderDataDTO> listHeaderData, 
			List<List<String>> listRowData);
}
