package com.example.finalprojectpractice;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.finalprojectpractice.Controller.MySingleton;
import com.example.finalprojectpractice.Model.Users;
import com.example.finalprojectpractice.adapter.RecyclerViewAdapater;
import com.example.finalprojectpractice.data.interfaceExample;
import com.example.finalprojectpractice.data.userBank;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView rv;
    private RecyclerViewAdapater rva;
    private List<Users> userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userList =new userBank().getUsers(new interfaceExample() {
            @Override
            public void processFinished(ArrayList<Users> usersArrayList) {
                rv=findViewById(R.id.recyclerView);
                rv.setHasFixedSize(true);
                rv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                rva=new RecyclerViewAdapater(MainActivity.this,userList);
                rv.setAdapter(rva);
            }
        });



    }
}

