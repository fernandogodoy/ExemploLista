package br.exemplo.lista;

import static org.junit.Assert.*;

import org.junit.Test;

public class ListaAlocacaoDinamicaTest {

	@Test
	public void addTest() {
		ListaAlocacaoDinamica lista = new ListaAlocacaoDinamica();
		lista.add("1");
		lista.add("2");
		assertEquals("1", lista.get(0));
		assertEquals("2", lista.get(1));
	}

	@Test
	public void testTamanho() {
		ListaAlocacaoDinamica lista = new ListaAlocacaoDinamica();
		assertEquals(Integer.valueOf("10"), lista.size());
		lista.add("1");
		assertEquals(Integer.valueOf("9"), lista.size());
		lista.add("2");
		assertEquals(Integer.valueOf("8"), lista.size());
	}

	@Test
	public void testTamanhoAtual() {
		ListaAlocacaoDinamica lista = new ListaAlocacaoDinamica();
		for (int i = 0; i <= 10; i++) {
			lista.add(String.valueOf(i));
		}
		assertEquals(Integer.valueOf("9"), lista.size());
		lista.add(String.valueOf("11"));
		assertEquals(Integer.valueOf("8"), lista.size());
	}

	@Test
	public void testRemove() {
		ListaAlocacaoDinamica lista = new ListaAlocacaoDinamica();
		lista.add("1");
		assertEquals("1", lista.get(0));
		assertEquals(Integer.valueOf("9"), lista.size());
		lista.add("2");
		assertEquals("2", lista.get(1));
		assertEquals(Integer.valueOf("8"), lista.size());
		lista.remove(0);
		assertEquals("2", lista.get(0));
		assertEquals(Integer.valueOf("9"), lista.size());
		lista.remove(0);
		assertTrue(lista.isEmpty());
	}

	@Test
	public void testToString() {
		ListaAlocacaoDinamica lista = new ListaAlocacaoDinamica();
		lista.add("1");
		assertEquals("[1]", lista.toString());
		lista.add("2");
		assertEquals("[1, 2]", lista.toString());
		lista.remove(0);
		assertEquals("[2]", lista.toString());
		lista.remove(0);
		assertEquals("", lista.toString());
	}

}
