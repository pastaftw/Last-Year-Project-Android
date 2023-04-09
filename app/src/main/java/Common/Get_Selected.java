//Returning From Selected Button (or Buttons) From Views

package Common;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ToggleButton;
import java.util.ArrayList;
import java.util.List;

public class Get_Selected {

    //Getting A Selected Buttons Text From A Parent
    public static String Only_One_From_Parent(ViewGroup parent) {
        for (int i = 0; i < parent.getChildCount(); i++) {
            Button targ_button = (Button) parent.getChildAt(i);
            if (targ_button.isSelected()) {
                return targ_button.getText().toString();
            }
        }
        return null;
    }

    //Getting Selected Buttons Indexes
    /*
    public static List<Integer> List_From_Parent(ViewGroup parent) {
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < parent.getChildCount(); i++) {
            ToggleButton targ_button = (ToggleButton) parent.getChildAt(i);
            if (targ_button.isChecked()) {
                result.add(i);
            }
        }
        return result;
    }
     */
}
