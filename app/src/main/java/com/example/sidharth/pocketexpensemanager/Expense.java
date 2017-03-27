package com.example.sidharth.pocketexpensemanager;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import java.util.ArrayList;


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
        View itemView=inflater.inflate(R.layout.fragment_expense, container, false);
        ArrayList<Category_Data> list=new ArrayList<>();
        list.add(new Category_Data("Books",R.drawable.books));
        list.add(new Category_Data("Clothes", R.drawable.clothes));
        list.add(new Category_Data("Entertainment", R.drawable.entertainment));
        list.add(new Category_Data("Fuel", R.drawable.fuel));
        list.add(new Category_Data("General", R.drawable.general));
        list.add(new Category_Data("Gift", R.drawable.gift));
        list.add(new Category_Data("Holidays", R.drawable.holidays));
        list.add(new Category_Data("Shopping", R.drawable.shopping));
        list.add(new Category_Data("Transport", R.drawable.transport));
        Spinner spin = (Spinner)itemView.findViewById(R.id.cat_spinner);
        Category_Adapter adapter = new Category_Adapter(getActivity(),R.layout.custom_category_list,R.id.category,list);
        spin.setAdapter(adapter);
        return itemView;
    }


}
