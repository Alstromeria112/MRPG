package net.alstromeria.mrpg.item;

import net.alstromeria.mrpg.MRPG;
import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.component.type.PotionContentsComponent;
import net.minecraft.entity.effect.StatusEffectInstance;
import net.minecraft.entity.effect.StatusEffects;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.Potions;
import net.minecraft.registry.Registries;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;
import java.util.Optional;

public class AttackItems {
    private static final Style ITALIC = Style.EMPTY.withItalic(false);
    private static final Formatting GREEN = Formatting.GREEN;
    private static final Formatting GRAY = Formatting.GRAY;
    private static final Formatting DARK_GRAY = Formatting.DARK_GRAY;
    private static final Formatting RED = Formatting.RED;
    private static final Formatting DARK_RED = Formatting.DARK_RED;

    public static ItemStack createBow() {
        ItemStack bow = new ItemStack(Items.BOW, 1);
        bow.set(DataComponentTypes.ITEM_NAME, Text.of("弓"));
        bow.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("右クリック長押し→放して発射").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("プレイヤーを一撃で倒せる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("矢を用いる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("※一回で壊れる").formatted(RED).fillStyle(ITALIC)
                )
        ));
        bow.setDamage(383);
        return bow;
    }

    public static ItemStack createArrow() {
        ItemStack arrow = new ItemStack(Items.ARROW, 1);
        arrow.set(DataComponentTypes.ITEM_NAME, Text.of("矢"));
        arrow.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("弓を使う際必要になる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("※一回で無くなる").formatted(RED).fillStyle(ITALIC)
                )
        ));
        return arrow;
    }

    public static ItemStack createCookedBeef() {
        ItemStack cookedBeef = new ItemStack(Items.COOKED_BEEF, 5);
        cookedBeef.set(DataComponentTypes.ITEM_NAME, Text.of("ステーキ"));
        cookedBeef.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("右クリック長押しで使用").formatted(GREEN).fillStyle(ITALIC)
                )
        ));
        return cookedBeef;
    }

    public static ItemStack createPotion() {
        ItemStack potion = new ItemStack(Items.POTION, 1);

        potion.set(DataComponentTypes.ITEM_NAME, Text.of("透明化のポーション"));
        potion.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("右クリック長押しで使用").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("15秒間体が透明になる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("手に持ったアイテムは透明にならない").formatted(GRAY).fillStyle(ITALIC)
                )
        ));

        PotionContentsComponent potionComponent = new PotionContentsComponent(
                Optional.empty(),
                Optional.of(0xF6F6F6),
                List.of(new StatusEffectInstance(StatusEffects.INVISIBILITY, 300, 0)),
                Optional.of("invisibility")
        );

        potion.set(DataComponentTypes.POTION_CONTENTS, potionComponent);

        return potion;
    }


    public static ItemStack createSnowBall() {
        ItemStack snowball = new ItemStack(Items.SNOWBALL, 1);
        snowball.set(DataComponentTypes.ITEM_NAME, Text.of("スタングレネード"));
        snowball.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("右クリックで投擲").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("当てた対象を5秒間盲目にし").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("行動不能にする").formatted(GRAY).fillStyle(ITALIC)
                )
        ));
        return snowball;
    }

    public static ItemStack createTrident() {
        ItemStack trident = new ItemStack(Items.TRIDENT, 1);
        trident.set(DataComponentTypes.ITEM_NAME, Text.of("怨念の槍"));
        trident.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("殴って使用 または").setStyle(Style.EMPTY.withColor(GREEN)).fillStyle(ITALIC),
                        Text.literal("右クリック長押し→放して投擲").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("プレイヤーを2発で倒せる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("外した場合は返ってくる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("※一回で壊れる").formatted(RED).fillStyle(ITALIC)
                )
        ));
        trident.setDamage(249);
        trident.isUsedOnRelease();
        return trident;
    }

    public static ItemStack createStoneAxe() {
        ItemStack stoneAxe = new ItemStack(Items.STONE_AXE, 1);
        stoneAxe.set(DataComponentTypes.ITEM_NAME, Text.literal("人狼の斧").formatted(DARK_RED));
        stoneAxe.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("殴って使用").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("プレイヤーを一撃で倒せる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("昼のあいだは一度しか使えない").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("※一回で壊れる").formatted(RED).fillStyle(ITALIC),
                        Text.literal("※人狼以外購入できない").formatted(DARK_RED).fillStyle(ITALIC)
                )
        ));
        stoneAxe.setDamage(130);
        return stoneAxe;
    }
}
