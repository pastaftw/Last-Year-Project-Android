package Interface;

import android.text.Layout;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.math.BigDecimal;
import java.text.BreakIterator;
import java.text.DecimalFormat;

import Processes.Item.Item_Model;
import Processes.Other.Types;
import ae.ogrenci_usulu.R;

public class Item_Converter {
    public static String[] Get_Item_Output(Item_Model item_model) {
        return new String[] {
                item_model.Buyer().toString(),
                item_model.Buy_Date().toString(), //WILL BE DATE
                item_model.Name(),
                item_model.Buy_Type().toString(),
                item_model.Buy_Count().toString(),
                item_model.Cost().toString(),
                item_model.Discount().toString(),
                item_model.Purpose() == null ?  "None" : item_model.Purpose().toString()
        };
    }

    public static Item_Model Convert_Text_To_Item(String[] item_model_output) {
        for (int i = 0; i<item_model_output.length; i++) {
            System.out.println(item_model_output[i]);
        }

        return new Item_Model(
                Integer.valueOf(item_model_output[0].trim()),
                item_model_output[1].trim(),
                item_model_output[2].trim(),
                Types.Object_Buy_Types.valueOf(item_model_output[3].trim()),
                Integer.valueOf(item_model_output[4].trim()),
                new BigDecimal(item_model_output[5].trim()),
                new BigDecimal(item_model_output[6].trim())
        );
    }

    /*
                item_model.Buyer().toString(),
                item_model.Buy_Date().toString(), //WILL BE DATE
                item_model.Name(),
                item_model.Buy_Type().toString(),
                item_model.Buy_Count().toString(),
                item_model.Cost().toString(),
                item_model.Discount().toString(),
                item_model.Purpose() == null ?  "None" : item_model.Purpose().toString()
   */

    public static void Update_Item_Model(View parent, Item_Model targ_item_model) {
        //ADVANCE check values && trim
        targ_item_model.Buyer(Integer.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buyer_editing)).getText()).trim()));
        targ_item_model.Buy_Date(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_date_editing)).getText()));
        targ_item_model.Name(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_name_editing)).getText()));
        targ_item_model.Buy_Type(Types.Object_Buy_Types.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_type_editing)).getText())));
        targ_item_model.Buy_Count(Integer.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_count_editing)).getText())));
        targ_item_model.Cost(new BigDecimal(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_cost_editing)).getText())));
        targ_item_model.Discount(new BigDecimal(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_discount_editing)).getText())));
        //targ_item_model.Purpose();
    }

    public static void Convert_Item_Model(String style, View parent, String[] item_model_output) {
        if (style == "ToTextView") {
            ((TextView) parent.findViewById(R.id.item_model_item_name)).setText(item_model_output[2]);
            ((TextView) parent.findViewById(R.id.item_model_item_cost)).setText(item_model_output[5]);
            ((TextView) parent.findViewById(R.id.item_model_item_buy_type)).setText(item_model_output[3]);
            ((TextView) parent.findViewById(R.id.item_model_item_buy_count)).setText(item_model_output[4]);
            ((TextView) parent.findViewById(R.id.item_model_item_discount)).setText(item_model_output[6]);
            ((TextView) parent.findViewById(R.id.item_model_item_buyer)).setText(item_model_output[0]);
            ((TextView) parent.findViewById(R.id.item_model_item_buy_date)).setText(item_model_output[1]);
            ((TextView) parent.findViewById(R.id.item_model_PURPOSE_PLACE_HOLDER)).setText(item_model_output[7]);
        }
        else if (style == "ToEditText") {
            ((EditText) parent.findViewById(R.id.item_model_item_name_editing)).setText(item_model_output[2]);
            ((EditText) parent.findViewById(R.id.item_model_item_cost_editing)).setText(item_model_output[5]);
            ((EditText) parent.findViewById(R.id.item_model_item_buy_type_editing)).setText(item_model_output[3]);
            ((EditText) parent.findViewById(R.id.item_model_item_buy_count_editing)).setText(item_model_output[4]);
            ((EditText) parent.findViewById(R.id.item_model_item_discount_editing)).setText(item_model_output[6]);
            ((EditText) parent.findViewById(R.id.item_model_item_buyer_editing)).setText(item_model_output[0]);
            ((EditText) parent.findViewById(R.id.item_model_item_buy_date_editing)).setText(item_model_output[1]);
            ((EditText) parent.findViewById(R.id.item_model_PURPOSE_PLACE_HOLDER_editing)).setText(item_model_output[7]);
        }
    }
}

