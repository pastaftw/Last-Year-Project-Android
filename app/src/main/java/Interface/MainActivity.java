package Interface;

//Common
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.ListView;

import java.math.BigDecimal;

import ae.ogrenci_usulu.R;

//Custom
import Processes.Other.Invoice;
import Processes.Other.Types;
import Processes.Item.Item_Model;
import Processes.Other.User;

class TEST {
    public static Invoice INV = new Invoice();
    static Integer start_index = 0;

    public static User[] Users = {
            new User(start_index++, "Ramazan", "SURNAME_HOLDER", "Ramazan123"),
            new User(start_index++, "Arda", "SURNAME_HOLDER", "Arda123"),
    };

    public static Item_Model[] Items = {
            new Item_Model(Users[1].ID(), "06/06/2023", "Çekirdik", Types.Object_Buy_Types.Countable, 1, BigDecimal.valueOf(21.50d), BigDecimal.valueOf(0)),
            new Item_Model(Users[1].ID(), "06/06/2023", "Yer Fıstığı", Types.Object_Buy_Types.Countable, 2, BigDecimal.valueOf(13.50d), BigDecimal.valueOf(0)),
            new Item_Model(Users[1].ID(), "06/06/2023", "Leblebi", Types.Object_Buy_Types.Countable, 2, BigDecimal.valueOf(11.50d), BigDecimal.valueOf(0)),
            new Item_Model(Users[1].ID(), "06/06/2023", "Bardak", Types.Object_Buy_Types.Countable, 1, BigDecimal.valueOf(9.75d), BigDecimal.valueOf(0)),
    };

    public static void PREPARE_TEST_SAMPLES() {
        for (Integer index = 0;  index < TEST.Users.length; index++) {INV.Add_User(TEST.Users[index]);}
        for (Integer index = 0;  index < TEST.Items.length; index++) {INV.Add_Item((Item_Model) TEST.Items[index]);}
    }
}

public class MainActivity extends AppCompatActivity {
    ListView item_model_list_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TEST.PREPARE_TEST_SAMPLES(); //TESTING

        item_model_list_view = (ListView) findViewById(R.id.container);
        Item_Adapter item_model_list_adapter = new Item_Adapter(this, TEST.INV.Items());
        item_model_list_view.setAdapter(item_model_list_adapter);
    }
}