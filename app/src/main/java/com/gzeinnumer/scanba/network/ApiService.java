package com.gzeinnumer.scanba.network;

import com.gzeinnumer.scanba.model.ResponsePlat;

import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
    @FormUrlEncoded
    @POST("read.php")
    Call<ResponsePlat> getIzin(@Field("plat") String plat);
}
