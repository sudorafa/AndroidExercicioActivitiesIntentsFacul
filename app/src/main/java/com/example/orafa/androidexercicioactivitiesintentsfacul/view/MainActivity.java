package com.example.orafa.androidexercicioactivitiesintentsfacul.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import com.example.orafa.androidexercicioactivitiesintentsfacul.R;
import com.example.orafa.androidexercicioactivitiesintentsfacul.dao.DStudent;
import com.example.orafa.androidexercicioactivitiesintentsfacul.model.Student;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private ArrayAdapter<Student> mAdapter;
    private ArrayList<Student> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        runList();

        this.mViewHolder.listStudent = (ListView) findViewById(R.id.listStudent);
        this.mViewHolder.buttonAdd = (Button) findViewById(R.id.buttonAdd);

        this.mViewHolder.buttonAdd.setOnClickListener(this);

        //pegar "objeto" selecionado na ListView e passar para a Activity NewStudant conforme código
        mViewHolder.listStudent.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent itent = new Intent(MainActivity.this, NewStudantActivity.class);
                itent.putExtra("student", mAdapter.getItem(position));
                startActivity(itent);
            }
        });

        registerForContextMenu(mViewHolder.listStudent);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.buttonAdd:
                Intent intent = new Intent(MainActivity.this, NewStudantActivity.class);
                startActivity(intent);
                break;
        }
    }

    private void runList() {
        mViewHolder.listStudent = (ListView) findViewById(R.id.listStudent);
        DStudent dStudent = new DStudent(this);
        students = (ArrayList<Student>) dStudent.findStudent();
        mAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, students);
        mViewHolder.listStudent.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged();
    }

    private static class ViewHolder {
        ListView listStudent;
        Button buttonAdd;
    }

    @Override
    protected void onResume() {
        runList();
        super.onResume();
    }

}
