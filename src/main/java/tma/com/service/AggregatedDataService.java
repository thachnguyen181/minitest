package tma.com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.HeaderDataDTO;
import tma.com.model.AggregatedData;
import tma.com.model.DataSourceGeoLevel;
import tma.com.model.DataSourceName;
import tma.com.repository.IAggregatedDataRepository;

@Service
public class AggregatedDataService implements IAggregatedDataService{

	@Autowired
	private IAggregatedDataRepository aggregatedDataRepository;
	
	@Autowired
	private IDataSourceColumnDefinitionService dataSourceColumnDefinitionService;
	
	@Override
	public AggregatedData save(DataSourceGeoLevel dataSourceGeoLevel,
			DataSourceName dataSourceName,
			List<HeaderDataDTO> listHeaderData, 
			List<List<String>> listRowData) {
		// TODO Auto-generated method stub\
		
		AggregatedData aggregatedData = null;
		for (int i = 2; i < listHeaderData.size(); i++) {
			if (listHeaderData.get(i).getCategory().equals("OVERALL")) {
				// CheckListRowData(?)
				for (List<String> rowData : listRowData) {
					aggregatedData = new AggregatedData();
					aggregatedData.setGeoLevelState(rowData.get(0));
					aggregatedData.setGeoLevelName(rowData.get(1));
					aggregatedData.setDataSourceGeoLevel(dataSourceGeoLevel); // Check(?)
					aggregatedData
							.setOverall(Double.parseDouble(rowData.get(i)));

					aggregatedData = aggregatedDataRepository.save(aggregatedData);
				}								
			}
		}
		
		dataSourceColumnDefinitionService.save(dataSourceName, aggregatedData, listHeaderData, listRowData);
		
		return aggregatedData;
	}

}
