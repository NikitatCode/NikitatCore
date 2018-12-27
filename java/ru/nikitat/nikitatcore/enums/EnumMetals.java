package ru.nikitat.nikitatcore.enums;

public enum EnumMetals {

    copper(0, 1, 3.0F, 5.0F, "Copper"),
    tin(1, 1, 2.5F, 5.0F, "Tin"),
    lead(2, 2, 4.0F, 6.0F, "Lead"),
    bronze(3, 1, 3.0F, "Bronze");

    public int meta;
    public boolean hasOre;
    public int harvestLevel;
    public float hardnessOre;
    public float hardnessBlock;
    //public float resistanceOre;
    //public float resistanceBlock;
    public String oreDictName;
    public static int maxMeta = 4;
    public static int maxMetaOre = 3;

    private EnumMetals(int meta, int harvestLevel, float hardnessOre, float hardnessBlock, /*float resistanceOre, float resistanceBlock,*/ String oreDictName) {
        this.hasOre = true;
        this.meta = meta;
        this.harvestLevel = harvestLevel;
        this.hardnessOre = hardnessOre;
        this.hardnessBlock = hardnessBlock;
        //this.resistanceOre = resistanceOre;
        //this.resistanceBlock = resistanceBlock;
        this.oreDictName = oreDictName;
    }

    private EnumMetals(int meta, int harvestLevel, float hardnessBlock, /*float resistanceBlock,*/ String oreDictName) {
        this.hasOre = false;
        this.meta = meta;
        this.harvestLevel = harvestLevel;
        this.hardnessBlock = hardnessBlock;
        //this.resistanceBlock = resistanceBlock;
        this.oreDictName = oreDictName;
    }

}
