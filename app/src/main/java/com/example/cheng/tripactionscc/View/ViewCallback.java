package com.example.cheng.tripactionscc.View;

import com.example.cheng.tripactionscc.Model.Beans.SearchDocs;

import java.util.List;

public interface ViewCallback {
    void onSuccess(List<SearchDocs> list);
    void onFailure();
}
