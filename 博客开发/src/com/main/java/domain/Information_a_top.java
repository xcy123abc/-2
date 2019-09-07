package com.main.java.domain;

public class Information_a_top {
    private String name;
    private String sex;
    private String height;
    private String origin;
    private String lacation;
    private String education;
    private String professionnal;
    private String garde;
    private String marriage;
    private String body;


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getHeight() {
        return height;
    }

    public void setHeight(String height) {
        this.height = height;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getLacation() {
        return lacation;
    }

    public void setLacation(String lacation) {
        this.lacation = lacation;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getProfessionnal() {
        return professionnal;
    }

    public void setProfessionnal(String professionnal) {
        this.professionnal = professionnal;
    }

    public String getGarde() {
        return garde;
    }

    public void setGarde(String garde) {
        this.garde = garde;
    }

    public String getMarriage() {
        return marriage;
    }

    public void setMarriage(String marriage) {
        this.marriage = marriage;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    @Override
    public String toString() {
        return "Information_a_top{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", height='" + height + '\'' +
                ", origin='" + origin + '\'' +
                ", lacation='" + lacation + '\'' +
                ", education='" + education + '\'' +
                ", professionnal='" + professionnal + '\'' +
                ", garde='" + garde + '\'' +
                ", marriage='" + marriage + '\'' +
                ", body='" + body + '\'' +
                '}';
    }
}
