package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka;

import rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka.interfaces.IBiblioteka;

import java.util.LinkedList;


/**
 * Klasa koja implementira interfejs IBiblioteka. Predstavlja implementaciju preko liste.
 * 
 * @author Vladimir
 *
 */
public class Biblioteka implements IBiblioteka {
	
	/**
	 * Dvostruko spregnuta lista sa svim knjigama u biblioteci.
	 */
	private LinkedList<Knjiga> knjige = new LinkedList<Knjiga>();
	
	
	//@Override
	public void dodajKnjigu(Knjiga knjiga) {
		if(knjiga==null)
			throw new NullPointerException("knjiga ne sme biti null");
		if(knjige.contains(knjiga))
			throw new RuntimeException("knjiga vec postoji");
		knjige.add(knjiga);
	}

	@Override
	public void obrisiKnjigu(Knjiga knjiga) {
		if(knjiga==null || !knjige.contains(knjiga))
			throw new RuntimeException("knjiga ne sme biti null, mora postojati");
		knjige.remove(knjiga);
	}

	@Override
	public LinkedList<Knjiga> vratiSveKnjige() {
		return knjige;
	}

	//sve samo ne nepotreban komentar neeeeeeeee
	@Override
	public LinkedList<Knjiga> pronadjiKnjigu(Autor autor, String isbn, String naslov, String izdavac) {
		
		if(autor==null && isbn==null && naslov==null && izdavac==null)
			throw new RuntimeException("mora imati bar jedan kriterijum");
		LinkedList<Knjiga> rezultat = new LinkedList<Knjiga>();
		
		for(Knjiga knjiga: knjige)
			if(knjiga.getNaslov().contains(naslov))
				rezultat.add(knjiga);
		
		return rezultat;
	}

}
