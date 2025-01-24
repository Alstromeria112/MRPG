package net.alstromeria.mrpg.events;

import net.fabricmc.fabric.api.entity.event.v1.ServerLivingEntityEvents;
import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.projectile.TridentEntity;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;

public class HitTrident {
    public static void register() {
        ServerLivingEntityEvents.AFTER_DAMAGE.register((entity, source, amount, f, b) -> {
            if (source.getSource() instanceof TridentEntity) {
                if (entity.getCommandTags().contains("hitTrident")) {
                    if (entity.getWorld() instanceof ServerWorld) {
                        entity.kill((ServerWorld) entity.getWorld());
                    }
                } else {
                    entity.addCommandTag("hitTrident");
                }
            }
        });

        AttackEntityCallback.EVENT.register((player, world, hand, entity, hitResult) -> {
            if (player.getStackInHand(hand).getItem() == Items.TRIDENT) {
                if (entity.getCommandTags().contains("hitTrident")) {
                    if (world instanceof ServerWorld) {
                        entity.kill((ServerWorld) world);
                    }
                } else {
                    entity.addCommandTag("hitTrident");
                }
            }
            return ActionResult.PASS;
        });
    }
}