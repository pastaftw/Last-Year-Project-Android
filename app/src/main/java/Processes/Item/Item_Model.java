package Processes.Item;
import androidx.annotation.Nullable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import Processes.Other.Types;

public class Item_Model {
    //Item Buyers
    List<Item_Buyer> _Item_Buyers;
    public List<Item_Buyer> Get_Buyers() {return _Item_Buyers;}
    public void Add_Buyer(Item_Buyer value) {_Item_Buyers.add(value);}
    public void Remove_Buyer(Item_Buyer value){_Item_Buyers.remove(value);}
    public void Set_All_Buyers(List<Item_Buyer> value) {
        _Item_Buyers.clear();
        _Item_Buyers.addAll(value);
    }

    //Item Buyer Type
    Types.Item_Buyer_Types _Item_Buyer_Share_Type;
    public Types.Item_Buyer_Types Get_Buyer_Share_Type() {return _Item_Buyer_Share_Type;}
    public void Set_Buyer_Share_Type(Types.Item_Buyer_Types value) {_Item_Buyer_Share_Type = value;}

    //Item Name
    String _Item_Name;
    public String Get_Name() {return _Item_Name;}
    public void Set_Name(String value) {_Item_Name = value;}

    //Item Buy Type
    Types.Item_Buy_Types _Item_Buy_Type;
    public Types.Item_Buy_Types Get_Buy_Type() {return _Item_Buy_Type;}
    public void Set_Buy_Type(Types.Item_Buy_Types value) {_Item_Buy_Type = value;}

    //Item Buy Count
    BigDecimal _Item_Buy_Count;
    public BigDecimal Get_Buy_Count() {return _Item_Buy_Count;}
    public void Set_Buy_Count(BigDecimal value) {_Item_Buy_Count = value;}

    //Item Cost
    BigDecimal _Item_Cost;
    public BigDecimal Get_Cost() {return _Item_Cost;}
    public void Set_Cost(BigDecimal value) {_Item_Cost = value;}

    //Item Discount
    @Nullable BigDecimal _Item_Discount;
    public BigDecimal Get_Discount() {return _Item_Discount;}
    public void Set_Discount(BigDecimal value) {_Item_Discount = value;}

    //Item Buy Date
    String _Item_Buy_Date;
    public String Get_Date() {return _Item_Buy_Date;}
    public void Set_Date(String value) {_Item_Buy_Date = value;}

    //Item Calculating Style
    @Nullable Item_Calculate_Style _Item_Calculate_Type;
    public Item_Calculate_Style Get_Calculate_Style() {return _Item_Calculate_Type;}
    public void Set_Calculate_Style(Item_Calculate_Style value) {_Item_Calculate_Type = value;}

    //Constructor Default
    public Item_Model (
            List<Item_Buyer> _Item_Buyers,
            Types.Item_Buyer_Types _Item_Buyer_Share_Type,
            String _Item_Name,
            Types.Item_Buy_Types _Item_Buy_Type,
            BigDecimal _Item_Buy_Count,
            BigDecimal _Item_Cost,
            BigDecimal _Item_Discount,
            String _Item_Buy_Date
    ) {
        this._Item_Buyers = _Item_Buyers;
        this._Item_Buyer_Share_Type = _Item_Buyer_Share_Type;
        this._Item_Name = _Item_Name;
        this._Item_Buy_Type = _Item_Buy_Type;
        this._Item_Buy_Count = _Item_Buy_Count;
        this._Item_Cost = _Item_Cost;
        this._Item_Discount = _Item_Discount;
        this._Item_Buy_Date = _Item_Buy_Date;
    }

    //Constructor Test!!!
    public Item_Model (
            Item_Buyer[] _Item_Buyers,
            Types.Item_Buyer_Types _Item_Buyer_Share_Type,
            String _Item_Name,
            Types.Item_Buy_Types _Item_Buy_Type,
            BigDecimal _Item_Buy_Count,
            BigDecimal _Item_Cost,
            BigDecimal _Item_Discount,
            String _Item_Buy_Date
    ) {
        this._Item_Buyers = new ArrayList<>();
        this._Item_Buyers.addAll(Arrays.asList(_Item_Buyers));
        this._Item_Buyer_Share_Type = _Item_Buyer_Share_Type;
        this._Item_Name = _Item_Name;
        this._Item_Buy_Type = _Item_Buy_Type;
        this._Item_Buy_Count = _Item_Buy_Count;
        this._Item_Cost = _Item_Cost;
        this._Item_Discount = _Item_Discount;
        this._Item_Buy_Date = _Item_Buy_Date;
    }

    //Constructor With Calculate Style
    public Item_Model (
            List<Item_Buyer> _Item_Buyers,
            Types.Item_Buyer_Types _Item_Buyer_Share_Type,
            String _Item_Name,
            Types.Item_Buy_Types _Item_Buy_Type,
            BigDecimal _Item_Buy_Count,
            BigDecimal _Item_Cost,
            BigDecimal _Item_Discount,
            String _Item_Buy_Date,
            Item_Calculate_Style _Item_Calculate_Type

    ) {
        this._Item_Buyers = _Item_Buyers;
        this._Item_Buyer_Share_Type = _Item_Buyer_Share_Type;
        this._Item_Name = _Item_Name;
        this._Item_Buy_Type = _Item_Buy_Type;
        this._Item_Buy_Count = _Item_Buy_Count;
        this._Item_Cost = _Item_Cost;
        this._Item_Discount = _Item_Discount;
        this._Item_Buy_Date = _Item_Buy_Date;
        this._Item_Calculate_Type = _Item_Calculate_Type;
    }
}

