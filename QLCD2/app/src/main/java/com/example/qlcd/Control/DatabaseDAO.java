package com.example.qlcd.Control;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.example.qlcd.Model.Citizen;

import java.util.ArrayList;
import java.util.List;

public class DatabaseDAO extends SQLiteOpenHelper {
    public static final String  name = "QLCD.sqlite";
    public DatabaseDAO(@Nullable Context context) {
        super(context, name,null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
    public void queryData(String sql ){
        SQLiteDatabase database = getWritableDatabase();
        database.execSQL(sql);
    }
    public Cursor getData(String sql){
        SQLiteDatabase database = getReadableDatabase();
        return database.rawQuery(sql, null);
    }
    public List<Citizen> SearchByName(String names){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE Name LIKE '%"+names+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public ArrayList<Citizen> SearchByCMND(String CMNDs){
        ArrayList<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE Name LIKE '%"+CMNDs+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public Long AddCitizen(Citizen c){
        ContentValues contentValues =new ContentValues();
        contentValues.put("Name",c.getName());
        contentValues.put("CMND",c.getCmnd());
        contentValues.put("Sex",c.getSex());
        contentValues.put("Dob",c.getDob());
        contentValues.put("Country",c.getCountry());
        contentValues.put("Hokhau",c.getHokhau());
        contentValues.put("Home",c.getHome());
        contentValues.put("NameFather",c.getFathername());
        contentValues.put("DobFather",c.getDobfather());
        contentValues.put("NameMother",c.getMothername());
        contentValues.put("DobMother",c.getDobmother());
        contentValues.put("NameWife",c.getWifename());
        contentValues.put("DobWife",c.getDobwife());
        contentValues.put("PhoneNumber",c.getPhone());
        contentValues.put("Crimial",c.getCriminal());
        contentValues.put("Note",c.getNote());
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.insert("Citizen",null,contentValues);
    }
    public int deleteCitizen(String id){
        String clause = "CMND = ? ";
        String[] values = {id};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.delete("Citizen",clause,values);
    }
    public int UpdateCitizen(Citizen c){
        ContentValues contentValues =new ContentValues();
        contentValues.put("Name",c.getName());
        contentValues.put("CMND",c.getCmnd());
        contentValues.put("Sex",c.getSex());
        contentValues.put("Dob",c.getDob());
        contentValues.put("Country",c.getCountry());
        contentValues.put("Hokhau",c.getHokhau());
        contentValues.put("Home",c.getHome());
        contentValues.put("NameFather",c.getFathername());
        contentValues.put("DobFather",c.getDobfather());
        contentValues.put("NameMother",c.getMothername());
        contentValues.put("DobMother",c.getDobmother());
        contentValues.put("NameWife",c.getWifename());
        contentValues.put("DobWife",c.getDobwife());
        contentValues.put("PhoneNumber",c.getPhone());
        contentValues.put("Crimial",c.getCriminal());
        contentValues.put("Note",c.getNote());
        String sql = "CMND = ?";
        String []clause = {c.getCmnd()};
        SQLiteDatabase sqLiteDatabase = getWritableDatabase();
        return sqLiteDatabase.update("Citizen",contentValues,sql,clause);
    }
    public List<Citizen> SearchByCC(String CMNDs){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE CMND LIKE '%"+CMNDs+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchBySex(String sexs){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE Sex = "+sexs+"";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByDob(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE Dob LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByCountry(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE Country LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByHokhau(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE Hokhau LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByHome(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE Home LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByNameFather(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE NameFather LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByNameMother(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE NameMother LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByNameWife(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE NameWife LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByDobFather(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE DobFather LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByDobMother(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE DobMother LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByDobWife(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE DobWife LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByPhone(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE PhoneNumber LIKE '%"+value+"%' ";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
    public List<Citizen> SearchByCrimial(String value){
        List<Citizen> arrayList = new ArrayList<>();
        String sql = "SELECT * FROM Citizen WHERE Crimial = "+value+"";
        SQLiteDatabase sqLiteDatabase =getReadableDatabase();
        Cursor cursor =sqLiteDatabase.rawQuery(sql,null);
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
        }
        return arrayList;
    }
}
