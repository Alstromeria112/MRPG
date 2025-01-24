package net.alstromeria.mrpg.commands.Trader;

import net.alstromeria.mrpg.MRPG;
import net.alstromeria.mrpg.item.SupportItems;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.passive.VillagerEntity;
import net.minecraft.item.Items;
import net.minecraft.text.Text;
import net.minecraft.util.math.BlockPos;
import net.minecraft.village.*;
import net.minecraft.world.World;
import java.util.Timer;

public class Supporter {
    public static void spawnTrader(World world, BlockPos pos) {
        VillagerEntity trader = new VillagerEntity(EntityType.VILLAGER, world);
        trader.setPos(pos.getX(), pos.getY(), pos.getZ());
        trader.setVillagerData(trader.getVillagerData().withProfession(VillagerProfession.CLERIC).withLevel(5).withType(VillagerType.PLAINS));
        MRPG.LOGGER.info("Set trader profession to {}", trader.getVillagerData().getProfession());

        trader.setCustomName(Text.of("Supporter"));
        trader.setCustomNameVisible(true);
        trader.setInvulnerable(true);
        trader.setSilent(true);
        trader.setAiDisabled(false);
        trader.setPersistent();
        trader.isAttackable();

        TradeOfferList tradeOffers = new TradeOfferList();
        tradeOffers.add(new TradeOffer(
                new TradedItem(Items.EMERALD, 6),
                SupportItems.createHeartOfTheSea(),
                10000,
                0,
                0f
        ));
        tradeOffers.add(new TradeOffer(
                new TradedItem(Items.EMERALD, 4),
                SupportItems.createGunpowder(),
                10000,
                0,
                0f
        ));
        tradeOffers.add(new TradeOffer(
                new TradedItem(Items.EMERALD, 2),
                SupportItems.createGoldenHorseArmor(),
                10000,
                0,
                0f
        ));
        tradeOffers.add(new TradeOffer(
                new TradedItem(Items.EMERALD, 4),
                SupportItems.createEndCrystal(),
                10000,
                0,
                0f
        ));
        tradeOffers.add(new TradeOffer(
                new TradedItem(Items.EMERALD, 2),
                SupportItems.createNetherStar(),
                10000,
                0,
                0f
        ));
        tradeOffers.add(new TradeOffer(
                new TradedItem(Items.EMERALD, 3),
                SupportItems.createSunflower(),
                10000,
                0,
                0f
        ));
        tradeOffers.add(new TradeOffer(
                new TradedItem(Items.EMERALD, 1),
                SupportItems.createPaper(),
                10000,
                0,
                0f
        ));
        trader.setOffers(tradeOffers);

        world.spawnEntity(trader);

        new Timer().schedule(new java.util.TimerTask() {
            @Override
            public void run() {
                trader.setAiDisabled(true);
            }
        }, 100);
    }
}