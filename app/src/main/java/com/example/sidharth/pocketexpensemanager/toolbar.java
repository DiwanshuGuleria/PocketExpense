package com.example.sidharth.pocketexpensemanager;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageButton;


/**
 * Created by Sidharth on 3/5/2017.
 */

public class toolbar extends AppCompatActivity{
    public static int REQUEST_CAPTURE=1;
    Toolbar toolbar;
    ViewPager viewPager;
    TabLayout tabLayout;
    viewPagerAdapter viewPagerAdapter;
    ImageButton imageButton;
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        toolbar=(Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        tabLayout=(TabLayout)findViewById(R.id.tablayout);
        viewPager=(ViewPager)findViewById(R.id.viewpager);
        viewPagerAdapter=new viewPagerAdapter(getSupportFragmentManager());
        viewPagerAdapter.addFragments(new HomeFragment(),"Home");
        viewPagerAdapter.addFragments(new Pay(),"Pay");
        viewPagerAdapter.addFragments(new Expense(),"Expense");
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
}
