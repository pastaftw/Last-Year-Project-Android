package Processes.Calculate;

//Common Modules

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Processes.Item.Item_Buyer;
import Processes.Item.Item_Model;
import Processes.Other.Types;
import Processes.Other.User;
import Processes.Payment.Payment_Helper_Tag;
import Processes.Payment.Payment_Tag;
import Processes.Payment.Payment_User_Info;

public class Calculate_Logic {

    //Calculating Item Amount
    static BigDecimal Item_Amount_Logic(Types.Item_Buy_Types type, Integer amount, BigDecimal cost) {
        if (type == Types.Item_Buy_Types.Countable) {return Calculate_Control.Multiply(cost, amount);}
        else if (type == Types.Item_Buy_Types.Kilogram) {return Calculate_Control.Multiply(cost, amount);}
        else if (type == Types.Item_Buy_Types.Gram) {return Calculate_Control.Multiply(cost, Calculate_Control.Convert_To_Kg(amount));}
        else {throw new Error("Item_Amount_Logic ERROR (Type logic is not defined.)");}
    }

    //Calculating Discount
    static BigDecimal Item_Discount_Logic(BigDecimal last_cost, Integer people_count, BigDecimal discount) {
        return Calculate_Control.Substract(last_cost, Calculate_Control.Divide(discount, people_count));
    }

    //Calculating Paid Amount By People
    static List<Payment_Helper_Tag> Item_Buyer_Share_Type_Logic(List<User> users, Item_Model item, List <Payment_User_Info> payments) {
        Types.Item_Buyer_Share_Types buyer_share_type = item.Get_Buyer_Share_Type();
        List<Payment_Helper_Tag> temporary_payment_results = new ArrayList<>();

        //Amount
        if (buyer_share_type == Types.Item_Buyer_Share_Types.values()[0]) {
            int item_buyer_count = payments.size();
            BigDecimal new_item_cost = Calculate_Control.Substract(item.Get_Cost(), item.Get_Discount());
            BigDecimal cost_per_person = Calculate_Control.Divide(new_item_cost, item_buyer_count);

            users.forEach((user) -> {
                boolean has_paid = false;
                for (int i = 0; i < item.Get_Buyers().size(); i++) {
                    Item_Buyer targ_user = item.Get_Buyers().get(i);
                    if (user.ID().equals(targ_user.Get_Buyer().ID())) {
                        //PH
                        temporary_payment_results.add(new Payment_Helper_Tag(
                                user.ID(),
                                Calculate_Control.Substract(targ_user.Get_Cost(), cost_per_person),
                                null
                        ));
                        has_paid = true;
                        break;
                    }
                }
                if (!has_paid) {
                    //PH
                    temporary_payment_results.add(new Payment_Helper_Tag(
                            user.ID(),
                            cost_per_person.negate(),
                            0
                    ));
                }
            });


            temporary_payment_results.forEach((p) -> {
                System.out.println("CURRENT:" + p.Get_Owner_ID() + " - " + p.Get_Current_Debt());
            });

            System.out.println("-----------------------------------------------------------------");

            List<Payment_Helper_Tag> last_pht = new ArrayList<>();
            for (int i = 0; i < temporary_payment_results.size(); i++) {
                Payment_Helper_Tag from_pht = temporary_payment_results.get(i);
                if (from_pht.Get_To_ID() == null) {continue;}
                BigDecimal transfer_val;
                for (int j = 0; j < temporary_payment_results.size(); j++){
                    Payment_Helper_Tag to_pht = temporary_payment_results.get(i);
                    if (to_pht.Get_To_ID() == null) {continue;}
                    transfer_val = Calculate_Control.Add(from_pht.Get_Current_Debt(), cost_per_person);
                    from_pht.Set_Current_Debt(Calculate_Control.Add(from_pht.Get_Current_Debt(), transfer_val));
                    to_pht.Set_Current_Debt(Calculate_Control.Add(to_pht.Get_Current_Debt(), transfer_val));
                }
            }

            System.out.println("-----------------------------------------------------------------");
            temporary_payment_results.forEach((p) -> {
                System.out.println("LAST:" + p.Get_Owner_ID() + " - " + p.Get_Current_Debt());
            });
        }
        return temporary_payment_results;
    }

                            /*
                        if (targ_to_pht.Get_To_ID() == null) {

                            /*
                            if (targ_from_pht.Get_Current_Debt().compareTo(BigDecimal.ZERO) >= 0) {break;}
                            //Eklenecek
                            BigDecimal val = Calculate_Control.Add(targ_from_pht.Get_Current_Debt(), cost_per_person);
                            System.out.println("val:" + val);
                            targ_from_pht.Set_Current_Debt(Calculate_Control.Add(targ_from_pht.Get_Current_Debt(), val));
                            targ_to_pht.Set_Current_Debt(Calculate_Control.Add(targ_to_pht.Get_Current_Debt(), val));
                            System.out.println("From " + targ_from_pht.Get_Owner_ID() + " To " + targ_to_pht.Get_Owner_ID() + " -> " + val);

                        }
                        */

    //Share Logic
    /*
    static void Share(Item_Model item, List <Payment_Main> payments, List <User> related_users) {
        if (item.Get_Calculate_Style().Get_Type() == Types.Item_Calculate_Types.Share) {
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
        if (item.Get_Calculate_Style().Get_Type() == Types.Item_Calculate_Types.Ignore) {
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
    */




    //Default Logic
    static void Default (List<User> users, Item_Model item, List <Payment_User_Info> payments) {
        List<Payment_Helper_Tag> temporary_payment_results = Item_Buyer_Share_Type_Logic(users, item, payments);
        List<Integer> temporary_no_debt_list = new ArrayList<>();


        /*
        payments.forEach((payment) -> {});*/

        temporary_payment_results.forEach((p) -> {
            System.out.println("CURRENT:" + p.Get_Owner_ID() + " - " + p.Get_Current_Debt());
        });
    }

    /*
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
     */

    public static void Execute_Logic(Item_Model item, List <User> users, List <Payment_User_Info> payments) {
        if (item.Get_Calculate_Style() != null) {
            List<User> related_users = item.Get_Calculate_Style().Get_Releated_Users();
            //Calculate_Logic.Share(item, payments, related_users);
            //Calculate_Logic.Ignore(item, users, payments, related_users);
        }
        else {
            System.out.println("Default Calculate!");
            Calculate_Logic.Item_Buyer_Share_Type_Logic(users, item, payments);
        }
    }
}
