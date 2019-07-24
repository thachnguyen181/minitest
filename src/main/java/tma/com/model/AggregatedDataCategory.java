package tma.com.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aggregated_data_category")
public class AggregatedDataCategory implements Serializable{

	private static final long serialVersionUID = 7996464031243211155L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "aggregated_data_id")
	private UUID aggregatedDataId;
	
	@Column(name = "data_definition_column_id")
	private int dataDefinitionColumnId;
	
	@Column(name = "data_value")
	private double dataValue;
}
