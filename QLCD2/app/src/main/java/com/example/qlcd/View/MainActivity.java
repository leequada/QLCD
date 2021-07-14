package com.example.qlcd.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.example.qlcd.Control.DatabaseDAO;
import com.example.qlcd.R;
import com.google.android.material.bottomappbar.BottomAppBar;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity {
    DatabaseDAO databaseDAO;
    FloatingActionButton floatingActionButton;
    BottomAppBar bottomAppBar;
    BottomNavigationView nav;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomAppBar = findViewById(R.id.bottombar);
        nav = findViewById(R.id.nav_menu);
        floatingActionButton = findViewById(R.id.flactionbtn);
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,new Home_fragment()).commit();
        nav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                Fragment fragment = null;
                switch (menuItem.getItemId()){
                    case R.id.nav_home:
                        fragment = new Home_fragment();
                        break;
                    case R.id.nav_search:
                        fragment = new Search_Fragment();
                        break;

                }
                getSupportFragmentManager().beginTransaction().replace(R.id.frame_container,fragment).commit();
                return true;
            }
        });



        databaseDAO = new DatabaseDAO(this);

       databaseDAO.queryData("CREATE TABLE IF NOT EXISTS " +
                "Citizen(Id INTEGER PRIMARY KEY AUTOINCREMENT , Name nvarchar(200) , CMND varchar(25) ,Sex INTEGER, Dob varchar(50) ," +
                "Country nvarchar(200) , Hokhau nvarchar(200) , Home nvarchar(200) , NameFather nvarchar(200) ," +
                "DobFather varchar(20) , NameMother nvarchar(200) , DobMother varchar(20) , NameWife nvarchar(200) , DobWife varchar(20) , PhoneNumber varchar(30) ,Crimial INTEGER ,Note nvarchar(200))  ");

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, Add_Activity.class));
            }
        });
    }
}