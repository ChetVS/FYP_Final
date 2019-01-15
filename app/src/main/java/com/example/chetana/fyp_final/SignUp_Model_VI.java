package com.example.chetana.fyp_final;

public class SignUp_Model_VI {
    private String FullName;
    private String Email;
    private String Mobile_Number;
    public String password;
    private String Profile;
    private String Lat;
    private String Lng;
    public SignUp_Model_VI(){}

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

   public String getLat() {
        return Lat;
    }

    public String getLng() {
        return Lng;
    }

    public void setLat(String Lat) {
        this.Lat = Lat;
    }

    public void setLng(String Lng) {
        this.Lng = Lng;
    }
}


