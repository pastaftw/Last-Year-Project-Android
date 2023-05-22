package Processes.Payment;

//Common Modules

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Processes.Other.Types;

public class Payment_User_Info {
    //Variables
    Integer _Owner_ID;
    BigDecimal _Payment_Status;

    public Payment_User_Info(Integer id, BigDecimal ps){
        _Owner_ID = id;
        _Payment_Status = ps;
    }

    public Integer Get_Owner_ID() {
        return _Owner_ID;
    }

    public BigDecimal Get_Payment() {
        return _Payment_Status;
    }

    public void Set_Payment(BigDecimal val){_Payment_Status = val;}

    /*
    List<Payment_Tag> _Payment_Tags = new ArrayList<>();

    //Constructor
    public Payment_User_Info(Integer owner_id) {_Owner_ID = owner_id;}

    //Properties
    public Integer Owner_ID() {return _Owner_ID;}
    public List<Payment_Tag> Payment_Tags() {return _Payment_Tags;}

    /*
    public Payment_Tag Find_Payment_Info(Integer to_id, Types.Payment_Types payment_type) {
        for (Payment_Tag payment_tag : _Payment_Tags) {
            if (payment_tag.Get_To_ID() == to_id && payment_tag.Payment_Type() == payment_type) {
                return payment_tag;
            }
        }
        return null;
    }
    */

    /*
    public void Add_Payment(Integer to_id, Types.Payment_Types payment_type, BigDecimal payment_amount, String payment_for) {
        Payment_Tag new_payment = new Payment_Tag();
        new_payment.Set_To_ID(to_id);
        new_payment.Set_Payment_Amount(payment_amount);
        new_payment.Set_Payment_For(payment_for);
        _Payment_Tags.add(new_payment);
    }
     */
}

