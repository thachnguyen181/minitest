package tma.com.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "data_source_name")
public class DataSourceName implements Serializable{

	private static final long serialVersionUID = -4288662597352609158L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	private int id;
	
	@Column(name = "name")
	private String name;
	
	@ManyToMany(cascade = { CascadeType.ALL })
	@JoinTable(name = "data_source_index",
		joinColumns = {@JoinColumn(name = "data_source_name_id",referencedColumnName="id")},
		inverseJoinColumns = @JoinColumn(name = "index_data_id", referencedColumnName="id"))
	private Set<Index> indexs;
	
	@OneToMany(mappedBy = "dataSourceName")
	private Set<DataSourceFile> dataSourceFiles;
	
	@OneToMany(mappedBy = "dataSourceName")
	private Set<DataSourceColumnDefinition> dataSourceColumnDefinitions;
	

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Set<Index> getIndexs() {
		return indexs;
	}

	public void setIndexs(Set<Index> index) {
		this.indexs = index;
	}

	public Set<DataSourceFile> getDataSourceFiles() {
		return dataSourceFiles;
	}

	public void setDataSourceFiles(Set<DataSourceFile> dataSourceFiles) {
		this.dataSourceFiles = dataSourceFiles;
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
		DataSourceName other = (DataSourceName) obj;
		if (id != other.id)
			return false;
		return true;
	}
}
