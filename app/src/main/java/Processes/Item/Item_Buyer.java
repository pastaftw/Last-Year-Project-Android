package Processes.Item;

import java.math.BigDecimal;

import Processes.Other.User;

public class Item_Buyer {
    //Values
    User _Buyer;
    BigDecimal _Buy;

    //Buyer
    public User Get_Buyer() {return _Buyer;}
    public void Set_Buyer(User value) {_Buyer = value;}

    //Cost
    public BigDecimal Get_Cost() {return _Buy;}
    public void Set_Cost(BigDecimal value) {_Buy = value;}

    //Constractor
    public Item_Buyer(User user_id, BigDecimal buy) {
        _Buyer = user_id;
        _Buy = buy;
    }
}
