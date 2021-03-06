package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.DataSourceGeoLevel;

@Repository
public interface IDataSourceGeoLevelRepository extends JpaRepository<DataSourceGeoLevel, Integer>{

}
