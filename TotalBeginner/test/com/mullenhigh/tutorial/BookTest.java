package com.mullenhigh.tutorial;

import junit.framework.TestCase;

public class BookTest extends TestCase
	{
		public void testBook()
			{
				Book b1 = new Book("Great Expectations");
				assertEquals("Great Expectations", b1.title);
				assertEquals("unknown author", b1.author);
					
			}
		public void testGetPerson()
			{
				Book b2 = new Book("War and Peace");
				Person p2 = new Person();
				p2.setName("Elvis");
				
				//method to say who the book belongs to
				b2.setPerson(p2);
				
				//get the name of the person who has the book
//				Person testPerson = b2.getPerson();
//				String testName = testPerson.getName();
				String testName = b2.getPerson().getName(); //This replaces the above two lines
				
				assertEquals("Elvis", testName);
			}
	}
