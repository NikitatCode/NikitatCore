package ru.nikitat.nikitatcore;


import net.minecraftforge.common.config.Config;
import ru.nikitat.nikitatcore.enums.EnumEnableDisable;

@Config(modid = "ncnt", name = "NikitatCoreConfig")
public class NCConfig {

    @Config.LangKey(value = "ncnt.config.cat.enable/disable_modules")
    @Config.Name(value = "enable/disable modules")
    public static OnOffModules cedm = new OnOffModules();

    /*@Config.Comment({
            "Uno",
            "Dos"
    })
    @Config.RangeInt(min = 0, max = 6)
    @Config.Name(value = "test")
    @Config.RequiresWorldRestart
    public static int someValue = 5;

    public static int someValue2 = 5;


    public static EnumTest enu = EnumTest.Dos;

    public enum EnumTest{
        Uno,
        Dos,
        Tres;
    }*/

    public static class OnOffModules{
        @Config.LangKey(value = "ncnt.config.module.ore")
        public EnumEnableDisable metalModule = EnumEnableDisable.Enable;
    }

}
