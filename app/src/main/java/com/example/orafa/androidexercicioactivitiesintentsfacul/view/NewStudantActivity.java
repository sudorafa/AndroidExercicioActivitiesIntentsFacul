package com.example.orafa.androidexercicioactivitiesintentsfacul.view;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.orafa.androidexercicioactivitiesintentsfacul.R;
import com.example.orafa.androidexercicioactivitiesintentsfacul.model.Student;

public class NewStudantActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewHolder mViewHolder = new ViewHolder();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_studant);

        this.mViewHolder.buttonSave = (Button) findViewById(R.id.buttonSave);
        this.mViewHolder.editName = (EditText) findViewById(R.id.editName);
        this.mViewHolder.editEmail = (EditText) findViewById(R.id.editEmail);
        this.mViewHolder.editPhone = (EditText) findViewById(R.id.editPhone);
        this.mViewHolder.editSite = (EditText) findViewById(R.id.editSite);

        this.mViewHolder.buttonSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        String name, email, phone, site;
        name = mViewHolder.editName.getText().toString();
        email = mViewHolder.editEmail.getText().toString();
        phone = mViewHolder.editPhone.getText().toString();
        site = mViewHolder.editSite.getText().toString();
        Student student = new Student(name, email, phone, site);
        Intent intent = new Intent();

        switch (v.getId()) {
            case R.id.buttonSave:
                intent.putExtra("student", student);
                setResult(RESULT_OK, intent);
                finish();
                break;
        }
    }

    private static class ViewHolder {
        EditText editName;
        EditText editSite;
        EditText editEmail;
        EditText editPhone;
        Button buttonSave;

    }
}
