 package com.borat.NSON;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.borat.NSON.ExamContract.*;

import java.util.ArrayList;
import java.util.List;


public class ExamDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "NursingExamQuestion.db";
    private static final int DATABASE_VERSION = 1;

    private static ExamDbHelper instance;

    private SQLiteDatabase db;

    ExamDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static synchronized ExamDbHelper getInstance(Context context){
        if (instance == null){
            instance = new ExamDbHelper(context.getApplicationContext());
        }
        return instance;
    }


    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_CATEGORIES_TABLE = "CREATE TABLE " +
                CategoriesTable.TABLE_NAME + "( " +
                CategoriesTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                CategoriesTable.COLUMN_NAME + " TEXT " +
                ")";

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_OPTION1 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION2 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION3 + " TEXT, " +
                QuestionsTable.COLUMN_OPTION4 + " TEXT, " +
                QuestionsTable.COLUMN_ANSWER_NR + " INTEGER, " +
                QuestionsTable.COLUMN_CATEGORY_ID + " INTEGER, " +
                "FOREIGN KEY(" + QuestionsTable.COLUMN_CATEGORY_ID + ") REFERENCES " +
                CategoriesTable.TABLE_NAME + "(" + CategoriesTable._ID + ")" + "ON DELETE CASCADE" +
                ")";


        db.execSQL(SQL_CREATE_CATEGORIES_TABLE);
        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        fillCategoriesTable();
        fillQuestionsTable();
    }
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + CategoriesTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + QuestionsTable.TABLE_NAME);
        onCreate(db);
    }

    @Override
    public void onConfigure(SQLiteDatabase db) {
        super.onConfigure(db);
        db.setForeignKeyConstraintsEnabled(true);
    }

    private void fillCategoriesTable() {
        Category c1 = new Category("SELECT SUBJECT");
        addCategory(c1);
        Category c2 = new Category("Physics");
        addCategory(c2);
        Category c3 = new Category("Biology");
        addCategory(c3);
        Category c4 = new Category("Chemistry");
        addCategory(c4);
        Category c5 = new Category("Mathematics");
        addCategory(c5);
        Category c6 = new Category("Current_Affairs");
        addCategory(c6);
    }

    private void addCategory(Category category) {
        ContentValues cv = new ContentValues();
        cv.put(CategoriesTable.COLUMN_NAME, category.getName());
        db.insert(CategoriesTable.TABLE_NAME, null, cv);
    }


    private void fillQuestionsTable() {
// Biology Questions
        Question q1 = new Question("What chromosomes line up in mitosis", "A: Telophase", "B: Anaphase", "C: Metaphase", "D: Prophase",3, Category.BIOLOGY );
        addQuestion(q1);
        Question q2 = new Question("which cellular organelle contains enzymes that are considered digestive ", "A: Golgi apparatus", "B: Lysosomes", "C: Nucleus", "D: Ribosomes", 2 , Category.BIOLOGY
        );
        addQuestion(q2);
        Question q3 = new Question("Organs repair themselves through a process called ", "A: Meiosis", "B: Mitosis", "C: Cellular differentiation","D: Transformation", 2 , Category.BIOLOGY);
        addQuestion(q3);
        Question q4 = new Question("Which of the following statement about enzymes is not true", "A:Enzymes are catalysts ", "B:Almost all enzymes are protein ", "C:Enzymes operate most efficently at optimum pH ","D: Enzymes are destroyed during chemical reactions ", 4 , Category.BIOLOGY );
        addQuestion(q4);
        Question q5 = new Question("Cholesterol that is known as LDL stans for", "A: Low-density lipoproteins ", "B: Low-density Lysosomes", "C: Level-density lipoproteins ","D: Level-density Lysosomes",1 , Category.BIOLOGY );
        addQuestion(q5);
        Question q6 = new Question("Breathing properly requires the presence of what compound that affects surface tension of alveoli in the lungs", "A:Potassium ", "B:Plasma ", "C: Surfacant ","D: Sodium chloride ", 3 , Category.BIOLOGY );
        addQuestion(q6);
        Question q7 = new Question("The functional unit of the kidney is ", "A: Medulla ", "B: GLomerulus ", "C: Pyramid ","D: Nephron ",4 , Category.BIOLOGY );
        addQuestion(q7);
        Question q8 = new Question("What anatomical structure connects the stomach and the mouth", "A: Trachea ", "B: spinal column", "C: Hepatic duct ","D: Oesophagus ", 4  , Category.BIOLOGY);
        addQuestion(q8);
        Question q9 = new Question("Which of the following models is considered a model for enzyme action", "A: Lock and key model ", "B: Enzyme interaction", "C: Transformation model ","D: Transcription model ", 1 , Category.BIOLOGY );
        addQuestion(q9);
        Question q10 = new Question("Which of the following statements about prostaglandins is not true", "A: Prostaglandins promote inflammation ", "B: can only constrict blood vessels", "C: are made in the renal medulla ","D: can lead to pain and fever ",2 , Category.BIOLOGY );
        addQuestion(q10);
        Question q11 = new Question("Hardening of the arteries is known as", "A: Arteriosclerosis", "B: Venon narrowing ", "C: Micro-circulation ","D: Hypertension ", 1 , Category.BIOLOGY );
        addQuestion(q11);
        Question q12 = new Question("Which of the following is not consider a function of the kidney", "A:Secretion ", "B: Reabsorption ", "C: Transport ","D: Filtration ", 3 ,Category.BIOLOGY );
        addQuestion(q12);
        Question q13 = new Question("Which of the following characteristics is not necessary in order for an object to be considered living", "A: Ability to reproduce ", "B:  Ability to grow", "C: Ability to move ","D: Ability to respond to stimuli ", 3 , Category.BIOLOGY);
        addQuestion(q13);
        Question q14 = new Question("Which of the following is not present in the nucleus of a cell", "A: Chromosomes ", "B: Nucleolus ", "C: Mitochoridrion ","D: Genes ", 3, Category.BIOLOGY );
        addQuestion(q14);
        Question q15 = new Question("Which of the following statement is correct of the hormones?", "A: secreted into the body through ducts ", "B: secreted directly into the blood stream ", "C: inactive chemical substance in the bloodstream ","D: non-special in their mode of action ", 2,  Category.BIOLOGY);
        addQuestion(q15);
        Question q16 = new Question("The casual organism of sleeping sickness is the ", "A: Trypanosome ", "B: Plasmodium ", "C: vibro bacterium ","D: Penicillium ",1, Category.BIOLOGY );
        addQuestion(q16);
        Question q17 = new Question("The structure in the cell that controls the movement of substance in and out of the cell is the", "A: Cytoplasmic membrane ", "B: Nuclear membrane ", "C: Cytoplasm ","D: Protoplasm ",1, Category.BIOLOGY );
        addQuestion(q17);
        Question q18 = new Question("A pair of gene that controls life is decribed as", "A: Dominant ", "B: Recessive ", "C: Allele ","D: variant ",1 ,Category.BIOLOGY );
        addQuestion(q18);
        Question q19 = new Question("Muscles are attached to bones through", "A: Ligament ", "B: Cartilage ", "C: Synovial membrane ","D: Tendons ",4 ,Category.BIOLOGY );
        addQuestion(q19);
        Question q20 = new Question("The human skin is regarded as a sense organ because it", "A: seperates the bosy from the outside world", "B: protects the body from cold and heat ", "C: regulates water content of the body ","D: has nerve endings ",4 ,Category.BIOLOGY );
        addQuestion(q20);
        Question q21 = new Question("The number of individual inhabit in relation to the unit space available to each organism is referred to as the", "A: Birth rate", "B: Mortality ", "C: Density ","D: Frequency",3, Category.BIOLOGY );
        addQuestion(q21);
        Question q22 = new Question("Agglutination occur in the blood transfusion when", "A:Donor and recipent belongs to the same blood group ", "B: Same antibodies from donor and reciprnt fuse together ", "C: Donor and the recipient belongs to different races ","D: Antigen and antibody in the donor and the recipient react",4 , Category.BIOLOGY);
        addQuestion(q22);
        Question q23 = new Question("Which of the following structures is a protective adaptive features of the Agama lizard to terrestial habitat", "A: Claws ", "B:Gular fold ", "C: Scaly skin ","D: Mandible ", 3, Category.BIOLOGY);
        addQuestion(q23);
        Question q24 = new Question("The organ which is sensitive to smell in a cockroach is the ", "A: Nostril ", "B: Pedipalp ", "C: Antenna","D: Mandible ",3  ,Category.BIOLOGY);
        addQuestion(q24);
        Question q25 = new Question("Transmission of the malaria parasites is effected through the bite of the", "A: Male anopheles mosquito ", "B: infected male anopheles mosquito ", "C: Female anopheles mosquito ","D: infectes female anopheles mosquito ",4 , Category.BIOLOGY);
        addQuestion(q25);
        Question q26 = new Question("Blood group and tongue-rolling are example of", "A: Continous variation ", "B: Discontinous variation", "C: Sex-linked variation ","D: adaptive radiation ",2, Category.BIOLOGY );
        addQuestion(q26);
        Question q27 = new Question("One of the following is not an organ", "A: Adipose", "B: Leaf", "C: heart ","D: Flower ",1 ,Category.BIOLOGY );
        addQuestion(q27);
        Question q28 = new Question("Azotobacter can be found in the____ of legumes", "A: Root nodules ", "B: stem internodes ", "C: Leaves","D: fruits ",1, Category.BIOLOGY );
        addQuestion(q28);
        Question q29 = new Question("A species is a group of organism whose members are ", "A: Capable of symbiotic life ", "B: Capable of freely interbreeding ", "C: capable of occupying thesame niche ","D: Capable of resisting enemies attack",2, Category.BIOLOGY );
        addQuestion(q29);
        Question q30 = new Question("The man who disproved the theory of spontaneous generation of life was", "A: Robert hooke ", "B: Louis pasteur ", "C: Robert Clerk ","D: Charles darwin ", 2 ,Category.BIOLOGY);
        addQuestion(q30);
        Question q31 = new Question("The gall bladder of a mmal has a duct connected to the ", "A: Duodenum ", "B: Liver ", "C: Pancreas ","D: Small intestine ",2  ,Category.BIOLOGY);
        addQuestion(q31);
        Question q32 = new Question("Tsetse fly is harmful to man because it is associated with the spread of", "A: River blindness ", "B: malaria ", "C: Sleeping sickness ","D: Leprosy ", 3 ,Category.BIOLOGY );
        addQuestion(q32);
        Question q33 = new Question("The opening of the stoma is controlled by the ", "A: Presence of guard cells ", "B: decrease in solute concentration in the guard cells ", "C: increase in solute concentration in guard cells ","D: presence of a pore ",1, Category.BIOLOGY );
        addQuestion(q33);
        Question q34 = new Question("The function of the loop of Henle is to:", "A: Increase the flow of urine ", "B: Concentrate amino acids in the kidney tissue ", "C: Concentra sodium chloride in the medulla of the kidney ","D: Increase the volume of urine",3 ,Category.BIOLOGY );
        addQuestion(q34);
        Question q35 = new Question("Which of the following relationships involves only one organism", "A: Saprophytism ", "B: Commensalism ", "C: parasitism ","D: Symbiosis ",1 ,Category.BIOLOGY );
        addQuestion(q35);
        Question q36 = new Question("If a nursing mother is not producing enough milk, her hormonal system is probably deficient in", "A: Testosterone ", "B: Thyroxin", "C: Insulin ","D: Prolactin ",4 ,Category.BIOLOGY );
        addQuestion(q36);
        Question q37 = new Question("The organ responsible for the production of insulin is", "A: liver ", "B:pancreas ", "C: Gall bladder ","D: Kideney", 2, Category.BIOLOGY);
        addQuestion(q37);
        Question q38 = new Question("Plants adapted for life in salty marsh are called", "A: Hydrophytes ", "B: Xerophytes ", "C: halophytes ","D: Epiphytes ",3 ,Category.BIOLOGY );
        addQuestion(q38);
        Question q39 = new Question("The processs of deamination is essential for the ", "A: Digestion of protein ", "B: Secretion of bile ", "C: formation of urea ","D: Formation of antibody ",3 ,Category.BIOLOGY );
        addQuestion(q39);
        Question q40 = new Question("During binary fission in lower organisms, the nucleus is known to undergo: ", "A: Mitosis ", "B: Meiosis ", "C: fragmentation ","D: Mutation ",1, Category.BIOLOGY );
        addQuestion(q40);
        Question q41 = new Question("In which of the following groups of animals is the Malphigian tubule found?", "A: Lizard, snake and frog ", "B: Crickets, house flies and grasshoppers ", "C: millipedes, centipedes and scorpion ","D: Earthworms, roundworms and flatworms", 2 ,Category.BIOLOGY );
        addQuestion(q41);
        Question q42 = new Question("The function of lenticle is :", "A:To remove excess water in plant ", "B: To absorb water from the atmosphere ", "C: For gaseous exchange ","D: to store food ", 3, Category.BIOLOGY );
        addQuestion(q42);
        Question q43 = new Question("Paternity disputes can most accurately be resolved through the us of", "A: DNA analysis ", "B: Fingerprinting ", "C: Tongue-rolling ","D: Blood group typing ", 1, Category.BIOLOGY );
        addQuestion(q43);
        Question q44 = new Question("The complex relationship between the members of a community and between the community as a whole and its physical environment is", "A: Ecosystem ", "B: Habitat ", "C: Niche ","D: Microhabitat ",1, Category.BIOLOGY );
        addQuestion(q44);
        Question q45 = new Question("A carrier of the hereditary character in plants and animals is the ", "A: Cell ", "B: Nucleus ", "C: gene ","D: Chloroplast ",2, Category.BIOLOGY );
        addQuestion(q45);
        Question q46 = new Question("A gland in the human body secretes two hormones, one of which causes a disease called diabetes when there is a deficiency. which of these organs producces the hormones", "A: Parathyroid ", "B: Adrenal body ", "C: Thyroid","D: Pancreas",4, Category.BIOLOGY );
        addQuestion(q46);
        Question q47 = new Question("Identical twins inherit their genes from", "A: one egg and two sperms ", "B: two eggs and a sperm ", "C: the same egg and sperm ","D: different eggs and sperms ",3 ,Category.BIOLOGY );
        addQuestion(q47);
        Question q48 = new Question("The element nitrogen is utilized in", "A: Formation of ATP ", "B: Formation of glucose ", "C: Formation of amino acids ","D: Photosynthesis ", 3 ,Category.BIOLOGY);
        addQuestion(q48);
        Question q49 = new Question("The joint between the atlas and the axis vertebrate allows for ", "A: Rotary movements only ", "B: Up and down or nodding movements only ", "C: Rotary and nodding movements ","D: No movement at all ",1, Category.BIOLOGY );
        addQuestion(q49);
        Question q50 = new Question("The amount of water loss from a leaf can be detected using", "A: lime water ", "B: Red litmus paper ", "C: Blue litmus paper ","D: Blue cobalt chloride paper ",4, Category.BIOLOGY );
        addQuestion(q50);


        //PHYSICS QUESTIONS

        Question q51 = new Question("Which of the following is not a vector quantity", "A: Force ", "B: Altitude", "C: Weight ", "D: Displacement  ",2, Category.PHYSICS );
        addQuestion(q51);
        Question q52 = new Question("The force with which an object accelerated to the earth is called its", "A: Acceleration ", "B: Mass ", "C: Gravity ", "D:Weight ",4, Category.PHYSICS );
        addQuestion(q52);
        Question q53 = new Question("If the relative density of a metal is 19, what will be the mass of 20cm3 of the metal when immersed in water", "A: 380g ", "B: 400g ", "C: 360g ", "D:180g ",1, Category.PHYSICS );
        addQuestion(q53);
        Question q54 = new Question("Which of the following is correct about liquid pressure is NOT correct", "A: At a point in a liquid is proportional to the depth ", "B: At any point in a liquid is the same at the same level ", "C: Is exerted equally in all directions at any point.Brick ", "D: ",3, Category.PHYSICS );
        addQuestion(q54);
        Question q55 = new Question("A ship travel towards a cliff receives the echo of its whistle after 3.5seconds. A short while later, it receives the echo after 2.5 seconds, if the speed of sound in air under prevailing conditions is 250ms^-1, how much closer is the ship to the cliff", "A: 10m ", "B: 125m ", "C: 175m ", "D: At a particular depth depends on the vessel ",4, Category.PHYSICS );
        addQuestion(q55);
        Question q56 = new Question("The range of wave of a visible spectrum is 400nm - 700nm, the wavelength of gamma rays is ", "A: Longer than 700nm ", "B: Shorter than 700nm but longer than 400nm ", "C: 550nm", "D: infinite ",3, Category.PHYSICS );
        addQuestion(q56);
        Question q57 = new Question("if the pressure on 100cm^3 of an ideal gas is doubled while its Kelvin(K) temperature is halved, then the new volume of the gas will become", "A: 25cm^3 ", "B: 50cm^3 ", "C: 100cm^3 ", "D:400cm^3 ",1, Category.PHYSICS );
        addQuestion(q57);
        Question q58 = new Question("A train has an initial velocity of 44m/s and an acceleration of -4m/s^2. its velocity after 10s is", "A: 2m/s ", "B: 4m/s ", "C: 8m/s ", "D: 12m/s ",2, Category.PHYSICS );
        addQuestion(q58);
        Question q59 = new Question("A man of mass 50kg ascends a flight of stairs 5m high in 5 seconds. if acceleration due to gravity is 10ms^2, the power expanded is ", "A: 100W  ", "B: 300W ", "C: 250W ", "D: 500W ",4, Category.PHYSICS );
        addQuestion(q59);
        Question q60 = new Question("Which of the following arrangements in the sequence shown can be used to obtain a pure spectrum of white light", "A: Source, slit, converging lens, prism, screen ", "B: source, slit, diverging lens, screen ", "C: source, converging lens, prism, diverging lens, screen ", "D: source, slit, prism, diverging lens ",1, Category.PHYSICS );
        addQuestion(q60);
        Question q61 = new Question("The linear expansitivity of brass is 2 X 10^-1 K^-1. If the volume of a pieces of brass is 100cm^3 at 00C, what will be its volume at 1000C", "A: 10.02cm^3 ", "B: 10.04cm^3 ", "C: 10.06cm^3 ", "D: 10.20cm^3 ",3, Category.PHYSICS );
        addQuestion(q61);
        Question q62 = new Question("The electrochemical equivalent of a metal is 0.126 X 10-6kg/C. The mass of the metal that a current od 5A deposit from a suitable bath in 1 hour is ", "A: 0.0378 x 13^3kg ", "B: 0.227 x 103kg ", "C: 0.378 x 10^3kg ", "D: 2.268 x 10^3kg ",4, Category.PHYSICS );
        addQuestion(q62);
        Question q63 = new Question("Ripples on water are similar to light waves in that they both", "A: Have same wavelength ", "B: Are longitudinal ", "C: Cannot be reflected ", "D: can be refracted and diffracted  ",4, Category.PHYSICS );
        addQuestion(q63);
        Question q64 = new Question("A piece of wood is floating on water, the force acting on the wood are ", "A: Upthrust and reaction ", "B: Weight and reaction ", "C: weight and upthrust ", "D: weight and viscosity ",3, Category.PHYSICS );
        addQuestion(q64);
        Question q65 = new Question("Of the following derived units, the one that is not unit of power is", "A: Joule/second ", "B: Ampere/Volt ", "C: Amphere2/volt ", "D: ohm2/volt ",3, Category.PHYSICS );
        addQuestion(q65);
        Question q66 = new Question("A force of 16N applied to a 4.0kg block that is at rest on a smooth horizontal surface. what is the velocity of the block at time = 5 seconds?", "A: 4m/s ", "B: 10m/s ", "C: 20m/s ", "D: 50m/s ",3, Category.PHYSICS );
        addQuestion(q66);
        Question q67 = new Question("1,000 identical drop of oil of density 5000kg/m^3 have a total mass of 5 x 10-4kg. One of the drops form a thin film of area 0.5m^2 on water. The thickness of the film is ", "A: 2 x 10^-8m ", "B: 2 x 10^-9m ", "C: 2 x10^-7m ", "D: 3 x10^-9m ",2, Category.PHYSICS );
        addQuestion(q67);
        Question q68 = new Question("The total length of a spring when a mass of 200g is hung from its end is 14cm, while its total length is 16cm when a mass of 30kg is hung from the same end. Calculate the unscratched length of the spring assuming Hook's law is obeyed", "A: 9.33cm ", "B: 10.00cm", "C: 10.66cm", "D: 12.00cm ",2, Category.PHYSICS );
        addQuestion(q68);
        Question q69 = new Question("A short response time is obtained in a liquid-in glass thermometer when the ", "A: Bulb is large and thick-walled ", "B: Stem is long and thin ", "C: Bulb is small and thick-walled ", "D: Bulb is thin walled and the liquid is a good conductor of heat ",4, Category.PHYSICS );
        addQuestion(q69);
        Question q70 = new Question("A machine has a velocity ration of 5. it requires a 50kg weight to overcome a 200kg weight. The efficiency is", "A: 4%  ", "B: 5%", "C: 40% ", "D: 80% ",4, Category.PHYSICS );
        addQuestion(q70);
        Question q71 = new Question("If the normal atm pressure in a laboratory supports a column of mer" +
                "cury 0.76m high and the relative density of mecury is 13.8, then the height of water column which amt pressure will support in the same laboratory at the same time is", "A: 0m ", "B: 10m ", "C: 13m ", "D: 18m ",4, Category.PHYSICS );
        addQuestion(q71);
        Question q72 = new Question("An electric current of 3A flowing through an electric heating element of resistance 20 embedded in 1,000g of oil raises the temperature of the oil by 100C in 10s, then the specific heat capacity of oil is", "A: 1.8J/g ", "B: 0.6J/g ", "C: 0.18J/g ", "D: 1.8J/g degree Celsius ",3, Category.PHYSICS );
        addQuestion(q72);
        Question q73 = new Question("The difference of potential between the terminals of a cell is 2.2volts. when a 4 ohm resistor is connected accross the terminals of this cell, the potential difference is 2 volts. what is the internal resistance of the cell", "A: 0.01 ohms ", "B: 0.25 ohms ", "C: 0.04ohms ", "D: 2.50 ohms ",3, Category.PHYSICS );
        addQuestion(q73);
        Question q74 = new Question(" Four equal resistor R1,R2,R3 and R4 are connected in series  V1,V2,V3, and v4 are voltmeter connected as indicated. which of the following relations is CORRECT", "A:  V1=V3=V2", "B: V1=2V2=V3 ", "C: V1= 1/2V3=V2 ", "D: V1-V3=V2 ",1, Category.PHYSICS );
        addQuestion(q74);
        Question q75 = new Question("The speed of light in vacuum is 3.0 x 108ms-1. if the refractive index of a transparent liquid is 4/3 then the speed of light in the liquid is ", "A: 0.44 x 108ms^-1", "B: 2.25 x108ms^-1 ", "C 3.0 x 108ms^-1: ", "D: 4.0 x 108ms^-1 ",2, Category.PHYSICS );
        addQuestion(q75);
        Question q76 = new Question("if the force on a charge of 0.2 coulomb in an electric field is 4N, then the electric field intensity of the fluid is", "A: 0.8 ", "B: 0.8N/C ", "C: 20.0N/C ", "D: 4.2N/C ",3, Category.PHYSICS );
        addQuestion(q76);
        Question q77 = new Question("The specific latent heat of vaporization of a substance is always", "A: Less than its specific latent heat of fusion ", "B: Greater than its specific heat of fusion ", "C: Equal to its specific latent heat of fusion ", "D: All of the above depending on the nature of the substance ",4, Category.PHYSICS );
        addQuestion(q77);
        Question q78 = new Question("Longitudinal waves do not exhibit", "A: Refraction ", "B: Reflection ", "C: Diffraction ", "D: polarization ",4, Category.PHYSICS );
        addQuestion(q78);
        Question q79 = new Question(" The distance travelled by a particle starting from rest is plotted against a square of the time elapsed from the commencement of motion. The resulting graph is linear. The slope of this graph is measure of", "A: Initial displacement ", "B: initial velocity ", "C: Acceleration ", "D: Half the acceleration",4, Category.PHYSICS );
        addQuestion(q79);
        Question q80 = new Question("What volume of alcohol with a density of 8.4 x 102kg m^2 will have the same mass as 4.2m^3 of petrol whose density is 7.2 x 102kg m^3", "A: 1.4m^3 ", "B: 3.6m^3 ", "C: 4.9m^3 ", "D: 5.0m^3 ",2, Category.PHYSICS );
        addQuestion(q80);
        Question q81 = new Question("For correcting long sight defects in the human eye we required a ", "A: Converging lense ", "B: Diverging lense ", "C: Microscope ", "D: periscope ",1, Category.PHYSICS );
        addQuestion(q81);
        Question q82 = new Question("For a concave mirror to form a real diminished image, the object must be placed ", "A: Behind the mirror ", "B: Between the mirror and focus ", "C: Between the focus and the center of curvature ", "D: At a distance greater than the radius of curvature ",4, Category.PHYSICS );
        addQuestion(q82);
        Question q83 = new Question("The unit quantity of electricity is called ", "A: The ampere ", "B: the volt ", "C:  The coulomb ", "D:The ammeter ",3, Category.PHYSICS );
        addQuestion(q83);
        Question q84 = new Question("The resistance of a wire depends on", "A: The length of the wire", "B: the diameter of the wire ", "C: The temperature of the wire ", "D: All of the above ",4, Category.PHYSICS );
        addQuestion(q84);
        Question q85 = new Question("Which of the following component is NOT contained in a dry cell", "A: Carbon rod ", "B: Paste of magnesium dioxide ", "C: paste of ammonium chloride ", "D: copper rod ",4, Category.PHYSICS );
        addQuestion(q85);
        Question q86 = new Question("Which of the following can be described as high tension transmission", "A: High resistance and low voltage ", "B: Low current and high voltage ", "C: High current and low voltage ", "D: High voltage and zero current",2, Category.PHYSICS );
        addQuestion(q86);
        Question q87 = new Question("All the heat generated in a 5 ohms resistor by 2A flowing for 30s is used to evaporate 5g of liquid at its boiling point. which of the following is the correct value of the specific latent het of the liquid", "A: 120J ", "B: 60Jg^-1", "C: 120 Jg^-1 ", "D: 1500J ",3, Category.PHYSICS );
        addQuestion(q87);
        Question q88 = new Question("When vibration occurs in an air column, the distance between a node and an anti-nodes is equal to ", "A: One-quarter of the wavelength ", "B: One-half of the wavelength ", "C: The wavelength ", "D: Twice the wavelength ",1, Category.PHYSICS );
        addQuestion(q88);
        Question q89 = new Question("Of two identical turning forks with natural frequency 256Hz, one is loaded so that 4 beats per second are heard when they are sounded together. wht is the frequency of the loaded turning fork ", "A: 260Hz ", "B: 252 Hz  ", "C: 248Hz  ", "D: 264Hz ",2, Category.PHYSICS );
        addQuestion(q89);
        Question q90 = new Question("Dew point is the temperature at which water vapour in the atmosphere", "A: Turns into steam  ", "B: solidifies into ice pellets  ", "C: First condenses into liquid form  ", "D: Is just sufficient to cause cooling ",3, Category.PHYSICS );
        addQuestion(q90);
        Question q91 = new Question("The lower and upper fixed points marked on a mercury-in-glass thermometer are 210mm apart. The end of the mercury column in the tube is 49mm above the lower fixed point in a room. what is the temperature of the room in degrees celsius", "A:55.3 oC  ", "B: 23.3 oC  ", "C: 49.0 oC  ", "D:16.1 oC ",2, Category.PHYSICS );
        addQuestion(q91);
        Question q92 = new Question("If a solid changes directly into a gas when heat is applied the process is called", "A: Vaporization  ", "B: Evaporation ", "C: Sublimation ", "D: Conversion ",3, Category.PHYSICS );
        addQuestion(q92);
        Question q93 = new Question("A plane inclined at an angle of 300 to the horizontal has an efficiency of 60%. The force parallel to the plane required to push a load of 120N uniformly up the plane is ", "A: 60N  ", "B: 100n ", "C: 120N ", "D: 200N ",2, Category.PHYSICS );
        addQuestion(q93);
        Question q94 = new Question("A body of mass 5kg initially at rest is acted upon by two mutually perpendicular force 12N and 5N. if the particle moves in the direction QA calculate the magnitude of the acceleration", "A: 0.40ms^2  ", "B:1.40ms^2  ", "C: 0.26ms^2 ", "D: 2.60ms^2 ",4, Category.PHYSICS );
        addQuestion(q94);
        Question q95 = new Question("A particle moves in a circular orbit of radius 0.02m. if the speed of the particle is 0.88ms-1, calculate its frequency in cycles per second", "A: 2.0  ", "B:  7.0 ", "C: 8.8  ", "D: 17.6 ",2, Category.PHYSICS );
        addQuestion(q95);
        Question q96 = new Question("A given mass of an ideal gas occupies a volume v at a temperature t and under pressure p. If the pressure is increased to 2P and the temperature reduced to 1/2T , then the percentage change in the volume of the gas id ", "A: 0%  ", "B: 25%  ", "C: 75%  ", "D: 300% ",3, Category.PHYSICS );
        addQuestion(q96);
        Question q97 = new Question("Which of the following properties of matter CANNOT be utilized for temperature measurement? The", "A: Length of a liquid column  ", "B: Volume of a gas constant pressure  ", "C: Pressure of a gas at constant volume ", "D: Current produced in a photoelectric current ",4, Category.PHYSICS );
        addQuestion(q97);
        Question q98 = new Question("The electromotive force EMF obtained from a simple dynamo may be increased by", "A: increasing the cross-section area of the coil  ", "B: Winding the coil on a soft-iron armature so as to increase the magnetic flux through the coil  ", "C: Increasing the speed of rotation ", "D: Making the field magnet longer ",3, Category.PHYSICS );
        addQuestion(q98);
        Question q99 = new Question("Normal atmospheric pressure at sea-level is 105nm^-2 and the acceleration due to gravity is approximately 10ms s^-1. If the atmosphere has a uniform density of 1Kgm^-3, its length is ", "A: 100m  ", "B: 1000m  ", "C: 10,000m  ", "D: 100,000m ",3, Category.PHYSICS );
        addQuestion(q99);
        Question q100 = new Question("Which of the following is correct explanation of the inertia of a body", "A: Ability to overcome the earth's gravity  ", "B: Reluctance to stop moving  ", "C: Reluctant to start moving and its readiness to stop moving once it has begun to move  ", "D: Reluctant to start moving and its reluctant to stop moving once it has begun to move ",4, Category.PHYSICS );
        addQuestion(q100);


        // Chemistry Questions

        Question q101 = new Question("A compound with molecular formula Fe2(so4) would be called", "A:Ferrous sulphate ", "B: iron(ii) sulphate", "C: iron (iii) sulphite","D: iron (iii) sulphate", 4, Category.CHEMISTRY);
        addQuestion(q101);
        Question q102 = new Question("A_____ is an element whose atoms are ionize by electron loss", "A: Metal", "B: Non-metal", "C: Conductor","D: Non-conductor", 1, Category.CHEMISTRY);
        addQuestion(q102);
        Question q103 = new Question("The characteristics of Alcohol include all except one", "A: It wet glass", "B: Low boiling point", "C: High expansivity","D: Poor conductivity", 4,Category.CHEMISTRY);
        addQuestion(q103);
        Question q104 = new Question("High melting pont, high boiling point, malleability and ductivity are characteristics of", "A: Non metal", "B: UV rays", "C: Electrolysis","D: Ionization", 3, Category.CHEMISTRY);
        addQuestion(q104);
        Question q105 = new Question("_____ is a process of converting an atom or molecules into an ion", "A: Conduction", "B: Oxidation", "C: Electrolysis","D: ionization", 4, Category.CHEMISTRY);
        addQuestion(q105);
        Question q106 = new Question("The periodic classification of elemnts is an arrangement of the elements in order of their ", "A: Atomic weight ", "B: Isotope weights ", "C: Molecular weight ","D: Atomic Numbers ", 4, Category.CHEMISTRY);
        addQuestion(q106);
        Question q107 = new Question("The efficiency of petrol as a fuel in high compression internal combustion engines improves with an increase in the amount of ", "A: Branded chain alkanes ", "B: straight chain alkanes ", "C: Cycloakanes ","D: halogenated hydrocarbons ", 1, Category.CHEMISTRY);
        addQuestion(q107);
        Question q108 = new Question("The chemical symbol for manganese is", "A: Mn", "B: Mo ", "C: Ma ","D: Mg ", 1, Category.CHEMISTRY);
        addQuestion(q108);
        Question q109 = new Question("Identify the incorrect statement", "A: Helium in a balloon: an element ", "B: Pain: a mixture ", "C: Tap water: a compound ","D: Mercury in a barometer ", 3, Category.CHEMISTRY);
        addQuestion(q109);
        Question q110 = new Question("A basic postulate of the kinetic theory of gases is that the molecule of a gas in straight line between collisions. This implies that ", "A: Collision are perfectly elastic ", "B: Forces if repulsion exist ", "C: Forces  of repulsion and attraction are in equilibrium ","D: Collision are inelastic ", 1, Category.CHEMISTRY);
        addQuestion(q110);
        Question q111 = new Question("Which of the following terms indicates the number of bonds that can be formed by an atom", "A:  Oxidation number", "B: Valence ", "C: Atomic number ","D: Electronegativity ", 2, Category.CHEMISTRY);
        addQuestion(q111);
        Question q112 = new Question("How many milligrams are in 0.2 decigrams?", "A: 20 milligrams", "B: 2000 milligrams", "C: 0.002 milligrams","D: 0.00002milligrams", 1, Category.CHEMISTRY);
        addQuestion(q112);
        Question q113 = new Question("_______ is a compound formed when all the replaceable hydrogen ion of an acid is replace by metallic ion", "A: acid", "B: base", "C: salt","D: solute", 3, Category.CHEMISTRY);
        addQuestion(q113);
        Question q114 = new Question("Addition of dilute hydrochloric acid to an aqueous of a crystalline salt yielded a yellow precipitate and a gas which turned dichromate paper green. the crystalline salt was probably", "A: Na2So4", "B: Na2S", "C: NaS2o45H2","D:NaCo3 ", 2, Category.CHEMISTRY);
        addQuestion(q114);
        Question q115 = new Question("The process involved in the conversion of an oil into margarine is known as", "A: Hydrogenation", "B: Condensation", "C: hydrolysis","D: Dehydration", 1, Category.CHEMISTRY);
        addQuestion(q115);
        Question q116 = new Question("Which of the following is an example of a chemical change", "A: Dissolution of salt water ", "B: Rusting of iron ", "C: Melting of ice ","D: Separating a mixture by distillation ", 2, Category.CHEMISTRY);
        addQuestion(q116);
        Question q117 = new Question("____ is a process of conversion an atom or molecule into an ion", "A: Conduction", "B: Oxidation", "C: Electrolysis","D: Ionization", 4, Category.CHEMISTRY);
        addQuestion(q117);
        Question q118 = new Question("When sodium chloride and metallic sodium are each dissolved in water", "A: both processes are exothermic ", "B: both processes are endothermic ", "C: the dissolution of metallic sodium is endothermic ","D: the dissolution of metallic sodium is exothermic ", 4, Category.CHEMISTRY);
        addQuestion(q118);
        Question q119 = new Question("Which of the following is produced during the formation of photochemical smog", "A: Nitrogen oxides", "B: Hydrocarbons", "C: Methane","D: Ozone", 4, Category.CHEMISTRY);
        addQuestion(q119);
        Question q120 = new Question("The oxidation state of chlorine in potassium chlorate is ", "A:  +1", "B: +2 ", "C: +3 ","D: +5", 4, Category.CHEMISTRY);
        addQuestion(q120);
        Question q121 = new Question("Alloys made with mercury as on metals are called", "A: Mixtures", "B: Emulsions ", "C: Solders","D: amalgams",4 , Category.CHEMISTRY);
        addQuestion(q121);
        Question q122 = new Question("Which of these have maximum density", "A: Water", "B: Benzene", "C: Ice","D: Chloroform", 1, Category.CHEMISTRY);
        addQuestion(q122);
        Question q123 = new Question("pH of water is _____", "A: 5", "B: 6", "C: 7","D: 8", 3, Category.CHEMISTRY);
        addQuestion(q123);
        Question q124 = new Question("_______ is a compound formed when all the replaceable hydrogen of an acid is replace by metallic ion", "A: Acid", "B: Base", "C: Salt","D: Solute", 3, Category.CHEMISTRY);
        addQuestion(q124);
        Question q125 = new Question("How many valence electrons does an oxygen atom have", "A: 2", "B:6 ", "C: 8","D: 16", 2, Category.CHEMISTRY);
        addQuestion(q125);
        Question q126 = new Question("Florine atoms tend to___ when they form chemical compounds with metal", "A: Lose electrons", "B: Gains electrons", "C: neither lose nor gain electrons.....they usually share electrons equally with metals","D: Florine atoms do not form compounds with other", 2, Category.CHEMISTRY);
        addQuestion(q126);
        Question q127 = new Question("which of the following is true of alkalies", "A: They have a sour taste", "B: They liberates ammonia when added to ammonium chloride ", "C: Their pH is 7","D: They turn phenolphthalein colourless", 2, Category.CHEMISTRY);
        addQuestion(q127);
        Question q128 = new Question("Real gases do noty obey the ideal gas law at", "A: High temperature", "B: Low temperature and high pressure", "C: Low pressure","D: High temperatures and pressure", 4, Category.CHEMISTRY);
        addQuestion(q128);
        Question q129 = new Question("The identity of an element is determined by", "A: The number of its protons", "B: The number of its neutrons", "C: the number of its electrons","D: its atomic mass", 1, Category.CHEMISTRY);
        addQuestion(q129);
        Question q130 = new Question("Which of the following planets contains a large amount of solid methane", "A: jupiter", "B: Neptune", "C: Pluto","D: Saturn", 2, Category.CHEMISTRY);
        addQuestion(q130);
        Question q131 = new Question("Nuclear reactions can be used in the following except", "A: Gauging the thickness of objects", "B: Making atomic bombs", "C: Charging","D: Generating electricity", 3, Category.CHEMISTRY);
        addQuestion(q131);
        Question q132 = new Question("What changes will occur during the electrolysis of brine using carbon electrodes", "A: Chlorine will be given off at the cathode", "B: Oxygen gas will be given off a the anode", "C: Sodium will be deposited at the cathode","D: The volumes of hydrogen and chrome given of at the same time are equal", 2, Category.CHEMISTRY);
        addQuestion(q132);
        Question q133 = new Question("Which of the following is a good conductor of electric current", "A: Mixture of petrol an kerosene ", "B: Aqueous solution of sugar", "C: Mixture of ethanol and water","D: Aqueous solution of table salt", 4, Category.CHEMISTRY);
        addQuestion(q133);
        Question q134 = new Question("The pH value of an aqueous solution of compounds remains at contaminated with small quantity of acid or alkali. which one of compound would produce such a solution", "A: Aqueous Ammonia and ammonium chloride", "B: Methanoic acid and sodium ethanoate", "C: Hydrochloric acid and sodium chloride","D: potassium hydroxide and potassium bromide", 1, Category.CHEMISTRY);
        addQuestion(q134);
        Question q135 = new Question("", "A: ", "B: ", "C: ","D: ",2 , Category.CHEMISTRY);
        addQuestion(q135);
        Question q136 = new Question("one of the properties is unique to carbon alone", "A: Polymerization", "B: Condensation", "C: Carnation","D: Hydrogenation", 3, Category.CHEMISTRY);
        addQuestion(q136);
        Question q137 = new Question("Zinc oxide is a", "A:Basic oxide ", "B: Acidic oxide ", "C: Amphoteric oxide ","D: Neutral Oxide ", 3, Category.CHEMISTRY);
        addQuestion(q137);
        Question q138 = new Question("An organic compound decolorized acidified KMnC4 solution hut failed to react with ammonical silver nitrate solution the organic compound is likely to be", "A: a carbonxyllic acid ", "B: an alkane ", "C: an alkene ","D: an alkanone ", 4, Category.CHEMISTRY);
        addQuestion(q138);

        Question q139 = new Question("If a solid changes directly into a gas when heat is applied, the process is called", "A: Vaporization", "B Evaporation: ", "C: Sublimation","D:  Ionization", 3, Category.CHEMISTRY);
        addQuestion(q139);
        Question q140 = new Question("Which of the following compounds would have the highest boiling point", "A:CH3CH2CH2CH3 ", "B:CH3NH2 ", "C: CH3OHCH","D: CH2F2",3, Category.CHEMISTRY );
        addQuestion(q140);
        Question q141 = new Question("The ammonium compound used in the manufacturing of dry cell is", "A:NH4C1 ", "B: NH4NO", "C:(NH4)2NO2 ","D: (NH4)2SO4", 1, Category.CHEMISTRY);
        addQuestion(q141);
        Question q142 = new Question("Which of the noble gases has no 'p' orbital?", "A: Neon", "B: Argon", "C: Helium","D: Krypton", 3, Category.CHEMISTRY);
        addQuestion(q142);
        Question q143 = new Question("A compound 'X' has all of the following properties. It is liquid at the room temperature and atmospheric pressure, it does not mix completely with water, it does not decolorize acidified potassium manganate (VII). what could 'X' be?", "A: Ethane", "B: Ethanol", "C: Ethanoic acid","D: Ethylethanote", 3, Category.CHEMISTRY);
        addQuestion(q143);
        Question q144 = new Question("Under high pressure, real gases do not obey gas laws because molecules", "A: have become more energetic", "B: Are close together", "C: Have become smaller in size","D: Decompose into atoms", 2, Category.CHEMISTRY);
        addQuestion(q144);
        Question q145 = new Question("The alkanol obtained from the production of soap", "A: Ethanol", "B: Glycerol", "C: Methanol","D: Propanol", 1, Category.CHEMISTRY);
        addQuestion(q145);
        Question q146 = new Question("Two cylinders A and B each contains 30cm^3 of oxygen and nitrogen respectively at the same temperature and pressure, if there are 5.0 mole of nitrogen, then the mass of oxygen is ", "A: 3.2g ", "B: 6.4g ", "C: 80.0g","D:  160.0g", 3, Category.CHEMISTRY);
        addQuestion(q146);
        Question q147 = new Question("The colour imparted to a flame by calcium ion is", "A: Green", "B: Blue", "C: brick-red","D: yellow", 3, Category.CHEMISTRY);
        addQuestion(q147);
        Question q148 = new Question("Which of these metals Mg,Fe,Pb and Cu will dissolve in dilute HCL", "A: All the metals", "B: Mg,Fe and Cu", "C: Mg,fe and Pb","D: Mg and Fe only", 4, Category.CHEMISTRY);
        addQuestion(q148);
        Question q149 = new Question("Which of the following substances is a mixture", "A: Granulated sugar", "B: Sea-water", "C: Sodium chloride","D: iron fillings", 2, Category.CHEMISTRY);
        addQuestion(q149);
        Question q150 = new Question("The basicity of tetraoxosulphate (VI) acid is", "A:7 ", "B: 5", "C: 4","D: 2", 4, Category.CHEMISTRY);
        addQuestion(q150);



        //current affairs questions

        Question q151 = new Question("The highest court in Nigeria is_________", "A: Court of Appeal", "B: Supreme court", "C: Federal High court","D: Magistrate court", 2,Category.Current_Affairs);
        addQuestion (q151);
        Question q152 = new Question("State of Osun was created in the year______", "A: 1990", "B: 1987", "C: 1991","D: 1993", 3,Category.Current_Affairs);
        addQuestion (q152);
        Question q153 = new Question("The name of Nigeria was coined out of ___________", "A: NIger forest", "B: Niger river", "C: Niger area","D: Niger texture", 3,Category.Current_Affairs);
        addQuestion (q153);
        Question q154 = new Question("Nigeria became 36states unter the regime of ______", "A: Olusegun Obasanjo", "B: Sanni Abacha", "C: Ibrahim Babaginda","D: Yakubu Gowon", 4,Category.Current_Affairs);
        addQuestion (q154);
        Question q155 = new Question("Oil can be found in one of the following states", "A: Sokoto", "B: Anambra", "C: Ekiti","D: Ondo",2,Category.Current_Affairs );
        addQuestion (q155);
        Question q156 = new Question("Nigeria became in Republic in ______", "A: 1961", "B: 1960", "C: 1976","D: 1963", 1,Category.Current_Affairs);
        addQuestion (q156);
        Question q157 = new Question("The Northern and Southern protectorate was amalgamated in ______", "A: 1914", "B: 1919", "C: 1921","D: 900", 4,Category.Current_Affairs);
        addQuestion (q157);
        Question q158= new Question("The first woman to buy a car in nigeria was_______", "A: Mrs Efunroye Tinubu", "B: Mrs Foluke Ette", "C: Mrs Remi Tinubu","D: Mrs Abike Dabiri", 1,Category.Current_Affairs);
        addQuestion (q158);
        Question q159 = new Question("In Nigeria the slogan Bring back our Girls is as a result of___________", "A: Kidnapped of Sambissa school girls", "B: Kidnapped of Chibok school girls", "C: Kidnapped of Oiloibiri school girls","D: Kidnapped of Bama school girls", 2,Category.Current_Affairs);
        addQuestion (q159);
        Question q160 = new Question("The Honourable Commissioner for Education in the State of Osun is ______", "A: professor Bukola Oyawoye", "B: dr Temitope Ilori", "C: mr Kolawole Omotunde Young","D: Mr Sunday Akere", 3,Category.Current_Affairs);
        addQuestion (q160);
        Question q161 = new Question("The title of the state of Osun is ________", "A: Born to rule", "B: State of the living spring", "C: Food basket of the nation","D: Land of virtue", 4,Category.Current_Affairs);
        addQuestion (q161);
        Question q162 = new Question("How many local governments do we have in nigeria", "A: 700", "B: 776", "C: 774","D: 778", 3,Category.Current_Affairs);
        addQuestion (q162);
        Question q163 = new Question("The liberian currency is ________", "A: pound sterling", "B: yen", "C: Dollar","D: Euro", 3,Category.Current_Affairs);
        addQuestion (q163);
        Question q164 = new Question("The capital of Zamfara is ______", "A: Gosau", "B: Gusau", "C: Yenogoa","D: Yonagoa", 2,Category.Current_Affairs);
        addQuestion (q164);
        Question q165 = new Question("Crude oil was first discovered in _______", "A: Port Harcourt", "B: jalingo", "C: Oloibiri","D: Dutse", 3,Category.Current_Affairs);
        addQuestion (q165);
        Question q166 = new Question("How many members of Federal House of Representative do we have in Nigeria", "A: 346", "B: 356", "C: 360","D: 370", 3,Category.Current_Affairs);
        addQuestion (q166);
        Question q167 = new Question("The winner of the Brazil 2014 FIFA world cup is _________", "A: Germany", "B: Brazil", "C: Argentina","D: Netherlands", 1,Category.Current_Affairs);
        addQuestion (q167);
        Question q168 = new Question("_____ was the Nobel Laureate Prize winner in Nigeria in 1980", "A: Professor Chinua Achebe", "B: Professor Wole Soyinka", "C: Professor Sam Okoye","D: Prodfessor Amakalgwe", 2,Category.Current_Affairs);
        addQuestion (q168);
        Question q169 = new Question("The main reason for studying Economics is ____", "A: Chioce", "B: Scarcity", "C: Opportunity cost","D: Priority", 2,Category.Current_Affairs);
        addQuestion (q169);
        Question q170 = new Question("Organization of African Unity (OAU) now African union (AU) was founded in _____", "A: 1963", "B: 1960", "C: 1975","D: 1972", 2,Category.Current_Affairs);
        addQuestion (q170);
        Question q171 = new Question("The name of the INEC  Chairman is _____", "A: Professor mahmood Yakubu", "B: Professor Mahoood Yakubu", "C: Professor Maurice Iwu","D: Professor Godwin Emefiele", 2,Category.Current_Affairs);
        addQuestion (q171);
        Question q172 = new Question("How many geo-political zones do we have in Nigeria", "A: 8", "B: 7", "C: 6","D: 5", 3,Category.Current_Affairs);
        addQuestion (q172);
        Question q173 = new Question("Thermometer is for temperature, while _______ is for humidity", "A: Hygrometer", "B: Hydrometer", "C: Rain guage","D: barometer", 1,Category.Current_Affairs);
        addQuestion (q173);
        Question q174 = new Question("The solar system consists of how many planets", "A: 10", "B: 9", "C: 8","D: 7", 2,Category.Current_Affairs);
        addQuestion (q174);
        Question q175 = new Question("The full meaning of ICPC is ______", "A: Independent Corrupt Practices Council", "B: Independent Corrupt Practices Commission", "C: Independent Corrupt Practices and other related offence commission","D: Independent Corrupt Practices and other related offenses Council", 3,Category.Current_Affairs);
        addQuestion (q175);
        Question q176 = new Question("The first executive Governor of Osun state is ___", "A: Senator Isiaka Adeleke", "B: Chief Bisi Akande", "C: Prince Olagunsoye Oyinlola","D: Ogbeni Rauf Aregbesola", 1,Category.Current_Affairs);
        addQuestion (q176);
        Question q177 = new Question("The headquarters of ECOWAS is _______", "A: Addis Ababa, Ethiopa", "B: Accra Ghana", "C: Nairobi, Kenya","D: Abuja, Nigeria", 4,Category.Current_Affairs);
        addQuestion (q177);
        Question q178 = new Question("The current Central Bank of Nigeria is ______", "A: Professor Charles Chukwuma soludo", "B: Professor Sanusi Lamido Sanusi", "C: Mr Tony Elumelu","D: Mr Godwin Emefiele", 4,Category.Current_Affairs);
        addQuestion (q178);
        Question q179 = new Question("Which of these continents is the coldest in the world", "A: Asia", "B: Africa", "C: Antarctic","D: America", 3,Category.Current_Affairs);
        addQuestion (q179);
        Question q180 = new Question("Which is the name of the world's highest mountains?", "A: Mount Kilimanjaro", "B: Mount Everest", "C: Mount Camerron","D: Mount Nkoyo", 2 ,Category.Current_Affairs);
        addQuestion (q180);
        Question q181 = new Question("What name is the parliament of Nigeria called", "A: House of Representatives", "B: Senate", "C: State House of Assembly","D: National Assembly", 4,Category.Current_Affairs);
        addQuestion (q181);
        Question q182 = new Question("The parliament of the United States of America is called", "A: House of Parliament", "B: National assembly", "C: Congress","D: Assembly", 3,Category.Current_Affairs);
        addQuestion (q182);
        Question q183 = new Question("Cote d'ivoire is formerly known as", "A: Yamassokou", "B: Ivory coast", "C: Gold coast","D: Rhode coast", 2,Category.Current_Affairs);
        addQuestion (q183);
        Question q184 = new Question("The process of preservation, protection and wise use of natural resources", "A: Fermentation", "B: Preservation", "C: Conservation","D: Ecology",3,Category.Current_Affairs );
        addQuestion (q184);
        Question q185 = new Question("Ballet and Tango are types of ", "A: Song", "B: dancing", "C: Cycling","D: Swimming", 2,Category.Current_Affairs);
        addQuestion (q185);
        Question q186= new Question("Thje first to develop atomic bomb was", "A: Albert Einstein", "B: Charles De Gaulle", "C: Thomas Jefferson","D: T.S Elliot", 3,Category.Current_Affairs);
        addQuestion (q186);
        Question q187 = new Question("The process by which the people in a country is given an opportunity to elect, choose or reject new government id known as ", "A: Referendum", "B: Plebiscite", "C: Election","D: Ratification", 3,Category.Current_Affairs);
        addQuestion (q187);
        Question q188 = new Question("In which continent is Mount Everest", "A: Asia", "B: North America", "C: Africa","D: Europe", 1,Category.Current_Affairs);
        addQuestion (q188);
        Question q189 = new Question("The current Governor of Osun state is", "A: Prince Olagunsoye Oyinlola", "B: Senator Isiaka Adetunji Adeleke", "C: Ogbeni Rauf Aregbesola","D: Mr Rahman Aregbesola",3 ,Category.Current_Affairs);
        addQuestion (q189);
        Question q190 = new Question("The full meaning of EFCC is", "A: Economy and Financial Criminal Commission", "B: Economy and Financial Crimes Commission", "C: Economic and Financial Criminal Commission","D: Economic and Financial Crimes Commission", 4,Category.Current_Affairs);
        addQuestion (q190);
        Question q191 = new Question("The traditional title of the king of Ede is", "A: Olufi", "B: Timi", "C: Ataoja","D: Ajalaye", 2,Category.Current_Affairs);
        addQuestion (q191);
        Question q192 = new Question("The accolade for the new Osun stae Youth Empowerment Scheme is ", "A: apalara", "B: Omoluabi", "C: Omotoyayi","D: Ajisefini", 1,Category.Current_Affairs);
        addQuestion (q192);
        Question q193 = new Question("The name of the head of the Al Qaeda leader that was killed in Pakistan is", "A: Obama Bin Ladin", "B: Osama Bin Ladin", "C: Obama Bunn Ladin","D: Osama Bunn LDIN", 2,Category.Current_Affairs);
        addQuestion (q193);
        Question q194 = new Question("Who is the Emir of Kano?", "A: Emir Ibrahim Magu", "B: Emir Lamido Sanusi", "C: Emir Ahmed Gambari","D: Emir Abubakar Lamido", 2,Category.Current_Affairs);
        addQuestion (q194);
        Question q195 = new Question("Democracy Day is celebrated in Nigeria on", "A: May 1", "B: May 2", "C: May 27","D: May 29", 4,Category.Current_Affairs);
        addQuestion (q195);
        Question q196 = new Question("_______ designed the Nigerian flag", "A: ", "B: ", "C: ","D: ", 2,Category.Current_Affairs);
        addQuestion (q196);
        Question q197 = new Question("The following are past Senate Presidents in Nigeria", "A: Ken Nnamani", "B: David Mark", "C: Dimeji Bankole","D: Nnamdi Azikwe", 3,Category.Current_Affairs);
        addQuestion (q197);
        Question q198 = new Question("The first and highest rank in Nigeria is the", "A: Officer of the order of the Federal republic(OFR)", "B: Officer of the Order of the Niger (OON)", "C: Grand Commander of the order of the Federal Republic (GCFR)","D: Grand Commander of the order of the Niger (GCON)", 3,Category.Current_Affairs);
        addQuestion (q198);
        Question q199 = new Question("National Youth Service COrp was established in the year", "A: 1953", "B: 1963", "C: 1973","D: 1983",3, Category.Current_Affairs);
        addQuestion (q199);
        Question q200 = new Question("Who is the current Minister for Health", "A: Prof Isaac Adewole", "B: Dr. Osagie Ehanire", "C: Prof. Abubakar Malami","D: Dr. Amina Mohammed", 1,Category.Current_Affairs);
        addQuestion (q200);

        //MATHEMATICS



        Question q201 = new Question(" Simplify (2a+b)-(b-2a)2 ", "A: 6a ", "B: 5a ", "C: 9a ","D: 8a ", 4,Category.MATHEMATICS);
        addQuestion (q201);
        Question q202 = new Question(" The angle of Pentagon are x^0, 2x^0 , 3x^0, 2x^0 and (3x-10)^0 find the value of x ", "A: 300  ", "B: 400 ", "C: 500 ","D: 600",3 ,Category.MATHEMATICS);
        addQuestion (q202);
        Question q203 = new Question(" Solve for: x and y, 3y -2x = 21 and 4y +5x = 5 ", "A: x= -3, y= 5 ", "B: x= 6, y= 4  ", "C: x= 5, y= -4  ","D:x= 4, y= 2 ",1 ,Category.MATHEMATICS);
        addQuestion (q203);
        Question q204 = new Question(" Simplify Log 10^500 + Log10^2", "A: 2 ", "B: 3 ", "C: 4 ","D:5 ", 2,Category.MATHEMATICS);
        addQuestion (q204);
        Question q205 = new Question(" if A varies inversely as B and A = 2/3 when B =9, find the value of B when A = 3/4 ", "A: 8  ", "B:9/2 ", "C: 8/81  ","D: 1/8",1, Category.MATHEMATICS);
        addQuestion (q205);
        Question q206 = new Question(" Find the average of the first four prime numbers greater than 10  ", "A: 15  ", "B: 17 ", "C: 19 ","D: 20 ", 1,Category.MATHEMATICS);
        addQuestion (q206);
        Question q207 = new Question("The vale of x +x x(xx) when x = 2 is ", "A: 10  ", "B: 16 ", "C: 18 ","D: 36",1 ,Category.MATHEMATICS);
        addQuestion (q207);
        Question q208 = new Question(" The probability of Bola passing English and Math are x an y respectively. Find the probability of the boy failing both tests ", "A: 1-(x+y)-xy  ", "B: 1-(x+y)+xy  ", "C: 1-(x-y)+xy  ","D: 1-(x-y)-xy ",2 ,Category.MATHEMATICS);
        addQuestion (q208);
        Question q209 = new Question(" Which of the following is not a measure of dispersion ", "A: Variance  ", "B: Range  ", "C:  Standard deviation ","D: Mean ",4 ,Category.MATHEMATICS);
        addQuestion (q209);
        Question q210 = new Question(" The distance light travel in ine year is approximately 5,870,000,000,000miles. The distance light travels in 100 years is ", "A: 587 X 10^8 miles  ", "B: 587 X 10^10 miles  ", "C: 587 X 10^10 miles  ","D: 587 X 10^12 miles ",4 ,Category.MATHEMATICS);
        addQuestion (q210);
        Question q211 = new Question("Find the gradient of the equation 2y-5x+6=5  ", "A: +3  ", "B: 2.5  ", "C: -2.5 ","D: -3 ",2 ,Category.MATHEMATICS);
        addQuestion (q211);
        Question q212 = new Question(" y/100 of 480 is 24 fin y ", "A: 6 ", "B: 5 ", "C:3  ","D: 1 ", 2,Category.MATHEMATICS);
        addQuestion (q212);
        Question q213 = new Question(" Solve the equation 4p2 = 16p", "A: P=0 or 4   ", "B: P=0 or 2  ", "C: P= -2 or 2  ","D: P= -4 or 16 ",1 ,Category.MATHEMATICS);
        addQuestion (q213);
        Question q214 = new Question(" A man has $10,000 to invest. He invest $4000 at 5% and $3500 at 4% . In order to have a yearly income of $500, he must invest the remainder at ", "A:  6% ", "B: 6.1% ", "C: 6.2% ","D: 6.4%",4 ,Category.MATHEMATICS);
        addQuestion (q214);
        Question q215 = new Question("if 122y = 1710, find the value of y  ", "A: 4  ", "B: 3  ", "C: 2 ","D:1 ",2 ,Category.MATHEMATICS);
        addQuestion (q215);
        Question q216 = new Question(" Solve the equation: (0.25)x-1 = 16 ", "A: 2 ", "B: 1 ", "C: -3 ","D: -1",4 ,Category.MATHEMATICS);
        addQuestion (q216);
        Question q217 = new Question(" ATB bank had shares to sell to the general public of 50k at 5.50 per share. A man invested a total of #132,660. How many shares did he buy ", "A: 24120 ", "B: 13220 ", "C: 101210 ","D:9140 ",1 ,Category.MATHEMATICS);
        addQuestion (q217);
        Question q218 = new Question(" if (0.2)x = 2 and log 2 = 0.3010, then the value of x to the nearest tenth is: ", "A: -10.0 ", "B: -0.5 ", "C: -0.4 ","D:10.0 ", 3,Category.MATHEMATICS);
        addQuestion (q217);
        Question q219 = new Question(" if 103y = 25 then 10-y equals: ", "A: -1/5  ", "B: 1/625 ", "C: 1/50 ","D: 1/5 ",4 ,Category.MATHEMATICS);
        addQuestion (q219);
        Question q220 = new Question(" The fraction (5x-11)/ (2x2 + x -6) was obtained by adding the two fractions A/(x+2) and B/(2x-3) The value of A and B must be respectively ", "A: 5x,-11  ", "B: -11,5x  ", "C: -1, 3 ","D: 3, -1 ", 4 ,Category.MATHEMATICS);
        addQuestion (q220);
        Question q221 = new Question(" The sum of three numbers is 98. the ratio of the first to the second is 2/3 and the ratio of the second to the third is 5/8. The second number is   ", "A: 15  ", "B: 20 ", "C: 30 ","D: 32 ",3 ,Category.MATHEMATICS);
        addQuestion (q221);
        Question q222 = new Question(" At what angle would a concave mirror reflect a ray of light incident on it passing through the center of curvature of the mirror ", "A:  180 degrees ", "B: 45 degrees  ", "C: 0 degrees ","D:  8 degrees",2 ,Category.MATHEMATICS);
        addQuestion (q222);
        Question q223 = new Question("  if Logx(1/8) = -3/2, then x is equal to ", "A: -4 ", "B: 4 ", "C: 1/4 ","D: 10 ", 2,Category.MATHEMATICS);
        addQuestion (q223);
        Question q224 = new Question(" 20% of 2 is equal to  ", "A: 20 ", "B:  4", "C: 0.4 ","D: 0.04",3 ,Category.MATHEMATICS);
        addQuestion (q224);
        Question q225 = new Question(" Find the derivation of y = sin(2x2 + 3x-4) ", "A: -cos(4x+3)  ", "B: -(6x^2 +3) cos(2x^3+3x-4) ", "C: cos(2x^3+3x-4)  ","D: (6x^3+3) cos(2x^3+3) ",1 ,Category.MATHEMATICS);
        addQuestion (q225);
        Question q226 = new Question(" How many possible ways are there of seating seven people P,Q<R<S<T<U and V at regular table ", "A:  7 ", "B: 504 ", "C: 360 ","D: 2520", 1,Category.MATHEMATICS);
        addQuestion (q226);
        Question q227 = new Question(" The 3rd term of an arithmetic progression is -9 and 7th term is -29. find the 10th term of the progression ", "A: 165  ", "B: 44 ", "C: -44 ","D: -165",3 ,Category.MATHEMATICS);
        addQuestion (q227);
        Question q228 = new Question(" If the hypotenuse of a right angled isosceles triangle is 2, what is the length of each of the other side ", "A: 2 ", "B: ???2 ", "C: 2/2 ","D:  1",2 ,Category.MATHEMATICS);
        addQuestion (q228);
        Question q229 = new Question(" The factors of 6x-5-x^2 are ", "A: (x+3)(x+2)  ", "B: (x-5)(x-1) ", "C: -(x+5)(x+1)  ","D: (x-5)(1-x) ",4 ,Category.MATHEMATICS);
        addQuestion (q229);
        Question q230 = new Question(" How many grams of hydrogen gas will be liberated when 8g of magnesium ribbon dissolves in 500cm^3 of 6 M.Hcl? (Mg = 24, H=1, Cl =35.5) ", "A: 1.2g ", "B:  0.7g ", "C:  0.5g ","D:  0.12g",2 ,Category.MATHEMATICS);
        addQuestion (q230);
        Question q231 = new Question(" If Log4(x) = 12, then log 2(x/4 is equal to ) ", "A: 11 ", "B:  48 ", "C: -12 ","D: 22",4 ,Category.MATHEMATICS);
        addQuestion (q231);
        Question q232 = new Question(" F is a quadratic function whose graph is a parabola opening upward and has a vertex on the x-axis. The graph of the new function g defined by g(x) = 2 -f(x-5) has a range defined by the interval", "A:  [-5, + infinity) ", "B: [2, + infinity)  ", "C: (- infinity, 2]  ","D:( - infinity, 0] ",3 ,Category.MATHEMATICS);
        addQuestion (q232);
        Question q233 = new Question(" Simplify 0.000215 X 0.000028 and express your answer in standard form ", "A: 6.03 X 10^9  ", "B: 6.02 X 10^9  ", "C: 6.03 X 10^-9 ","D: 6.02 X 10^-9 ", 4,Category.MATHEMATICS);
        addQuestion (q233);
        Question q234 = new Question(" F is a function such that f(x) < 0. The graph of the new function g defined by g(x) = |f(x)| is a reflection of the graph of f ", "A:  On the y axis ", "B: on the x axis ", "C: on the line y = x ","D: on the line y = -1 ", 2,Category.MATHEMATICS);
        addQuestion (q234);
        Question q235 = new Question(" If the graph of y = f(x) is transformed into the graph of 2y-6= -4. f(x-3, point (a,b) on the graph  y = f(x) becomes point (A,B) on the graph of 2y-6 =-4f(x-3) where A and B are given by  ", "A: A=a-3, B=b  ", "B:  A=a+3 B=b ", "C:A= a+3, B=2b  ","D: A= a+3, B=2b+3 ",4 ,Category.MATHEMATICS);
        addQuestion (q235);
        Question q236 = new Question(" When a parabola represented by the equation y-2x^2 = 8x+5 is translated 3 units to the left and 2 units up, the new parabola has its vertex at  ", "A:(-5, -1)  ", "B: (-5, 5) ", "C: (-1, 3)  ","D:  (-2, -3", 1 ,Category.MATHEMATICS);
        addQuestion (q236);
        Question q237 = new Question(" The graph of the two equations y = ax2+bx+c and y = Ax^2 + Bx +c, such that a and A have different signs and that the quantities b2- 4ac and B 2-4AC are both negative ", "A: Intersect at two points ", "B: Intersect at one point  ", "C: do not intersect  ","D: none of the above ",3 ,Category.MATHEMATICS);
        addQuestion (q237);
        Question q238 = new Question(" The graph of the two linear equations ax-by = c and bx-ay=c where a, b and c are all not equal to zero  ", "A: are parallel ", "B: intersect at one point  ", "C: intersect at two points  ","D: perpendicular ",4 ,Category.MATHEMATICS);
        addQuestion (q238);
        Question q239 = new Question("  For x greater than or equal to zero and less than or equal to 2 pi, sinx and cos x are both decreasing on the intervals ", "A: (0, pi/2)  ", "B: (pi/2, pi)  ", "C: (pi, 3pi/2)  ","D: (3pi/2, 2pi) ",2 ,Category.MATHEMATICS);
        addQuestion (q239);
        Question q240 = new Question(" The three solutions of the equation f(x) = 0 are -2, 0 and 3 Therefore, the three solutions of the equation f(x-2) = 0 are  ", "A:  -4, -2 ", "B: -2,0 and 3 ", "C: 4,2 and 5 ","D: 0,2 and 5 ",4 ,Category.MATHEMATICS);
        addQuestion (q240);
        Question q241 = new Question(" The three solutions of the equation f(x) = 0 are -4,8 and 11, therefore, the three solutions of the equation f(2x) = 0 are  ", "A: -2,4 and 11/2 ", "B: -8,16 and 22  ", "C:  -4,8 and 11 ","D: 2,1/2 and 7/2 ",1 ,Category.MATHEMATICS);
        addQuestion (q241);
        Question q242 = new Question(" A school committee consists of 2 teachers and 4 students. The number of different committees that can be formed from 5 teachers and 10 students is  ", "A:  10 ", "B: 15 ", "C: 2100 ","D: 8", 3,Category.MATHEMATICS);
        addQuestion (q242);
        Question q243 = new Question(" Five books (A<B<C<D and E) are to be arranged on a shelf. Books C and D are t be arranged first and second starting from the right of the shelf. the number of the different orders in which books A,B and E may be arranged is ", "A: 5! ", "B: 3! ", "C: 2! ","D: 3! *2 ",2 ,Category.MATHEMATICS);
        addQuestion (q243);
        Question q244 = new Question(" The mean of a data set is equal to 10 and its standard deviation is equal to 1. if we add 5 to each data value, then the mean and standard deviation become ", "A: mean = 15, standard deviation = 6  ", "B: mean = 10, standard deviation =6  ", "C: mean = 15, standard deviation = 1  ","D: mean = 10, standard deviation = 1 ",3 ,Category.MATHEMATICS);
        addQuestion (q244);
        Question q245 = new Question(" The exam score of all 500 students were recorded and it was determined that these scores were normally distributed. If Jane's score is 0.8 standard deviation above the mean, then how many, to the nearest unit, students scored above jane?  ", "A: 394 ", "B: 250  ", "C: 400  ","D: 106 ",4 ,Category.MATHEMATICS);
        addQuestion (q245);
        Question q246 = new Question("if f(x) is an odd function, then | f(x) | is   ", "A: an odd function ", "B:  an even function ", "C: neither odd nor even  ","D: even and odd ", 2,Category.MATHEMATICS);
        addQuestion (q246);
        Question q247 = new Question("The period of |sin(3x)| is  ", "A: 2 pi  ", "B: 2pi/3 ", "C: pi/3  ","D: 3 pi ", 3,Category.MATHEMATICS);
        addQuestion (q247);
        Question q248 = new Question(" The period of 2sinx cos x is ", "A: 4pi ", "B: 2pi ", "C:  4pi ","D:  pi",4 ,Category.MATHEMATICS);
        addQuestion (q248);
        Question q249 = new Question(" A tennis player won 66 out of first 1212 sets. Then he won all f the remaining 66 sets. What part of the sets did the player win? ", "A: 1/3 ", "B: 2/3  ", "C: 1/4","D: 1/2",3 ,Category.MATHEMATICS);
        addQuestion (q249);
        Question q250 = new Question("A boy had $36 after a couple of hours of shopping he had $8 left what part of the money did he spend ?  ", "A: 2/9 ", "B: 2/7 ", "C: 7/9 ","D: 4/9 ",4 ,Category.MATHEMATICS);
        addQuestion (q250);





    }
    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_OPTION1, question.getOption1());
        cv.put(QuestionsTable.COLUMN_OPTION2, question.getOption2());
        cv.put(QuestionsTable.COLUMN_OPTION3, question.getOption3());
        cv.put(QuestionsTable.COLUMN_OPTION4, question.getOption4());
        cv.put(QuestionsTable.COLUMN_ANSWER_NR, question.getAnswerNr());
        cv.put(QuestionsTable.COLUMN_CATEGORY_ID, question.getCategoryID());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public List<Category> getAllCategories(){
        List<Category> categoryList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + CategoriesTable.TABLE_NAME, null);

        if (c.moveToFirst()){
            do{
                Category category = new Category();
                category.setId(c.getInt(c.getColumnIndex(CategoriesTable._ID)));
                category.setName(c.getString(c.getColumnIndex(CategoriesTable.COLUMN_NAME)));
                categoryList.add(category);
            }while (c.moveToNext());
        }
        c.close();
        return categoryList;
    }


    public ArrayList<Question> getAllQuestions(){
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
                question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
                question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
                question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
                question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
                question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
                questionList.add(question);
            } while (c.moveToNext());
        }
        c.close();
        return questionList;
    }

public ArrayList<Question> getQuestions(int categoryID) {
    ArrayList<Question> questionList = new ArrayList<>();
    db = getReadableDatabase();


    String selection = QuestionsTable.COLUMN_CATEGORY_ID + " = ? " ;
    String[] selectionArgs = new String[] {String.valueOf(categoryID)};

    Cursor c = db.query(
            QuestionsTable.TABLE_NAME,
            null,
            selection,
            selectionArgs,
            null,
            null,
            null
    );


    if (c.moveToFirst()) {
        do {
            Question question = new Question();
            question.setId(c.getInt(c.getColumnIndex(QuestionsTable._ID)));
            question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
            question.setOption1(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION1)));
            question.setOption2(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION2)));
            question.setOption3(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION3)));
            question.setOption4(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTION4)));
            question.setAnswerNr(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_ANSWER_NR)));
            question.setCategoryID(c.getInt(c.getColumnIndex(QuestionsTable.COLUMN_CATEGORY_ID)));
            questionList.add(question);
        } while (c.moveToNext());
    }
    c.close();
    return questionList;
}
}







