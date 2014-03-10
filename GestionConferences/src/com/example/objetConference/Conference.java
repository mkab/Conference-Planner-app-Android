package com.example.objetConference;

import java.util.ArrayList;
import java.util.Date;

public class Conference {
  private String nom;
  private Date dateDebut, dateFin;
  String description;
  ArrayList<Presentation> presentations;

  public Conference(String name, String descr, Date dd, Date df) {
    nom = name;
    description = descr;
    dateDebut = dd;
    dateFin = df;
    presentations = new ArrayList<Presentation>();
  }

  public String getNom() {
    return nom;
  }

  public Date getDateDebut() {
    return dateDebut;
  }

  public Date getDateFin() {
    return dateFin;
  }

  public String getDescription() {
    return description;
  }

  public ArrayList<Presentation> getPresentations() {
    return presentations;
  }
}
