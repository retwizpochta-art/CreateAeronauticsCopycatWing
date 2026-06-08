package com.mumu17.copycat_wing.mixin.copycats;

import com.copycatsplus.copycats.content.copycat.flat_pane.CopycatFlatPaneBlock;
import dev.ryanhcode.sable.api.block.BlockSubLevelCustomCenterOfMass;
import dev.ryanhcode.sable.api.block.BlockSubLevelLiftProvider;
import dev.ryanhcode.sable.companion.math.JOMLConversion;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;

import static com.mumu17.copycat_wing.Copycat_wing.copycat_wing$getNormal;

@Mixin(CopycatFlatPaneBlock.class)
public class MixinCopycatFlatPaneBlock implements BlockSubLevelLiftProvider, BlockSubLevelCustomCenterOfMass {
    @Override
    public @NotNull Direction sable$getNormal(BlockState blockState) {
        try {
            return copycat_wing$getNormal(blockState);
        } catch (Exception e) {
            return Direction.NORTH;
        }
    }

    @Override
    public Vector3dc getCenterOfMass(final BlockGetter blockGetter, final BlockState state) {
        return JOMLConversion.HALF;
    }
}