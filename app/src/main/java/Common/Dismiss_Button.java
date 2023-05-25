package Common;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Interface.User.User_Group_Converter;
import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class Dismiss_Button implements View.OnClickListener {
    ViewGroup container;
    View targ_view;
    View[] relations;
    Boolean c_type;

    public Dismiss_Button(ViewGroup container, View targ_view, View[] relations) {
        this.container = container;
        this.targ_view = targ_view;
        this.relations = relations;
    }

    //Overriding Default
    @Override
    public void onClick(View button){
        ((ViewGroup)(relations[0].getParent())).setVisibility(View.VISIBLE);
        container.removeView(targ_view);
    }
}
