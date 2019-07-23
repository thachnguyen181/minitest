package tma.com.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import tma.com.model.User;

@Repository
public interface IUserRepository extends JpaRepository<User, String> {

}
