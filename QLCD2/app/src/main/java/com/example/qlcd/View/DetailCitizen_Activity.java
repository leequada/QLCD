package com.example.qlcd.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.ContentProvider;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.qlcd.Control.DatabaseDAO;
import com.example.qlcd.Model.Citizen;
import com.example.qlcd.R;

import java.util.Calendar;

public class DetailCitizen_Activity extends AppCompatActivity {
    DatabaseDAO databaseDAO;
    EditText name,cmnd,country,home,hokhau,namefather,dobfather,namemother,dobmother,namewife,dobwife,phone,note;
    TextView tname,tcmnd,tcountry,tdob,thome,thokhau,tnamefather,tnamemother,tdobfather,tdobmother,tnamewife,tdobwife,tphone,tnote;
    Button btnname,btncmnd,btndob,btncountry,btnhokhau,btnhome,btnnamefather,btndobfather,btnnamemother,btndobmother,btnnamewife,btndobwife,btnphone,btnnote;
    CheckBox crimial;
    RadioGroup radioGroup;
    RadioButton radioButton;
    Toolbar toolbar;
    Citizen citizen;
    ImageView imageView;
    Button btnsave;
    String names ;
    String cmnds;
    String sexs;
    String  dobs;
    String countrys ;
    String hokhaus ;
    String  homes ;
    String fathernames;
    String mothernames;
    String wifenames;
    String dobfathers;
    String dobmothers;
    String dobwifes;
    String phones;
    String criminals;
    String notes;
    DatePickerDialog.OnDateSetListener setListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_citizen);
        databaseDAO = new DatabaseDAO(this);
        btnsave = findViewById(R.id.btnsave);
        init();

        Intent intent = getIntent();
        if(intent != null){
            if(intent.hasExtra("Citizen")){
                citizen =(Citizen) intent.getSerializableExtra("Citizen");
                Toast.makeText(DetailCitizen_Activity.this,citizen.getMothername(),Toast.LENGTH_SHORT).show();
            }
        }



        names = citizen.getName();
        cmnds = citizen.getCmnd();
        countrys = citizen.getCountry();
        dobs = citizen.getDob();
        hokhaus = citizen.getHokhau();
        homes = citizen.getHome();
        sexs = citizen.getSex();
         fathernames = citizen.getFathername();
        mothernames = citizen.getMothername();
         wifenames=citizen.getWifename();
      dobfathers = citizen.getDobfather();
         dobmothers=citizen.getDobmother();
       dobwifes=citizen.getDobwife();
       phones=citizen.getPhone();
        criminals=citizen.getCriminal();
       notes=citizen.getNote();

       if(sexs.equals("0")){
           imageView.setBackgroundResource(R.drawable.woman);
       }
       else {
           imageView.setBackgroundResource(R.drawable.man);
       }

        tname.setText(citizen.getName());
        tcmnd.setText(citizen.getCmnd());
        tcountry.setText(citizen.getCountry());
        tdob.setText(citizen.getDob());
        thokhau.setText(citizen.getHokhau());
        thome.setText(citizen.getHome());
        tnamefather.setText(citizen.getFathername());
        tnamemother.setText(citizen.getMothername());
        tnamewife.setText(citizen.getWifename());
        tdobfather.setText(citizen.getDobfather());
        tdobmother.setText(citizen.getDobmother());
        tdobwife.setText(citizen.getDobwife());
        tphone.setText(citizen.getPhone());
        tnote.setText(citizen.getNote());
        if(citizen.getCriminal().equals("0")) {
            crimial.setChecked(false);
        }
        if(citizen.getSex().equals("0")){
            radioButton = findViewById(R.id.editnus);
            radioButton.setChecked(true);
        }


        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int radioid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioid);
                if(radioButton.getText().toString().equalsIgnoreCase("Nam")){
                    sexs = "1";
                }else {
                    sexs = "0";
                }
                if(crimial.isChecked()){
                    criminals = "1";
                }
                else {
                    criminals = "0";
                }
                Citizen c = new Citizen(names,cmnds,sexs,dobs,countrys,hokhaus,homes,fathernames,mothernames,wifenames,dobfathers,dobmothers,dobwifes,phones,criminals,notes);
                int result = databaseDAO.UpdateCitizen(c);
                if(result>0){
                    Toast.makeText(DetailCitizen_Activity.this,"Update Thành Công",Toast.LENGTH_SHORT).show();
                }
            }
        });

        btnname.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(name.getVisibility() == View.GONE){
                    name.setVisibility(View.VISIBLE);
                    tname.setVisibility(View.GONE);
                    name.setText(names);

                }
                else if(name.getVisibility() == View.VISIBLE){
                    names = name.getText().toString();
                    name.setVisibility(View.GONE);
                    tname.setVisibility(View.VISIBLE);
                    tname.setText(names);
                }
            }
        });

        btncmnd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(cmnd.getVisibility() == View.GONE){
                    cmnd.setVisibility(View.VISIBLE);
                    tcmnd.setVisibility(View.GONE);
                    cmnd.setText(cmnds);

                }
                else if(cmnd.getVisibility() == View.VISIBLE){
                    cmnds = cmnd.getText().toString();
                    cmnd.setVisibility(View.GONE);
                    tcmnd.setVisibility(View.VISIBLE);
                    tcmnd.setText(cmnds);
                }
            }
        });
        Calendar calendar = Calendar.getInstance();
        int year = calendar.get(Calendar.YEAR);
        int month = calendar.get(Calendar.MONTH);
        int day = calendar.get(Calendar.DAY_OF_MONTH);

        btndob.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(DetailCitizen_Activity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
                        ,setListener,year,month,day);
                datePickerDialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                datePickerDialog.show();
            }
        });
        setListener = new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                month = month+1;
                String date = day+"/"+month+"/"+year;
                tdob.setText(date);
            }
        };

        btncountry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(country.getVisibility() == View.GONE){
                    country.setVisibility(View.VISIBLE);
                    tcountry.setVisibility(View.GONE);
                    country.setText(countrys);

                }
                else if(country.getVisibility() == View.VISIBLE){
                    countrys = country.getText().toString();
                    country.setVisibility(View.GONE);
                    tcountry.setVisibility(View.VISIBLE);
                    tcountry.setText(countrys);
                }
            }
        });

        btnhokhau.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(hokhau.getVisibility() == View.GONE){
                    hokhau.setVisibility(View.VISIBLE);
                    thokhau.setVisibility(View.GONE);
                    hokhau.setText(hokhaus);

                }
                else if(hokhau.getVisibility() == View.VISIBLE){
                    hokhaus = hokhau.getText().toString();
                    hokhau.setVisibility(View.GONE);
                    thokhau.setVisibility(View.VISIBLE);
                    thokhau.setText(hokhaus);
                }

            }
        });

        btnhome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(home.getVisibility() == View.GONE){
                    home.setVisibility(View.VISIBLE);
                    thome.setVisibility(View.GONE);
                    home.setText(homes);

                }
                else if(home.getVisibility() == View.VISIBLE){
                    homes = home.getText().toString();
                    home.setVisibility(View.GONE);
                    thome.setVisibility(View.VISIBLE);
                    thome.setText(homes);
                }
            }
        });

        btnnamefather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(namefather.getVisibility() == View.GONE){
                    namefather.setVisibility(View.VISIBLE);
                    tnamefather.setVisibility(View.GONE);
                    namefather.setText(fathernames);

                }
                else if(namefather.getVisibility() == View.VISIBLE){
                    fathernames = namefather.getText().toString();
                    namefather.setVisibility(View.GONE);
                    tnamefather.setVisibility(View.VISIBLE);
                    tnamefather.setText(fathernames);
                }

            }
        });

        btndobfather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dobfather.getVisibility() == View.GONE){
                    dobfather.setVisibility(View.VISIBLE);
                    tdobfather.setVisibility(View.GONE);
                    dobfather.setText(dobfathers);

                }
                else if(dobfather.getVisibility() == View.VISIBLE){
                    dobfathers = dobfather.getText().toString();
                    dobfather.setVisibility(View.GONE);
                    tdobfather.setVisibility(View.VISIBLE);
                    tdobfather.setText(dobfathers);
                }
            }
        });

        btnnamemother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(namemother.getVisibility() == View.GONE){
                    namemother.setVisibility(View.VISIBLE);
                    tnamemother.setVisibility(View.GONE);
                    namemother.setText(mothernames);

                }
                else if(namemother.getVisibility() == View.VISIBLE){
                    mothernames = namemother.getText().toString();
                    namemother.setVisibility(View.GONE);
                    tnamemother.setVisibility(View.VISIBLE);
                    tnamemother.setText(mothernames);
                }
            }
        });

        btndobmother.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dobmother.getVisibility() == View.GONE){
                    dobmother.setVisibility(View.VISIBLE);
                    tdobmother.setVisibility(View.GONE);
                    dobmother.setText(dobmothers);

                }
                else if(dobmother.getVisibility() == View.VISIBLE){
                    dobmothers = dobmother.getText().toString();
                    dobmother.setVisibility(View.GONE);
                    tdobmother.setVisibility(View.VISIBLE);
                    tdobmother.setText(dobmothers);
                }

            }
        });

        btnnamewife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(namewife.getVisibility() == View.GONE){
                    namewife.setVisibility(View.VISIBLE);
                    tnamewife.setVisibility(View.GONE);
                    namewife.setText(wifenames);

                }
                else if(namewife.getVisibility() == View.VISIBLE){
                    wifenames = namewife.getText().toString();
                    namewife.setVisibility(View.GONE);
                    tnamewife.setVisibility(View.VISIBLE);
                    tnamewife.setText(wifenames);
                }

            }
        });
        btndobwife.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(dobwife.getVisibility() == View.GONE){
                    dobwife.setVisibility(View.VISIBLE);
                    tdobwife.setVisibility(View.GONE);
                    dobwife.setText(dobwifes);

                }
                else if(dobwife.getVisibility() == View.VISIBLE){
                    dobwifes = dobwife.getText().toString();
                    dobwife.setVisibility(View.GONE);
                    tdobwife.setVisibility(View.VISIBLE);
                    tdobwife.setText(dobwifes);
                }
            }
        });

        btnphone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(phone.getVisibility() == View.GONE){
                    phone.setVisibility(View.VISIBLE);
                    tphone.setVisibility(View.GONE);
                    phone.setText(phones);

                }
                else if(phone.getVisibility() == View.VISIBLE){
                    phones = phone.getText().toString();
                    phone.setVisibility(View.GONE);
                    tphone.setVisibility(View.VISIBLE);
                    tphone.setText(phones);
                }
            }
        });

        btnnote.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(note.getVisibility() == View.GONE){
                    note.setVisibility(View.VISIBLE);
                    tnote.setVisibility(View.GONE);
                    note.setText(notes);

                }
                else if(note.getVisibility() == View.VISIBLE){
                    notes = note.getText().toString();
                    note.setVisibility(View.GONE);
                    tnote.setVisibility(View.VISIBLE);
                    tnote.setText(notes);
                }
            }
        });


    }
    public void init(){
        name = findViewById(R.id.detailname);
        cmnd = findViewById(R.id.detailcmnd);
        namefather = findViewById(R.id.detailnamefather);
        dobfather = findViewById(R.id.detaildobfather);
        namemother = findViewById(R.id.detailnamemother);
        dobmother = findViewById(R.id.detaildobmother);
        namewife = findViewById(R.id.detailnamewife);
        dobwife = findViewById(R.id.detaildobwife);
        phone = findViewById(R.id.detailphone);
        note = findViewById(R.id.detailnote);
        home = findViewById(R.id.detailhome);
        country = findViewById(R.id.detailcountry);
        hokhau = findViewById(R.id.detailhokhau);
        radioGroup = findViewById(R.id.greditsexs);
        crimial = findViewById(R.id.crimialdetail);
        toolbar = findViewById(R.id.toolbars);


        tname = findViewById(R.id.txtname);
        tcmnd = findViewById(R.id.txtcmnd);
        tnamefather = findViewById(R.id.txtnamefather);
        tdobfather = findViewById(R.id.txtdobfather);
        tnamemother = findViewById(R.id.txtnamemother);
        tdobmother = findViewById(R.id.txtdobmother);
        tnamewife = findViewById(R.id.txtnamewife);
        tdobwife = findViewById(R.id.txtdobwife);
        tphone = findViewById(R.id.txtphone);
        tnote = findViewById(R.id.txtnote);
        thome = findViewById(R.id.txthome);
        tcountry = findViewById(R.id.txtcountry);
        thokhau = findViewById(R.id.txthokhau);
        tdob = findViewById(R.id.txtdob);



        btnname = findViewById(R.id.btnname);
        btncmnd = findViewById(R.id.btncmnd);
        btnnamefather = findViewById(R.id.btnnamefather);
        btndobfather = findViewById(R.id.btndobfather);
        btnnamemother = findViewById(R.id.btnnamemother);
        btndobmother = findViewById(R.id.btndobmother);
        btnnamewife = findViewById(R.id.btnnamewife);
        btndobwife = findViewById(R.id.btndobwife);
        btnphone = findViewById(R.id.btnphone);
        btnnote = findViewById(R.id.btnnote);
        btnhome = findViewById(R.id.btnhome);
        btncountry = findViewById(R.id.btncountry);
        btnhokhau = findViewById(R.id.btnhokhau);
        btndob = findViewById(R.id.btndobs);

        imageView = findViewById(R.id.detailimg);

        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setDisplayShowTitleEnabled(false);
        toolbar.setNavigationOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                finish();
            }

        });
    }
}