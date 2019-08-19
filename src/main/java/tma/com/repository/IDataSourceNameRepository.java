package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tma.com.model.DataSourceName;

@Repository
public interface IDataSourceNameRepository extends JpaRepository<DataSourceName, Integer> {
	
    @Query("SELECT d FROM DataSourceName d WHERE d.name = :name") // Cai nay la nativeQuery = false, dung className / fieldName cua model class
    //@Query(nativeQuery=true, value= "SELECT d FROM data_source_name d WHERE d.name = :name") // Khi nao nativeQuery = true thi moi dung table name/column name trong DB
	public DataSourceName findByName (@Param("name")String name);
}
