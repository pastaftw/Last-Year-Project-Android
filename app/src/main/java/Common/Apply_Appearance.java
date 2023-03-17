//Appearance Module For Views

package Common;
import android.view.View;
import android.graphics.Color;

public class Apply_Appearance {
    public static void Select(View target_view, Boolean is_seleceted) {
        if (is_seleceted) {target_view.setBackgroundColor(Color.rgb(0, 255 , 255));}
        else {target_view.setBackgroundColor(Color.GRAY);}
    }
}
