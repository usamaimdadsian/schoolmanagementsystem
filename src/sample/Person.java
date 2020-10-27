package sample;

import java.time.LocalDate;

public class Person
{
    String name;
    String fatherName;
    String gender;
    String cnic;
    LocalDate birthday;
    String religion;
    String phoneNumber;
    String email;
    String address;

    public Person(String name, String fatherName,String cnic, String gender, LocalDate birthday, String religion, String  phoneNumber,  String address) {
        this.name = name;
        this.fatherName = fatherName;
        this.cnic=cnic;
        this.gender = gender;
        this.birthday = birthday;
        this.religion = religion;
        this.phoneNumber = phoneNumber;
        this.address = address;
    }


    /*--------------------------------------
            SETTERS AND GETTERS
-------------------------------------------*/

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getCnic() {
        return cnic;
    }

    public void setCnic(String cnic) {
        this.cnic = cnic;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    public void setBirthday(LocalDate birthday) {
        this.birthday = birthday;
    }

    public String getReligion() {
        return religion;
    }

    public void setReligion(String religion) {
        this.religion = religion;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Person{" + "name=" + name + '}';
    }
}
