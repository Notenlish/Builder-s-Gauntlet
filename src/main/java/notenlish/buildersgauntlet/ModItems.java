package notenlish.buildersgauntlet;

import net.fabricmc.fabric.api.creativetab.v1.CreativeModeTabEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.component.DataComponents;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.BlockTags;
import net.minecraft.tags.ItemTags;
import net.minecraft.tags.TagKey;
import net.minecraft.util.Unit;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ToolMaterial;
import net.minecraft.world.level.block.Block;

import java.util.function.Function;

public class ModItems {
    public static Item register(ResourceKey<Item> itemKey, Function<Item.Properties, Item> itemFactory, Item.Properties settings) {
        // Create the item instance.
        Item item = itemFactory.apply(settings.setId(itemKey));

        // Register the item.
        Registry.register(BuiltInRegistries.ITEM, itemKey, item);

        return item;
    }

    // these #region stuff are not required, fabric docs uses them to specify a portion of the code.
    // #region buildite_incorrect_blocks_tag
    public static final TagKey<Block> INCORRECT_FOR_BUILDITE_TOOL = TagKey.create(Registries.BLOCK,
            Identifier.fromNamespaceAndPath(BuilderSGauntlet.MOD_ID, "incorrect_for_buildite_tool"));
    // #endregion buildite_incorrect_blocks_tag

    public static final TagKey<Block> MINEABLE_WITH_BUILDERS_GAUNTLET = TagKey.create(Registries.BLOCK, Identifier.fromNamespaceAndPath(BuilderSGauntlet.MOD_ID, "mineable_with_builders_gauntlet"));

    public static final ToolMaterial BUILDITE_TOOL_MATERIAL = new ToolMaterial(
            INCORRECT_FOR_BUILDITE_TOOL, // incorrect blocks for drops
            67, // Six Seveen!
            6.0F,  // iron is 6.0F
            0.0F,
            22,
            BuilditeMaterial.REPAIRS_BUILDITE_ARMOR
    );

    public static final Item BUILDERS_GAUNTLET = register(
            ModItemIds.BUILDERS_GAUNTLET,
            Item::new,
            new Item.Properties().component(
                    DataComponents.UNBREAKABLE,
                    Unit.INSTANCE
            ).stacksTo(1).tool(BUILDITE_TOOL_MATERIAL, MINEABLE_WITH_BUILDERS_GAUNTLET, 1f, 1f, 0.0F)
    );

    public static void initialize() {
        // Get the event for modifying entries in the ingredients group.
        // And register an event handler that adds our suspicious item to the ingredients group.
        CreativeModeTabEvents.modifyOutputEvent(CreativeModeTabs.TOOLS_AND_UTILITIES)
                .register((creativeTab) -> creativeTab.accept(ModItems.BUILDERS_GAUNTLET));

    }

}
