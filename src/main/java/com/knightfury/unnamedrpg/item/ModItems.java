package com.knightfury.unnamedrpg.item;

import com.knightfury.unnamedrpg.UnnamedRPG;
import com.knightfury.unnamedrpg.block.ModBlocks;
import com.knightfury.unnamedrpg.util.Registration;
import net.minecraft.inventory.EquipmentSlotType;
import net.minecraft.item.*;
import net.minecraft.item.crafting.Ingredient;
import net.minecraft.util.SoundEvent;
import net.minecraft.util.SoundEvents;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

public class ModItems
{
    public static final RegistryObject<Item> CHIMERA_HORN =
            Registration.ITEMS.register("chimera_horn",
                    () -> new Item(new Item.Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> MITHRIL_INGOT =
            Registration.ITEMS.register("mithril_ingot",
                    () -> new Item(new Item.Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> RAW_CHIMERA_MEAT =
            Registration.ITEMS.register("raw_chimera_meat",
                    () -> new RawChimeraMeat());

    /* TOOLS */

    public static final RegistryObject<Item> MITHRIL_SHOVEL =
            Registration.ITEMS.register("mithril_shovel",
                    () -> new ShovelItem(ModItemTier.MITHRIL, 0f, 0f,
                            new Item.Properties()
                                .defaultMaxDamage(150)
                                .addToolType(ToolType.SHOVEL, 3)
                                .group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> MITHRIL_SWORD =
            Registration.ITEMS.register("mithril_sword",
                    () -> new SwordItem(ModItemTier.MITHRIL, 5, 4f,
                            new Item.Properties()
                                 .defaultMaxDamage(150)
                                 .group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> MITHRIL_AXE =
            Registration.ITEMS.register("mithril_axe",
                    () -> new AxeItem(ModItemTier.MITHRIL, 7, 2f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.AXE, 3)
                                    .group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> MITHRIL_HOE =
            Registration.ITEMS.register("mithril_hoe",
                    () -> new HoeItem(ModItemTier.MITHRIL, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.HOE, 3)
                                    .group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> MITHRIL_PICKAXE =
            Registration.ITEMS.register("mithril_pickaxe",
                    () -> new PickaxeItem(ModItemTier.MITHRIL, 0, 0f,
                            new Item.Properties()
                                    .defaultMaxDamage(150)
                                    .addToolType(ToolType.PICKAXE, 3)
                                    .group(UnnamedRPG.UNNAMED_RPG_TAB)));

    /* ARMOR */

    public static final RegistryObject<Item> MITHRIL_HELMET =
            Registration.ITEMS.register("mithril_helmet",
                    () -> new ArmorItem(ModArmorMaterial.MITHRIL, EquipmentSlotType.HEAD,
                            new Item.Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> MITHRIL_CHESTPLATE =
            Registration.ITEMS.register("mithril_chestplate",
                    () -> new ArmorItem(ModArmorMaterial.MITHRIL, EquipmentSlotType.CHEST,
                            new Item.Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> MITHRIL_LEGGINGS =
            Registration.ITEMS.register("mithril_leggings",
                    () -> new ArmorItem(ModArmorMaterial.MITHRIL, EquipmentSlotType.LEGS,
                            new Item.Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> MITHRIL_BOOTS =
            Registration.ITEMS.register("mithril_boots",
                    () -> new ArmorItem(ModArmorMaterial.MITHRIL, EquipmentSlotType.FEET,
                            new Item.Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)));

    public static final RegistryObject<Item> WOLFSBANE_SEEDS =
            Registration.ITEMS.register("wolfsbane_seeds",
                    () -> new BlockItem(ModBlocks.WOLFSBANE_CROP.get(), new Item.Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)));


    public static void register() { }

    public enum ModArmorMaterial implements IArmorMaterial
    {
        MITHRIL(1050, new int[] { 8, 11, 12, 7}, 27, SoundEvents.ITEM_ARMOR_EQUIP_IRON,
                Ingredient.fromStacks(new ItemStack(ModItems.MITHRIL_INGOT.get())),
                UnnamedRPG.MOD_ID + ":mithril", 4, 0);

        private final int durability;
        private final int[] damageReductionAmountArray;
        private final int enchantability;
        private final SoundEvent soundEvent;
        private final Ingredient repairMaterial;
        private final String name;
        private final float toughness;
        private final float knockbackResistance;

        ModArmorMaterial(int durability, int[] damageReductionAmountArray, int enchantability, SoundEvent soundEvent, Ingredient repairMaterial, String name, float toughness, float knockbackResistance) {
            this.durability = durability;
            this.damageReductionAmountArray = damageReductionAmountArray;
            this.enchantability = enchantability;
            this.soundEvent = soundEvent;
            this.repairMaterial = repairMaterial;
            this.name = name;
            this.toughness = toughness;
            this.knockbackResistance = knockbackResistance;
        }

        @Override
        public int getDurability(EquipmentSlotType slotIn)
        {
            return durability;
        }

        @Override
        public int getDamageReductionAmount(EquipmentSlotType slotIn)
        {
            return damageReductionAmountArray[slotIn.getIndex()];
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public SoundEvent getSoundEvent()
        {
            return soundEvent;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return repairMaterial;
        }

        @Override
        public String getName()
        {
            return name;
        }

        @Override
        public float getToughness()
        {
            return toughness;
        }

        @Override
        public float getKnockbackResistance() {
            return knockbackResistance;
        }

    }

    public enum ModItemTier implements IItemTier
    {
        MITHRIL(3, 4450, 3f, 2f, 30,
                Ingredient.fromStacks(new ItemStack(ModItems.MITHRIL_INGOT.get())));

        private final int harvestLevel;
        private final int maxUses;
        private final float efficiency;
        private final float attackDamage;
        private final int enchantability;
        private final Ingredient repairMaterial;

        ModItemTier(int harvestLevel, int maxUses, float efficiency, float attackDamage, int enchantability, Ingredient repairMaterial) {
            this.harvestLevel = harvestLevel;
            this.maxUses = maxUses;
            this.efficiency = efficiency;
            this.attackDamage = attackDamage;
            this.enchantability = enchantability;
            this.repairMaterial = repairMaterial;
        }


        @Override
        public int getMaxUses()
        {
            return harvestLevel;
        }

        @Override
        public float getEfficiency()
        {
            return efficiency;
        }

        @Override
        public float getAttackDamage()
        {
            return attackDamage;
        }

        @Override
        public int getHarvestLevel()
        {
            return harvestLevel;
        }

        @Override
        public int getEnchantability()
        {
            return enchantability;
        }

        @Override
        public Ingredient getRepairMaterial()
        {
            return repairMaterial;
        }
    }
}
