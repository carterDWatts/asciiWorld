package asciiWorld;

import asciiPanel.AsciiPanel;

public class FungusAi extends CreatureAi {

	private CreatureFactory factory;
	private int spreadCount;
	
	public FungusAi(Creature creature, CreatureFactory factory) {
		super(creature);
		this.factory = factory;
	}
	
	public void onUpdate() {
		if(spreadCount < 5 && Math.random() < .2) {
			spread();
		}
	}
	
	public void spread() {
		int x = creature.x + (int)(Math.random()*11) - 5;  
		int y = creature.y + (int)(Math.random()*11) - 5;
		
		if(!creature.canEnter(x,y))
			return;
		
		Creature child = factory.newFungus();
		child.x = x;
		child.y = y;
		spreadCount++;
	}
}