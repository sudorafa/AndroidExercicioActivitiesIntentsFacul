package com.example.orafa.androidexercicioactivitiesintentsfacul.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.orafa.androidexercicioactivitiesintentsfacul.R;
import com.example.orafa.androidexercicioactivitiesintentsfacul.dao.DStudent;
import com.example.orafa.androidexercicioactivitiesintentsfacul.model.Student;

public class NewStudantActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder mViewHolder = new ViewHolder();
    private Student student;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_studant);

        this.mViewHolder.buttonSave = (Button) findViewById(R.id.buttonSave);
        this.mViewHolder.editName = (EditText) findViewById(R.id.editName);
        this.mViewHolder.editEmail = (EditText) findViewById(R.id.editEmail);
        this.mViewHolder.editPhone = (EditText) findViewById(R.id.editPhone);

        //pegar o aluno que está chegando via "objeto" se foi selecionado, se não gera para salvar um novo
        student = (Student) getIntent().getSerializableExtra("student");
        if (student != null) {
            mViewHolder.editName.setText(student.getName());
            mViewHolder.editEmail.setText(student.getEmail());
            mViewHolder.editPhone.setText(student.getEmail());
        } else {
            student = new Student();
        }

        this.mViewHolder.buttonSave.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        switch (v.getId()) {
            case R.id.buttonSave:
                student.setName(mViewHolder.editName.getText().toString());
                student.setEmail(mViewHolder.editEmail.getText().toString());
                student.setPhone(mViewHolder.editPhone.getText().toString());
                DStudent dStudent = new DStudent(NewStudantActivity.this);
                dStudent.save(student);
                finish();
                break;
        }
    }

    private static class ViewHolder {
        EditText editName;
        EditText editEmail;
        EditText editPhone;
        Button buttonSave;

    }
}
