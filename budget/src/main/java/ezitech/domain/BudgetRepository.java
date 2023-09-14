package ezitech.domain;

import ezitech.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel = "budgets", path = "budgets")
public interface BudgetRepository extends JpaRepository<Budget, String> {}
