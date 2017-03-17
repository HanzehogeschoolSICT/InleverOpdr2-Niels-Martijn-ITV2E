import java.util.ArrayList;

public class WordFinder {
	
	private Wordlist_Model wordlist;
	private Boggle boggle;
	private Board_Model boardmodel;

	public WordFinder(Boggle boggle, Board_Model boardmodel){
		this.boggle = boggle;
		this.wordlist = new Wordlist_Model();
		this.boardmodel = boardmodel;
	}
	
	public void start(){
		for(int y = 0; y < this.boardmodel.getSize(); y++){
			for(int x = 0; x < this.boardmodel.getSize(); x++){
				ArrayList<int[]> path = new ArrayList<int[]>();
				
				this.find(this.boardmodel.getValue(x,y), x,y,path);
			}
		}
	}
	
	private void find(String word, int x, int y, ArrayList<int[]> originalPath){
		ArrayList<int[]> copy = new ArrayList<int[]>();
		for (int[] coords: originalPath) {
		  copy.add(coords.clone());
		}
		copy.add(this.getCoords(x, y));
		if(this.wordlist.checkWord(word) == true){
			this.boggle.wordsModel.addWord(word);
			this.boggle.screen.addLine(word);
			this.printPath(word, copy);
		}
		if(this.wordlist.checkSubWord(word) == true){
			this.findSurrounding(word, x, y, copy);
		}
	}
	
	private int[] getCoords(int x, int y){
		int[] coords = new int[2];
		coords[0] = y;
		coords[1] = x;
		return coords;
	}
	
	private boolean inPath(int x, int y, ArrayList<int[]> path){
		for(int[] coords : path){
			if(coords[0] == y && coords[1] == x){
				return true;
			}
		}		
		return false;
	}
	
	private void findSurrounding(String word, int x, int y, ArrayList<int[]> path){
		this.checkNew(word, x, (y - 1), path); //North
		this.checkNew(word, (x + 1), (y - 1), path); //NorthEast
		
		this.checkNew(word, (x + 1), y, path); //East
		this.checkNew(word, (x + 1), (y + 1), path); //SouthEast
		
		this.checkNew(word, x, (y + 1), path); //South
		this.checkNew(word, (x - 1), (y + 1), path); //SouthWest
		
		this.checkNew(word, (x - 1), y, path); //West
		this.checkNew(word, (x - 1), (y - 1), path); //NorthWest
	}
	
	private void checkNew(String word, int x, int y, ArrayList<int[]> path){
		if(x >= 0 && x < this.boardmodel.getSize() && y >= 0 && y < this.boardmodel.getSize()){
			if(this.inPath(x, y, path) == false){
				word = word + this.boardmodel.getValue(x, y);
				this.find(word, x, y, path);
			}
		}
	}
	
	private void printPath(String word, ArrayList<int[]> path){
		System.out.print(word + " (");
		for(int[] coords : path){
			System.out.print(coords[0]);
			System.out.print(",");
			System.out.print(coords[1]);
			System.out.print(";");
		}
		System.out.println(")");
	}

}
