package com.example.qlcd.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.qlcd.Control.DatabaseDAO;
import com.example.qlcd.Model.Citizen;
import com.example.qlcd.R;

import java.util.Calendar;

public class Add_Activity extends AppCompatActivity {
    EditText name , cmnd , fathername,dobfather,mothername,dobmother,wifename,dobwife,dob,phone,note,home,country,hokhau;
    RadioButton radioButton;
    RadioGroup radioGroup;
    Button btnadd,btndob,btnswap;
    Toolbar toolbar;
    DatePickerDialog.OnDateSetListener setListener;
    CheckBox checkBox;
    DatabaseDAO databaseDAO;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        name = findViewById(R.id.editname);
        cmnd = findViewById(R.id.editcmnd);
        fathername = findViewById(R.id.editfathername);
        dobfather = findViewById(R.id.editdobfather);
        mothername = findViewById(R.id.editmothername);
        dobmother = findViewById(R.id.dobmother);
        wifename = findViewById(R.id.editwifename);
        dobwife = findViewById(R.id.dobwife);
        dob = findViewById(R.id.editdob);
        phone = findViewById(R.id.editphone);
        note = findViewById(R.id.editNote);
        home = findViewById(R.id.edithome);
        country = findViewById(R.id.editcountry);
        hokhau = findViewById(R.id.edithokhau);
        radioGroup = findViewById(R.id.greditsex);
        btnadd = findViewById(R.id.btnadd);
        btnswap = findViewById(R.id.swap);
        btndob = findViewById(R.id.btndob);
        checkBox = findViewById(R.id.crimial);
        toolbar = findViewById(R.id.toolbar);
        init();
        databaseDAO = new DatabaseDAO(this);

        btnswap.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(btndob.getVisibility() == View.GONE){
                    btndob.setVisibility(View.VISIBLE);
                    dob.setVisibility(View.GONE);
                }
                else {
                    btndob.setVisibility(View.GONE);
                    dob.setVisibility(View.VISIBLE);
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
                DatePickerDialog datePickerDialog = new DatePickerDialog(Add_Activity.this, android.R.style.Theme_Holo_Light_Dialog_MinWidth
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
                btndob.setText(date);
            }
        };

        btnadd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String names = ToUpperCase(name.getText().toString());
                String cmnds = cmnd.getText().toString();
                Cursor cursor = databaseDAO.getData("SELECT * FROM Citizen WHERE CMND = "+cmnds+"");
                int radioid = radioGroup.getCheckedRadioButtonId();
                radioButton = findViewById(radioid);
                String sexs;
                if(radioButton.getText().toString().equalsIgnoreCase("Nam")){
                    sexs = "1";
                }else {
                    sexs = "0";
                }

                String dobss="";
                if (btndob.getVisibility() == View.GONE){
                   String regex = "^\\d{2}/\\d{2}/\\d{4}$";
                   String input = dob.getText().toString();
                   String[] arr = input.split("/");
                    switch (input.length()){
                        case 8:
                            String days = input.substring(0,2);
                            String months = input.substring(2,4);
                            String years = input.substring(4,8);
                            dobss = days+"/"+months+"/"+years;
                            break;
                        case 4:
                            dobss = input;
                            break;
                    }
                }

                String countrys = country.getText().toString() ;
                String hokhaus = hokhau.getText().toString();
                String  homes = home.getText().toString() ;
                String fathernames = fathername.getText().toString();
                String mothernames=mothername.getText().toString();
                String wifenames = wifename.getText().toString();
                String dobfathers = dobfather.getText().toString();
                String dobmothers = dobmother.getText().toString();
                String dobwifes = dobwife.getText().toString();
                String phones = phone.getText().toString();
                String criminals;
                if(checkBox.isChecked()){
                    criminals = "1";
                }
                else {
                    criminals = "0";
                }
                String notes = note.getText().toString();
                Citizen c = new Citizen(names,cmnds,sexs,dobss,countrys,hokhaus,homes,fathernames,mothernames,wifenames,dobfathers,dobmothers,dobwifes,phones,criminals,notes);
                if(dobss.equals("") || cursor.getCount() > 0 ){
                    Toast.makeText(Add_Activity.this,"Sai định dạng của ngày sinh hoặc CMND đã tồn tại", Toast.LENGTH_SHORT).show();
                }
                else {
                    Long result = databaseDAO.AddCitizen(c);
                    if(result > 0){
                        Toast.makeText(Add_Activity.this,"Thành công",Toast.LENGTH_SHORT).show();
                         //startActivity(new Intent(Add_Activity.this,Home_fragment.class));
                    }
                    else {
                        Toast.makeText(Add_Activity.this,"Lỗi ....",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });



    }
    public  String ToUpperCase(String name){
        String[] arrname = name.split(" ");
        String result="";
        for(String t : arrname){
            t = t.substring(0,1).toUpperCase()+t.substring(1);
            result +=t+" ";
        }
        return result;
    }
    private void init() {
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