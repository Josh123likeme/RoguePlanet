package me.Josh123likeme.RoguePlanet.Entities;

import me.Josh123likeme.Render3D4p0.Vector3D;
import me.Josh123likeme.Render3D4p0.World.Model;

public class Entity {

	protected Model model;
	
	public Model getModel() {
		
		return model;
		
	}
	
	public Vector3D getPos() {
		
		return model.getPos();
		
	}
	
	public void setPos(Vector3D pos) {
		
		model.setPos(pos);
		
	}
	
	public void offsetPos(Vector3D offset) {
		
		model.offsetPos(offset);
		
	}
	
	public void setRotation(double yaw) {
		
		model.setRotation(yaw);
		
	}
	
	public void offsetRotation(double yaw) {
		
		model.offsetRotation(yaw);
		
	}
	
}
