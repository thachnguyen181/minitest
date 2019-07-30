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
@Table(name = "data_source_geo_level")
public class DataSourceGeoLevel implements Serializable{

	private static final long serialVersionUID = 3952785305264335642L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "data_source_file_id")
	private DataSourceFile dataSourceFile;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "geo_level_lookup_id")
	private GeoLevelLookup geoLevelLookup;
	
	@OneToMany(mappedBy = "dataSourceGeoLevel")
	private Set<AggregatedData> aggregatedData;
	
	public DataSourceGeoLevel() {}

	public DataSourceGeoLevel(int id, DataSourceFile dataSourceFile, GeoLevelLookup geoLevelLookup,
			Set<AggregatedData> aggregatedData) {
		super();
		this.id = id;
		this.dataSourceFile = dataSourceFile;
		this.geoLevelLookup = geoLevelLookup;
		this.aggregatedData = aggregatedData;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DataSourceFile getDataSourceFile() {
		return dataSourceFile;
	}

	public void setDataSourceFile(DataSourceFile dataSourceFile) {
		this.dataSourceFile = dataSourceFile;
	}

	public GeoLevelLookup getGeoLevelLookup() {
		return geoLevelLookup;
	}

	public void setGeoLevelLookup(GeoLevelLookup geoLevelLookup) {
		this.geoLevelLookup = geoLevelLookup;
	}

	public Set<AggregatedData> getAggregatedData() {
		return aggregatedData;
	}

	public void setAggregatedData(Set<AggregatedData> aggregatedData) {
		this.aggregatedData = aggregatedData;
	}
}
