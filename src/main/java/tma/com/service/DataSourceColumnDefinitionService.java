package tma.com.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.dto.HeaderDataDTO;
import tma.com.model.AggregatedData;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.model.DataSourceName;
import tma.com.repository.IDataSourceColumnDefinitionRepository;

@Service
public class DataSourceColumnDefinitionService implements IDataSourceColumnDefinitionService{

	@Autowired
	private IDataSourceColumnDefinitionRepository dataSourceColumnDefinitionRepository;
	
	@Autowired
	private IAggregatedDataCategoryService aggregatedDataCategoryService;
	
	@Override
	public void save(DataSourceName dataSourceName, 
			AggregatedData aggregatedData,
			List<HeaderDataDTO> listHeaderData,
			List<List<String>> listRowData) {
		// TODO Auto-generated method stub
		
		for (int i = 0; i < listHeaderData.size(); i++) {
			DataSourceColumnDefinition dataSourceColumnDefinition = new DataSourceColumnDefinition();
			dataSourceColumnDefinition
					.setCategory(listHeaderData.get(i).getCategory());
			dataSourceColumnDefinition
					.setName(listHeaderData.get(i).getNameInExcelFile());
			dataSourceColumnDefinition
					.setUiName(listHeaderData.get(i).getNameForUI());
			dataSourceColumnDefinition.setDataSourceName(dataSourceName);

			dataSourceColumnDefinition = dataSourceColumnDefinitionRepository
					.save(dataSourceColumnDefinition);
			
			aggregatedDataCategoryService.save(dataSourceColumnDefinition, aggregatedData, listRowData, i);
			
		}
	}

}
