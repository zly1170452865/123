package com.yuntu.pojo;

public class Sex {
    private int s_id;
    private String s_sex;

    public Sex() {
    }

    public Sex(String s_sex) {
        this.s_sex = s_sex;
    }

    public Sex(int s_id, String s_sex) {
        this.s_id = s_id;
        this.s_sex = s_sex;
    }

    public int getS_id() {
        return s_id;
    }

    public void setS_id(int s_id) {
        this.s_id = s_id;
    }

    public String getS_sex() {
        return s_sex;
    }

    public void setS_sex(String s_sex) {
        this.s_sex = s_sex;
    }

    @Override
    public String toString() {
        return "Sex{" +
                "s_id=" + s_id +
                ", s_sex='" + s_sex + '\'' +
                '}';
    }
}
