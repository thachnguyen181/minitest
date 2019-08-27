package tma.com.service;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.IndexDTO;
import tma.com.model.DataSourceName;
import tma.com.model.Index;
import tma.com.repository.IIndexRepository;

@Service
public class IndexService implements IIndexService{

	@Autowired
	private IIndexRepository indexRepository;
	
	@Autowired
	private IDataSourceIndexService dataSourceIndexService;
	
	@Override
	public Index save(List<IndexDTO> listIndexDto, DataSourceName dataSourceName) {
		// TODO Auto-generated method stub
		
		for (IndexDTO indexDto : listIndexDto) {
			Index index = new Index();
			index.setIndexName(indexDto.getIndexName());
			index.setDisplayName(indexDto.getDisplayName());
			index.setCreatedAt(new Date());
			index.setUpdatedAt(new Date());
			
			// data_source_name
			// exception
			dataSourceIndexService.save(index, dataSourceName);
			
			return indexRepository.save(index);
		}
		// exception
		return null;
	}

}
