package com.wira.app;

/**
 * Created by Lenovo on 07/04/2016.
 */
public class Location {

    private int fid;
    private String x;
    private String y;

    public Location(int fid, String x, String y) {
        this.fid = fid;
        this.x = x;
        this.y = y;
    }

    public int getFid() {
        return fid;
    }

    public void setFid(int fid) {
        this.fid = fid;
    }

    public String getX() {
        return x;
    }

    public void setX(String x) {
        this.x = x;
    }

    public String getY() {
        return y;
    }

    public void setY(String y) {
        this.y = y;
    }
}
