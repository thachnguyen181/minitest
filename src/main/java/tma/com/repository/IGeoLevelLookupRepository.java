package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.GeoLevelLookup;

@Repository
public interface IGeoLevelLookupRepository extends JpaRepository<GeoLevelLookup, Integer> {

}
