package Processes.Item;

import java.math.BigDecimal;

import Processes.Other.User;

public class Item_Buyer {
    //Variables
    User _Buyer;
    BigDecimal _Buy;

    //Properties
    public User Buyer() {return _Buyer;}
    public void Buyer(User value) {_Buyer = value;}
    public BigDecimal Cost() {return _Buy;}
    public void Cost(BigDecimal value) {_Buy = value;}

    //Constractor
    public Item_Buyer(User user_id, BigDecimal buy) {
        _Buyer = user_id;
        _Buy = buy;
    }
}
