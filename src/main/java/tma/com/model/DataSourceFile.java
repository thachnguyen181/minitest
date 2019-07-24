package tma.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_source_file")
public class DataSourceFile implements Serializable{
	
	private static final long serialVersionUID = -5827330182443103064L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "data_source_name_id")
	private int dataSourceNameId;
	
	@Column(name = "file_name")
	private String fileName;
	
	@Column(name = "data_type_name")
	private String dataTypeName;
	
	@Column(name =  "year")
	private int year;
	
	@Column(name = "percentage")
	private Boolean percentage;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "creater_id")
	private String createrId;
	
	@()
}
