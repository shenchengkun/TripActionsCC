package com.example.cheng.tripactionscc.Model;

import com.example.cheng.tripactionscc.Model.Beans.SearchResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface HttpService {
    @GET("svc/search/v2/articlesearch.json")
    Call<SearchResponse> getSearch(@Query("api-key") String apiKey,
                                   @Query("q") String keyWord);
}
