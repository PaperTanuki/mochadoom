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

    static boolean debug = false;


    public static mobj_t createMonster(int monsterType,Actions actions){
        mobj_t monster;

        switch (monsterType){

            case NORMAL:
                if(debug)System.out.println("Es normal!");
                monster=new monster_t(actions);
                break;
            case VAMPIRE:
                if(debug)System.out.println("Es Vampiro!");
                monster=new Vampire(actions);
                break;
            case GHOUL:
                if(debug)System.out.println("Es Ghoul!");
                monster= new Ghoul(actions);
                break;
            case WEREWOLF:
                if(debug)System.out.println("Es WereWolf!");
                monster= new werewolf_t(actions);
                break;
            case HYBRID:
                if(debug)System.out.println("Es hybrido!");
                monster= new monster_t(actions);
                break;
            default:
                monster= new monster_t(actions);
                break;

        }
        return monster;


    }


}
