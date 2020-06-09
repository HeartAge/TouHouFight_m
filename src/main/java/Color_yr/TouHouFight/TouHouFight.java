package Color_yr.TouHouFight;

import Color_yr.TouHouFight.Key.Key;
import Color_yr.TouHouFight.Key.KeyCheck;
import Color_yr.TouHouFight.Pack.GetPack;
import com.github.gamepiaynmo.custommodel.client.CustomModelClient;
import com.github.gamepiaynmo.custommodel.server.CustomModel;
import com.github.gamepiaynmo.custommodel.server.ModelLoadInfo;
import io.netty.buffer.Unpooled;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.event.client.ClientTickCallback;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.Identifier;
import net.minecraft.util.PacketByteBuf;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class TouHouFight implements ModInitializer {
    public static final String modID = "touhoufight";
    public static final Identifier ID = new Identifier("thf", "channel");
    public static final Logger log = LogManager.getLogger();

    public static boolean isPlay;

    public static void registerPacket(Identifier id) {
        ClientSidePacketRegistry.INSTANCE.register(id, (context, buffer) -> {
            try {
                context.getTaskQueue().execute(() -> {
                    GetPack.read(buffer);
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

    @Override
    public void onInitialize() {
        registerPacket(ID);
        new Key().init();
        ClientTickCallback.EVENT.register(e -> {
            KeyCheck.Do();
        });
    }
}
