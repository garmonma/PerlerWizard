package com.nni.gamevate.perlerwizard.object;

/**
 * @author Marcus Garmon
 * @date Dec 29, 2016
 */
public class Wall extends GameObject implements Collidable {

	private String side;
	
	public Wall(float width, float height, float x, float y, String side) {
		super(width, height, x, y);
		this.side = side;
	}

	@Override
	public boolean collided(Collidable object) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void update(float delta) {
		// TODO Auto-generated method stub
		
	}
	
	public String getSide(){
		return side;
	}
	
	public void setDirection(float degrees){
		direction.set(position).setAngle(degrees);
	}

}
