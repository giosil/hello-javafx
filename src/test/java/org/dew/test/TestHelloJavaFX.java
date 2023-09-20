package org.dew.test;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

public class TestHelloJavaFX extends TestCase {
  
  public TestHelloJavaFX(String testName) {
    super(testName);
  }
  
  public static Test suite() {
    return new TestSuite(TestHelloJavaFX.class);
  }
  
  public void testApp() throws Exception {
    System.out.println("TestHelloJavaFX");
  }
  
}
