package Interface.User;

import android.view.View;
import android.widget.TextView;

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

    //User Converter
    public static void Convert_User_Model (String style, View parent, String[] user_output) {
        if (style.equals("ToTextView")) {
            ((TextView) parent.findViewById(R.id.invoice_user_card_content_name)).setText(user_output[0]);
            ((TextView) parent.findViewById(R.id.invoice_user_card_content_surname)).setText(user_output[1]);
            ((TextView) parent.findViewById(R.id.invoice_user_card_content_user_name_username)).setText(user_output[2]);
        }
    }
}
