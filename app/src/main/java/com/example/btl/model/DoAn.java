package com.example.btl.model;

import org.json.JSONException;
import org.json.JSONObject;

public class DoAn {
    private String TenDoAn,LinkAnh,GiaDoAn;


    public DoAn(){

    }
    public DoAn(JSONObject o) throws JSONException {
        TenDoAn = o.getString("tenDoan");
        LinkAnh = o.getString("image");
        GiaDoAn = o.getString("giaDoan");
    }
    public DoAn(String tenDoAn, String linkAnh, String giaDoAn) {
        TenDoAn = tenDoAn;
        LinkAnh = linkAnh;
        GiaDoAn = giaDoAn;
    }

    public String getTenDoAn() {
        return TenDoAn;
    }

    public void setTenDoAn(String tenDoAn) {
        TenDoAn = tenDoAn;
    }

    public String getLinkAnh() {
        return LinkAnh;
    }

    public void setLinkAnh(String linkAnh) {
        LinkAnh = linkAnh;
    }

    public String getGiaDoAn() {
        return GiaDoAn;
    }

    public void setGiaDoAn(String giaDoAn) {
        GiaDoAn = giaDoAn;
    }
}

