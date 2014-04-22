package com.example.gameon;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.util.Log;




abstract class Searcher
{
	static public InputStream retrieveStream(String url) {
		  
		DefaultHttpClient client = new DefaultHttpClient();
	      HttpGet getRequest = new HttpGet(url);
		         
		      try {
		          
		         HttpResponse getResponse = client.execute(getRequest);
		         final int statusCode = getResponse.getStatusLine().getStatusCode();
		          
		         if (statusCode != HttpStatus.SC_OK) {
		            
		            return null;
		         }
		 
		         HttpEntity getResponseEntity = getResponse.getEntity();
		         return getResponseEntity.getContent();
	         
		      }
		      catch (IOException e) {
		         getRequest.abort();
		         
		      }
			       
		      return null;
			       
			  }
	
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
			apiURL=Searcher.retrieveStream(apiCall);
			DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
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