package it.corso.mygym.model.dao;
import it.corso.mygym.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
@Repository
public interface UserRepository extends JpaRepository <User,Long> {
}
