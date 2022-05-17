package com.androidaflevering.smartpark.primitivDatabase;

public class SamarbejdspartnereInfo {

    public String samarbejdspartnerNavn;

    public String aabningstider;

    public double timePris;

    public String adresse;

    public SamarbejdspartnereInfo(String samarbejdspartnerNavn, String adresse, String aabningstider, double timePris) {
        this.samarbejdspartnerNavn = samarbejdspartnerNavn;
        this.aabningstider = aabningstider;
        this.timePris = timePris;
        this.adresse = adresse;
    }

    public String getSamarbejdspartnerNavn() {
        return samarbejdspartnerNavn;
    }

    public void setSamarbejdspartnerNavn(String samarbejdspartnerNavn) {
        this.samarbejdspartnerNavn = samarbejdspartnerNavn;
    }

    public String getAabningstider() {
        return aabningstider;
    }

    public void setAabningstider(String aabningstider) {
        this.aabningstider = aabningstider;
    }

    public double getTimePris() {
        return timePris;
    }

    public void setTimePris(double timePris) {
        this.timePris = timePris;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

}
