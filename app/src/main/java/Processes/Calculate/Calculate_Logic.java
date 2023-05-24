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

    /* LEGACY
    //Calculating Discount

    static BigDecimal Item_Discount_Logic(BigDecimal last_cost, Integer people_count, BigDecimal discount) {
        return Calculate_Control.Substract(last_cost, Calculate_Control.Divide(discount, people_count));
    }

    //Calculating Paid Amount By People


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


    //Share Logic

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

    /*
        ██╗░░██╗███████╗███╗░░██╗██████╗░██╗███╗░░░███╗███████╗  ███╗░░██╗░█████╗░████████╗██╗
        ██║░██╔╝██╔════╝████╗░██║██╔══██╗██║████╗░████║██╔════╝  ████╗░██║██╔══██╗╚══██╔══╝╚═╝
        █████═╝░█████╗░░██╔██╗██║██║░░██║██║██╔████╔██║█████╗░░  ██╔██╗██║██║░░██║░░░██║░░░░░░
        ██╔═██╗░██╔══╝░░██║╚████║██║░░██║██║██║╚██╔╝██║██╔══╝░░  ██║╚████║██║░░██║░░░██║░░░░░░
        ██║░╚██╗███████╗██║░╚███║██████╔╝██║██║░╚═╝░██║███████╗  ██║░╚███║╚█████╔╝░░░██║░░░██╗
        ╚═╝░░╚═╝╚══════╝╚═╝░░╚══╝╚═════╝░╚═╝╚═╝░░░░░╚═╝╚══════╝  ╚═╝░░╚══╝░╚════╝░░░░╚═╝░░░╚═╝

        ██████╗░██████╗░░█████╗░░░░░░██╗███████╗██╗░░░██╗██╗
        ██╔══██╗██╔══██╗██╔══██╗░░░░░██║██╔════╝╚██╗░██╔╝██║
        ██████╔╝██████╔╝██║░░██║░░░░░██║█████╗░░░╚████╔╝░██║
        ██╔═══╝░██╔══██╗██║░░██║██╗░░██║██╔══╝░░░░╚██╔╝░░██║
        ██║░░░░░██║░░██║╚█████╔╝╚█████╔╝███████╗░░░██║░░░██║
        ╚═╝░░░░░╚═╝░░╚═╝░╚════╝░░╚════╝░╚══════╝░░░╚═╝░░░╚═╝

        ██████╗░░█████╗░░░░░█████╗░███████╗░░░██████╗░░█████╗░██████╗░██████╗░██╗███████╗
        ╚════██╗██╔═══╝░░░░██╔══██╗██╔════╝░░░╚════██╗██╔══██╗╚════██╗╚════██╗╚█║██╔════╝
        ░░███╔═╝██████╗░░░░██║░░██║██████╗░░░░░░███╔═╝██║░░██║░░███╔═╝░█████╔╝░╚╝█████╗░░
        ██╔══╝░░██╔══██╗░░░██║░░██║╚════██╗░░░██╔══╝░░██║░░██║██╔══╝░░░╚═══██╗░░░██╔══╝░░
        ███████╗╚█████╔╝██╗╚█████╔╝██████╔╝██╗███████╗╚█████╔╝███████╗██████╔╝░░░███████╗
        ╚══════╝░╚════╝░╚═╝░╚════╝░╚═════╝░╚═╝╚══════╝░╚════╝░╚══════╝╚═════╝░░░░╚══════╝

        ██╗░░██╗░█████╗░██████╗░░█████╗░██████╗░  ██████╗░██╗████████╗██╗██████╗░
        ██║░██╔╝██╔══██╗██╔══██╗██╔══██╗██╔══██╗  ██╔══██╗██║╚══██╔══╝██║██╔══██╗
        █████═╝░███████║██║░░██║███████║██████╔╝  ██████╦╝██║░░░██║░░░██║██████╔╝
        ██╔═██╗░██╔══██║██║░░██║██╔══██║██╔══██╗  ██╔══██╗██║░░░██║░░░██║██╔══██╗
        ██║░╚██╗██║░░██║██████╔╝██║░░██║██║░░██║  ██████╦╝██║░░░██║░░░██║██║░░██║
        ╚═╝░░╚═╝╚═╝░░╚═╝╚═════╝░╚═╝░░╚═╝╚═╝░░╚═╝  ╚═════╝░╚═╝░░░╚═╝░░░╚═╝╚═╝░░╚═╝
    */

    static void Default_Updated(List<User> users, Item_Model item, List<Payment_Helper_Tag> tmp_list) {
        //Types.Item_Buyer_Share_Types buyer_share_type = item.Get_Buyer_Share_Type(); //!!!!!!!!!!!!!!
        //Buyer Share Types are not avaible in first build. Will be in next.

        int item_buyer_count = item.Get_Buyers().size();
        BigDecimal new_item_cost = Calculate_Control.Substract(item.Get_Cost(), item.Get_Discount());
        BigDecimal cost_per_person = Calculate_Control.Divide(new_item_cost, users.size());

        users.forEach((user) -> {
            boolean has_paid = false;
            //Paid Special Buyer
            for (int i = 0; i < item.Get_Buyers().size(); i++) {
                Item_Buyer targ_user = item.Get_Buyers().get(i);
                if (user.ID().equals(targ_user.Get_Buyer().ID())) {
                    tmp_list.add(new Payment_Helper_Tag(
                            user.ID(),
                            Calculate_Control.Substract(targ_user.Get_Cost(), cost_per_person)
                    ));
                    has_paid = true;
                    //break;
                }
            }
            //NOT Paid
            if (!has_paid) {
                tmp_list.add(new Payment_Helper_Tag(
                        user.ID(),
                        cost_per_person.negate()
                ));
            }
        });
    }

    static boolean Related_User_Control(List<User> related_users, int id) {
        for (int i = 0; i < related_users.size(); i++) {
            if (related_users.get(i).ID() == id) {
                return true;
            }
        }
        return false;
    }

    static void Ignore_Updated(List<User> users, Item_Model item, List<Payment_Helper_Tag> tmp_list) {
        if (item.Get_Calculate_Style().Get_Type() != Types.Item_Calculate_Types.Ignore) {return;}
        //Types.Item_Buyer_Share_Types buyer_share_type = item.Get_Buyer_Share_Type(); //!!!!!!!!!!!!!!
        //Buyer Share Types are not avaible in first build. Will be in next.

        int item_buyer_count = item.Get_Buyers().size();
        List<User> related_users = item.Get_Calculate_Style().Get_Releated_Users();
        int updated_user_count = users.size() - related_users.size();
        BigDecimal new_item_cost = Calculate_Control.Substract(item.Get_Cost(), item.Get_Discount());
        BigDecimal cost_per_person = Calculate_Control.Divide(new_item_cost, updated_user_count);

        users.forEach((user) -> {
            boolean has_paid = false;
            //Paid Special Buyer
            for (int i = 0; i < item.Get_Buyers().size(); i++) {
                Item_Buyer targ_user = item.Get_Buyers().get(i);
                if (user.ID().equals(targ_user.Get_Buyer().ID())) {
                    if (Related_User_Control(related_users, user.ID())) {
                        System.out.println("ignored " + user.ID());
                        tmp_list.add(new Payment_Helper_Tag(
                                user.ID(),
                                targ_user.Get_Cost()
                        ));
                    }
                    else {
                        System.out.println("is paid but not ignored " + user.ID());
                        tmp_list.add(new Payment_Helper_Tag(
                                user.ID(),
                                Calculate_Control.Substract(targ_user.Get_Cost(), cost_per_person)
                        ));
                    }
                    has_paid = true;
                    //break;
                }
            }
            //NOT Paid
            if (!has_paid) {
                if (!Related_User_Control(related_users, user.ID())) {
                    System.out.println("not related " + user.ID());
                    tmp_list.add(new Payment_Helper_Tag(
                            user.ID(),
                            cost_per_person.negate()
                    ));
                }
            }
        });
    }

    static void Share_Updated(List<User> users, Item_Model item, List<Payment_Helper_Tag> tmp_list) {
        if (item.Get_Calculate_Style().Get_Type() != Types.Item_Calculate_Types.Share) {return;}
        //Types.Item_Buyer_Share_Types buyer_share_type = item.Get_Buyer_Share_Type(); //!!!!!!!!!!!!!!
        //Buyer Share Types are not avaible in first build. Will be in next.

        List<User> related_users = item.Get_Calculate_Style().Get_Releated_Users();
        BigDecimal new_item_cost = Calculate_Control.Substract(item.Get_Cost(), item.Get_Discount());
        BigDecimal cost_per_person = Calculate_Control.Divide(new_item_cost, related_users.size());

        users.forEach((user) -> {
            boolean has_paid = false;
            //Paid Special Buyer
            for (int i = 0; i < item.Get_Buyers().size(); i++) {
                Item_Buyer targ_user = item.Get_Buyers().get(i);
                if (user.ID().equals(targ_user.Get_Buyer().ID())) {
                    //Is related User
                    if (Related_User_Control(related_users, user.ID())) {
                        tmp_list.add(new Payment_Helper_Tag(
                                user.ID(),
                                Calculate_Control.Substract(targ_user.Get_Cost(), cost_per_person)
                        ));
                    }
                    else {
                        tmp_list.add(new Payment_Helper_Tag(
                                user.ID(),
                                targ_user.Get_Cost()
                        ));
                    }
                    has_paid = true;
                    //break;
                }
            }
            //NOT Paid
            if (!has_paid) {
                if (Related_User_Control(related_users, user.ID())) {
                    tmp_list.add(new Payment_Helper_Tag(
                            user.ID(),
                            cost_per_person.negate()
                    ));
                }
            }
        });
    }

    public static void Execute_Logic(List <User> users, List <Item_Model> items, List <Payment_Helper_Tag> tmp_list) {
        System.out.println("Logic Execute:: Started");
        if (users.size() == 0 || items.size() == 0) {
            System.out.println("USERS OR ITEMS ARE MISSING!");
            return;
        }

        //Execute Logic
        for (Item_Model item: items) {
            if (item.Get_Calculate_Style() != null) {
                System.out.println("Logic:: Special Calculate");
                Calculate_Logic.Share_Updated(users, item, tmp_list);
                Calculate_Logic.Ignore_Updated(users, item, tmp_list);
            }
            else {
                System.out.println("Logic:: Default Calculate");
                Calculate_Logic.Default_Updated(users, item, tmp_list);
            }
        }
    }
}
