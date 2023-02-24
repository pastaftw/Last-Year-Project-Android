package Interface;

//Common Imports
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import org.w3c.dom.Text;

import Processes.Item.Item_Model;
import ae.ogrenci_usulu.R;

public class Item_Interface {
    public static int Get_ID_From_R(Context context, String type, String name) {
        return context.getResources().getIdentifier(name, type, context.getPackageName());
    }

    public void Add_Item_To_Layout(Context context, String layout_name, LinearLayout add_to, String[] item_model_output) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(Get_ID_From_R(context, "layout", layout_name), null);
        /*
        Returning Indexes
        Object Buyer: 0
        Object Buy Date: 1
        Object Name: 2
        Object Buy Type: 3
        Object Buy Count: 4
        Object Cost: 5
        Object Discount: 6
        Object Purpose: 7
        */

        //Giving Params
        ((TextView) view.findViewById(R.id.item_model_item_name)).setText(item_model_output[2]);
        ((TextView) view.findViewById(R.id.item_model_item_cost)).setText(item_model_output[5]);
        ((TextView) view.findViewById(R.id.item_model_item_buy_type)).setText(item_model_output[3]);
        ((TextView) view.findViewById(R.id.item_model_item_buy_count)).setText(item_model_output[4]);
        ((TextView) view.findViewById(R.id.item_model_item_discount)).setText(item_model_output[6]);
        ((TextView) view.findViewById(R.id.item_model_item_buyer)).setText(item_model_output[0]);
        ((TextView) view.findViewById(R.id.item_model_item_buy_date)).setText(item_model_output[1]);
        ((TextView) view.findViewById(R.id.item_model_PURPOSE_PLACE_HOLDER)).setText(item_model_output[7]);

        add_to.addView(view);
    }
}
