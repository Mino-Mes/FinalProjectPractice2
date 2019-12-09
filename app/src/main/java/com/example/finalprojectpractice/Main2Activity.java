package com.example.finalprojectpractice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.finalprojectpractice.Model.Users;
import com.google.gson.Gson;

public class Main2Activity extends AppCompatActivity {

    private TextView tv;
    private Users user;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tv=findViewById(R.id.textView1);

    Bundle bundle = getIntent().getExtras();

    if(bundle !=null)
    {
        Gson gson= new Gson();
        String contactAsString = bundle.getString("contactAsString");
      user=gson.fromJson(contactAsString, Users.class);

        tv.setText("Voila " + user.getFname() + " " + user.getAge());

    }

    }
}
