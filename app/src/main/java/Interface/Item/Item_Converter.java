//Item Converting

package Interface.Item;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.ToggleButton;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import Common.Get_Selected;
import Processes.Calculate.Calculate_Control;
import Processes.Item.Item_Buyer;
import Processes.Item.Item_Calculate_Style;
import Processes.Item.Item_Model;
import Processes.Other.Types;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class Item_Converter {
    public static String[] Get_Item_Output(Item_Model item_model) {
        String item_buyers;
        String item_calculating_style_relateds;

        //Reading Item Buyer / Buyers
        if (item_model.Get_Buyers() != null)  {
            item_buyers = "";
            for (Item_Buyer item_buyer : item_model.Get_Buyers()) {
                //Output
                item_buyers += (item_buyer.Get_Buyer().Name() + " (" +  item_buyer.Get_Buyer().Username()+ ")" +  ": " + item_buyer.Get_Cost()) + "\n";
            }
        }
        else {item_buyers = "No Buyer (???)";}

        //Reading Calculate Style Related Buyer / Buyers
        if (item_model.Get_Calculate_Style() != null) {
            item_calculating_style_relateds = "";
            //Output
            for (User related_user : item_model.Get_Calculate_Style().Get_Releated_Users()) {
                item_calculating_style_relateds += related_user.Name() + ", " + "\n";
            }
        }
        else {item_calculating_style_relateds = "No one is exception.";}

        return new String[] {
                item_model.Get_Name(),
                item_model.Get_Cost().toString(),
                item_model.Get_Discount().toString(),
                item_model.Get_Date(),
                item_model.Get_Buyer_Share_Type().toString(),
                item_buyers,
                item_model.Get_Buy_Type().toString(),
                item_model.Get_Calculate_Style() != null? item_model.Get_Calculate_Style().Get_Type().toString() : Types.Item_Calculate_Types.values()[0].toString(),
                item_calculating_style_relateds,
        };
    }

    public static Item_Model Convert_Item_View_To_Item_Model(View item_view, List<User> user_list) {
        //Item Name
        EditText item_model_item_name_view = item_view.findViewById(R.id.invoice_item_card_editing_content_name);
        String item_model_item_name = item_model_item_name_view.getText().toString().trim();

        //Item Cost
        EditText item_model_item_cost_view = item_view.findViewById(R.id.invoice_item_card_editing_content_cost);
        BigDecimal item_model_item_cost = new BigDecimal(item_model_item_cost_view.getText().toString().trim());

        //Item Discount
        EditText item_model_item_discount_view = item_view.findViewById(R.id.invoice_item_card_editing_content_discount);
        BigDecimal item_model_item_discount = new BigDecimal(item_model_item_discount_view.getText().toString().trim());

        //ITEM DATE HERE!! (NOT FINAL) (RETURNS LOCAL TIME FOR NOW) !!!!!!!!!!!
        EditText item_model_item_buy_date_view = item_view.findViewById(R.id.invoice_item_card_editing_content_buy_date);
        String item_model_item_buy_date_value = new SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(new Date());

        //Item Buyer Share Type
        ViewGroup item_model_item_buyer_type_view = item_view.findViewById(R.id.invoice_item_card_editing_content_buyer_share_type);
        String item_model_item_buyer_type_value = Get_Selected.Only_One_From_Parent(item_model_item_buyer_type_view);
        Types.Item_Buyer_Share_Types item_model_buyer_type = Types.Item_Buyer_Share_Types.valueOf(item_model_item_buyer_type_value);

        //Item Buyers & Item Buy Amount
        List<Item_Buyer> item_model_buyer_type_related_users = new ArrayList<>();
        BigDecimal item_model_item_buy_count = BigDecimal.valueOf(0);

        ViewGroup item_model_item_buyer_type_related_users_view = item_view.findViewById(R.id.invoice_item_card_editing_content_buyers);
        for (int i = 0; i < item_model_item_buyer_type_related_users_view.getChildCount(); i++) {
            ViewGroup targ_view =  (ViewGroup) item_model_item_buyer_type_related_users_view.getChildAt(i);
            ToggleButton targ_togglebutton = (ToggleButton) targ_view.getChildAt(0);
            String targ_edittext = ((EditText) targ_view.getChildAt(1)).getText().toString().trim();
            BigDecimal targ_edittext_value = new BigDecimal(targ_edittext);
            if (targ_togglebutton.isChecked()) {
                Calculate_Control.Add(item_model_item_buy_count, targ_edittext_value);
                item_model_buyer_type_related_users.add(new Item_Buyer(user_list.get(i), targ_edittext_value));
            }
        }

        //Item Buy Type
        ViewGroup item_model_item_buy_type_view = item_view.findViewById(R.id.invoice_item_card_editing_content_buy_type);
        String item_model_item_buy_type_value = Get_Selected.Only_One_From_Parent(item_model_item_buy_type_view);
        Types.Item_Buy_Types item_model_buy_type = Types.Item_Buy_Types.valueOf(item_model_item_buy_type_value);

        //Item Calculate Type
        ViewGroup item_model_calculate_type_view = item_view.findViewById(R.id.invoice_item_card_editing_content_calculate_type);
        String item_model_item_calculate_type_value = Get_Selected.Only_One_From_Parent(item_model_calculate_type_view);
        Types.Item_Calculate_Types item_calculate_style = Types.Item_Calculate_Types.valueOf(item_model_item_calculate_type_value);

        //Item Calculate Type Related Users
        ViewGroup item_model_item_calculate_type_related_users_view = item_view.findViewById(R.id.invoice_item_card_editing_content_calculate_type_related_users);
        Item_Calculate_Style item_calculate_style_override = null;

        if (item_calculate_style != Types.Item_Calculate_Types.values()[0]) {
            item_calculate_style_override = new Item_Calculate_Style(item_calculate_style);
            List<User> item_model_item_calculate_type_related_users = new ArrayList<>();
            item_calculate_style_override.Add_All_Related_Users(item_model_item_calculate_type_related_users);

            for (int i = 0; i < item_model_item_calculate_type_related_users_view.getChildCount(); i++) {
                ToggleButton targ_togglebutton = (ToggleButton) item_model_item_calculate_type_related_users_view.getChildAt(i);
                if (targ_togglebutton.isChecked()) {
                    User targ_user = user_list.get(i);
                    item_model_item_calculate_type_related_users.add(targ_user);
                }
            }
        }

        //TESTING OUTPUT
        /* System.out.println(
                "ITEM_OUTPUT:::::" +
                item_model_item_name + " "
                + item_model_item_cost + " "
                + item_model_item_discount + " "
                + item_model_item_buy_date_value + " "
                + item_model_buyer_type + " "
                + item_model_buy_type + " "
        );
        for (int i = 0; i< item_model_buyer_type_related_users.size(); i++) {
            System.out.println("ITEM BUYER:::" + item_model_buyer_type_related_users.get(i).Buyer().Name());
        }
        if (item_model_item_calculate_type_related_users != null) {
            for (int i = 0; i< item_model_item_calculate_type_related_users.size(); i++) {
                System.out.println("CALCULATE RELATED:::" + item_model_item_calculate_type_related_users.get(i).Name());
            }
        } */

        //Returning Without Calculate Style
        if (item_calculate_style_override == null) {
            return new Item_Model(
                    item_model_buyer_type_related_users,
                    item_model_buyer_type,
                    item_model_item_name,
                    item_model_buy_type,
                    item_model_item_buy_count,
                    item_model_item_cost,
                    item_model_item_discount,
                    item_model_item_buy_date_value
            );
        }
        //Returning With Calculate Style
        return new Item_Model(
                item_model_buyer_type_related_users,
                item_model_buyer_type,
                item_model_item_name,
                item_model_buy_type,
                item_model_item_buy_count,
                item_model_item_cost,
                item_model_item_discount,
                item_model_item_buy_date_value,
                item_calculate_style_override
        );
    }

    //Updating Existing Item_Model
    public static void Update_Item_Model(View parent, Item_Model targ_item_model, List<User> targ_user_list) {
        Item_Model new_item_model = Convert_Item_View_To_Item_Model(parent, targ_user_list);
        targ_item_model.Set_Name(new_item_model.Get_Name());
        targ_item_model.Set_Cost(new_item_model.Get_Cost());
        targ_item_model.Set_Discount(new_item_model.Get_Discount());
        targ_item_model.Set_Date(new_item_model.Get_Date());
        targ_item_model.Set_Buyer_Share_Type(new_item_model.Get_Buyer_Share_Type());
        targ_item_model.Set_All_Buyers(new_item_model.Get_Buyers());
        targ_item_model.Set_Buy_Type(new_item_model.Get_Buy_Type());
        targ_item_model.Set_Calculate_Style(new_item_model.Get_Calculate_Style());

        /*
        //ADVANCE check values && trim (LEGACY CODE)
        //targ_item_model.Buyer(Integer.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buyer_editing)).getText()).trim()));
        //targ_item_model.Set_Buy_Date(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_date_editing)).getText()));
        targ_item_model.Set_Name(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_name_editing)).getText()));
        //targ_item_model.Buy_Type(Types.Object_Buy_Types.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_type_editing)).getText())));
        //targ_item_model.Buy_Count(Integer.valueOf(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_buy_count_editing)).getText())));
        targ_item_model.Set_Cost(new BigDecimal(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_cost_editing)).getText())));
        targ_item_model.Set_Discount(new BigDecimal(String.valueOf(((EditText) parent.findViewById(R.id.item_model_item_discount_editing)).getText())));

        //CONVERTING TYPES ::::::
        Types.Item_Buyer_Types item_buyer_type = Types.Item_Buyer_Types.valueOf(Get_Selected.Only_One_From_Parent(parent.findViewById(R.id.item_model_item_buyer_share_type_container_editing)));
        Types.Item_Buy_Types item_buy_type = Types.Item_Buy_Types.valueOf(Get_Selected.Only_One_From_Parent(parent.findViewById(R.id.item_model_item_buy_type_container_editing)));
        Types.Item_Calculate_Types item_purpose = Types.Item_Calculate_Types.valueOf(Get_Selected.Only_One_From_Parent(parent.findViewById(R.id.item_model_item_calculate_type_container_editing)));
        List<Integer> item_purpose_related_user_indexes = Get_Selected.List_From_Parent(parent.findViewById(R.id.item_model_item_calculate_type_related_users_container_editing));

        //targ_item_model.Purpose();

        //SPECIAL UPDATE
        //targ_item_model.Set_Calculate_Style(item_purpose);
        targ_item_model.Set_Buy_Type(item_buy_type);
        //reach users
         */
    }

    //Updating Existing Item_Model
    public static void Create_Item_Model(View parent, Item_Model targ_item_model, List<User> targ_user_list, List<Item_Model> list) {
        Item_Model new_item_model = Convert_Item_View_To_Item_Model(parent, targ_user_list);
        list.add(new_item_model);
    }

    //Item Converter
    public static void Convert_Item_Model(String style, View parent, String[] item_model_output) {
        if (style.equals("ToTextView")) {
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_name)).setText(item_model_output[0]);
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_cost)).setText(item_model_output[1]);
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_discount)).setText(item_model_output[2]);
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_buy_type)).setText(item_model_output[3]);
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_share_type)).setText(item_model_output[4]);
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_buyers)).setText(item_model_output[5]);
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_buy_type)).setText(item_model_output[6]);
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_share_type)).setText(item_model_output[7]);
            ((TextView) parent.findViewById(R.id.invoice_item_card_content_share_type_related_users)).setText(item_model_output[8]);
        }
        else if (style.equals("ToEditText")) {
            //APPLY SELECTED VALUES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            ((EditText) parent.findViewById(R.id.invoice_item_card_editing_content_name)).setText(item_model_output[0]);
            ((EditText) parent.findViewById(R.id.invoice_item_card_editing_content_cost)).setText(item_model_output[1]);
            ((EditText) parent.findViewById(R.id.invoice_item_card_editing_content_discount)).setText(item_model_output[2]);
            ((EditText) parent.findViewById(R.id.invoice_item_card_editing_content_buy_date)).setText(item_model_output[3]);
            //( x2 (EditText) parent.findViewById(R.id.item_model_item_buyer_share_type_container_editing)).setText(item_model_output[6]);
            //((EditText) parent.findViewById(R.id.item_model_item_buy_type_container_editing)).setText(item_model_output[0]);
            //((EditText) parent.findViewById(R.id.item_model_item_calculate_type_container_editing)).setText(item_model_output[1]);
            //((EditText) parent.findViewById(R.id.item_model_item_calculate_type_related_users_container_editing)).setText(item_model_output[7]);
        }
        else if (style.equals("ToEditText_New")) {
            //APPLY SELECTED VALUES!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
            ((EditText) parent.findViewById(R.id.invoice_item_card_editing_content_name)).setText("Nesne İsmi");
            ((EditText) parent.findViewById(R.id.invoice_item_card_editing_content_cost)).setText(0);
            ((EditText) parent.findViewById(R.id.invoice_item_card_editing_content_discount)).setText(0);
            ((EditText) parent.findViewById(R.id.invoice_item_card_editing_content_buy_date)).setText("Tarih_Kullanılamıyor");
            //( x2 (EditText) parent.findViewById(R.id.item_model_item_buyer_share_type_container_editing)).setText(item_model_output[6]);
            //((EditText) parent.findViewById(R.id.item_model_item_buy_type_container_editing)).setText(item_model_output[0]);
            //((EditText) parent.findViewById(R.id.item_model_item_calculate_type_container_editing)).setText(item_model_output[1]);
            //((EditText) parent.findViewById(R.id.item_model_item_calculate_type_related_users_container_editing)).setText(item_model_output[7]);
        }
    }
}

