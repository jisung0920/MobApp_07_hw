package com.example.jisung.mobapp_06;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jisung on 2017-04-06.
 */

public class Student implements Parcelable{
    private String name="";
    private String hakno="";
    private int age =0;
    private int isman=1;

    public Student(String name, String hakno, int age,int isman) {
        this.name = name;
        this.hakno = hakno;
        this.age = age;
        this.isman = isman;

    }

    @Override
    public String toString() {
        String str =name +":"+hakno+":"+age+":"+isman;
        return str;
    }

    protected Student(Parcel in) {
        name = in.readString();
        hakno = in.readString();
        age = in.readInt();
        isman = in.readInt();
    }

    public static final Creator<Student> CREATOR = new Creator<Student>() {
        @Override
        public Student createFromParcel(Parcel in) {
            return new Student(in);
        }

        @Override
        public Student[] newArray(int size) {
            return new Student[size];
        }
    };

    public void setStudent(String n, String h, int age,int isman){
        this.name = n;
        this.hakno = h;
        this.age = age;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(hakno);
        dest.writeInt(age);
        dest.writeInt(isman);


    }
}
