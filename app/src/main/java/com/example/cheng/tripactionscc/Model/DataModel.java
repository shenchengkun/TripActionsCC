package com.example.cheng.tripactionscc.Model;

import com.example.cheng.tripactionscc.Model.Beans.SearchResponse;
import com.example.cheng.tripactionscc.Presenter.PresenterCallback;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class DataModel {

    private final PresenterCallback presenterCallback;
    private static final String BASE_URL = "https://api.nytimes.com/";
    private static final String API_KEY = "wGHGNcHlKeJ4D6PlMfTN75AbFTE19wQq";
    private final HttpService httpService;

    public DataModel(PresenterCallback presenterCallback) {
        this.presenterCallback = presenterCallback;

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        httpService = retrofit.create(HttpService.class);
    }

    public void getSearch(String keyWord){
        httpService.getSearch(API_KEY,keyWord).enqueue(new Callback<SearchResponse>() {
            @Override
            public void onResponse(Call<SearchResponse> call, Response<SearchResponse> response) {
                if(response.isSuccessful()){
                    SearchResponse searchResponse = response.body();
                    presenterCallback.onSuccess(searchResponse.getResponse().getDocs());
                }
            }

            @Override
            public void onFailure(Call<SearchResponse> call, Throwable t) {

            }
        });
    }
}
