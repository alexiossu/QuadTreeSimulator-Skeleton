package utility;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
//import jdk.internal.jimage.ImageReader.Node;
import quadtreesimulator.entity.GenericEntity;
import quadtreesimulator.entity.property.Sprite;

//TODO Complete
public class QuadTree extends GenericEntity {

	private Node head;
	private int maxDepth;

	// TODO Complete

	private QuadTree() {

		sprite = new Sprite() {

			@Override
			public void draw(GraphicsContext gc) {
				gc.setLineWidth(0.5);
				drawNode(head, gc);
			}

			private void drawNode(Node n, GraphicsContext gc) {
				if (n.children == null || n.empty || n.depth >= maxDepth) {
					return;
				}
				gc.strokeLine(n.x + n.width / 2, n.y, n.x + n.width / 2, n.y + n.height);
				gc.strokeLine(n.x, n.y + n.height / 2, n.x + n.width, n.y + n.height / 2);
				for (Node node : n.children) {
					drawNode(node, gc);
				}
			}
		};
	}

	public QuadTree(int depth, double width, double height) { // Depth

		this.maxDepth = depth;

		head = new Node(0, 0, 0, width, height);
	}
	
	public void push() {
		
	}
	 
}