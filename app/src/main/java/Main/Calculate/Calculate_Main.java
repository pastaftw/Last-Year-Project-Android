package Main.Calculate;

//Common Modules
import java.util.List;
import java.util.ArrayList;

//Custom Modules
import Main.Other.User;
import Main.Item.Item_Model;
import Main.Payment.Payment_Main;

public class Calculate_Main {
    //Variables
    List <Payment_Main> _Payments = new ArrayList<>();

    //Properties
    public List <Payment_Main> Payments() {return _Payments;}

    //Functions
    public void Prepare_Invoice(List <User> Users) {
        if (_Payments.size() > 0) {_Payments.clear();}

        Users.forEach((user) -> {
            Payment_Main new_result = new Payment_Main(user.ID());
            _Payments.add(new_result);
        });
    }

    public List <Payment_Main> Execute_Calculate(List <User> Users, List <Item_Model> Items) {
        for (Item_Model item : Items) {Calculate_Logic.Execute_Logic(item, Users, _Payments);}
        return _Payments;
    }
}
