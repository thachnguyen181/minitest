package tma.com.service;

import java.util.List;

import tma.com.dto.HeaderDataDTO;
import tma.com.model.AggregatedData;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.model.DataSourceName;

public interface IDataSourceColumnDefinitionService {

	public void save(DataSourceName dataSourceName, 
			AggregatedData aggregatedData,
			List<HeaderDataDTO> listHeaderData,
			List<List<String>> listRowData);
}
