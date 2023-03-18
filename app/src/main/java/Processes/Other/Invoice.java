package Processes.Other;

//Common Modules

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import Processes.Item.Item_Model;
import Processes.Item.Item_Calculate_Style;

public class Invoice {
    //Variables
    List <User> _Users = new ArrayList<>();
    List <Item_Model> _Items = new ArrayList<>();

    //Properties
    public List <User> Users() {return _Users;}
    public  List <Item_Model> Items() {return _Items;}

    //Functions
    public void Add_User(User user) {_Users.add(user);}
    public void Add_User(Integer id, String name, String surname, String username) {_Users.add(new User(id, name, surname, username));}
    public void Add_Item (Item_Model item) {_Items.add(item);}
    public void Add_Purpose(Item_Model to, Types.Item_Calculate_Types type, User user) {
        if (to.Get_Calculate_Style() == null) {
            Item_Calculate_Style new_purpose = new Item_Calculate_Style(type);
            new_purpose.Add_Related_User(user);
            to.Set_Calculate_Style(new_purpose);
        }
        else if (to.Get_Calculate_Style() != null && to.Get_Calculate_Style().Type() == type) {to.Get_Calculate_Style().Add_Related_User(user);}
        else {throw new Error("Add_Purpose_Item_Fail");}
    }
}