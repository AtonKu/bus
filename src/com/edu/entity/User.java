package com.edu.entity;

public class User {

    private String userName;
    private String passWord;
    private int roleType;
    private String createTime;
    private int idDel;
    private int age;
    private int classes;
    private String realName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getRoleType() {
        return roleType;
    }

    public void setRoleType(int roleType) {
        this.roleType = roleType;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public int getIdDel() {
        return idDel;
    }

    public void setIdDel(int idDel) {
        this.idDel = idDel;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getClasses() {
        return classes;
    }

    public void setClasses(int classes) {
        this.classes = classes;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }
}
