package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tma.com.model.DataSourceName;

public interface IDataSourceNameRepository extends JpaRepository<DataSourceName, Integer> {

}
