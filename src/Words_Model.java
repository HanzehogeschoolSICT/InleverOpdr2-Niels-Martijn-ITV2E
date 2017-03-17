import java.util.ArrayList;

public class Words_Model {
	
	private ArrayList<String> foundWords;
	
	public Words_Model(){
		this.foundWords = new ArrayList<String>();
	}
	
	public void addWord(String word){
		this.foundWords.add(word);
	}
	
	public ArrayList<String> getWords(){
		return this.foundWords;
	}
}
