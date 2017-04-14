package com.example.sidharth.pocketexpensemanager.fragments;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.sidharth.pocketexpensemanager.data.MainActivity;
import com.example.sidharth.pocketexpensemanager.R;

/**
 * Created by Sidharth on 2/8/2017.
 */

public class setpass extends Activity {


    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.setpass);
    }

    public void onsetpass(View v)
    {
        EditText e=(EditText)findViewById(R.id.etext);
        EditText e1=(EditText)findViewById(R.id.pass1);
        EditText e2=(EditText)findViewById(R.id.pass2);

        String a=e.getText().toString();
        String b=e1.getText().toString();
        String c=e2.getText().toString();

        if(b.isEmpty())
        {
            Toast t=Toast.makeText(setpass.this,"Enter Password",Toast.LENGTH_SHORT);
            t.show();
        }
        else {
            if (!b.equals(c)) {
                Toast t = Toast.makeText(setpass.this, "Password don't match", Toast.LENGTH_SHORT);
                t.show();
            } else {

                SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
                SharedPreferences.Editor editor=sharedPreferences.edit();
                editor.putString("name",a);
                editor.putString("pass",b);
                editor.commit();
                Toast.makeText(setpass.this,"Password successfully set",Toast.LENGTH_SHORT).show();
                Intent i = new Intent(setpass.this, MainActivity.class);

                startActivity(i);
            }
        }

    }
}
