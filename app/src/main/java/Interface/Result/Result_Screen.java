package Interface.Result;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import Processes.Payment.Payment_User_Info;
import ae.ogrenci_usulu.R;

public class Result_Screen {
    public void Build_Result_Screen(Context context, ViewGroup parent, List<Payment_User_Info> pui, ViewGroup related) {
        LayoutInflater interlater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View result_model_view = interlater.inflate(R.layout.invoice_result_container, null);
        related.setVisibility(View.VISIBLE);
        parent.addView(result_model_view, 0);

        TextView targ = result_model_view.findViewById(R.id.invoice_result_text);
        String f = "";

        for (int i = 0; i < pui.size(); i++) {
            f += "\n" + pui.get(i).Get_Owner_ID() + " " + pui.get(i).Get_Payment();
        }

        targ.setText(f);

        /*
        result_model_view.findViewById(R.id.invoice_result_container_click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                ((ViewGroup)parent).removeView(result_model_view);
            }
        });
        */
    }
}
