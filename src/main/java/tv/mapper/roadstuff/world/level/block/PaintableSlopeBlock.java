package tv.mapper.roadstuff.world.level.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Mirror;
import net.minecraft.world.level.block.Rotation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import tv.mapper.mapperbase.world.level.block.SlopeBlock;
import tv.mapper.mapperbase.world.level.block.ToolTypes;

import static tv.mapper.roadstuff.util.BlockHelper.getUnpaintedBlock;


public class PaintableSlopeBlock extends SlopeBlock implements PaintSystem {

    public PaintableSlopeBlock(Properties properties, ToolTypes tool) {
        super(properties, tool);

        this.registerDefaultState(this.stateDefinition.any().setValue(LAYERS, 1).setValue(DIRECTION, Direction.NORTH).setValue(WATERLOGGED, Boolean.FALSE));
    }


    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        builder.add(LAYERS, DIRECTION, WATERLOGGED);
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter worldIn, BlockPos pos, BlockState state) {
        return new ItemStack(getUnpaintedBlock(state));
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