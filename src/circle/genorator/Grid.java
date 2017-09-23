package circle.genorator;

import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

public class Grid extends VBox{
	
	private int size;
	private int elementSize = 10;
	
	public Grid(int size){
		super();
		this.size = size;
		HBox tmp;
		for(int i=0; i<this.size; i++){
			tmp = new HBox();
			for(int j=0; j<this.size; j++){
				tmp.getChildren().add(new Box());
			}
			this.getChildren().add(tmp);
		}
	}
	
	public void createCircle(double d){
		// (x – h)2 + (y – k)2 = r2, with the center being at the point (h, k)
		// (y-k)^2 = (r^2)-(x-h)^2
		// (+-)(y-k) = sqrt((r^2)-((x-h)^2))
		// y = (+-)(sqrt((r^2)-((x-h)^2)))+k
		// h = k = r to keep circle in the first quadrant.
		// Find y
		double r = d/2;
		for(int x=0; x<r*2; x++){
			double tmp = Math.sqrt(Math.pow(r,2)-Math.pow(x-r,2));
			int ny = (int)((-1*tmp)+r);
			int y = (int)(-1*(ny-r)+r);
			setFilled(x, y);
			setFilled(y, x);
			setFilled(x, ny);
			setFilled(ny, x);
		}
	}
	
	private void setFilled(int x, int y){
		HBox row = (HBox)this.getChildren().get(y);
		((Box)row.getChildren().get(x)).setFilled();
	}
	
	private void setEmpty(int x, int y){
		HBox row = (HBox)this.getChildren().get(y);
		((Box)row.getChildren().get(x)).setEmpty();
	}
	
	private class Box extends Rectangle{
		
		private String emptyBox = "-fx-background-color: D59B14; -fx-border-color: black";
		private String filledBox = "-fx-background-color: blue; -fx-border-color: black";
		
		public Box(){
			super();
			setSize(elementSize, elementSize);
			setEmpty();
		}
		
		public void setSize(int width, int height){
			this.setWidth(width);
			this.setHeight(height);
			this.setStroke(Color.BLACK);
		}
		
		public void setFilled(){
			this.setFill(Color.BLUE);
		}
		
		public void setEmpty(){
			this.setFill(Color.BURLYWOOD);
		}
		
	}
}
