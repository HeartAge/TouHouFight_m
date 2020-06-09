package Color_yr.TouHouFight.Key;

import Color_yr.TouHouFight.Pack.SendPack;
import Color_yr.TouHouFight.TouHouFight;

public class KeyCheck {
    private static int num;
    public static void Do()
    {
        if (!TouHouFight.isPlay)
            return;
        if (Key.Ex1.isPressed()) {
            if (num != 1)
                SendPack.send("ex1");
            num = 1;
        } else if (Key.Ex2.isPressed()) {
            if (num != 2)
                SendPack.send("ex2");
            num = 2;
        } else if (Key.Ex3.isPressed()) {
            if (num != 3)
                SendPack.send("ex3");
            num = 3;
        } else if (Key.Kill.isPressed()) {
            if (num != 4)
                SendPack.send("kill");
            num = 4;
        } else if (Key.Shot.isPressed()) {
            if (num != 5)
                SendPack.send("shot");
            num = 5;
        } else if (num == 5 && !Key.Shot.isPressed()) {
            SendPack.send("unshot");
            num = 0;
        } else {
            num = 0;
        }
    }
}
