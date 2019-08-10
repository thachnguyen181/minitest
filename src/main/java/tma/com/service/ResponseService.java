package tma.com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.ResponseDTO;
import tma.com.repository.IResponseRepository;

@Service
public class ResponseService implements IResponseService{
	
	@Autowired
	private IResponseRepository responseRepository;

	@Override
	public ResponseDTO getData(ResponseDTO responseDto) {
		// TODO Auto-generated method stub
			
		return responseRepository.save(responseDto) ;
	}
	
	/*public Boolean insert(ResponseDTO responseDto) {
		// TODO Auto-generated method stub
		
		if (responseDto != null) {
			if(responseDto.getListIndex() != null) {
				for (int i = 0; i < responseDto.getListIndex().size(); i ++) {
					Index index = responseDto.getListIndex()[i];
					indexRepo.save(index);
				}
			}
		}
		//aggregatedData.set
		//aggregatedData.set
		return null;
	}*/
	
	
}
