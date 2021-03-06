package com.example.qlcd.View;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.qlcd.Control.AdapterRecycleView;
import com.example.qlcd.Control.DatabaseDAO;
import com.example.qlcd.Model.Citizen;
import com.example.qlcd.R;

import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class Search_Fragment extends Fragment {
    View view;
    EditText editText;
    Spinner spinner;
    Button btnSearch;
    TextView totalCitizen;
    RecyclerView recyclerView;
    DatabaseDAO databaseDAO;
    AdapterRecycleView adapterRecycleView;
    ArrayList<Citizen> arrayList  = new ArrayList<>();

    @Nullable

    @Override
    public View onCreateView(@NotNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable  Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.search_fragment,container,false);
        editText = view.findViewById(R.id.contentSearch);
        spinner = view.findViewById(R.id.spinners);
        btnSearch = view.findViewById(R.id.btnSearchAll);
        totalCitizen = view.findViewById(R.id.totalcitizen);
        recyclerView = view.findViewById(R.id.rys1);
        databaseDAO = new DatabaseDAO(getActivity());

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        adapterRecycleView = new AdapterRecycleView(getActivity(),arrayList);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(adapterRecycleView);


        final ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(getActivity(),R.array.choice,android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String text = parent.getItemAtPosition(position).toString();
                if(text.equalsIgnoreCase("C?? ti???n ??n")){
                    editText.setVisibility(View.GONE);
                }
                else {
                    editText.setVisibility(View.VISIBLE);
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String reg  = spinner.getSelectedItem().toString();
                String content = editText.getText().toString();
                List<Citizen> list = new ArrayList<>();
                switch (reg){
                    case "CMND":
                        arrayList.clear();
                        list=databaseDAO.SearchByCC(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "H??? v?? t??n":
                        arrayList.clear();
                        list = databaseDAO.SearchByName(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "Ng??y sinh":
                        arrayList.clear();
                        list=databaseDAO.SearchByDob(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "Qu?? qu??n":
                        arrayList.clear();
                        list=databaseDAO.SearchByCountry(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "H??? kh???u":
                        arrayList.clear();
                        list=databaseDAO.SearchByHokhau(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "Gi???i t??nh":
                        arrayList.clear();
                        if(content.equalsIgnoreCase("Nam")){
                            content="1";
                        }else {
                            content="0";
                        }
                        list=databaseDAO.SearchBySex(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "N??i ??? hi???n t???i":
                        arrayList.clear();
                        list=databaseDAO.SearchByHome(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "H??? v?? t??n b???":
                        arrayList.clear();
                        list=databaseDAO.SearchByNameFather(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "H??? v?? t??n m???":
                        arrayList.clear();
                        list=databaseDAO.SearchByNameMother(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "H??? v?? t??n v???":
                        arrayList.clear();
                        list=databaseDAO.SearchByNameWife(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "N??m sinh b???":
                        arrayList.clear();
                        list=databaseDAO.SearchByDobFather(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "N??m sinh m???":
                        arrayList.clear();
                        list=databaseDAO.SearchByDobMother(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "N??m sinh v???":
                        arrayList.clear();
                        list=databaseDAO.SearchByDobWife(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "S??? ??i???n tho???i":
                        arrayList.clear();
                        list=databaseDAO.SearchByPhone(content);
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                    case "C?? Ti???n ??n":
                        arrayList.clear();
                        list=databaseDAO.SearchByCrimial("1");
                        for(Citizen c : list){
                            arrayList.add(c);
                        }
                        totalCitizen.setText("T???ng s??? c??ng d??n l?? : "+arrayList.size());
                        adapterRecycleView.notifyDataSetChanged();
                        break;
                }
            }
        });

        return view;
    }


}
