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
@Table(name = "data_source_geo_level")
public class DataSourceGeoLevel implements Serializable{

	private static final long serialVersionUID = 3952785305264335642L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "data_source_file_id")
	private int datSourceFileId;
	
	@Column(name = "geo_level_lookup_id")
	private int geoLevelLookupId;
	
	@OneToMany(mappedBy = "dataSourceGeoLevel")
	private Set<AggregatedData> aggregatedData;
	
	public DataSourceGeoLevel() {}

	public DataSourceGeoLevel(int id, int datSourceFileId, int geoLevelLookupId) {
		super();
		this.id = id;
		this.datSourceFileId = datSourceFileId;
		this.geoLevelLookupId = geoLevelLookupId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDatSourceFileId() {
		return datSourceFileId;
	}

	public void setDatSourceFileId(int datSourceFileId) {
		this.datSourceFileId = datSourceFileId;
	}

	public int getGeoLevelLookupId() {
		return geoLevelLookupId;
	}

	public void setGeoLevelLookupId(int geoLevelLookupId) {
		this.geoLevelLookupId = geoLevelLookupId;
	}

	public Set<AggregatedData> getAggregatedData() {
		return aggregatedData;
	}

	public void setAggregatedData(Set<AggregatedData> aggregatedData) {
		this.aggregatedData = aggregatedData;
	}
}
