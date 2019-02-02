package com.example.cheng.tripactionscc.Presenter;

import com.example.cheng.tripactionscc.Model.Beans.SearchDocs;

import java.util.List;

public interface PresenterCallback {
    void onSuccess(List<SearchDocs> list);
    void onFailure();
    void getSearch(String keyWord);
}
