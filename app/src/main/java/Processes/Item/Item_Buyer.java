package Processes.Item;
import java.math.BigDecimal;
import Processes.Other.User;

public class Item_Buyer {
    //Variables
    User _Buyer;
    BigDecimal _Buy_Cost;

    //Properties
    public User Buyer() {return _Buyer;}
    public void Buyer(User value) {_Buyer = value;}
    public BigDecimal Cost() {return _Buy_Cost;}
    public void Cost(BigDecimal value) {_Buy_Cost = value;}

    //Constractor
    public Item_Buyer(User user_id, BigDecimal buy_cost) {
        _Buyer = user_id;
        _Buy_Cost = buy_cost;
    }
}
