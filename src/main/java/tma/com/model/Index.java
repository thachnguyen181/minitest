package tma.com.model;

import java.io.Serializable;
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
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy = "index")
	private Set<DataSourceIndex> dataSourceIndexs;
	
	public Index() {}

	public Index(int id) {
		super();
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Set<DataSourceIndex> getDataSourceIndexs() {
		return dataSourceIndexs;
	}

	public void setDataSourceIndexs(Set<DataSourceIndex> dataSourceIndexs) {
		this.dataSourceIndexs = dataSourceIndexs;
	}
}
