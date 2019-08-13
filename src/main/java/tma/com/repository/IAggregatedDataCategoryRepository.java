package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import tma.com.model.AggregatedDataCategory;

public interface IAggregatedDataCategoryRepository extends JpaRepository<AggregatedDataCategory, Integer> {

}
