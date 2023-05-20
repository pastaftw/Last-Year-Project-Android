package Processes.Calculate;

//Common Modules
import java.util.ArrayList;
import java.util.List;

import Processes.Item.Item_Model;
import Processes.Other.User;
import Processes.Payment.Payment_User_Info;

public class Calculate_Main {
    List <Payment_User_Info> _Payments = new ArrayList<>();
    public List <Payment_User_Info> Get_Payments() {return _Payments;}

    //Functions
    public void Prepare_Invoice(List <User> invoice_users) {
        if (_Payments.size() > 0) {_Payments.clear();}

        invoice_users.forEach((user) -> {
            Payment_User_Info new_result = new Payment_User_Info(user.ID());
            _Payments.add(new_result);
        });
    }

    public void Execute_Calculate(List <User> Users, List <Item_Model> Items) {
        for (Item_Model item : Items) {Calculate_Logic.Execute_Logic(item, Users, _Payments);}

        System.out.println("RESULTS --------------------------------------" + _Payments.size());
        _Payments.forEach((object) -> {
            object.Payment_Tags().forEach((tag) -> {
                System.out.println(
                        "Amount: " + tag.Get_Payment_Amount() + " "
                        + "Type:" + tag.Get_Payment_Type() + " "
                        + "Payment For:" + tag.Get_Payment_For() + " "
                        + "To ID:" + tag.Get_To_ID() + "\n---------------"

                );
            });
        });
    }
}
