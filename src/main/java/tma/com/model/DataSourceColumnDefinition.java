package tma.com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "data_source_column_definition")
public class DataSourceColumnDefinition implements Serializable{

	private static final long serialVersionUID = 7481901508969694449L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "category")
	private String category;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "ui_name")
	private String uiName;
	
	@Column(name = "column_number")
	private int columnNumber;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "data_source_name_id")
	private DataSourceName dataSourceName;
	
	@OneToMany(mappedBy = "dataSourceColumnDefinition")
	private Set<AggregatedDataCategory> aggregatedDataCategorys;
	
	public DataSourceColumnDefinition() {}

	public DataSourceColumnDefinition(int id, String category, String name, String uiName, int columnNumber,
			DataSourceName dataSourceName) {
		super();
		this.id = id;
		this.category = category;
		this.name = name;
		this.uiName = uiName;
		this.columnNumber = columnNumber;
		this.dataSourceName = dataSourceName;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getUiName() {
		return uiName;
	}

	public void setUiName(String uiName) {
		this.uiName = uiName;
	}

	public int getColumnNumber() {
		return columnNumber;
	}

	public void setColumnNumber(int columnNumber) {
		this.columnNumber = columnNumber;
	}

	public DataSourceName getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(DataSourceName dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public Set<AggregatedDataCategory> getAggregatedDataCategorys() {
		return aggregatedDataCategorys;
	}

	public void setAggregatedDataCategorys(Set<AggregatedDataCategory> aggregatedDataCategorys) {
		this.aggregatedDataCategorys = aggregatedDataCategorys;
	}
}
