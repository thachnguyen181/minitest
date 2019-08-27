package tma.com.service;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tma.com.model.AggregatedData;
import tma.com.model.AggregatedDataCategory;
import tma.com.model.DataSourceColumnDefinition;
import tma.com.repository.IAggregatedDataCategoryRepository;

@Service
public class AggregatedDataCategoryService implements IAggregatedDataCategoryService{

	@Autowired
	private IAggregatedDataCategoryRepository aggregatedDataCategoryRepository;
	
	@Override
	public void save(DataSourceColumnDefinition dataSourceColumnDefinition,
			AggregatedData aggregatedData, 
			List<List<String>> listRowData,
			int index) {
		// TODO Auto-generated method stub
		
		List<String> stringList = Arrays.asList("OVERALL", "BE_EXCLUDED", "GEO");
		
		if (!stringList
				.contains(dataSourceColumnDefinition.getCategory())) {
			AggregatedDataCategory aggregatedDataCategory = new AggregatedDataCategory();
			aggregatedDataCategory
					.setDataSourceColumnDefinition(dataSourceColumnDefinition);
			aggregatedDataCategory.setAggregatedData(aggregatedData);
			for (List<String> rowData : listRowData) {
				aggregatedDataCategory.setDataValue(
						Double.parseDouble(rowData.get(index)));
				
				aggregatedDataCategoryRepository.save(aggregatedDataCategory);
			}										
		}
	}

}
