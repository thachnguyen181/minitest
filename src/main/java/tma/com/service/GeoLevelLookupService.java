package tma.com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.GeoLevelLookupDTO;
import tma.com.dto.SheetDataDTO;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.model.DataSourceFile;
import tma.com.model.DataSourceName;
import tma.com.model.GeoLevelLookup;
import tma.com.repository.IGeoLevelLookupRepository;

@Service
public class GeoLevelLookupService implements IGeoLevelLookupService {

	@Autowired
	private IGeoLevelLookupRepository geoLevelLookupRepository;
	
	@Autowired
	private IDataSourceGeoLevelService dataSourceGeoLevelService;
	
	@Override
	public GeoLevelLookup save(SheetDataDTO sheetDataDto, DataSourceFile dataSourceFile, DataSourceName dataSourceName) {
		// TODO Auto-generated method stub

		GeoLevelLookup result = geoLevelLookupRepository.findByName(sheetDataDto.getGeoLevel());
		if (result == null) {
			result.setGeoName(sheetDataDto.getGeoLevel());
			result = geoLevelLookupRepository.save(result);
		}
		
		dataSourceGeoLevelService.save(result, dataSourceFile, dataSourceName, sheetDataDto.getListHeaderData(), sheetDataDto.getListRowData());
		
		return result;
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
