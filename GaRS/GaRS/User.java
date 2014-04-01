import java.util.LinkedList;




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
	
	
	
}