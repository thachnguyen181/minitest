package tma.com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;

@Entity
@Table(name = "geo_level_lookup", uniqueConstraints = {@UniqueConstraint(name = "geo_level_lookup_pkey", columnNames = {"id"})})
public class GeoLevelLookup implements Serializable{

	private static final long serialVersionUID = -5842832319776588767L;
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private int id;
	
	@Column(name = "geo_name")
	private String geoname;
	
	@ManyToMany
	@JoinTable(name = "data_source_geo_level", joinColumns = {@JoinColumn(name = "geo_level_lookup_id", referencedColumnName="id")}, inverseJoinColumns = {@JoinColumn(name = "data_source_file_id", referencedColumnName="id")})
    private Set<DataSourceFile> dataSourceFiles; 
	
	public GeoLevelLookup() {}

	public GeoLevelLookup(int id, String geoname) {
		super();
		this.id = id;
		this.geoname = geoname;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGeoname() {
		return geoname;
	}

	public void setGeoname(String geoname) {
		this.geoname = geoname;
	}

	public Set<DataSourceFile> getDataSourceFiles() {
		return dataSourceFiles;
	}

	public void setDataSourceFiles(Set<DataSourceFile> dataSourceFiles) {
		this.dataSourceFiles = dataSourceFiles;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		GeoLevelLookup other = (GeoLevelLookup) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
