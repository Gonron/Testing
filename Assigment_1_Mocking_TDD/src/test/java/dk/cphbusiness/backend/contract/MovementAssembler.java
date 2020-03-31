package dk.cphbusiness.backend.contract;

import dk.cphbusiness.backend.models.Movement;

import java.util.ArrayList;
import java.util.List;

import static dk.cphbusiness.contract.MovementManager.*;
import static dk.cphbusiness.backend.contract.AccountAssembler.*;

public class MovementAssembler {

    public static MovementDetail createMovementDetail(Movement movement){
        return new MovementDetail(movement.getId(),
                movement.getTime(),
                movement.getAmount(),
                createAccountSummary(movement.getTarget()),
                createAccountSummary(movement.getSource()));
    }

    public static List<MovementDetail> createMovementDetails(List<Movement> movement){
        var summaries = new ArrayList<MovementDetail>();
        movement.forEach(mvmnt -> summaries.add(createMovementDetail(mvmnt)));
        return summaries;
    }
}