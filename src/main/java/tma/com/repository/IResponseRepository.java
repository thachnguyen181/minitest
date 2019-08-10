package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tma.com.dto.ResponseDTO;

public interface IResponseRepository extends JpaRepository<ResponseDTO, Integer>{
	
}
