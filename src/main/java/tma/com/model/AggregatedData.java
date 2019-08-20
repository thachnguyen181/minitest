package tma.com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

@Entity
@Table(name = "aggregated_data")
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class AggregatedData implements Serializable{

	private static final long serialVersionUID = 2081792676877376781L;

	@Id
	@GeneratedValue(generator="UUID")
	@GenericGenerator(name="UUID", strategy = "org.hibernate.id.UUIDGenerator")
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", updatable = false, nullable = false)
	private String id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "data_source_geo_level_id")
	private DataSourceGeoLevel dataSourceGeoLevel;
	
	@Column(name = "geo_level_state")
	private String geoLevelState;
	
	@Column(name = "geo_level_name")
	private String geoLevelName;
	
	@Column(name = "geo_id")
	private int geoId;
	
	@Column(name = "overall")
	private double overall;
	
	@OneToMany(mappedBy = "aggregatedData")
	private Set<AggregatedDataCategory> aggregatedDataCategorys;
	
	public AggregatedData() {}

	public AggregatedData(String id, DataSourceGeoLevel dataSourceGeoLevel, String geoLevelState, String geoLevelName,
			int geoId, double overall) {
		super();
		this.id = id;
		this.dataSourceGeoLevel = dataSourceGeoLevel;
		this.geoLevelState = geoLevelState;
		this.geoLevelName = geoLevelName;
		this.geoId = geoId;
		this.overall = overall;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public DataSourceGeoLevel getDataSourceGeoLevel() {
		return dataSourceGeoLevel;
	}

	public void setDataSourceGeoLevel(DataSourceGeoLevel dataSourceGeoLevel) {
		this.dataSourceGeoLevel = dataSourceGeoLevel;
	}

	public String getGeoLevelState() {
		return geoLevelState;
	}

	public void setGeoLevelState(String geoLevelState) {
		this.geoLevelState = geoLevelState;
	}

	public String getGeoLevelName() {
		return geoLevelName;
	}

	public void setGeoLevelName(String geoLevelName) {
		this.geoLevelName = geoLevelName;
	}

	public int getGeoId() {
		return geoId;
	}

	public void setGeoId(int geoId) {
		this.geoId = geoId;
	}

	public double getOverall() {
		return overall;
	}

	public void setOverall(double overall) {
		this.overall = overall;
	}

	public Set<AggregatedDataCategory> getAggregatedDataCategorys() {
		return aggregatedDataCategorys;
	}

	public void setAggregatedDataCategorys(Set<AggregatedDataCategory> aggregatedDataCategorys) {
		this.aggregatedDataCategorys = aggregatedDataCategorys;
	}
}
