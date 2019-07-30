package tma.com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "data_source_name")
public class DataSourceName implements Serializable{

	private static final long serialVersionUID = -4288662597352609158L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@OneToMany(mappedBy = "dataSourceName")
	private Set<DataSourceIndex> dataSourceIndexs;
	
	@OneToMany(mappedBy = "dataSourceName")
	private Set<DataSourceFile> dataSourceFiles;
	
	@OneToMany(mappedBy = "dataSourceName")
	private Set<DataSourceColumnDefinition> dataSourceColumnDefinitions;
	
	public DataSourceName() {}

	public DataSourceName(int id, String name, Set<DataSourceIndex> dataSourceIndexs,
			Set<DataSourceFile> dataSourceFiles, Set<DataSourceColumnDefinition> dataSourceColumnDefinitions) {
		super();
		this.id = id;
		this.name = name;
		this.dataSourceIndexs = dataSourceIndexs;
		this.dataSourceFiles = dataSourceFiles;
		this.dataSourceColumnDefinitions = dataSourceColumnDefinitions;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<DataSourceIndex> getDataSourceIndexs() {
		return dataSourceIndexs;
	}

	public void setDataSourceIndexs(Set<DataSourceIndex> dataSourceIndexs) {
		this.dataSourceIndexs = dataSourceIndexs;
	}

	public Set<DataSourceFile> getDataSourceFiles() {
		return dataSourceFiles;
	}

	public void setDataSourceFiles(Set<DataSourceFile> dataSourceFiles) {
		this.dataSourceFiles = dataSourceFiles;
	}

	public Set<DataSourceColumnDefinition> getDataSourceColumnDefinitions() {
		return dataSourceColumnDefinitions;
	}

	public void setDataSourceColumnDefinitions(Set<DataSourceColumnDefinition> dataSourceColumnDefinitions) {
		this.dataSourceColumnDefinitions = dataSourceColumnDefinitions;
	}
}
