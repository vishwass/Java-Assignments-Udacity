package com.udacity.jdnd.course1;

import com.udacity.jdnd.course1.service.FizzBuzzService;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class FizzBuzzServiceTest {

	@Test
	void testFizzBuzz(){
		FizzBuzzService fbs = new FizzBuzzService();

		// check non-divisible numbers return themselves
		assertEquals("1", fbs.fizzBuzz(1));
		assertEquals("47", fbs.fizzBuzz(47));
		assertEquals("121", fbs.fizzBuzz(121));

		// check numbers divisible by 3
		assertEquals("Fizz", fbs.fizzBuzz(3));
		assertEquals("Fizz", fbs.fizzBuzz(333));

		//check numbers divisible by 5
		assertEquals("Buzz", fbs.fizzBuzz(5));
		assertEquals("Buzz", fbs.fizzBuzz(85));

		//check numbers divisible by 3 and 5
		assertEquals("FizzBuzz", fbs.fizzBuzz(15));
		assertEquals("FizzBuzz", fbs.fizzBuzz(75));

		//check invalid inputs
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(0));
		assertThrows(IllegalArgumentException.class, () -> fbs.fizzBuzz(-1));
	}

	@Test
	void testBuzzFizz_HappyPath(){
		FizzBuzzService fbs = new FizzBuzzService();

		assertEquals(5,fbs.buzzFizz("Buzz",1));
		assertEquals(10,fbs.buzzFizz("Buzz",2));
		assertEquals(50,fbs.buzzFizz("Buzz",10));


		assertEquals(3,fbs.buzzFizz("Fizz",1));
		assertEquals(6,fbs.buzzFizz("Fizz",2));
		assertEquals(21,fbs.buzzFizz("Fizz",7));


		assertEquals(15,fbs.buzzFizz("FizzBuzz",1));
		assertEquals(30,fbs.buzzFizz("FizzBuzz",2));
		assertEquals(165,fbs.buzzFizz("FizzBuzz",11));

		assertEquals(4,fbs.buzzFizz("4",4));
		assertEquals(7,fbs.buzzFizz("7",7));
		assertEquals(11,fbs.buzzFizz("11",11));
	}

	@Test
	void testBuzzFizz_unClearRepeatition(){
		FizzBuzzService fbs = new FizzBuzzService();
		//unclear test result - should it detect a FizzBuzz or keep it as Fizz or Buzz provided by input.
		assertEquals(18, fbs.buzzFizz("Fizz",5));
		assertEquals(20, fbs.buzzFizz("Buzz", 3));
	}

	@Test
	void testBuzzFizz_invalidStrings(){
		FizzBuzzService fbs = new FizzBuzzService();
		//does code need to be case sensitive
		assertEquals(3, fbs.buzzFizz("buzz",1));
		//what should be the response for this input
		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("someinvalidstring", 1));
	}

	@Test
	void testBuzzFizz_BoundaryChecking(){
		FizzBuzzService fbs = new FizzBuzzService();

		// Number below 0 ,not throwing exception
		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("-1",1));

		// Integer reoccurence for 1. What is the output here?
		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("1",2));

		// Invalid occurence for fizz and buzz.What should be the output here?
		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("Fizz",0));
		assertThrows(IllegalArgumentException.class, () -> fbs.buzzFizz("Buzz",-1));



	}
}
