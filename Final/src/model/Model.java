package model;



/**
 *  Model controls model data for FinalView and FinalXMLController
 * @author Mr. Chad Steffl, S02269293
 * @version 1.3, 12/11/16, Final Project, CSC 241
 */
public class Model {
    /**
     * Total number of stats(STR, DEX...) used
     */
    private static final int NUM_STATS = 6;
    
    /**
     * Minimum proficiency bonus is always +2 or higher
     */
    private static final int MIN_PROF_BONUS = 2;

    /**
     * Holds base stats without bonuses. Initial value is always 10 as that is
     * the default per Dungeons and Dragons 5th Edition rule set.
     */
    private final int[] BASE_STAT_ARRAY = {10, 10, 10, 10, 10, 10};
   
    /**
     * Array to hold stat(STR, DEX...) bonus(modifier).
     * 
     */
    private final int[] STAT_MOD = new int[NUM_STATS];
    
    /**
     * Hold stat values which will be used for GUI stat rolled Label
     */
    private final int[] STAT_LABEL = new int[NUM_STATS];
    
     /**
     * array of integers for racial bonus to stats(STR, DEX...) which is primarily 
     * used for the GUI Label
     */
    private final int[] STAT_RACE_LABEL = new int[NUM_STATS];
    
    /**
     * Array to hold total of stats (STR, DEX ...) including bonuses
     */
    private final int[] STAT_TOTAL_LABEL = new int[NUM_STATS];
    
    
    
    /**
     * Holds proficiency bonus which is based on level.
     */
    private int profBonus;
    
    /**
     * Holds character level
     */
    private int level;
    
    /**
     * Holds character hit points
     */
    private int hitPoints;
    
    /**
     * Calculate proficiency bonus of character which is solely based on level
     * (lvl 1-4 = +2, lvl 5-8 = +3, lvl 9-12 = +4, lvl 13-16 = +5,
     * lvl 17-20 = +6)
     * @param level
     * @return 
     */
    public int getProfBonus(int level){
//        System.out.println("level: " + level); //FOR DEBUGGING
        if (level != 0){
            double levelDouble = (double) level;
            profBonus = (int) ( Math.ceil(levelDouble / 4) + 1 );
        }
        else{
            profBonus = MIN_PROF_BONUS;
        }   
        return profBonus;
    }
    
    /**
     * Set character level
     * @param level 
     */
    public void setLevel(int level){
        this.level = level;
    }
    
    /**
     * Get character level
     * @return 
     */
    public int getLevel(){
        return level;
    }
    
    /**
    * Setter for base stat scores excluding any bonuses
    * @param statScore
    * @param index 
    */
    public void setStatScore(int statScore, int index){
        BASE_STAT_ARRAY[index] = statScore;
    }
    
    /**
     * Getter for base stat scores excluding any bonuses
     * @param index
     * @return 
     */
    public int getStatScore(int index){
        return BASE_STAT_ARRAY[index];
    }
    
    /**
     * Returns array of the stats randomly rolled (or manually assigned)
     * @return 
     */
    public int[] getRolledStats(){
        return STAT_LABEL;
    }
    
    /**
     * Setter for stat score array which will output to GUI stat scores
     * without bonuses.
     * @param stat
     * @param index 
     */
    public void setStatLabel(int stat, int index){
        STAT_LABEL[index] = stat;
    }
    
    /**
     * Getter for stat score array which will output to GUI stat scores
     * without bonuses.
     * @param index
     * @return 
     */
    public int getStatLabel(int index){
        return STAT_LABEL[index];
    }
    
    /**
     * Getter for racial stat bonus (primarily for GUI Labels)
     * @param index
     * @return 
     */
    public int getStatRaceLabel(int index){
        return STAT_RACE_LABEL[index];
    }
    
    /**
     * Setter for racial stat bonus (primarily for GUI Labels)
     * @param score
     * @param index 
     */
    public void setStatRaceLabel(int score, int index){
        STAT_RACE_LABEL[index] = score;
    }
    
    /**
     * Getter for total stat bonus (primarily for GUI Labels)
     * @param index
     * @return 
     */
    public int getStatTotalLabel(int index){
        return STAT_TOTAL_LABEL[index];
    }
    
    /**
     * Setter for total stat bonus (primarily for GUI Labels)
     * @param score
     * @param index 
     */
    public void setStatTotalLabel(int score, int index){
        STAT_TOTAL_LABEL[index] = score;
    }
    
    /**
     * Getter for a stat's modifier(bonus)
     * Bonus is (SCORE - 10) /2 rounded down. I.E. SCORE = 12 is +1 bonus
     * @param index
     * @return 
     */
    public int getStatMod(int index){
        return STAT_MOD[index];
    }
    
    /**
     * Setter for stat's modifier(bonus)
     * @param score
     * @param index 
     */
    public void setStatMod(int score, int index){
        STAT_MOD[index] = score;
    }
    
    /**
     * Total saving throw including all modifiers and bonuses.
     * In this case total saving throw = stat modifier + proficiency bonus
     * @param index
     * @return 
     */
    public int getTrainedStatThrow(int index){
        return getProfBonus(level) + getStatMod(index);
    }
    
    /**
     * Setter for character's base hit points excluding bonuses
     * @param hitPoints
     */
    public void setHP(int hitPoints) {
        this.hitPoints = hitPoints;
    }
    
    /**
     * Getter for character's base hit points excluding bonuses
     * @return
     */
    public int getHP(){
        return hitPoints;
    } 
}
