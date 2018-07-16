package com.example.arun.git;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface UserService {

    @GET("{name}")
    Call<UserResponse> getUser(@Path("name")String username);
}
