//Inserting Warnings & Errors On Targeted ViewGroup
//Update situations later

package Common;
import android.content.Context;
import android.graphics.Color;
import android.view.ViewGroup;
import android.widget.TextView;

public class Warning_Info {
    public void Create_Warning(Context context, ViewGroup target, String message) {
        TextView new_textview = new TextView(context);
        new_textview.setText("WARNING_HOLDER: " + message);
        new_textview.setBackgroundColor(Color.rgb(255, 0, 0));
        new_textview.setTextColor(Color.rgb(255, 255, 255));
        new_textview.setTextSize(20);
        target.addView(new_textview);
    }
}
