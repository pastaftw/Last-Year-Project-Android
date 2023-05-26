package Interface;

import android.content.Context;
import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import androidx.annotation.Nullable;

import java.util.List;

import Interface.Item.Item_Adapter;
import Interface.Item.Item_Converter;
import Interface.Item.Item_Edit;
import Interface.User.User_Group_Adapter;
import Interface.User.User_Group_Edit;
import Processes.Item.Item_Model;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class Interface_Master {
    public static void Prepare_Invoice_Menu(Context context, ViewGroup[] parent, List<User> user_group, List<Item_Model> items) {
        //User Group
        View invoice_menu_user_group_container = LayoutInflater.from(context).inflate(R.layout.invoice_user_cards_container, null);
        parent[0].addView(invoice_menu_user_group_container);
        ViewGroup invoice_menu_user_group_view = parent[0].findViewById(R.id.invoice_user_cards_container_content);
        ListView invoice_menu_user_group_view_container = invoice_menu_user_group_view.findViewById(R.id.invoice_user_cards_container_content);
        User_Group_Adapter item_model_list_adapter = new User_Group_Adapter(context, user_group, items);
        invoice_menu_user_group_view_container.setAdapter(item_model_list_adapter);

        //Item_Model
        View invoice_menu_iten_cards_container = LayoutInflater.from(context).inflate(R.layout.invoice_item_cards_container, null);
        parent[1].addView(invoice_menu_iten_cards_container);
        ViewGroup invoice_menu_item_model_view_container = parent[1].findViewById(R.id.invoice_item_cards_container_content);
        ListView invoice_menu_item_model_view = invoice_menu_item_model_view_container.findViewById(R.id.invoice_item_cards_container_content);
        Item_Adapter invoice_menu_item_model_list_adapter = new Item_Adapter(context, user_group, items);
        invoice_menu_item_model_view.setAdapter(invoice_menu_item_model_list_adapter);

        //Add Buttons
        invoice_menu_iten_cards_container.findViewById(R.id.invoice_item_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Item_Edit a = new Item_Edit();
                a.Bring_Item_Add_Screen(context, (ViewGroup) invoice_menu_iten_cards_container, user_group, items, null, new ViewGroup[]{invoice_menu_item_model_view});
            }
        });

        invoice_menu_user_group_container.findViewById(R.id.invoice_user_add).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                User_Group_Edit a = new User_Group_Edit();
                a.Bring_User_Edit_Screen(context, (ViewGroup) invoice_menu_user_group_container, null, user_group, new ViewGroup[]{invoice_menu_user_group_view}, items);
            }
        });
    }

    public static void Show_Targeted_Menu(View parent, Integer targ) {
        ViewGroup invoice_menu_user_group_view = parent.findViewById(R.id.invoice_menu_user_group_content);
        ViewGroup invoice_menu_item_model_view = parent.findViewById(R.id.invoice_menu_items_content);

        while (parent.findViewById(R.id.invoice_result_container_main) != null) {
            ((ViewGroup)parent).removeView(parent.findViewById(R.id.invoice_result_container_main));
        }

        /*
        if (parent.findViewById(R.id.invoice_result_container_main) != null) {
            ((ViewGroup)parent).removeView(parent.findViewById(R.id.invoice_result_container_main));
        }*/

        invoice_menu_item_model_view.setVisibility(View.GONE);
        invoice_menu_user_group_view.setVisibility(View.GONE);

        if (targ == R.id.invoice_menu_user_group_content) {
            invoice_menu_item_model_view.setVisibility(View.GONE);
            invoice_menu_user_group_view.setVisibility(View.VISIBLE);
        }
        else if (targ == R.id.invoice_menu_items_content) {
            invoice_menu_user_group_view.setVisibility(View.GONE);
            invoice_menu_item_model_view.setVisibility(View.VISIBLE);
        }
        else if (targ == -1) {
            invoice_menu_user_group_view.setVisibility(View.GONE);
            invoice_menu_item_model_view.setVisibility(View.GONE);
        }
    }
}
