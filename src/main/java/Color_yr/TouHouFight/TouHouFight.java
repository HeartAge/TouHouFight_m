package Color_yr.TouHouFight;

import Color_yr.TouHouFight.Key.Key;
import Color_yr.TouHouFight.Pack.GetPack;
import Color_yr.TouHouFight.Pack.IPacket;
import com.github.gamepiaynmo.custommodel.client.CustomModelClient;
import com.github.gamepiaynmo.custommodel.server.CustomModel;
import com.github.gamepiaynmo.custommodel.server.ModelLoadInfo;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.client.font.TextRenderer;
import net.minecraft.client.gui.hud.InGameHud;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TouHouFight implements ModInitializer {
    public static final String modID = "touhoufight";
    public static final Identifier ID = new Identifier("thf", "channel");
    public static final Logger log = LogManager.getLogger();

    private static int num;
    public static boolean isPlay;

    public static <T extends IPacket> void registerPacket(Identifier id, Class<T> packetClass) {
        ClientSidePacketRegistry.INSTANCE.register(id, (context, buffer) -> {
            try {
                IPacket packet = packetClass.newInstance();
                String temp = packet.read(buffer);
                context.getTaskQueue().execute(() -> {
                    onClicentPacket(temp);
                });
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }

    public static void onServerQuit() {
        if (MinecraftClient.getInstance().player != null)
            CustomModelClient.manager.clearModel(MinecraftClient.getInstance().player.getGameProfile());
        isPlay = false;
    }

    public static void update() {
        InGameHud hud = MinecraftClient.getInstance().inGameHud;
        TextRenderer textRenderer = hud.getFontRenderer();
        textRenderer.drawWithShadow("test", 50, 50, 0xffffff);
    }

    public static void onClicentPacket(final String message) {
        if (message.equals("start")) {
            isPlay = true;
            update();
        } else if (message.startsWith("stop")) {
            onServerQuit();
        } else if (message.startsWith("[mode]")) {
            String mo = message.replace("[mode]", "");
            ModelLoadInfo info = CustomModel.manager.models.get(mo);
            if (info == null) {
                log.info(mo + " is null");
                return;
            }
            CustomModelClient.manager.selectModel(MinecraftClient.getInstance().player.getGameProfile(), mo);
        }
    }

    @Override
    public void onInitialize() {
        registerPacket(ID, GetPack.class);
        new Key();
        ClientTickCallback.EVENT.register(e -> {
            if (!isPlay)
                return;
            if (Key.Ex1.isPressed()) {
                if (num != 1)
                    send("ex1");
                num = 1;
            } else if (Key.Ex2.isPressed()) {
                if (num != 2)
                    send("ex2");
                num = 2;
            } else if (Key.Ex3.isPressed()) {
                if (num != 3)
                    send("ex3");
                num = 3;
            } else if (Key.Kill.isPressed()) {
                if (num != 4)
                    send("kill");
                num = 4;
            } else if (Key.Shot.isPressed()) {
                if (num != 5)
                    send("shot");
                num = 5;
            } else if (num == 5 && !Key.Shot.isPressed()) {
                send("unshot");
                num = 0;
            } else {
                num = 0;
            }
        });
    }

    public void send(String message) {
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
        passedData.writeString(message);
        ClientSidePacketRegistry.INSTANCE.sendToServer(ID, passedData);
    }
}
