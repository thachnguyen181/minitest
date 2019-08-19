package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.AggregatedDataCategory;

@Repository
public interface IAggregatedDataCategoryRepository extends JpaRepository<AggregatedDataCategory, Integer> {

}
