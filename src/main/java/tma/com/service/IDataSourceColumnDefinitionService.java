package tma.com.service;

import tma.com.dto.DataSourceColumnDefinitionDTO;
import tma.com.model.DataSourceColumnDefinition;

public interface IDataSourceColumnDefinitionService {

	public DataSourceColumnDefinition insert(DataSourceColumnDefinitionDTO dataSourceColumnDefinitionDto);
}