package tma.com.service;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.IndexDTO;
import tma.com.model.Index;
import tma.com.repository.IIndexRepository;

@Service
public class IndexService implements IIndexService{

	@Autowired
	private IIndexRepository indexRepository;
	
	@Override
	public Index insert(IndexDTO indexDto) {
		// TODO Auto-generated method stub

		Index index = new Index();
		index.setIndexName(indexDto.getIndexName());
		index.setDisplayName(indexDto.getDisplayName());
		index.setCreatedAt(new Date());
		index.setUpdatedAt(new Date());
		return indexRepository.save(index);
	}

	@Override
	public Index getById(int id) {
		// TODO Auto-generated method stub
		
		return indexRepository.findById(id).get();
	}

}
