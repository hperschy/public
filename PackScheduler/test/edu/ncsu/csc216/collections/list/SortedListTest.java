package edu.ncsu.csc216.collections.list;

import static org.junit.Assert.*;

import org.junit.Test;

/**
 * Tests SortedList
 * @author Hunter Perschy
 * @author Zach Scott
 */
public class SortedListTest {

	/**
	 * Tests constructor
	 */
	@Test
	public void testSortedList() {
		SortedList<String> list = new SortedList<String>();
		assertEquals(0, list.size());
		assertFalse(list.contains("apple"));
		
		String string1 = "Billy";
	    String string2 = "Bob";
		String string3 = "Jr.";
		String string4 = "Peanut";
		String string5 = "Butter";
		String string6 = "Jelly";
	    String string7 = "Parker";
		String string8 = "Brooks";
		String string9 = "PB&Jsforlifez";
		String string10 = "string";
		String string11 = "word";
		list.add(string1);
		list.add(string2);
		list.add(string11);
		list.add(string10);
		list.add(string9);
		list.add(string8);
		list.add(string7);
		list.add(string6);
		list.add(string5);
		list.add(string4);
		list.add(string3);
		assertEquals(11, list.size());
		assertTrue(list.contains("Billy"));
		assertFalse(list.contains(""));
	}

	/**
	 * Tests add().
	 */
	@Test
	public void testAdd() {
		SortedList<String> list = new SortedList<String>();
		
		list.add("banana");
		assertEquals(1, list.size());
		assertEquals("banana", list.get(0));
		
		list.add("bana");
		list.add("banan");
		list.add("bananana");
		assertEquals("bana", list.get(0));
		assertEquals("banan", list.get(1));
		assertEquals("banana", list.get(2));
		assertEquals("bananana", list.get(3));

		try {
			list.add(null);
			fail("Created null object");
		} catch (NullPointerException e) {
			assertEquals(4, list.size());
		}
		

		try {
			list.add("banana");
			fail("Duplicate added");
		} catch (IllegalArgumentException e) {
			assertEquals(4, list.size());
		}
		
	}
	
	/**
	 * Tests get()
	 */
	@Test
	public void testGet() {
		SortedList<String> list = new SortedList<String>();
		
		try {
			list.get(0);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(0, list.size());
		}
		

		list.add("bana");
		list.add("banan");
		list.add("bananana");
		assertEquals(3, list.size());

		try {
			list.get(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//skip line
		}

		try {
			list.get(list.size());
			fail();
		} catch (IndexOutOfBoundsException e) {
			//skip line
		}
	}
	
	/**
	 * Tests remove().
	 */
	@Test
	public void testRemove() {
		SortedList<String> list = new SortedList<String>();
		
		try {
			list.remove(1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			//skip line
		}

		list.add("bana");
		list.add("banan");
		list.add("bananana");
		list.add("banananana");
		assertEquals(4, list.size());

		try {
			list.remove(-1);
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		try {
			list.remove(list.size());
			fail();
		} catch (IndexOutOfBoundsException e) {
			assertEquals(4, list.size());
		}

		list.remove(list.size() / 2);
		assertEquals(3, list.size());
		assertEquals("bana", list.get(0));
		assertEquals("banananana", list.get(list.size() - 1));

		list.remove(list.size() - 1);
		assertEquals(2, list.size());
		assertEquals("bana", list.get(0));
		assertFalse(list.get(list.size() - 1).equals("banananana"));

		list.remove(0);
		assertEquals(1, list.size());
		assertFalse(list.get(list.size() - 1).equals("bana"));

		list.remove(0);
		assertEquals(0, list.size());
	}
	
	/**
	 * Tests indexOf().
	 */
	@Test
	public void testIndexOf() {
		SortedList<String> list = new SortedList<String>();
		

		assertEquals(-1, list.indexOf("1"));

		list.add("1");
		list.add("11");
		list.add("111");
		list.add("1111");
		assertEquals(4, list.size());

		assertEquals(0, list.indexOf("1"));
		assertEquals(1, list.indexOf("11"));
		assertEquals(2, list.indexOf("111"));
		assertEquals(3, list.indexOf("1111"));
		assertEquals(-1, list.indexOf("22"));
		assertEquals(-1, list.indexOf("2"));
		assertEquals(-1, list.indexOf("Scary"));
		assertEquals(-1, list.indexOf("Larry"));

		try{
			list.indexOf(null);
			fail();
		} catch(NullPointerException e) {
			//skip line
		}
	}
	
	/**
	 * Tests clear().
	 */
	@Test
	public void testClear() {
		SortedList<String> list = new SortedList<String>();


		list.add("1");
		list.add("11");
		list.add("111");
		list.add("1111");

		list.clear();

		assertEquals(0, list.size());
	}

	/**
	 * Tests isEmpty().
	 */
	@Test
	public void testIsEmpty() {
		SortedList<String> list = new SortedList<String>();
		

		assertTrue(list.isEmpty());

		list.add("1");

		assertTrue(!list.isEmpty());
		assertFalse(list.isEmpty());
	}

	/**
	 * Tests contains().
	 */
	@Test
	public void testContains() {
		SortedList<String> list = new SortedList<String>();
		

		assertFalse(list.contains("1"));

		list.add("1");
		list.add("11");
		list.add("111");
		list.add("1111");

		assertTrue(list.contains("1"));
		assertTrue(list.contains("11"));
		assertTrue(list.contains("111"));
		assertTrue(list.contains("1111"));
		assertFalse(list.contains("2"));
		assertFalse(list.contains("22"));
		assertFalse(list.contains("222"));
	}
	
	/**
	 * Tests equals().
	 */
	@Test
	public void testEquals() {
		SortedList<String> list1 = new SortedList<String>();
		SortedList<String> list2 = new SortedList<String>();
		SortedList<String> list3 = new SortedList<String>();
		

		list1.add("1");
		list1.add("11");
		list1.add("111");
		list1.add("1111");
		list2.add("1");
		list2.add("11");
		list2.add("111");
		list2.add("1111");
		list3.add("2");
		list3.add("22");
		list3.add("222");
		list3.add("2222");

		assertTrue(list1.equals(list2));
		assertFalse(list1.equals(list3));
		assertFalse(list2.equals(list3));
	}
	
	/**
	 * Tests hashCode().
	 */
	@Test
	public void testHashCode() {
		SortedList<String> list1 = new SortedList<String>();
		SortedList<String> list2 = new SortedList<String>();
		SortedList<String> list3 = new SortedList<String>();
		

		list1.add("1");
		list1.add("11");
		list1.add("111");
		list1.add("1111");
		list2.add("1");
		list2.add("11");
		list2.add("111");
		list2.add("1111");
		list3.add("2");
		list3.add("22");
		list3.add("222");
		list3.add("2222");

		assertTrue(list1.hashCode() == list2.hashCode());
		assertFalse(list1.hashCode() == list3.hashCode());
		assertFalse(list3.hashCode() == list2.hashCode());
	}
}
 