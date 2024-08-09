package net.hyper_pigeon.eldritch_mobs.register;

import net.hyper_pigeon.eldritch_mobs.EldritchMobsMod;
import net.minecraft.entity.attribute.EntityAttributeModifier;
import net.minecraft.util.Identifier;

public class EldritchMobsAttributeModifiers {
    public static final EntityAttributeModifier ELITE_HEALTH_BOOST = new EntityAttributeModifier(Identifier.of("elite_health_boost"), EldritchMobsMod.ELDRITCH_MOBS_CONFIG.EliteHealthMultiplier,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);

    public static final EntityAttributeModifier ULTRA_HEALTH_BOOST = new EntityAttributeModifier(Identifier.of("ultra_health_boost"), EldritchMobsMod.ELDRITCH_MOBS_CONFIG.UltraHealthMultiplier,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);

    public static final EntityAttributeModifier ELDRITCH_HEALTH_BOOST = new EntityAttributeModifier(Identifier.of("eldritch_health_boost"), EldritchMobsMod.ELDRITCH_MOBS_CONFIG.EldritchHealthMultiplier,
            EntityAttributeModifier.Operation.ADD_MULTIPLIED_BASE);
}
