package com.example.sidharth.pocketexpensemanager.fragments;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.AppCompatSpinner;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.sidharth.pocketexpensemanager.R;
import com.example.sidharth.pocketexpensemanager.adapter.viewPagerAdapter;


/**
 * Created by Sidharth on 3/5/2017.
 */

public class toolbar extends AppCompatActivity{
    public static int REQUEST_CAPTURE=1;
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    com.example.sidharth.pocketexpensemanager.adapter.viewPagerAdapter viewPagerAdapter;
    ImageButton imageButton;



    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);

        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPagerAdapter=new viewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new homeFragment(),"Home");
        viewPagerAdapter.addFragments(new pay(),"Pay");
        viewPagerAdapter.addFragments(new expense(),"Expense");
        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
        imageButton=(ImageButton)findViewById(R.id.image_icon);


        if(!hasCamera())
        {
            imageButton.setEnabled(false);
        }


    }

    public void Date(View view) {
        DateDialogFragment dialog = new DateDialogFragment();
        android.app.FragmentTransaction ft = getFragmentManager().beginTransaction();
        dialog.show(ft, "asd");
    }
    public void onImage(View v)
    {
        Intent i=new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        startActivityForResult(i,REQUEST_CAPTURE);
    }

    public boolean hasCamera()
    {
        return getPackageManager().hasSystemFeature(PackageManager.FEATURE_CAMERA_ANY);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.calendar, menu);
        return true;
    }
    View v;
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.calendar:

                Date(v);
                return true;
            default:
                return super.onOptionsItemSelected(item);

        }
    }



}
