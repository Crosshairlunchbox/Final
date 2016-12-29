import model.Races;
import model.Model;
import model.CharacterClass;
import util.InputData;
import util.OutputData;
import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.control.Button;

import java.util.Arrays;
import javafx.collections.ObservableList;


import static java.lang.String.format;
import static javafx.collections.FXCollections.observableArrayList;



/**
     * FXML Controller class
     * <p>
     * This code controls Final and FinalView
     * 
     * @author Mr. Chad Steffl, S02269293
     * @version 1.3, 12/11/16, Final Project, CSC 241
     */
public class FinalXMLController implements Initializable {
    
    /**
     * Class containing methods for outputting data to text file,
     * including PrintWriter
     */
    private OutputData output;
    
    /**
     * All model data for MVC paradigm controller
     */
    private Model model;

    /* for rolling dice */
    /**
     * ROLLS represents number of rolls, E.G. for rolling 4d6 dice
     */
    private static final int ROLLS = 4;
    /**
     * FACES represents sides on dice rolled, E.G. six sided regular die
     */
    private static final int FACES = 6;
    /**
     * Used for rolling 4d6 dice randomly
     */
    private final Random DICE_ROLL = new Random();
    
    /**
     * The value at which all the "SORT" Buttons start. Sort buttons
     * are temporarily given the values 1-6 inclusive while manually sorting.
     */
    private static final String INITIAL_SORT_VALUE = "1";
    /* format integer as String for output */
    private static final String FORMAT_INTEGER = "%d";
    
    /**
    * Total number of stats. Useful for looping through all stats in an array.
    */
    private static final int NUM_STATS = 6;
    
    /**
     * For starting a loop at ZERO
     */
    private static final int ZERO = 0;
    
    /**
     * Array of labels to hold the individual strScoreLabel, dexScoreLabel...etc.
     * These labels hold the stat values randomly rolled or after manual sort
     */
    private final Label[] SCORE_LABELS = new Label[NUM_STATS];
    
    /**
     * Holds the rolled value of "strength" score also known as STR
     */
    @FXML
    private Label strScoreLabel;
    /**
     * Holds the rolled value of "dexterity" score also known as DEX
     */
    @FXML
    private Label dexScoreLabel;
    /**
     * Holds the rolled value of "constitution" score also known as CON
     */
    @FXML
    private Label conScoreLabel;
    /**
     * Holds the rolled value of "intelligence" score also known as INT
     */
    @FXML
    private Label intScoreLabel;
    /**
     * Holds the rolled value of "wisdom" score also known as WIS
     */
    @FXML
    private Label wisScoreLabel;
    /**
     * Holds the rolled value of "charisma" score also known as CHA
     */
    @FXML
    private Label chaScoreLabel;
    
    /**
     * Array to hold strTotalLabel, dexTotalLabel, etc.
     * These values are the sum of stats and their bonuses.
     * Labels are used in GUI to display these stats
     */
    private final Label[] STAT_TOTAL_LABEL = new Label[NUM_STATS];
    
    /**
     * Holds the total strength score including any (racial) bonuses
     */
    @FXML
    private Label strTotalLabel;
    /**
     * Holds the total dexterity score including any (racial) bonuses
     */
    @FXML
    private Label dexTotalLabel;
    /**
     * Holds the total constitution score including any (racial) bonuses
     */
    @FXML
    private Label conTotalLabel;
    /**
     * Holds the total intelligence score including any (racial) bonuses
     */
    @FXML
    private Label intTotalLabel;
    /**
     * Holds the total wisdom score including any (racial) bonuses
     */
    @FXML
    private Label wisTotalLabel;
    /**
     * Holds the total charisma score including any (racial) bonuses
     */
    @FXML
    private Label chaTotalLabel;
    
    
    /**
     * Holds the character's size (SMALL, MEDIUM, LARGE) etc.
     */
    @FXML
    private Label sizeLabel;
    /**
     * Box containing user selectable RACE choices for a character
     */
    @FXML
    private ComboBox<String> raceBox;
    /**
     * Box containing user selectable CLASS choices for a character
     */
    @FXML
    private ComboBox<String> classBox;
    /**
     * Box containing user selectable LEVEL choices for a character
     */
    @FXML
    private ComboBox<Integer> levelBox ;
    /**
     * Box containing user selectable GENDERs choices for a character
     */
    @FXML
    private ComboBox<String> genderBox;
    /**
     * Box containing user selectable ALIGNMENT choices for a character
     */
    @FXML
    private ComboBox<String> alignmentBox;
    
   
    /**
     * Array to hold strSaveBox, dexSaveBox... etc.
     */
    @FXML
    private final CheckBox[] STAT_SAVE_BOX = new CheckBox[NUM_STATS];
    
    /**
     * Program selected checkbox which shows if a saving throw based on 
     * STRENGTH applies to the chosen CLASS.
     * Not user selectable except via class
     */
    @FXML
    private CheckBox strSaveBox;
    /**
     * Program selected checkbox which shows if a saving throw based on 
     * DEXTERITY applies to the chosen CLASS.
     * Not user selectable except via class
     */
    @FXML
    private CheckBox dexSaveBox;
    /**
     * Program selected checkbox which shows if a saving throw based on 
     * CONSTITUTION applies to the chosen CLASS.
     * Not user selectable except via class
     */
    @FXML
    private CheckBox conSaveBox;
    /**
     * Program selected checkbox which shows if a saving throw based on 
     * INTELLIGENCE applies to the chosen CLASS.
     * Not user selectable except via class
     */
    @FXML
    private CheckBox intSaveBox;
    /**
     * Program selected checkbox which shows if a saving throw based on 
     * WISDOM applies to the chosen CLASS.
     * Not user selectable except via class
     */
    @FXML
    private CheckBox wisSaveBox;
    /**
     * Program selected checkbox which shows if a saving throw based on 
     * CHARISMA applies to the chosen CLASS.
     * Not user selectable except via class
     */
    @FXML
    private CheckBox chaSaveBox;
    
    
    
    
    /**
     * Array to hold strRaceLabel, dexRaceLabel... etc.
     */
    @FXML
    private final Label[] STAT_RACE_LABEL = new Label[NUM_STATS];
   
    
    /**
     * Holds the racial bonus to STRENGTH if one applies.
     */
    @FXML
    private Label strRaceLabel;
    /**
     * Holds the racial bonus to DEXTERITY if one applies.
     */
    @FXML
    private Label dexRaceLabel;
    /**
     * Holds the racial bonus to CONSTITUTION if one applies.
     */
    @FXML
    private Label conRaceLabel;
    /**
     * Holds the racial bonus to INTELLIGENCE if one applies.
     */
    @FXML
    private Label intRaceLabel;
    /**
     * Holds the racial bonus to WISDOM if one applies.
     */
    @FXML
    private Label wisRaceLabel;
    /**
     * Holds the racial bonus to CHARISMA if one applies.
     */
    @FXML
    private Label chaRaceLabel;
    
    /**
     * Array holds the stat bonus(modifier) in Label form for use in GUI
     */
     private final Label[] STAT_MOD_LABEL = new Label[NUM_STATS];
    
    /**
     * Holds the bonus (modifier) for STRENGTH stat
     */
    @FXML
    private Label strModLabel;
    /**
     * Holds the bonus (modifier) for DEXTERITY stat
     */
    @FXML
    private Label dexModLabel;
    /**
     * Holds the bonus (modifier) for CONSTITUTION stat
     */
    @FXML
    private Label conModLabel;
    /**
     * Holds the bonus (modifier) for INTELLIGENCE stat
     */
    @FXML
    private Label intModLabel;
    /**
     * Holds the bonus (modifier) for WISDOM stat
     */
    @FXML
    private Label wisModLabel;
    /**
     * Holds the bonus (modifier) for CHARISMA stat
     */
    @FXML 
    private Label chaModLabel;
    
   
    
    
     /**
     * Array of Labels which holds the proficiency bonus to a saving throw
     * for each stat(STR, DEX). Only two proficiency bonuses are ever applied to 
     * one character at a time.
     */
    private final Label[] STAT_PROF_BONUS_LABEL = new Label[NUM_STATS];
    
    
    /**
     * Holds the proficiency bonus to STRENGTH saving throw
     * if character is proficient in it.
     */
    @FXML
    private Label strProfBonusLabel;
    /**
     * Holds the proficiency bonus to DEXTERITY saving throw
     * if character is proficient in it.
     */
    @FXML
    private Label dexProfBonusLabel;
    /**
     * Holds the proficiency bonus to CONSTITUTION saving throw
     * if character is proficient in it.
     */
    @FXML
    private Label conProfBonusLabel;
    /**
     * Holds the proficiency bonus to INTELLIGENCE saving throw
     * if character is proficient in it.
     */
    @FXML
    private Label intProfBonusLabel;
    /**
     * Holds the proficiency bonus to WISDOM saving throw
     * if character is proficient in it.
     */
    @FXML
    private Label wisProfBonusLabel;
    /**
     * Holds the proficiency bonus to CHARISMA saving throw
     * if character is proficient in it.
     */
    @FXML 
    private Label chaProfBonusLabel;
    
   
    /**
     * Holds the stat bonus(modifer) to saving throw for each stat(STR, DEX...)
     */
    private final Label[] STAT_BONUS_THROW_LABEL = new Label[NUM_STATS];
    
    /**
     * Holds the STRENGTH bonus(modifier) to STRENGTH saving throw
     */
    @FXML
    private Label strBonusThrowLabel;
    /**
     * Holds the DEXTERITY bonus(modifier) to DEXTERITY saving throw
     */
    @FXML
    private Label dexBonusThrowLabel;
    /**
     * Holds the CONSTITUTION bonus(modifier) to CONSTITUTION saving throw
     */
    @FXML
    private Label conBonusThrowLabel;
    /**
     * Holds the INTELLIGENCE bonus(modifier) to INTELLIGENCE saving throw
     */
    @FXML
    private Label intBonusThrowLabel;
    /**
     * Holds the WISDOM bonus(modifier) to WISDOM saving throw
     */
    @FXML
    private Label wisBonusThrowLabel;
    /**
     * Holds the CHARISMA bonus(modifier) to CHARISMA saving throw
     */
    @FXML
    private Label chaBonusThrowLabel;
    
    
    
    /**
     * Holds the total saving throw modifier including base score and bonuses
     * for each of the six saving throws.
     */
    private final Label[] STAT_TOTAL_THROW_LABEL = new Label[NUM_STATS];
        
    
    /**
     * Contains total bonus to STRENGTH saving throw
     */
    @FXML
    private Label strTotalThrowLabel;
    /**
     * Contains total bonus to DEXTIERITY saving throw
     */
    @FXML 
    private Label dexTotalThrowLabel;
    /**
     * Contains total bonus to CONSTITUION saving throw
     */
    @FXML
    private Label conTotalThrowLabel;
    /**
     * Contains total bonus to INTELLIGENCE saving throw
     */
    @FXML 
    private Label intTotalThrowLabel;
    /**
     * Contains total bonus to WISDOM saving throw
     */
    @FXML
    private Label wisTotalThrowLabel;
    /**
     * Contains total bonus to CHARISMA saving throw
     */
    @FXML 
    private Label chaTotalThrowLabel;
    
    
    /**
     * Holds an array of Button representing the buttons that a user uses
     * to manually sort stats(STR, DEX...) from largest to smallest.
     */
    private final Button[] STAT_SORT_BUTTON = new Button[NUM_STATS];
    
    /**
     * Button used to manually sort/prioritize STRENGTH score
     */
    @FXML
    private Button strSortButton;
    /**
     * Button used to manually sort/prioritize DEXTERITY score
     */
    @FXML
    private Button dexSortButton;
    /**
     * Button used to manually sort/prioritize CONSTITUION score
     */
    @FXML
    private Button conSortButton;
    /**
     * Button used to manually sort/prioritize INTELLIGENCE score
     */
    @FXML
    private Button intSortButton;
    /**
     * Button used to manually sort/prioritize WISDOM score
     */
    @FXML
    private Button wisSortButton;
    /**
     * Button used to manually sort/prioritize CHARISMA score
     */
    @FXML
    private Button chaSortButton;
    
    
    

    /**
     * User selectable button which allows the user to randomly roll 4d6k3
     * for each of the six stat scores (STRENGTH, DEXTERITY...).
     */
    @FXML
    private Button rollStatsButton;
    
    /**
     * Total hit points of the character
     */
    @FXML
    private Label totalHP;
    
    /**
     * Portion of total hit points derived solely from class.
     */
    @FXML 
    private Label classHP;
    
    /**
     * Portion of total hit points derived solely from CONSTITUION bonus(modifier).
     */
    @FXML
    private Label conHP;
    
    /**
     * Displays proficiency bonus which is based solely on character's level.
     */
    @FXML
    private TextField profBonusOutput;
   
    /**
     * Displays character's name
     */
    @FXML
    private TextField charName;
    
    /** 
     * Instances of ENUM CharacterClass corresponding to various character classes
     */
    CharacterClass fighter = CharacterClass.FIGHTER;
    CharacterClass paladin = CharacterClass.PALADIN;
    CharacterClass wizard = CharacterClass.WIZARD;
    
    /**
     * Instances of ENUM Races corresponding to various race choices
     */
    Races human = Races.HUMAN;
    Races highelf = Races.HIGHELF;
    Races woodelf = Races.WOODELF;
    
    /**
     * List of class choices that may be selected.
     * Class name is gathered from respective ENUM class.
     */
    private final ObservableList<String> CLASS_LIST = 
            observableArrayList(fighter.getClassName(),
            paladin.getClassName(),wizard.getClassName() );
    /**
     * List of race choices that may be selected.
     * Race name is gathered from respective ENUM class.
     */
    private final ObservableList<String> RACE_LIST =
            observableArrayList(human.getRaceName(), 
            highelf.getRaceName(), woodelf.getRaceName() );
    /**
     * List of alignment choices that may be selected.
     */
    private final ObservableList<String> ALIGNMENT_LIST =
            observableArrayList("LAWFUL GOOD", 
            "CHAOTIC GOOD", "CHAOTIC NEUTRAL", "LAWFUL NEUTRAL");
    /**
     * List of levels that may be chosen.
     */
    private final ObservableList<Integer> LEVEL_LIST = 
            observableArrayList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
    /**
     * List of genders that may be chosen.
     */
    private final ObservableList<String> GENDER_LIST = 
            observableArrayList("MALE", "FEMALE", "OTHER");
    
    /**
     * Starting external sort Counter used in Method sortStats() to iterate
     * through the six stat scores while manually sorting is in progress.
     */
    private int sortCount = 0;
    
    /**
     * All stats are always held in the same order within arrays.
     * Define ordinal numbers for respective stats.
     */
    private static final int STR = 0;
    private static final int DEX = 1;
    private static final int CON = 2;
    private static final int INT = 3;
    private static final int WIS = 4;
    private static final int CHA = 5;
    
    

    
    /**
     * Method which initializes any data or components
     * @param location
     * @param resources 
     */
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        
        STAT_SORT_BUTTON[STR] = strSortButton;
        STAT_SORT_BUTTON[DEX] = dexSortButton;
        STAT_SORT_BUTTON[CON] = conSortButton;
        STAT_SORT_BUTTON[INT] = intSortButton;
        STAT_SORT_BUTTON[WIS] = wisSortButton;
        STAT_SORT_BUTTON[CHA] = chaSortButton;
        
        STAT_MOD_LABEL[STR] = strModLabel;
        STAT_MOD_LABEL[DEX] = dexModLabel;
        STAT_MOD_LABEL[CON] = conModLabel;
        STAT_MOD_LABEL[INT] = intModLabel;
        STAT_MOD_LABEL[WIS] = wisModLabel;
        STAT_MOD_LABEL[CHA] = chaModLabel;
        
        STAT_TOTAL_THROW_LABEL[STR] = strTotalThrowLabel;
        STAT_TOTAL_THROW_LABEL[DEX] = dexTotalThrowLabel;
        STAT_TOTAL_THROW_LABEL[CON] = conTotalThrowLabel;
        STAT_TOTAL_THROW_LABEL[INT] = intTotalThrowLabel;
        STAT_TOTAL_THROW_LABEL[WIS] = wisTotalThrowLabel;
        STAT_TOTAL_THROW_LABEL[CHA] = chaTotalThrowLabel;
        
        STAT_RACE_LABEL[STR] = strRaceLabel;
        STAT_RACE_LABEL[DEX] = dexRaceLabel;
        STAT_RACE_LABEL[CON] = conRaceLabel;
        STAT_RACE_LABEL[INT] = intRaceLabel;
        STAT_RACE_LABEL[WIS] = wisRaceLabel;
        STAT_RACE_LABEL[CHA] = chaRaceLabel;
        
        STAT_TOTAL_LABEL[STR] = strTotalLabel;
        STAT_TOTAL_LABEL[DEX] = dexTotalLabel;
        STAT_TOTAL_LABEL[CON] = conTotalLabel;
        STAT_TOTAL_LABEL[INT] = intTotalLabel;
        STAT_TOTAL_LABEL[WIS] = wisTotalLabel;
        STAT_TOTAL_LABEL[CHA] = chaTotalLabel;
        
        STAT_BONUS_THROW_LABEL[STR] = strBonusThrowLabel;
        STAT_BONUS_THROW_LABEL[DEX] = dexBonusThrowLabel;
        STAT_BONUS_THROW_LABEL[CON] = conBonusThrowLabel;
        STAT_BONUS_THROW_LABEL[INT] = intBonusThrowLabel;
        STAT_BONUS_THROW_LABEL[WIS] = wisBonusThrowLabel;
        STAT_BONUS_THROW_LABEL[CHA] = chaBonusThrowLabel;
        
        STAT_SAVE_BOX[STR] = strSaveBox;
        STAT_SAVE_BOX[DEX] = dexSaveBox;
        STAT_SAVE_BOX[CON] = conSaveBox;
        STAT_SAVE_BOX[INT] = intSaveBox;
        STAT_SAVE_BOX[WIS] = wisSaveBox;
        STAT_SAVE_BOX[CHA] = chaSaveBox;
        
        SCORE_LABELS[STR] = strScoreLabel;
        SCORE_LABELS[DEX] = dexScoreLabel;
        SCORE_LABELS[CON] = conScoreLabel;
        SCORE_LABELS[INT] = intScoreLabel;
        SCORE_LABELS[WIS] = wisScoreLabel;
        SCORE_LABELS[CHA] = chaScoreLabel;
        
        STAT_PROF_BONUS_LABEL[STR] = strProfBonusLabel;
        STAT_PROF_BONUS_LABEL[DEX] = dexProfBonusLabel;
        STAT_PROF_BONUS_LABEL[CON] = conProfBonusLabel;
        STAT_PROF_BONUS_LABEL[INT] = intProfBonusLabel;
        STAT_PROF_BONUS_LABEL[WIS] = wisProfBonusLabel;
        STAT_PROF_BONUS_LABEL[CHA] = chaProfBonusLabel;
        
        
        Platform.runLater(() -> {
            model = new Model();
            output = new OutputData();

            classBox.setItems(CLASS_LIST); //
            raceBox.setItems(RACE_LIST);//
            levelBox.getItems().addAll(LEVEL_LIST);
            genderBox.getItems().addAll(GENDER_LIST);
            alignmentBox.getItems().addAll(ALIGNMENT_LIST);//
        
        });
    }
    
    /**
     * Implement rolling 4d6k3 for use on GUI 'Roll 4d6' button
     * 4d6k3 = QTY 4 six sided DICE, keeping highest of the three
     
     * @return  SUM of highest three dice
     * @author Dr. Bruce K. Haddon  
     */
    public int rollStats() {
        //System.out.println("rollStats activated"); //for DEBUGGING
            int sum = 0;
            int least = FACES;
            for (int i = ZERO; i !=ROLLS; ++i){
                int die = 1 + DICE_ROLL.nextInt(FACES);
                least = Math.min(least, die);
                sum += die;
            }
            
            
            return sum - least;
        }
    
    /**
     * Roll 4d6k3 for all stats and assign values.
     */
    public void rollAllStats(){
        
        for (int i = ZERO; i < NUM_STATS; i++){
            model.setStatScore(rollStats(), i);
        }
    }
    /**
     * Take stats and assign to Label used by GUI
     */
    public void setBaseLabelScores(){        
        for(int i = ZERO; i < NUM_STATS; i++){
            model.setStatLabel(model.getStatScore(i), i);
            SCORE_LABELS[i].setText(format(FORMAT_INTEGER,
                    model.getStatScore(i)) );
        }
    }
    
    /**
     * Calculate stats will provide all operations for calculate stat scores.
     * This includes individual values, totals, and updating all stats
     * related to stats(saves, hit points)
     * 
     * @param e 
     */
    @FXML
    public void calculateStats(ActionEvent e){
        resetSortButtons();
        rollAllStats();
        setBaseLabelScores();
        calculateTotalStat();
        calculateSaves();
        calculateTotalHP();
        
//        // for debugging
//        System.out.println("Str score " + model.getStrScore());
//        System.out.println(model.getDexScore());
//        System.out.println(model.getConScore());
//        System.out.println(model.getIntScore());
//        System.out.println(model.getWisScore());
//        System.out.println(model.getChaScore());
//        System.out.println("hello");
    }
    
    /**
     * Action events for selecting class and the accompanying features such
     * as saving throws and hit points.
     * @param e 
     */
    @FXML
    public void selectClass(ActionEvent e){
       /* Class determines saving throw proficiencies so they must be reset */
        resetSavingThrows();
       
        
        switch ((String)classBox.getValue()){
            
            case "FIGHTER" : 
                //System.out.println(classBox.getValue() +" selected");
                setSavingThrowCheckbox(fighter);
                calculateSaves();
                model.setHP(fighter.getHP());
                calculateTotalHP();
            
            break;
            
            case "PALADIN" : 
                //System.out.println(classBox.getValue() +" selected");
                setSavingThrowCheckbox(paladin);
                calculateSaves();
                model.setHP(paladin.getHP());
                calculateTotalHP();
            break;
            
            case "WIZARD" : 
                //System.out.println(classBox.getValue() + " selected");
                setSavingThrowCheckbox(wizard);
                calculateSaves();
                model.setHP(wizard.getHP());
                calculateTotalHP();
            break;
            
            default : System.out.println("No class selected");
        }
    }
    
    /**
     * Action events for selecting race and assigning related features such
     * as racial stat(STR, DEX...) bonuses, SIZE.
     * @param e 
     */
    @FXML
    public void selectRace(ActionEvent e){
       
        switch((String)raceBox.getValue()){
            
            case "HUMAN" : 
                
                //System.out.println(raceBox.getValue() + " selected");
                setRacialStatBonus(human);
                setBaseLabelScores();
                calculateTotalStat();
                calculateSaves();
                setSize(human);
                
                break;
                
            case "HIGHELF":
                //System.out.println(raceBox.getValue() + " selected");
                setRacialStatBonus(highelf);
                setBaseLabelScores();
                calculateTotalStat();
                calculateSaves();
                setSize(highelf);
                
                break;
                
            case "WOODELF":
                //System.out.println(raceBox.getValue() + " selected");
                setRacialStatBonus(woodelf);
                setBaseLabelScores();
                calculateTotalStat();
                calculateSaves();
                setSize(woodelf);
                
                break;
            
            default: System.out.println("Race selection error");
        }
        
    }
    
    /**
     * Caluates saving throws. Saving throws add proficiency bonus only if a
     * given class(FIGHTER, WIZARD...) is trained (checkbox is checked)
     */
    public void calculateSaves(){
        int zero_bonus = ZERO;
        
        for(int i = STR; i < NUM_STATS; i++){
            STAT_BONUS_THROW_LABEL[i].setText(format(FORMAT_INTEGER,
                    model.getStatMod(i)));
            
            if(!STAT_SAVE_BOX[i].isSelected()){
                STAT_PROF_BONUS_LABEL[i].setText(format(FORMAT_INTEGER, 
                        zero_bonus));
                STAT_TOTAL_THROW_LABEL[i].setText(format(FORMAT_INTEGER,
                        model.getStatMod(i) ));
            }
            else{
                STAT_PROF_BONUS_LABEL[i].setText(format(FORMAT_INTEGER, 
                        model.getProfBonus(model.getLevel())));
                STAT_TOTAL_THROW_LABEL[i].setText(format(FORMAT_INTEGER,
                        model.getTrainedStatThrow(i) ));
            }
        }
    }   
    
    /**
     * Calculate total hit points and set corresponding label.
     */
    public void calculateTotalHP(){
        setClassHP();
        setConModHP();
        totalHP.setText(format(FORMAT_INTEGER, (model.getHP() 
                + model.getStatMod(CON))));
    } 
    /**
     * set class based hit points label based on class
     */
    public void setClassHP(){
        classHP.setText(format(FORMAT_INTEGER, model.getHP() ));
    }
    /**
     * set constitution based hit points bonus based on CONSTIUTION bonus(modifier).
     */
    public void setConModHP(){
        conHP.setText(format(FORMAT_INTEGER, model.getStatMod(CON)));
    }
    /**
     * Action events for dealing with selection of level
     * @param e 
     */
    public void selectLevel(ActionEvent e){
        
        model.setLevel(levelBox.getValue());
        /* Proficiency bonus is based strictly upon level so it should only be
        * set after level is selected.
        */
        profBonusOutput.setText("+" + 
                format(FORMAT_INTEGER, model.getProfBonus(model.getLevel())));
        
        /* Proficiency bonus will apply to exactly two saving throws
        *so upon setting proficiency bonus saving throws must be recalculated.
        */
        calculateSaves();
        
    }
    
    /**
     * Calculate proficiency bonus of character which is solely based on level
     * 
     * @param level
     * @return 
     */
    public int calculateProfBonus(int level){

        return model.getProfBonus(level);
    }
    
    /**
     * Calculate sum of stat scores(STRENGTH, DEXTERITY...) and set
     * related label.
     */
    public void calculateTotalStat(){
//        // For Debugging
//        System.out.println("Str Label " +model.getStrLabel());
//        System.out.println("Str Race Label " +model.getStrRaceLabel());
        for (int i = ZERO; i < NUM_STATS; i++){
            model.setStatTotalLabel( ( (model.getStatLabel(i) + 
                    model.getStatRaceLabel(i) ) ), i );
            STAT_TOTAL_LABEL[i].setText(format(FORMAT_INTEGER,
                    model.getStatTotalLabel(i) ) );
        }
        

        /* stat bonus(modifer) is based only on stat total and should only be
        *set after stat totals are calculated.
        */
        setStatModifier();
    }
    
    /**
     * Set Racial bonuses and display to relevant label
     * @param raceName 
     */
    public void setRacialStatBonus(Races raceName){
        resetRacialStatBonus();
        
        for( int i = ZERO; i < NUM_STATS; i++){
            model.setStatRaceLabel( (raceName.getRacialStatBonus(i)), i);
            STAT_RACE_LABEL[i].setText(format(FORMAT_INTEGER, 
                    model.getStatRaceLabel(i)));
        }
    }
    
    /**
     * Set stat modifier and relevant label
     * The Bonus(modifier) is equal to (SCORE - 10) /2. E.G. 12 = +1, 13 = +1,
     * 14 = +2.
     */
    public void setStatModifier(){
        for (int i = ZERO; i < NUM_STATS; i++){
            model.setStatMod( ((((model.getStatTotalLabel(i))) - 10 ) / 2 ), i );
            STAT_MOD_LABEL[i].setText(format(FORMAT_INTEGER,
                    model.getStatMod(i) ) );
        }
    }
    
    /**
     * Reset racial bonuses to zero
     */
    public void resetRacialStatBonus(){
        int zeroBonus = ZERO;
        
        for(int i = ZERO; i < NUM_STATS; i++){
            model.setStatRaceLabel(zeroBonus, i);
            STAT_RACE_LABEL[i].setText(format(FORMAT_INTEGER, 
                    model.getStatRaceLabel(i)));
        }
    }
    
    /**
     * Uncheck all six saving throw CheckBox.
     * This is the default state.
     */
    public void resetSavingThrows(){
        
        for(CheckBox thisBox:STAT_SAVE_BOX){
            thisBox.setSelected(false);
        }
    }
    
    /**
     * Set the correct (two) saving throw checkboxes based on the class
     * E.G. FIGHTER class checks STRENGTH and CONSTITUTION boxes
     * Also disables the other four checkboxes that do not apply to that class.
     * @param className 
     */
    public void setSavingThrowCheckbox(CharacterClass className){
        for (int i = ZERO; i< NUM_STATS; i++){
            STAT_SAVE_BOX[i].setSelected(className.getStatSaveBool(i));
            STAT_SAVE_BOX[i].setDisable(!className.getStatSaveBool(i));  
        }
    }

    /**
     * Set character size based on the race chosen.
     * @param race 
     */
    private void setSize(Races race) {
        sizeLabel.setText(race.getSize());
    }
    
    /**
     * Reset the manual sort buttons next to each stat back to original value.
     * 
     */
    private void resetSortButtons(){
        for (Button thisButton : STAT_SORT_BUTTON){
            thisButton.setText(INITIAL_SORT_VALUE);
        }
    }
    /**
     * Enable manual sort buttons next to each stat. Default state is disabled.
     * @param e 
     */
    public void enableSortButtons(ActionEvent e){
        /* Turn buttons on for sorting */
        for (Button thisButton : STAT_SORT_BUTTON){
            thisButton.setDisable(false);
        } 
    }
    /**
     * Disable manual sort buttons next to each stat. 
     * Disabled is the default state.
     */
    public void disableSortButtons(){
        
        for(Button thisButton : STAT_SORT_BUTTON){
            thisButton.setDisable(true);
        }
    }
    
    /**
     * Method to allow user directed manual sorting of stats using
     * manual sort buttons next to each stat.
     * sortCount is used such that no button may be assigned a duplicate order.
     * @param e 
     */
    public void sortStats(ActionEvent e){
        /** Disable re-rolling of stats while manual sorting is in progress */
        rollStatsButton.setDisable(true);
        
        /* ORDERING begins at 1 */
        ++sortCount;
        /* get button pressed */
        Button b = (Button)e.getSource();

        /* check which button was pressed and assign sortCount value to that button label */
        
        for (Button thisButton : STAT_SORT_BUTTON){
            if (b.equals(thisButton)){
                thisButton.setText(format(FORMAT_INTEGER, sortCount));
                thisButton.setDisable(true);
            }
        }
        
        if(sortCount >= NUM_STATS){
            /* reset sortCount so process can be done again if desired */
            sortCount = ZERO;
            disableSortButtons();
            rollStatsButton.setDisable(false);
            manualSortStats();
        }
    }
    
    /**
     * Sort stats and assign scores based on the order manually chosen by user.
     */
    public void manualSortStats(){
        int[] statValues = new int[NUM_STATS];
        int[] statSortedValues = new int[NUM_STATS];

        int max = statValues.length -1;
        int descend_count = ZERO;

            for(int i = ZERO; i <NUM_STATS; i++){
                statValues[i] = model.getStatScore(i);
            }

        /** place stat values in ascending order so they can be then reversed */
        Arrays.sort(statValues);
        /** sort values in descending order and assign to 
        * statSortedValues[] output array
        */
        
        //  System.out.println("Array in descending order: "); // For Debugging
        for (int i = max; i>=ZERO; i--){
            statSortedValues[descend_count] = statValues[i];
        //System.out.println(statSortedValues[k]); // For Debugging
            descend_count++;
        }
        //// For Debugging
        //System.out.println("parse test " + (Integer.parseInt(strSortButton.getText())));
        //System.out.println("parse array test" + 
        //      statSortedValues[(Integer.parseInt(strSortButton.getText())) -1]);
        //System.out.println("parse array test with int" + statSortedValues[1]);

    
        for (int i = ZERO; i <NUM_STATS; i++){
            model.setStatScore(statSortedValues[(Integer.parseInt(
                STAT_SORT_BUTTON[i].getText())) -1], i);
        }
        
        //       System.out.println(model.getStrScore());
        //       System.out.println(model.getDexScore());
        //       System.out.println(model.getConScore());
        //       System.out.println(model.getIntScore());
        //       System.out.println(model.getWisScore());
        //       System.out.println(model.getChaScore());
       
        /* reset relevant fields with manually sorted stat(str, dex..) values */
        setBaseLabelScores();
        calculateTotalStat();
        calculateSaves();
        calculateTotalHP();
           
       }
    
    /**
     * Save character data to a text file
     * @param e 
     */
    @FXML
    public void testSave(ActionEvent e){
        System.out.println("hello"); // FOR DEBUGGING
        /**
         * Minimum name length must be two characters or longer
         */
        int MIN_NAME = 2;
        
        /**
         * Ensure all data is present before starting the outputting of data
         */
        if(charName.getText().length() >= MIN_NAME
                && levelBox.getValue() != null
                && classBox.getValue() != null
                && raceBox.getValue() != null
                && genderBox.getValue() != null
                && alignmentBox.getValue() !=null){
            output.initialize();
            output.printObject(charName.getText());
            output.printStats(model.getRolledStats());
            output.printObject(levelBox.getValue());
            output.printObject(classBox.getValue());
            output.printObject(genderBox.getValue());
            output.printObject(alignmentBox.getValue());
            output.printObject(raceBox.getValue());
            output.close();
        }
        else{
            ErrorXMLController.showStage();
        } 
    }
    
    /**
     * Method to load all saved character data
     * @param e 
     */
    
    @FXML
    public void loadSave(ActionEvent e){
        int VALUES_PER_INPUT_LINE = 12;
        System.out.println("Loading Data");
        int NAME_INDEX = 0;
        int STR_INDEX = 1;
        int DEX_INDEX = 2;
        int CON_INDEX = 3;
        int INT_INDEX = 4;
        int WIS_INDEX = 5;
        int CHA_INDEX = 6;
        int LEVEL_INDEX = 7;
        int CLASS_INDEX = 8;
        int GENDER_INDEX = 9;
        int ALIGN_INDEX = 10;
        int RACE_INDEX = 11;
        
        try (InputData inputData = new InputData("CharData.txt",
        InputData.class, null, VALUES_PER_INPUT_LINE, ",", ",", ",", ","
                , ",", ",", ",", ",", ",", ",", ",", ",") ){
            
            inputData.stream().forEach((String[] value) -> {
                
                String name = (String)value[NAME_INDEX];
                //System.out.println(name);
                charName.setText(name);
                
                int strength = Integer.parseInt(value[STR_INDEX]);
                //System.out.println(strength);
                model.setStatScore(strength, STR);
                
                int dexterity = Integer.parseInt(value[DEX_INDEX]);
                //System.out.println(dexterity);
                
                model.setStatScore(dexterity, DEX);
                int constitution = Integer.parseInt(value[CON_INDEX]);
                //System.out.println(constitution);
                model.setStatScore(constitution, CON);
                
                int intelligence = Integer.parseInt(value[INT_INDEX]);
                //System.out.println(intelligence);
                model.setStatScore(intelligence, INT);
                
                int wisdom = Integer.parseInt(value[WIS_INDEX]);
                model.setStatScore(wisdom, WIS);
                
                int charisma = Integer.parseInt(value[CHA_INDEX]);
                model.setStatScore(charisma, CHA);
                
                int level = Integer.parseInt(value[LEVEL_INDEX]);
                levelBox.setValue(level);
                
                String className = value[CLASS_INDEX];
                classBox.setValue(className);
                
                String gender = value[GENDER_INDEX];
                genderBox.setValue(gender);
                
                String alignment = value[ALIGN_INDEX];
                alignmentBox.setValue(alignment);
                
                String race = value[RACE_INDEX];
                raceBox.setValue(race);
            });
        }
        setBaseLabelScores();
        calculateTotalStat();
        calculateSaves();
        calculateTotalHP();
    }
    
    /**
     * Close GUI
     * @param e 
     */
    @FXML
    public void close(ActionEvent e){
        System.exit(ZERO);
    }
    
}
    
    


