/**
 * 
 */
package com.schoolo2o.test;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

import com.schoolo2o.utils.Console;

/**
 * @author 恒毅
 *
 */
public class ConsoleTest {

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
	}

	/**
	 * Test method for {@link com.schoolo2o.utils.Console#LOG(java.lang.Class, java.lang.String)}.
	 */
	@Test
	public void testLOG() {
		Console.LOG(getClass(), "LOG");
	}

	/**
	 * Test method for {@link com.schoolo2o.utils.Console#ERR(java.lang.Class, java.lang.String)}.
	 */
	@Test
	public void testERR() {
		Console.ERR(getClass(), "ERROR");
	}

}
