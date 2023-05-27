package Interface.Activities;

//Common

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;

import Common.TEST;
import Interface.Interface_Master;
import Interface.Result.Result_Screen;
import Processes.Calculate.Calculate_Main;
import Processes.Other.Invoice;
import ae.ogrenci_usulu.R;

public class Invoice_Menu extends AppCompatActivity {
    //Root
    View root;

    //Buttons
    Button user_group_button;
    Button items_button;
    Button calculate_button;

    //Containers
    LinearLayout user_group_container;
    LinearLayout items_container;

    //Other
    Integer current_menu = -1;

    //Life Cycle Functions
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //Life Cycle Main
        super.onCreate(savedInstanceState);
        setContentView(R.layout.invoice_menu);

        //TESTING//////////////////////////////
        Invoice new_invoice = new Invoice();
        //new_invoice.Set_All_Users(TEST.Users);
        //new_invoice.Set_All_Items(TEST.Items);
        ///////////////////////////////////////

        root = findViewById(R.id.invoice_menu_content_root);
        user_group_button = (Button) findViewById(R.id.invoice_menu_group_button);
        items_button = (Button) findViewById(R.id.invoice_menu_items_button);
        calculate_button = (Button) findViewById(R.id.invoice_menu_calculate_button);
        user_group_container = findViewById(R.id.invoice_menu_user_group_content);
        items_container = findViewById(R.id.invoice_menu_items_content);

        //Prepare
        //user_group_container.setVisibility(View.GONE);
        items_container.setVisibility(View.GONE);

        //Listeners
        Interface_Master.Prepare_Invoice_Menu(
                getApplicationContext(),
                new ViewGroup[] {user_group_container, items_container},
                new_invoice.Get_Users(), new_invoice.Get_Items()
        );

        user_group_button.setOnClickListener((View view) -> {
                if (current_menu != R.id.invoice_menu_user_group_content) {
                    current_menu = R.id.invoice_menu_user_group_content;
                    Interface_Master.Show_Targeted_Menu(root, R.id.invoice_menu_user_group_content);
                }
        });

        items_button.setOnClickListener((View view) -> {
                if (current_menu != R.id.invoice_menu_items_content) {
                    current_menu = R.id.invoice_menu_items_content;
                    Interface_Master.Show_Targeted_Menu(root, R.id.invoice_menu_items_content);
                }
        });

        calculate_button.setOnClickListener((View view) -> {
            System.out.println("EXECUTED_CALCULATE_MODULE!");
            //CALCULATE
            Calculate_Main new_calculate_main = new Calculate_Main();
            //Preparing Payment User Info List
            //new_calculate_main.Prepare_Invoice(new_invoice.Get_Users());
            //START!

            //FINAL
            Result_Screen finalize = new Result_Screen();
            ((ViewGroup)items_container).setVisibility(View.INVISIBLE);
            ((ViewGroup)user_group_container).setVisibility(View.INVISIBLE);

            /*
            if (root.findViewById(R.id.invoice_result_container_main) != null) {
                ((ViewGroup)root).removeView(root.findViewById(R.id.invoice_result_container_main));
            }*/

            while (root.findViewById(R.id.invoice_result_container_main) != null) {
                ((ViewGroup)root).removeView(root.findViewById(R.id.invoice_result_container_main));
            }

            current_menu = -3;

            finalize.Build_Result_Screen(
                    getApplicationContext(),
                    (ViewGroup) root,
                    new_calculate_main.Execute_Calculate(new_invoice.Get_Users(), new_invoice.Get_Items()),
                    new_invoice.Get_Users(),
                    ((ViewGroup)user_group_container.getParent())
            );
        });
    }
}