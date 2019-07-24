package tma.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
