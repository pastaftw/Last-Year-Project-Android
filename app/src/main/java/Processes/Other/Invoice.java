package Processes.Other;

//Common Modules

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import Processes.Item.Item_Model;
import Processes.Item.Item_Calculate_Style;

public class Invoice {
    //Values
    List <User> _User_Group = new ArrayList<>();
    List <Item_Model> _Items = new ArrayList<>();


    //User Group
    public List <User> Get_Users() {return _User_Group;}
    public void Add_User(User user) {_User_Group.add(user);}
    public void Set_All_Users(List <User> value) {
        _User_Group.clear();
        _User_Group.addAll(value);
    }
    public void Set_All_Users(User[] value) {
        _User_Group.clear();
        _User_Group.addAll(Arrays.asList(value));
    }

    //Items
    public List <Item_Model> Get_Items() {return _Items;}
    public void Add_Item (Item_Model item) {_Items.add(item);}
    public void Set_All_Items(List <Item_Model> value) {
        _Items.clear();
        _Items.addAll(value);
    }
    public void Set_All_Items(Item_Model[] value) {
        _Items.clear();
        _Items.addAll(Arrays.asList(value));
    }
}