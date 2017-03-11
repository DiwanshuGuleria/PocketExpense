package com.example.sidharth.pocketexpensemanager;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import java.util.Calendar;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by root on 8/3/17.
 */

public class DateDialogFragment extends DialogFragment implements DatePickerDialog.OnDateSetListener{
    //EditText dateText;
    public  DateDialogFragment(){
       // dateText = (EditText)getView();

    }



    public Dialog onCreateDialog(Bundle savedInstanceState){
        final Calendar c =  Calendar.getInstance();
        int year=c.get(Calendar.YEAR);
        int month=c.get(Calendar.MONTH);
        int day=c.get(Calendar.DAY_OF_MONTH);
        return new DatePickerDialog(getActivity(),this,year,month,day);
    }

    public void onDateSet(DatePicker view,int year,int month,int day){
        String date=day+"/"+month+"/"+year;
        Toast.makeText(getActivity(),date,Toast.LENGTH_LONG).show();
    }

}
