package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka;

import java.util.LinkedList;


public class Knjiga {
	
	private String naslov;
	private LinkedList <Autor> autori;
	private String isbn;
	private String izdavac;
	private int izdanje;
	
	public String getNaslov() {
		return naslov;
	}
	
	public void setNaslov(String naslov) {
		this.naslov = naslov;
	}
	
	public LinkedList<Autor> getAutori() {
		return autori;
	}

	public void setAutori(LinkedList<Autor> autori) {
		this.autori = autori;
	}

	public String getIsbn() {
		return isbn;
	}
	
	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}
	
	public String getIzdavac() {
		return izdavac;
	}
	
	public void setIzdavac(String izdavac) {
		this.izdavac = izdavac;
	}
	
	public int getIzdanje() {
		return izdanje;
	}
	
	public void setIzdanje(int izdanje) {
		this.izdanje = izdanje;
	}

	@Override
	public String toString() {
		return "Knjiga [naslov=" + naslov + ", autori=" + autori + ", isbn=" + isbn + ", izdavac=" + izdavac
				+ ", izdanje=" + izdanje + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((isbn == null) ? 0 : isbn.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Knjiga other = (Knjiga) obj;
		if (isbn == null) {
			if (other.isbn != null)
				return false;
		} else if (!isbn.equals(other.isbn))
			return false;
		return true;
	}
	
	
	
	
}

