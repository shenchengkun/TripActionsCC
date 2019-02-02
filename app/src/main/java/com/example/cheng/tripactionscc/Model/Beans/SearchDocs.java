package com.example.cheng.tripactionscc.Model.Beans;

import java.util.List;

public class SearchDocs {
    String web_url;

    public String getWeb_url() {
        return web_url;
    }

    public void setWeb_url(String web_url) {
        this.web_url = web_url;
    }

    SearchHeadline headline;
    List<SearchMultiMedia> multimedia;

    public SearchHeadline getHeadline() {
        return headline;
    }

    public void setHeadline(SearchHeadline headline) {
        this.headline = headline;
    }

    public List<SearchMultiMedia> getMultimedia() {
        return multimedia;
    }

    public void setMultimedia(List<SearchMultiMedia> multimedia) {
        this.multimedia = multimedia;
    }
}
