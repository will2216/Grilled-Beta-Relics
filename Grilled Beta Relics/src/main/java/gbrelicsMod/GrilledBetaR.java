package gbrelicsMod;

import java.nio.charset.StandardCharsets;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.Texture;
import com.evacipated.cardcrawl.modthespire.lib.SpireInitializer;
import com.megacrit.cardcrawl.localization.RelicStrings;

import basemod.BaseMod;
import basemod.ModPanel;
import basemod.helpers.RelicType;
import basemod.interfaces.*;
import gbrelicsMod.relics.*;


@SpireInitializer
public class GrilledBetaR implements PostInitializeSubscriber, 
EditRelicsSubscriber,
EditStringsSubscriber
{
	public static final Logger logger = LogManager.getLogger(GrilledBetaR.class.getName());
	
	private static final String MODNAME = "Grilled Beta Relics";
    private static final String AUTHOR = "Beta Chess";
    private static final String DESCRIPTION = "Adds additional relics to Slay The Spire";
	
	
	public GrilledBetaR() {
    	BaseMod.subscribe(this);
    }
    
    
    // !!! Initialize mod
    public static void initialize() {
    	logger.info("------------------------- Grilled initiation -------------------------");
    	
    	
    	@SuppressWarnings("unused")
    	GrilledBetaR GBRMod = new GrilledBetaR();
    	
    	
    	logger.info("----------------------------------------------------------------------------");
    }
	
	
	
	@Override
    public void receivePostInitialize() {
    	
    	
    	// Mod badge
    	logger.info("Creating mod badge");
    	
    	
    	ModPanel settingsPanel = new ModPanel();
    	Texture badgeTexture = new Texture("img/GrilledBetaRelicsBadge.png");
    	
    	
    	
    	BaseMod.registerModBadge(badgeTexture, MODNAME, AUTHOR, DESCRIPTION, settingsPanel);
        
    	logger.info("Mod badge created"); 
    }
	
	@Override
    public void receiveEditStrings() {
    	logger.info("Editing strings");
    	
    	BaseMod.loadCustomStrings(RelicStrings.class, loadJson("localization/eng/GrilledRelicStrings.json"));
    	
    	logger.info("Done editing strings");
    }
	
	
	public void receiveEditRelics() {
    	logger.info("Editing relics");
    	
    	BaseMod.addRelic(new ProntoPizza(), RelicType.SHARED);

    	
    	logger.info("Done editing relics");
    }
	
	// !!! json loader
    private static String loadJson(String jsonPath) {
        return Gdx.files.internal(jsonPath).readString(String.valueOf(StandardCharsets.UTF_8));
    }
}