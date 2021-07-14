package com.example.qlcd.View;

import android.database.Cursor;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlcd.Control.AdapterRecycleView;
import com.example.qlcd.Control.DatabaseDAO;
import com.example.qlcd.Model.Citizen;
import com.example.qlcd.R;

import java.util.ArrayList;
import java.util.List;

public class Home_fragment extends Fragment {
    View view;
    RecyclerView recyclerView;
    EditText editText;
    Button searchbtn;
    ArrayList<Citizen> arrayList;
    AdapterRecycleView adapterRecycleView;
    DatabaseDAO databaseDAO;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.home_fragment,container,false);
        recyclerView = view.findViewById(R.id.recycleView);
        editText = view.findViewById(R.id.SearchByName);
        searchbtn = view.findViewById(R.id.searchbtn);
        databaseDAO = new DatabaseDAO(getActivity());
        arrayList = new ArrayList<>();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapterRecycleView = new AdapterRecycleView(getActivity(),arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterRecycleView);

        Cursor cursor = databaseDAO.getData("SELECT * FROM Citizen ORDER BY Id DESC LIMIT 30");
        while (cursor.moveToNext()){
            String name = cursor.getString(1);
            String cmnd = cursor.getString(2);
            String sex = cursor.getString(3);
            String  dob = cursor.getString(4);
            String country = cursor.getString(5) ;
            String hokhau  = cursor.getString(6);
            String  home = cursor.getString(7);
            String fathername = cursor.getString(8);
            String mothername = cursor.getString(10);
            String wifename = cursor.getString(12);
            String dobfather = cursor.getString(9);
            String dobmother = cursor.getString(11);
            String dobwife = cursor.getString(13);
            String phone = cursor.getString(14);
            String criminal = cursor.getString(15);
            String note = cursor.getString(16);
            Citizen c = new Citizen(name,cmnd,sex,dob,country,hokhau,home,fathername,mothername,wifename,dobfather,dobmother,dobwife,phone,criminal,note);
            arrayList.add(c);
            adapterRecycleView.notifyDataSetChanged();
        }

        searchbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String txt = editText.getText().toString();
                arrayList.clear();
                List<Citizen> list = databaseDAO.SearchByName(txt);
                for(Citizen c : list){
                    arrayList.add(c);
                }
                adapterRecycleView.notifyDataSetChanged();
            }
        });

        return view;
    }
}
