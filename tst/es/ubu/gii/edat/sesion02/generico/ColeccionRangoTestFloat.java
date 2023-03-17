package es.ubu.gii.edat.sesion02.generico;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import es.ubu.gii.edat.sesion02.generico.ColeccionRango;

public class ColeccionRangoTestFloat {

	ColeccionRango<Float> rango;
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testSize() {
		rango = new ColeccionRango<Float>( new Float(3), new Float(5), new Float(0.25));
		assertEquals(8,rango.size());
	}

	@Test
	public void testSize2() {
		rango = new ColeccionRango<Float>( new Float(3.5), new Float(5.5), new Float(0.5));
		assertEquals(4,rango.size());
	}
	
	@Test
	public void testIterator() {
		
		int i=0;
		float [] control = {(float) 3.0,(float) 3.25,(float) 3.5,(float) 3.75,(float) 4.0,(float) 4.25,(float) 4.5,(float) 4.75};
		
		rango = new ColeccionRango<Float>( new Float(3), new Float(5), new Float(0.25));
		
		assertEquals(control.length, rango.size());
		
		Iterator<Float> it = rango.iterator(); 
		while(it.hasNext()){
			
			Float siguiente = it.next();
			assertTrue (siguiente == control[i]);
			i++;
			
		}
		
	}

	@Test
	public void testIterator2() {
		
		int i;
		float j = (float) 3.5;
		float [] control = new float[4];
		for(i=0; j<5.5; i++, j=(float)(j+0.5)){
			control[i]=j;
		}
		
		rango = new ColeccionRango<Float>( new Float(3.5), new Float(5.5), new Float(0.5));
		
		assertEquals(control.length, rango.size());
		
		Iterator<Float> it = rango.iterator(); 

		i=0;
		while(it.hasNext()){
			
			Float siguiente = it.next();
			assertTrue (siguiente == control[i]);
			i++;
			
		}
		
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testLimites(){
		
		rango = new ColeccionRango<Float>((float)27.0,(float)2.0,(float)3.0);
		
	}
	
	@Test
	(expected = IllegalArgumentException.class)
	public void testPaso(){
		
		rango = new ColeccionRango<Float>((float)2.0,(float)5.2,(float)8.0);
		
	}
	
}
