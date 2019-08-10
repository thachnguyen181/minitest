package tma.com.service;

import tma.com.dto.IndexDTO;
import tma.com.model.Index;

public interface IIndexService {

	public Index insert(IndexDTO indexDto);
	public Index getById(int id);
}
