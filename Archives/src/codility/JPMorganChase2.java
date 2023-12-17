package codility;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

public class JPMorganChase2 {
  /**
   * Iterate through each line of input.
   */
  public static void main(String[] args) throws IOException {
    InputStreamReader reader = new InputStreamReader(System.in, StandardCharsets.UTF_8);
    BufferedReader in = new BufferedReader(reader);
    String line;
    while ((line = in.readLine()) != null) {
      String[] st = line.split(";");
      if (st.length >= 2) {
	      String uri1 = convertToCommonURI(st[0]);
	      String uri2 = convertToCommonURI(st[1]);
	      System.out.println(uri1);
	      System.out.println(uri2);
	      System.out.println(uri1.equals(uri2) ? "True" : "False");
      }
    }
  }
  
  static private String convertToCommonURI(String s) {
	s = convertHexEncodings(s);
	String uri = "";
	int ind = 0;
	// Scheme ends with colon :
	// Make scheme upper case
	while (ind < s.length() && s.charAt(ind) != ':') {
		uri += Character.toUpperCase(s.charAt(ind));
		ind++;
	}
	if (ind < s.length() && s.charAt(ind) == ':') {
		uri += ":";
		ind++;
	}
	
	if (ind < s.length() - 2 && "//".equals(s.substring(ind, ind+2))) {
		uri += "//";
		ind += 2;
		
		// host name ends with next slash / or end of string
		// Make host name upper case
		int posOfColon = -1;
		while (ind < s.length() && s.charAt(ind) != '/') {
			uri += Character.toUpperCase(s.charAt(ind));
			ind++;
			if (ind < s.length() && s.charAt(ind) == ':') { 
				posOfColon = ind;
			}
		}
		
		if (posOfColon > -1) {
			String portSt = s.substring(posOfColon + 1, ind);
			if (portSt.length() > 0 && portSt.length() < 6) {
				int port = Integer.valueOf(portSt);
				if (port == 0 || port > 65535) {
					uri += ":80";
				}
			}
		}
		else {
			uri += ":80";
		}
	}
	
	uri += s.substring(ind);
    return uri;
  }
  
  static private String convertHexEncodings(String s) {
	  String encodedSt = "";
	  String hexNums = "0123456789ABCDEF";
	  int decimal, i = 0;
	  for (i = 0; i < s.length() - 2; i++) {
		  if (s.charAt(i) == '%') {
			  i++;
			  decimal = hexNums.indexOf(Character.toUpperCase(s.charAt(i))) * 16;
			  i++;
			  decimal += hexNums.indexOf(Character.toUpperCase(s.charAt(i)));
			  encodedSt += ((char)decimal);
		  } else {
			  encodedSt += s.charAt(i);
		  }
	  }
	  for (; i < s.length(); i++) {
		  encodedSt += s.charAt(i);
	  }
	  return encodedSt;
  }
}


