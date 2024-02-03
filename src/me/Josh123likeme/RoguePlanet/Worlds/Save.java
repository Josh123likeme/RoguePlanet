package me.Josh123likeme.RoguePlanet.Worlds;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import assets.Assets;
import me.Josh123likeme.Render3D4p0.Camera;
import me.Josh123likeme.Render3D4p0.Renderer;
import me.Josh123likeme.Render3D4p0.Vector3D;
import me.Josh123likeme.Render3D4p0.World.Model;
import me.Josh123likeme.Render3D4p0.World.World;
import me.Josh123likeme.RoguePlanet.Game;
import me.Josh123likeme.RoguePlanet.Entities.*;
import me.Josh123likeme.RoguePlanet.InputListener.KeyboardWitness;
import me.Josh123likeme.RoguePlanet.Terrain.*;
import me.Josh123likeme.RoguePlanet.Utils.STLParser;

public class Save {
	
	private Game game;
	
	private Camera camera;
	
	private World world;
	private Renderer renderer;
	
	private Terrain terrain;
	private List<Entity> entities = new ArrayList<Entity>();
	
	public Save(Game game) {
		
		this.game = game;
		
		camera = new Camera(0.032/9*16, 0.032, 1000/9*16, 1000, 0.017);
		
		camera.pos.Z = 200;
		camera.pitch = 0;
		camera.yaw = Math.PI / 2;
		
		world = new World();
		
		world.doContextShadowing = true;
		world.updateSunDirection(new Vector3D(-1, -1, -0.5));
		
		renderer = new Renderer();
		
		renderer.renderFaces = true;
		renderer.renderWireframe = false;
		
		terrain = new Terrain();
		
		world.addModel(terrain.getModel());
		
		entities.add(new PLAYER());
		
		world.addModel(entities.get(0).getModel());
		
	}
	
	public void update() {
		
		Vector3D newPos = new Vector3D();
		
		if (game.keyboardWitness.getHeldKeys().contains(87)) newPos.Y += 1;
		if (game.keyboardWitness.getHeldKeys().contains(65)) newPos.X -= 1;
		if (game.keyboardWitness.getHeldKeys().contains(83)) newPos.Y -= 1;
		if (game.keyboardWitness.getHeldKeys().contains(68)) newPos.X += 1;
		
		if (newPos.mag() > 0.01) newPos.normalise().scale(0.1);
		
		entities.get(0).offsetPos(newPos);
		
		entities.get(0).offsetRotation(0.01);;
		
	}
	
	public void render(Graphics g) {
		
		//update camera based on new screen dimensions
		camera.iw = game.getWidth();
		camera.ih = game.getHeight();
		
		camera.sw = camera.sh * ((double) camera.iw / camera.ih);
		
		renderer.render(g, world, camera);
		
		if (game.keyboardWitness.getHeldKeys().contains(61)) camera.fl += 0.001;
		if (game.keyboardWitness.getHeldKeys().contains(45)) camera.fl -= 0.001;
		
		g.setColor(Color.white);
		
		g.drawString("" + camera.fl, 0, 10);
		
		renderer.renderDebugInfo(g);
		
	}

}
