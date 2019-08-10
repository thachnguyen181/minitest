package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.AggregatedData;

@Repository
public interface IAggregatedDataRepository extends JpaRepository<AggregatedData, Integer>{

}
