package com.example.yourdoctor;

public class danhmuc1 {
    private int image;
    private String name;
    private String desc;
    private String age;
    private String cost;
    private String order;
    private String sex;

    public danhmuc1(int image, String name, String desc, String age, String cost, String order, String sex) {
        this.image = image;
        this.name = name;
        this.desc = desc;
        this.age = age;
        this.cost = cost;
        this.order = order;
        this.sex = sex;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getCost() {
        return cost;
    }

    public void setCost(String cost) {
        this.cost = cost;
    }

    public String getOrder() {
        return order;
    }

    public void setOrder(String order) {
        this.order = order;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }
}