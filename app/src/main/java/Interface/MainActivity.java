package Interface;

//Common

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;

import Interface.User.User_Group_Adapter;
import Processes.Item.Item_Buyer;
import Processes.Item.Item_Model;
import Processes.Other.Invoice;
import Processes.Other.Types;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

class TEST {
    static Integer user_id_index_start = 0;

    public static User[] Users = {
            new User(user_id_index_start++, "Arda", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Erol", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Abdullah", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Ayla", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Yusuf", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Emre", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Volkan", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
            new User(user_id_index_start++, "Mustafa", "SURNAME_HOLDER", "USERNAME_PLACEHOLDER"),
    };

    public static Item_Model[] Items = {                                                                                                                                                     //TEST PARAMS
            new Item_Model(
                    new Item_Buyer[]{
                            new Item_Buyer(Users[0], new BigDecimal(16)),
                            new Item_Buyer(Users[1], new BigDecimal(17)),
                    },
                    Types.Item_Buyer_Types.Amount,
                    "Patates Cipsi",
                    Types.Item_Buy_Types.Countable,
                    BigDecimal.valueOf(1),
                    BigDecimal.valueOf(29.90),
                    BigDecimal.valueOf(0),
                    "DATE_PLACE_HOLDER"
            ),

            new Item_Model(
                    new Item_Buyer[]{
                            new Item_Buyer(Users[2], new BigDecimal(16)),
                            new Item_Buyer(Users[3], new BigDecimal(17)),
                            new Item_Buyer(Users[4], new BigDecimal(18)),
                    },
                    Types.Item_Buyer_Types.Amount,
                    "Domates",
                    Types.Item_Buy_Types.Kilogram,
                    BigDecimal.valueOf(2),
                    BigDecimal.valueOf(40),
                    BigDecimal.valueOf(0.2),
                    "DATE_PLACE_HOLDER"
            ),
    };
}

public class MainActivity extends AppCompatActivity {
    LinearLayout user_group_parent;
    LinearLayout item_model_list_view;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //TESTING//////////////////////////////
        Invoice new_invoice = new Invoice();
        new_invoice.Set_All_Users(TEST.Users);
        new_invoice.Set_All_Items(TEST.Items);
        //END OF TESTING//////////////////////
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice_menu);

        Button invoice_menu_group_button = (Button) findViewById(R.id.invoice_menu_group_button);
        Button invoice_menu_items_button = (Button) findViewById(R.id.invoice_menu_items_button);


        user_group_parent = findViewById(R.id.invoice_menu_user_group_content);
        LayoutInflater inflater = LayoutInflater.from(getApplicationContext());
        View view = inflater.inflate(R.layout.invoice_user_cards_container, null);
        user_group_parent.addView(view);
        ListView user_group_list_view = view.findViewById(R.id.invoice_user_cards_container_content);
        User_Group_Adapter user_group_adapter = new User_Group_Adapter(this, new_invoice.Get_Users());
        user_group_list_view.setAdapter(user_group_adapter);

        /*
        item_model_list_view = findViewById(R.id.invoice_menu_items_content);
        Item_Adapter item_model_list_adapter = new Item_Adapter(this, new_invoice.Get_Users(), new_invoice.Get_Items());
        item_model_list_view.setAdapter(item_model_list_adapter);
         */

        /*
        item_model_list_view = findViewById(R.id.item_list_listview);
        Item_Adapter item_model_list_adapter = new Item_Adapter(this, TEST.INV.Users(), TEST.INV.Items());
        item_model_list_view.setAdapter(item_model_list_adapter);
        */
    }
}