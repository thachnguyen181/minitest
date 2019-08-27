package tma.com.service;

import java.util.List;

import tma.com.dto.IndexDTO;
import tma.com.model.DataSourceName;
import tma.com.model.Index;

public interface IIndexService {

	public Index save(List<IndexDTO> listIndexDto, DataSourceName dataSourceName);
}
