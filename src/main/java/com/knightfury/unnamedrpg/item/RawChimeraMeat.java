package com.knightfury.unnamedrpg.item;

import com.knightfury.unnamedrpg.UnnamedRPG;
import net.minecraft.item.Food;
import net.minecraft.item.Item;
import net.minecraft.potion.EffectInstance;
import net.minecraft.potion.Effects;

public class RawChimeraMeat extends Item
{
    public RawChimeraMeat()
    {
        super(new Properties().group(UnnamedRPG.UNNAMED_RPG_TAB)
                .food(new Food.Builder()
                        .hunger(2)
                        .saturation(1f)
                        .build()));
    }
}
