package net.alstromeria.mrpg.events;

import net.fabricmc.fabric.api.event.lifecycle.v1.ServerTickEvents;
import net.minecraft.entity.AreaEffectCloudEntity;
import net.minecraft.entity.EntityType;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.world.World;

public class HitSnowBall {
    public static void register() {
        ServerTickEvents.END_WORLD_TICK.register(HitSnowBall::onWorldTick);
    }

    private static void onWorldTick(ServerWorld world) {
        world.getEntitiesByType(EntityType.SNOWBALL, snowball -> true).forEach(snowball -> {
            AreaEffectCloudEntity aec = new AreaEffectCloudEntity(world, snowball.getX(), snowball.getY(), snowball.getZ());
            aec.setDuration(3);
            aec.setRadius(0);
            aec.setRadiusOnUse(0);
            aec.setParticleType(ParticleTypes.ITEM_SNOWBALL);
            aec.addEffect(new StatusEffectInstance(StatusEffects.UNLUCK, 3, 0, true, false, false));
            aec.age = 0;
            aec.addCommandTag("grenade");
            aec.addCommandTag(snowball.getUuidAsString());
            world.spawnEntity(aec);
        });

        world.getEntitiesByType(EntityType.AREA_EFFECT_CLOUD, aec -> aec.getCommandTags().contains("grenade") && aec.age == 2).forEach(aec -> {
            boolean hasAge1 = !world.getEntitiesByType(EntityType.AREA_EFFECT_CLOUD, otherAec ->
                    otherAec.getCommandTags().containsAll(aec.getCommandTags()) && otherAec.age == 1).isEmpty();
            if (!hasAge1) {
                summonAEC(world, aec);
            }
        });
    }

    private static void summonAEC(World world, AreaEffectCloudEntity aec) {
        aec.setDuration(10);
        aec.setRadius(3);
        aec.setWaitTime(0);
        aec.age = 0;
        aec.getCommandTags().clear();
        aec.addEffect(new StatusEffectInstance(StatusEffects.BLINDNESS, 100, 1, true, false, false));
        aec.addEffect(new StatusEffectInstance(StatusEffects.SLOWNESS, 100, 6, true, false, false));
        world.spawnEntity(aec);
    }
}