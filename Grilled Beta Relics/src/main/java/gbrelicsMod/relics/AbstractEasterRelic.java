package gbrelicsMod.relics;

import com.badlogic.gdx.graphics.Texture;
import com.megacrit.cardcrawl.actions.*;
import com.megacrit.cardcrawl.actions.AbstractGameAction.AttackEffect;
import com.megacrit.cardcrawl.actions.common.*;
import com.megacrit.cardcrawl.core.AbstractCreature;
import com.megacrit.cardcrawl.dungeons.AbstractDungeon;

import basemod.abstracts.CustomRelic;


public abstract class AbstractEasterRelic extends CustomRelic {
	public AbstractEasterRelic(String ID, Texture texture, Texture outline, RelicTier tier, LandingSound sfx) {
        super(ID, texture, outline, tier, sfx);
    }
	
	public void gainMaxHP(int MHPgain) {
		com.megacrit.cardcrawl.dungeons.AbstractDungeon.player.increaseMaxHp(MHPgain, true);
	}
	public void gainMaxHP(int MHPgain, Boolean ShowEffect) {
		com.megacrit.cardcrawl.dungeons.AbstractDungeon.player.increaseMaxHp(MHPgain, ShowEffect);
	}
	
	public void loseHP(int HP_AMT) {
		com.megacrit.cardcrawl.dungeons.AbstractDungeon.player.currentHealth -= HP_AMT;
	}
	public void loseHP(int HP_AMT, Boolean AbsoluteLoss, AbstractCreature player) {
		if(AbsoluteLoss) {
			loseHP(HP_AMT);
		}
		else {
			System.out.println("AHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHHH");
			AbstractDungeon.actionManager.addToBottom(new LoseHPAction(player, player, HP_AMT,  AbstractGameAction.AttackEffect.FIRE ));  
		}
	}
	public void loseHP(int HP_AMT, AbstractCreature target, AbstractCreature source) {
		AbstractDungeon.actionManager.addToBottom(new LoseHPAction(target, source, HP_AMT,  AbstractGameAction.AttackEffect.FIRE ));
	}
	public void loseHP(int HP_AMT, AbstractCreature target, AbstractCreature source, AttackEffect effect) {
		AbstractDungeon.actionManager.addToBottom(new LoseHPAction(target, source, HP_AMT,  effect ));
	}
	
	
	
}