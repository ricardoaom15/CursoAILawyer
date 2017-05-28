package com.raikersoft.lawyer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.Toast;

import com.raikersoft.lawyer.model.DataBaseManager;
import com.raikersoft.lawyer.model.Lawyer;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class LawyerAddActivity extends AppCompatActivity {

    @BindView(R.id.add_name)
    EditText name;
    @BindView(R.id.add_phone)
    EditText phone;
    @BindView(R.id.add_speciality)
    EditText speciality;
    @BindView(R.id.add_biography)
    EditText biography;

    DataBaseManager dataBaseManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lawyer_add);
        ButterKnife.bind(this);
        dataBaseManager = new DataBaseManager(getApplicationContext());
    }

    @OnClick(R.id.add_fab)
    public void addLawyer(){
        Lawyer lawyer = new Lawyer();
        lawyer.setName(name.getText().toString());
        lawyer.setPhone(phone.getText().toString());
        lawyer.setSpeciality(speciality.getText().toString());
        lawyer.setBiography(biography.getText().toString());
        if(dataBaseManager.insertLawyer(lawyer)){
            Toast.makeText(this, "Se agregó el abogado correctamente", Toast.LENGTH_SHORT).show();
            finish();
        }else{
            Toast.makeText(this, "no se pudo agregar el abogado", Toast.LENGTH_SHORT).show();
        }
    }
}
