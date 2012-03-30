package wad.spring.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import wad.spring.domain.AnnualBudget;


public interface AnnualBudgetRepository extends JpaRepository<AnnualBudget, Long> {

}
