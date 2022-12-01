package com.SEP7.ToolBeer.localDatabase;

public class ForhandlereInfo {

    public String forhandlerNavn;

    public String aabningstider;

    public String website;

   // public String adresse;

    public ForhandlereInfo(String forhandlerNavn, String aabningstider, String website) {
        this.forhandlerNavn = forhandlerNavn;
        this.aabningstider = aabningstider;
    //    this.adresse = adresse;
        this.website = website;
    }

    public String getForhandlerNavn() {
        return forhandlerNavn;
    }

    public void setForhandlerNavn(String forhandlerNavn) {
        this.forhandlerNavn = forhandlerNavn;
    }

    public String getAabningstider() {
        return aabningstider;
    }

    public void setAabningstider(String aabningstider) {

        this.aabningstider = aabningstider;
    }

   // public String getAdresse() {
     //   return adresse;
    //}

    //public void setAdresse(String adresse) {
      //  this.adresse = adresse;
    //}

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}
