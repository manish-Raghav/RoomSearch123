package com.example.roomsearch123;

public class InteractiveModeldata {
    private  String image1;
    private String image2;
    private String image3;
    private  String rent;
    private  String tenantcount;
    private  String  adress;
    private  String  disc;
    private String phone;
    private  String Name;

    public InteractiveModeldata(String image1, String image2, String image3, String rent,
                                String tenantcount, String adress, String disc, String phone, String name) {
        this.image1 = image1;
        this.image2 = image2;
        this.image3 = image3;
        this.rent = rent;
        this.tenantcount = tenantcount;
        this.adress = adress;
        this.disc = disc;
        this.phone = phone;
        Name = name;
    }

    public String getImage1() {
        return image1;
    }

    public void setImage1(String image1) {
        this.image1 = image1;
    }

    public String getImage2() {
        return image2;
    }

    public void setImage2(String image2) {
        this.image2 = image2;
    }

    public String getImage3() {
        return image3;
    }

    public void setImage3(String image3) {
        this.image3 = image3;
    }

    public String getRent() {
        return rent;
    }

    public void setRent(String rent) {
             this.rent = rent;
    }

    public String getTenantcount() {
        return tenantcount;
    }

    public void setTenantcount(String tenantcount) {
        this.tenantcount = tenantcount;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getDisc() {
        return disc;
    }

    public void setDisc(String disc) {
        this.disc = disc;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }
}
