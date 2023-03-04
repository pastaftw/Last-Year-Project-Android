package Interface;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;


public class Common {
    public void Add_Layout(Context context, View container_view, int insert_this) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        ViewGroup insert_point = (ViewGroup) container_view;
        View v = interlater.inflate(insert_this, null);
        insert_point.addView(v, 0);
        //new ViewGroup.LayoutParams(/*ViewGroup.LayoutParams.FILL_PARENT, ViewGroup.LayoutParams.FILL_PARENT)*/)
    }
}
