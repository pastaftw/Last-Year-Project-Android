package Processes.Item;
import androidx.annotation.Nullable;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Processes.Other.Types;
import Processes.Other.Types.Object_Buy_Types;

public class Item_Model {
    //Variables
    Integer _Item_Buyer;
    String _Item_Buy_Date;
    String _Item_Name;
    Object_Buy_Types _Item_Buy_Type;
    Integer _Item_Buy_Count = 0;
    BigDecimal _Item_Cost;
    BigDecimal _Item_Discount;
    @Nullable Item_Purpose _Item_Purpose;

    //Properties
    public Integer Buyer() {return _Item_Buyer;}
    public void Buyer(Integer value) {_Item_Buyer = value;}
    public String Buy_Date() {return _Item_Buy_Date;}
    public void Buy_Date(String value) {_Item_Buy_Date = value;}
    public String Name() {return _Item_Name;}
    public void Name(String value) {_Item_Name = value;}
    public Object_Buy_Types Buy_Type() {return _Item_Buy_Type;}
    public void Buy_Type(Object_Buy_Types value) {_Item_Buy_Type = value;}
    public Integer Buy_Count() {return _Item_Buy_Count;}
    public void Buy_Count(Integer value) {_Item_Buy_Count = value;}
    public BigDecimal Cost() {return _Item_Cost;}
    public void Cost(BigDecimal value) {_Item_Cost = value;}
    public BigDecimal Discount() {return _Item_Discount;}
    public void Discount(BigDecimal value) {_Item_Discount = value;}
    public Item_Purpose Purpose() {return _Item_Purpose;}
    public void Set_Purpose(Item_Purpose value) {_Item_Purpose = value;}

    //Constructor
    public Item_Model(Integer item_buyer, String item_buy_date, String item_name, Object_Buy_Types item_buy_type, Integer item_buy_count, BigDecimal item_cost, BigDecimal item_discount) {
        Buyer(item_buyer);
        Buy_Date(item_buy_date);
        Name(item_name);
        Buy_Type(item_buy_type);
        Buy_Count(item_buy_count);
        Cost(item_cost);
        Discount(item_discount);
    }

    //TESTING AREA
    List<Item_Buyer> _NEW_ITEM_BUYERS = new ArrayList<>();
    Types.Item_Buyer_Types _NEW_ITEM_BUYER_TYPE = Types.Item_Buyer_Types.Countable;
    public List<Item_Buyer> NEW_BUYERS() {return _NEW_ITEM_BUYERS;}
    public void NEW_BUYERS(Item_Buyer value) {_NEW_ITEM_BUYERS.add(value);}
    public Item_Model(Integer item_buyer, String item_buy_date, String item_name, Object_Buy_Types item_buy_type, Integer item_buy_count, BigDecimal item_cost, BigDecimal item_discount, Item_Buyer TEST) {
        Buyer(item_buyer);
        Buy_Date(item_buy_date);
        Name(item_name);
        Buy_Type(item_buy_type);
        Buy_Count(item_buy_count);
        Cost(item_cost);
        Discount(item_discount);
        NEW_BUYERS(TEST); // TEST
    }
    public Item_Model(Integer item_buyer, String item_buy_date, String item_name, Object_Buy_Types item_buy_type, Integer item_buy_count, BigDecimal item_cost, BigDecimal item_discount, Item_Buyer[] TEST) {
        Buyer(item_buyer);
        Buy_Date(item_buy_date);
        Name(item_name);
        Buy_Type(item_buy_type);
        Buy_Count(item_buy_count);
        Cost(item_cost);
        Discount(item_discount);
        //TESTTTT
        for (int i = 0; i < TEST.length; i++) {
            NEW_BUYERS(TEST[i]);
        }
    }
}

