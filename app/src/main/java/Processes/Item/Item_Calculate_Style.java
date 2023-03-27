package Processes.Item;

//Common Modules

import java.util.ArrayList;
import java.util.List;

import Processes.Other.Types.Item_Calculate_Types;
import Processes.Other.User;

public class Item_Calculate_Style {
    Item_Calculate_Types _Type;
    List <User> _Related_Users = new ArrayList<>();


    //Constructor
    public Item_Calculate_Style(Item_Calculate_Types value) {_Type = value;}

    //Properties
    public Item_Calculate_Types Type() {return _Type;}
    public void Set_Type(Item_Calculate_Types value) {_Type = value;}
    public List <User> Get_Releated_Users() {return _Related_Users;}

    //Functions
    public void Add_Related_User(User value) {_Related_Users.add(value);}
    public void Add_All_Related_Users(List<User> value) {
        _Related_Users.clear();
        _Related_Users = value;
    }
}
