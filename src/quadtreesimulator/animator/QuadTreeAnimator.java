package quadtreesimulator.animator;

import javafx.beans.property.ObjectProperty;
import javafx.event.EventHandler;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.WritableImage;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import quadtreesimulator.scene.AbstractScene;
import quadtreesimulator.scene.ColorDetectionScene;
import utility.QuadTree;

public class QuadTreeAnimator extends AbstractAnimator {

	private int[] buffer;
	private double x;
	private double y;
	private boolean initilized;
	private Canvas drawingCanvas;
	private QuadTree qt;

	public void init() {

		if (initilized) {
				return;			// Go out. Continue
		}
		
		initilized = true;
		
		qt = ((ColorDetectionScene) scene).getQuadTree();  //CASTING
				
		ObjectProperty< Color> color = (ObjectProperty<Color>) scene.getOption("color");
		color.addListener((v, o, n) -> qt.clear());
		
		drawingCanvas = new Canvas(scene.w(), scene.h());
		Canvas canvas = scene.getCanvas();
		canvas.setOnMouseDragged(e -> {
			x = e.getSceneX();
			y = e.getSceneY();
		});

		EventHandler eventHandler;
		eventHandler = (event -> {
			MouseEvent e = (MouseEvent) event;
			GraphicsContext gc = drawingCanvas.getGraphicsContext2D();
			
			if(e.isPrimaryButtonDown()) {
				gc.setStroke(color.get());
			}
			
			gc.setLineWidth(2);
			
			if (isRunning()) {
				gc.strokeLine(x, y, e.getX(), e.getY());
			} else {  											// MAKE SURE THAT ALT IS GONNA LOOK LIKE THAT
				x = e.getSceneX();
				y = e.getY();
			}
			
		});
		canvas.setOnMouseDragEntered(eventHandler); // Calling back. Async method
		// eventHandler.handle(event);

	}

	public void clear() {
		
		qt.clear();
		clearAndFill(drawingCanvas.getGraphicsContext2D(), Color.TRANSPARENT);
	}

	@Override
	protected void handle(GraphicsContext gc, long now) {
		// TODO Auto-generated method stub
		
		init();
		clearAndFill(gc, Color.TRANSPARENT);
		SnapshotParameters sp = new SnapshotParameters();
		sp.setFill(Color.TRANSPARENT);
		WritableImage image = drawingCanvas.snapshot(sp, null);
		
		if (image != null) {
			gc.drawImage(image, 0, 0);
		}
		                                         // STEP 7. uadtreesimulator.scene.ColorDetectionScene.createScene()   SHOULD BE FINISHED FIRST!!!
		
	}

	@Override
	public void setScene(AbstractScene scene) {  			// What is it doing here??
		// TODO Auto-generated method stub
		
	}

}
