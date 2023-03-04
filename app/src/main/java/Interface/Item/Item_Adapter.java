package Interface.Item;


import android.content.Context;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.List;

import Interface.Common;
import Processes.Item.Item_Model;
import ae.ogrenci_usulu.R;
import Interface.Item.Item_Converter;

public class Item_Adapter extends ArrayAdapter<Item_Model> {
    Context context;
    List<Item_Model> item_list = new ArrayList<>();

    public Item_Adapter(Context context, List<Item_Model> items) {
        super(context, 0, items);
        this.context = context;
        item_list = items;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item_model_view;
        item_model_view = convertView;
        Item_Model current_item_model = item_list.get(position);

        if(item_model_view == null) {
            item_model_view = LayoutInflater.from(context).inflate(R.layout.item_card, parent,false);
        }

        Item_Converter.Convert_Item_Model("ToTextView", item_model_view, Item_Converter.Get_Item_Output(current_item_model));

        //TEST
        //Common b = new Common();
        //On Item View Click
        item_model_view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ViewGroup v = (ViewGroup) view.getRootView().findViewById(R.id.item_list_main);
                parent.setVisibility(View.GONE);
                Item_Edit a = new Item_Edit();
                a.Bring_Item_Add_Screen(getContext(), v, current_item_model, new View[] {parent});
                notifyDataSetChanged();
            }
        });

        return item_model_view;
    }
}


/*
final Handler handler = new Handler();
handler.postDelayed(new Runnable() {
    @Override
    public void run() {}
}, 2000);
 */

/*
public class Item_Interface {
    public static int Get_ID_From_R(Context context, String type, String name) {
        return context.getResources().getIdentifier(name, type, context.getPackageName());
    }

    public void Add_Item_To_Layout(Context context, String layout_name, LinearLayout add_to, String[] item_model_output) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(Get_ID_From_R(context, "layout", layout_name), null);

        //Returning Indexes
        //Object Buyer: 0
        //Object Buy Date: 1
        //Object Name: 2
        //Object Buy Type: 3
        //Object Buy Count: 4
        //Object Cost: 5
        //Object Discount: 6
        //Object Purpose: 7

        //Giving Params
        ((TextView) view.findViewById(R.id.item_model_item_name)).setText(item_model_output[2]);
        ((TextView) view.findViewById(R.id.item_model_item_cost)).setText(item_model_output[5]);
        ((TextView) view.findViewById(R.id.item_model_item_buy_type)).setText(item_model_output[3]);
        ((TextView) view.findViewById(R.id.item_model_item_buy_count)).setText(item_model_output[4]);
        ((TextView) view.findViewById(R.id.item_model_item_discount)).setText(item_model_output[6]);
        ((TextView) view.findViewById(R.id.item_model_item_buyer)).setText(item_model_output[0]);
        ((TextView) view.findViewById(R.id.item_model_item_buy_date)).setText(item_model_output[1]);
        ((TextView) view.findViewById(R.id.item_model_PURPOSE_PLACE_HOLDER)).setText(item_model_output[7]);
        Edit_Item_Model edit_item_model_listener = new Edit_Item_Model("hALOW");
        view.setOnClickListener(edit_item_model_listener);
        add_to.addView(view);
    }
}
*/
