package com.example.orafa.androidexercicioactivitiesintentsfacul.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.NonNull;

import com.example.orafa.androidexercicioactivitiesintentsfacul.model.Student;

/**
 * Created by o Rafa on 26/09/2017.
 */

public class DStudent extends SQLiteOpenHelper {

    public DStudent(Context context) {
        super(context, "rafa", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "create table student(id integer primary key, name TEXT, email TEXT, phone TEXT);";
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        String sql = "drop table student;";
        db.execSQL(sql);
        onCreate(db);
    }

    public void save(Student student) {

    }

    @NonNull
    private ContentValues getContentValues(Student student) {
        ContentValues cv = new ContentValues();
        cv.put("name",student.getName());
        cv.put("email", student.getEmail());
        cv.put("phone", student.getPhone());
        return cv;
    }
}
