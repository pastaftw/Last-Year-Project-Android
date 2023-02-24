package Processes.Item;
import java.math.BigDecimal;
import Processes.Other.Types.Object_Buy_Types;

public class Item_Model {
    //Variables
    Integer _Object_Buyer;
    String _Object_Buy_Date;
    String _Object_Name;
    Object_Buy_Types _Object_Buy_Type;
    Integer _Object_Buy_Count = 0;
    BigDecimal _Object_Cost;
    BigDecimal _Object_Discount;
    Item_Purpose _Purpose;

    //Properties
    public Integer Buyer() {return _Object_Buyer;}
    public void Buyer(Integer value) {_Object_Buyer = value;}
    public String Buy_Date() {return _Object_Buy_Date;}
    public void Buy_Date(String value) {_Object_Buy_Date = value;}
    public String Name() {return _Object_Name;}
    public void Name(String value) {_Object_Name = value;}
    public Object_Buy_Types Buy_Type() {return _Object_Buy_Type;}
    public void Buy_Type(Object_Buy_Types value) {_Object_Buy_Type = value;}
    public Integer Buy_Count() {return _Object_Buy_Count;}
    public void Buy_Count(Integer value) {_Object_Buy_Count = value;}
    public BigDecimal Cost() {return _Object_Cost;}
    public void Cost(BigDecimal value) {_Object_Cost = value;}
    public BigDecimal Discount() {return _Object_Discount;}
    public void Discount(BigDecimal value) {_Object_Discount = value;}
    public Item_Purpose Purpose() {return _Purpose;}
    public void Set_Purpose(Item_Purpose value) {_Purpose = value;}

    //Custom
    public String[] Output() {
        return new String[] {
                _Object_Buyer.toString(),
                _Object_Buy_Date.toString(), //WILL BE DATE
                _Object_Name, //IS STRING
                _Object_Buy_Type.toString(),
                _Object_Buy_Count.toString(),
                _Object_Cost.toString(),
                _Object_Discount.toString(),
                _Purpose == null ?  "None" : _Purpose.toString(),
        };
    }

    //Constructor
    public Item_Model(Integer object_buyer, String buy_date, String name, Object_Buy_Types buy_type, Integer buy_count, BigDecimal cost, BigDecimal discount) {
        Buyer(object_buyer);
        Buy_Date(buy_date);
        Name(name);
        Buy_Type(buy_type);
        Buy_Count(buy_count);
        Cost(cost);
        Discount(discount);
    }
}

