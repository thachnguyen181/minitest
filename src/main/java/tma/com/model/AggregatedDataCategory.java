package tma.com.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name = "aggregated_data_category")
public class AggregatedDataCategory implements Serializable{

	private static final long serialVersionUID = 7996464031243211155L;
	
	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
	@Column(name = "id", nullable = false, updatable = false)
	private UUID id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "aggregated_data_id")
	private AggregatedData aggregatedData;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "data_definition_column_id")
	private DataSourceColumnDefinition dataSourceColumnDefinition;
	
	@Column(name = "data_value")
	private double dataValue;
	
	public AggregatedDataCategory() {}

	public AggregatedDataCategory(UUID id, AggregatedData aggregatedData,
			DataSourceColumnDefinition dataSourceColumnDefinition, double dataValue) {
		super();
		this.id = id;
		this.aggregatedData = aggregatedData;
		this.dataSourceColumnDefinition = dataSourceColumnDefinition;
		this.dataValue = dataValue;
	}

	public UUID getId() {
		return id;
	}

	public void setId(UUID id) {
		this.id = id;
	}

	public AggregatedData getAggregatedData() {
		return aggregatedData;
	}

	public void setAggregatedData(AggregatedData aggregatedData) {
		this.aggregatedData = aggregatedData;
	}

	public DataSourceColumnDefinition getDataSourceColumnDefinition() {
		return dataSourceColumnDefinition;
	}

	public void setDataSourceColumnDefinition(DataSourceColumnDefinition dataSourceColumnDefinition) {
		this.dataSourceColumnDefinition = dataSourceColumnDefinition;
	}

	public double getDataValue() {
		return dataValue;
	}

	public void setDataValue(double dataValue) {
		this.dataValue = dataValue;
	}
}
