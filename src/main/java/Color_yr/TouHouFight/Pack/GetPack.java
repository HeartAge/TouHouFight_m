package Color_yr.TouHouFight.Pack;

import net.minecraft.util.PacketByteBuf;

public class GetPack implements IPacket {
    @Override
    public String read(PacketByteBuf buf) {
        byte[] buff = new byte[buf.readableBytes()];
        buf.readBytes(buff);
        buff[0] = 0;
        return new String(buff).substring(1);
    }
}