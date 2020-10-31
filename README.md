@Author: Shahriar Emami
emamis@algonquincollege.com

# QuadTreeSimulator-Skeleton
QuadTree Simulator

Explanation of packages
In this section I will explain the functionality of all the packages and classes in them.

Utility
1. QuadTree, this class will process an image at pixel level to find a specific color. Node is an inner class of QuadTree. QuadTree divides the screen in 4 equal sectors and each sector will be divided again and again in 4 equal sectors. The rule for this division relies on any colored pixel being present in the sector. The number of times this division will occur depends on the maximum depth defined at initialization of the tree.

Scene
1. AbstractScene, this class holds some common code that might be shared among scenes. In the scope of this assignment we’ll only use one scene. However, this application can have multiple scenes allowing for multiple custom behaviors. Now arguably we can move more components from UI to this class to even have more custom look per scene. For example, we can move some GUI Nodes like menu item to scene, so we can have more customized options depending on the scene.
Two of the methods that will be used often from this class are:
a. addOption( uniqueName:String, option:Object):void
b. getOption( uniqueName:String): Object
Add method adds an object such as IntegerProperty to an internal map called options. The aim is to have one central location for each scene that properties/options can be retrieved based on their name. Here is an example:
ObjectProperty< Color> colorOption = new SimpleObjectProperty<>( Color.BLACK);
scene.addOption( "color", colorOption);//add the colorOption to scene
//here the option retrieved from the scene and casted to the desired type.
ObjectProperty< Color> color = (ObjectProperty< Color>) scene.getOption( "color");
These methods will be used quiet often. You can find the name of options under the heading Options.
2. ColorDetectionScene, this class inherits form AbstractScene. Custom component related to the specific scene are created here instead of in AbstractScene.

Property
1. Drawable, this is a generic interface which holds all the methods that relate to drawing entities. All sprites in this application are subclass of Drawable.
2. Entity, this is an interface which represents anything that can be placed in the Application. For example, QuadTree and FpsCounter are subclass of Entity. This interface holds the common methods between all entities.
3. Sprite, this is an abstract class which implements Drawable. It adds body to all common methods, however leaves draw method as abstract as it must be overridden by its subclasses.

Entity
1. FpsCounter, this class simply counts the number of frames per second. This class is an entity which is drawable. It extends GenericEntity.
2. GenericEntity, this class implements Entity. It is meant to implement a generic entity which can be customized but ready to use as is. The method update in this class will be called by animator to update the entity. The content of update in almost all cases will be nothing, except for cases where some updated is needed for every frame. In this assignment we don’t use this class. It is just here as a support class for the overall structure.

Animator
1. AbstractAnimator, this class extends AnimationTimer. AnimationTimer is a JavaFX class which acts as a timer. It has methods start, stop, and handle. Start and Stop manipulate the active state of timer. Handle method is called by JavaFX automatically every 1/120 of second. Each time this method is called a new frame is drawn on the screen. AbstractAnimator is the abstraction to JavaFX AnimationTimer to hold some common code like clear.
2. QuadTreeAnimator, this class extends AbstractAnimator. This is the heart of the application. it updates and draws everything in each frame. In this animator we have two canvas objects.
One canvas is called drawingCanvas which is created internally and is used to store the movements of player mouse for drawing the lines, but it is not actually visible to the user. Other canvas is used for actual display to user. In every frame we take snapshot of the drawing canvas and save it in and image object. The pixels of image object are passed to QuadTree to be processed. Then the image and QuadTree are both drawn on the main canvas.
