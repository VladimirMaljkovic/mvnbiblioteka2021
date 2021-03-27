package rs.ac.bg.fon.nprog.mvnbiblioteka2021.biblioteka;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;


public class AutorTest {
	
	Autor a;

	@BeforeEach
	public void setUp() throws Exception {
		a = new Autor();
	}

	@AfterEach
	public void tearDown() throws Exception {
		a = null;
	}

	@Test
	public void testSetIme() {
		a.setIme("Pera");
		assertEquals("Pera", a.getIme());
	}
	
	@Test
	@DisplayName("Testira uneto null za ime")
	public void testSetImeNull() {		
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setIme(null));
	}
	
	@Test
	@DisplayName("Testira uneto ime manje od 1 karaktera")
	public void testSetImeJednoSlovo() {
		
		assertThrows(java.lang.RuntimeException.class,
				() -> a.setIme("P"));
	}
	
	@Test
	@DisplayName("Testira uneto prezime od 0 karaktera")
	public void testSetImeNulaSlovo() {
		
		assertThrows(java.lang.RuntimeException.class,
				() -> a.setIme(""));
	}

	@Test
	public void testSetPrezime() {
		a.setPrezime("Peric");
		assertEquals("Peric", a.getPrezime());
	}
	
	@Test
	@DisplayName("Testira uneto null za prezime")
	public void testSetPrezimeNull() {		
		assertThrows(java.lang.NullPointerException.class,
				() -> a.setPrezime(null));
	}
	
	@Test
	@DisplayName("Testira uneto prezime manje od 1 karaktera")
	public void testSetPrezimemeJednoSlovo() {
		
		assertThrows(java.lang.RuntimeException.class,
				() -> a.setPrezime("P"));
	}

	@Test
	public void testAutor() {
		assertNotNull(a);
	}

	@Test
	public void testAutorStringString() {
		a = new Autor("Pera", "Peric");
		assertNotNull(a);
		assertEquals("Pera", a.getIme());
		assertEquals("Peric", a.getPrezime());

	}

	@Test
	public void testToString() {
		a.setIme("Pera");
		a.setPrezime("Peric");
		String s = a.toString();
		
		assertTrue(s.contains("Pera"));
		assertTrue(s.contains("Peric"));	}

	
	@ParameterizedTest
	@CsvSource({
		"Pera, Peric, Pera, Peric, true",
		"Pera, Peric, Pera, Mikic, false",
		"Pera, Peric, Mika, Peric, false",
		"Pera, Peric, Mika, Mikic, false",
	})
	public void testEqualsObject(String ime1, String prezime1, String ime2, String prezime2, boolean eq) {
			
		a.setIme(ime1);
		a.setPrezime(prezime1);
		
		Autor b = new Autor(ime2, prezime2);
		
		assertEquals(eq, a.equals(b));
		
	}

}
