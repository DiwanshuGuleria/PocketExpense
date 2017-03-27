package com.example.sidharth.pocketexpensemanager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String pass="";
    String name="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView tr=(TextView)findViewById(R.id.setpass);
        SharedPreferences sharedPreferences= PreferenceManager.getDefaultSharedPreferences(this);
        pass=sharedPreferences.getString("pass","");
        name=sharedPreferences.getString("name","");
        if(!name.isEmpty())
        tr.setText("Welcome "+name);
    }

    public void onclick(View v)
    {

        if(v.getId()==R.id.setpass)
        {
            if(!pass.isEmpty())
            {
                Toast t=Toast.makeText(MainActivity.this,"Password already set",Toast.LENGTH_SHORT);
                t.show();
            }
            else {
                Intent i = new Intent(MainActivity.this, setpass.class);
                startActivity(i);
            }
        }


        if(v.getId()==R.id.submit)
        {
            EditText e=(EditText)findViewById(R.id.pass);

            String r=e.getText().toString();

            if(r.isEmpty())
            {
                Toast t=Toast.makeText(MainActivity.this,"Enter Password",Toast.LENGTH_SHORT);
                t.show();
            }
            else
            {

                if(!r.equals(pass))
                {
                    Toast t=Toast.makeText(MainActivity.this,"Password don't match",Toast.LENGTH_SHORT);
                    t.show();
                }
                else
                {
                    Intent i=new Intent(MainActivity.this,toolbar.class);
                    startActivity(i);
                }
            }

        }
    }


}
