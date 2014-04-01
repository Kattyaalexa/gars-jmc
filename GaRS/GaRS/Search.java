import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;




abstract class Searcher
{
	
	public static LinkedList<Game> gameSearch(String title, LinkedList<String> pforms)
	{
		InputStream apiURL;
		LinkedList<Game> relatedTitles=new LinkedList<Game>();
		
		Document gamesDoc;
		String apiStem;
		NodeList focus;
		Element node;
		apiStem=title;
		for(String pform: pforms)
			apiStem=apiStem+"&platform="+pform;
		
		try
		{
			String apiCall="http://thegamesdb.net/api/GetGamesList.php?name="+apiStem;
			URL url=new URL(apiCall);
			URLConnection connect=url.openConnection();
			connect.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows; U; Windows NT 6.1; en-GB;    "
					+ "					 rv:1.9.2.13) Gecko/20101203 Firefox/3.6.13 (.NET CLR 3.5.30729)");
			
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			apiURL=connect.getInputStream();
			DocumentBuilder bob=factory.newDocumentBuilder();
			gamesDoc=bob.parse(apiURL);
			apiURL.close();
		
			
			focus=gamesDoc.getElementsByTagName("id");
			for(int i=0; i<focus.getLength(); i++)
			{	
				node=(Element)focus.item(i);
			
				if(node!=null)
				{
					relatedTitles.add(new Game(Integer.parseInt(node.getTextContent())));
				}
					
			}

				
		}
		
		catch (Exception e) 
		{
			System.out.println(e.getLocalizedMessage());
		}
			
		return relatedTitles;
					
	}
		
	


}