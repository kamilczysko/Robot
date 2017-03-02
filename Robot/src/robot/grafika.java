package robot;

import java.awt.Color;
import java.awt.GraphicsConfiguration;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Map;
import javax.media.j3d.AmbientLight;
import javax.media.j3d.Appearance;
import javax.media.j3d.Background;
import javax.media.j3d.BoundingSphere;
import javax.media.j3d.Bounds;
import javax.media.j3d.BranchGroup;
import javax.media.j3d.Canvas3D;
import javax.media.j3d.ColoringAttributes;
import javax.media.j3d.DirectionalLight;
import javax.media.j3d.LineArray;
import javax.media.j3d.LineAttributes;
import javax.media.j3d.Material;
import javax.media.j3d.Shape3D;
import javax.media.j3d.Transform3D;
import javax.media.j3d.TransformGroup;
import javax.media.j3d.View;
import javax.vecmath.AxisAngle4f;
import javax.vecmath.Color3f;
import javax.vecmath.Point3d;
import javax.vecmath.Point3f;
import javax.vecmath.Vector3f;
import com.sun.j3d.loaders.IncorrectFormatException;
import com.sun.j3d.loaders.Loader;
import com.sun.j3d.loaders.ParsingErrorException;
import com.sun.j3d.loaders.Scene;
import com.sun.j3d.utils.behaviors.vp.OrbitBehavior;
import com.sun.j3d.utils.geometry.Box;
import com.sun.j3d.utils.geometry.Cylinder;
import com.sun.j3d.utils.geometry.Sphere;
import com.sun.j3d.utils.universe.SimpleUniverse;
import com.sun.j3d.utils.universe.ViewingPlatform;

public class grafika {

	Canvas3D canvas;
	SimpleUniverse universe;
	BranchGroup root;
	Transform3D transform = new Transform3D();
	View view;
	Scene scene;

	public TransformGroup podloga;
	public TransformGroup podstawa;
	public TransformGroup kosc1;
	public TransformGroup kosc2;
	public TransformGroup kosc3;

	static Transform3D tmpTrans = new Transform3D();
	static TransformGroup tmpTG;
	static Vector3f tmpVector = new Vector3f(0, 0, 0);
	
	public static Map<String, Shape3D> nameMap;
	
	//zmienne konfiguracyjne
	
	
	AxisAngle4f zAxis = new AxisAngle4f(0.0f, 0.0f, 1.0f, 0.0f);
	AxisAngle4f xAxis= new AxisAngle4f(1.0f, 0.0f, 0.0f, 0.0f);
	AxisAngle4f yAxis= new AxisAngle4f(0.0f, 1.0f, 0.0f, 0.0f);
	
	Color3f background;
	Color3f aLight;
	Color3f dLight;
	Background bg;
	
	configLoader cl;
	AmbientLight ambientLightNode;
	DirectionalLight light1,light2;
	
	
	Cylinder cyl;
	Box box;
	Sphere s;
	
	grafika(configLoader cl){
		this.cl = cl;
		loadProp(cl);
	}
	
	Appearance a(Color c){
		Appearance a = new Appearance();
		Material m = new Material();
				
		Color3f c3 = new Color3f(c);
		m.setColorTarget(0);
		m.setAmbientColor(c3);
		m.setDiffuseColor(c3);
		m.setEmissiveColor(c3);
		m.setShininess(127);
		//m.setSpecularColor(c3);
		//m.setLightingEnable(true);
		//m.setShininess(2.0f);
		
		a.setMaterial(m);
		return a;
	}
	
	void setRobotColor(Map<String, Shape3D> parts , Color czlony, Color sruby, Color przeguby, Color podstawa, Color chwytak, Color podloga){
		setCzlonyColor(parts, czlony);
		setSrubyColor(parts, sruby);
		setPrzegubyColor(parts, przeguby);
		setPodstawaColor(parts, podstawa);
		setChwytakColor(parts, chwytak);
		setPodlogaColor(parts, podloga);
	}
	
	void setCzlonyColor(Map<String, Shape3D> nameMap , Color czlony){
		nameMap.get("czlon0").setAppearance(a(czlony));
		nameMap.get("czlon1").setAppearance(a(czlony));
		nameMap.get("czlon2").setAppearance(a(czlony));
	}
	
	void setSrubyColor(Map<String, Shape3D> nameMap ,Color sruby){
		nameMap.get("sruba1").setAppearance(a(sruby));
		nameMap.get("sruba2").setAppearance(a(sruby));
		nameMap.get("sruba3").setAppearance(a(sruby));
		nameMap.get("sruba4").setAppearance(a(sruby));
		nameMap.get("sruba5").setAppearance(a(sruby));
		nameMap.get("sruba6").setAppearance(a(sruby));
	}
	
	void setPrzegubyColor(Map<String, Shape3D> nameMap ,Color przeguby){

		nameMap.get("przegub0d").setAppearance(a(przeguby));
		nameMap.get("przegub0l").setAppearance(a(przeguby));
		nameMap.get("przegub0p").setAppearance(a(przeguby));
		nameMap.get("przegub1l").setAppearance(a(przeguby));
		nameMap.get("przegub1p").setAppearance(a(przeguby));
		nameMap.get("przegub2l").setAppearance(a(przeguby));
		nameMap.get("przegub2p").setAppearance(a(przeguby));
		nameMap.get("przegub3").setAppearance(a(przeguby));
		nameMap.get("nadgarstek").setAppearance(a(przeguby));
		
	}
	
	void setPodstawaColor(Map<String, Shape3D> nameMap,Color podstawa){
		nameMap.get("podstawa").setAppearance(a(podstawa));
	}
	
	void setChwytakColor(Map<String, Shape3D> nameMap , Color chwytak){
		nameMap.get("szczeka1").setAppearance(a(chwytak));
		nameMap.get("szczeka2").setAppearance(a(chwytak));
		nameMap.get("mechanizmchwytaka").setAppearance(a(chwytak));
	}
	
	void setPodlogaColor(Map<String, Shape3D> nameMap ,Color podloga){
		nameMap.get("podloga").setAppearance(a(podloga));
	}
	private void buildRobot(Map<String, Shape3D> nameMap)
			throws FileNotFoundException, IncorrectFormatException,
			ParsingErrorException {	 
				
		setRobotColor(nameMap, cl.czlonyColor(),cl.srubyColor(),cl.przegubyColor(),cl.podstawaColor(),cl.chwytakColor(),cl.podlogaColor());
		podloga = new TransformGroup();
		podloga.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		podloga.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
		tmpTG = new TransformGroup();
		tmpVector.set(0.35f, -0.45f, 0.5f);
		tmpTrans.set(tmpVector);
		tmpTG.setTransform(tmpTrans);
		
		xAxis.angle = (float)Math.toRadians(90);
		tmpTG.getTransform(tmpTrans);
		tmpTrans.setRotation(xAxis);
		tmpTG.setTransform(tmpTrans);
		//	
		tmpTG.addChild(nameMap.get("podloga"));
		tmpTG.addChild(nameMap.get("sruba1"));
		tmpTG.addChild(nameMap.get("sruba2"));
		tmpTG.addChild(nameMap.get("sruba3"));
		tmpTG.addChild(nameMap.get("sruba4"));
		tmpTG.addChild(nameMap.get("sruba5"));
		tmpTG.addChild(nameMap.get("sruba6"));
		tmpTG.addChild(nameMap.get("podstawa"));
	
		podloga.addChild(tmpTG);
		
		
		podstawa = new TransformGroup();
		podstawa.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		podstawa.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
		tmpVector.set(0.0f, 0.0f, 0.0f);
		tmpTrans.set(tmpVector);
		podstawa.setTransform(tmpTrans);
		
		tmpTG = new TransformGroup();
		tmpVector.set(0.35f, -0.45f, 0.5f);
		tmpTrans.setTranslation(tmpVector);
		tmpTG.setTransform(tmpTrans);
		
		tmpTG.addChild(nameMap.get("przegub0d"));
		tmpTG.addChild(nameMap.get("przegub0l"));
		tmpTG.addChild(nameMap.get("przegub0p"));
		
		xAxis.angle = (float)Math.toRadians(90);
		tmpTG.getTransform(tmpTrans);
		tmpTrans.setRotation(xAxis);
		tmpTG.setTransform(tmpTrans);
		
		rotZ(podstawa,load(1,cl));
		podstawa.addChild(tmpTG);
		
		podloga.addChild(podstawa);

		
		
		kosc1 = new TransformGroup();
		kosc1.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		kosc1.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); //

		tmpVector.set(0.0f, 0.0f, 0.15f);
		tmpTrans.set(tmpVector);
		kosc1.setTransform(tmpTrans);
		
		tmpTG = new TransformGroup();
		tmpVector.set(0.35f, -0.45f, 0.34f);
		tmpTrans.set(tmpVector);
		tmpTG.setTransform(tmpTrans);
		
		xAxis.angle = (float)Math.toRadians(90);
		tmpTG.getTransform(tmpTrans);
		tmpTrans.setRotation(xAxis);
		tmpTG.setTransform(tmpTrans);
		
		tmpTG.addChild(nameMap.get("czlon0"));
		tmpTG.addChild(nameMap.get("przegub1l"));
		tmpTG.addChild(nameMap.get("przegub1p"));
		
		kosc1.addChild(tmpTG);

		rotY(kosc1, load(2,cl));
		podstawa.addChild(kosc1);
		
		

		kosc2 = new TransformGroup();
		kosc2.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		kosc2.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE); //
		
		tmpVector.set(0.0f, -0.0f, 0.315f);
		tmpTrans.set(tmpVector);
		kosc2.setTransform(tmpTrans);

		tmpTG = new TransformGroup();
		tmpVector.set(0.35f, -0.45f, 0.0f);
		tmpTrans.set(tmpVector);
		tmpTG.setTransform(tmpTrans);
		
		xAxis.angle = (float)Math.toRadians(90);
		tmpTG.getTransform(tmpTrans);
		tmpTrans.setRotation(xAxis);
		tmpTG.setTransform(tmpTrans);
		
		tmpTG.addChild(nameMap.get("czlon1"));
		
		kosc2.addChild(tmpTG);
		

		rotY(kosc2, load(3,cl));
		kosc1.addChild(kosc2);
		
		kosc3 = new TransformGroup();
		kosc3.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		kosc3.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		
		tmpVector.set(0.0f, 0.0f, 0.0f);
		tmpTrans.set(tmpVector);
		kosc3.setTransform(tmpTrans);

		tmpTG = new TransformGroup();
		tmpVector.set(0.35f, -0.45f, -0.2f);
		tmpTrans.set(tmpVector);
		tmpTG.setTransform(tmpTrans);
		
		xAxis.angle = (float)Math.toRadians(90);
		tmpTG.getTransform(tmpTrans);
		tmpTrans.setRotation(xAxis);
		tmpTG.setTransform(tmpTrans);
		
		tmpTG.addChild(nameMap.get("czlon2"));
		tmpTG.addChild(nameMap.get("przegub2l"));
		tmpTG.addChild(nameMap.get("przegub2p"));
		tmpTG.addChild(nameMap.get("mechanizmchwytaka"));
		tmpTG.addChild(nameMap.get("nadgarstek"));
		tmpTG.addChild(nameMap.get("przegub3"));
		tmpTG.addChild(nameMap.get("szczeka1"));
		tmpTG.addChild(nameMap.get("szczeka2"));
		
		kosc3.addChild(tmpTG);

		kosc2.addChild(kosc3);
		
		try {
			addLocalAxes(kosc2,false);
			addLocalAxes(kosc1,false);
			addLocalAxes(kosc3,false);
			addLocalAxes(podstawa,false);
			addLocalAxes(podloga,true);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
		
	@SuppressWarnings("static-access")
	BranchGroup createSceneGraph() throws Exception {
		// Create the root of the branch graph
		BranchGroup objRoot = new BranchGroup();

		TransformGroup rootGroup = new TransformGroup();
		Transform3D front = new Transform3D();
		front.rotX(Math.toRadians(-90));
		rootGroup.setTransform(front);
		
		objRoot.addChild(rootGroup);

		TransformGroup objTrans = new TransformGroup();
		objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_WRITE);
		objTrans.setCapability(TransformGroup.ALLOW_TRANSFORM_READ);
		rootGroup.addChild(objTrans);
		
		Loader loader = LoaderFactory.getWavefrontLoader();
		scene = loader.load("src\\robot\\model\\robot.obj");
		root = scene.getSceneGroup();

		@SuppressWarnings("unchecked") 
		Map<String, Shape3D> nameMap = scene.getNamedObjects();
		this.nameMap = nameMap;

		for (String name : nameMap.keySet()) {

			System.out.printf("Name: %s\n", name);
			nameMap.get(name).setCapability(Shape3D.ALLOW_APPEARANCE_WRITE);
			nameMap.get(name).setCapability(Shape3D.ALLOW_APPEARANCE_READ);

		}

		root.removeAllChildren();

		buildRobot(nameMap); // dodanie robota modelu
		//buildRobot(); // robot prosty
		objTrans.addChild(podloga);

		BoundingSphere bounds = new BoundingSphere(new Point3d(0, 50, 0), 200.0);

		// ********************************************/
		addAxesToUniverse(objRoot,false);// dodanie osi wsp
		mouseService(bounds, canvas); // dodanie obs³ugi myszy

		// t³o
		bg = new Background(background);
		bg.setApplicationBounds(bounds);
		bg.setCapability(Background.ALLOW_COLOR_READ);
		bg.setCapability(Background.ALLOW_COLOR_WRITE);
		objTrans.addChild(bg);

		// swiatla
		//Color3f ambientColor = new Color3f(aLight);
		ambientLightNode = new AmbientLight(aLight);
		ambientLightNode.setInfluencingBounds(bounds);
		ambientLightNode.setCapability(AmbientLight.ALLOW_COLOR_READ);
		ambientLightNode.setCapability(AmbientLight.ALLOW_COLOR_WRITE);
	//	ambientLightNode.
		//objRoot.addChild(ambientLightNode);
//*/
	//	Color3f light1Color = new Color3f(dLight);
		Vector3f light1Direction = new Vector3f(0.0f, -0.2f, -1.0f);

		light1 = new DirectionalLight(dLight,
				light1Direction);
		light1.setInfluencingBounds(bounds);
		light1.setCapability(DirectionalLight.ALLOW_COLOR_READ);
		light1.setCapability(DirectionalLight.ALLOW_COLOR_WRITE);
		objRoot.addChild(light1);
		

		light1Direction = new Vector3f(0.0f, 0.2f, 1.0f);
		
		light2 = new DirectionalLight(dLight,
				light1Direction);
		light2.setInfluencingBounds(bounds);
		light2.setCapability(DirectionalLight.ALLOW_COLOR_READ);
		light2.setCapability(DirectionalLight.ALLOW_COLOR_WRITE);
		objRoot.addChild(light2);


		return objRoot;
	}
	
	public Canvas3D init3D() throws Exception { // inicjacja grafiki
		GraphicsConfiguration config = SimpleUniverse
				.getPreferredConfiguration();

		canvas = new Canvas3D(config);
		universe = new SimpleUniverse(canvas);

		BranchGroup sc = createSceneGraph();

		universe.getViewingPlatform().setNominalViewingTransform();
		universe.addBranchGraph(sc);

		view = universe.getViewer().getView();

		return canvas;
	}

	private void addAxesToUniverse(BranchGroup root,boolean on) // uk³ad wspó³rzêdnych
			throws IOException {

		LineAttributes la = new LineAttributes();
		Appearance a1 = new Appearance();
		Appearance a2 = new Appearance();
		Appearance a3 = new Appearance();
		la.setLineWidth(2.5f);

		a1.setColoringAttributes(new ColoringAttributes(new Color3f(Color.blue), ColoringAttributes.NICEST));
		a2.setColoringAttributes(new ColoringAttributes(new Color3f(Color.green), ColoringAttributes.NICEST));
		a3.setColoringAttributes(new ColoringAttributes(new Color3f(Color.red), ColoringAttributes.NICEST));

		LineArray axisXLines = new LineArray(2, LineArray.COORDINATES);
		axisXLines.setCoordinate(0, new Point3f(0.0f, 0.0f, 0.0f));
		axisXLines.setCoordinate(1, new Point3f(0.5f, 0.0f, 0.0f));

		LineArray axisYLines = new LineArray(2, LineArray.COORDINATES);
		axisYLines.setCoordinate(0, new Point3f(0.0f, 0.0f, 0.0f));
		axisYLines.setCoordinate(1, new Point3f(0.0f, 0.5f, 0.0f));

		LineArray axisZLines = new LineArray(2, LineArray.COORDINATES);
		axisZLines.setCoordinate(0, new Point3f(0.0f, 0.0f, 0.0f));
		axisZLines.setCoordinate(1, new Point3f(0.0f, 0.0f, 0.5f));
		if(on){
			root.addChild(new Shape3D(axisXLines, a1));
			root.addChild(new Shape3D(axisYLines, a2));
			root.addChild(new Shape3D(axisZLines, a3));
		}
	}// */
	
	private void addLocalAxes(TransformGroup tg,boolean on) // uk³ad wspó³rzêdnych
			throws IOException {

		LineAttributes la = new LineAttributes();
		Appearance a1 = new Appearance();
		Appearance a2 = new Appearance();
		Appearance a3 = new Appearance();
		la.setLineWidth(5f);

		a1.setColoringAttributes(new ColoringAttributes(new Color3f(Color.blue), ColoringAttributes.NICEST));
		a2.setColoringAttributes(new ColoringAttributes(new Color3f(Color.green), ColoringAttributes.NICEST));
		a3.setColoringAttributes(new ColoringAttributes(new Color3f(Color.red), ColoringAttributes.NICEST));
		

		LineArray axisXLines = new LineArray(2, LineArray.COORDINATES);
		axisXLines.setCoordinate(0, new Point3f(0.0f, 0.0f, 0.0f));
		axisXLines.setCoordinate(1, new Point3f(0.25f, 0.0f, 0.0f));

		LineArray axisYLines = new LineArray(2, LineArray.COORDINATES);
		axisYLines.setCoordinate(0, new Point3f(0.0f, 0.0f, 0.0f));
		axisYLines.setCoordinate(1, new Point3f(0.0f, 0.25f, 0.0f));

		LineArray axisZLines = new LineArray(2, LineArray.COORDINATES);
		axisZLines.setCoordinate(0, new Point3f(0.0f, 0.0f, 0.0f));
		axisZLines.setCoordinate(1, new Point3f(0.0f, 0.0f, 0.25f));
		if(on){
			tg.addChild(new Shape3D(axisXLines, a1));
			tg.addChild(new Shape3D(axisYLines, a2));
			tg.addChild(new Shape3D(axisZLines, a3));
		}
	}// */

	private void mouseService(Bounds influenceRegion, Canvas3D canvas3D) { // mysz
		OrbitBehavior orbit = new OrbitBehavior(canvas3D,
				OrbitBehavior.PROPORTIONAL_ZOOM);
		orbit.setSchedulingBounds(influenceRegion);
		ViewingPlatform vp = universe.getViewingPlatform();
		vp.setViewPlatformBehavior(orbit);
	}
	
	//³adowanie ustawien
	private void loadProp(configLoader cl){
		background = cl.bgColor();
		dLight = cl.dLightColor();
		aLight = cl.aLightColor();
		
	}
	
	//ustawienie kolorów t³a i œwiat³a
	public void setBackground(Color3f c){
		bg.setColor(c);
	}
	public void setaLight(Color3f c){
		ambientLightNode.setColor(c);
	}
	public void setdLight(Color3f c){
		light1.setColor(c);
		light2.setColor(c);
	}
	
	////metody do sterowania robotem
	
	public void rotGama(double rot){
		//System.out.println("Rotacja: "+rot);
		zAxis.angle = (float) Math.toRadians(rot);
		podstawa.getTransform(tmpTrans);
		tmpTrans.setRotation(zAxis);
		podstawa.setTransform(tmpTrans); 
	}

	public void rotAlfa(double rot){
		//System.out.println("Rotacja: "+rot);
		yAxis.angle = (float) Math.toRadians(rot);
		kosc1.getTransform(tmpTrans);
		tmpTrans.setRotation(yAxis);
		kosc1.setTransform(tmpTrans); 
	}
	
	public void rotBeta(double rot){
		//System.out.println("Rotacja: "+rot);
		yAxis.angle = (float) Math.toRadians(rot);
		kosc2.getTransform(tmpTrans);
		tmpTrans.setRotation(yAxis);
		kosc2.setTransform(tmpTrans); 
	}
	
	public void transZ(double t){
		Vector3f trans = new Vector3f(0.0f,0.0f,(float)t*0.002f);
		kosc3.getTransform(tmpTrans);
		tmpTrans.setTranslation(trans);
		kosc3.setTransform(tmpTrans); 
	}
	
	//ustawienia pocz¹tkowe
	
	
	public void rotZ(TransformGroup tg, double rot){
		//System.out.println("Rotacja: "+rot);
		zAxis.angle = (float) Math.toRadians(rot);
		tg.getTransform(tmpTrans);
		tmpTrans.setRotation(zAxis);
		tg.setTransform(tmpTrans); 
	}

	public void rotX(TransformGroup tg, double rot){
		//System.out.println("Rotacja: "+rot);
		xAxis.angle = (float) Math.toRadians(rot);
		tg.getTransform(tmpTrans);
		tmpTrans.setRotation(xAxis);
		tg.setTransform(tmpTrans); 
	}
	
	public void rotY(TransformGroup tg, double rot){
		//System.out.println("Rotacja: "+rot);
		yAxis.angle = (float) Math.toRadians(rot);
		tg.getTransform(tmpTrans);
		tmpTrans.setRotation(yAxis);
		tg.setTransform(tmpTrans); 
	}
	
	 
	//³adowanie konfiguracji pocz¹tkowej robota
	int load(int przegub, configLoader cl){
		switch(przegub){
		case 1:
			return cl.poczGama();
		case 2:
			return cl.poczAlfa();
		case 3:
			return cl.poczBeta();
		}
		return 0;
	}
	//*/
	

}
