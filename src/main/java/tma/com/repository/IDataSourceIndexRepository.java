package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.DataSourceIndex;

@Repository
public interface IDataSourceIndexRepository extends JpaRepository<DataSourceIndex, Integer>{

}
