package Interface;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import java.util.List;
import Processes.Item.Item_Model;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class Item_Adapter extends ArrayAdapter<Item_Model> {
    Context context;
    List<User> user_list;
    List<Item_Model> item_list;

    public Item_Adapter(Context context, List <User> user_list, List<Item_Model> item_list) {
        super(context, 0, item_list);
        this.context = context;
        this.user_list = user_list;
        this.item_list = item_list;
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
                //CALL FUNC
                a.Bring_Item_Add_Screen(getContext(), v, user_list, current_item_model,  new View[] {parent});
                notifyDataSetChanged();
            }
        });

        return item_model_view;
    }
}
