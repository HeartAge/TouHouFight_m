package Color_yr.TouHouFight.Pack;

import net.minecraft.util.PacketByteBuf;

public interface IPacket {
    String read(PacketByteBuf packetByteBuf);
}