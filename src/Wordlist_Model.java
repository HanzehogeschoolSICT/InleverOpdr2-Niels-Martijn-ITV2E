import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Wordlist_Model {

	private HashMap<String, ArrayList<String>> wordList;
	private Path textPath = FileSystems.getDefault().getPath("wordList.txt");
	
	public Wordlist_Model(){
		this.loadFile();
	}
	
	private void loadFile(){
		try {
			Stream lines = Files.lines(this.textPath);
			this.initHashMapKey();
			lines.forEach(s->this.addWord((String) s));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void initHashMapKey(){
		this.wordList = new HashMap<String, ArrayList<String>>();
		for(int x = 0; x < 26; x++){
			char letter = (char) (x + 'a');
			this.wordList.put(Character.toString(letter), new ArrayList<String>());
		}
	}
	
	private void addWord(String s){
		String firstLetter = s.substring(0,1);
		if(this.wordList.containsKey(firstLetter)){
			this.wordList.get(firstLetter).add(s);
		}
	}
	
	public boolean checkWord(String word){
		if(word.length() >=3){
			String firstLetter = word.substring(0,1);
			return this.wordList.get(firstLetter).contains(word);
		}
		return false;
	}
	
	public boolean checkSubWord(String word){
		String firstLetter = word.substring(0,1);
		int wordLength = word.length();
		for(String fullWord : this.wordList.get(firstLetter)){
			if(fullWord.length() > wordLength){
				if(fullWord.substring(0, (wordLength)).equals(word)){
					return true;
				}
			}
		}
		return false;
	}
}
