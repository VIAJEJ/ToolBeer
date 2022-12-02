package com.SEP7.ToolBeer.localDatabase;

import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;

import java.util.ArrayList;

public class Seed {

    private final ArrayList<Distributors> ForhandlereAListe = new ArrayList<>();
    private static Seed seedInstance;

    private Seed() {
        ForhandlereAListe.add(new Distributors("DK","SuperBrugsen", "07:00 - 21:00", "www.superbrugsen.coop.dk/"));
        ForhandlereAListe.add(new Distributors("DK","Kvickly", "07:00-21:00", "www.kvickly.coop.dk/"));
        ForhandlereAListe.add(new Distributors("DK", "Dagli’Brugsen", "07:00-21.00", "www.daglibrugsen.coop.dk"));
        ForhandlereAListe.add(new Distributors("DK","Irma", "08:00-21:00", "www.irma.dk"));
        ForhandlereAListe.add(new Distributors("DK","Coop 365discount", "08:00-22:00", "www.coop365.coop.dk"));
        ForhandlereAListe.add(new Distributors("DK","Fakta", "07:00-21:00", "www.fakta.dk"));
        ForhandlereAListe.add(new Distributors("DK","Bilka", "07:00-22:00", "www.bilka.dk"));
        ForhandlereAListe.add(new Distributors("DK","Føtex","07:00-21:00", "www.føtex.dk"));
        ForhandlereAListe.add(new Distributors("DK","Netto (Ikke alle)", "08:00-22:00", "www.netto.dk"));
        ForhandlereAListe.add(new Distributors("DK","Salling", "10:00-18:00", "www.salling.dk"));
        ForhandlereAListe.add(new Distributors("DK","Væskebalancen", "12:00-19:00", "www.facebook.com/vaeskebalancenaarhus"));
    }

    public static Seed getInstance () {
        if (seedInstance == null) {
            seedInstance = new Seed();
        }
        return seedInstance;
    }

    public ArrayList<Distributors> getForhandlereAListe() {
        return ForhandlereAListe;
    }
}
