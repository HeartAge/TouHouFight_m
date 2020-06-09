package Color_yr.TouHouFight.Pack;

import Color_yr.TouHouFight.Hud.HudShow;
import Color_yr.TouHouFight.TouHouFight;
import com.github.gamepiaynmo.custommodel.client.CustomModelClient;
import com.github.gamepiaynmo.custommodel.server.CustomModel;
import com.github.gamepiaynmo.custommodel.server.ModelLoadInfo;
import net.minecraft.client.MinecraftClient;
import net.minecraft.util.PacketByteBuf;

public class GetPack {
    public static void read(PacketByteBuf buf) {
        byte[] buff = new byte[buf.readableBytes()];
        buf.readBytes(buff);
        buff[0] = 0;
        String data = new String(buff).substring(1);
        if (data.equals("start")) {
            TouHouFight.isPlay = true;
        } else if (data.startsWith("stop")) {
            TouHouFight.onServerQuit();
        } else if (data.startsWith("[mode]")) {
            String mo = data.replace("[mode]", "");
            ModelLoadInfo info = CustomModel.manager.models.get(mo);
            if (info == null) {
                TouHouFight.log.info(mo + " is null");
                return;
            }
            CustomModelClient.manager.selectModel(MinecraftClient.getInstance().player.getGameProfile(), mo);
        } else if (data.startsWith("[state]")) {
            String mo = data.replace("[state]", "");
            int a;
            switch (mo.substring(0, 1)) {
                case "0":
                    a = Integer.parseInt(mo.substring(2));
                    HudShow.ShowSave.setHealth(a);
                    break;
                case "1":
                    a = Integer.parseInt(mo.substring(2));
                    HudShow.ShowSave.setAmmunition(a);
                    break;
                case "2":
                    a = Integer.parseInt(mo.substring(2));
                    HudShow.ShowSave.setNowAmmunition(a);
                    break;
                case "3":
                    a = Integer.parseInt(mo.substring(2));
                    HudShow.ShowSave.setSkill1CountDown(a);
                    break;
                case "4":
                    a = Integer.parseInt(mo.substring(2));
                    HudShow.ShowSave.setSkill2CountDown(a);
                    break;
                case "5":
                    a = Integer.parseInt(mo.substring(2));
                    HudShow.ShowSave.setSkill3CountDown(a);
                    break;
                case "6":
                    a = Integer.parseInt(mo.substring(2));
                    HudShow.ShowSave.setSkillKillCountDown(a);
                    break;
            }
        }
    }
}