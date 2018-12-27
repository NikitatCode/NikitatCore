package ru.nikitat.nikitatcore.items;

import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.oredict.OreDictionary;
import ru.nikitat.nikitatcore.NikitatCoreMod;
import ru.nikitat.nikitatcore.api.NikitatItem;
import ru.nikitat.nikitatcore.enums.EnumMetals;


public class NikitatIngots extends Item implements NikitatItem {

    private String[] names = new String[EnumMetals.maxMeta];

    public NikitatIngots() {
        this.setHasSubtypes(true);
        this.setCreativeTab(NikitatCoreMod.tabMetals);
        this.setRegistryName("ncnt", "nikitat_ingots");
        for (EnumMetals em : EnumMetals.values()) {
            names[em.meta] = "nikitat.ingot." + em.name();
        }
    }

    @Override
    public void getSubItems(CreativeTabs tab, NonNullList<ItemStack> items) {
        if (tab == NikitatCoreMod.tabMetals) {
            for (EnumMetals em : EnumMetals.values()) {
                items.add(new ItemStack(this, 1, em.meta));
            }
        }
    }

    @Override
    public String getUnlocalizedName(ItemStack stack) {
        return names[stack.getItemDamage()];
    }

    @Override
    public void postRegWithThaumcraft() {

    }

    @Override
    public void postRegWithWizardry() {

    }

    @Override
    public void postReg() {
        for (EnumMetals em : EnumMetals.values()) {
            OreDictionary.registerOre("ingot" + em.oreDictName, new ItemStack(this, 1, em.meta));
        }
    }

    @Override
    public void setRender() {
        for (EnumMetals em : EnumMetals.values()) {
            ModelLoader.setCustomModelResourceLocation(this, em.meta, new ModelResourceLocation("ncnt:ningot" + em.meta, "inventory"));
        }
    }
}
