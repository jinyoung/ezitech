package ezitech.infra;

import ezitech.domain.*;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.Link;
import org.springframework.hateoas.server.RepresentationModelProcessor;
import org.springframework.stereotype.Component;

@Component
public class ExpenseTableHateoasProcessor
    implements RepresentationModelProcessor<EntityModel<ExpenseTable>> {

    @Override
    public EntityModel<ExpenseTable> process(EntityModel<ExpenseTable> model) {
        return model;
    }
}
