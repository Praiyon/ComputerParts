import java.io.IOException;
import java.util.regex.*;


import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
public class Scrap {
	private final  String  input = "cat";
	private final String REGEX = "\\bcat\\b";
	String url = "http://www.canadacomputers.com";
	public void cpu(){
		String title = "";
		
		try {
			Document doc = Jsoup.connect("http://www.canadacomputers.com/index.php?cPath=4_1210_65").get();
			title = doc.title();
			//Elements links = doc.select("a[href]");  
			Elements links = doc.select(".productListing-data");
			price(links);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}  
		
	
		
	}
	public void titles(){
		try{
			Document doc = Jsoup.connect(url).get();
			Element link = doc.select("a").first();
			//Element linkt = doc.select("a").first().text();
			System.out.println(link);
		
			//Document doco= Jsoup.connect(url + "/" + link.toString()).get();
			System.out.println(link);
			
		}catch(IOException e){
			e.printStackTrace();
		}
		
	}
	public void test(){
		try{
			Document doc = Jsoup.connect(url).get();
			Element link = doc.select("a").first();
			Element cpu = link;
			for (Element x : doc.select("a[href]")){
				if (x.text().equals("Processors (CPUs)")) cpu = x;
			}
			System.out.println(cpu);
			
		
			
		}catch(IOException e){
			e.printStackTrace();
		}
	}
	
	//public intelCpu
	public String priceRegex(String regex, String str){
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(str);
		int count = 0;
		int start = 0, end = 0;
		while(m.find()){
			start = m.start();
			end = m.end();
			count++;
			//System.out.println("Match number "+count);
	        //System.out.println("start(): "+m.start());
	        //System.out.println("end(): "+m.end());
		}
		return(str.substring(start,end));
	}
	public ArrayList<String> price(ArrayList<Element> links){
		ArrayList<String> list = new ArrayList <String>();
		for(Element text : links){
			String str = text.text();
			int len = str.length();
			//String p = priceRegex("[$][0-9]+",str);
			//System.out.println(str + str.length());
			if ( len > 4) list.add(str);
			
		}
		for (String x : list) System.out.println(x);
		ArrayList<String> finalList = new ArrayList<String>();
		for (String x : list){
			String last = x.substring(x.lastIndexOf(" ")+1);
			if (x.length()<30) finalList.add(last);
		}
		for (String x : finalList) System.out.println(x.trim());
		return finalList;
	}
}
	
