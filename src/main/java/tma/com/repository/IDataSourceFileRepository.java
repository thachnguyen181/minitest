package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.DataSourceFile;

@Repository
public interface IDataSourceFileRepository extends JpaRepository<DataSourceFile, Integer>{

}
