package tma.com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
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
	private String geoName;
	
	@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "geoLevelLookup")
    private Set<DataSourceGeoLevel> dataSourceGeoLevels; 
	
	public GeoLevelLookup() {}

	public GeoLevelLookup(int id, String geoName, Set<DataSourceGeoLevel> dataSourceGeoLevels) {
		super();
		this.id = id;
		this.geoName = geoName;
		this.dataSourceGeoLevels = dataSourceGeoLevels;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getGeoName() {
		return geoName;
	}

	public void setGeoName(String geoName) {
		this.geoName = geoName;
	}

	public Set<DataSourceGeoLevel> getDataSourceGeoLevels() {
		return dataSourceGeoLevels;
	}

	public void setDataSourceGeoLevels(Set<DataSourceGeoLevel> dataSourceGeoLevels) {
		this.dataSourceGeoLevels = dataSourceGeoLevels;
	}
}
