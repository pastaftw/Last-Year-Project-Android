package Interface.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;

import java.util.List;

import Interface.Item.Handlers.Item_Edit_Confirm_Click;
import Interface.Item.Handlers.Item_Edit_Delete_Click;
import Processes.Item.Item_Model;
import Processes.Other.User;
import ae.ogrenci_usulu.R;
public class Item_Edit {

    public void Bring_Item_Add_Screen(Context context, ViewGroup container, List<User> user_list, List<Item_Model> item_list, Item_Model item_model, @Nullable View[] relations) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_model_view = interlater.inflate(R.layout.invoice_item_card_editing, null);

        Item_Edit_Extra extra_content = new Item_Edit_Extra();
        ViewGroup calculate_style_related_users_view = extra_content.Bring_Purpose_User_List(context, item_model_view, user_list);
        ViewGroup user_group_list_view = extra_content.Bring_User_List(context, item_model_view, user_list);

        //MULTI PRCS
        if (item_model != null) {
            Item_Converter.Convert_Item_Model("ToEditText", item_model_view, Item_Converter.Get_Item_Output(item_model));
            item_model_view.findViewById(R.id.invoice_item_card_editing_content_confirm_button).setOnClickListener(new Item_Edit_Confirm_Click(container, user_group_list_view, item_model_view, user_list, item_model, relations, true));
            //On Confirm Click
        }
        else {
            item_model_view.findViewById(R.id.invoice_item_card_editing_content_confirm_button).setOnClickListener(new Item_Edit_Confirm_Click(container, user_group_list_view, item_model_view, user_list, item_model, relations, false, item_list));
        }

        //On Delete Click
        item_model_view.findViewById(R.id.invoice_item_card_editing_content_dismiss_button).setOnClickListener(new Common.Dismiss_Button(container, item_model_view, relations));
        item_model_view.findViewById(R.id.invoice_item_card_editing_content_delete_button).setOnClickListener(new Item_Edit_Delete_Click(container, item_list, item_model, item_model_view, relations));
        extra_content.Bring_Item_Add_Screen_Extra(context, item_model_view, new ViewGroup[] {calculate_style_related_users_view});
        container.addView(item_model_view, 0);
    }
}
