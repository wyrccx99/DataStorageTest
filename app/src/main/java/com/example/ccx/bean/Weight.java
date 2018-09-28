package com.example.ccx.bean;

import xiaofei.library.datastorage.annotation.ClassId;
import xiaofei.library.datastorage.annotation.ObjectId;

/**
 * Created by ccx on 18/09/21.
 */
@ClassId("Weight")
public class Weight {


    private String barcodesx;
    private String barcodeall;
    private int netweight;

    public String getBarcodeall() {
        return barcodeall;
    }

    public void setBarcodeall(String barcodeall) {
        this.barcodeall = barcodeall;
    }

    public int getNetweight() {
        return netweight;
    }

    public void setNetweight(int netweight) {
        this.netweight = netweight;
    }

    public String getBarcodesx() {
        return barcodesx;
    }

    public void setBarcodesx(String barcodesx) {
        if(barcodesx.length()>14){
            barcodesx = barcodesx.substring(6,20);
        }
        this.barcodesx = barcodesx;
    }


    @Override
    public String toString() {
        return "Weight{" +
                "barcodesx='" + barcodesx + '\'' +
                ", barcodeall='" + barcodeall + '\'' +
                ", netweight=" + netweight +
                '}';
    }

}
