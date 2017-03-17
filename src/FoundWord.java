import java.util.ArrayList;

public class FoundWord {

	private String word;
	private ArrayList<int[]> path;
	
	public FoundWord(String word, ArrayList<int[]> path) {
		this.word = word;
		this.path = path;
	}
	
	public String getWord(){
		return this.word;
	}
	
	public ArrayList<int[]> getPath(){
		return this.path;
	}

}
