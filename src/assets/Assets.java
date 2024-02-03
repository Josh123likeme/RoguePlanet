package assets;

import java.io.File;
import java.net.URL;

import me.Josh123likeme.Render3D4p0.World.Model;
import me.Josh123likeme.RoguePlanet.Utils.STLParser;

public abstract class Assets {
	
	public static Model loadModel(String path) {
		
		ClassLoader classLoader = Assets.class.getClassLoader();
		URL resource = classLoader.getResource(path);
		 // File path is passed as parameter
		File file = new File(resource.getFile());
		
		STLParser stlp = new STLParser();
		
		return stlp.parseSTL(file);
		
	}
	
}
