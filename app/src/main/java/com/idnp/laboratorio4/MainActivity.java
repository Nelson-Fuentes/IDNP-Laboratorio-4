package com.idnp.laboratorio4;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.idnp.laboratorio4.activities.StudentRegisterActivity;
import com.idnp.laboratorio4.activities.StudentUpdateActivity;
import com.idnp.laboratorio4.adapters.StudentAdapter;
import com.idnp.laboratorio4.models.Student;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;
    private StudentAdapter studentAdapter;
    private ArrayList<Student> students;

    public static final int UPDATE_REQUEST = 1;
    public static final int REGISTER_REQUEST = 2;
    public static final String POSITION = "position";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.prepareStudentsList();
        this.prepareStudentsListView();
    }
    private void prepareStudentsList(){
        this.students = new ArrayList<Student>();
        this.students.add(new Student(20172129, "Cruz Mamani", "Piero Nelson"));
        this.students.add(new Student(20171623, "Davila Chipana", "Elmer Xavier"));
        this.students.add(new Student(20173385, "Fuentes Paredes", "Nelson Alejandro"));
        this.students.add(new Student(20172129, "Ticllahuanaco Huachaca", "Kelvin"));
    }

    private void prepareStudentsListView(){
        this.studentAdapter = new StudentAdapter(this, this.students);
        this.listView = (ListView) this.findViewById(R.id.listView);
        this.listView.setAdapter(this.studentAdapter);
        this.listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Student student = MainActivity.this.students.get(position);
                Intent intent = new Intent(MainActivity.this, StudentUpdateActivity.class);
                intent.putExtra(StudentRegisterActivity.TAG_STUDENT, student);
                intent.putExtra(MainActivity.POSITION, position);
                startActivityForResult(intent, UPDATE_REQUEST);
            }
        });
    }

    public void startRegisterStudent(View view){
        Intent intent  = new Intent(this, StudentRegisterActivity.class);
        this.startActivityForResult(intent, REGISTER_REQUEST);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (resultCode == Activity.RESULT_OK){
            if (requestCode == REGISTER_REQUEST){
                Student newStudent = (Student) data.getExtras().get(StudentRegisterActivity.TAG_STUDENT);
                this.students.add(newStudent);
                this.studentAdapter.notifyDataSetChanged();
            }
            if (requestCode == UPDATE_REQUEST){
                Student updatedStudent = (Student) data.getExtras().get(StudentRegisterActivity.TAG_STUDENT);
                int position = ((Integer)data.getExtras().get(POSITION)).intValue();
                this.students.set(position, updatedStudent);
                this.studentAdapter.notifyDataSetChanged();
            }
        }
    }
}