package tv.mapper.roadstuff.world.level.block.state.properties;

import com.google.common.collect.Maps;
import net.minecraft.network.chat.Component;
import net.minecraft.util.StringRepresentable;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.world.item.DyeColor;
import net.minecraft.world.item.DyeItem;

import java.util.Map;

public enum EnumPaintColor implements StringRepresentable {
    WHITE(0, "white"),
    YELLOW(1, "yellow"),
    BLACK(2, "black");
    // ORANGE(2, "orange")
    // MAGENTA(3, "magenta"),
    // LIGHT_BLUE(4, "light_blue"),
    // LIME(5, "lime"),
    // PINK(6, "pink"),
    // GRAY(7, "gray"),
    // LIGHT_GRAY(8, "light_gray"),
    // CYAN(9, "cyan"),
    // PURPLE(10, "purple"),
    // BLUE(11, "blue"),
    // BROWN(12, "brown"),
    // GREEN(13, "green"),
    // RED(14, "red"),
    // ^ causes too many blockstates


    private final int id;
    private final String name;


    private EnumPaintColor(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getSerializedName() {
        return this.name;
    }

    public String getNameTranslated() {
        return Component.translatable("roadstuff.message.paint.color." + this.name).getString();
    }


    public int getId() {
        return this.id;
    }

    public static EnumPaintColor getColorByID(int id) {
        for (EnumPaintColor color : values()) {
            if (color.getId() == id)
                return color;
        }
        return null;
    }
}