package tma.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.DataSourceColumnDefinitionDTO;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.repository.IDataSourceColumnDefinitionRepository;

@Service
public class DataSourceColumnDefinitionService implements IDataSourceColumnDefinitionService{

	@Autowired
	private IDataSourceColumnDefinitionRepository dataSourceColumnDefinitionReopository;
	@Override
	public DataSourceColumnDefinition insert(DataSourceColumnDefinitionDTO dataSourceColumnDefinitionDto) {
		// TODO Auto-generated method stub
		
		DataSourceColumnDefinition dataSourceColumnDefinition = new DataSourceColumnDefinition();
		
		return null;//dataSourceColumnDefinitionReopository.save(dataSourceColumnDefinition())
	}

}
