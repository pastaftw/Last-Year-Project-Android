//Item_Edit - Controling Userlist

package Interface.Item;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ToggleButton;
import Common.Apply_Appearance;
import Common.Warning_Info;

public class Item_Edit_Users_Control {
    public Boolean Control(ViewGroup users_interface, EditText buy_count) {
        int child_count = users_interface.getChildCount();
        int selected_buy_count = Integer.valueOf(buy_count.getText().toString());
        int total_users_selected = 0;
        int total_buy_count = 0;

        for (int i = 0; i < child_count; i++) {
            ViewGroup child_layout = (ViewGroup) users_interface.getChildAt(i);
            ToggleButton targ_toggle = (ToggleButton) child_layout.getChildAt(0);
            EditText targ_edittext = (EditText) child_layout.getChildAt(1);
            Apply_Appearance.Select(targ_toggle, false);

            if (targ_toggle.isChecked()) {
                total_users_selected++;
                total_buy_count += Integer.valueOf(targ_edittext.getText().toString());
            }

            System.out.println(targ_toggle.getText() +  " -> " + targ_edittext.getText());
        }

        String warning_info = "";
        Context a = ((View)(users_interface)).getContext();
        Warning_Info warning_info_handler = new Warning_Info();

        Boolean result = true;

        if (selected_buy_count != total_buy_count) {
            //DOOOOO
            warning_info_handler.Create_Warning(a, (ViewGroup) users_interface.getParent(), "Buy Counts Are Not Matching!");
            result = false;
        }

       if (total_users_selected < 1) {
           //DOO
           warning_info_handler.Create_Warning(a, (ViewGroup) users_interface.getParent(), "Did you forget selecting a user?");
           result = false;
       }

       if (selected_buy_count > total_users_selected) {
           //DOO
           warning_info_handler.Create_Warning(a, (ViewGroup) users_interface.getParent(), "Something is not right about User list chooices!!");
           result = false;
       }
       return result;
    }
}
