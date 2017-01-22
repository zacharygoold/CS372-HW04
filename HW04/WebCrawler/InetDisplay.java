import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.regex.*;

/**
 * in this class you have a web spider that can search through 100
 * URL's and find things, cool eh?
 * @author zgoold17
 *	*randomly crashes
 *	*fixed 1/22/17
 */

public class InetDisplay {
	public static void main(String[] args){
		//variable to keep track of how many sites
		int siteCount = 0;
		newURL(url);
		//while there is not 100 yet, continue on
		while (siteCount < 100){
			String url2 = null;
			for (Map.Entry<String, Boolean> e : hmap.entrySet()){
				if (e.getValue() == false){
					url2 = e.getKey();
				}
				address.add(url2);
				hmap.put(url2, true);
			}
			//increment the count
			siteCount++;
		}
		//find the pattern in the url, aka inact newURL
		for ( int i1 = 0; i1< hmap.size(); i1++){
			newURL(hmap.get(i1));
		}
		
		//display the address's
		for (int i = 0; i < hmap.size(); i++){
			System.out.printf("Address's: \r" + hmap.get(i) + "\n");
		}
		
	}
	//create hashmap to keep track of addresses and if they are in the array
	static HashMap<String, Boolean> hmap = new HashMap<String, Boolean>();
	//create list to store the address's
	static ArrayList<String> address = new ArrayList<String>();
	//the url we are using (WHITWORTH BABY)
	static String url = "http://www.whitworth.edu/cms/";
	
	
	/**
	 * newURL will enact the bufferedreader and use REGEX to compile
	 * matcher and pattern regex commands
	 * @param s
	 * Some copied from slide
	 */
	public static void newURL(String s){
		try{
			URL url1 = new URL(s);
			BufferedReader rdr = new BufferedReader(new InputStreamReader(url1.openStream()));
			String line = rdr.readLine();
			//search for the pattern provided
			while (line != null) {
				Pattern finder = Pattern.compile("<a\\s*?href=\"(http:.*?)\"");
				Matcher matcher = finder.matcher(line); 
				if (matcher.find()){
					hmap.put(matcher.group(1), false);
				}
				line = rdr.readLine();
			}
			
		} catch (Exception ex) {System.out.printf("OOPS");}
	}
}
