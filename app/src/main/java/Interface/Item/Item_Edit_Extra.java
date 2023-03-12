package Interface.Item;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import java.util.List;

import Common.Only_1_onClick;
import Processes.Other.Types;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class Item_Edit_Extra {
    public void Bring_Item_Add_Screen_Extra(Context context, View root, @Nullable ViewGroup[] relations) {
        ViewGroup item_purpose_container = root.findViewById(R.id.item_model_item_purpose_container_editing);
        ViewGroup item_buy_type_container = root.findViewById(R.id.item_model_item_buy_type_container_editing);
        ViewGroup item_buyer_container = root.findViewById(R.id.item_model_item_buyer_container_editing);

        //PURPOSE CONTAINER
        for (byte i = 0; i < Types.Purpose_List_Types.values().length; i++) {
            Button new_item_purpose_list_button = new Button(context);
            new_item_purpose_list_button.setText(Types.Purpose_List_Types.values()[i].name());
            new_item_purpose_list_button.setTextSize(20);

            //Giving Listener
            new_item_purpose_list_button.setOnClickListener(new Item_Edit_Purpose_Click(relations));
            //Defaults
            if (i == 0) {
                new_item_purpose_list_button.setSelected(true);
                relations[0].setVisibility(View.GONE);
            }
            //Adding ViewGroup
            item_purpose_container.addView(new_item_purpose_list_button);
        }

        //BUY TYPE CONTAINER
        for (byte i = 0; i < Types.Object_Buy_Types.values().length; i++) {
            Button new_item_buy_type_button = new Button(context);
            new_item_buy_type_button.setText(Types.Object_Buy_Types.values()[i].name());
            new_item_buy_type_button.setTextSize(20);

            //Giving Listener
            new_item_buy_type_button.setOnClickListener(new Only_1_onClick());
            //Defaults
            if (i == 0) {new_item_buy_type_button.setSelected(true);}
            //Adding ViewGroup
            item_buy_type_container.addView(new_item_buy_type_button);
        }

        //BUYER CONTAINER
        for (byte i = 0; i < Types.Item_Buyer_Types.values().length; i++) {
            Button new_item_buyer_button = new Button(context);
            new_item_buyer_button.setText(Types.Item_Buyer_Types.values()[i].name());
            new_item_buyer_button.setTextSize(20);

            //Giving Listener
            new_item_buyer_button.setOnClickListener(new Only_1_onClick());
            //Seting Default
            if (i == 0) {new_item_buyer_button.setSelected(true);}
            //Adding ViewGroup
            item_buyer_container.addView(new_item_buyer_button);
        }
    }

    public ViewGroup Bring_Purpose_User_List(Context context, View root, List<User> user_list) {
        ViewGroup v = root.findViewById(R.id.item_model_users_container_editing);
        for(int i = 0; i < user_list.size(); i++) {
            ToggleButton a = new ToggleButton(context);
            a.setText(user_list.get(i).Name() + " (" + user_list.get(i).Username()+")");
            a.setTextOn(user_list.get(i).Name() + " (" + user_list.get(i).Username()+")" + ": Seçildi");
            a.setTextOff(user_list.get(i).Name() + " (" + user_list.get(i).Username()+")");
            v.addView(a);
            //onclick ++++++++
        }
        return v;
    }
}
