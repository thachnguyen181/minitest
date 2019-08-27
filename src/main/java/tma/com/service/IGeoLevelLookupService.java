package tma.com.service;

import java.util.List;

import tma.com.dto.GeoLevelLookupDTO;
import tma.com.dto.SheetDataDTO;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.model.DataSourceFile;
import tma.com.model.DataSourceName;
import tma.com.model.GeoLevelLookup;

public interface IGeoLevelLookupService {

	public List<GeoLevelLookupDTO> getAll();
	public GeoLevelLookup save(SheetDataDTO sheetDataDto, DataSourceFile dataSourceFile, DataSourceName dataSourceName);
}
