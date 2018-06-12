
package finalprojectB;

import org.junit.Test;
import junit.framework.TestCase;
import org.junit.Test;
import java.util.Random;
//You can use this as a skeleton for your 3 different test approach
//It is an optional to use this file, you can generate your own test file(s) to test the target function!
// Again, it is up to you to use this file or not!





public class UrlValidatorTest extends TestCase {


   public UrlValidatorTest(String testName) {
      super(testName);
   }

   
      

   

   @Test
   public void testManualTest() {

        //this should return true
        String[] schemes = { "http", "https" };
        UrlValidator urlValidator1 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES); //all
        UrlValidator urlValidator2 = new UrlValidator(schemes); //specific schemes
        UrlValidator urlValidator3 = new UrlValidator(null); //default

        //assertTrue(urlValidator1.isValid("https://www.google.com"));
        //assertTrue(urlValidator1.isValid("ftp://www.soundcloud.com"));
        //assertFalse(urlValidator1.isValid("http://www.soundcl@ud.com")); //returns true instead for first bug

       // assertTrue(urlValidator2.isValid("http://www.google.com")); //returns false due to a different bug than above
        //assertTrue(urlValidator2.isValid("https://www.google.com")); //returns false again
   
       assertFalse(urlValidator2.isValid("ftp://foo.bar.com/")); //should return false as it is not one of the schemes

        //assertTrue(urlValidator3.isValid("https://foo.bar.com/"));//both should return true
      //  assertTrue(urlValidator3.isValid("ftp://foo.bar.com/")); // but are false
   }

   
   
   @Test
   public void testYourFirstPartition()
   {
     //You can use this function to implement your First Partition testing	


   }
   
   public void testYourSecondPartition(){
		 //You can use this function to implement your Second Partition testing	   

   }
   //You need to create more test cases for your Partitions if you need to
   @Test
   public void testIsValid()
   {
  //  You can use this function for programming based testing
      ResultPair[] testUrlScheme = { new ResultPair("http://", true), new ResultPair("ftp://", true),
      new ResultPair("3ht://", false), new ResultPair("http:", false), new ResultPair("://", false) };
  
      ResultPair[] testUrlAuthority = { new ResultPair("www.google.com", true), new ResultPair("go.com", true),
      new ResultPair("256.256.256.256", true), new ResultPair("1.2.3.4.5", false), new ResultPair("aaa", false) };
 
      ResultPair[] testUrlPort = { new ResultPair(":80", true), new ResultPair(":65535", true), new ResultPair("", true),
      new ResultPair(":-1", false), new ResultPair(":65a", false) };
  
      ResultPair[] testPath = { new ResultPair("/test1", true), new ResultPair("/t123", true), new ResultPair("", true),
      new ResultPair("/..", false), new ResultPair("/..//file", false) };
 
      ResultPair[] testUrlQuery = { new ResultPair("?action=view", true), new ResultPair("?action=edit&mode=up", true),
      new ResultPair("", true) };

      UrlValidator urlValidator1 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES); //default schemes to use with these pairs
     // UrlValidator urlValidator2 = new UrlValidator(UrlValidator.ALLOW_ALL_SCHEMES);
      Random random = new Random();

      for (int i = 0; i < 1000; i++){
        StringBuilder buff = new StringBuilder();
        boolean expected = true; 

        int schemeIdx = random.nextInt(5); // get one of the 5 pairs
        buff.append(testUrlScheme[schemeIdx].item); // append the index of the pair at the buffer
        expected &= testUrlScheme[schemeIdx].valid;

        int authIdx = random.nextInt(5);
        buff.append(testUrlAuthority[authIdx].item);
        expected &= testUrlAuthority[authIdx].valid;

        int portIdx = random.nextInt(5); 
        buff.append(testUrlPort[portIdx].item);
        expected &= testUrlPort[portIdx].valid;

        int pathIdx = random.nextInt(5);
        buff.append(testPath[pathIdx].item);
        expected &= testPath[pathIdx].valid;

        int queryIdx = random.nextInt(3);
        buff.append(testUrlQuery[queryIdx].item);
        expected &= testUrlQuery[queryIdx].valid;

        String finalUrl = buff.toString();
        boolean result1 = urlValidator1.isValid(finalUrl);
       // boolean result2 = urlValidator2.isValid(finalUrl);

          System.out.println("Final url:" + finalUrl + " Result1: " + result1);
        if (result1 == true){
          System.out.println("Default scheme validator good!");
        }

        // if (result2 == true){
        //   System.out.println("All scheme validator good!");
        // }
      }


  }
  
}
