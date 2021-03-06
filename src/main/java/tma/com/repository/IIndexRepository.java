package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.Index;

@Repository
public interface IIndexRepository extends JpaRepository<Index, Integer>{

}
