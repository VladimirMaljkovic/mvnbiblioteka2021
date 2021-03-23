package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka;

/**
 * Klasa koja predstavlja autora knjige
 * 
 * Autor ima 2 string vrednosti - ime i prezime
 * 
 * @author Vladimir Maljkovic
 * @version 0.1
 *
 */
public class Autor {
	/**
	 * ime autora kao String
	 */
	private String ime;
	/**
	 * prezime autora kao String
	 */
	private String prezime;
	
	/**
	 * Vraca ime autora
	 * @return Ime autora kao String
	 */
	public String getIme() {
		return ime;
	}
	
	/**
	 * Postavlja ime autora na novu vrednost
	 * @param ime - ime autora kao String
	 * @throws java.lang.NullPointerException ako je uneto ime null
	 * @throws java.lang.RuntimeException ako je uneto ime krace od 2 znaka
	 */
	public void setIme(String ime) {
		if(ime == null)
			throw new NullPointerException("Ime ne sme biti null");
		if(ime.length() < 2)
			throw new RuntimeException("Ime mora imati vise od 2 znaka");
		
		this.ime = ime;
	}
	/**
	 * Vraca prezime autora
	 * @return Prezime autora kao string
	 */
	public String getPrezime() {
		return prezime;
	}
	
	/**
	 * Postavlja prezime autora na novu vrednost
	 * @param prezime - prezime autora kao String
	 * @throws java.lang.NullPointerException ako je uneto prezime null
	 * @throws java.lang.RuntimeException ako je uneto prezime krace od 2 znaka
	 */
	public void setPrezime(String prezime) {
		if(prezime == null)
			throw new NullPointerException("prezime ne sme biti null");
		if(prezime.length() < 2)
			throw new RuntimeException("prezime mora imati vise od 2 znaka");
		this.prezime = prezime;
	}
	
	/**
	 * Konstruktor koji samo inicijalizuje objekat.
	 */
	public Autor() {
		super();
	}
	
	/**
	 * Konsturktor koji inicijalizuje objekat i postavlja vrednosti za ime i prezime autora
	 * @param ime - Ime autora kao String
	 * @param prezime - Prezime autora kao String
	 */
	public Autor(String ime, String prezime) {
		super();
		setIme(ime);
		setPrezime(prezime);
	}

	/**
	 * @return Vraca String sa svim podacima o autoru
	 */
	@Override
	public String toString() {
		return "Autor [ime=" + ime + ", prezime=" + prezime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((ime == null) ? 0 : ime.hashCode());
		result = prime * result + ((prezime == null) ? 0 : prezime.hashCode());
		return result;
	}

	/**
	 * Poredi dva autora i vraca true ako su isti
	 * 
	 * Autori se porede po imenu i prezimenu i oba moraju biti ista.
	 * 
	 * @return
	 * <ul>
	 * 		<li>true ako su oba objekta klase Autor i imaju ista imena i prezimena</li>
	 *	<li>false u svim ostalim slucajevima</li>
	 *</ul>
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Autor other = (Autor) obj;
		if (ime == null) {
			if (other.ime != null)
				return false;
		} else if (!ime.equals(other.ime))
			return false;
		if (prezime == null) {
			if (other.prezime != null)
				return false;
		} else if (!prezime.equals(other.prezime))
			return false;
		return true;
	}
	
	
}
