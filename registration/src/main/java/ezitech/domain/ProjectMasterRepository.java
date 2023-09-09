package ezitech.domain;

import ezitech.domain.*;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(collectionResourceRel="projectMasters", path="projectMasters")
public interface ProjectMasterRepository extends PagingAndSortingRepository<ProjectMaster, String>{
}