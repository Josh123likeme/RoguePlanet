package me.Josh123likeme.RoguePlanet.Entities;

import java.io.File;

import me.Josh123likeme.RoguePlanet.Utils.STLParser;

public class PLAYER extends Entity {

	public PLAYER() {
		
		STLParser stlp = new STLParser();
		
		model = stlp.parseSTL(new File("src/assets/models/PLAYER.stl"));
		
	}
	
}
