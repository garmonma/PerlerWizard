<<<<<<< Upstream, based on origin/master
package com.nni.gamevate.pixelwizard.skills;

public interface SpellInterface {

	public void bounce();
=======
package com.nni.gamevate.pixelwizard.spells;

public interface SpellInterface {

	public void bounce(String enemy, String side);
>>>>>>> bf64fb6 Created the foundation for the spell. SpellColor and SpellShape.
	
	public void evaporate();
	
	public void transfiguration();
}
