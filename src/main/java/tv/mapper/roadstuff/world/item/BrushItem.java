package tv.mapper.roadstuff.world.item;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.minecraft.ChatFormatting;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.network.chat.Component;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.util.Mth;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionResultHolder;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.TooltipFlag;
import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.Property;
import tv.mapper.mapperbase.world.level.block.SlopeBlock;
import tv.mapper.roadstuff.util.ModConstants;
import tv.mapper.roadstuff.world.level.block.PaintSystem;
import tv.mapper.roadstuff.world.level.block.PaintableRoadBlock;
import tv.mapper.roadstuff.world.level.block.PaintableSlopeBlock;
import tv.mapper.roadstuff.world.level.block.state.properties.EnumPaintColor;

import static tv.mapper.roadstuff.util.BlockHelper.getUnpaintedBlock;
import static tv.mapper.roadstuff.world.level.block.RSBlockRegistry.*;

public class BrushItem extends Item {
    private int paintQuantity;

    public BrushItem(Properties properties, int paintQuantity) {
        super(properties);
        this.paintQuantity = paintQuantity;
    }

    @Override
    public boolean canAttackBlock(BlockState state, Level worldIn, BlockPos pos, Player player) {
        if (player.isCreative() && state.getBlock() instanceof PaintableRoadBlock)
            return false;
        return true;
    }

    public boolean hurtEnemy(ItemStack stack, LivingEntity target, LivingEntity attacker) {
        CompoundTag nbt = checkNBT(stack);

        if (nbt.getInt("paint") > 0) {
            target.addEffect(new MobEffectInstance(MobEffects.BLINDNESS, 50));
            nbt.putInt("paint", nbt.getInt("paint") - 1);
            stack.setTag(nbt);
        }
        return true;
    }

    @Override
    public InteractionResultHolder<ItemStack> use(Level world, Player player, InteractionHand hand) {
        ItemStack stack = player.getItemInHand(hand);

        CompoundTag nbt = checkNBT(stack);
        stack.setTag(nbt);

        if (world.isClientSide) {
            if (ModConstants.ALTERNATE_BRUSH) {
                if (player.isShiftKeyDown())
                    BrushItemClient.displayBrushGui(nbt.getInt("pattern"), nbt.getInt("paint"), nbt.getInt("color"), nbt.getFloat("scroll"), nbt.getIntArray("favs"));
            } else {
                if (!player.isShiftKeyDown())
                    BrushItemClient.displayBrushGui(nbt.getInt("pattern"), nbt.getInt("paint"), nbt.getInt("color"), nbt.getFloat("scroll"), nbt.getIntArray("favs"));
            }
        }

        return new InteractionResultHolder<>(InteractionResult.SUCCESS, stack);
    }

    public InteractionResult useOn(UseOnContext context) {
        CompoundTag nbt = checkNBT(context.getItemInHand());
        context.getItemInHand().setTag(nbt);

        if (ModConstants.ALTERNATE_BRUSH) {
            ItemStack heldItem = context.getItemInHand();
            Player player = context.getPlayer();

            if (player.isShiftKeyDown()) {
                if (context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof PaintSystem)
                    return copyPattern(context.getLevel().getBlockState(context.getClickedPos()), context.getLevel(), nbt, context.getPlayer());
                else if (context.getLevel().isClientSide)
                    BrushItemClient.displayBrushGui(nbt.getInt("pattern"), nbt.getInt("paint"), nbt.getInt("color"), nbt.getFloat("scroll"), nbt.getIntArray("favs"));
            } else
                return paintLine(context.getClickedFace(), context.getLevel().getBlockState(context.getClickedPos()), context.getLevel(), context.getClickedPos(), player, heldItem);
        } else {
            if (context.getPlayer().isShiftKeyDown()) {
                if (context.getLevel().getBlockState(context.getClickedPos()).getBlock() instanceof PaintSystem) {
                    return copyPattern(context.getLevel().getBlockState(context.getClickedPos()), context.getLevel(), nbt, context.getPlayer());
                }
            }
        }
        return InteractionResult.PASS;

    }

    @Override
    public void appendHoverText(ItemStack stack, Level player, List<Component> list, TooltipFlag flag) {
        super.appendHoverText(stack, player, list, flag);
        if (stack.hasTag()) {
            String color = EnumPaintColor.getColorByID(stack.getTag().getInt("color")).getNameTranslated();

            if (stack.getTag().getInt("paint") == 0)
                color = "X";
            list.add(Component.literal(Component.translatable("roadstuff.message.brush.gui.pattern").getString() + stack.getTag().getInt("pattern") + "; " + Component.translatable("roadstuff.message.brush.gui.color").getString() + color));
            list.add(Component.literal(Component.translatable("roadstuff.message.brush.gui.paint").getString() + stack.getTag().getInt("paint")));
        }
    }

    @Override
    public boolean isBarVisible(ItemStack stack) {
        if (checkNBT(stack).getInt("paint") > 0)
            return true;
        else
            return false;
    }

    @Override
    public int getBarWidth(ItemStack stack) {
        return (checkNBT(stack).getInt("paint") * 13) / this.getMaxPaint();
    }

    @Override
    public int getBarColor(ItemStack pStack) {
        float f = Math.max(0.0F, (float) checkNBT(pStack).getInt("paint") / (float) this.getMaxPaint());
        return Mth.hsvToRgb(f / 3.0F, 1.0F, 1.0F);
    }

    public static CompoundTag checkNBT(ItemStack stack) {
        CompoundTag nbt;

        if (stack.hasTag()) {
            nbt = stack.getTag();
        } else {
            int[] favorites = {0, 0, 0, 0, 0, 0, 0, 0};

            nbt = new CompoundTag();
            nbt.putInt("paint", 0);
            nbt.putInt("pattern", 0);
            nbt.putInt("color", EnumPaintColor.WHITE.getId());
            nbt.putFloat("scroll", 0.0f);
            nbt.putIntArray("favs", favorites);
        }
        return nbt;
    }

    public static InteractionResult paintLine(Direction face, BlockState oldState, Level world, BlockPos pos, Player player, ItemStack stack) {
        Block newBlock;

        CompoundTag nbt = checkNBT(stack);
        stack.setTag(nbt);

        int pattern = nbt.getInt("pattern");
        int color = nbt.getInt("color");

        if (!world.isClientSide && face == Direction.UP) {
            if (pattern == 0) {
                return removeLine(world, pos, player);
            }

            Block oldBlock = oldState.getBlock();
            if (oldState.getBlock() instanceof PaintSystem) {
                String newId = getUnpaintedBlock(oldState).getDescriptionId() + "_" + EnumPaintColor.getColorByID(color).getSerializedName() + "_line_" + pattern;
                newId = newId.replaceAll("^block.roadstuff.", "");
                newBlock = nameToPaintableBlockMap.get(newId).get();  // RoadStuff.asphaltSlopeMap.getBlockFor(color, pattern)
                oldState.getBlock().getDescriptionId();

                BlockState newState = newBlock.defaultBlockState();
                for (Property p : oldState.getProperties()) {
                    newState = newState.setValue(p, oldState.getValue(p));
                }

                Direction newDirection = Direction.fromYRot(oldState.getValue(PaintSystem.DIRECTION).toYRot() + (oldState.getBlock() == newBlock ? 90 : -90));

                if (oldState.getBlock() == newBlock) {
                    newState = newState.setValue(PaintSystem.DIRECTION, newDirection);
                    world.setBlockAndUpdate(pos, newState);
                } else {
                    if (nbt.getInt("paint") > 0) {
                        if (newBlock instanceof PaintableSlopeBlock) {
                            if (player.getMainHandItem() == stack)
                                world.setBlockAndUpdate(pos, newState.setValue(PaintSystem.DIRECTION, player.getDirection()));
                            else
                                world.setBlockAndUpdate(pos, newState.setValue(PaintSystem.DIRECTION, player.getDirection().getOpposite()));
                        } else
                            world.setBlockAndUpdate(pos, newState);
                        if (!player.isCreative())
                            nbt.putInt("paint", nbt.getInt("paint") - 1);
                        world.playSound(null, pos, SoundEvents.SLIME_BLOCK_PLACE, SoundSource.BLOCKS, .8F, 2.0F);
                    }
                }
            }
        }

        stack.setTag(nbt);
        return InteractionResult.SUCCESS;
    }

    public static InteractionResult removeLine(Level world, BlockPos pos, Player player) {
        BlockState state = world.getBlockState(pos);

        if (state.getBlock() instanceof SlopeBlock && state.getBlock() != getUnpaintedBlock(state)) {
            BlockState newBlock = getUnpaintedBlock(state).defaultBlockState();

            if (!world.isClientSide) {
                world.setBlockAndUpdate(pos, newBlock.setValue(SlopeBlock.WATERLOGGED, state.getValue(SlopeBlock.WATERLOGGED)));
                world.playSound(null, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.5F);
            }
        } else if (state.getBlock() instanceof PaintSystem && !(state.getBlock() instanceof SlopeBlock) && state.getBlock() != getUnpaintedBlock(state)) {
            BlockState newBlock = getUnpaintedBlock(state).defaultBlockState();

            if (!world.isClientSide) {
                world.setBlockAndUpdate(pos, newBlock);
                world.playSound(null, pos, SoundEvents.COMPOSTER_FILL, SoundSource.BLOCKS, 1.0F, 1.5F);
            }
        }
        return InteractionResult.SUCCESS;
    }

    private InteractionResult copyPattern(BlockState state, Level world, CompoundTag nbt, Player player) {
        Block block = state.getBlock();

        if (!world.isClientSide) {

            if (block instanceof PaintableRoadBlock) {
                Pattern p = Pattern.compile("\\d+$");
                Matcher m = p.matcher(block.getDescriptionId());
                if (m.find()) {
                    int num = Integer.parseInt(m.group());
                    nbt.putInt("pattern", num);
                    player.displayClientMessage(Component.literal(ChatFormatting.WHITE + "Copied pattern " + num + " into brush"), true);
                }
                return InteractionResult.SUCCESS;
            }
        }

        return InteractionResult.PASS;
    }


    public int getMaxPaint() {
        return this.paintQuantity;
    }

}