package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.PerspectiveCamera;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.VertexAttributes;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g3d.Environment;
import com.badlogic.gdx.graphics.g3d.Material;
import com.badlogic.gdx.graphics.g3d.Model;
import com.badlogic.gdx.graphics.g3d.ModelBatch;
import com.badlogic.gdx.graphics.g3d.ModelInstance;
import com.badlogic.gdx.graphics.g3d.attributes.ColorAttribute;
import com.badlogic.gdx.graphics.g3d.utils.ModelBuilder;

public class MyGdxGame extends ApplicationAdapter {
	//hello tis devin
	//u need to import a tons of stuff so just double click on the class name and selected
	//select "quick fix" and then there's an option to import
	Texture img;
	private PerspectiveCamera camera;
	private ModelBatch batch;//a batch. u add model into it and it renders the models optimizedly
	private Model box;//think of it like a blueprint of a model or a class. contains all ze important data
	private ModelInstance boxInstance;//this is the actual instance of the box
	//think of it like a copy of a blueprint
	private Environment scene;//for lightning and stuffs
	@Override
	public void create () {
		camera = new  PerspectiveCamera(75f,Gdx.graphics.getWidth(),Gdx.graphics.getHeight());
		camera.position.set(0f,0f,3f);
		//settin the position
		camera.lookAt(0f,0f,0f);//the rotation of the camera aka when u rotated it to look at a certain position
		//dope application of trig
		camera.near=0.1f;
		camera.far=300f;//another variable that is just like what it sounds like- how far the camera can look
		
		batch = new ModelBatch();
		ModelBuilder builder = new ModelBuilder();//used to construct a model
		//diffuse is the "base" color of an object. just like an apple is red 
		box = builder.createBox(1f, 1f, 1f, new Material(ColorAttribute.createDiffuse(Color.BLUE)), VertexAttributes.Usage.Position|VertexAttributes.Usage.Normal);
		boxInstance = new ModelInstance(box,0,0,0);
		scene = new Environment();//declaration of independence
		scene.set(new ColorAttribute(ColorAttribute.AmbientLight,1f,1f,1f,0.8f));//the lightning
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT|GL20.GL_DEPTH_BUFFER_BIT);
		camera.update();//just call it
		batch.begin(camera);//positioning and probably screen 
		batch.render(boxInstance);
		batch.end();
		
	}
	
	@Override
	public void dispose () {//so u wouldnt have memory leak. altho if u terminate the program it would be cleared anyway i believe, in a high level language like java
		
	}
}
