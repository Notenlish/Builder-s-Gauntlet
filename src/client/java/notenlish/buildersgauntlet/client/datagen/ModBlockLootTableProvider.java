package notenlish.buildersgauntlet.client.datagen;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootSubProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.world.level.block.Blocks;

import java.util.concurrent.CompletableFuture;

public class ModBlockLootTableProvider extends FabricBlockLootSubProvider {
    protected ModBlockLootTableProvider(FabricPackOutput dataOutput, CompletableFuture<HolderLookup.Provider> registryLookup) {
        super(dataOutput, registryLookup);
    }

    @Override
    public void generate() {
        dropWhenSilkTouch(Blocks.SHORT_GRASS);
        dropWhenSilkTouch(Blocks.TALL_GRASS);
        dropWhenSilkTouch(Blocks.COBWEB);
        dropWhenSilkTouch(Blocks.FERN);
        dropWhenSilkTouch(Blocks.LARGE_FERN);
        dropWhenSilkTouch(Blocks.DEAD_BUSH);
        dropWhenSilkTouch(Blocks.SHORT_DRY_GRASS);
        dropWhenSilkTouch(Blocks.TALL_DRY_GRASS);
        dropWhenSilkTouch(Blocks.BUSH);
        dropWhenSilkTouch(Blocks.NETHER_SPROUTS);
        dropWhenSilkTouch(Blocks.HANGING_ROOTS);
        dropWhenSilkTouch(Blocks.GLOW_LICHEN);
        dropWhenSilkTouch(Blocks.SMALL_DRIPLEAF);
        dropWhenSilkTouch(Blocks.SEAGRASS);
//        dropWhenSilkTouch(Blocks.TALL_SEAGRASS);
        // if I call this it crashes
    }
}