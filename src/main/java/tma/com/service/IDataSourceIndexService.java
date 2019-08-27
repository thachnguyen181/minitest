package tma.com.service;

import tma.com.model.DataSourceIndex;
import tma.com.model.DataSourceName;
import tma.com.model.Index;

public interface IDataSourceIndexService {

	public DataSourceIndex save(Index index, DataSourceName dataSourceName);
}
