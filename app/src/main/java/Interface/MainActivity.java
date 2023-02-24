package Interface;

//Common
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import ae.ogrenci_usulu.R;

//Custom
import Main.Other.Invoice;
import Main.Other.Types;
import Main.Item.Item_Model;
import Main.Other.User;

class TEST {
    static Invoice INV = new Invoice();
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
    LinearLayout cont;
    Button add;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TEST.PREPARE_TEST_SAMPLES(); //TESTING PURPOSES

        cont = findViewById(R.id.container);
        add = findViewById(R.id.button);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Common.Add_Layout(getApplicationContext(), "item_card", cont, "Hallo");
            }
        });
    }
}