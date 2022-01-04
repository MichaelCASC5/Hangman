import java.util.Scanner;
import java.util.ArrayList;

import java.io.File;
import java.io.FileWriter;

public class Driver{
    private static ArrayList<Integer> selectSave = new ArrayList<>();
    private static int highscore;
    private static int score = 0;
    private static boolean hints;
    
    private static Word[] words = {
        //SINGLE WORDS
        new Word("advice", "Something you might give to someone else", "Language, Speech"),
        new Word("aircraft", "It takes to the skies", "Aviation"),
        new Word("airplane", "It can fly!", "Aviation"),
        new Word("airport", "Where to catch a flight", "Aviation"),
        new Word("astronomy", "The study of the cosmos", "Science, Space"),
        new Word("atoms", "These very small things are everywhere", "Science"),
        new Word("bank", "A place where money can be kept", "Money, Security"),
        new Word("basketball", "A very popular sport nowadays", "Games"),
        new Word("bird", "A very airborne creature", "Animals"),
        new Word("blimp", "It can fly, but very slowly", "Aviation"),
        new Word("bottle", "A way to transport water", "Items"),
        new Word("breakfast", "It is a meal typically eaten in the morning", "Food, Time"),
        new Word("bridge", "A construction that joins two otherwise seperated places together", "Construction"),
        new Word("brunch", "It is a small meal, or snack, eaten in the mid-morning", "Food, Time"),
        new Word("bus", "A thing that people can take to get places", "Transportation, Vehicles"),
        new Word("cake", "Tasty! And sweet too", "Food"),
        new Word("cannon", "A very loud sound!", "Weapons"),
        new Word("cat", "Feisty, and independent", "Pets"),
        new Word("checkers", "A popular, and very old board game", "Games"),
        new Word("chess", "Rooks, Queens, Pawns, and Kings", "Games"),
        new Word("chocolate", "Usually dark in complexion, and very sweet", "Food"),
        new Word("classroom", "A place where you might go to learn", "Education"),
        new Word("clock", "Keeping track of time", "Devices, Time"),
        new Word("cloud", "Something you see in the sky", "Weather"),
        new Word("composer", "Someone who writes music", "Occupation, Music"),
        new Word("computer", "A device that does calculations", "Devices"),
        new Word("controller", "Something to play a video game with", "Devices, Games"),
        new Word("curtain", "It can be used to cover something up", "Items"),
        new Word("deer", "They are hoofed, and have antlers", "Animals"),
        new Word("desk", "A place to sit and work at", "Furniture"),
        new Word("dictionary", "A place to look up words", "Language"),
        new Word("dinner", "It is a meal typically eaten in the evening", "Food, Time"),
        new Word("discussion", "What people might be engaging in", "Language, Speech"),
        new Word("doctor", "Someone you should visit when ill", "Occupation"),
        new Word("dog", "Man's best friend", "Pets"),
        new Word("drill", "A tool used to make a hole", "Tools"),
        new Word("elevator", "It goes up and down!", "Machines"),
        new Word("equation", "A formula for a calculation", "Math, Science"),
        new Word("essay", "A large peice of writing", "Items, Writing"),
        new Word("explosion", "Very loud, and very dangerous", "Physics"),
        new Word("eyeballs", "They're in your face!", "Biology, Body Parts"),
        new Word("fan", "A way to keep cool on a hot day", "Devices"),
        new Word("fish", "An animal of the oceans", "Animals"),
        new Word("flute", "A woodwind with a very light and whimsical pitch", "Music"),
        new Word("folder", "A place to keep a lot of papers, or files", "Items"),
        new Word("glass", "An object that be seen through partially", "Materials"),
        new Word("glue", "It sticks things together", "Tools, Construction"),
        new Word("grasslands", "They are very flat formations", "Geography, Terrain"),
        new Word("gravel", "A lot of small rocks", "Terrain"),
        new Word("hammer", "It can nail pieces of wood together", "Tools, Construction"),
        new Word("hamster", "Very small and cuddly", "Pets"),
        new Word("hangman", "A game about guessing a word", "Games"),
        new Word("headphones", "A way to listen to music", "Devices, Music"),
        new Word("hurricane", "It can cause a lot of damage, and is quite dangerous", "Weather"),
        new Word("jazz", "A musical genre", "Music"),
        new Word("keyboard", "Something to type on", "Devices"),
        new Word("lamp", "It gives light!", "Tools, Light"),
        new Word("letters", "They are already in your field of view", "Language"),
        new Word("librarian", "Someone you will find in a library", "Occupation"),
        new Word("lighter", "It can start fires", "Tools, Fire"),
        new Word("lion", "A fierce cat that you do not want to mess with", "Animals"),
        new Word("lunch", "It is a meal typically eaten in the afternoon", "Food, Time"),
        new Word("marker", "It can be used permanently, or washable", "Tools, Writing"),
        new Word("mars", "The red planet", "Science, Space"),
        new Word("mechanic", "Someone to fix your car", "Occupation"),
        new Word("microscope", "It makes small things bigger", "Tool, Science"),
        new Word("mirror", "It stares right back at you!", "Furniture"),
        new Word("moss", "A small flowerless, and green plant", "Biology, Plants"),
        new Word("mountains", "They are very large formations", "Geography, Terrain"),
        new Word("mouse", "Eek! In the kitchen!", "Animals, Home"),
        new Word("mud", "It's yucky, sticky, and dirty", "Terrain"),
        new Word("nail", "Something that can be put into a wall", "Tools"),
        new Word("noise", "It can be loud, or quiet", "Science, Physics"),
        new Word("nose", "It is on your face", "Biology, Body Parts"),
        new Word("oboe", "An instrument that sounds like a duck!", "Music"),
        new Word("ocean", "Lots of water", "Geography"),
        new Word("pancake", "A flat cake", "Food"),
        new Word("paper", "You can write on it", "Materials, Writing"),
        new Word("pen", "A very permanent pencil", "Tools, Writing"),
        new Word("pencil", "Something to write with", "Tools, Writing"),
        new Word("phone", "Something that you can speak into", "Devices, Communications"),
        new Word("pistol", "It is small, and hand-held", "Weapons"),
        new Word("plastic", "Cheap to make, easy to use, but can pollute the world", "Materials"),
        new Word("possibility", "It might happen, it might not", "Math, Science"),
        new Word("present", "It makes people happy", "Items"),
        new Word("printer", "A way to bring digital files into the real world", "Devices, Machines"),
        new Word("programer", "Someone who creates software", "Occupation"),
        new Word("restaurant", "An established place to eat", "Building, Location, Food"),
        new Word("rifle", "A weapon used for greater accuracy at long distance", "Weapons"),
        new Word("rose", "A pretty red flower", "Biology, Plants"),
        new Word("sand", "It's course, rough, and gets everywhere", "Terrain"),
        new Word("school", "A building where you might go to learn", "Education, Buildings"),
        new Word("screen", "You're looking at it right now!", "Devices, Display"),
        new Word("skeleton", "A collection of bones", "Biology"),
        new Word("skyscraper", "A very tall building", "Buildings"),
        new Word("spacecraft", "A way to be safe in space", "Science, Space"),
        new Word("stick", "Something you might find on the forest floor", "Items, Terrain"),
        new Word("suggestion", "Something you might give another person", "Language, Speech"),
        new Word("suitcase", "Something you might bring to work", "Items"),
        new Word("sunflower", "A tall, and yellow flower.", "Biology, Plants"),
        new Word("sword", "A very pointy weapon", "Weapons"),
        new Word("tape", "It straps things together", "Tools, Construction"),
        new Word("telescope", "It makes far things closer", "Tool, Science"),
        new Word("television", "Who knew you could stare at it so long?", "Devices, Display"),
        new Word("timer", "It is counting down", "Device, Time"),
        new Word("toes", "They're on your feet!", "Biology, Body Parts"),
        new Word("tongue", "It is in your mouth", "Biology, Body Parts"),
        new Word("train", "Something you might ride to work", "Transportation, Vehicles"),
        new Word("trumpet", "A small brass instrument with a very bright sound", "Music"),
        new Word("typing", "You will need to do it soon", "Computers"),
        new Word("umbrella", "Protection from rain", "Tools, Weather"),
        new Word("vacuum", "Sucking up dirt and dust off the floor!", "Devices, Tools, Machines"),
        new Word("venus", "The morning star", "Science, Space"),
        new Word("waiter", "Someone who takes your order", "Occupation"),
        new Word("whale", "A very big and wet animal", "Animals"),
        new Word("wood", "It can be very strudy, and can be built into many things", "Materials"),
        new Word("wrench", "A tool used to provide grip", "Tools"),
        new Word("zebra", "It is a striped animal", "Animals"),
        
        //PHRASES
        new Word("alarm clock", "What wakes you up in the morning?", "Devices, Time"),
        new Word("ant hill", "A mountain for insects", "Animals, Terrain"),
        new Word("atomic bomb", "A very big BOOM", "Devices, Weapons"),
        new Word("bank teller", "Someone to help you out at the bank", "Occupation"),
        new Word("chicken soup", "A tasty meal, if you're ever feeling cold", "Food"),
        new Word("concert hall", "Where to watch a performance", "Building, Location"),
        new Word("conveyer belt", "It moves things around, and where they need to be", "Devices, Machines"),
        new Word("dining hall", "A moderately large place to eat", "Building, Food"),
        new Word("dining room", "A moderately large place to eat", "Building, Food"),
        new Word("hand sanitizer", "It keeps your hands clean", "Items"),
        new Word("health inspector", "Someone who examines food", "Occupation"),
        new Word("ice cream", "It is very cold", "Food"),
        new Word("lawn mower", "Something that shaves grass", "Tools"),
        new Word("noodle soup", "It has lots of tiny strands", "Food"),
        new Word("pacific ocean", "A very big place on the face of the planet!", "Geography"),
        new Word("picture frame", "Where a picture is kept", "Items, Display"),
        new Word("polar bear", "A very warm bear, in a very cold place", "Animals"),
        new Word("police officer", "Law Enforcement", "Occupation"),
        new Word("pool ball", "Scoring different colored balls into different holes", "Games"),
        new Word("quantum mechanics", "Describing nature at the atomic scale", "Science, Physics"),
        new Word("snow storm", "A winter wonderland!", "Weather"),
        new Word("software engineer", "Someone who builds software", "Occupation"),
        new Word("thunder storm", "A very dark and dreary condition", "Weather"),
        new Word("to be or not to be", "that is the question...", "Literature"),
        new Word("train tracks", "Something to help trains along", "Construction, Vehicles"),
        new Word("video game", "It is very virtual", "Games"),
    };
    public static void startUp(){
        try{
            File info = new File("info.dll");
            if(!info.exists()){
                createInfo();
            }
            Scanner fileReader = new Scanner(info);
            while(fileReader.hasNextLine()){
                String data = fileReader.nextLine();
                data = data.toLowerCase();
                data = data.replaceAll(" ", "");
                                
                //Gettting data
                if(data.substring(0,9).equals("highscore")){
                    highscore = Integer.parseInt(data.substring(10));
                }else if(data.substring(0,5).equals("hints")){
                    hints = Boolean.parseBoolean(data.substring(6));
                }
                //System.out.println(data);
            }
            fileReader.close();
        }catch(Exception e){
            e.printStackTrace();
            System.out.println("File not found.");
        }
    }
    public static void createInfo(){
        try{
            FileWriter file = new FileWriter("info.dll");
            file.write("highscore=0");
            file.write("\nhints=true");
            file.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[]args){
        //dev();
        startUp();
        
        //LOOP
        boolean gameRun = true;
        int multiplier = 5;
        while(gameRun){
            boolean isFirstGuess = true;
            int guesses = 6;
            boolean guessRun = true;
            
            int select = (int)(Math.random()*words.length);
            while(isPresent(select)){
                select = (int)(Math.random()*words.length);
            }
            if(selectSave.size() > 49){
                selectSave.remove(0);
            }
            selectSave.add(select);
            
            int len = words[select].getWord().length();
            int lenWoSpace = len;
            int correct = 0;
            
            String blank = "";
            for(int i=0;i<len;i++){
                if(words[select].getLetter(i) != ' '){
                    blank+= "_";
                }else{
                    blank+= " ";
                    lenWoSpace--;
                }
            }

            String letterbank = "";
            boolean win = false;
            
            Scanner reader = new Scanner(System.in);
            while(guessRun && guesses > 0){
                for(int i=0;i<20;i++){
                    System.out.println();
                }
                
                System.out.println("Welcome to Hangman!     Highscore: " + highscore + "\n\n\n");
                System.out.println("Guesses left: " + guesses + "     SCORE: " + score);
                System.out.println("letterbank: " + letterbank);
                System.out.println();
                
                String topic = words[select].getTopic();
                String plural;
                if(topic.indexOf(",") == -1){
                    plural = "Topic";
                }else{
                    plural = "Topics";
                }
                System.out.print(plural + ": " + topic);
                if(isFirstGuess){
                    System.out.print("     " + "Worth " + (len * 100 * multiplier) + " points on first try");
                }
                System.out.println();
                
                if(guesses == 1 && hints){
                    System.out.println("Hint: " + words[select].getHint());
                }
                
                //Prints Blank Spaces
                for(int i=0;i<blank.length();i++){
                    System.out.print(blank.charAt(i) + " ");
                }
                System.out.println();
                
                //Getting the first char of the input
                String ans = reader.nextLine();
                if(ans.equals("") || ans.equals(" ")){
                    ans = "  ";
                }
                ans = ans.toLowerCase();
                if(ans.charAt(ans.length()-1) == ' '){
                    ans = ans.substring(0,ans.length()-1);
                }
                char input = ans.charAt(0);
                
                if(!ans.equals(words[select].getWord())){
                    //Guessing character by character
                    if(words[select].check(input) && blank.indexOf(input) == -1){
                        for(int i=0;i<len;i++){
                            if(input == words[select].getLetter(i)){
                                blank = blank.substring(0,i) + input + blank.substring(i+1,len);
                                correct++;
                                score+=100;
                            }
                        }
                    }else{
                        String addComma;
                        if(guesses < 6){
                            addComma = ", ";
                        }else{
                            addComma = "";
                        }
                        letterbank+=addComma + input;
                        guesses--;
                    }
                    if(correct == lenWoSpace){
                        System.out.println();
                        System.out.println(words[select].getWord());
                        guessRun = false;
                        win = true;
                    }else if(guesses == 0){
                        System.out.println();
                        System.out.println(words[select].getWord());
                    }
                }else{
                    //Guessing entire word
                    win = true;
                    guessRun = false;
                    if(isFirstGuess){
                        score+=(len * 100 * multiplier);
                    }else{
                        score+=(100*(lenWoSpace-correct));
                    }
                }
                isFirstGuess = false;
                //Setting highscore
                if(score > highscore){
                    highscore = score;
                    save();
                }
            }
            
            System.out.println();
            
            if(win){
                System.out.println("You won!" + "     SCORE: " + score);
            }else{
                System.out.println("Sorry, you lost." + "     SCORE: " + score);
                score = 0;
            }
            
            System.out.println("Continue?     [y/n]");
            String cont = reader.next();
            if(cont.equals("n")){
                gameRun = false;
            }else if(cont.equals("/resetHighscore")){
                highscore = 0;
            }else if(cont.equals("/toggleHints")){
                if(hints){
                    hints = false;
                }else{
                    hints = true;
                }
            }
            
            save();
        }
    }
    public static void save(){
        try{
            FileWriter file = new FileWriter("info.dll");
            file.write("highscore=" + highscore);
            file.write("\nhints=" + hints);
            file.close();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static boolean isPresent(int select){
        boolean output = false;
        for(int i=0;i<selectSave.size();i++){
            if(selectSave.get(i) == select){
                output = true;
            }
        }
        return output;
    }
    //Developer
    public static void printSelect(){
        for(int i=0;i<selectSave.size();i++){
            System.out.print(selectSave.get(i) + ", ");
        }
        System.out.println();
    }
    public static void dev(){
        Word temp;
        for(int i=0;i<words.length;i++){
            for(int j=i+1;j<words.length;j++){
                if(words[i].getWord().compareTo(words[j].getWord()) > 0){
                    temp = words[i];
                    words[i] = words[j];
                    words[j] = temp;
                }
            }
        }
        System.out.println("private static Word[] words = {");
        System.out.println("        //SINGLE WORDS");
        for(int i=0;i<words.length;i++){
            if(words[i].getWord().indexOf(' ') == -1){
                System.out.println(
                        "        " +
                        "new Word(\"" + words[i].getWord() + "\", \""
                        + words[i].getHint() + "\", \"" + words[i].getTopic() + "\"),"
                );
            }
        }
        System.out.println("\n        //PHRASES");
        for(int i=0;i<words.length;i++){
            if(words[i].getWord().indexOf(' ') != -1){
                System.out.println(
                        "        " +
                        "new Word(\"" + words[i].getWord() + "\", \""
                        + words[i].getHint() + "\", \"" + words[i].getTopic() + "\"),"
                );
            }
        }
        System.out.println("    };");
    }
}