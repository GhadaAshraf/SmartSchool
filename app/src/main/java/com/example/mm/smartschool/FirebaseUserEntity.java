package com.example.mm.smartschool;


public class FirebaseUserEntity {

    private String uId;

    private String email;

    private String name;

    private String phonenumber;

    private String password;

    private String student_class;

    private String E_mail;

    public FirebaseUserEntity(){
    }

    public FirebaseUserEntity(String uId, String email, String name, String phonenumber, String E_mail, String password, String student_class) {
        this.uId = uId;
        this.email = email;
        this.name = name;
        this.phonenumber = phonenumber;
        this.E_mail = E_mail;
        this.password = password;
        this.student_class = student_class;
    }

    public String getuId() {
        return uId;
    }

    public String getEmail() {
        return email;
    }

    public String getName() {
        return name;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public String getE_mail() {
        return E_mail;
    }

    public String getPassword() {
        return password;
    }

    public String getStudent_class() {
        return student_class;
    }
}
