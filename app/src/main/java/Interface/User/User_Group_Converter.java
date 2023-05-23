package Interface.User;

import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import Common.TEST;
import Processes.Item.Item_Model;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class User_Group_Converter {
    //User Output
    public static String[] Get_User_Output(User user) {
        return new String[] {
                user.Name(),
                user.Surname(),
                user.Username(),
                //PROPS...
        };
    }

    public static User Convert_User_Group_Model_To_User(View item_view, List<User> user_list) {
        //Item Name
        EditText user_model_user_name_view = item_view.findViewById(R.id.invoice_user_card_editing_content_name);
        String user_model_user_name = user_model_user_name_view.getText().toString().trim();

        EditText user_model_user_surname_view = item_view.findViewById(R.id.invoice_user_card_editing_content_surname);
        String user_model_user_surname = user_model_user_surname_view.getText().toString().trim();

        EditText user_model_user_username_view = item_view.findViewById(R.id.invoice_user_card_editing_content_username);
        String user_model_username = user_model_user_username_view.getText().toString().trim();
        return new User (
                Common.TEST.user_id_index_start++,
                user_model_user_name,
                user_model_user_surname,
                user_model_username
        );
    }

    public static void Update_User_Group_Model(View parent, User targ_user_model, List<User> targ_user_list) {
        User new_item_model = Convert_User_Group_Model_To_User(parent, targ_user_list);
        System.out.println("ID::::::" + targ_user_model.ID());
        targ_user_model.Name(new_item_model.Name());
        targ_user_model.Surname(new_item_model.Surname());
        targ_user_model.Username(new_item_model.Username());
    }

    //User Converter
    public static void Convert_User_Model (String style, View parent, String[] user_output) {
        if (style.equals("ToTextView")) {
            ((TextView) parent.findViewById(R.id.invoice_user_card_content_name)).setText(user_output[0]);
            ((TextView) parent.findViewById(R.id.invoice_user_card_content_surname)).setText(user_output[1]);
            ((TextView) parent.findViewById(R.id.invoice_user_card_content_user_name_username)).setText(user_output[2]);
        }
        else if (style.equals("ToEditText")) {
            ((EditText) parent.findViewById(R.id.invoice_user_card_editing_content_name)).setText(user_output[0]);
            ((EditText) parent.findViewById(R.id.invoice_user_card_editing_content_surname)).setText(user_output[1]);
            ((EditText) parent.findViewById(R.id.invoice_user_card_editing_content_username)).setText(user_output[2]);
        }
    }
}
