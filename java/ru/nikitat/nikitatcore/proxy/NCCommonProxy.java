package ru.nikitat.nikitatcore.proxy;

import net.minecraft.util.text.translation.I18n;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;
import ru.nikitat.nikitatcore.NCConfig;
import ru.nikitat.nikitatcore.NikitatCoreMod;
import ru.nikitat.nikitatcore.blocks.BlockNikitatMetalBlocks;
import ru.nikitat.nikitatcore.blocks.BlockNikitatOres;
import ru.nikitat.nikitatcore.enums.EnumEnableDisable;
import ru.nikitat.nikitatcore.items.NikitatIngots;
import ru.nikitat.nikitatcore.items.NikitatNuggets;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;

public class NCCommonProxy {

    public void preInit(FMLPreInitializationEvent event) {
        if (NCConfig.cedm.metalModule == EnumEnableDisable.Enable) {
            NikitatCoreMod.tabMetals = new NikitatCoreMod.Tab("ncnt.tab.name.metals", "nikitat_ores");
            NikitatRegistry.registerINMNBlock(new BlockNikitatOres());
            NikitatRegistry.registerINMNBlock(new BlockNikitatMetalBlocks());
            NikitatRegistry.registerItem(new NikitatNuggets());
            NikitatRegistry.registerItem(new NikitatIngots());
        }
    }

    public void init(FMLInitializationEvent event) {

    }

    public void postInit(FMLPostInitializationEvent event) {

    }

}
