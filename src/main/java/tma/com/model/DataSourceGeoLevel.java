package tma.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
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
}
