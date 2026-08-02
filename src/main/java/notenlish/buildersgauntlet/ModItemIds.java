package notenlish.buildersgauntlet;

import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.Item;

public class ModItemIds {
    public static ResourceKey<Item> create(String name) {
        return ResourceKey.create(Registries.ITEM, Identifier.fromNamespaceAndPath(BuilderSGauntlet.MOD_ID, name));
    }

    public static final ResourceKey<Item> BUILDERS_GAUNTLET = create("builders_gauntlet");
}
