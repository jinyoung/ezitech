package ezitech.domain;

import ezitech.domain.*;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

//<<< PoEAA / Repository
@RepositoryRestResource(
    collectionResourceRel = "projectMasters",
    path = "projectMasters"
)
public interface ProjectMasterRepository
    extends JpaRepository<ProjectMaster, String> {}
