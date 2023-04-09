package Interface.Item.Handlers;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Processes.Item.Item_Model;

public class Item_Edit_Delete_Click implements View.OnClickListener {
    //Values
    ViewGroup parent;
    List<Item_Model> item_list;
    Item_Model target_item;
    View item_model_view;
    View[] relations;

    //Constructor
    public Item_Edit_Delete_Click(ViewGroup parent, List<Item_Model> item_list, Item_Model target_item, View item_model_view, View[] relations) {
        this.parent = parent;
        this.item_list = item_list;
        this.target_item = target_item;
        this.item_model_view = item_model_view;
        this.relations = relations;
    }

    //Overriding Default
    public void onClick(View target_view) {
        item_list.remove(target_item);
        parent.removeView(item_model_view);
        relations[0].setVisibility(View.VISIBLE);
    }
}
