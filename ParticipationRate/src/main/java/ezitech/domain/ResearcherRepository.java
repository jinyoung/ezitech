package ezitech.domain;

import ezitech.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "researchers",
    path = "researchers"
)
public interface ResearcherRepository
    extends PagingAndSortingRepository<Researcher, String> {}
