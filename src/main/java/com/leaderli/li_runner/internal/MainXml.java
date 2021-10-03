package com.leaderli.li_runner.internal;

public class MainXml {

    public final DataArray<Data> request;
    public final DataArray<Data> response;

    public MainXml(DataArray<Data> request, DataArray<Data> response) {
        this.request = request;
        this.response = response;
    }

    @Override
    public String toString() {
        return "request:\t" + request + "\r\n" +
                "response:\t" + response + "\r\n";
    }
}
