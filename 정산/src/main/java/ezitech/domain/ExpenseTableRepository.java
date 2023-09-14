package ezitech.domain;

import ezitech.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "expenseTables",
    path = "expenseTables"
)
public interface ExpenseTableRepository
    extends JpaRepository<ExpenseTable, String> {}
