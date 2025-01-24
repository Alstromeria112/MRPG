package net.alstromeria.mrpg.events;

import net.alstromeria.mrpg.MRPG;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerEntityEvents;
import net.minecraft.entity.projectile.ArrowEntity;

public class SetArrowDamage {
    public static void initialize() {
        MRPG.LOGGER.info("Registering Arrow Kill Event");
        ServerEntityEvents.ENTITY_LOAD.register((entity, world) -> {
            if (entity instanceof ArrowEntity arrow && !world.isClient) {
                arrow.setDamage(100.0);
                MRPG.LOGGER.info("Arrow loaded with damage: {}", arrow.getDamage());
            }
        });
    }
}