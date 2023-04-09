package Interface.User;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;

import Processes.Other.User;
import ae.ogrenci_usulu.R;

public class User_Group_Adapter extends ArrayAdapter<User> {
    //Values
    Context context;
    List<User> user_group_list;

    //Constructor
    public User_Group_Adapter(Context context, List<User> user_group_list) {
        super(context, 0, user_group_list);
        this.context = context;
        this.user_group_list = user_group_list;
    }

    @Override
    public View getView(int index, View convert_view, ViewGroup parent) {
        View user_model_view = convert_view;
        User targ_user = user_group_list.get(index);

        if (user_model_view == null) {
            user_model_view = LayoutInflater.from(context).inflate(R.layout.invoice_user_card, parent,false);
        }

        User_Group_Converter.Convert_User_Model("ToTextView", user_model_view, User_Group_Converter.Get_User_Output(targ_user));
        return user_model_view;
    }
}