import java.io.File;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.LinkedList;









import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;




class User 
{
	private LinkedList<Game> favoriteGames;
	private LinkedList<String> acceptedPlatforms;	
	private LinkedList<Game> blackList;
	
	
	public User()
	{
		favoriteGames=new LinkedList<Game>();
		acceptedPlatforms= new LinkedList<String>();		
		blackList=new LinkedList<Game>();
	}
	public User(File f)
	{
		favoriteGames=new LinkedList<Game>();
		acceptedPlatforms= new LinkedList<String>();		
		blackList=new LinkedList<Game>();
		try 
		{
			readObject(f);
		} catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void write(File f) throws IOException
	{
		writeObject(f);
	}
	public boolean checkList(LinkedList<Game> list, Game y)
	{
		for(Game x: list)
		{
			if(y.compareTo(x)==0)
				return true;
		}
		
		return false;
	}
	
	public int addToFavs(Game fav)
	{
		if(checkList(favoriteGames, fav))
			return -1;
		
		favoriteGames.add(fav);
		return 1;
	}
	public int addToBlist(Game baddie)
	{
		if(checkList(blackList, baddie))
			return -1;
		
		blackList.add(baddie);
		return 1;
	}
	public int addToPforms(String id)
	{
		for(String i: acceptedPlatforms)
			if(i.equalsIgnoreCase(id))
				return -1;
		
		acceptedPlatforms.add(id);
		return 1;
	}


	public LinkedList<Game> getBlackList() {
		return blackList;
	}


	public void setBlackList(LinkedList<Game> blackList) {
		this.blackList = blackList;
	}

	
	public LinkedList<String> getAcceptedPlatforms() {
		return acceptedPlatforms;
	}


	public void setAcceptedPlatforms(LinkedList<String> acceptedPlatforms) {
		this.acceptedPlatforms = acceptedPlatforms;
	}


	public LinkedList<Game> getFavoriteGames() {
		return favoriteGames;
	}


	public void setFavoriteGames(LinkedList<Game> favoriteGames) {
		this.favoriteGames = favoriteGames;
	}
	
	private void writeObject(File file)
	     throws IOException
	     {
			DocumentBuilderFactory fac=DocumentBuilderFactory.newInstance();
			
			try 
			{
				Document doc=fac.newDocumentBuilder().newDocument();
				Element root=doc.createElement("User");
				Element favs=doc.createElement("Favorites");
				Element ap=doc.createElement("Platforms");
				Element bl=doc.createElement("Blacklist");
				doc.appendChild(root);
				root.appendChild(favs);
				root.appendChild(ap);
				root.appendChild(bl);
				
				
				
	
				for(Game g: favoriteGames)
				{
					Element fgame=doc.createElement("favorite");
					fgame.setTextContent(Integer.toString(g.gameID));
					favs.appendChild(fgame);					
				}
				for(String p: acceptedPlatforms)
				{
					Element pform=doc.createElement("platform");
					pform.setTextContent(p);
					ap.appendChild(pform);					
				}
				for(Game g: blackList)
				{
					Element blgame=doc.createElement("blacklist");
					blgame.setTextContent(Integer.toString(g.gameID));
					bl.appendChild(blgame);					
				}
				TransformerFactory transformerFactory = TransformerFactory.newInstance();
				Transformer transformer = transformerFactory.newTransformer();
				DOMSource source = new DOMSource(doc);
				StreamResult result=new StreamResult(file);
				transformer.transform(source, result);
			} catch (Exception e) 
			{
						e.printStackTrace();
			}
		 
	     }
	 
	private void readObject(File file) throws Exception
	     {
		
			DocumentBuilderFactory fac=DocumentBuilderFactory.newInstance();
			Document doc=fac.newDocumentBuilder().parse(file);
			NodeList focus;
			focus=doc.getElementsByTagName("favorite");
			for(int i=0; i<focus.getLength(); i++)
				addToFavs(new Game(Integer.parseInt(focus.item(i).getTextContent())));
			focus=doc.getElementsByTagName("blacklist");
			for(int i=0; i<focus.getLength(); i++)
				addToBlist(new Game(Integer.parseInt(focus.item(i).getTextContent())));
			focus=doc.getElementsByTagName("platform");
			for(int i=0; i<focus.getLength(); i++)
				addToPforms(focus.item(i).getTextContent());
		
	     }
		 	
	
}