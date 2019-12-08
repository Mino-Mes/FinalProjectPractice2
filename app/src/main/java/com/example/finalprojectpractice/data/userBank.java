package com.example.finalprojectpractice.data;

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
    final private String URL ="https://api.myjson.com/bins/kp9wz";
    MySingleton ms = new MySingleton();

    public List<Users> getUsers(final interfaceExample callback){

        JsonObjectRequest jsonArrayRequest = new JsonObjectRequest(
                Request.Method.GET,
                URL,
                null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                            try{
                                JSONArray jsonArray = response.getJSONArray("employees");
                                for(int i=0;i<jsonArray.length();i++) {
                                   JSONObject employee =jsonArray.getJSONObject(i);
                                    Users user = new Users();
                                    user.setFname(employee.getString("firstname"));
                                    user.setAge(employee.getInt("age"));
                                    user.setEmail(employee.getString("mail"));
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

