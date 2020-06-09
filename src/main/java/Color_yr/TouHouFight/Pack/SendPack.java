package Color_yr.TouHouFight.Pack;

import Color_yr.TouHouFight.TouHouFight;
import io.netty.buffer.Unpooled;
import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;
import net.minecraft.util.PacketByteBuf;

public class SendPack {
    public static void send(String message) {
        PacketByteBuf passedData = new PacketByteBuf(Unpooled.buffer());
        passedData.writeString(message);
        ClientSidePacketRegistry.INSTANCE.sendToServer(TouHouFight.ID, passedData);
    }
}
