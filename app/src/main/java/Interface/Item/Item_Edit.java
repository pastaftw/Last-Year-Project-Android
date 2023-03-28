package Interface.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.Nullable;

import java.util.List;

import Processes.Item.Item_Model;
import Processes.Other.User;
import ae.ogrenci_usulu.R;
public class Item_Edit {

    public void Bring_Item_Add_Screen(Context context, ViewGroup container, List<User> user_list, Item_Model item_model, @Nullable View[] relations) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_model_view = interlater.inflate(R.layout.invoice_item_card_editing, null);
        Item_Edit_Extra extra_content = new Item_Edit_Extra();

        ViewGroup a = extra_content.Bring_Purpose_User_List(context, item_model_view, user_list);
        Item_Converter.Convert_Item_Model("ToEditText", item_model_view, Item_Converter.Get_Item_Output(item_model));
        extra_content.Bring_Item_Add_Screen_Extra(context, item_model_view, new ViewGroup[] {a});

        //layout kontrolleri dizi
        //[] tek tek çağrılıp türüne bakılması try catch ile
        ViewGroup test = extra_content.Bring_User_List(context, item_model_view, user_list);
        Item_Edit_Users_Control n = new Item_Edit_Users_Control();


        //On Item Click
        item_model_view.findViewById(R.id.invoice_item_card_editing_confirm_button)
                .setOnClickListener(
                        new View.OnClickListener() {
                            //FOR NOW IT'S LIKE THAT BUT I'lL MODULE THIS LATER
                                                      @Override
                                                      public void onClick(View view) {
                                                          Boolean result = n.Control(test);
                                                          if (result) {
                                                              Item_Converter.Convert_Item_View_To_Item_Model(item_model_view, user_list);
                                                              Item_Converter.Update_Item_Model(item_model_view, item_model, user_list);
                                                              container.removeView(item_model_view);
                                                              relations[0].setVisibility(View.VISIBLE);
                                                          }
                                                      }
        });

        container.addView(item_model_view, 0);
    }
}
