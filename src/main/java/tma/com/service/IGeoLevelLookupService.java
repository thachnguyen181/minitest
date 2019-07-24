package tma.com.service;

import java.util.List;

import tma.com.dto.GeoLevelLookupDTO;
import tma.com.model.GeoLevelLookup;

public interface IGeoLevelLookupService {

	public List<GeoLevelLookupDTO> getAll();
	public GeoLevelLookup insert(GeoLevelLookupDTO geoLevelLookupDto);
}
