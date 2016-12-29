package model;


/**
 * CharacterClass pertains relevant character based information
 * Such ass hit points, spell ability, saving throws
 * @author Mr. Chad Steffl, S02269293
 * @version 1.3, 12/11/16, Final Project, CSC 241
 */
public enum CharacterClass {
    /**
     * FIGHTER has HP = d10, no spells, STR, CON saving throws
     */
    FIGHTER(10, false, true, false, true, false, false, false, "FIGHTER"){ 
        @Override 
        public int getHP(){
            return 10;
        }
        @Override
        public boolean getSpells(){
            return false;
        }

        @Override
        public String getClassName() {
            return "FIGHTER";
        }

        @Override
        public boolean getStatSaveBool(int index){
            
            switch(index){
                case STR : return true;
                case DEX : return false;
                case CON : return true;
                case INT : return false;
                case WIS : return false;
                case CHA : return false;
                default: return false;
            }
        }
    }, 
    /**
     * Paladin has D10 hit points, has spells(limited), WIS and CHA saves
     */
    PALADIN(10, true, false, false, false, false, true, true, "PALADIN"){
        @Override
        public int getHP(){
            return 10;
        }
        @Override
        public boolean getSpells(){
            return true;
        }

        @Override
        public String getClassName() {
            return "PALADIN";
        }
        
        @Override
        public boolean getStatSaveBool(int index){
            
            switch(index){
                case STR : return false;
                case DEX : return false;
                case CON : return false;
                case INT : return false;
                case WIS : return true;
                case CHA : return true;
                default: return false;
            }
        }
    }, 
    /**
     * Wizard has D6 hit points, spells, INT, WIS saving throws
     */
    WIZARD(6, true, false, false, false, true, true, false, "WIZARD"){ // hp 6, has spells, int, wisdom saves
        @Override
        public int getHP(){
            return 6;
        }
        @Override
        public boolean getSpells(){
            return true;
        }

        @Override
        public String getClassName() {
            return "WIZARD";
        }

        @Override
        public boolean getStatSaveBool(int index){
            
            switch(index){
                case STR : return false;
                case DEX : return false;
                case CON : return false;
                case INT : return true;
                case WIS : return true;
                case CHA : return false;
                default: return false;
            }
        }
    }; 


    /** future implementations
     * Barbarian 
     * Bard
     * Cleric
     * Druid
     * //Fighter
     * Monk
     * //Paladin
     * Ranger
     * Rogue
     * Sorcerer
     * //Wizard
    */
     
    /**
     * Return hit points based on class excluding bonuses
     * @return 
     */
    public abstract int getHP();
    /**
     * Return whether class has access to spellcasting or not
     * @return 
     */
    public abstract boolean getSpells();
    /**
     * Return whether class is proficient in a saving throw
     * based on its index
     * @param index
     * @return 
     */
    public abstract boolean getStatSaveBool(int index);
    
    /**
     * Return class's name
     * @return 
     */
    public abstract String getClassName();
    /**
     * Number of total stats
     */
    private final int NUM_STATS = 6;
    /**
     * Class's hit points
     */
    private final int HIT_POINTS;
    /**
     * Boolean whether class has spells
     */
    private final boolean HAS_SPELLS;

    /**
     * Indices for stats
     */
    private static final int STR = 0;
    private static final int DEX = 1;
    private static final int CON = 2;
    private static final int INT = 3;
    private static final int WIS = 4;
    private static final int CHA = 5;
    
    /**
     * Array that holds saving throw proficiencies
     */
    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private final boolean[] STAT_SAVE_BOOL = new boolean[NUM_STATS];
    
    /**
     * This class's name
     */
    private final String CLASS_NAME;
        
    /**
     * 
     * @param HP                hit points of this class
     * @param spells            whether this class has spellcasting ability
     * @param strSaveBool       Proficiency in strength saving throw
     * @param dexSaveBool       Proficiency in dexterty saving throw
     * @param conSaveBool       Proficiency in constitution saving throw
     * @param intSaveBool       Proficiency in intelligence saving throw
     * @param wisSaveBool       Proficiency in wisdom saving throw
     * @param chaSaveBool       Proficiency in charisma saving throw
     * @param className         Class name
     */   
    CharacterClass(int HP, boolean spells, boolean strSaveBool, 
            boolean dexSaveBool, boolean conSaveBool, boolean intSaveBool,
            boolean wisSaveBool, boolean chaSaveBool, String className){
        
        this.HIT_POINTS = HP;
        this.HAS_SPELLS = spells;
        STAT_SAVE_BOOL[STR] = strSaveBool;
        STAT_SAVE_BOOL[DEX] = dexSaveBool;
        STAT_SAVE_BOOL[CON] = conSaveBool;
        STAT_SAVE_BOOL[INT] = intSaveBool;
        STAT_SAVE_BOOL[WIS] = wisSaveBool;
        STAT_SAVE_BOOL[CHA] = chaSaveBool;
        this.CLASS_NAME = className;
    }
}
