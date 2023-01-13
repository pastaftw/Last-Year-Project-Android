package App_Basis.Item;

//Common Modules
import java.util.List;
import java.util.ArrayList;

//Custom Modules
import App_Basis.User;
import App_Basis.Types.Purpose_List_Types;

public class Item_Purpose {
    //Variables
    List <User> _Related_Users = new ArrayList<>();
    Purpose_List_Types _Type;

    //Constructor
    public Item_Purpose(Purpose_List_Types value) {_Type = value;}

    //Properties
    public Purpose_List_Types Type() {return _Type;}
    public void Set_Type(Purpose_List_Types value) {_Type = value;}
    public List <User> Releated_Users() {return _Related_Users;}

    //Functions
    public void Add_Related_User(User value) {_Related_Users.add(value);}
}
