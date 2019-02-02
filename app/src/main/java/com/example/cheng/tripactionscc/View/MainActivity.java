package com.example.cheng.tripactionscc.View;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.WindowManager;
import android.widget.SearchView;

import com.example.cheng.tripactionscc.Model.Beans.SearchDocs;
import com.example.cheng.tripactionscc.Model.Beans.SearchMultiMedia;
import com.example.cheng.tripactionscc.Presenter.Presenter;
import com.example.cheng.tripactionscc.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements ViewCallback{
    Presenter presenter;
    RecyclerView recyclerView;
    RecyclerViewAdapter recyclerViewAdapter;
    List<SearchDocs> list;
    SearchView searchView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search_view);
        presenter = new Presenter(this);
        list = new ArrayList<>();
        recyclerView = findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewAdapter = new RecyclerViewAdapter(this,list);
    }

    @Override
    protected void onStart() {
        super.onStart();
        recyclerView.setAdapter(recyclerViewAdapter);

        recyclerViewAdapter.setOnViewItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                SearchDocs searchDocs = list.get(position);
                List<SearchMultiMedia> searchMultiMediaList = searchDocs.getMultimedia();
                startDetail(searchMultiMediaList.size()>0?"https://www.nytimes.com/"+
                                searchMultiMediaList.get(0).getUrl():"",
                        searchDocs.getHeadline().getMain(),searchDocs.getWeb_url());
            }
        });

        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                searchView.clearFocus();
                presenter.getSearch(s);
                return true;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        presenter = null;
    }

    @Override
    public void onSuccess(List<SearchDocs> list) {
        this.list.clear();
        this.list.addAll(list);
        recyclerViewAdapter.notifyDataSetChanged();
    }

    @Override
    public void onFailure() {

    }

    private void startDetail(String url,String headLine,String webUrl){
        Intent i = new Intent(this, DetailActivity.class);
        i.putExtra("url", url);
        i.putExtra("headLine",headLine);
        i.putExtra("webUrl", webUrl);
        startActivity(i);
    }
}
