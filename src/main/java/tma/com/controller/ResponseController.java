package tma.com.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tma.com.dto.ResponseDTO;
import tma.com.service.IResponseService;

@RestController
public class ResponseController {

	@Autowired
	private IResponseService responseService;
	
	@PostMapping(value = "/response")
	public ResponseEntity<String> insert(@RequestBody ResponseDTO data) {
		String message = responseService.getData(data);
		if (message == "Save!") {
			return new ResponseEntity<String>(message, HttpStatus.OK);
		} else {
			return new ResponseEntity<String>(message, HttpStatus.BAD_REQUEST);
		}
	}
}
