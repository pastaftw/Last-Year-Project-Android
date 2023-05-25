//Handles Item Edit Confirm Click
package Interface.User.Handlers;

import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import java.util.List;

import Interface.Item.Item_Converter;
import Interface.Item.Item_Edit_Users_Control;
import Interface.User.User_Group_Converter;
import Processes.Item.Item_Model;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class User_Group_Edit_Confirm_Click implements View.OnClickListener {
    //Values
    ViewGroup container;
    User targ_user;
    View user_model_view;
    List <User> user_list;
    View[] relations;
    Item_Edit_Users_Control item_edit_users_control = new Item_Edit_Users_Control();
    Boolean upd;

    //Constructor
    public User_Group_Edit_Confirm_Click(ViewGroup container, List<User> user_list, User targ_user, View user_model_view, View[] relations, boolean upd) {
        this.container = container;
        //this.user_model_view = user_model_view;
        this.targ_user = targ_user;
        this.user_model_view = user_model_view;
        this.user_list = user_list;
        this.relations = relations;
        this.upd = upd;
    }

    //Overriding Default
    @Override
    public void onClick(View targ_view){
        User_Group_Converter.Convert_User_Group_Model_To_User(user_model_view,user_list);
        if (upd) {
            User_Group_Converter.Update_User_Group_Model(user_model_view, targ_user, user_list);
        }
        else {
            User_Group_Converter.Create_User_Group_Model(user_model_view, targ_user, user_list);
        }
        ((ViewGroup)(relations[0].getParent())).setVisibility(View.VISIBLE);
        container.removeView(user_model_view);
    }
}
