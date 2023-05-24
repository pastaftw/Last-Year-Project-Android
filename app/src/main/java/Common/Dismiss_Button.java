package Common;

import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import Interface.User.User_Group_Converter;
import Processes.Other.User;

public class Dismiss_Button implements View.OnClickListener {
    ViewGroup container;
    View targ_view;
    View[] relations;

    public Dismiss_Button(ViewGroup container, View targ_view, View[] relations) {
        this.container = container;
        this.targ_view = targ_view;
        this.relations = relations;
    }

    //Overriding Default
    @Override
    public void onClick(View button){
        relations[0].setVisibility(View.VISIBLE);
        container.removeView(targ_view);
    }
}
