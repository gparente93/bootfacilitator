package it.core.facilitator.boot;
import static org.junit.Assert.assertTrue;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import org.junit.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import lombok.extern.log4j.Log4j2;

@SpringBootTest
@ExtendWith(SpringExtension.class)
@AutoConfigureMockMvc
@Log4j2
public class BootTests {

	@Test
	public void contextLoads() {
	}

    @Test
    public void pingApi() throws Exception {
    	boolean testUrl =pingUrl("https://api.stakdek.de/api/qr/gen?data=test");
    	assertTrue(testUrl);
    }
    
    public static boolean pingUrl(final String address) { 
    	 try {
    	  final URL url = new URL(address);
    	  final HttpURLConnection urlConn = (HttpURLConnection) url.openConnection();
    	  urlConn.setConnectTimeout(1000 * 10); // mTimeout is in seconds
    	  final long startTime = System.currentTimeMillis();
    	  urlConn.connect();
    	  final long endTime = System.currentTimeMillis();
    	  if (urlConn.getResponseCode() == HttpURLConnection.HTTP_OK) {
    	   log.info("Time (ms) : " + (endTime - startTime));
    	   log.info("Ping to "+address +" was success");
    	   return true;
    	  }
    	 } catch (final MalformedURLException e1) {
    	  e1.printStackTrace();
    	 } catch (final IOException e) {
    	  e.printStackTrace();
    	 }
    	 return false;
    	}

}