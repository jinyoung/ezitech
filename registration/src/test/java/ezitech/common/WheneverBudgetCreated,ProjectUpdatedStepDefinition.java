package ezitech.common;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import static org.assertj.core.api.Assertions.assertThat;

public class WheneverBudgetCreated,ProjectUpdatedStepDefinition {
    
    BudgetCreated budgetCreated = new BudgetCreated();
    ProjectUpdated projectUpdated = new ProjectUpdated();
    ProjectMaster projectMaster = new ProjectMaster();

    @Given("BudgetCreated \\( {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} ) is published and ProjectMaster \\( {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} {string} )is present")
    public void BudgetCreated_is_published_and_ProjectMaster_is_present(String BudgetCreated_taskManagementNumber, String BudgetCreated_governmentSupportAmount, String BudgetCreated_privateRatio, String BudgetCreated_privateCashRatio, String BudgetCreated_laborCost, String BudgetCreated_internalLaborCost, String BudgetCreated_externalLaborCost, String BudgetCreated_studentResearchCost, String BudgetCreated_materialCost, String BudgetCreated_researchFacilityCost, String BudgetCreated_activityCost, String BudgetCreated_indirectCost, String ProjectMaster_projectId, String ProjectMaster_noticeProjectName, String ProjectMaster_projectManager, String ProjectMaster_projectName, String ProjectMaster_rfpName, String ProjectMaster_researchManager, String ProjectMaster_cashBurden, String ProjectMaster_materialBurden, String ProjectMaster_totalProjectCost, String ProjectMaster_currentYearProjectCost, String ProjectMaster_totalProjectDuration, String ProjectMaster_currentYearDuration, String ProjectMaster_organName, String ProjectMaster_organBusinessNumber, String ProjectMaster_organDirector, String ProjectMaster_receiptDate, String ProjectMaster_selectionNotification, String ProjectMaster_accountAllocation, String ProjectMaster_projectPlanFile, String ProjectMaster_participationType){
      // budgetCreated.setTaskManagementNumber();
      // budgetCreated.setGovernmentSupportAmount();
      // budgetCreated.setPrivateRatio();
      // budgetCreated.setPrivateCashRatio();
      // budgetCreated.setLaborCost();
      // budgetCreated.setInternalLaborCost();
      // budgetCreated.setExternalLaborCost();
      // budgetCreated.setStudentResearchCost();
      // budgetCreated.setMaterialCost();
      // budgetCreated.setResearchFacilityCost();
      // budgetCreated.setActivityCost();
      // budgetCreated.setIndirectCost();
      // projectMaster.setProjectId();
      // projectMaster.setNoticeProjectName();
      // projectMaster.setProjectManager();
      // projectMaster.setProjectName();
      // projectMaster.setRfpName();
      // projectMaster.setResearchManager();
      // projectMaster.setCashBurden();
      // projectMaster.setMaterialBurden();
      // projectMaster.setTotalProjectCost();
      // projectMaster.setCurrentYearProjectCost();
      // projectMaster.setTotalProjectDuration();
      // projectMaster.setCurrentYearDuration();
      // projectMaster.setOrganName();
      // projectMaster.setOrganBusinessNumber();
      // projectMaster.setOrganDirector();
      // projectMaster.setReceiptDate();
      // projectMaster.setSelectionNotification();
      // projectMaster.setAccountAllocation();
      // projectMaster.setProjectPlanFile();
      // projectMaster.setParticipationType();
    }
    @When("update project")
    public void update project(){
        projectMaster.update project();
    }
    @Then("ProjectUpdated \\( {string} ) should publish")
    public void ProjectUpdated_should_publish(String ProjectUpdated_noticeProjectName){
      // projectUpdated.setNoticeProjectName();
    }

}
