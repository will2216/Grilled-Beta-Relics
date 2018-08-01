package gbrelicsMod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.relics.AbstractRelic;
 

public class ProntoPizza extends AbstractEasterRelic {
	public static final String ID = "ProntoPizza";
    private static final String IMG = "relics/PorontoPepperPizza.png";
    private static final String OutlineIMG = "relics/outline/PorontoPepperPizza.png";
    
    private static final int HP_AMT = 15;
    private static final int DMG_AMT = 9;
    
    
    public void onEquip() {
    	gainMaxHP(HP_AMT);
    	loseHP(DMG_AMT);
    }
    
    public ProntoPizza() {
        super(ID, new Texture(IMG), new Texture(OutlineIMG), RelicTier.COMMON, LandingSound.FLAT);
    }
    
    
    
    @Override
    public String getUpdatedDescription() {
        return DESCRIPTIONS[0] + HP_AMT + DESCRIPTIONS[1] + DMG_AMT + DESCRIPTIONS[2];
    }
    
    @Override
    public AbstractRelic makeCopy() {
        return new ProntoPizza();
    }
}