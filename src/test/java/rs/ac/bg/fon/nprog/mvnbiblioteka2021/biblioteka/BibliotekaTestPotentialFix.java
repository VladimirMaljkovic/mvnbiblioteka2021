package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class BibliotekaTestPotentialFix {
	
	public Biblioteka biblioteka;

	@BeforeEach
	public void setUp() throws Exception {
		//samo ovde inicijalizujem intsancu biblioteke
		biblioteka = new Biblioteka();
	}

	@AfterEach
	public void tearDown() throws Exception {
		biblioteka = null;
	}
	
	
	@Test
	public void testDodajKnjigu() {
		Knjiga k = new Knjiga();
		k.setNaslov("Knjiga 1");
		
		biblioteka.dodajKnjigu(k);
		
		assertEquals(1, biblioteka.vratiSveKnjige().size());
		assertEquals(k, biblioteka.vratiSveKnjige().get(0));
		
	}
	
	@Test
	public void testDodajKnjiguNull() {
		assertThrows(java.lang.NullPointerException.class,
				() -> biblioteka.dodajKnjigu(null) );
	}
	
	@Test
	public void testDodajKnjiguDuplikat() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		Knjiga k2 = new Knjiga();
		k2.setIsbn("12345");
		
		biblioteka.dodajKnjigu(k);
		
		
		RuntimeException e = assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.dodajKnjigu(k2) );
		assertEquals("knjiga vec postoji", e.getMessage());
	}

	@Test
	public void testObrisiKnjigu() {
		Knjiga k = new Knjiga();
		biblioteka.dodajKnjigu(k);
		biblioteka.obrisiKnjigu(k);
		
		assertEquals(0, biblioteka.vratiSveKnjige().size());
	}
	
	@Test
	public void testObrisiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.obrisiKnjigu(null));
	}
	
	@Test
	public void testObrisiKnjiguNePostoji() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		biblioteka.dodajKnjigu(k);
		
		Knjiga k2 = new Knjiga();
		k2.setIsbn("23453245");
		
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.obrisiKnjigu(k2));
	}

	@Test
	public void testVratiSveKnjige() {
		Knjiga k = new Knjiga();
		k.setIsbn("12345");
		biblioteka.dodajKnjigu(k);
		
		List<Knjiga> knjige = biblioteka.vratiSveKnjige();
		assertEquals(1, knjige.size());
		assertEquals(k, knjige.get(0));
	}

	@Test
	public void testPronadjiKnjiguNull() {
		assertThrows(java.lang.RuntimeException.class,
				() -> biblioteka.pronadjiKnjigu(null, null, null, null));
	}
	
	@Test
	public void testPronadjiKnjigu() {
		Knjiga k1 = new Knjiga();
		k1.setNaslov("Knjiga o dzungli");
		k1.setIsbn("123");
		biblioteka.dodajKnjigu(k1);
		Knjiga k2 = new Knjiga();
		k2.setNaslov("Dzungla zivota");
		k2.setIsbn("234");
		biblioteka.dodajKnjigu(k2);
		Knjiga k3 = new Knjiga();
		k3.setNaslov("Peepee");
		k3.setIsbn("345");
		biblioteka.dodajKnjigu(k3);
		
		List<Knjiga> knjige = biblioteka.pronadjiKnjigu(null, null, "zung", null);
		assertEquals(2, knjige.size());
		assertTrue(knjige.contains(k1));
		assertTrue(knjige.contains(k2));
		
	}

}