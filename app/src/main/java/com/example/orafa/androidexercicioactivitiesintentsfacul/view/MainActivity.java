package com.example.orafa.androidexercicioactivitiesintentsfacul.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.orafa.androidexercicioactivitiesintentsfacul.R;
import com.example.orafa.androidexercicioactivitiesintentsfacul.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<Student> students = new ArrayList<Student>();
        students.add(new Student("Rafa", "asdsa@dsaud", "99999999"));
        students.add(new Student("Edu", "asdsa@dsaud", "99999999"));
        students.add(new Student("Lima", "asdsa@dsaud", "99999999"));

        ListView listView = (ListView) findViewById(R.id.listStudent);

        ArrayAdapter<Student> adapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students);

        listView.setAdapter(adapter);
    }
}
