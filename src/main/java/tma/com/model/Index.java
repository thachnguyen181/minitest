package tma.com.model;

import java.io.Serializable;
import java.util.Date;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "index")
public class Index implements Serializable{

	private static final long serialVersionUID = -2193716477323724661L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "created_at")
	private Date createdAt;
	
	@Column(name = "updated_at")
	private Date updatedAt;
	
	@Column(name = "index_name")
	private String indexName;
	
	@Column(name = "display_name")
	private String displayName;
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "index")
	private Set<DataSourceIndex> dataSourceIndexs;
	
	public Index() {}

	public Index(int id, Date createdAt, Date updatedAt, String indexName, String displayName,
			Set<DataSourceIndex> dataSourceIndexs) {
		super();
		this.id = id;
		this.createdAt = createdAt;
		this.updatedAt = updatedAt;
		this.indexName = indexName;
		this.displayName = displayName;
		this.dataSourceIndexs = dataSourceIndexs;
	}
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}

	public Date getUpdatedAt() {
		return updatedAt;
	}

	public void setUpdatedAt(Date updatedAt) {
		this.updatedAt = updatedAt;
	}

	public Set<DataSourceIndex> getDataSourceIndexs() {
		return dataSourceIndexs;
	}

	public void setDataSourceIndexs(Set<DataSourceIndex> dataSourceIndexs) {
		this.dataSourceIndexs = dataSourceIndexs;
	}

	public String getIndexName() {
		return indexName;
	}

	public void setIndexName(String indexName) {
		this.indexName = indexName;
	}

	public String getDisplayName() {
		return displayName;
	}

	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}
}
