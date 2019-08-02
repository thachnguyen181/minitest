package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tma.com.model.AggregatedData;

public interface IAggregatedDataRepository extends JpaRepository<AggregatedData, Integer>{

}
