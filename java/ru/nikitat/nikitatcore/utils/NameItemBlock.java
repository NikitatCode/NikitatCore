package ru.nikitat.nikitatcore.utils;

import net.minecraft.block.Block;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.util.math.MathHelper;
import ru.nikitat.nikitatcore.api.INeedManyNames;

public class NameItemBlock extends ItemBlock{

    private String[] names;

    public NameItemBlock(Block par1) {
        super(par1);
        this.setMaxDamage(0);
        this.setHasSubtypes(true);
        if(par1 instanceof INeedManyNames){
            names = ((INeedManyNames) par1).getNames();
            setRegistryName(block.getRegistryName());
        }
    }

    public int getMetadata(int par1) {
        return MathHelper.clamp(par1, 0, names.length-1);
    }

    public String getUnlocalizedName(ItemStack par1ItemStack) {
        return names[MathHelper.clamp(par1ItemStack.getItemDamage(), 0, names.length-1)];
    }

}
