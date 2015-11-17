package com.clayons.interviewquestions.Model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by jaychung on 11/16/15.
 */
public class Person implements Parcelable {
    private String firstName;
    private String lastName;
    private Integer age;
    private String phoneNum;
    private String photoUrl;
    private boolean isLiked;

    public Person(String firstName, String lastName, Integer age, String phoneNum, String photoUrl) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.photoUrl = photoUrl;
    }

    public Person() {

    }

    public Person(Parcel in) {
        String[] data = new String[6];
        in.readStringArray(data);
        firstName = data[0];
        lastName = data[1];
        age = Integer.parseInt(data[2]);
        phoneNum = data[3];
        photoUrl = data[4];
        isLiked = Boolean.parseBoolean(data[5]);

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

    public boolean isLiked() {
        return isLiked;
    }

    public void setIsLiked(boolean isLiked) {
        this.isLiked = isLiked;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel out, int flags) {
        String[] data = new String[] {
                firstName,
                lastName,
                Integer.toString(age),
                phoneNum,
                photoUrl,
                Boolean.toString(isLiked)
        };
        out.writeStringArray(data);
    }

    public static final Parcelable.Creator CREATOR = new Parcelable.Creator() {
        public Person createFromParcel(Parcel in) {
            return new Person(in);
        }

        public Person[] newArray(int size) {
            return new Person[size];
        }
    };

}
