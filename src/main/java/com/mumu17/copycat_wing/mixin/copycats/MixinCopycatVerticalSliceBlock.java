package com.mumu17.copycat_wing.mixin.copycats;

import com.copycatsplus.copycats.content.copycat.vertical_slice.CopycatVerticalSliceBlock;
import dev.ryanhcode.sable.api.block.BlockSubLevelCustomCenterOfMass;
import dev.ryanhcode.sable.api.block.BlockSubLevelLiftProvider;
import dev.ryanhcode.sable.companion.math.JOMLConversion;
import net.minecraft.core.Direction;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jetbrains.annotations.NotNull;
import org.joml.Vector3dc;
import org.spongepowered.asm.mixin.Mixin;

@Mixin(CopycatVerticalSliceBlock.class)
public class MixinCopycatVerticalSliceBlock implements BlockSubLevelLiftProvider, BlockSubLevelCustomCenterOfMass {
    @Override
    public @NotNull Direction sable$getNormal(BlockState blockState) {
        try {
            return blockState.getValue(BlockStateProperties.FACING).getOpposite();
        } catch (Exception e) {
            return Direction.NORTH;
        }
    }

    @Override
    public Vector3dc getCenterOfMass(final BlockGetter blockGetter, final BlockState state) {
        return JOMLConversion.HALF;
    }
}