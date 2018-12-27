
package ru.nikitat.nikitatcore;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;
import ru.nikitat.nikitatcore.proxy.NCCommonProxy;

import ru.nikitat.nikitatcore.NCEventHandler;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;

import java.util.HashMap;


@Mod(modid = "ncnt")
public class NikitatCoreMod {

    //Tabs
    public static CreativeTabs tabMetals = null;

    @Mod.Instance("ncnt")
    public static NikitatCoreMod instance;

    @SidedProxy(clientSide = "ru.nikitat.nikitatcore.proxy.NCClientProxy", serverSide = "ru.nikitat.nikitatcore.proxy.NCServerProxy")
    public static NCCommonProxy proxy;

    @Mod.EventHandler
    public void init(FMLInitializationEvent event) {
        proxy.init(event);
    }

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        proxy.preInit(event);
        MinecraftForge.EVENT_BUS.register(new NCEventHandler());
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent event) {

    }

    /*@Mod.EventHandler
    public void serverStarting(FMLServerStartingEvent event) {
        event.registerServerCommand(new SetMoneyCommand());
        event.registerServerCommand(new GetMoneyCommand());
    }*/

    public static class Tab extends CreativeTabs {

        private String tii;

        public Tab(String label, String tii) {
            super(label);
            this.tii = tii;
        }

        @Override
        public ItemStack getTabIconItem() {
            return new ItemStack(NikitatRegistry.getItemOrItemBlock(tii));
        }
    }

}
