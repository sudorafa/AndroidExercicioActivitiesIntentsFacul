package com.example.orafa.androidexercicioactivitiesintentsfacul.model;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.orafa.androidexercicioactivitiesintentsfacul.R;

import java.util.List;

/**
 * Created by oRafa on 17/10/2017.
 */

public class StudentAdapter extends ArrayAdapter<Student> {
    public StudentAdapter(@NonNull Context context, @NonNull List<Student> objects) {
        super(context, 0, objects);
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        //obter objeto da lista
        Student student = getItem(position);

        //carregar arquivo de layout
        View layout = LayoutInflater.from(getContext()).inflate(R.layout.item_listview, null);

        //Preencher o arquivo de layout com os dados do objeto
        TextView textViewName = (TextView)layout.findViewById(R.id.textViewName);
        TextView textViewPhone = (TextView)layout.findViewById(R.id.textViewPhone);
        textViewName.setText(student.getName());
        textViewPhone.setText(student.getPhone());

        //retornar a view preenchida
        return layout;
    }
}
