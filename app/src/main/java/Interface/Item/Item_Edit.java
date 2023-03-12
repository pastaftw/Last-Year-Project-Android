package Interface.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;
import android.widget.ToggleButton;

import androidx.annotation.Nullable;

import java.util.List;

import Common.Only_1_onClick;
import Processes.Item.Item_Model;
import Processes.Other.Types;
import Processes.Other.User;
import ae.ogrenci_usulu.R;
public class Item_Edit {

    public void Bring_Item_Add_Screen(Context context, ViewGroup container, List<User> user_list, Item_Model item_model, @Nullable View[] relations) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_model_view = interlater.inflate(R.layout.item_card_edit, null);
        Item_Edit_Extra extra_content = new Item_Edit_Extra();

        ViewGroup a = extra_content.Bring_Purpose_User_List(context, item_model_view, user_list);
        Item_Converter.Convert_Item_Model("ToEditText", item_model_view, Item_Converter.Get_Item_Output(item_model));
        extra_content.Bring_Item_Add_Screen_Extra(context, item_model_view, new ViewGroup[] {a});
        //layout kontrolleri dizi
        //[] tek tek çağrılıp türüne bakılması try catch ile


        //On Item Click
        item_model_view.findViewById(R.id.item_model_button_editing)
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
