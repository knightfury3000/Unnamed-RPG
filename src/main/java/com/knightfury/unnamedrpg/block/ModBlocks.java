package com.knightfury.unnamedrpg.block;

import com.knightfury.unnamedrpg.UnnamedRPG;
import com.knightfury.unnamedrpg.util.Registration;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraftforge.common.ToolType;
import net.minecraftforge.fml.RegistryObject;

import java.util.function.Supplier;

public class ModBlocks
{
    public static final RegistryObject<Block> MITHRIL_BLOCK = register("mithril_block",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
            .hardnessAndResistance(20f,100f)
            .harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.METAL)));

    public static final RegistryObject<Block> MITHRIL_ORE = register("mithril_ore",
            () -> new Block(AbstractBlock.Properties.create(Material.IRON)
            .hardnessAndResistance(20f,100f)
            .harvestLevel(3).harvestTool(ToolType.PICKAXE).sound(SoundType.STONE)));


    public static final RegistryObject<Block> WOLFSBANE_CROP =
            Registration.BLOCKS.register("wolfsbane_crop",
                    () -> new WolfsbaneCrop(AbstractBlock.Properties.from(Blocks.WHEAT)));

    public static void register() { }

    private static <T extends Block> RegistryObject<T> register(String name, Supplier<T> block)
    {
        RegistryObject<T> toReturn = Registration.BLOCKS.register(name, block);
        Registration.ITEMS.register(name, () -> new BlockItem(toReturn.get(),
                new Item.Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)));
        return toReturn;
    }
}
