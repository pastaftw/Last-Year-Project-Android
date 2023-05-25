package Interface.User.Handlers;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Processes.Item.Item_Buyer;
import Processes.Item.Item_Model;
import Processes.Other.User;

public class User_Group_Edit_Delete_Click implements View.OnClickListener {
    //Values
    ViewGroup parent;
    List<Item_Model> item_list;
    List<User> user_list;
    User user;
    View user_group_view;
    View[] relations;

    //Constructor
    public User_Group_Edit_Delete_Click(ViewGroup parent, View user_group_view, List<Item_Model> item_list, List<User> user_list, User user, View[] relations) {
        this.parent = parent;
        this.item_list = item_list;
        this.user_list = user_list;
        this.user = user;
        this.user_group_view = user_group_view;
        this.relations = relations;
    }

    //Overriding Default
    public void onClick(View target_view) {
        int targ_id = user.ID();

        //fix user delete temp
        item_list.forEach(item -> {
            List <Item_Buyer> ib = item.Get_Buyers();
            for (int i = ib.size() - 1; i >= 0; i--) {
                if (ib.get(i).Get_Buyer().ID() == targ_id) {
                   ib.remove(i);
                   System.out.println("R:" + i);
                }
            };
        });

        user_list.remove(user);
        System.out.println("USER:" + user.Name());
        parent.removeView(user_group_view);
        ((ViewGroup)(relations[0].getParent())).setVisibility(View.VISIBLE);
    }
}
