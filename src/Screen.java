import java.util.Random;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Screen {
	
	private GridPane content;
	private TextArea textArea;
	private Boggle boggle;
	
	public Screen(Boggle boggle){
		this.boggle = boggle;
	}

	public void show(Stage primaryStage){
		primaryStage.setTitle("Sort algorithms");
		
		Scene boggleScene = new Scene(this.setupScene());
		primaryStage.setScene(boggleScene);
		primaryStage.setResizable(false);
		primaryStage.show();
	}
	
	private BorderPane setupScene(){ 
		BorderPane root = new BorderPane();
		HBox header = this.setHeader();
		this.content = new GridPane();
		this.showBoard();
		this.content.setAlignment(Pos.BOTTOM_CENTER);
		HBox footer = this.setFooter();
		this.textArea = new TextArea();
		this.textArea.setEditable(false);
		this.textArea.setMaxWidth(120);
		root.setTop(header);
		root.setCenter(this.content);
		root.setLeft(this.textArea);
		root.setBottom(footer);
		return root;
	}
	
	private HBox setHeader(){
		HBox header = new HBox();
		Label text  = new Label("Boggle finder Mw/Nv");
		Font font = new Font("Calibri", 16);
		text.setFont(font);
		text.setTextFill(Color.WHITE);
		header.setAlignment(Pos.TOP_CENTER);
		header.setStyle("-fx-background-color: #42c5f4");
		header.getChildren().add(text);
		return header;
	}
	
	private HBox setFooter(){
		HBox footer = new HBox();
		footer.setAlignment(Pos.BOTTOM_CENTER);
		footer.setStyle("-fx-background-color: #c9c9c9;");
		footer.setPadding(new Insets(10,10,10,10));
		footer.setSpacing(5);
		Button start = this.getStartButton();
		footer.getChildren().add(start);
		return footer;
	}
	
	private Button getStartButton(){
		Button start = new Button("Start");
		start.setOnAction(new StartHandlerClass());
		return start;
	}
	
	private void showBoard(){
		for(int x=0; x < this.boggle.boardModel.getSize(); x++){
			for(int y=0; y< this.boggle.boardModel.getSize(); y++){
				String character = this.boggle.boardModel.getBoard()[x][y].toUpperCase();
				StackPane letter = this.createBar(character);
				this.content.add(letter, x, y);
			}
		}
	}

	private StackPane createBar(String character) {
		StackPane bar = new StackPane();
		Rectangle rect = new Rectangle();
		rect.setFill(Color.ANTIQUEWHITE);
		rect.setStroke(Color.BLACK);
		Label value = new Label(character);
		value.setTextFill(Color.BLACK);
		value.setFont(new Font("Calibri", 16));
		rect.setWidth(50);
		rect.setHeight(50);
		bar.getChildren().addAll(rect, value);
		bar.setLayoutY(0);
		bar.setAlignment(Pos.CENTER);
		return bar;
	}


	public void addLine(String text){
		this.textArea.appendText(text + "\n");
	}





	class StartHandlerClass implements EventHandler<ActionEvent> {
		@Override
		public void handle(ActionEvent e) {
			//START
			boggle.wordFinder.start();
		}
	}
}
