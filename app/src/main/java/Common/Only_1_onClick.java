package Common;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import androidx.annotation.Nullable;

public class Only_1_onClick implements View.OnClickListener {
    @Override
    public void onClick(View view) {
        ViewGroup parent = (ViewGroup) view.getParent();
        Button current_button = (Button) view;

        for (int i = 0; i < parent.getChildCount(); i++) {
            Button targ_button = (Button) parent.getChildAt(i);
            targ_button.setBackgroundColor(Color.GRAY);
            targ_button.setClickable(true);
            targ_button.setSelected(false);
        }

        current_button.setBackgroundColor(Color.YELLOW);
        current_button.setClickable(false);
        current_button.setSelected(true);
    }
}
