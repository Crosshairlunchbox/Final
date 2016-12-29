package model;


/**
 * Races pertains to relevant racial traits for characters such as
 * racial stat bonuses, size, and base movement speed
 * @author Mr. Chad Steffl, S02269293
 * @version 1.3, 12/11/16, Final Project, CSC 241
 */
public enum Races {
    
    /**
     * Human is medium size, has +1 to all stats, and 30' base move speed
     */
    HUMAN("MEDIUM", 1, 1, 1, 1, 1, 1, 30, "HUMAN") {
        
        @Override
        public String getSize() {
            return "MEDIUM";
        }
        
        @Override
        public int getRacialStatBonus(int index){
            
            switch(index){
                case STR : return 1;
                
                case DEX : return 1;
                
                case CON : return 1;
                
                case INT : return 1;
                
                case WIS : return 1;
                
                case CHA : return 1;
                
                default : return 0;
            }
        }

        @Override
        public int getMoveSpeed() {
            return 30;
        }

        @Override
        public String getRaceName() {
            return "HUMAN";
        }
    },
    /**
     * HIGH ELF is medium sized, has +2 to DEX and INT and has 30' base movement
     * speed
     */
    HIGHELF("MEDIUM", 0, 2, 0, 1, 0, 0, 30, "HIGHELF") {
        @Override
        public String getSize() {
            return "MEDIUM";
        }
        
        @Override
        public int getRacialStatBonus(int index){
            
            switch(index){
                case STR : return 0;
                
                case DEX : return 2;
                
                case CON : return 0;
                
                case INT : return 1;
                
                case WIS : return 0;
                
                case CHA : return 0;
                
                default : return 0;
            }
        }

        @Override
        public int getMoveSpeed() {
            return 30;
        }

        @Override
        public String getRaceName() {
            return "HIGHELF";
        } 
    },
    /**
     * WOODF ELF is medium sized, has +2 DEX and +1 WIS and 35' base movement
     * speed
     */
    WOODELF("MEDIUM", 0, 2, 0, 0, 1, 0, 35, "WOODELF") {
        @Override
        public String getSize() {
            return "MEDIUM";
        }

        @Override
        public int getRacialStatBonus(int index){
            
            switch(index){
                case STR : return 0;
                
                case DEX : return 2;
                
                case CON : return 0;
                
                case INT : return 0;
                
                case WIS : return 1;
                
                case CHA : return 0;
                
                default : return 0;
            }
        }

        @Override
        public int getMoveSpeed() {
            return 35;
        }

        @Override
        public String getRaceName() {
            return "WOODELF";
        }
    };
    
    /**
     * @return Size of this race
     */
    public abstract String getSize();
    /**
     * Return racial stat bonus based off index
     * @param index (0 = STR, 1 = DEX, 2 = CON, 3 = INT, 4 = WIS, 5 = CHA)
     * @return 
     */
    public abstract int getRacialStatBonus(int index);
    /**
     * 
     * @return  This race's inherent move speed
     */
    public abstract int getMoveSpeed();
    /**
     * 
     * @return  this race's name
     */
    public abstract String getRaceName();
    
    /**
     * Race's size
     */
    private final String size;
    /**
     * Race's base move speed
     */
    private final int speed;
    /**
     * Race's name
     */
    private final String raceName;
    
    /**
     * Indices for each stat
     */
    private static final int STR = 0;
    private static final int DEX = 1;
    private static final int CON = 2;
    private static final int INT = 3;
    private static final int WIS = 4;
    private static final int CHA = 5;
    /**
     * Total number of stats
     */
    private final int NUM_STATS = 6;
    
    /**
     * Array of stat bonuses to all stats based on each's index
     */
    @SuppressWarnings("MismatchedReadAndWriteOfArray")
    private final int[] racialStatBonus = new int[NUM_STATS];

    /**
     * 
     * @param size      Character size(E.G. medium)
     * @param strBonus  Racial bonus to STR
     * @param dexBonus  Racial bonus to DEX
     * @param conBonus  Racial bonus to CON
     * @param intBonus  Racial bonus to INT
     * @param wisBonus  Racial bonus to WIS
     * @param chaBonus  Racial bonus to CHA
     * @param speed     Base movement speed in feet per round
     * @param raceName  String of race name
     */
    Races(String size, int strBonus, int dexBonus, int conBonus, int intBonus, 
            int wisBonus, int chaBonus, int speed, String raceName){

        this.size = size;
        racialStatBonus[STR] = strBonus;
        racialStatBonus[DEX] = dexBonus;
        racialStatBonus[CON] = conBonus;
        racialStatBonus[INT] = intBonus;
        racialStatBonus[WIS] = wisBonus;
        racialStatBonus[CHA] = chaBonus;
        this.speed = speed;
        this.raceName = raceName;

    }
}
