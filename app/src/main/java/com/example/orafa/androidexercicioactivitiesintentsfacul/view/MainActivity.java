package com.example.orafa.androidexercicioactivitiesintentsfacul.view;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.example.orafa.androidexercicioactivitiesintentsfacul.R;
import com.example.orafa.androidexercicioactivitiesintentsfacul.model.Student;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();

    Student student;
    List<Student> mListStudent;
    ArrayAdapter<Student> mAdapter;
    public static final int REQUEST_CADASTRO = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.listStudent = (ListView) findViewById(R.id.listStudent);
        this.mViewHolder.buttonAdd = (Button) findViewById(R.id.buttonAdd);

        this.mViewHolder.buttonAdd.setOnClickListener(this);

        mListStudent = new ArrayList<>();

        mAdapter = new ArrayAdapter<Student>(this, android.R.layout.simple_list_item_1, mListStudent);
        this.mViewHolder.listStudent.setAdapter(mAdapter);

        //Registra a list para usar o método onCreateContextMenu que add o menu
        registerForContextMenu(this.mViewHolder.listStudent);

    }

    //A partir do parâmetro contextMenu podemos criar opções para o nosso context menu utilizando o método add:
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        menu.add(Menu.NONE, 1, Menu.NONE, R.string.callToStudent);
        menu.add(Menu.NONE, 2, Menu.NONE, R.string.smsToStudent);
        menu.add(Menu.NONE, 2, Menu.NONE, R.string.sendEmail);
        menu.add(Menu.NONE, 3, Menu.NONE, R.string.mapLocation);
        menu.add(Menu.NONE, 4, Menu.NONE, R.string.siteStudent);
    }

    //Para poder dar uma ação para um context menu: Basta sobrescrevemos o método onContextItemSelected
    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case 1:

        }
        return super.onContextItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CADASTRO) {
                student = (Student) data.getSerializableExtra("student");
                mListStudent.add(student);
                mAdapter.notifyDataSetChanged();
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

    @Override
    protected void onResume() {
        super.onResume();

        this.mViewHolder.listStudent.setOnCreateContextMenuListener(this);
    }

    private static class ViewHolder {
        ListView listStudent;
        Button buttonAdd;
    }

}
