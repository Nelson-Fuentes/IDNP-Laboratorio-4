package com.idnp.laboratorio4.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.idnp.laboratorio4.R;
import com.idnp.laboratorio4.models.Student;

import java.util.ArrayList;

public class StudentAdapter  extends BaseAdapter {
    private Context context;
    private ArrayList<Student> students;

    public StudentAdapter(Context context, ArrayList<Student> students) {
        this.context = context;
        this.students = students;
    }

    @Override
    public int getCount() {
        return this.students.size();
    }

    @Override
    public Object getItem(int position) {
        return this.students.get(position);
    }

    @Override
    public long getItemId(int position) {
        return this.students.get(position).getCui();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = convertView;
        LayoutInflater layoutInflater = LayoutInflater.from(this.context);

        view = layoutInflater.inflate(R.layout.list_item_student, null);

        ((TextView) view.findViewById(R.id.textViewCUI)).setText(this.students.get(position).getCui()+"");
        ((TextView) view.findViewById(R.id.textViewFullName)).setText(this.students.get(position).getApellidos() +  ", " + this.students.get(position).getNombres());
        return view;
    }
}
