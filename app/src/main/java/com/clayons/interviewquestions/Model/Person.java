package com.clayons.interviewquestions.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jaychung on 11/16/15.
 */
public class Person implements Parcelable {
    public static final Creator<Person> CREATOR = new Creator<Person>() {
        public Person createFromParcel(Parcel source) {
            return new Person(source);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNum;
    private String photoUrl;
    private boolean favorited;

    public Person(String firstName, String lastName, Integer age, String phoneNum, String photoUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNum = phoneNum;
        this.age = age;
        this.photoUrl = photoUrl;
    }

    public Person() {

    }

    protected Person(Parcel in) {
        this.firstName = in.readString();
        this.lastName = in.readString();
        this.age = (Integer) in.readValue(Integer.class.getClassLoader());
        this.phoneNum = in.readString();
        this.photoUrl = in.readString();
        this.favorited = in.readByte() != 0;
    }

    public boolean isFavorited() {
        return favorited;
    }

    public void setFavorited(boolean favorited) {
        this.favorited = favorited;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public void setPhotoUrl(String photoUrl) {
        this.photoUrl = photoUrl;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.firstName);
        dest.writeString(this.lastName);
        dest.writeValue(this.age);
        dest.writeString(this.phoneNum);
        dest.writeString(this.photoUrl);
        dest.writeByte(favorited ? (byte) 1 : (byte) 0);
    }
}
