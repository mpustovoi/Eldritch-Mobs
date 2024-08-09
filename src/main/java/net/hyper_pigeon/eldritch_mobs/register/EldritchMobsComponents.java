package net.hyper_pigeon.eldritch_mobs.register;

import net.hyper_pigeon.eldritch_mobs.EldritchMobsMod;
import net.hyper_pigeon.eldritch_mobs.component.MobModifierComponent;
import net.minecraft.entity.mob.MobEntity;
import org.ladysnake.cca.api.v3.entity.EntityComponentFactoryRegistry;
import org.ladysnake.cca.api.v3.entity.EntityComponentInitializer;

public final class EldritchMobsComponents implements EntityComponentInitializer {
    @Override
    public void registerEntityComponentFactories(EntityComponentFactoryRegistry registry) {
        registry.registerFor(MobEntity.class, EldritchMobsMod.ELDRITCH_MODIFIERS, MobModifierComponent::new);
    }
}
