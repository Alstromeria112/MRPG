package net.alstromeria.mrpg.item;

import net.minecraft.component.DataComponentTypes;
import net.minecraft.component.type.LoreComponent;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.text.Style;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.List;

public class SupportItems {
    private static final Style ITALIC = Style.EMPTY.withItalic(false);
    private static final Formatting GREEN = Formatting.GREEN;
    private static final Formatting GRAY = Formatting.GRAY;
    private static final Formatting DARK_GRAY = Formatting.DARK_GRAY;
    private static final Formatting RED = Formatting.RED;
    private static final Formatting DARK_RED = Formatting.DARK_RED;

    public static ItemStack createHeartOfTheSea() {
        ItemStack heartOfTheSea = new ItemStack(Items.HEART_OF_THE_SEA, 1);
        heartOfTheSea.set(DataComponentTypes.ITEM_NAME, Text.of("占い師の心"));
        heartOfTheSea.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("購入した数だけ看板から").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("役職を見ることができる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("※占いは一夜につき一度のみ").formatted(RED).fillStyle(ITALIC)
                )
        ));
        return heartOfTheSea;
    }

    public static ItemStack createGunpowder() {
        ItemStack gunpowder = new ItemStack(Items.GUNPOWDER, 1);
        gunpowder.set(DataComponentTypes.ITEM_NAME, Text.of("霊媒師の遺灰"));
        gunpowder.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("オフハンドで使用").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("死亡者全員の名前がわかる").formatted(GRAY).fillStyle(ITALIC)
                )
        ));
        return gunpowder;
    }

    public static ItemStack createGoldenHorseArmor() {
        ItemStack goldenHorseArmor = new ItemStack(Items.GOLDEN_HORSE_ARMOR, 1);
        goldenHorseArmor.set(DataComponentTypes.ITEM_NAME, Text.of("霊能者の馬鎧"));
        goldenHorseArmor.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("看板に使用(夜限定)").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("使用した夜の間一度だけ対象を").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("致命傷から護ることができる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("護衛が成功すると翌朝に通知が届く").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("※自分には使用できない").formatted(RED).fillStyle(ITALIC),
                        Text.literal("※人狼にも使用できるが効果はない").formatted(RED).fillStyle(ITALIC)
                )
        ));
        return goldenHorseArmor;
    }

    public static ItemStack createEndCrystal() {
        ItemStack endCrystal = new ItemStack(Items.END_CRYSTAL, 1);
        endCrystal.set(DataComponentTypes.ITEM_NAME, Text.literal("共犯者の目").formatted(GRAY));
        endCrystal.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("オフハンドで使用").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("人狼誰か一人の名前がわかる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("※共犯者意外使用できない").formatted(RED).fillStyle(ITALIC)
                )
        ));
        return endCrystal;
    }

    public static ItemStack createNetherStar() {
        ItemStack netherStar = new ItemStack(Items.NETHER_STAR, 1);
        netherStar.set(DataComponentTypes.ITEM_NAME, Text.of("聖なる十字架"));
        netherStar.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("殴って使用").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("吸血鬼を一撃で倒せる").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("※一回で壊れる").formatted(RED).fillStyle(ITALIC)
                )
        ));
        return netherStar;
    }

    public static ItemStack createSunflower() {
        ItemStack sunflower = new ItemStack(Items.SUNFLOWER, 1);
        sunflower.set(DataComponentTypes.ITEM_NAME, Text.of("プロビデンスの眼光"));
        sunflower.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("オフハンドで使用").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("自分以外の全生存者に").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("40秒間の発光をもたらす").formatted(GRAY).fillStyle(ITALIC)
                )
        ));
        return sunflower;
    }

    public static ItemStack createPaper() {
        ItemStack paper = new ItemStack(Items.PAPER, 1);
        paper.set(DataComponentTypes.ITEM_NAME, Text.of("天啓の呪符"));
        paper.set(DataComponentTypes.LORE, new LoreComponent(
                List.of(
                        Text.literal("オフハンドで使用").formatted(GREEN).fillStyle(ITALIC),
                        Text.literal("使用してから次の朝まで").formatted(GRAY).fillStyle(ITALIC),
                        Text.literal("自分が占われたことを察知できる").formatted(GRAY).fillStyle(ITALIC)
                )
        ));
        return paper;
    }
}
