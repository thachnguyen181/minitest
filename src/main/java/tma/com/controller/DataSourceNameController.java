package tma.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tma.com.dto.DataSourceNameDTO;
import tma.com.dto.ResponseDTO;
import tma.com.model.DataSourceName;
import tma.com.service.IDataSourceNameService;

@RestController
public class DataSourceNameController {
	
	@Autowired
	private IDataSourceNameService dataSourceNameService;
	
	@GetMapping(value = "/datasourcenames")
	public ResponseEntity<DataSourceName> getById(int id) {
		DataSourceName dataSourceName = dataSourceNameService.getById(id);
		if (dataSourceName != null) {
			return new ResponseEntity<DataSourceName>(dataSourceName, HttpStatus.OK);
		} else {
			return new ResponseEntity<DataSourceName>(dataSourceName, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/datasourcenames")
	public ResponseEntity<DataSourceName> insert(@RequestBody DataSourceNameDTO dataSourceNameDto) {
		DataSourceName dataSourceName = dataSourceNameService.insert(dataSourceNameDto);
		if (dataSourceName != null) {
			return new ResponseEntity<DataSourceName>(dataSourceName, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<DataSourceName>(dataSourceName, HttpStatus.BAD_REQUEST);
		}
	}
	
	@PostMapping(value = "/datasourcenames")
	public ResponseEntity<DataSourceName> insertResponse(@RequestBody ResponseDTO responseDto) {
		DataSourceName dataSourceName = dataSourceNameService.insert(responseDto);
		if (dataSourceName != null) {
			return new ResponseEntity<DataSourceName>(dataSourceName, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<DataSourceName>(dataSourceName, HttpStatus.BAD_REQUEST);
		}
	}
}
