import java.io.*;
import java.net.URL;
import java.util.Scanner;
import java.util.HashMap;
import java.util.ArrayList;

public class InetDisplay {
	public static void main(String[] args){
		
	}
	
	static HashMap<String, Boolean> hmap = new HashMap<String, Boolean>();
	static ArrayList<String> address = new ArrayList<String>();
	static String url = "http://www.whitworth.edu/cms/";
	
	public static void newURL(String s){
		try{
			URL url1 = new URL(s);
			BufferedReader rdr = new BufferedReader(new InputStreamReader(url1.openStream()));
			String line = rdr.readLine();
		} catch (Exception ex) {System.out.printf("OOPS");}
	}
}
