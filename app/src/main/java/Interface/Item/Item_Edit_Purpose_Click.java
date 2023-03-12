package Interface.Item;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.Nullable;
import Common.Only_1_onClick;

public class Item_Edit_Purpose_Click extends Only_1_onClick {
    ViewGroup[] relations;
    public Item_Edit_Purpose_Click(ViewGroup[] relations) {this.relations = relations;}

    @Override
    public void onClick(View view) {
        super.onClick(view);

        Button current_button = (Button) view;
        ViewGroup parent = (ViewGroup) view.getParent();
        Boolean relations_visible = false;

        for (int i = 0; i < parent.getChildCount(); i++) {
            Button targ_button = (Button) parent.getChildAt(i);
            if (targ_button.getText().equals(current_button.getText()) && i != 0) {
                relations_visible = true;
            }
        }

        //Customize Relations
        if (relations_visible) {relations[0].setVisibility(View.VISIBLE);}
        else {relations[0].setVisibility(View.GONE);}
    }
}
