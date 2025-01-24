package net.alstromeria.mrpg;

import net.alstromeria.mrpg.commands.Trader.Command;
import net.alstromeria.mrpg.events.HitSnowBall;
import net.alstromeria.mrpg.events.HitTrident;
import net.alstromeria.mrpg.events.SetArrowDamage;
import net.alstromeria.mrpg.events.UsedAxe;
import net.alstromeria.mrpg.item.ModItems;
import net.fabricmc.api.ModInitializer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MRPG implements ModInitializer {
	public static final String MOD_ID = "mrpg";
	public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

	@Override
	public void onInitialize() {
		ModItems.initialize();
		SetArrowDamage.initialize();
		Command.initialize();
		UsedAxe.register();
		HitSnowBall.register();
		HitTrident.register();
		LOGGER.info("Successfully initialized.");
	}
}