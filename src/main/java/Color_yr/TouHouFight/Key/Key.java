package Color_yr.TouHouFight.Key;

import Color_yr.TouHouFight.TouHouFight;
import net.fabricmc.fabric.api.client.keybinding.FabricKeyBinding;
import net.fabricmc.fabric.api.client.keybinding.KeyBindingRegistry;
import net.minecraft.client.util.InputUtil;
import net.minecraft.util.Identifier;
import org.lwjgl.glfw.GLFW;

public class Key {
    public static FabricKeyBinding Ex1;
    public static FabricKeyBinding Ex2;
    public static FabricKeyBinding Ex3;
    public static FabricKeyBinding Kill;
    public static FabricKeyBinding Shot;

    public void init() {
        KeyBindingRegistry.INSTANCE.addCategory(TouHouFight.modID);
        Ex1 = FabricKeyBinding.Builder.create(
                new Identifier(TouHouFight.modID, "ex1"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_1,
                TouHouFight.modID
        ).build();
        Ex2 = FabricKeyBinding.Builder.create(
                new Identifier(TouHouFight.modID, "ex2"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_2,
                TouHouFight.modID
        ).build();
        Ex3 = FabricKeyBinding.Builder.create(
                new Identifier(TouHouFight.modID, "ex3"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_3,
                TouHouFight.modID
        ).build();
        Kill = FabricKeyBinding.Builder.create(
                new Identifier(TouHouFight.modID, "kill"),
                InputUtil.Type.KEYSYM,
                GLFW.GLFW_KEY_G,
                TouHouFight.modID
        ).build();
        Shot = FabricKeyBinding.Builder.create(
                new Identifier(TouHouFight.modID, "shot"),
                InputUtil.Type.MOUSE,
                GLFW.GLFW_MOUSE_BUTTON_LEFT,
                TouHouFight.modID
        ).build();
        KeyBindingRegistry.INSTANCE.register(Ex1);
        KeyBindingRegistry.INSTANCE.register(Ex2);
        KeyBindingRegistry.INSTANCE.register(Ex3);
        KeyBindingRegistry.INSTANCE.register(Kill);
        KeyBindingRegistry.INSTANCE.register(Shot);
    }
}
