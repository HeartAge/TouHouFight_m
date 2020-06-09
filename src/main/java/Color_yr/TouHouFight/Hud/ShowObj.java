package Color_yr.TouHouFight.Hud;

public class ShowObj {
    private int health; //0
    private int ammunition; //1
    private int nowAmmunition; //2
    private int skill1CountDown; //3
    private int skill2CountDown; //4
    private int skill3CountDown; //5
    private int skillKillCountDown; //6

    public int getAmmunition() {
        return ammunition;
    }

    public int getHealth() {
        return health;
    }

    public int getNowAmmunition() {
        return nowAmmunition;
    }

    public int getSkill1CountDown() {
        return skill1CountDown;
    }

    public int getSkill2CountDown() {
        return skill2CountDown;
    }

    public int getSkill3CountDown() {
        return skill3CountDown;
    }
    public int getSkillKillCountDown() {
        return skillKillCountDown;
    }

    public void setAmmunition(int ammunition) {
        this.ammunition = ammunition;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public void setNowAmmunition(int nowAmmunition) {
        this.nowAmmunition = nowAmmunition;
    }

    public void setSkill1CountDown(int skill1CountDown) {
        this.skill1CountDown = skill1CountDown;
    }

    public void setSkill2CountDown(int skill2CountDown) {
        this.skill2CountDown = skill2CountDown;
    }

    public void setSkill3CountDown(int skill3CountDown) {
        this.skill3CountDown = skill3CountDown;
    }

    public void setSkillKillCountDown(int skillKillCountDown) {
        this.skillKillCountDown = skillKillCountDown;
    }
}
