package com.example.arun.git;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MainActivity extends AppCompatActivity {

    EditText username;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username=findViewById(R.id.username);







//
//        Retrofit.Builder builder = new Retrofit.Builder()
//                .baseUrl("https://codingninjas.in/api/v2/")
//                .addConverterFactory(GsonConverterFactory.create());
//
//        Retrofit retrofit = builder.build();
//
//        CoursesService service = retrofit.create(CoursesService.class);
//
//        Call<CoursesResponse> call = service.getCourses();
//
//        call.enqueue(new Callback<CoursesResponse>() {
//            @Override
//            public void onResponse(Call<CoursesResponse> call, Response<CoursesResponse> response) {
//
//                CoursesResponse coursesResponse = response.body();
//                ArrayList<Course> courses = coursesResponse.getData().courses;
//                titles.clear();
//                for(int i = 0;i<courses.size();i++){
//                    titles.add(courses.get(i).courseName);
//                }
//                progressBar.setVisibility(View.GONE);
//                listView.setVisibility(View.VISIBLE);
//
//            }
//
//            @Override
//            public void onFailure(Call<CoursesResponse> call, Throwable t) {
//
//            }
//        });

    }



    public void get(View view)
    {
        Retrofit.Builder builder = new Retrofit.Builder()
                .baseUrl("https://api.github.com/users/")
                .addConverterFactory(GsonConverterFactory.create());

        Retrofit retrofit = builder.build();
        UserService service=retrofit.create(UserService.class);
        Call<UserResponse> call=service.getUser(username.getText().toString());
        call.enqueue(new Callback<UserResponse>() {
            @Override
            public void onResponse(Call<UserResponse> call, Response<UserResponse> response) {
                UserResponse userResponse =response.body();
                TextView showName=findViewById(R.id.name);
                showName.setText(userResponse.getName());

            }

            @Override
            public void onFailure(Call<UserResponse> call, Throwable t) {
                Log.i("Error",t.getMessage());
            }
        });
    }
}
