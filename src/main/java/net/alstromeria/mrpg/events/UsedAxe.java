package net.alstromeria.mrpg.events;

import net.fabricmc.fabric.api.event.player.AttackEntityCallback;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.EntityHitResult;
import net.minecraft.world.World;
import org.jetbrains.annotations.Nullable;

public class UsedAxe {
    public static void register() {
        AttackEntityCallback.EVENT.register((PlayerEntity player, World world, Hand hand, Entity entity, @Nullable EntityHitResult hitResult) -> {
            ItemStack itemStack = player.getStackInHand(hand);
            if (world instanceof ServerWorld serverWorld && itemStack.getItem() == Items.STONE_AXE) {
                if (!player.isInCreativeMode()) {
                    itemStack.setDamage(itemStack.getDamage() + 1);
                    if (itemStack.getDamage() >= itemStack.getMaxDamage()) {
                        player.getInventory().removeOne(itemStack);
                    }
                }
                world.playSound(null, player.getX(), player.getY(), player.getZ(), SoundEvents.ITEM_TOTEM_USE, SoundCategory.MASTER, 1.0f, 1.0f);
                entity.damage(serverWorld, world.getDamageSources().sweetBerryBush(), 100f);
                return ActionResult.SUCCESS;
            }
            return ActionResult.PASS;
        });
    }
}