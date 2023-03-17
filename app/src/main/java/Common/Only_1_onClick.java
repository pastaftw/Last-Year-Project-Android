//Only 1 Button Click Per Parent

package Common;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class Only_1_onClick implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        ViewGroup parent = (ViewGroup) view.getParent();
        Button current_button = (Button) view;

        for (int i = 0; i < parent.getChildCount(); i++) {
            Button targ_button = (Button) parent.getChildAt(i);
            Apply_Appearance.Select(targ_button, false);
            targ_button.setClickable(true);
            targ_button.setSelected(false);
        }

        Apply_Appearance.Select(current_button, true);
        current_button.setClickable(false);
        current_button.setSelected(true);
    }
}
