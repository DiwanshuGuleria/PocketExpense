package com.example.sidharth.pocketexpensemanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 */
<<<<<<< HEAD:app/src/main/java/com/example/sidharth/pocketexpensemanager/toppaid.java
public class toppaid extends Fragment {
    private DatePicker datePicker;
    private Calendar calendar;
    private TextView dateView;
    private int year, month, day;
=======
public class Pay extends Fragment {
>>>>>>> 5026a2a33235d5c798b98d2456e693af02ee8f13:app/src/main/java/com/example/sidharth/pocketexpensemanager/Pay.java


    public Pay() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD:app/src/main/java/com/example/sidharth/pocketexpensemanager/toppaid.java


        return inflater.inflate(R.layout.fragment_transfer, container, false);
=======
        return inflater.inflate(R.layout.fragment_pay, container, false);
>>>>>>> 5026a2a33235d5c798b98d2456e693af02ee8f13:app/src/main/java/com/example/sidharth/pocketexpensemanager/Pay.java
    }

}
