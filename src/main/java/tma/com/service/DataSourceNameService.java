package tma.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.model.DataSourceName;
import tma.com.repository.IDataSourceNameRepository;

@Service
public class DataSourceNameService implements IDataSourceNameService {

	@Autowired
	private IDataSourceNameRepository dataSourceNameRepository;
	
	@Override
	public DataSourceName save(String dataSourceName) {
		// TODO Auto-generated method stub
		
		DataSourceName result = dataSourceNameRepository.findByName(dataSourceName);
		if (result == null) {
			result.setName(dataSourceName);
			result = dataSourceNameRepository.save(result);
		}
		
		return result;
	}	
}
