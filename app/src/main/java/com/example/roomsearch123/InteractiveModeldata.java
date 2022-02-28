package com.example.roomsearch123;

import android.graphics.Bitmap;

public class InteractiveModeldata {
    private  String img1;
    private String img2;
    private String img3;
    private  String rent;
    private  String tanentcount;
    private  String  adress;
    private  String  dis;
    private String phone;
    private  String name;


    public InteractiveModeldata(String img1, String img2, String img3, String rent,
                                String tenantcount, String adress, String dis, String phone, String name) {
        this.img1 = img1;
        this.img2 = img2;
        this.img3 = img3;
        this.rent = rent;
        this.tanentcount = tenantcount;
        this.adress = adress;
        this.dis = dis;
        this.phone = phone;
        this.name = name;
    }

    public String getImg1() {
        return img1;
    }

    public void setImg1(String img1) {
        this.img1 = img1;
    }

    public String getImg2() {
        return img2;
    }

    public void setImg2(String img2) {
        this.img2 = img2;
    }

    public String getImg3() {
        return img3;
    }

    public void setImg3(String img3) {
        this.img3 = img3;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
        this.rent = rent;
    }

    public String getTanentcount() {
        return tanentcount;
    }

    public void setTanantcount(String tenantcount) {
        this.tanentcount = tenantcount;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDis() {
        return dis;
    }

    public void setDis(String dis) {
        this.dis = dis;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }
}
