package com.yuntu.pojo;

public class StuInfo {
    private int stu_id;
    private String stu_name;
    private String stu_pwd;
    private String stu_age;
    private String stu_address;
    private String stu_major;

    /*一对一*/
    private Sex sex;

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public StuInfo() {
    }

    public StuInfo(String stu_name, String stu_pwd, String stu_age, String stu_address, String stu_major, Sex sex) {
        this.stu_name = stu_name;
        this.stu_pwd = stu_pwd;
        this.stu_age = stu_age;
        this.stu_address = stu_address;
        this.stu_major = stu_major;
        this.sex = sex;
    }

    public StuInfo(int stu_id, String stu_name, String stu_pwd, String stu_age, String stu_address, String stu_major, Sex sex) {
        this.stu_id = stu_id;
        this.stu_name = stu_name;
        this.stu_pwd = stu_pwd;
        this.stu_age = stu_age;
        this.stu_address = stu_address;
        this.stu_major = stu_major;
        this.sex = sex;
    }

    public int getStu_id() {
        return stu_id;
    }

    public void setStu_id(int stu_id) {
        this.stu_id = stu_id;
    }

    public String getStu_name() {
        return stu_name;
    }

    public void setStu_name(String stu_name) {
        this.stu_name = stu_name;
    }

    public String getStu_pwd() {
        return stu_pwd;
    }

    public void setStu_pwd(String stu_pwd) {
        this.stu_pwd = stu_pwd;
    }

    public String getStu_age() {
        return stu_age;
    }

    public void setStu_age(String stu_age) {
        this.stu_age = stu_age;
    }

    public String getStu_address() {
        return stu_address;
    }

    public void setStu_address(String stu_address) {
        this.stu_address = stu_address;
    }

    public String getStu_major() {
        return stu_major;
    }

    public void setStu_major(String stu_major) {
        this.stu_major = stu_major;
    }

    @Override
    public String toString() {
        return "StuInfo{" +
                "stu_id=" + stu_id +
                ", stu_name='" + stu_name + '\'' +
                ", stu_pwd='" + stu_pwd + '\'' +
                ", stu_age='" + stu_age + '\'' +
                ", stu_address='" + stu_address + '\'' +
                ", stu_major='" + stu_major + '\'' +
                ", sex=" + sex +
                '}';
    }
}
