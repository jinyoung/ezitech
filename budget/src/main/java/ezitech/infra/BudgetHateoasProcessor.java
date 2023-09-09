package ezitech.infra;

import ezitech.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class BudgetHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<Budget>> {

    @Override
    public EntityModel<Budget> process(EntityModel<Budget> model) {
        model.add(
            Link
                .of(
                    model.getRequiredLink("self").getHref() +
                    "//budgets/{taskManagementNumber}"
                )
                .withRel("/budgets/{taskManagementNumber}")
        );

        return model;
    }
}
