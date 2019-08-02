package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tma.com.model.DataSourceFile;

public interface IDataSourceFileRepository extends JpaRepository<DataSourceFile, Integer>{

}
