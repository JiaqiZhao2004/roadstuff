package tv.mapper.roadstuff.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import tv.mapper.mapperbase.world.level.block.CustomBlock;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

import javax.annotation.Nullable;

import static tv.mapper.roadstuff.util.BlockHelper.getUnpaintedBlock;

/*
 *  PaintableBlock
 *
 *  This block can be painted using the paintbrush.
 *
 */
public class PaintableRoadBlock extends CustomBlock implements PaintSystem {

    public PaintableRoadBlock(Properties properties, ToolTypes tool) {
        super(properties, tool);

        this.registerDefaultState(this.defaultBlockState().setValue(DIRECTION, Direction.NORTH));

    }


    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(getUnpaintedBlock(state));
    }

    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(DIRECTION);
    }

    @Nullable
    public BlockState getStateForPlacement(BlockPlaceContext context) {
        return this.defaultBlockState().setValue(DIRECTION, context.getHorizontalDirection());
    }


    @Override
    public BlockState rotate(BlockState pState, Rotation pRotation) {
        return pState.setValue(DIRECTION, pRotation.rotate(pState.getValue(DIRECTION)));
    }

    @SuppressWarnings("deprecation")
    @Override
    public BlockState mirror(BlockState pState, Mirror pMirror) {
        return pState.rotate(pMirror.getRotation(pState.getValue(DIRECTION)));
    }

}