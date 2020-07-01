

import java.io.File;
import java.util.*;



public class Main {

    public static File fileWithStudents = new File("src/names.txt");
    public static ArrayList<String> nameOfStudents = new ArrayList<>();
    public static ArrayList<String> surnameOfStudents = new ArrayList<>();



    public static void main(String[] args) throws Exception{
        workWithFile();

        System.out.println("Number of unique names: "+uniqueNameOfStudents().size());
        System.out.println("Unique names in the "+fileWithStudents+":");
        for(String s:uniqueNameOfStudents()){
            System.out.println(s);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Number of unique surnames: "+uniqueSurnameOfStudents().size());
        System.out.println("Unique surnames in the "+fileWithStudents+":");
        for(String s:uniqueSurnameOfStudents()){
            System.out.println(s);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Popular names(which is encountered 3 or more times): ");
        for(String s:popularNames()){
            System.out.println(s);
        }

        System.out.println("--------------------------------------------------");
        System.out.println("Popular surnames(which is encountered 3 or more times): ");
        for(String s:popularSurnames()){
            System.out.println(s);
        }

        System.out.println("--------------------------------------------------");
        longestName();
        longestSurname();


        highestRatioOfVowelsInName();
        highestRatioOfConsInName();



    }


    public static void workWithFile() throws Exception{
        Scanner scanner = new Scanner(fileWithStudents);
        while(scanner.hasNextLine()){
            String[] line = scanner.nextLine().trim().split("\\s+");
            nameOfStudents.add(line[0]);
            surnameOfStudents.add(line[1]);
        }
    }

    public static ArrayList<String> uniqueNameOfStudents(){
        HashMap<String,Integer> findingUniqueName = new HashMap<>();
        ArrayList<String> listOfUniqueNames = new ArrayList<>();


        for(int i=0;i<nameOfStudents.size();i++){
            if(findingUniqueName.containsKey(nameOfStudents.get(i))){
                findingUniqueName.put(nameOfStudents.get(i),findingUniqueName.get(nameOfStudents.get(i))+1);
            }
            else{
                findingUniqueName.put(nameOfStudents.get(i),1);
            }
        }

        for(Map.Entry<String,Integer> m:findingUniqueName.entrySet()){
            if(m.getValue()==1){
                listOfUniqueNames.add(m.getKey());
            }
        }

        return listOfUniqueNames;
    }

    public static ArrayList<String> uniqueSurnameOfStudents(){
        HashMap<String,Integer> findingUniqueSurname = new HashMap<>();
        ArrayList<String> listOfUniqueSurnames = new ArrayList<>();


        for(int i=0;i<surnameOfStudents.size();i++){
            if(findingUniqueSurname.containsKey(surnameOfStudents.get(i))){
                findingUniqueSurname.put(surnameOfStudents.get(i),findingUniqueSurname.get(surnameOfStudents.get(i))+1);
            }
            else{
                findingUniqueSurname.put(surnameOfStudents.get(i),1);
            }
        }

        for(Map.Entry<String,Integer> m:findingUniqueSurname.entrySet()){
            if(m.getValue()==1){
                listOfUniqueSurnames.add(m.getKey());
            }
        }

        return listOfUniqueSurnames;
    }


    public static ArrayList<String> popularNames(){

        HashMap<String,Integer> findingPopularName = new HashMap<>();
        ArrayList<String> listOfPopularNames = new ArrayList<>();


        for(int i=0;i<nameOfStudents.size();i++){
            if(findingPopularName.containsKey(nameOfStudents.get(i))){
                findingPopularName.put(nameOfStudents.get(i),findingPopularName.get(nameOfStudents.get(i))+1);
            }
            else{
                findingPopularName.put(nameOfStudents.get(i),1);
            }
        }



        for(Map.Entry<String,Integer> m:findingPopularName.entrySet()){
            if(m.getValue()>=3){
                listOfPopularNames.add(m.getKey());
            }
        }


        return listOfPopularNames;

    }


    public static ArrayList<String> popularSurnames(){

        HashMap<String,Integer> findingPopularSurname = new HashMap<>();
        ArrayList<String> listOfPopularSurnames = new ArrayList<>();


        for(int i=0;i<surnameOfStudents.size();i++){
            if(findingPopularSurname.containsKey(surnameOfStudents.get(i))){
                findingPopularSurname.put(surnameOfStudents.get(i),findingPopularSurname.get(surnameOfStudents.get(i))+1);
            }
            else{
                findingPopularSurname.put(surnameOfStudents.get(i),1);
            }
        }

        int count=0;
        for(Map.Entry<String,Integer> m:findingPopularSurname.entrySet()){
            count+=m.getValue();
        }

        for(Map.Entry<String,Integer> m:findingPopularSurname.entrySet()){
            if(m.getValue()>=3){
                listOfPopularSurnames.add(m.getKey());
            }
        }


        return listOfPopularSurnames;

    }


    public static void longestName(){
        String longestName = nameOfStudents.get(0);
        for(String s:nameOfStudents){
            if(s.length()>longestName.length()){
                longestName=s;
            }
        }
        System.out.println("Longest name is "+longestName);
    }

    public static void longestSurname(){
        String longestSurname = surnameOfStudents.get(0);
        for(String s:surnameOfStudents){
            if(s.length()>longestSurname.length()){
                longestSurname=s;
            }
        }
        System.out.println("Longest surname is "+longestSurname);
    }

    public static void highestRatioOfVowelsInName() {
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> noDuplicateNames = new ArrayList<>();

        for (String s : nameOfStudents) {
            if (!noDuplicateNames.contains(s)) {
                noDuplicateNames.add(s);
            }
        }


        for (int i = 0; i < noDuplicateNames.size(); i++) {
            int count = 0;
            char[] letters = noDuplicateNames.get(i).toLowerCase().toCharArray();
            for (int j = 0; j < letters.length; j++) {

                if((letters[j] >= 'a' && letters[j] <= 'z') ||
                        (letters[j] >= 'A' && letters[j] <= 'Z')) {
                    if (letters[j] == 'a' || letters[j] == 'e' || letters[j] == 'i' || letters[j] == 'o' || letters[j] == 'u') {
                        count++;
                    }
                }


            }
            hm.put(noDuplicateNames.get(i), count);
        }

        int max = 0;
        String name = "";
        for (Map.Entry<String, Integer> m : hm.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                name = m.getKey();
            }
        }
        System.out.println("Name with highest ratio of vowels is "+name);
    }

    public static void highestRatioOfConsInName(){
        HashMap<String, Integer> hm = new HashMap<>();
        ArrayList<String> noDuplicateNames = new ArrayList<>();

        for (String s : nameOfStudents) {
            if (!noDuplicateNames.contains(s)) {
                noDuplicateNames.add(s);
            }
        }


        for (int i = 0; i < noDuplicateNames.size(); i++) {
            int count = 0;
            char[] letters = noDuplicateNames.get(i).toLowerCase().toCharArray();
            for (int j = 0; j < letters.length; j++) {
                if((letters[j] >= 'a' && letters[j] <= 'z') ||
                        (letters[j] >= 'A' && letters[j] <= 'Z')) {
                    if (letters[j] != 'a' && letters[j] != 'e' && letters[j] != 'i' && letters[j] != 'o' && letters[j] != 'u') {
                        count++;
                    }
                }

            }
            hm.put(noDuplicateNames.get(i), count);
        }

        int max = 0;
        String name = "";
        for (Map.Entry<String, Integer> m : hm.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
                name = m.getKey();
            }
        }
        System.out.println("Name with highest ratio of consonants is "+name);

    }
}






