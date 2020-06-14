import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner in= new Scanner(System.in);
        File file = new File("src/book.txt");
        if(file.exists() && file.canRead()){
            System.out.println("File name is "+file);
            System.out.println("Amount of words: "+ countWords(file));
            System.out.println("Count of characters: " +countCharacters(file));
            System.out.println("Count of sentences: "+sentenceCount(file));
            System.out.println("Word frequency in this file: ");
            wordFrequency(file);
            System.out.println("Longest word is: " + longestWord(file));
            System.out.println("Enter your reading speed:");
            System.out.println("Average reader's speed is 250 WPM(words per minute)");
            int wpm = in.nextInt();
            readingTime(file,wpm);
        }
        else{
            System.out.println("Please ensure that your file exists or can be read!");
        }
    }

    public static int countWords(File file){
        int wordCount=0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while((s= br.readLine())!=null){
                String[] words  = s.trim().split("\\s+");
                wordCount +=words.length;
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();

        }
        return wordCount;
    }

    public static void wordFrequency(File file){
        HashMap<String,Integer> wordFrequency = new HashMap<String,Integer>();
        try{
            Scanner sc = new Scanner(new FileReader(file));
            while(sc.hasNext()){
                String word = sc.next();
                Integer count = wordFrequency.get(word);
                if(count!=null){
                    count++;
                }else{
                    count = 1;
                }
                wordFrequency.put(word,count);
            }
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }

        for(String i: wordFrequency.keySet()){
            System.out.println(i+":"+wordFrequency.get(i));
        }
    }


    public static String longestWord(File file){

        String longestWord = " ";
        try{
            Scanner sc = new Scanner(new FileReader(file));
            String c;
            while(sc.hasNext()){
                c = sc.next();
                if(c.length()>longestWord.length()){
                    longestWord=c;
                }
            }
            sc.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return longestWord;
    }

    public static int countCharacters(File file){
        int characterCount = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while((s= br.readLine())!=null){
                characterCount+=s.length();
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return characterCount;
    }

    public static void readingTime(File file,int wpm){
        double minute = countWords(file) / wpm;
        double second = Math.round(((minute%wpm)/wpm)*60);
        System.out.println("This should take you around "+(int)minute+" minutes and " +(int)second + " seconds to read at "+wpm+" words per minute.");
    }

    public static int sentenceCount(File file){
        int sentenceCount = 0;
        try{
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while((s= br.readLine())!=null){
                String[] sentence  = s.split("[!?.:]+");
                sentenceCount+=sentence.length;
            }
            br.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        return sentenceCount;
    }
}
