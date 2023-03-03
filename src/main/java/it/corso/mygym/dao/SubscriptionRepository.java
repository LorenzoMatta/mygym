package it.corso.mygym.dao;


import it.corso.mygym.model.Subscription;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubscriptionRepository extends JpaRepository <Subscription,Long> {
}
