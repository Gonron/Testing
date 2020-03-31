package dk.cphbusiness.backend.contract;
import dk.cphbusiness.backend.models.Bank;
import java.util.ArrayList;
import java.util.Collection;
import static dk.cphbusiness.contract.BankManager.*;

public class BankAssembler {

    public static BankSummary createBankSummary(Bank bank){
        return new BankSummary(bank.getCvr(), bank.getName());
    }


    public static Collection<BankSummary> createBankSummaries(Collection<Bank> banks){
        var summaries = new ArrayList<BankSummary>();
        for(Bank bank : banks) summaries.add(createBankSummary(bank));
        return summaries;
    }
}

