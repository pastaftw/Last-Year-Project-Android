package Interface.Item;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TableLayout;

import Processes.Item.Item_Model;
import ae.ogrenci_usulu.R;
import Processes.Other.Types;

public class Item_Edit {
    void Bring_Item_Add_Screen_Extra(String style, Context context, View root, int targ_container) {
        ViewGroup view = root.findViewById(targ_container);

        if (style == "Purpose") {
            for (byte i = 0; i < Types.Purpose_List_Types.values().length; i++) {
                RadioButton new_button = new RadioButton(context);
                new_button.setText(Types.Purpose_List_Types.values()[i].name());


                //TESTING!!
                RadioGroup.LayoutParams new_button_params = new RadioGroup.LayoutParams(
                        TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT
                );


                new_button_params.weight = 0;
                new_button_params.gravity = 1;
                new_button.setTextSize(20);

                //FINAL
                new_button.setLayoutParams(new_button_params);
                view.addView(new_button);

                //Seting Default
                if (i == 0) {new_button.setChecked(true);}
            }
        }
        else if (style == "Buy") {
            for (byte i = 0; i < Types.Object_Buy_Types.values().length; i++) {
                RadioButton new_button = new RadioButton(context);
                new_button.setText(Types.Object_Buy_Types.values()[i].name());


                //TESTING!!
                RadioGroup.LayoutParams new_button_params = new RadioGroup.LayoutParams(
                        TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT
                );


                new_button_params.weight = 0;
                new_button_params.gravity = 1;
                new_button.setTextSize(20);

                //FINAL
                new_button.setLayoutParams(new_button_params);
                view.addView(new_button);

                //Seting Default
                if (i == 0) {new_button.setChecked(true);}
            }
        }
        else if (style == "Buyer") {
            for (byte i = 0; i < Types.Item_Buyer_Types.values().length; i++) {
                RadioButton new_button = new RadioButton(context);
                new_button.setText(Types.Item_Buyer_Types.values()[i].name());


                //TESTING!!
                RadioGroup.LayoutParams new_button_params = new RadioGroup.LayoutParams(
                        TableLayout.LayoutParams.WRAP_CONTENT,
                        TableLayout.LayoutParams.WRAP_CONTENT
                );


                new_button_params.weight = 0;
                new_button_params.gravity = 1;
                new_button.setTextSize(20);

                //FINAL
                new_button.setLayoutParams(new_button_params);
                view.addView(new_button);

                //Seting Default
                if (i == 0) {new_button.setChecked(true);}
            }
        }
    }

    public void Bring_Item_Add_Screen(Context context, ViewGroup container, Item_Model item_model, View[] relations) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View item_model_view = interlater.inflate(R.layout.item_card_edit, null);
        Item_Converter.Convert_Item_Model("ToEditText", item_model_view, Item_Converter.Get_Item_Output(item_model));
        Bring_Item_Add_Screen_Extra("Buy", context, item_model_view, R.id.item_model_item_buy_type_container_editing);
        Bring_Item_Add_Screen_Extra("Purpose", context, item_model_view, R.id.item_model_item_purpose_container_editing);
        Bring_Item_Add_Screen_Extra("Buyer", context, item_model_view, R.id.item_model_item_buyer_container_editing);

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
