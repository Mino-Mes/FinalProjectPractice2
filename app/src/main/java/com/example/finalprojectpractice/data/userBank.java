package com.example.finalprojectpractice.data;

import android.util.Log;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.JsonObjectRequest;
import com.example.finalprojectpractice.Controller.MySingleton;
import com.example.finalprojectpractice.Model.Users;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class userBank {
    ArrayList <Users> userArrayList = new ArrayList<>();
   // final private String URL ="https://api.myjson.com/bins/kp9wz";
   final private String URL ="https://gist.githubusercontent.com/aws1994/f583d54e5af8e56173492d3f60dd5ebf/raw/c7796ba51d5a0d37fc756cf0fd14e54434c547bc/anime.json";
    MySingleton ms = new MySingleton();

    public List<Users> getUsers(final interfaceExample callback){
        Log.d("asd", "onResponse: ");
        JsonArrayRequest jsonArrayRequest = new JsonArrayRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                            try{
                           //   JSONArray jsonArray = response.getJSONArray("employees");
                                for(int i=0;i<response.length();i++) {
                                   JSONObject employee =response.getJSONObject(i);
                                    Users user = new Users();
                                    user.setFname(employee.getString("name"));
                                //    Log.d("asd", "onResponse: " + employee.getString("a"));
                                   user.setAge(1);
                               user.setEmail("filler");
                                    userArrayList.add(user);
                                }
                            }catch (JSONException e)
                            {
                                e.printStackTrace();
                            }

                        if(null !=callback)
                        {
                            callback.processFinished(userArrayList);
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });

        ms.getInstance().addToRequestQueue(jsonArrayRequest);

        return userArrayList;
        }
    }

