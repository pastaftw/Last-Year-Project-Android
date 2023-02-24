package Main.Other;

//Common Modules
import java.util.List;
import java.math.BigDecimal;
import java.util.ArrayList;

//Custom Modules
import Main.Item.Item_Model;
import Main.Item.Item_Purpose;

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
    public void Add_Item(Integer buyer, String buy_date, String name, Types.Object_Buy_Types buy_type, Integer buy_count, BigDecimal cost, BigDecimal discount) {_Items.add(new Item_Model(buyer, buy_date, name, buy_type, buy_count, cost, discount));}
    public void Add_Purpose(Item_Model to, Types.Purpose_List_Types type, User user) {
        if (to.Purpose() == null) {
            Item_Purpose new_purpose = new Item_Purpose(type);
            new_purpose.Add_Related_User(user);
            to.Set_Purpose(new_purpose);
        }
        else if (to.Purpose() != null && to.Purpose().Type() == type) {to.Purpose().Add_Related_User(user);}
        else {throw new Error("Add_Purpose_Item_Fail");}
    }
}