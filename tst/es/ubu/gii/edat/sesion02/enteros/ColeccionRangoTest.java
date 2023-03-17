package es.ubu.gii.edat.sesion02.enteros;

import static org.junit.Assert.*;

import java.util.Collection;
import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.ubu.gii.edat.sesion02.enteros.ColeccionRango;

public class ColeccionRangoTest {

	ColeccionRango rango;

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
		rango = new ColeccionRango(3,5,1);
		assertEquals(2,rango.size());
	}

	@Test
	public void testSize2() {
		rango = new ColeccionRango(2,27,3);
		assertEquals(9,rango.size());
	}

	@Test
	public void testIterator() {

		int i=0;
		int [] control = {3,4};

		rango = new ColeccionRango(3,5,1);

		assertEquals(control.length, rango.size());

		Iterator it = rango.iterator(); 
		while(it.hasNext()){

			Integer siguiente = (Integer) it.next();
			assertTrue (siguiente == control[i]);
			i++;

		}

	}

	@Test
	public void testIterator2() {

		int i,j;
		int [] control = new int[9];
		for(i=0, j=2; j<=27; i++, j=j+3){
			control[i]=j;
		}

		rango = new ColeccionRango(2,27,3);

		assertEquals(control.length, rango.size());

		Iterator it = rango.iterator(); 

		i=0;
		while(it.hasNext()){

			Integer siguiente = (Integer) it.next();
			assertTrue (siguiente == control[i]);
			i++;

		}

	}

	@Test
	(expected = IllegalArgumentException.class)
	public void testLimites(){

		rango = new ColeccionRango(27,2,3);

	}

	@Test
	(expected = IllegalArgumentException.class)
	public void testPaso(){

		rango = new ColeccionRango(2,5,8);

	}

	/**
	 * TODO
	 * Comprobar que, aunque NO se implemente el método contains en ColeccionRango, 
	 * la clase es capaz de funcionar correctamente cuando se llaman a estos métodos.
	 * 
	 *  ¿A qué puede ser debido esto?
	 */
	public void testContains() {
		
		Collection c1 = new ColeccionRango(0, 10, 1);
		assertFalse(c1.contains(-1));
		assertTrue(c1.contains(0));
		assertTrue(c1.contains(10));
		assertFalse(c1.contains(10+1));

		Collection c2 = new ColeccionRango(0, 20, 1);
		assertFalse(c1.contains(-1));
		assertTrue(c1.contains(0));
		assertTrue(c1.contains(10));
		assertTrue(c1.contains(10+1));
		
		assertTrue(c2.containsAll(c1));
		assertFalse(c1.containsAll(c2));
		
	}

	@Test
	public void testComplejidad() {
		for( int i = 10; i <= 1000000; i *= 10 ) {
			System.out.println("Comprobando con " + i + " elementos");
			long ini = System.nanoTime();
			Collection c1 = new ColeccionRango(0, i, 1);
			assertFalse(c1.contains(i+1));
			long fin = System.nanoTime();
			System.out.println("tarda " + (fin-ini) + " nanosegundos");
		}
	}
	
}
