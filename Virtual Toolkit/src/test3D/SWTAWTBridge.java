package test3D;

import java.applet.Applet;
import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Frame;
import java.awt.GraphicsConfiguration;
import java.awt.GridLayout;
import java.awt.Label;
import java.awt.Panel;

import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.Material;
import javax.media.j3d.Texture;
import javax.media.j3d.TextureAttributes;
import javax.swing.JLabel;
import javax.swing.JRootPane;
import javax.swing.JTextField;
import javax.vecmath.Color3f;
import javax.vecmath.Color4f;
import javax.vecmath.Point3d;
import javax.vecmath.Vector3f;

import org.eclipse.swt.SWT;
import org.eclipse.swt.awt.SWT_AWT;
import org.eclipse.swt.layout.FillLayout;
import org.eclipse.swt.widgets.Composite;
import org.eclipse.swt.widgets.Display;
import org.eclipse.swt.widgets.Shell;

import com.sun.j3d.utils.geometry.ColorCube;
import com.sun.j3d.utils.geometry.Primitive;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.universe.SimpleUniverse;

public class SWTAWTBridge extends Applet {

	public static void main(String[] args)
	{
		SWTAWTBridge test = new SWTAWTBridge();
		test.runMe();
	}
	
	public void runMe() {
		
		final Display display = new Display();
		final Shell shell = new Shell(display);
		shell.setLayout(new FillLayout());

		Composite SWT_AWT_container = new Composite(shell, SWT.NO_BACKGROUND | SWT.EMBEDDED); 
		
		// create swt container:
	//	Composite SWT_AWT_container = new Composite(, SWT.EMBEDDED);
		// set bounds (here showing bounds to cover parent's area)
	//	final Rectangle sh3dbnds = parent.getBounds();
	//	sh3dbnds.x = sh3dbnds.y = 0;
	//	SWT_AWT_container.setBounds(sh3dbnds);

		// ----------------
		Frame awt = SWT_AWT.new_Frame(SWT_AWT_container);
		//-----------------
	//	final Rectangle bounds = SWT_AWT_container.getBounds();
		awt.setBounds(0, 0, 200,200);

		awt.setLayout(new BorderLayout());

		// create your scene:
		final Canvas3D c = setup();

		awt.add(c, BorderLayout.CENTER); 
		
		BranchGroup scene = createSceneGraph();

		scene.compile();


		// SimpleUniverse is a Convenience Utility class

		//SimpleUniverse simpleU = new SimpleUniverse(c);


		// This moves the ViewPlatform back a bit so the

		// objects in the scene can be viewed.

		//simpleU.getViewingPlatform().setNominalViewingTransform();

		//simpleU.addBranchGraph(scene);


		
		shell.setSize(200,70);
		shell.open();
		while(!shell.isDisposed()) 
		{
			if (!display.readAndDispatch()) display.sleep();
		}
		display.dispose();
	} 
	
	private static BranchGroup createSceneGraph() {


		// Create the root of the branch graph

		BranchGroup objRoot = new BranchGroup();


		// Create a simple shape leaf node, add it to the scene graph.

		// ColorCube is a Convenience Utility class

		objRoot.addChild(new ColorCube(0.4));


		return objRoot;


		}




	
	public  Canvas3D setup()
	{
		setLayout(new BorderLayout());

		   GraphicsConfiguration config =

		   SimpleUniverse.getPreferredConfiguration();

		   Canvas3D canvas = new Canvas3D(config);

		   add("North",new Label("This is the top"));

		   add("Center", canvas);

		   add("South",new Label("This is the bottom"));

		   BranchGroup contents = new BranchGroup();

		   contents.addChild(new ColorCube(0.3));

		   SimpleUniverse universe = new SimpleUniverse(canvas);

		   universe.getViewingPlatform().setNominalViewingTransform();

		   universe.addBranchGraph(contents);
		   
		  return canvas;
	}
}
