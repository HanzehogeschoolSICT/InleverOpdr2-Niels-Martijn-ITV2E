import javafx.stage.Stage;

public class Boggle{
	public Board_Model boardModel;
	public Words_Model wordsModel;
	public WordFinder wordFinder;
	public Screen screen;
	
	public Boggle(Stage primaryStage){
		this.boardModel = new Board_Model(this);
		this.wordsModel = new Words_Model();
		this.wordFinder = new WordFinder(this, this.boardModel);
		
		this.screen = new Screen(this);
		this.screen.show(primaryStage);
		
	}
}
