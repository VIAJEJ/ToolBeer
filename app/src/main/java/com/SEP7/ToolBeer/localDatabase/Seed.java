package com.SEP7.ToolBeer.localDatabase;

import com.SEP7.ToolBeer.localDatabase.Entity.Distributors;
import com.SEP7.ToolBeer.localDatabase.Entity.Products;

import java.util.ArrayList;

public class Seed {

    private final ArrayList<Distributors> ForhandlereAListe = new ArrayList<>();
    private final ArrayList<Products> products = new ArrayList<>();
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
        products.add(new Products("Gose To Hollywood 2.0", "3,8%", "Gose with oranges", "Our dazzling Gose with oranges, Gose To Hollywood. Salty, sour, light gose brewed with the best fruits California can offer. Best consumed on warm summer days or on the red carpet."));
        products.add(new Products("House Of Pale", "5,5%", "PALE ALE", "House Of Pale is one of the recipes we’ve taken from our beloved mad laboratory in Copenhagen, BRUS. A New England Pale ale with Equanot hops. It’s seen many changes and tweaks over this year, experimenting with hop doses and overall ‘crispiness’ - and now we’re pretty sure we’ve got exactly what we’ve been looking for."));
        products.add(new Products("45 Days Organic Pilsner", "4,7%", "ORGANIC PILSNER", "The slower the fermentation, the better a pilsner tastes. We took no risks and decided to ferment and mature our pilsner no less than 45 days. It would be a sin to rush it after all. Enjoy all the crisp complexity that belongs in the golden lager we all love, and enjoy it more knowing it was made only with the highest respect and admiration for the style."));
        products.add(new Products("Whirl Domination", "6,2%", "IPA", "Whirl Domination is the first IPA to be brewed in our shiny new brewhouse in Svinninge, so naturally, we were curious as to what our new baby could do! We pushed the hops to the limit, packing in as much aroma as possible to this fresh AF beauty. Thus begins a new era of our hoppy world domination - drink it, and embrace the future…"));
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
    public ArrayList<Products> getProducts() {return products;}
}
