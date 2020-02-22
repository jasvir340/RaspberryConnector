package com.jvtech;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    Button lights,fan,ac,fridge;
    TextView title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        lights=(Button)findViewById(R.id.lights);
        fan=(Button)findViewById(R.id.fan);
        ac=(Button)findViewById(R.id.ac);
        fridge=(Button)findViewById(R.id.fridge);
        title=(TextView)findViewById(R.id.title);

        final RequestQueue queue = Volley.newRequestQueue(MainActivity.this);

        final boolean[] lightsOn = {false},fanOn = {false},acOn = {false},fridgeOn = {false};

        lights.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(lightsOn[0])
                {
                    StringRequest request = new StringRequest(Request.Method.POST, Classified.BASE_URL + "devices/events", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {
                            Toast.makeText(MainActivity.this, "turning off lights ...", Toast.LENGTH_SHORT).show();
                            title.setText("Lights turned off");
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        public Map<String,String> getParams()
                        {
                            Map<String,String> map = new HashMap<>();
                            map.put("name","lights off");
                            map.put("data","");
                            map.put("private","false");
                            return map;
                        }

                        public Map<String, String> getHeaders()
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("Authorization","Bearer "+Classified.ACCESS_TOKEN);
                            return map;
                        }
                    };
                    lights.setBackgroundColor(Color.RED);
                    lightsOn[0] =false;
                    queue.add(request);
                }
                else
                {
                    StringRequest request = new StringRequest(Request.Method.POST, Classified.BASE_URL + "devices/events", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(MainActivity.this, "turning on lights ...", Toast.LENGTH_SHORT).show();
                            title.setText("Lights turned on");

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        public Map<String,String> getParams()
                        {
                            Map<String,String> map = new HashMap<>();
                            map.put("name","lights on");
                            map.put("data","");
                            map.put("private","false");
                            return map;
                        }

                        public Map<String, String> getHeaders()
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("Authorization","Bearer "+Classified.ACCESS_TOKEN);
                            return map;
                        }
                    };
                    lights.setBackgroundColor(Color.GREEN);
                    lightsOn[0] =true;
                    queue.add(request);
                }
            }
        });

        fan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fanOn[0])
                {
                    StringRequest request = new StringRequest(Request.Method.POST, Classified.BASE_URL + "devices/events", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(MainActivity.this, "turning off fan ...", Toast.LENGTH_SHORT).show();
                            title.setText("Fan turned off");

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        public Map<String,String> getParams()
                        {
                            Map<String,String> map = new HashMap<>();
                            map.put("name","fan off");
                            map.put("data","");
                            map.put("private","false");
                            return map;
                        }

                        public Map<String, String> getHeaders()
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("Authorization","Bearer "+Classified.ACCESS_TOKEN);
                            return map;
                        }
                    };
                    fan.setBackgroundColor(Color.RED);
                    fanOn[0] =false;
                    queue.add(request);
                }
                else
                {
                    StringRequest request = new StringRequest(Request.Method.POST, Classified.BASE_URL + "devices/events", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(MainActivity.this, "Turning fan on ... ", Toast.LENGTH_SHORT).show();
                            title.setText("Fan turned on");

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        public Map<String,String> getParams()
                        {
                            Map<String,String> map = new HashMap<>();
                            map.put("name","fan on");
                            map.put("data","");
                            map.put("private","false");
                            return map;
                        }

                        public Map<String, String> getHeaders()
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("Authorization","Bearer "+Classified.ACCESS_TOKEN);
                            return map;
                        }
                    };
                    fan.setBackgroundColor(Color.GREEN);
                    fanOn[0] =true;
                    queue.add(request);
                }

            }
        });

        ac.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(acOn[0])
                {
                    StringRequest request = new StringRequest(Request.Method.POST, Classified.BASE_URL + "devices/events", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(MainActivity.this, "turning off ac ...", Toast.LENGTH_SHORT).show();
                            title.setText("AC turned off ");

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        public Map<String,String> getParams()
                        {
                            Map<String,String> map = new HashMap<>();
                            map.put("name","ac off");
                            map.put("data","");
                            map.put("private","false");
                            return map;
                        }

                        public Map<String, String> getHeaders()
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("Authorization","Bearer "+Classified.ACCESS_TOKEN);
                            return map;
                        }
                    };
                    ac.setBackgroundColor(Color.RED);
                    acOn[0] =false;
                    queue.add(request);
                }
                else
                {
                    StringRequest request = new StringRequest(Request.Method.POST, Classified.BASE_URL + "devices/events", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(MainActivity.this, "turning on ac ...", Toast.LENGTH_SHORT).show();
                            title.setText("Ac turned on");

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        public Map<String,String> getParams()
                        {
                            Map<String,String> map = new HashMap<>();
                            map.put("name","ac on");
                            map.put("data","");
                            map.put("private","false");
                            return map;
                        }

                        public Map<String, String> getHeaders()
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("Authorization","Bearer "+Classified.ACCESS_TOKEN);
                            return map;
                        }
                    };
                    ac.setBackgroundColor(Color.GREEN);
                    acOn[0] =true;
                    queue.add(request);
                }

            }
        });

        fridge.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(fridgeOn[0])
                {
                    StringRequest request = new StringRequest(Request.Method.POST, Classified.BASE_URL + "devices/events", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(MainActivity.this, "turning off fridge ...", Toast.LENGTH_SHORT).show();
                            title.setText("Fridge turned off");

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        public Map<String,String> getParams()
                        {
                            Map<String,String> map = new HashMap<>();
                            map.put("name","fridge off");
                            map.put("data","");
                            map.put("private","false");
                            return map;
                        }

                        public Map<String, String> getHeaders()
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("Authorization","Bearer "+Classified.ACCESS_TOKEN);
                            return map;
                        }
                    };
                    fridge.setBackgroundColor(Color.RED);
                    fridgeOn[0] =false;
                    queue.add(request);
                }
                else
                {
                    StringRequest request = new StringRequest(Request.Method.POST, Classified.BASE_URL + "devices/events", new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Toast.makeText(MainActivity.this, "turning on fridge ...", Toast.LENGTH_SHORT).show();
                            title.setText("Fridge turned on");

                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {

                            Toast.makeText(MainActivity.this, "Something went wrong !!!", Toast.LENGTH_SHORT).show();

                        }
                    })
                    {
                        public Map<String,String> getParams()
                        {
                            Map<String,String> map = new HashMap<>();
                            map.put("name","fridge on");
                            map.put("data","");
                            map.put("private","false");
                            return map;
                        }

                        public Map<String, String> getHeaders()
                        {
                            Map<String, String> map = new HashMap<>();
                            map.put("Authorization","Bearer "+Classified.ACCESS_TOKEN);
                            return map;
                        }
                    };
                    fridge.setBackgroundColor(Color.GREEN);
                    fridgeOn[0] =true;
                    queue.add(request);
                }

            }
        });

    }
}
