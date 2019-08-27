package tma.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.model.DataSourceIndex;
import tma.com.model.DataSourceName;
import tma.com.model.Index;
import tma.com.repository.IDataSourceIndexRepository;

@Service
public class DataSourceIndexService implements IDataSourceIndexService{

	@Autowired
	private IDataSourceIndexRepository dataSourceIndexRepository;
	
	@Override
	public DataSourceIndex save(Index index, DataSourceName dataSourceName) {
		// TODO Auto-generated method stub
		
		DataSourceIndex dataSourceIndex = new DataSourceIndex();
		dataSourceIndex.setDataSourceName(dataSourceName);
		dataSourceIndex.setIndex(index);
		
		return dataSourceIndexRepository.save(dataSourceIndex);
	}

}
