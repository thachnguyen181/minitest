package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tma.com.model.DataSourceName;

@Repository
public interface IDataSourceNameRepository extends JpaRepository<DataSourceName, Integer> {
	
    @Query("SELECT d FROM data_source_name d WHERE d.name = :name")
	public DataSourceName findByName (@Param("name")String name);
}
