package utility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import quadtreesimulator.entity.GenericEntity;
import quadtreesimulator.entity.property.Sprite;

//TODO Complete
public class QuadTree {

	//TODO Complete

	private QuadTree() {
		sprite = new Sprite() {
			@Override
			public void draw( GraphicsContext gc) {
				gc.setLineWidth( 0.5);
				drawNode( head, gc);
			}

			private void drawNode( Node n, GraphicsContext gc) {
				if ( n.children == null || n.empty || n.depth >= maxDepth) {
					return;
				}
				gc.strokeLine( n.x + n.width / 2, n.y, n.x + n.width / 2, n.y + n.height);
				gc.strokeLine( n.x, n.y + n.height / 2, n.x + n.width, n.y + n.height / 2);
				for ( Node node : n.children) {
					drawNode( node, gc);
				}
			}
		};
	}

}