package com.example.kladionica.dto;

public class UplataDTO {
	
		private int idKorisnik;
		private double iznosDobitka;
		
		public UplataDTO() {
			
		}

		public UplataDTO(int idKorisnik, double iznosDobitka) {
			this.idKorisnik = idKorisnik;
			this.iznosDobitka = iznosDobitka;
		}

		public int getIdKorisnik() {
			return idKorisnik;
		}

		public void setIdKorisnik(int idKorisnik) {
			this.idKorisnik = idKorisnik;
		}

		public double getIznosDobitka() {
			return iznosDobitka;
		}

		public void setIznosDobitka(double iznosDobitka) {
			this.iznosDobitka = iznosDobitka;
		}
		
		

		

}
