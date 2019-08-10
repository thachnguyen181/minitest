package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.DataSourceColumnDefinition;

@Repository
public interface IDataSourceColumnDefinitionRepository extends JpaRepository<DataSourceColumnDefinition, Integer>{

}
