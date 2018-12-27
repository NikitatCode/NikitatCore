package ru.nikitat.nikitatcore.registers;


import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.Loader;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.fml.common.registry.ForgeRegistries;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;
import ru.nikitat.nikitatcore.api.*;
import ru.nikitat.nikitatcore.utils.NameItemBlock;

import java.util.ArrayList;
import java.util.HashMap;

//Mod.EventBusSubscriber(modid = "ncnt")
public class NikitatRegistry {
    private static HashMap<String, Item> items = new HashMap<String, Item>();
    private static HashMap<String, Block> blocks = new HashMap<String, Block>();
    public static ArrayList<NikitatGameObject> regrenderlist = new ArrayList<NikitatGameObject>();

    public static Block getBlock(String name) {
        return blocks.get(name);
    }

    public static Item getItemForNBlock(String namenb) {
        return Item.getItemFromBlock(blocks.get(namenb));
    }

    public static Item getItem(String name) {
        return items.get(name);
    }

    public static void registerItem(NikitatItem ni) {
        /*while (!rl.empty()) {
            NikitatItem ni = rl.pop();*/
        if (ni instanceof Item) {
            Item item = (Item) ni;
            ForgeRegistries.ITEMS.register(item);
            items.put(item.getRegistryName().getResourcePath(), item);
            ni.postReg();
            regrenderlist.add(ni);
            if (Loader.isModLoaded("Thaumcraft")) {
                ni.postRegWithThaumcraft();
            }
            if (Loader.isModLoaded("wizardrynt")) {
                ni.postRegWithWizardry();
            }
        }
    }

    public static void registerBlock(NikitatBlock nb) {
        /*while (!rl.empty()) {
            NikitatBlock nb = rl.pop();*/
        if (nb instanceof Block) {
            Block block = (Block) nb;
            ForgeRegistries.BLOCKS.register(block);
            ForgeRegistries.ITEMS.register(new ItemBlock(block).setRegistryName(block.getRegistryName()));
            blocks.put(block.getRegistryName().getResourcePath(), (Block) nb);
            nb.postReg();
            regrenderlist.add(nb);
            if (Loader.isModLoaded("Thaumcraft")) {
                nb.postRegWithThaumcraft();
            }
            if (Loader.isModLoaded("wizardrynt")) {
                nb.postRegWithWizardry();
            }
        }
    }

    public static void registerBlockWithItemBlock(IHaveItemBlock ihib) {
        /*while (!rl.empty()) {
            NikitatBlock nb = rl.pop();*/
        if (ihib instanceof Block && ihib instanceof NikitatBlock) {
            NikitatBlock nb = (NikitatBlock) ihib;
            Block block = (Block) nb;
            ForgeRegistries.BLOCKS.register(block);
            ForgeRegistries.ITEMS.register(ihib.getItemBlock());
            blocks.put(block.getRegistryName().getResourcePath(), (Block) nb);
            nb.postReg();
            regrenderlist.add(nb);
            if (Loader.isModLoaded("Thaumcraft")) {
                nb.postRegWithThaumcraft();
                //nib.postRegWithThaumcraft();
            }
            if (Loader.isModLoaded("wizardrynt")) {
                nb.postRegWithWizardry();
            }
        }
    }

    public static void registerINMNBlock(INeedManyNames inmnb) {
        if (inmnb instanceof Block && inmnb instanceof NikitatBlock) {
            NikitatBlock nb = (NikitatBlock) inmnb;
            Block block = (Block) nb;
            ForgeRegistries.BLOCKS.register(block);
            ForgeRegistries.ITEMS.register(new NameItemBlock(block));
            blocks.put(block.getRegistryName().getResourcePath(), (Block) nb);
            nb.postReg();
            regrenderlist.add(nb);
            if (Loader.isModLoaded("Thaumcraft")) {
                nb.postRegWithThaumcraft();
            }
            if (Loader.isModLoaded("wizardrynt")) {
                nb.postRegWithWizardry();
            }
        }
    }

    public static Item getItemOrItemBlock(String name){
        if(items.containsKey(name)){
            return items.get(name);
        }else if(blocks.containsKey(name)){
            return getItemForNBlock(name);
        }else return null;
    }

    @SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        System.out.println("11221122");
        for (int i = 0; i<regrenderlist.size(); i++) {
            if(regrenderlist.get(i) != null){
                regrenderlist.get(i).setRender();
            }
        }
        regrenderlist.clear();
    }

}
