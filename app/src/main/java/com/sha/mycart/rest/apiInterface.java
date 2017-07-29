package com.sha.mycart.rest;

import com.sha.mycart.Model.dataclass;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by SHA on 24/7/2017.
 */

public interface apiInterface {

    @GET("v2/59797a19110000e7009edb3e")
    Call<List<dataclass>> getAlldata();

}
