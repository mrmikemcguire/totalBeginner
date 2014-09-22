package com.mullenhigh.tutorial;
import java.util.ArrayList;
import junit.framework.TestCase;

public class MyLibraryTest extends TestCase
	{
		private Book	b1;
		private Book	b2;
		private Person	p1;
		private Person	p2;
		private MyLibrary	m1;

		public void testMyLibrary()		// all JUnit test cases must begin with "test"
			{
				MyLibrary m1 = new MyLibrary("Test");
				
				assertEquals("Test", m1.name);
				
				assertTrue(m1.books instanceof ArrayList);
				assertTrue(m1.people instanceof ArrayList);
			}
		
		public void setup()
		// create objects
			{
			b1 = new Book ("Book 1");
			b2 = new Book ("Book 2");
			
			p1 = new Person();
			p2 = new Person();
			p1.setName("Fred");
			p2.setName("Sue");
			
			m1 = new MyLibrary("Test");
			}
		
		public void testAddBook()
		//create test objects		
			{
			setup();
			
			//test initial size is 0
			assertEquals(0, m1.getBooks().size());
			
			m1.addBook(b1);
			m1.addBook(b2);
			
			assertEquals(2, m1.getBooks().size());
			assertEquals(0, m1.getBooks().indexOf(b1));
			assertEquals(1, m1.getBooks().indexOf(b2));

			m1.removeBook(b1);
			assertEquals(1, m1.getBooks().size());
			assertEquals(0, m1.getBooks().indexOf(b2));
			
			m1.removeBook(b2);
			assertEquals(0, m1.getBooks().size());
			}
			
			public void testCheckOut()
				{
				setup();
				
				addItems();
				
				assertTrue("Book did not check out correctly", m1.checkOut(b1,p1));
				assertEquals("Fred", b1.getPerson().getName());
				assertFalse("Book was already checked out",m1.checkOut(b1,p1));
				assertTrue("Book check in failed", m1.checkIn(b1));
				assertFalse ("Book was already checked in",m1.checkIn(b1));
				assertFalse ("Book was never checked out",m1.checkIn(b2));
				
				setup();
				p1.setMaximumBooks(1);
				addItems();
				
				assertTrue("First book did not check out", m1.checkOut(b2, p1));
				assertFalse("Second book should not have checked out", m1.checkOut(b1, p1));
				
				}

			private void addItems()
				{
				m1.addBook(b1);
				m1.addBook(b2);
				m1.addPerson(p1);
				m1.addPerson(p2);
				}
			
			public void testGetBooksForPerson()
				{
				setup();
				addItems();
				assertEquals(0,m1.getBooksForPerson(p1).size());
				
				m1.checkOut(b1, p1);
				
				ArrayList<Book> testBooks = m1.getBooksForPerson(p1);
				assertEquals(1, testBooks.size());
				assertEquals(0, testBooks.indexOf(b1));
				
				
				m1.checkOut(b2, p1);
				assertEquals(2, testBooks.size());
				assertEquals(1, testBooks.indexOf(b2));
				}
			}
	
