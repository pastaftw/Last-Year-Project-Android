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

    //Constructor
    public User_Group_Edit_Confirm_Click(ViewGroup container, List<User> user_list, User targ_user, View user_model_view, View[] relations) {
        this.container = container;
        //this.user_model_view = user_model_view;
        this.targ_user = targ_user;
        this.user_model_view = user_model_view;
        this.user_list = user_list;
        this.relations = relations;
    }

    //Overriding Default
    @Override
    public void onClick(View targ_view){
        User_Group_Converter.Convert_User_Group_Model_To_User(user_model_view,user_list);
        //User_Group_Converter.Convert_User_Model("ToEditText", user_model_view, User_Group_Converter.Get_User_Output(targ_user));
        User_Group_Converter.Update_User_Group_Model(user_model_view, targ_user, user_list);
        //System.out.println("Update" + targ_user.ID()+ " " + targ_user.Name() + " " + targ_user.Surname() + " " +  targ_user.Username());

        container.removeView(user_model_view);
        relations[0].setVisibility(View.VISIBLE);
        /*
        Item_Converter.Convert_Item_View_To_Item_Model(item_model_view, user_list);
        Item_Converter.Update_Item_Model(item_model_view, item_model, user_list);
        container.removeView(item_model_view);
        relations[0].setVisibility(View.VISIBLE);
         */
    }
}
