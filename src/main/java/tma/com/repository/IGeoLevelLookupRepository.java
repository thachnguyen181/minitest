package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import tma.com.model.GeoLevelLookup;

@Repository
public interface IGeoLevelLookupRepository extends JpaRepository<GeoLevelLookup, Integer> {
	
	@Query("SELECT g FROM geo_level_lookup g WHERE g.geo_name = :name")
	public GeoLevelLookup findByName(@Param("name")String name);
}
