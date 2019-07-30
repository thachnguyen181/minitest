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
@Table(name = "data_source_file")
public class DataSourceFile implements Serializable{
	
	private static final long serialVersionUID = -5827330182443103064L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "data_source_name_id")
	private DataSourceName dataSourceName;
	
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
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "creater_id")
	private User user;
	
	@OneToMany(mappedBy = "dataSourceFile")
	private Set<DataSourceGeoLevel> dataSourceGeoLevels;
	
	public DataSourceFile() {}

	public DataSourceFile(int id, DataSourceName dataSourceName, String fileName, String dataTypeName, int year,
			Boolean percentage, String status, User user, Set<DataSourceGeoLevel> dataSourceGeoLevels) {
		super();
		this.id = id;
		this.dataSourceName = dataSourceName;
		this.fileName = fileName;
		this.dataTypeName = dataTypeName;
		this.year = year;
		this.percentage = percentage;
		this.status = status;
		this.user = user;
		this.dataSourceGeoLevels = dataSourceGeoLevels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DataSourceName getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(DataSourceName dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getDataTypeName() {
		return dataTypeName;
	}

	public void setDataTypeName(String dataTypeName) {
		this.dataTypeName = dataTypeName;
	}

	public int getYear() {
		return year;
	}

	public void setYear(int year) {
		this.year = year;
	}

	public Boolean getPercentage() {
		return percentage;
	}

	public void setPercentage(Boolean percentage) {
		this.percentage = percentage;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Set<DataSourceGeoLevel> getDataSourceGeoLevels() {
		return dataSourceGeoLevels;
	}

	public void setDataSourceGeoLevels(Set<DataSourceGeoLevel> dataSourceGeoLevels) {
		this.dataSourceGeoLevels = dataSourceGeoLevels;
	}
}
