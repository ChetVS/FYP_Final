package com.example.chetana.fyp_final;

public class SignUp_Model_Monitor {
    private String FullName;
    private String Email;
    private String Mobile_Number;
    public String password;
    private String Profile;

    public SignUp_Model_Monitor(){}

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        this.FullName = fullName;
    }

    public String getEmail()
    {
        return Email;
    }

    public void setEmail(String email) {
        this.Email = email;
    }

    public String getMobile_Number()
    {
        return Mobile_Number;
    }

    public void setMobile_Number(String mobile_Number)
    {
        this.Mobile_Number = mobile_Number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password)
    {
        this.password = password;
    }

    public String getProfile() {
        return Profile;
    }

    public void setProfile(String profile) {
        this.Profile = profile;
    }
}
