package tma.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
	
	@Column(name = "data_source_name_id")
	private int dataSourceNameId;
}
