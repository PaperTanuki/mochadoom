package net.sourceforge.mochadoom.gamelogic;

/**
 * Created by Nicolas on 14-12-2016.
 */
public class MonsterFactory {

    public static final int NORMAL = 0;
    public static final int VAMPIRE = 1;
    public static final int GHOUL = 2;
    public static final int WEREWOLF = 3;
    public static final int HYBRID= 4;


    public static IMonster createMonster(int monsterType,Actions actions){
        switch (monsterType){
            case NORMAL:
                return new monster_t(actions);
            case VAMPIRE:
                return  new monster_t(actions);
            case GHOUL:
                return new monster_t(actions);
            case WEREWOLF:
                return new monster_t(actions);
            case HYBRID:
                return new monster_t(actions);
            default:
                return new monster_t(actions);

        }


    }


}
