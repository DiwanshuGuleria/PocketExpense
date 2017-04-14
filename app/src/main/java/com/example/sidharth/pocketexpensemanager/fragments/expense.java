package com.example.sidharth.pocketexpensemanager.fragments;


 import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
 import android.widget.Button;
 import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.sidharth.pocketexpensemanager.R;
import com.example.sidharth.pocketexpensemanager.adapter.Category_Adapter;
import com.example.sidharth.pocketexpensemanager.data.Category_DB;
import com.example.sidharth.pocketexpensemanager.data.Category_Data;
import com.example.sidharth.pocketexpensemanager.data.DBhandler;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class expense extends Fragment {

    Button add;
    TextView output;
    DBhandler dBhandler;
    EditText edMoney,edDescription;
   /* Bundle str = getActivity().getIntent().getExtras();
    String date = str.getString("abc");*/

    String money,category,description,date="12/03/1889";





    public expense() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View itemView=inflater.inflate(R.layout.fragment_expense, container, false);
        ArrayList<Category_Data> list=new ArrayList<>();
        list.add(new Category_Data("Books", R.drawable.books));
        list.add(new Category_Data("Clothes", R.drawable.clothes));
        list.add(new Category_Data("Entertainment", R.drawable.entertainment));
        list.add(new Category_Data("Fuel", R.drawable.fuel));
        list.add(new Category_Data("General", R.drawable.general));
        list.add(new Category_Data("Gift", R.drawable.gift));
        list.add(new Category_Data("Holidays", R.drawable.holidays));
        list.add(new Category_Data("Shopping", R.drawable.shopping));
        list.add(new Category_Data("Transport", R.drawable.transport));
        Spinner spin = (Spinner)itemView.findViewById(R.id.cat_spinner);
        Category_Adapter adapter = new Category_Adapter(getActivity(), R.layout.custom_category_list, R.id.category,list);
        spin.setAdapter(adapter);
        category=spin.getSelectedItem().toString();

        output = (TextView)itemView.findViewById(R.id.textView2);
        edDescription = (EditText)itemView.findViewById(R.id.editText2);
        edMoney = (EditText)itemView.findViewById(R.id.editText);
        dBhandler = new DBhandler(getContext(),null,null,1);
        description = edDescription.getText().toString();
        money = edMoney.getText().toString();
        printDatabase();
        add=(Button)itemView.findViewById(R.id.button2);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Category_DB db = new Category_DB(date,description,money,category);
                dBhandler.addData(db);
                printDatabase();
            }
        });
        return itemView;
    }



        public void printDatabase(){
            String dbString = dBhandler.databaseTOstring();
            output.setText(dbString);
            edMoney.setText("");
            edDescription.setText("");
        }


}
