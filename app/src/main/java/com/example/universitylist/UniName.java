package com.example.universitylist;

import java.util.List;

public class UniName {

    private List<String> web_pages;
    private String state_province;
    private String alpha_two_code;
    private String name;
    private String country;
    private List<String> domains;



    public String getState_province() {
        return state_province;
    }

    public void setState_province(String state_province) {
        this.state_province = state_province;
    }

    public String getAlpha_two_code() {
        return alpha_two_code;
    }

    public void setAlpha_two_code(String alpha_two_code) {
        this.alpha_two_code = alpha_two_code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }


    public String getWeb_pages() {
        return web_pages.get(0);
    }

    public String getDomains() {
        return domains.get(0);
    }
}
