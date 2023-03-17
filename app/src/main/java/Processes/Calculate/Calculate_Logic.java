package Processes.Calculate;

//Common Modules

import java.math.BigDecimal;
import java.util.List;
import Processes.Item.Item_Model;
import Processes.Other.Types;
import Processes.Other.User;
import Processes.Payment.Payment_Main;

public class Calculate_Logic {

    //Calculating Item Amount
    static BigDecimal Item_Amount_Logic(Types.Object_Buy_Types type, Integer amount, BigDecimal cost) {
        if (type == Types.Object_Buy_Types.Countable) {return Calculate_Control.Multiply(cost, amount);}
        else if (type == Types.Object_Buy_Types.Kilogram) {return Calculate_Control.Multiply(cost, amount);}
        else if (type == Types.Object_Buy_Types.Gram) {return Calculate_Control.Multiply(cost, Calculate_Control.Convert_To_Kg(amount));}
        else {throw new Error("Item_Amount_Logic ERROR (Type logic is not defined.)");}
    }

    //Calculating Discount
    static BigDecimal Item_Discount_Logic(BigDecimal last_cost, Integer people_count, BigDecimal discount) {
        return Calculate_Control.Substract(last_cost, Calculate_Control.Divide(discount, people_count));
    }

    //Share Logic
    static void Share(Item_Model item, List <Payment_Main> payments, List <User> related_users) {
        if (item.Purpose().Type() == Types.Purpose_List_Types.Share) {
            payments.forEach((payment) -> {
                related_users.forEach((related_user) -> {
                    if (payment.Owner_ID() == related_user.ID() && payment.Owner_ID() != item.Buyer()) {
                        //Payment Profile
                        payment.Add_Payment(
                                item.Buyer(),
                                Types.Payment_Types.Debtor,
                                //Executing Item_Discount_Logic
                                Item_Discount_Logic(
                                        Calculate_Control.Divide(Item_Amount_Logic(item.Buy_Type(), item.Buy_Count(), item.Cost()), related_users.size()),
                                        related_users.size(),
                                        item.Discount()
                                ),
                                item.Name()
                        );
                    }
                });
            });
        }
    }

    //Ignore Logic
    static void Ignore(Item_Model item, List <User> users, List <Payment_Main> payments, List <User> related_users) {
        if (item.Purpose().Type() == Types.Purpose_List_Types.Ignore) {
            Integer non_related_user_count = users.size() - related_users.size();
            payments.forEach((payment) -> {
                //geliştir
                related_users.forEach((related_user) -> {
                    if (payment.Owner_ID() != related_user.ID() && payment.Owner_ID() != item.Buyer()) {
                        //Payment Profile
                        payment.Add_Payment(
                                item.Buyer(),
                                Types.Payment_Types.Debtor,
                                //Executing Item_Discount_Logic
                                Item_Discount_Logic(
                                        Calculate_Control.Divide(Item_Amount_Logic(item.Buy_Type(), item.Buy_Count(), item.Cost()), non_related_user_count),
                                        related_users.size(),
                                        item.Discount()
                                ),
                                item.Name()
                        );
                    }
                });
            });
        }
    }

    //Default Logic
    static void Default (Item_Model item, List <Payment_Main> payments) {
        BigDecimal people_count =  BigDecimal.valueOf(payments.size());
        payments.forEach((payment) -> {
            if (payment.Owner_ID() != item.Buyer()) {
                //Payment Profile
                payment.Add_Payment(
                        item.Buyer(),
                        Types.Payment_Types.Debtor,
                        //Executing Item_Discount_Logic
                        Item_Discount_Logic(
                                Calculate_Control.Divide(item.Cost(), people_count),
                                payments.size(),
                                item.Discount()
                        ),
                        item.Name()
                );
            }
        });
    }

    public static void Execute_Logic(Item_Model item, List <User> users, List <Payment_Main> payments) {
        if (item.Purpose() != null) {
            List<User> related_users = item.Purpose().Releated_Users();
            Calculate_Logic.Share(item, payments, related_users);
            Calculate_Logic.Ignore(item, users, payments, related_users);
        }
        else {
            Default(item, payments);
        }
    }
}
