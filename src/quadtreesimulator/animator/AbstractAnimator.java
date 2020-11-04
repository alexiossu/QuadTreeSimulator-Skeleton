package quadtreesimulator.animator;

import javafx.animation.AnimationTimer;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import quadtreesimulator.entity.FpsCounter;
import quadtreesimulator.entity.property.Sprite;
import quadtreesimulator.scene.AbstractScene;

public abstract class AbstractAnimator extends AnimationTimer {

	private boolean isRunning;
	protected AbstractScene scene;
	private FpsCounter fps;

	public AbstractAnimator() {

		fps = new FpsCounter(10, 25);
		fps.getDrawable().setFill(Color.BLACK);
		fps.getDrawable().setStroke(Color.WHITE);
		fps.getDrawable().setWidth(1);

	}

	@Override
	public void stop() {
		// TODO Auto-generated method stub
		super.stop();
		if (isRunning) {
			isRunning = false;
		}
	}

	@Override
	public void start() {
		// TODO Auto-generated method stub
		if (isRunning) {
			isRunning = true;
		}
	}

	public boolean isRunning() {
		return true;
	}

	public void clear() {
		// TODO Auto-generated method stub
		clearAndFill(scene.gc(), Color.TRANSPARENT);
	}

	protected void clearAndFill(GraphicsContext gc, Color background) {
		clearAndFill(gc, background, 0, 0, scene.w(), scene.h());
	}

	protected void clearAndFill(GraphicsContext gc, Color background, double x, double y, double w, double h) {

		gc.setFill(background);
		gc.clearRect(x, y, w, h);
		gc.fillRect(x, y, w, h);
	}

	public void handle(long now) {

		scene.gc();

		if (scene.getOption("displayFPS") != null) { // SUPPOSE TO RETURN BooleanProperty

			fps.calculateFPS(now);

		}

		gc.save();
		this.handle(gc, now);
		gc.restore();

		if (scene.getOption("displayFPS") != null) {

			Sprite s = fps.getDrawable();
			s.draw(gc);
		}
	}

	protected void handle(GraphicsContext gc, long now) {
		// TODO Auto-generated method stub
	}
}