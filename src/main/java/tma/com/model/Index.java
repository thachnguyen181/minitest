package tma.com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "index")
public class Index implements Serializable{

	private static final long serialVersionUID = -2193716477323724661L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@ManyToMany(mappedBy = "indexs")
	//@JoinColumn(name = "index_data_id")
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

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Index other = (Index) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
