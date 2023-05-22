package Processes.Calculate;

//Common Modules
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Processes.Item.Item_Model;
import Processes.Other.User;
import Processes.Payment.Payment_Helper_Tag;
import Processes.Payment.Payment_User_Info;

public class Calculate_Main {
    List <Payment_User_Info> _Payments = new ArrayList<>();
    public List <Payment_User_Info> Get_Payments() {return _Payments;}

    //Functions
    public void Prepare_Invoice(List <User> invoice_users) {
        if (_Payments.size() > 0) {_Payments.clear();}

        invoice_users.forEach((user) -> {
            Payment_User_Info new_result = new Payment_User_Info(user.ID(), BigDecimal.ZERO);
            _Payments.add(new_result);
        });
    }

    public void Execute_Calculate(List <User> Users, List <Item_Model> Items) {
        List<Payment_Helper_Tag> tmp_list = new ArrayList<>();
        Calculate_Logic.Execute_Logic(Users, Items, tmp_list);

        System.out.println("RESULTS --------------------------------------" + _Payments.size());
        tmp_list.forEach((object) -> {
            System.out.println(
                    "OWNER: " + object.Get_Owner_ID()
                    + " Payment Staus: " + object.Get_Current_Debt()
            );
        });
    }
}
