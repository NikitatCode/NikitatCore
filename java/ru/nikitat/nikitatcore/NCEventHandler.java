package ru.nikitat.nikitatcore;


import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.client.event.ModelRegistryEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import ru.nikitat.nikitatcore.api.NikitatGameObject;
import ru.nikitat.nikitatcore.registers.NikitatRegistry;

public class NCEventHandler {

    @SubscribeEvent
    public void onLivingUpdateEvent(EntityJoinWorldEvent event) {
        if (event.getEntity() instanceof EntityPlayer) {
        }
    }

    /*@SubscribeEvent
    public void registerModels(ModelRegistryEvent event) {
        for (NikitatGameObject ni : NikitatRegistry.regrenderlist) {
            ni.setRender();
            NikitatRegistry.regrenderlist.remove(ni);
        }
        System.out.println("11221122");
    }*/

   /* @SubscribeEvent
    public void onEntityConstructing(EntityEvent.EntityConstructing event) {
        if (event.entity instanceof EntityPlayer && PlayerMoneyData.get((EntityPlayer) event.entity) == null) PlayerMoneyData.register((EntityPlayer) event.entity);
    }*/

    
}
