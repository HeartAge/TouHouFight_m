package Color_yr.TouHouFight.Hud;

import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;

public class HudShow {
    public static ShowObj ShowSave = new ShowObj();
    public static void Show() {
        InGameHud hud = MinecraftClient.getInstance().inGameHud;
        TextRenderer textRenderer = hud.getFontRenderer();
        textRenderer.drawWithShadow("test", 50, 50, 0xffffff);
    }
}
