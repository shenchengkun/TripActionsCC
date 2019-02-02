package com.example.cheng.tripactionscc.Presenter;

import com.example.cheng.tripactionscc.Model.Beans.SearchDocs;
import com.example.cheng.tripactionscc.Model.DataModel;
import com.example.cheng.tripactionscc.View.ViewCallback;

import java.util.List;

public class Presenter implements PresenterCallback{

    private final ViewCallback viewCallback;
    private final DataModel dataModel;

    public Presenter(ViewCallback viewCallback) {
        this.viewCallback = viewCallback;
        dataModel = new DataModel(this);
    }
    @Override
    public void onSuccess(List<SearchDocs> list) {
        viewCallback.onSuccess(list);
    }

    @Override
    public void onFailure() {

    }

    @Override
    public void getSearch(String keyWord) {
        dataModel.getSearch(keyWord);
    }

}
