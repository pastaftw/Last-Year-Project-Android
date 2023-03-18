package Interface;

//Common

import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.math.BigDecimal;
import java.util.ArrayList;

import Interface.Item.Item_Adapter;
import Processes.Item.Item_Buyer;
import Processes.Item.Item_Model;
import Processes.Other.Invoice;
import Processes.Other.Types;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

class TEST {
    public static Invoice INV = new Invoice();
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
    };

    public static void PREPARE_TEST_SAMPLES() {
        for (int index = 0;  index < TEST.Users.length; index++) {INV.Add_User(TEST.Users[index]);}
        for (int index = 0;  index < TEST.Items.length; index++) {INV.Add_Item(TEST.Items[index]);}
    }
}

public class MainActivity extends AppCompatActivity {
    ListView item_model_list_view;
    ListView users_view;
    LinearLayout insert_point;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_cards);
        TEST.PREPARE_TEST_SAMPLES(); //TESTING

        item_model_list_view = findViewById(R.id.item_list_listview);
        Item_Adapter item_model_list_adapter = new Item_Adapter(this, TEST.INV.Users(), TEST.INV.Items());
        item_model_list_view.setAdapter(item_model_list_adapter);
    }
}