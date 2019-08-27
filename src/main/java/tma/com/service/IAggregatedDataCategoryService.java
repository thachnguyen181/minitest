package tma.com.service;

import java.util.List;

import tma.com.model.AggregatedData;
import tma.com.model.AggregatedDataCategory;
import tma.com.model.DataSourceColumnDefinition;

public interface IAggregatedDataCategoryService {
	public void save(DataSourceColumnDefinition dataSourceColumnDefinition,
			AggregatedData aggregatedData, 
			List<List<String>> listRowData,
			int index);
}
