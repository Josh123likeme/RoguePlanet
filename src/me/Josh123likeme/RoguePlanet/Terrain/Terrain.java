package me.Josh123likeme.RoguePlanet.Terrain;

import java.io.File;

import me.Josh123likeme.Render3D4p0.World.Model;
import me.Josh123likeme.RoguePlanet.Utils.STLParser;

public class Terrain {

	private Model model;
	
	public Terrain() {
		
		File file = new File("C:\\Users\\joshu\\Downloads\\untitled.stl");
		
		STLParser stlp = new STLParser();
		
		model = stlp.parseSTL(file);
		
	}
	
	public Model getModel() {
		
		return model;
		
	}
	
}
