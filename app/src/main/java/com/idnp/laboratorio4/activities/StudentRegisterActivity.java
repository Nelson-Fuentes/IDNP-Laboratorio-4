package com.idnp.laboratorio4.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.idnp.laboratorio4.MainActivity;
import com.idnp.laboratorio4.R;
import com.idnp.laboratorio4.interfaces.StudentFormInterface;
import com.idnp.laboratorio4.models.Student;

public class StudentRegisterActivity extends AppCompatActivity implements StudentFormInterface {

    public static final String TAG_STUDENT = "student";

    private EditText editTextCUI;
    private EditText editTextLastName;
    private EditText editTextFirstName;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.student_form);

        this.editTextCUI = (EditText) this.findViewById(R.id.editTextCUI);
        this.editTextLastName = (EditText) this.findViewById(R.id.editTextLastName);
        this.editTextFirstName = (EditText) this.findViewById(R.id.editTextFirstName);

    }

    public void saveResult(View view){
        int cui = Integer.parseInt(this.editTextCUI.getText().toString());
        String last_name = this.editTextLastName.getText().toString();
        String first_name = this.editTextFirstName.getText().toString();
        Student student = new Student(cui, last_name, first_name);

        Intent intent = new Intent();
        intent.putExtra(TAG_STUDENT, student);
        this.setResult(Activity.RESULT_OK, intent);
        this.finish();
    }


}