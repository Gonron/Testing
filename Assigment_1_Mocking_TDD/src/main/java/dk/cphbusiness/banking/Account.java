package dk.cphbusiness.banking;
import java.util.*;
public interface Account {



    public Bank getBank();

    public Customer getCustomer();

    public String getNumber();

    public long getBalance();



    public void transfer(long amount, Account target);

    public void transfer(long amount, String targetNumber);

    void updateBalance(long amount);

    List<RealMovement> getMovements();


}
