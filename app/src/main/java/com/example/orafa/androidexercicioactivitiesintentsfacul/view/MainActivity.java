package com.example.orafa.androidexercicioactivitiesintentsfacul.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.orafa.androidexercicioactivitiesintentsfacul.R;
import com.example.orafa.androidexercicioactivitiesintentsfacul.model.Student;
import com.example.orafa.androidexercicioactivitiesintentsfacul.model.StudentAdapter;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    Student mStudent;
    List<Student> mStudents;
    StudentAdapter mStudentAdapter;
    public static final int REQUEST_CADASTRO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.listStudent = (ListView) findViewById(R.id.listStudent);
        this.mViewHolder.buttonAdd = (Button) findViewById(R.id.buttonAdd);

        this.mViewHolder.buttonAdd.setOnClickListener(this);

        mStudents = new ArrayList<>();

        //mAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, mStudent);
        mStudentAdapter = new StudentAdapter(this, mStudents);
        this.mViewHolder.listStudent.setAdapter(mStudentAdapter);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode  == RESULT_OK) {
            if(requestCode == REQUEST_CADASTRO){
                mStudent = (Student) data.getSerializableExtra("student");
                mStudents.add(mStudent);
                mStudentAdapter.notifyDataSetChanged();
            }

        }
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAdd:
                Intent intent = new Intent(MainActivity.this, NewStudantActivity.class);
                startActivityForResult(intent, REQUEST_CADASTRO);
                break;
        }
    }

    private static class ViewHolder {
        ListView listStudent;
        Button buttonAdd;
    }

}
