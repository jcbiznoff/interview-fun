package com.clayons.interviewquestions.Model;

/**
 * Created by jaychung on 11/16/15.
 */
public class Person {

    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNum;
    private String photoUrl;
    private boolean isLiked;

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public Integer getAge() {
        return age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public boolean isLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    public Person(String firstName, String lastName, Integer age, String phoneNum, String photoUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.photoUrl = photoUrl;
    }

    public Person() {

    }
}
