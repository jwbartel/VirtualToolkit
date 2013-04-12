package test3D;

import java.awt.Frame;

import java.applet.Applet;

import java.awt.*;

import com.sun.j3d.utils.applet.MainFrame;

import com.sun.j3d.utils.universe.*;

import javax.media.j3d.*;

import javax.vecmath.*;

import com.sun.j3d.utils.image.TextureLoader;
import com.sun.j3d.utils.behaviors.keyboard.*;


public class lesson09 extends Applet {

    SimpleUniverse simpleU;

    static boolean application = false;


    public BranchGroup createSceneGraph() {      

   	BranchGroup objRoot = new BranchGroup();

    	PolygonAttributes p = new PolygonAttributes ();
    	p.setCullFace (PolygonAttributes.CULL_NONE);

  	PlatformGeometry pg = new PlatformGeometry ();
    	TransformGroup ptTG = new TransformGroup ();
    	Transform3D pt3d = new Transform3D ();

    	pt3d.setTranslation (new Vector3d (0, 0, -1.0));
    	ptTG.setTransform (pt3d);

	Appearance appGFront = new Appearance();
 	TransparencyAttributes ta0 = new TransparencyAttributes (); 
    	ta0.setTransparencyMode (ta0.BLENDED);
    	ta0.setTransparency (0.0f);
    	appGFront.setTransparencyAttributes (ta0);

    	QuadArray GFront = new QuadArray (4,QuadArray.COORDINATES | GeometryArray.TEXTURE_COORDINATE_2);

    	GFront.setCoordinate (0, new Point3d (-0.85, -0.65, 0));
    	GFront.setCoordinate (1, new Point3d (0.85, -0.65, 0));
    	GFront.setCoordinate (2, new Point3d (0.85, 0.6, 0));
    	GFront.setCoordinate (3, new Point3d (-0.85, 0.6, 0));

    	GFront.setTextureCoordinate (0, new Point2f(0.0f,0.0f));
    	GFront.setTextureCoordinate (1, new Point2f(1.0f,0.0f)); 
    	GFront.setTextureCoordinate (2, new Point2f(1.0f,1.0f));
    	GFront.setTextureCoordinate (3, new Point2f(0.0f,1.0f));


	if (application == true){
     	   	Texture GogglesOn = new TextureLoader("goggles.gif", this).getTexture();
	   	appGFront.setTexture (GogglesOn);

        }
	else {
	    	try
    		{
      			java.net.URL texImage = new java.net.URL (getCodeBase (), "goggles.gif");
	      		Texture GogglesOn= new TextureLoader (texImage, this).getTexture ();
      			appGFront.setTexture (GogglesOn);

	    	}
    		catch (java.net.MalformedURLException ex){}

	}

    	ptTG.addChild (new Shape3D (GFront, appGFront));
    	pg.addChild (ptTG);
	ViewingPlatform vp = simpleU.getViewingPlatform ();
    	vp.setPlatformGeometry (pg);

  	Appearance polygon1Appearance = new Appearance();
	polygon1Appearance.setPolygonAttributes (p);
	Color3f color1 = new Color3f (0.0f, 1.0f, 0.0f);
	ColoringAttributes color1ca = new ColoringAttributes (color1, 1);
	polygon1Appearance.setColoringAttributes(color1ca);
	QuadArray polygon1 = new QuadArray (4, QuadArray.COORDINATES);
    	polygon1.setCoordinate (0, new Point3f (-5f, -5f, -15f));
    	polygon1.setCoordinate (1, new Point3f (5f, -5f, -15f));
    	polygon1.setCoordinate (2, new Point3f (5f, 5f, -15f));
    	polygon1.setCoordinate (3, new Point3f (-5f, 5f, -15f));
    	objRoot.addChild(new Shape3D(polygon1,polygon1Appearance));  

  	Appearance polygon2Appearance = new Appearance();
	polygon2Appearance.setPolygonAttributes (p);
	Color3f color2 = new Color3f (1.0f, 1.0f, 0.0f);
	ColoringAttributes color2ca = new ColoringAttributes (color2, 1);
	polygon2Appearance.setColoringAttributes(color2ca);
	QuadArray polygon2 = new QuadArray (4, QuadArray.COORDINATES);
    	polygon2.setCoordinate (0, new Point3f (-5f, -5f, -25f));
    	polygon2.setCoordinate (1, new Point3f (-5f, -5f, 25f));
    	polygon2.setCoordinate (2, new Point3f (-5f, 5f, 25f));
    	polygon2.setCoordinate (3, new Point3f (-5f, 5f, -25f));
    	objRoot.addChild(new Shape3D(polygon2,polygon2Appearance));  

  	Appearance polygon3Appearance = new Appearance();
	polygon3Appearance.setPolygonAttributes (p);
	Color3f color3 = new Color3f (1.0f, 0.0f, 0.0f);
	ColoringAttributes color3ca = new ColoringAttributes (color3, 1);
	polygon3Appearance.setColoringAttributes(color3ca);
	QuadArray polygon3 = new QuadArray (4, QuadArray.COORDINATES);
    	polygon3.setCoordinate (0, new Point3f (5f, -5f, -25f));
    	polygon3.setCoordinate (1, new Point3f (5f, -5f, 25f));
    	polygon3.setCoordinate (2, new Point3f (5f, 5f, 25f));
    	polygon3.setCoordinate (3, new Point3f (5f, 5f, -25f));
    	objRoot.addChild(new Shape3D(polygon3,polygon3Appearance));  

	TransformGroup vpTrans = simpleU.getViewingPlatform().getViewPlatformTransform();
	KeyNavigatorBehavior keyNavBeh = new KeyNavigatorBehavior(vpTrans);
	keyNavBeh.setSchedulingBounds(new BoundingSphere(new Point3d(),1000.0));
	objRoot.addChild(keyNavBeh);


	return objRoot;


    }



    public lesson09 (){

    }



    public void init() {



        setLayout(new BorderLayout());

    	Canvas3D c = new Canvas3D(SimpleUniverse.getPreferredConfiguration());

    	add("Center", c);

    	simpleU = new SimpleUniverse(c);

    	BranchGroup scene = createSceneGraph();


        TransformGroup tg = simpleU.getViewingPlatform().getViewPlatformTransform();

	Transform3D t3d = new Transform3D();
	t3d.setTranslation(new Vector3f(0f,0f,10f));
	tg.setTransform(t3d);

        scene.compile();

        simpleU.addBranchGraph(scene);

    }

  
    public void destroy(){
	simpleU.removeAllLocales();
    }  


    public static void main(String[] args) {
   	application = true;

     Frame frame = new MainFrame(new lesson09(), 500, 400);

    }

}
