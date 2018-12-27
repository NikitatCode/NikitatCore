package ru.nikitat.nikitatcore.blocks;

import net.minecraft.block.Block;
import net.minecraft.block.SoundType;
import net.minecraft.block.material.Material;
import net.minecraft.block.properties.IProperty;
import net.minecraft.block.properties.PropertyInteger;
import net.minecraft.block.state.BlockStateContainer;
import net.minecraft.block.state.IBlockState;
import net.minecraft.client.renderer.block.model.ModelResourceLocation;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.NonNullList;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.World;
import net.minecraftforge.client.model.ModelLoader;
import net.minecraftforge.oredict.OreDictionary;
import ru.nikitat.nikitatcore.NikitatCoreMod;
import ru.nikitat.nikitatcore.api.INeedManyNames;
import ru.nikitat.nikitatcore.api.NikitatBlock;
import ru.nikitat.nikitatcore.enums.EnumMetals;

public class BlockNikitatOres extends Block implements NikitatBlock, INeedManyNames {

    public static final PropertyInteger TYPE = PropertyInteger.create("type", 0, EnumMetals.maxMetaOre);
    private static float[] hardnessList;

    public BlockNikitatOres() {
        super(Material.ROCK);
        this.setCreativeTab(NikitatCoreMod.tabMetals);
        this.setRegistryName("ncnt", "nikitat_ores");
        this.setResistance(5.0F);
        this.setSoundType(SoundType.STONE);
        hardnessList = new float[EnumMetals.maxMetaOre];
        for (EnumMetals em : EnumMetals.values()) {
            if (em.hasOre) {
                IBlockState bs = this.getDefaultState().withProperty(TYPE, em.meta);
                this.setHarvestLevel("pickaxe", em.harvestLevel);
                hardnessList[em.meta] = em.hardnessOre;
            }
        }
    }

    @Override
    public void getSubBlocks(CreativeTabs itemIn, NonNullList<ItemStack> items) {
        //if (itemIn == NikitatCoreMod.tabMetals) {
        for (EnumMetals em : EnumMetals.values()) {
            if (em.hasOre) {
                items.add(new ItemStack(this, 1, em.meta));
            }
        }
        //}
    }

    @Override
    public float getBlockHardness(IBlockState blockState, World worldIn, BlockPos pos) {
        return hardnessList[blockState.getValue(TYPE).intValue()];
    }

    @Override
    public int damageDropped(IBlockState state) {
        return state.getValue(TYPE).intValue();
    }

    @Override
    public String[] getNames() {
        String[] s = new String[EnumMetals.maxMetaOre];
        for (EnumMetals em : EnumMetals.values()) {
            if (em.hasOre) {
                s[em.meta] = "nikitat.ore." + em.name();
            }
        }
        return s;
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
            if (em.hasOre) {
                OreDictionary.registerOre("ore" + em.oreDictName, new ItemStack(this, 1, em.meta));
            }
        }
    }

    @Override
    public void setRender() {
        for (EnumMetals em : EnumMetals.values()) {
            if (em.hasOre) {
                ModelLoader.setCustomModelResourceLocation(Item.getItemFromBlock(this), em.meta, new ModelResourceLocation("ncnt:ore" + em.meta, "inventory"));
            }
        }
    }

    public IBlockState getStateFromMeta(int meta) {
        return this.getDefaultState().withProperty(TYPE, meta);
    }


    public int getMetaFromState(IBlockState state) {
        return ((Integer) state.getValue(TYPE)).intValue();
    }

    protected BlockStateContainer createBlockState() {
        return new BlockStateContainer(this, new IProperty[]{TYPE});
    }

}
