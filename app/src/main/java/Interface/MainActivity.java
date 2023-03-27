package Interface;

//Common

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.List;

import Interface.Item.Item_Adapter;
import Interface.Item.Item_Edit_Extra;
import Processes.Item.Item_Buyer;
import Processes.Item.Item_Model;
import Processes.Other.Invoice;
import Processes.Other.Types;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

class TEST {
    static Integer start_index = 0;

    public static User[] Users = {
            new User(start_index++, "Ramazan", "SURNAME_HOLDER", "Ramazan123"),
            new User(start_index++, "Arda", "SURNAME_HOLDER", "Arda123"),
            new User(start_index++, "Erol", "SURNAME_HOLDER", "Erol312"),
            new User(start_index++, "APOOO", "SURNAME_HOLDER", "APOOO21"),
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
                    BigDecimal.valueOf(2),
                    BigDecimal.valueOf(29.90d),
                    BigDecimal.valueOf(0),
                    "DATE_PLACE_HOLDER"
            ),
            new Item_Model(
                    new Item_Buyer[]{
                            new Item_Buyer(Users[0], new BigDecimal(16)),
                            new Item_Buyer(Users[1], new BigDecimal(17)),
                    },
                    Types.Item_Buyer_Types.Amount,
                    "EŞYA 2",
                    Types.Item_Buy_Types.Countable,
                    BigDecimal.valueOf(2),
                    BigDecimal.valueOf(29.90d),
                    BigDecimal.valueOf(0),
                    "DATE_PLACE_HOLDER"
            ),
    };
}

public class MainActivity extends AppCompatActivity {
    ListView item_model_list_view;
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


        item_model_list_view = findViewById(R.id.invoice_menu_content);
        Item_Adapter item_model_list_adapter = new Item_Adapter(this, new_invoice.Get_Users(), new_invoice.Get_Items());
        item_model_list_view.setAdapter(item_model_list_adapter);

        /*
        item_model_list_view = findViewById(R.id.item_list_listview);
        Item_Adapter item_model_list_adapter = new Item_Adapter(this, TEST.INV.Users(), TEST.INV.Items());
        item_model_list_view.setAdapter(item_model_list_adapter);
        */
    }
}