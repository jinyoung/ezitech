package ezitech.infra;
import ezitech.domain.*;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.transaction.Transactional;

//<<< Clean Arch / Inbound Adaptor

@RestController
// @RequestMapping(value="/projectMasters")
@Transactional
public class ProjectMasterController {
    @Autowired
    ProjectMasterRepository projectMasterRepository;




    @RequestMapping(value = "projectMasters/{id}//projects/{projectId}",
        method = RequestMethod.PUT,
        produces = "application/json;charset=UTF-8")
    public ProjectMaster updateProject(@PathVariable(value = "id")  id, @RequestBody UpdateProjectCommand updateProjectCommand, HttpServletRequest request, HttpServletResponse response) throws Exception {
            System.out.println("##### /projectMaster/updateProject  called #####");
            Optional<ProjectMaster> optionalProjectMaster = projectMasterRepository.findById(id);
            
            optionalProjectMaster.orElseThrow(()-> new Exception("No Entity Found"));
            ProjectMaster projectMaster = optionalProjectMaster.get();
            projectMaster.updateProject(updateProjectCommand);
            
            projectMasterRepository.save(projectMaster);
            return projectMaster;
            
    }
    




}
//>>> Clean Arch / Inbound Adaptor
