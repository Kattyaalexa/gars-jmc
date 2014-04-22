import java.io.InputStream;
import java.net.URL;
import java.net.URLConnection;
import java.util.Collections;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;




public class Recommender 
{
	private LinkedList<Genera> favoriteGenera;
	private User subject;
	private LinkedList<recomendable> recomendations;
	
	public Recommender(User u)
	{
		subject=u;
		favoriteGenera=new LinkedList<Genera>();
		setRecomendations(new LinkedList<recomendable>());
		makeFavoriteGenera();
	}
	private int checkFavs(String s)
	{
		for(Genera g: favoriteGenera)
			if(g.genera.equalsIgnoreCase(s))
				return favoriteGenera.indexOf(g);
		return -1;
	}
	private void makeFavoriteGenera()
	{
		
		
		for(Game g: subject.getFavoriteGames())
			for(String s: g.getGenera())
			{
				int check=checkFavs(s);
				if(check>=0)
					++favoriteGenera.get(check).hits;
				else
					favoriteGenera.add(new Genera(s));
					 
				
			}
		
		Collections.sort(favoriteGenera);
		Collections.reverse(favoriteGenera);
					
	}
	private LinkedList<Game> getRelatedTitles(Game g)
	{
			
		return Searcher.gameSearch(g.getGameTitle(), subject.getAcceptedPlatforms());
					
	}
	private LinkedList<recomendable> measure(LinkedList<Game> gl)	
	{
		LinkedList<recomendable> recos=new LinkedList<recomendable>();
		int w=1;
		int wt=0;
		
		for(Game g:gl)
		{
			w=1;
			for(String s1: g.getGenera())
			{
				for(Genera gen: favoriteGenera)
					if(gen.genera.equalsIgnoreCase(s1))
					{
						w+=gen.hits;
					}
			}
			if(g.getRating()!=0)
				wt=w*g.getRating();
			else
				wt=w;
			recos.add(new recomendable(g, wt));
		}
		
		return recos;
		
	}
	public void recomend()
	{
		LinkedList<recomendable> possibles=new LinkedList<recomendable>();
		boolean isDupe=false;
		for(Game g: subject.getFavoriteGames())
		{
			for(recomendable r:measure(getRelatedTitles(g)))
			{
				isDupe=false;
				if(subject.checkList(subject.getFavoriteGames(), r.title))
						isDupe=true;
				else
				{
					for(recomendable dupe:	possibles)
					{
						if(dupe.title.compareTo(r.title)==0)
						{
							isDupe=true;
							possibles.get(possibles.indexOf(dupe)).weight=
								possibles.get(possibles.indexOf(dupe)).weight*2;
						}
			
					}
						
				}
				if(isDupe==false)
				{
					possibles.add(r);
				}
				
					
			}
		}
		Collections.sort(possibles);
		Collections.reverse(possibles);
		recomendations=possibles;
	}	
	public LinkedList<Genera> getFG()
	{
		return favoriteGenera;
	}
	
	
	public Game getRecomendation() {
		if(recomendations.size()>0)
			return recomendations.get(0).getGame();
		else
			return null;
	}
	public void setRecomendations(LinkedList<recomendable> recomendations) {
		this.recomendations = recomendations;
	}


	private class Genera implements Comparable<Genera>
	{
		protected String genera;
		protected int hits;
		
		public Genera(String g)
		{
			genera=g;
			hits=1;
		}

		@Override
		public int compareTo(Genera o)
		{
				
				return this.hits-o.hits;

		}
		
		public String toString()
		{
			Integer i=hits;
			return genera+"\t"+i.toString();
		}
	}
	private class recomendable implements Comparable<recomendable>
	{
		protected Game title;
		protected int weight;
		public recomendable(Game G, int i)
		{
			title=G;
			weight=i;
					
		}
		public Game getGame()
		{
			return title;
		}
		
		@Override
		public int compareTo(recomendable arg0) {
			return this.weight-arg0.weight;
		}
	
		
		
	}
	public String toString()
	{
		String ms="\n";
		for(recomendable r: recomendations)
		{
			ms=ms+r.title.getGameTitle()+"\t"+r.weight+"\n";
		}
		return ms;
	}
		

}
