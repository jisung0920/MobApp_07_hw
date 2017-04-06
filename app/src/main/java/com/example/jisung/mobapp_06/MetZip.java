package com.example.jisung.mobapp_06;

import android.os.Parcel;
import android.os.Parcelable;



/**
 * Created by jisung on 2017-04-06.
 */

public class MetZip implements Parcelable{
    private String name;
    private String number;
    private String[] menu;
    private String homepage;
    private String regitD;
    private int catNum;

    public MetZip(String name, String number, String[] menu, String homepage, String regitD, int catNum) {
        this.name = name;
        this.number = number;
        this.menu = menu;
        this.homepage = homepage;
        this.regitD = regitD;
        this.catNum = catNum;
    }

    protected MetZip(Parcel in) {
        name = in.readString();
        number = in.readString();
        menu = in.createStringArray();
        homepage = in.readString();
        regitD = in.readString();
        catNum = in.readInt();
    }

    public String getName() {
        return name;
    }

    public int getCatNum() {
        return catNum;
    }

    @Override
    public String toString() {
        String str = this.name;
        return str;
    }

    public void setMetZip(String name, String number, String[] menu, String homepage, String regitD, int catNum) {
        this.name = name;
        this.number = number;
        this.menu = menu;
        this.homepage = homepage;
        this.regitD = regitD;
        this.catNum = catNum;
    }

    public String getNumber() {
        return number;
    }

    public String getMenu(int i) {
        if(i==0){
            return this.menu[0];
        }
        else if(i==1)
            return this.menu[1];
        else
            return this.menu[2];
    }

    public String getHomepage() {
        return homepage;
    }

    public String getRegitD() {
        return regitD;
    }

    public static final Creator<MetZip> CREATOR = new Creator<MetZip>() {
        @Override
        public MetZip createFromParcel(Parcel in) {
            return new MetZip(in);
        }

        @Override
        public MetZip[] newArray(int size) {
            return new MetZip[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(number);
        dest.writeStringArray(menu);
        dest.writeString(homepage);
        dest.writeString(regitD);
        dest.writeInt(catNum);
    }
}
