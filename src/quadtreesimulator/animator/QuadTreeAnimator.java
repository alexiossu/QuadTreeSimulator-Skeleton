package quadtreesimulator.animator;

import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import quadtreesimulator.scene.AbstractScene;
import quadtreesimulator.scene.ColorDetectionScene;
import utility.QuadTree;

public class  extends AbstractAnimator {

	private int[] buffer;
	private double x;
	private double y;
	private boolean initilized;
	private Canvas drawingCanvas;
	private QuadTree qt;

	public void init() {

		if (initilized) {
							// Go back. Continue
		}
		ColorDetectionScene scene;
		
		scene.getQuadTree();  		// CASTING
		
	}

	public void clear() {

	}

	@Override
	protected void handle(GraphicsContext gc, long now) {
		// TODO Auto-generated method stub

	}

	public void setScene(ColorDetectionScene scene) {  			// What is it doing here??
		// TODO Auto-generated method stub
		
	}

}
