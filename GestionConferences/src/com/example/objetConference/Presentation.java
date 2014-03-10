package com.example.objetConference;

import java.util.Date;

public class Presentation {

	private String auteur;
	private Date dateDebut;
	private Date dateFin;
	private String lieu;

	private String programme;

	public Presentation(String prog, String auteur, String lieu, Date d,
			Date dd, Date df) {
		this.programme = prog;
		this.auteur = auteur;
		this.lieu = lieu;
		dateDebut = dd;
		dateFin = df;
	}

	public String getAuteur() {
		return auteur;
	}

	public String getLieu() {
		return lieu;
	}

	public Date getDateDebut() {
		return dateDebut;
	}

	public Date getDateFin() {
		return dateFin;
	}

}
