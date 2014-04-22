package com.example.gameon;
import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import android.os.StrictMode;
import android.util.Log;

/*************************************
 * Author: Jeffrey Sall
 * Last Edited:3/30/2014
 * 
 * Class Game:
 * Game represents an individual games 
 * data. It must be provided with a unique
 * integer that represents the game's primary
 * key. It stores this and the game's XML document
 * as member data, and provides functions to
 * Retrieve data(as strings) from the document.  
 * 
 * implements Comparable<Game>:
 * This class implements this interface
 * in order to be used by inherited compare
 * functions in the java SDK. Games are compared
 * based on their ID.
 * 
 * 
 *************************************/

class Game implements Comparable<Game>
{
	protected int gameID;
	protected NodeList focus;
	protected Element node;
	protected Document gameDoc;
	//This is the Static half of the URL to get images
	private final String imgStem="http://thegamesdb.net/banners/_gameviewcache/";
	
	
	/*
	 * Constructor
	 * Parameters: int id
	 * 	The games primary key
	 * 
	 * This constructor get's the games XML document from
	 * the gamesDB.net and stores it as member data so 
	 * functions can parse it for relevent data.
	 */
	public Game(int id)
	{
		gameID=id;
		InputStream xml;
		StrictMode.ThreadPolicy policy = new StrictMode.
		ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy); 
		
		
		try 
		{
			
			
			
			xml=Searcher.retrieveStream("http://thegamesdb.net/api/GetGame.php?id="+gameID);
            DocumentBuilderFactory factory=DocumentBuilderFactory.newInstance();
			DocumentBuilder bob=factory.newDocumentBuilder();
			
			gameDoc=bob.parse(xml);
			xml.close();
			
		} 
		catch (Exception e) 
		{
			e.printStackTrace();
		}
		
		
	}

	//getter for gameID
	public int getGameID()
	{
		return gameID;
	}
	
	
	public String getGameTitle()
	{
		String title=null;
		
		focus=gameDoc.getElementsByTagName( "GameTitle");		
		node=(Element)focus.item(0);
		if(node!=null)
			title=node.getTextContent();
				
		return title;
	}
	
	/*
	 * Below are functions corresponding to
	 * the attributes stored in the games XML
	 * document
	 */
	
	public int getPlatformID()
	{
		int pID=-1;
		focus=gameDoc.getElementsByTagName("PlatformId");
		node=(Element)focus.item(0);
		if(node!=null)
			pID=Integer.parseInt(node.getTextContent());
		
		return pID;
	}
	
	public String getPlatform()
	{
		String platform=null;
		
		focus=gameDoc.getElementsByTagName("Platform");		
		node=(Element)focus.item(0);
		if(node!=null)
			platform=node.getTextContent();
				
		return platform;
	}
	public String releaseDate()
	{
		String rd=null;
		
		focus=gameDoc.getElementsByTagName("ReleaseDate");		
		node=(Element)focus.item(0);
		if(node!=null)
			rd=node.getTextContent();
				
		return rd;
	}
	public String getOverview()
	{
		String oview=null;
		
		focus=gameDoc.getElementsByTagName("Overview");		
		node=(Element)focus.item(0);
		if(node!=null)
			oview=node.getTextContent();
				
		return oview;
	}
	public String getESRB()
	{
		String text=null;
		
		focus=gameDoc.getElementsByTagName("ESRB");		
		node=(Element)focus.item(0);
		if(node!=null)
			text=node.getTextContent();
				
		return text;
	}
	public String[] getGenera()
	{
		String args[];
		String text=null;
		
		focus=gameDoc.getElementsByTagName("genre");
		args=new String[focus.getLength()];
		for(int i=0; i<focus.getLength(); i++)
		{	
			node=(Element)focus.item(i);
		
			if(node!=null)
				text=node.getTextContent();
			args[i]=text;
		}
				
		return args;
	}
	public String getYouTube()
	{
		String text=null;
		
		focus=gameDoc.getElementsByTagName("YouTube");		
		node=(Element)focus.item(0);
		if(node!=null)
			text=node.getTextContent();
				
		return text;
	}
	public String getPublisher()
	{
		String text=null;
		
		focus=gameDoc.getElementsByTagName("Publisher");		
		node=(Element)focus.item(0);
		if(node!=null)
			text=node.getTextContent();
				
		return text;
	}
	public String getDev()
	{
		String text=null;
		
		focus=gameDoc.getElementsByTagName("Developer");		
		node=(Element)focus.item(0);
		if(node!=null)
			text=node.getTextContent();
				
		return text;
	}
	public int getRating()
	{
		String text=null;
		double rating=0;
		focus=gameDoc.getElementsByTagName("Rating");		
		node=(Element)focus.item(0);
		if(node!=null)
		{
			text=node.getTextContent();
			rating=Double.parseDouble(text);
		}
		
		return (int) (rating*100);
	}
	public String[] getFAoriginals()
	{
		String args[];
		String text=null;
		
		focus=gameDoc.getElementsByTagName("original");
		args=new String[focus.getLength()];
		for(int i=0; i<focus.getLength(); i++)
		{	
			node=(Element)focus.item(i);
		
			if(node!=null)
				text=node.getTextContent();
			args[i]=imgStem+text;
		}
				
		return args;
	}
	public String[] getBoxArt()
	{
		String args[];
		String text=null;
		
		focus=gameDoc.getElementsByTagName("boxart");
		args=new String[focus.getLength()];
		for(int i=0; i<focus.getLength(); i++)
		{	
			node=(Element)focus.item(i);
		
			if(node!=null)
				text=node.getTextContent();
			args[i]=imgStem+text;
		}
				
		return args;
	}
	
	
	
	/*This function it part of implementing the Comparable interface.
	*As is standard it return 0 if two games are equal, and not 0
	* if they are not.
	*/
	@Override
	public int compareTo(Game arg0)
	{
	
		
		return this.gameID-arg0.gameID;
	}
	
	
	
	

}