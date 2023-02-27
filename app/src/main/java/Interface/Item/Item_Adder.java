package Interface.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import Processes.Item.Item_Model;
import ae.ogrenci_usulu.R;
import Interface.Item.Item_Converter;

public class Item_Adder {
    public void Bring_Item_Add_Screen(Context context, ViewGroup container, Item_Model item_model, View[] relations) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_model_view = interlater.inflate(R.layout.item_card_edit, null);
        Item_Converter.Convert_Item_Model("ToEditText", item_model_view, Item_Converter.Get_Item_Output(item_model));
        ((Button)item_model_view.findViewById(R.id.item_model_button_editing))
                .setOnClickListener(
                        new View.OnClickListener() {
                                                      @Override
                                                      public void onClick(View view) {
                                                          Item_Converter.Update_Item_Model(item_model_view, item_model);
                                                          ((ViewGroup)view.getParent()).removeAllViews();
                                                          relations[0].setVisibility(View.VISIBLE);
                                                      }
        });
        container.addView(item_model_view, 0);
    }
}
