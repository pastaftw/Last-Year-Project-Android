//Item_Edit - User Toggle Button Click Handler

package Interface.Item.Handlers;
import android.view.View;
import android.widget.ToggleButton;
import Common.Apply_Appearance;

public class Item_Edit_User_Click implements View.OnClickListener {
    //Properties
    View[] relations;

    //Constructors
    public  Item_Edit_User_Click() {}
    public Item_Edit_User_Click (View[] relations) {this.relations = relations;}

    //Override Default
    @Override
    public void onClick(View view) {
        ToggleButton current_button = (ToggleButton) view;
        if (!current_button.isChecked()) {
            //Customize Relations
            if (relations != null) {relations[0].setEnabled(false);}
            Apply_Appearance.Select(current_button, false);
        }
        else {
            //Customize Relations
            if (relations != null) {relations[0].setEnabled(true);}
            Apply_Appearance.Select(current_button, true);
        }
    }
}
