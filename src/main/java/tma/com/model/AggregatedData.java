package tma.com.model;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "aggregated_data")
public class AggregatedData implements Serializable{

	private static final long serialVersionUID = 1868162720391308731L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private UUID id;
	
	@Column(name = "data_source_geo_level_id")
	private int dataSourceGeoLevelId;
	
	@Column(name = "geo_level_state")
	private String geoLevelState;
	
	@Column(name = "geo_level_name")
	private String geoLevelName;
	
	@Column(name = "geo_id")
	private int geoId;
	
	@Column(name = "overall")
	private double overall;
}
