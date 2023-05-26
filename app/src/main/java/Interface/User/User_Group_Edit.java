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
import Interface.User.Handlers.User_Group_Edit_Confirm_Click;
import Interface.User.Handlers.User_Group_Edit_Delete_Click;
import Processes.Item.Item_Model;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class User_Group_Edit {
    public void Bring_User_Edit_Screen(Context context, ViewGroup container, User targ_user, List<User> user_list, @Nullable View[] relations, List<Item_Model> item_list) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View user_group_view = interlater.inflate(R.layout.invoice_user_card_editing, null);

        //Clicks
        //Item_Converter.Convert_Item_Model("ToEditText", item_model_view, Item_Converter.Get_Item_Output(item_model));
        if (targ_user != null) {
            User_Group_Converter.Convert_User_Model("ToEditText", user_group_view, User_Group_Converter.Get_User_Output(targ_user));
            user_group_view.findViewById(R.id.invoice_user_card_editing_content_confirm_button).setOnClickListener(new User_Group_Edit_Confirm_Click(container, user_list, targ_user, user_group_view, relations, true));
        }
        else {
            user_group_view.findViewById(R.id.invoice_user_card_editing_content_confirm_button).setOnClickListener(new User_Group_Edit_Confirm_Click(container, user_list, targ_user, user_group_view, relations, false));
        }

        //relations[0].setVisibility(View.INVISIBLE);
        //((ViewGroup)(relations[0].getParent())).setVisibility(View.INVISIBLE);
        user_group_view.findViewById(R.id.invoice_user_card_editing_content_dismiss_button).setOnClickListener(new Common.Dismiss_Button(container, user_group_view, relations));
        user_group_view.findViewById(R.id.invoice_user_card_editing_content_delete_button).setOnClickListener(new User_Group_Edit_Delete_Click(container, user_group_view, item_list, user_list, targ_user, relations));
        container.addView(user_group_view, 0);
    }
}
