package tma.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.GeoLevelLookupDTO;
import tma.com.model.GeoLevelLookup;
import tma.com.repository.IGeoLevelLookupRepository;

@Service
public class GeoLevelLookupService implements IGeoLevelLookupService {

	@Autowired
	private IGeoLevelLookupRepository geoLevelLookupRepository;

	/*@Override
	public List<GeoLevelLookup> getAll() {
		// TODO Auto-generated method stub
		
		return geoLevelLookupRepository.findAll();
	}

	@Override
	public GeoLevelLookup insert(GeoLevelLookup geoLevelLookup) {
		// TODO Auto-generated method stub
		
		GeoLevelLookup geoLevelLookupEdited = geoLevelLookupRepository.save(geoLevelLookup);
		return geoLevelLookupEdited;
	}*/
	
	
	@Override
	public GeoLevelLookup insert(GeoLevelLookupDTO geoLevelLookupDto) {
		// TODO Auto-generated method stub
		
		GeoLevelLookup geoLevelLookup = new GeoLevelLookup();
		geoLevelLookup.setGeoName(geoLevelLookupDto.getGeoname());
		//geoLevelLookup.setDataSourceGeoLevels(dataSourceGeoLevels);
		return geoLevelLookupRepository.save(geoLevelLookup);
	}

	@Override
	public List<GeoLevelLookupDTO> getAll() {
		// TODO Auto-generated method stub
		ArrayList<GeoLevelLookupDTO> geoLevelLookupDtos = new ArrayList<GeoLevelLookupDTO>();
		
		for (GeoLevelLookup i : geoLevelLookupRepository.findAll()) {
			GeoLevelLookupDTO geoLevelLookupDto = new GeoLevelLookupDTO();
			geoLevelLookupDto.setId(i.getId());
			geoLevelLookupDto.setGeoname(i.getGeoName());
			geoLevelLookupDtos.add(geoLevelLookupDto);
		}		
		
		return geoLevelLookupDtos;
	}
	
	

}
