package net.superfastscyphozoa.sublunary.data;

import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricBlockLootTableProvider;
import net.superfastscyphozoa.sublunary.registry.RegisterBlocks;

public class SublunaryLootTableProvider extends FabricBlockLootTableProvider {
    public SublunaryLootTableProvider(FabricDataOutput dataOutput) {
        super(dataOutput);
    }

    @Override
    public void generate() {
        addDrop(RegisterBlocks.LAVENDER);
    }
}
