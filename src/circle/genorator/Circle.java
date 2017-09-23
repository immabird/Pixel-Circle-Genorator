package circle.genorator;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Circle extends Application{
	
	private int d = 27;
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage stage) throws Exception {
		Grid grid = new Grid(d+1);
		ScrollPane pane = new ScrollPane(new Pane(grid));
		pane.setMaxSize(1000, 800);
		
		// Creates the circle
		grid.createCircle(d);
		
		// Create scene and add pane to it
		Scene scene = new Scene(pane);
		
		// Set scene and show
		stage.setScene(scene);
		stage.sizeToScene();
		stage.setTitle("Circle Generator");
		stage.show();
	}
}