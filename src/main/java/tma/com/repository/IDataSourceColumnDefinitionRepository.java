package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tma.com.model.DataSourceColumnDefinition;

public interface IDataSourceColumnDefinitionRepository extends JpaRepository<DataSourceColumnDefinition, Integer>{

}
