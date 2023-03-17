package es.ubu.gii.edat.sesion02.generico;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.ubu.gii.edat.sesion02.generico.ColeccionRango;

public class ColeccionRangoTestEnteros {

	ColeccionRango<Integer> rango;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
		rango = new ColeccionRango<Integer>(3,5,1);
		assertEquals(2,rango.size());
	}

	@Test
	public void testSize2() {
		rango = new ColeccionRango<Integer>(2,27,3);
		assertEquals(9,rango.size());
	}
	
	@Test
	public void testIterator() {
		
		int i=0;
		int [] control = {3,4};
		
		rango = new ColeccionRango<Integer>(3,5,1);
		
		assertEquals(control.length, rango.size());
		
		Iterator<Integer> it = rango.iterator(); 
		while(it.hasNext()){
			
			Integer siguiente = it.next();
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
		
		rango = new ColeccionRango<Integer>(2,27,3);
		
		assertEquals(control.length, rango.size());
		
		Iterator<Integer> it = rango.iterator(); 

		i=0;
		while(it.hasNext()){
			
			Integer siguiente = it.next();
			assertTrue (siguiente == control[i]);
			i++;
			
		}
		
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testLimites(){
		
		rango = new ColeccionRango<Integer>(27,2,3);
		
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testPaso(){
		
		rango = new ColeccionRango<Integer>(2,5,8);
		
	}
	
}
