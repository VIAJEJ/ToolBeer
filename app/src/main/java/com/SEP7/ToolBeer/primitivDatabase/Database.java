package com.SEP7.ToolBeer.primitivDatabase;

import java.util.ArrayList;

public class Database {

    private ArrayList<ForhandlereInfo> ForhandlereAListe = new ArrayList<>();
    private static Database database;

    private Database() {
        ForhandlereAListe.add(new ForhandlereInfo("SuperBrugsen", "07:00 - 21:00", "www.superbrugsen.coop.dk/"));
        ForhandlereAListe.add(new ForhandlereInfo("Kvickly", "07:00-21:00", "www.kvickly.coop.dk/"));
        ForhandlereAListe.add(new ForhandlereInfo("Dagli’Brugsen", "07:00-21.00", "www.daglibrugsen.coop.dk"));
        ForhandlereAListe.add(new ForhandlereInfo("Irma", "08:00-21:00", "www.irma.dk"));
        ForhandlereAListe.add(new ForhandlereInfo("Coop 365discount", "08:00-22:00", "www.coop365.coop.dk"));
        ForhandlereAListe.add(new ForhandlereInfo("Fakta", "07:00-21:00", "www.fakta.dk"));
        ForhandlereAListe.add(new ForhandlereInfo("Bilka", "07:00-22:00", "www.bilka.dk"));
        ForhandlereAListe.add(new ForhandlereInfo("Føtex","07:00-21:00", "www.føtex.dk"));
        ForhandlereAListe.add(new ForhandlereInfo("Netto (Ikke alle)", "08:00-22:00", "www.netto.dk"));
        ForhandlereAListe.add(new ForhandlereInfo("Salling", "10:00-18:00", "www.salling.dk"));
        ForhandlereAListe.add(new ForhandlereInfo("Væskebalancen", "12:00-19:00", "www.facebook.com/vaeskebalancenaarhus"));
    }

    public static Database getInstance () {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public ArrayList<ForhandlereInfo> getForhandlereAListe() {
        return ForhandlereAListe;
    }
}
