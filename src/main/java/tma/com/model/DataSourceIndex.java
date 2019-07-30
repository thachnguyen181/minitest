package tma.com.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "data_source_index")
public class DataSourceIndex implements Serializable{

	private static final long serialVersionUID = 1335369159189834733L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "data_source_name_id")
	private DataSourceName dataSourceName;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "index_data_id")
	private Index index;
	
	public DataSourceIndex() {}

	public DataSourceIndex(int id, DataSourceName dataSourceName, Index index) {
		super();
		this.id = id;
		this.dataSourceName = dataSourceName;
		this.index = index;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public DataSourceName getDataSourceName() {
		return dataSourceName;
	}

	public void setDataSourceName(DataSourceName dataSourceName) {
		this.dataSourceName = dataSourceName;
	}

	public Index getIndex() {
		return index;
	}

	public void setIndex(Index index) {
		this.index = index;
	}	
}
