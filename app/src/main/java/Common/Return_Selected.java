package Common;

import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import java.util.ArrayList;
import java.util.List;

public class Return_Selected {
    public static String From_Parent(ViewGroup parent) {
        @Nullable String result = "";
        for (int i = 0; i < parent.getChildCount(); i++) {
            Button targ_button = (Button) parent.getChildAt(i);
            if (targ_button.isSelected()) {
                result = targ_button.getText().toString();
                break;
            }
        }
        return result;
    }
    public static List<Integer> From_Parent_As_List(ViewGroup parent) {
        List<Integer> result = new ArrayList();
        for (int i = 0; i < parent.getChildCount(); i++) {
            ToggleButton targ_button = (ToggleButton) parent.getChildAt(i);
            if (targ_button.isChecked()) {
                result.add(i);
            }
        }
        return result;
    }
}
