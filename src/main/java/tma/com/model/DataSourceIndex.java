package tma.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "data_source_index")
public class DataSourceIndex implements Serializable{

	private static final long serialVersionUID = 1335369159189834733L;
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "data_source_name_id")
	private int dataSourceNameId;
	
	@Column(name = "index_data_id")
	private int indexDataId;
	
	public DataSourceIndex() {}

	public DataSourceIndex(int id, int dataSourceNameId, int indexDataId) {
		super();
		this.id = id;
		this.dataSourceNameId = dataSourceNameId;
		this.indexDataId = indexDataId;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getDataSourceNameId() {
		return dataSourceNameId;
	}

	public void setDataSourceNameId(int dataSourceNameId) {
		this.dataSourceNameId = dataSourceNameId;
	}

	public int getIndexDataId() {
		return indexDataId;
	}

	public void setIndexDataId(int indexDataId) {
		this.indexDataId = indexDataId;
	}
}
