 package com.borat.nsneq;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import com.borat.nsneq.ExamContract.*;

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
        Category c1 = new Category("SUBJECTS");
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

        /*
        Question q51 = new Question("The two types of human tape worm can be distinguished by the presence or absence of", "A: Scolex ", "B: Hook ", "C: Head  ","D: Proglottis ",2, Category.BIOLOGY );
        addQuestion(q51);
        Question q52 = new Question("Accommodation of human eye is best described as the", "A: Ability to see distant objects ", "B: Movement of upper and lower eyelids ", "C: Focusing of near and distant objects ","D: Changing of lens shape due to varying light intemsities ",3, Category.BIOLOGY );
        addQuestion(q52);
        Question q53 = new Question("A person whose blood can be donated to all other people must have the blood group", "A: O ", "B: AB ", "C: B ","D: A ",1 ,Category.BIOLOGY );
        addQuestion(q53);
        Question q54 = new Question("Which of the following substance is not found in urine", "A: Water ", "B: Sodium chloride ", "C: nitrogenous compounds ","D: Calcium chloride",4 , Category.BIOLOGY);
        addQuestion(q54);
        Question q55 = new Question("Anaerobic respiration in yeast produces", "A: a carbon dioxide and ethanol ", "B: Carbon dioxide and water ", "C: Carbondioxide and oxygen ","D: Carbon dioxide and glucose ",1 , Category.BIOLOGY);
        addQuestion(q55);
        Question q56 = new Question("which of the following lists of diseased, their causes and transmission is correct", "A: Cholera, virus, severe diarrhea infected water ", "B: Malaria, protozoan, high fever, contact with infected person ", "C: syphilis, virus, venereal diseases, sexual intercourse ","D: smallpx, virus, skin with blister, close contact with infected person ", 4, Category.BIOLOGY);
        addQuestion(q56);
        Question q57 = new Question("The spots and stripes of the leopard and tiget are examples of", "A: warning colouration ", "B: countershading ", "C: cryptic colouration ","D:distuptive colouration ",4, Category.BIOLOGY );
        addQuestion(q57);
        Question q58 = new Question("if calcium is deficient in food this may cause", "A: Anaemia ", "B: Retarded growth ", "C: Sterility ","D: beri-beri ",2 ,Category.BIOLOGY );
        addQuestion(q58);
        Question q59 = new Question("An animal cells can perform these processes, except", "A: Respiration ", "B: Nutrition ", "C: Locomotion ","D: transpiration ", 4 ,Category.BIOLOGY);
        addQuestion(q59);
        Question q60 = new Question("You can distinguish an animal cell from that of a plant by the", "A: presence of cell membrane ", "B:Presence of contractile vacuoles ", "C: presence of cellulos wall ","D: Presence of protoplasm ",3, Category.BIOLOGY );
        addQuestion(q60);
        Question q61 = new Question("Physiology process within a cell is controlled by", "A: Neuclus ", "B: Cytopalsm ", "C: Cell membrane ","D:vacuole ",1, Category.BIOLOGY );
        addQuestion(q61);
        Question q62 = new Question("The power-house within an animal cell is the", "A: Centrosome ", "B: Nucleus ", "C: Golgi apparatus ","D:mitochondrion ",4, Category.BIOLOGY );
        addQuestion(q62);
        Question q63 = new Question("Which of the following structures direct the transmission of hereditary inheritance", "A: nucleous ", "B: gene ", "C: chloroplast ","D:plasmids ",2, Category.BIOLOGY );
        addQuestion(q63);
        Question q64 = new Question("Which of these personalities was noted for evolution theory of special", "A: Robert Nooke ", "B: Mathias Schleiden ", "C: Theodor Schwann ","D: Charles Darwin ",4 ,Category.BIOLOGY );
        addQuestion(q64);
        Question q65 = new Question("Man's intelligence is indicated by his ability to", "A: communicate with people  ", "B: play football ver well ", "C: Speak fluently ","D:Solve problems ",4, Category.BIOLOGY );
        addQuestion(q65);
        Question q66 = new Question("All of the following are atropods except", "A: Millipede ", "B: Centipede ", "C: Spider ","D: snail",4, Category.BIOLOGY );
        addQuestion(q66);
        Question q67 = new Question("Mature red blood cells lack one of the following", "A: Centrosomes ", "B: protoplasm ", "C: Cytoplasm ","D:nucleus ",4 ,Category.BIOLOGY );
        addQuestion(q67);
        Question q68 = new Question("Which of these terms includes all of the others", "A: Cells ", "B: Tissue ", "C: System ","D:organism ",4, Category.BIOLOGY );
        addQuestion(q68);
        Question q69 = new Question("The following micro-organisms are harmful to man and his natural resources except", "A: Pneumoccocus ", "B: Meningoccous ", "C: Tubercle bacillus ","D:penicilliumnotatum ", 4 ,Category.BIOLOGY);
        addQuestion(q69);
        Question q70 = new Question("Sleeping sickness is caused by", "A: Teaniasolium ", "B: taeniasaginata ", "C: schistosomahaematobium ","D: trypanosome ", 4 ,Category.BIOLOGY);
        addQuestion(q70);
        Question q71 = new Question("Because they transmit diseases house flies are known as", "A: Carriers ", "B: parasites ", "C: Hosts ","D: vectors ",4 ,Category.BIOLOGY );
        addQuestion(q71);
        Question q72 = new Question("Irritability is the ability of an organism to react to", "A: Locomote ", "B: Excrete feaces ", "C: Show annoyance ","D: React to stimuli ", 4, Category.BIOLOGY );
        addQuestion(q72);
        Question q73 = new Question("A position of the thumb to the forfinger ensbles the man's hand to ", "A: Swim perfectly", "B: Fight attackers ", "C: Hold food well ","D:handle tools ",4, Category.BIOLOGY );
        addQuestion(q73);
        Question q74 = new Question("A group of living cells similar in nature and performing thesame function is called", "A: System ", "B: An organ ", "C: inclusion ","D:a tissue ",4 , Category.BIOLOGY);
        addQuestion(q74);
        Question q75 = new Question("It was discovered that small pox was due to ", "A: Virus ", "B: Protozoon ", "C: Bactenum ","D: tsetse fly ", 1, Category.BIOLOGY);
        addQuestion(q75);
        Question q76 = new Question("Microorganisms can be destroyed by the use of these except", "A: Use of extreme temperatures ", "B: disinfectants ", "C: Salinity ","D: smoking and refrigeration ",4 ,Category.BIOLOGY );
        addQuestion(q76);
        Question q77 = new Question("Saprophytes are characterized by these except ", "A: Absence of chlorophyll ", "B: Causing decay of dead tress ", "C: Digestion of food by enzymes ","D:photosynthetic ability ",4 ,Category.BIOLOGY );
        addQuestion(q77);
        Question q78 = new Question("Death of man, animanl and plants can be caused by one organism", "A: Saprophytes ", "B: Epiphytes ", "C: Microphytes ","D: Parasites ",4, Category.BIOLOGY );
        addQuestion(q78);
        Question q79 = new Question("Symbiosis can be applied to the following relationship except", "A: A situation where orgaisn ", "B: ", "C: ","D: ",1 ,Category.BIOLOGY );
        addQuestion(q79);
        Question q80 = new Question("Parasitism can be defined as", "A: ", "B: ", "C: ","D: ",1 ,Category.BIOLOGY );
        addQuestion(q80);
        Question q81 = new Question(" The organism that gains no benefits but is harmed during the process of the sassociation is known as", "A: Parasite ", "B: Host ", "C: Symbiont ","D:predator ",2 ,Category.BIOLOGY );
        addQuestion(q81);
        Question q82 = new Question("Water can be best purified for community drinking by", "A: Chlorination ", "B: sedimentation ", "C: Distillation ","D: filteration ",1 ,Category.BIOLOGY );
        addQuestion(q82);
        Question q83 = new Question("Iodine deficiency can cause", "A: Anaemia ", "B: Goiter ", "C: Kwashiorkor ","D: obesity ",2, Category.BIOLOGY );
        addQuestion(q83);
        Question q84 = new Question("The organism that gain no benefit but is harmed during the process of association is known as", "A: Parasite ", "B: Host", "C: Symbiont ","D: predator ", 2 ,Category.BIOLOGY);
        addQuestion(q84);
        Question q85 = new Question("The association in which no harm or inconvinience is caused to one partner though benefit is derived by other one is known as", "A: Parasitism ", "B: predatory ", "C: Commensalism ","D: saprophytism",3, Category.BIOLOGY );
        addQuestion(q85);
        Question q86 = new Question("A process during which certain gases are exchanged between a living organism and its surrounding environment is known as", "A: Reproduction ", "B: Respiration ", "C: Excretion ","D: nutrition ",2 , Category.BIOLOGY );
        addQuestion(q86);
        Question q87 = new Question("Semi-digested food ready to leave the stomach is termed", "A: Curd ", "B: Chyle ", "C: Roughage ","D: faeces ",2, Category.BIOLOGY );
        addQuestion(q87);
        Question q88 = new Question("The human heart is situated in the ", "A: Cranial cavity ", "B: Thoracic cavity ", "C: abdominal cavity ","D: pelvic cavity ", 2 ,Category.BIOLOGY);
        addQuestion(q88);
        Question q89 = new Question("The main function of the lung is", "A:To ensure proper exchange of gases ", "B: to ensure digestion of food ", "C: To detoxicate food substances ","D: to deaminate ingested protein ",1, Category.BIOLOGY );
        addQuestion(q89);
        Question q90 = new Question("The function unit of lungs is the", "A: Alveoli ", "B: Trachea ", "C: Bronchiole ","D: artriole ", 1, Category.BIOLOGY);
        addQuestion(q90);
        Question q91 = new Question("Oxygenated blood from the lungs passes into the heart through", "A: pulmonary arteries ", "B: plumonary veins ", "C: Hapatic portal veins ","D: superior vena cava ", 2 ,Category.BIOLOGY);
        addQuestion(q91);
        Question q92 = new Question("One of these vessels carries deoxygenated blood away from the heart", "A: inferior vena cava ", "B: Supenor vena cava ", "C: Plumonary vein ","D: pulmonary artery ",4 ,Category.BIOLOGY );
        addQuestion(q92);
        Question q93 = new Question("Which of the following is made up of striated muscles", "A: Biceps ", "B: Veins ", "C: Artery ","D:stomach ",1 ,Category.BIOLOGY );
        addQuestion(q93);
        Question q94 = new Question(" Various tissues are found in the body of a man because", "A: ", "B: ", "C: ","D: the cells containd different types of chromosomes ",1, Category.BIOLOGY );
        addQuestion(q94);
        Question q95 = new Question("The inclusion of small quantities of fluorine in the diet of man is essential for the", "A: prevention of cavity and decay formation in the teeth ", "B: Utilization of iron in the body ", "C: Regulation of body fluid ","D: regulation of thyroxine secretion",1, Category.BIOLOGY);
        addQuestion(q95);
        Question q96 = new Question("which of the following function of the stomach is concerned with the digestion of starch", "A: Production of hydrochloric acid ", "B: killing of microbes in the starchy food ", "C: Forming of chyme  ","D: Softening of food ", 1 ,Category.BIOLOGY);
        addQuestion(q96);
        Question q97 = new Question("The vein which returns blood from the legs and trunk to the heart is", "A:inferior vena cava ", "B: Superior vena cava", "C: Pulmonary Vein ","D: Aorta ",1, Category.BIOLOGY );
        addQuestion(q97);
        Question q98 = new Question("In vertebrate the spinal cord is protected by ", "A: Medullary canal ", "B: Neural canal ", "C: Pelvic cavity ","D: vertebral column ",4, Category.BIOLOGY );
        addQuestion(q98);
        Question q99 = new Question("Defincy of insulin in man causes a diseases called", "A: Dehydration ", "B: Diabetes ", "C: Cholera ","D: Yellow fever ",2 ,Category.BIOLOGY);
        addQuestion(q99);
        Question q100 = new Question("Transmission and reception of messages within the body of man is the function of", "A: Neurons ", "B: Cardiac muscles ", "C: Skin ","D: Bones ",1 ,Category.BIOLOGY );
        addQuestion(q100);

*/


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







