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

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ViewHolder mViewHolder = new ViewHolder();

    List<Student> mStudent;
    ArrayAdapter<Student> mAdapter;
    public static final int REQUEST_CADASTRO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.listStudent= (ListView) findViewById(R.id.listStudent);
        this.mViewHolder.buttonAdd = (Button) findViewById(R.id.buttonAdd);

        mStudent = new ArrayList<>();

        mAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, mStudent);
        this.mViewHolder.listStudent.setAdapter(mAdapter);

        findViewById(R.id.buttonAdd).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, NewStudantActivity.class);
                startActivityForResult(intent, REQUEST_CADASTRO);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQUEST_CADASTRO && requestCode == RESULT_OK) {
            Student student = (Student) data.getParcelableExtra("student");
            mStudent.add(student);
            mAdapter.notifyDataSetChanged();
        }
    }

    //    @Override
//    public void onClick(View v) {
//        switch (v.getId()) {
//            case R.id.buttonAdd:
//                Intent intent = new Intent(MainActivity.this, NewStudantActivity.class);
//                startActivity(intent);
//                break;
//        }
//    }

    private static class ViewHolder {
        ListView listStudent;
        Button buttonAdd;

    }

}
