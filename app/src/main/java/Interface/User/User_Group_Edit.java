package Interface.User;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.List;

import Interface.Item.Handlers.Item_Edit_Confirm_Click;
import Interface.Item.Handlers.Item_Edit_Delete_Click;
import Interface.Item.Item_Converter;
import Interface.Item.Item_Edit_Extra;
import Interface.Item.Item_Edit_Users_Control;
import Processes.Item.Item_Model;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class User_Group_Edit {
    public void Bring_User_Edit_Screen(Context context, ViewGroup container, List<User> user_list, @Nullable View[] relations) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View user_group_view = interlater.inflate(R.layout.invoice_user_card_editing, null);
        container.addView(user_group_view, 0);

        //Item_Edit_Extra extra_content = new Item_Edit_Extra();
        /*
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_model_view = interlater.inflate(R.layout.invoice_item_card_editing, null);
        Item_Edit_Extra extra_content = new Item_Edit_Extra();

        ViewGroup calculate_style_related_users_view = extra_content.Bring_Purpose_User_List(context, item_model_view, user_list);
        Item_Converter.Convert_Item_Model("ToEditText", item_model_view, Item_Converter.Get_Item_Output(item_model));
        extra_content.Bring_Item_Add_Screen_Extra(context, item_model_view, new ViewGroup[] {calculate_style_related_users_view});

        //layout kontrolleri dizi
        //[] tek tek çağrılıp türüne bakılması try catch ile
        ViewGroup user_group_list_view = extra_content.Bring_User_List(context, item_model_view, user_list);
        Item_Edit_Users_Control n = new Item_Edit_Users_Control();

        //On Confirm Click
        item_model_view.findViewById(R.id.invoice_item_card_editing_content_confirm_button).setOnClickListener(new Item_Edit_Confirm_Click(container, user_group_list_view, item_model_view, user_list, item_model, relations));
        //On Delete Click
        item_model_view.findViewById(R.id.invoice_item_card_editing_content_delete_button).setOnClickListener(new Item_Edit_Delete_Click(container, item_list, item_model, item_model_view, relations));
        container.addView(item_model_view, 0);
        */
    }
}
