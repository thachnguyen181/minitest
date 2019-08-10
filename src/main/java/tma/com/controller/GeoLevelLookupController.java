package tma.com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import tma.com.dto.GeoLevelLookupDTO;
import tma.com.model.GeoLevelLookup;
import tma.com.service.IGeoLevelLookupService;
import tma.com.util.DTO;

@RestController
public class GeoLevelLookupController {

	@Autowired
	private IGeoLevelLookupService geoLevelLookupService;
	
	//---------------------------- GET ALL GEO_LEVEL_LOOKUP ---------------------------//
	/*@GetMapping(value = "/geolevellookups")
	public ResponseEntity<List<GeoLevelLookupDTO>> getAll() {
		
		return new ResponseEntity<List<GeoLevelLookupDTO>> (geoLevelLookupService.getAll(), HttpStatus.OK);
	}*/
	
	//-------------------------- CREATE NEW GEO_LEVEL_LOOKUP --------------------------//
	@PostMapping(value = "/geolevellookups")
	public ResponseEntity<GeoLevelLookup> create(GeoLevelLookupDTO geoLevelLookupDto) {
		GeoLevelLookup geoLevelLookupCreated = geoLevelLookupService.insert(geoLevelLookupDto);
		
		if (geoLevelLookupCreated != null) {
			return new ResponseEntity<GeoLevelLookup>(geoLevelLookupCreated, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<GeoLevelLookup>(geoLevelLookupCreated, HttpStatus.BAD_REQUEST);
		}
	}
}
