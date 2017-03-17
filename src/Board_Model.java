import java.util.Random;

public class Board_Model {
	private Boggle boggle;
	private static final int size = 4;
	private String[][] board;
	private String[] dices;
	
	public Board_Model(Boggle boggle){
		this.boggle = boggle;
		this.dices = new String[] {"iefyeh","eptslu","henips","lecars","avndze","dkunto","snedwo","tgievn","eylugk","fbirxo","bqajmo","aaciot","camdep","aybilt", "hmosar", "wirglu"};
		this.makeBoard();
	}
	
	private void makeBoard(){
		this.board = new String[this.size][this.size];
		int counter = 0;
		for(int y=0; y < this.size; y++){
			for(int x=0; x< this.size; x++){
				String letters = this.dices[counter % this.dices.length];
				Random r = new Random();
				char c = letters.charAt(r.nextInt(letters.length() - 1));
				this.board[y][x] = Character.toString(c);
				counter++;
			}
		}
	}
	
	public String[][] getBoard(){
		return this.board;
	}
	
	public String getValue(int x, int y){
		return this.board[y][x];
	}
	
	public int getSize(){
		return this.size;
	}
}
