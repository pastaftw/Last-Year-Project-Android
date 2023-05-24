//Handles Item Edit Confirm Click
package Interface.Item.Handlers;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Interface.Item.Item_Converter;
import Interface.Item.Item_Edit_Users_Control;
import Processes.Item.Item_Model;
import Processes.Other.User;

public class Item_Edit_Confirm_Click implements View.OnClickListener {
    //Values
    ViewGroup container;
    ViewGroup user_group;
    View item_model_view;
    List <User> user_list;
    Item_Model item_model;
    View[] relations;
    Item_Edit_Users_Control item_edit_users_control = new Item_Edit_Users_Control();

    //Constructor
    public Item_Edit_Confirm_Click(ViewGroup container, ViewGroup user_group, View item_model_view, List<User> user_list, Item_Model item_model, View[] relations) {
        this.container = container;
        this.user_group = user_group;
        this.item_model_view = item_model_view;
        this.user_list = user_list;
        this.item_model = item_model;
        this.relations = relations;
    }

    //Overriding Default
    @Override
    public void onClick(View targ_view){
        if (item_edit_users_control.Control(user_group, item_model)) {
            Item_Converter.Convert_Item_View_To_Item_Model(item_model_view, user_list);
            Item_Converter.Update_Item_Model(item_model_view, item_model, user_list);
            relations[0].setVisibility(View.VISIBLE);
            container.removeView(item_model_view);
        }
    }
}
