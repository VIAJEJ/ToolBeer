package com.SEP7.ToolBeer.primitivDatabase;

import java.util.ArrayList;

public class Database {

    private ArrayList<SamarbejdspartnereInfo> SamarbejdspartnereAListe = new ArrayList<>();
    private static Database database;

    private Database() {
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Saling Parkeringshus","Østergade 25, 8000 Aarhus C", "00.00 - 24.00", 24.00));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Bruuns Galleri Parkeringshus", "M.P. Bruunsgade 25, 8000 Aarhus C", "00.00-24.00", 22));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Navitas Parkeringshus", "Inge Lehmanns Gade 10, 8000 Aarhus C", "00.00-24.00", 17));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("DGI Huset", "Værkmestergade 17, 8000 Aarhus C", "00.00-24.00", 20));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("ARoS Parkeringshus", "ARoS Allé, 8000 Aarhus C", "00.00-24.00", 17));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Busgaden Parkeringshus", "Telefonsmøgen 1, 8000 Aarhus C", "00.00-24.00", 17));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Dokk1", "Kystvejen", "00:00-23:59", 44));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Havneholmen","Thit Jensens Gade","00:00-23:59", 44));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Z-huset", "Bernhart-Jensens Boulevard", "00:00-23:59", 30));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Nicolinehus", "Nicolinehus", "00:00-23:59", 22));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Brynet", "Risskov brynet", "00:00-23:59", 22));
        SamarbejdspartnereAListe.add(new SamarbejdspartnereInfo("Møllehatten", "Møllehatten", "00:00-23:59", 22));

    }

    public static Database getInstance () {
        if (database == null) {
            database = new Database();
        }
        return database;
    }

    public ArrayList<SamarbejdspartnereInfo> getSamarbejdspartnereAListe() {
    return SamarbejdspartnereAListe;
    }

}
