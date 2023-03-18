//Item Converting

package Interface.Item;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import Common.Get_Selected;
import Processes.Item.Item_Buyer;
import Processes.Item.Item_Calculate_Style;
import Processes.Item.Item_Model;
import Processes.Other.Types;
import Processes.Other.User;
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
                Types.Item_Buy_Types.valueOf(item_model_output[3].trim()),
                Integer.valueOf(item_model_output[4].trim()),
                new BigDecimal(item_model_output[5].trim()),
                new BigDecimal(item_model_output[6].trim())
        );
    }

    public static void Convert_Item_View_To_Item_Model(View item_view, List<User> user_list) {
        //Item Name
        EditText item_model_item_name_view = item_view.findViewById(R.id.item_model_item_name_editing);
        String item_model_item_name = item_model_item_name_view.getText().toString().trim();

        //Item Cost
        EditText item_model_item_cost_view = item_view.findViewById(R.id.item_model_item_cost_editing);
        BigDecimal item_model_item_cost = new BigDecimal(item_model_item_cost_view.getText().toString().trim());

        //Item Discount
        EditText item_model_item_discount_view = item_view.findViewById(R.id.item_model_item_discount_editing);
        BigDecimal item_model_item_discount = new BigDecimal(item_model_item_discount_view.getText().toString().trim());

        //ITEM DATE HERE!! (NOT FINAL)
        EditText item_model_item_buy_date_view = item_view.findViewById(R.id.item_model_item_buy_date_editing);
        String item_model_item_buy_date_value = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        //Item Buyer Type
        ViewGroup item_buyer_type_view = item_view.findViewById(R.id.item_model_item_buyer_container_editing);
        String item_buyer_type_value = Get_Selected.Only_One_From_Parent(item_buyer_type_view);
        Types.Item_Buyer_Types item_model_buyer_type = Types.Item_Buyer_Types.valueOf(item_buyer_type_value);

        //Item Buyer Type Related Users
        List<Item_Buyer> item_model_item_buyer_type_related_users = new ArrayList<>();
        ViewGroup item_model_item_buyer_type_related_users_view = item_view.findViewById(R.id.item_model_user_container_editing);

        for (int i = 0; i < item_model_item_buyer_type_related_users_view.getChildCount(); i++) {
            ViewGroup targ_view =  (ViewGroup) item_model_item_buyer_type_related_users_view.getChildAt(i);
            ToggleButton targ_togglebutton = (ToggleButton) targ_view.getChildAt(0);
            String targ_edittext = ((EditText) targ_view.getChildAt(1)).getText().toString().trim();
            BigDecimal targ_edittext_value = new BigDecimal(targ_edittext);
            if (targ_togglebutton.isChecked()) {
                item_model_item_buyer_type_related_users.add(new Item_Buyer(user_list.get(i), targ_edittext_value));
            }
        }

        //Item Buy Type
        ViewGroup item_buy_type_view = item_view.findViewById(R.id.item_model_item_buy_type_container_editing);
        String item_buy_type_value = Get_Selected.Only_One_From_Parent(item_buy_type_view);
        Types.Item_Buy_Types item_model_buy_type = Types.Item_Buy_Types.valueOf(item_buy_type_value);

        //Item Calculate Style
        ViewGroup item_calculate_style_view = item_view.findViewById(R.id.item_model_item_calculate_style_container_editing);
        String item_calculate_style_value = Get_Selected.Only_One_From_Parent(item_calculate_style_view);
        Types.Item_Calculate_Styles item_calculate_style = Types.Item_Calculate_Styles.valueOf(item_calculate_style_value);

        //Item Calculate Style Related Users
        List<User> item_calculate_style_related_users = null;
        ViewGroup item_calculate_style_related_users_view = item_view.findViewById(R.id.item_model_item_calculate_style_related_users_container_editing);

        if (item_calculate_style != Types.Item_Calculate_Styles.values()[0]) {
            //Getting Item Calculate Style Related Users
            item_calculate_style_related_users = new ArrayList<>();

            for (int i = 0; i < item_calculate_style_related_users_view.getChildCount(); i++) {
                ToggleButton targ_togglebutton = (ToggleButton) item_calculate_style_related_users_view.getChildAt(i);
                if (targ_togglebutton.isChecked()) {
                    User targ_user = user_list.get(i);
                    item_calculate_style_related_users.add(targ_user);
                }
            }
        }

        //Ready To Deploy
        System.out.println(
                "ITEM_OUTPUT:::::" +
                item_model_item_name + " "
                + item_model_item_cost + " "
                + item_model_item_discount + " "
                + item_model_item_buy_date_value + " "
                + item_model_buyer_type + " "
                + item_model_buy_type + " "
        );

        for (int i = 0; i< item_model_item_buyer_type_related_users.size(); i++) {
            System.out.println("ITEM BUYER:::" + item_model_item_buyer_type_related_users.get(i).Buyer().Name());
        }
        for (int i = 0; i< item_calculate_style_related_users.size(); i++) {
            System.out.println("CALCULATE RELATED:::" + item_calculate_style_related_users.get(i).Name());
        }
    }

    public static void Update_Item_Model(View parent, Item_Model targ_item_model) {
        //ADVANCE check values && trim
        //targ_item_model.Buyer(Integer.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buyer_editing)).getText()).trim()));
        targ_item_model.Buy_Date(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_date_editing)).getText()));
        targ_item_model.Name(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_name_editing)).getText()));
        //targ_item_model.Buy_Type(Types.Object_Buy_Types.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_type_editing)).getText())));
        //targ_item_model.Buy_Count(Integer.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_count_editing)).getText())));
        targ_item_model.Cost(new BigDecimal(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_cost_editing)).getText())));
        targ_item_model.Discount(new BigDecimal(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_discount_editing)).getText())));

        //CONVERTING TYPES ::::::
        Types.Item_Buyer_Types item_buyer_type = Types.Item_Buyer_Types.valueOf(Get_Selected.Only_One_From_Parent(parent.findViewById(R.id.item_model_item_buyer_container_editing)));
        Types.Item_Buy_Types item_buy_type = Types.Item_Buy_Types.valueOf(Get_Selected.Only_One_From_Parent(parent.findViewById(R.id.item_model_item_buy_type_container_editing)));
        Types.Item_Calculate_Styles item_purpose = Types.Item_Calculate_Styles.valueOf(Get_Selected.Only_One_From_Parent(parent.findViewById(R.id.item_model_item_calculate_style_container_editing)));
        List<Integer> item_purpose_related_user_indexes = Get_Selected.List_From_Parent(parent.findViewById(R.id.item_model_item_calculate_style_related_users_container_editing));

        //targ_item_model.Purpose();

        //SPECIAL UPDATE
        targ_item_model.Buy_Type(item_buy_type);
        targ_item_model.BUYER_TYPE(item_buyer_type);
        //reach users
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
            //((EditText) parent.findViewById(R.id.item_model_item_buy_type_editing)).setText(item_model_output[3]);
            //((EditText) parent.findViewById(R.id.item_model_item_buy_count_editing)).setText(item_model_output[4]);
            ((EditText) parent.findViewById(R.id.item_model_item_discount_editing)).setText(item_model_output[6]);
            //((EditText) parent.findViewById(R.id.item_model_item_buyer_editing)).setText(item_model_output[0]);
            ((EditText) parent.findViewById(R.id.item_model_item_buy_date_editing)).setText(item_model_output[1]);
            //((EditText) parent.findViewById(R.id.item_model_PURPOSE_PLACE_HOLDER_editing)).setText(item_model_output[7]);
        }
    }
}

