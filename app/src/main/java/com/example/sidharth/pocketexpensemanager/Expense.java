package com.example.sidharth.pocketexpensemanager;


import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import java.util.Calendar;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.view.Menu;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v4.app.Fragment;
import android.support.v4.app.DialogFragment;


/**
 * A simple {@link Fragment} subclass.
 */
public class Expense extends Fragment {

    public Expense() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_expense, container, false);
    }
    public void onStart(){
        super.onStart();
        EditText dateText = (EditText)getView().findViewById(R.id.date);
        dateText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if(hasFocus){
                    DateDialogFragment dialog= new DateDialogFragment();
                    android.support.v4.app.FragmentTransaction ft =  getFragmentManager().beginTransaction();
                    dialog.show(ft,"asd");

                }
            }
        });





}

}
