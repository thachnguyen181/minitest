package tma.com.dto;

public class GeoLevelLookupDTO {
	private int id;
	private String geoname;
	
	public GeoLevelLookupDTO() {}
	
	public GeoLevelLookupDTO(int id, String geoname) {
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
