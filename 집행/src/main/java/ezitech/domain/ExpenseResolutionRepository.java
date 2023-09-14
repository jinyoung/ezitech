package ezitech.domain;

import ezitech.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "expenseResolutions",
    path = "expenseResolutions"
)
public interface ExpenseResolutionRepository
    extends JpaRepository<ExpenseResolution, String> {}
