import java.util.ArrayList;
import java.util.Map.*;
import java.util.List; 
import java.util.Iterator;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.File;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.OutputStreamWriter;
import java.util.*;


public class QuizGenerator {
    
//===================================Questions================================================
    public static class Questions 
    {
        //Types of Questions
        private String questionAsked;
        //Type of question type -> 1 = T/F, 2 = M/C, 3 = S/A, 4 = Mutiple Answers
        private int questionType; 

        Questions(int questionType,String questionAsked)
        {
            this.questionType = questionType; 
            this.questionAsked = questionAsked;
        }

        public List<String> initiateQuestion()
        {
            if(questionType == 1) // True and False 
            {
                ArrayList<String> tof = new ArrayList<>(); 
                tof.add("[T]");
                tof.add("[F]"); 

                return tof; 
            }
            else if(questionType == 2) //Multiple Choice
            {
                ArrayList<String> mul = new ArrayList<>();
                System.out.println("Input for option 'A' ");
                String a = stringLineReader();
                
                System.out.println("Input for option 'B' ");
                String b = stringLineReader();
                
                System.out.println("Input for option 'C'");
                String c = stringLineReader();
    
                System.out.println("Input for option 'D' ");
                String d = stringLineReader();

                mul.add("a) "+a); 
                mul.add("b) "+b);
                mul.add("c) "+c); 
                mul.add("d) "+d); 

                return mul;
            }
            else if(questionType == 3) // Open Ended 
            {
                ArrayList<String> opend = new ArrayList<>();
                System.out.println("Input Hints If Needed");
                System.out.println("Ex: Make sure to mention 'Why The British Lost' to get full credit");
                String a = stringLineReader();
                opend.add(a); 

                return opend; 
            }
            else if(questionType == 4) // Mutiple Answers 
            {
                ArrayList<String> mula = new ArrayList<>();
                System.out.println("Input for option 'A'");
                String a = stringLineReader();
                
                System.out.println("Input for option 'B'");
                String b = stringLineReader();
                
                System.out.println("Input for option 'C'");
                String c = stringLineReader();
    
                System.out.println("Input for option 'D'");
                String d = stringLineReader();

                System.out.println("Input for option 'E'");
                String e = stringLineReader();

                System.out.println("Input for option 'F");
                String f = stringLineReader();

                mula.add("a) "+a); 
                mula.add("b) "+b);
                mula.add("c) "+c);
                mula.add("d) "+d);
                mula.add("e) "+e);
                mula.add("f) "+f);

                return mula;
            }
            else
            {
                ArrayList<String> nully = new ArrayList<>();
                return nully;
            }

        }

        public String AnswerKey()
        {
            System.out.println("Enter Answer to Question");
            String input = stringLineReader();
            return input;
        }

        public String getQuestionAsked()
        {
            return questionAsked;
        }

        public int getQuestionType()
        {
            return questionType;
        }

        @Override
        public String toString()
        {
            return ""+questionAsked;
        }   
    }    
    public static class TrueOrFalse 
    {
        private boolean answer;   
        
        TrueOrFalse(boolean answer)
        {
            this.answer = answer; 
        }

        @Override
        public String toString()
        {
            return "The answer for this [T/F] question is " + " (" + answer  + ")";
        }
    }


    
//===================================Answer Generator================================================
    public static void takeQuiz(){
        //System.out.println("[Error]: File Opener Still in Development");
        File folder = new File("QuestionFiles/");
        File[] listOfFiles = folder.listFiles();
        for(int i=0; i<listOfFiles.length; i++)
        {
            if(listOfFiles[i].isFile())
            {
                System.out.println("File "+listOfFiles[i].getName());
            }
            else if(listOfFiles[i].isDirectory())
            {
                System.out.println("Directory "+listOfFiles[i].getName());
            }
        }
        System.out.println("");
        System.out.println("Enter File name");
        String fileName = stringLineReader();
        System.out.println("");
        
        System.out.println("Enter Your Name");
        String userName = stringLineReader();
        System.out.println("");

        ArrayList<String> userAnswer = new ArrayList<>();
        ArrayList<String> correctAnswer = new ArrayList<>();
        ArrayList<String> quizQuestions = new ArrayList<>();
        int numOfQ = 0;
        int score = 0;


        try {
            BufferedReader br = new BufferedReader(new FileReader("SaveFile/"+fileName+".txt"));
            //String question = br.readLine();
            String question = br.readLine();
            while(question != null)
            {
                try
                {
                    int qType = Integer.parseInt(br.readLine());
                    if(qType == 1)
                    {
                        numOfQ++;
                        question = br.readLine();
                        System.out.println(question);
                        quizQuestions.add(question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("");
                        System.out.println("Enter Your Answer");
                        String input = stringLineReader();
                        userAnswer.add(input);
                        correctAnswer.add(question);
                        if(input.equals(question) == true)
                        {
                            //System.out.println("Correct");
                            score++;
                        }
                        System.out.println("");
                    }
                    else if(qType == 2)
                    {
                        numOfQ++;
                        question = br.readLine();
                        System.out.println(question);
                        quizQuestions.add(question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("");
                        System.out.println("Enter Your Answer");
                        String input = stringLineReader();
                        userAnswer.add(input);
                        correctAnswer.add(question);
                        if(input.equals(question) == true)
                        {
                            //System.out.println("Correct");
                            score++;
                        }
                        System.out.println("");
                    }
                    else if(qType == 3)
                    {
                        numOfQ++;
                        question = br.readLine();
                        System.out.println(question);
                        quizQuestions.add(question);
                        question = br.readLine();
                        System.out.println(question);
                        System.out.println("");
                        System.out.println("Enter Your Answer");
                        String input = stringLineReader();
                        System.out.println("Will be Graded by teacher");
                        correctAnswer.add(question);
                        userAnswer.add(input);
                        question = br.readLine();
                        System.out.println("");
                    }
                    else if(qType == 4)
                    {
                        numOfQ++;
                        question = br.readLine();
                        System.out.println(question);
                        quizQuestions.add(question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("\t"+question);
                        question = br.readLine();
                        System.out.println("");
                        System.out.println("Enter Your Answer");
                        String input = stringLineReader();
                        userAnswer.add(input);
                        correctAnswer.add(question);
                        if(input.equals(question) == true)
                        {
                            //System.out.println("Correct");
                            score++;
                        }
                        System.out.println("");
                    }
                }
                catch(NumberFormatException e)
                {
                    System.out.println("End of Quiz");
                    break;
                }
            }
            System.out.println("");  
            System.out.println("[Results]");
            System.out.println("Score: "+score+"/"+numOfQ);
            
            saveQuizInformation(fileName, userName, score, numOfQ, userAnswer, correctAnswer,quizQuestions);

        }   
        catch (IOException e) {
            e.printStackTrace(); 
        }
    }

    public static void saveQuizInformation(String fileName, String userName, int score, int numOfQ, ArrayList<String> userAnswer,ArrayList<String> correctAnswer,ArrayList<String> quizQuestions)
    {
        try{
            //this will create Question Files
            File newFile = new File("StudentFiles/"+fileName+" - "+userName+".txt");
            FileOutputStream sf = new FileOutputStream(newFile);
            OutputStreamWriter sfw = new OutputStreamWriter(sf);
            BufferedWriter sqi = new BufferedWriter(sfw);

            sqi.write("Quiz - "+fileName);
            sqi.newLine();
            sqi.write("Name: "+userName);
            sqi.newLine();
            sqi.write("Score: "+score+"/"+numOfQ);
            sqi.newLine();
            sqi.newLine();
            //System.out.println(userAnswer.size());
            //System.out.println(quizQuestions.size());
            for(int i=0; i<userAnswer.size();i++)
            {
                int qi = i+1;
                sqi.write("Question "+qi+" : "+quizQuestions.get(i));
                sqi.newLine();
                sqi.write("\t[Answer] : "+userAnswer.get(i));
                sqi.newLine();
                sqi.write("\t[Correct Answer] : "+correctAnswer.get(i));
                sqi.newLine();
            }
            sqi.close();
        }
        catch(IOException e)
        {
            System.out.println("[Error]: No File Found");
        }
    }


//===================================Write to File===============================================
    public static void makeFile(LinkedHashMap<Questions,List<String>> QuestionHash, LinkedHashMap<String, String> AnswerHash)
    {
        try 
        {
            System.out.println("");
            System.out.println("Enter File Name:");
            String fileName = stringLineReader();
            
            //this will create Question Files
            File newFile = new File("QuestionFiles/"+fileName+".txt");
            FileOutputStream is = new FileOutputStream(newFile);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            BufferedWriter w = new BufferedWriter(osw);

            //this will create answer file
            File ansFile = new File("AnswerKey/"+fileName+".txt");
            FileOutputStream ans = new FileOutputStream(ansFile);
            OutputStreamWriter ansf = new OutputStreamWriter(ans);
            BufferedWriter answ = new BufferedWriter(ansf);

            //this will create save file
            File saveFile = new File("SaveFile/"+fileName+".txt");
            FileOutputStream save = new FileOutputStream(saveFile);
            OutputStreamWriter savef = new OutputStreamWriter(save);
            BufferedWriter savew = new BufferedWriter(savef);



            //this will output information to Question file
            Iterator iterate = QuestionHash.entrySet().iterator();
            int count = 1;
                w.write("Quiz "+fileName);
                w.newLine();
                w.write("Name:_________________________");
                w.newLine();
                w.newLine();
            while (iterate.hasNext()) {
                Map.Entry obj = (Entry)iterate.next();
                //System.out.println(obj.getKey()+ " : [Answers] : \t"+obj.getValue());
                List<String> choices = (List<String>)obj.getValue();
                w.write("Question "+count+ ": " +obj.getKey());
                w.newLine();
                w.newLine();
                //w.write("\t[Choices] : "+obj.getValue());
                for(String choice : choices)
                {
                    w.write("\t"+choice);
                    w.newLine();
                    w.newLine();
                }
                count++;
            }
            w.close();

            //This will be the output information for the answer file
            Iterator ansiterate = AnswerHash.entrySet().iterator();
            count = 1;
            while (ansiterate.hasNext()) {
                Map.Entry obj = (Entry)ansiterate.next();
                //System.out.println(obj.getKey()+ " : [Answers] : \t"+obj.getValue());
                answ.write("Question "+count+": "+obj.getKey());
                answ.newLine();
                answ.newLine();
                answ.write("\t[Answers] : "+obj.getValue());
                answ.newLine();
                answ.newLine();  
                count++; 
            }
            answ.close();

            //This will be the output information for the answer file
            //savew.write("Quiz - Start");
            Iterator saveiterate = QuestionHash.entrySet().iterator();
            Iterator saveAnsiterate = AnswerHash.entrySet().iterator();
            savew.write("Quiz - Save File");
            savew.newLine();
            while (saveiterate.hasNext() && saveAnsiterate.hasNext()) {
                Map.Entry objans = (Entry)saveAnsiterate.next();
                Map.Entry obj = (Entry)saveiterate.next();
                //System.out.println(obj.getKey()+ " : [Answers] : \t"+obj.getValue());
                // savew.write(""+obj.getKey());
                // savew.newLine();
                // savew.write(""+obj.getValue());
                // savew.newLine();
                Questions question = (Questions)obj.getKey();
                List<String> questionsC = (List<String>)obj.getValue();
                String questionAns = (String)objans.getValue();
                savew.write(""+question.getQuestionType());
                savew.newLine();
                savew.write(question.getQuestionAsked());
                savew.newLine();
                for(String choices : questionsC)
                {
                    savew.write(choices);
                    savew.newLine();
                }
                savew.write(questionAns);
                savew.newLine();
            }
            savew.close();
           
        }
        catch (IOException e)
        {
            System.err.println("[Error] : unable to make/write to new file");
        }
        
        
    }



//===================================Line Readers================================================
   public static String stringLineReader()
   {
       BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
       try 
       {
        String userInput = input.readLine();
        return userInput;
        } 
        catch (IOException e) 
        {
        e.printStackTrace();
        }

       return "";
   }

   public static Integer intLineReader()
   {
        BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
        try 
        {
        int userInput = Integer.parseInt(input.readLine());
        return userInput;
        } 
        catch (IOException e) 
        {
        e.printStackTrace();
        }

        return 0;
   }


   public static Boolean boolLineReader()
   {
        BufferedReader input = new BufferedReader(new InputStreamReader((System.in)));
        try 
        {
        String userInput = input.readLine();
        
            if(userInput.equals("T") || userInput.equals("true") || userInput.equals("True"))
            {
                return true;
            }
            else if(userInput.equals("F") || userInput.equals("false") || userInput.equals("False"))
            {
                return false;
            }
        } 
        catch (IOException e) 
        {
        e.printStackTrace();
        }
        return true;
   }

//=================================U/I interface======================================
    public static void main(String args[])
    {
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        //List<Questions> QuestionList = new ArrayList<>();
        LinkedHashMap<Questions,List<String>> QuestionHash = new LinkedHashMap<Questions,List<String>>();
        LinkedHashMap<String,String> AnswersHash = new LinkedHashMap<String,String>(); 
        int value = 0;
        System.out.println("Welcome to Quiz Generator!");
        while(true)
        {
            System.out.println("Options : [1] - Make a Quiz \t[2] - Take a Quiz \t[3] - View a File");
            try{
                int numInput = Integer.parseInt(reader.readLine());
                switch(numInput)
                {
                    case 1:
                        ///////////
                        value = 0;
                        while(value == 0)
                        {
                            System.out.println("Options : [0] - EXIT \t[1] - True/False \t[2] - Multiple Choice \t[3] - Open Ended \t[4] - Multiple Answers \t[5] - Show Questions \t[6] - Generate Answer Sheet");
                            try 
                            {
                                int num = Integer.parseInt(reader.readLine()); 
                            
                                switch(num) 
                                {   
                                    case 1:
                                        System.out.println("For the answer please put in the format of true or false");  
                                        String inputTF = stringLineReader();
                                        Questions questionType1 = new Questions(1,inputTF);
                                        List<String> answers_tf = questionType1.initiateQuestion();
                                        String answerTF = questionType1.AnswerKey();
                                        AnswersHash.put(inputTF,answerTF);
                                        QuestionHash.put(questionType1,answers_tf);
                                        System.out.println();
                                        break; 
                                        
                                    case 2:
                                        System.out.println("For the answer please put in the format of m/c");  
                                        String inputMC = stringLineReader();
                                        Questions questionType2 = new Questions(2,inputMC);
                                        List<String> answers_mc = questionType2.initiateQuestion();
                                        String answerMC = questionType2.AnswerKey();
                                        AnswersHash.put(inputMC,answerMC);
                                        QuestionHash.put(questionType2,answers_mc);
                                        System.out.println();
                                        break;
                
                                    case 3:   
                                        System.out.println("For the answer please put in the format of open ended");  
                                        String inputOE = stringLineReader();
                                        Questions questionType3 = new Questions(3,inputOE);
                                        List<String> answers_oe = questionType3.initiateQuestion();
                                        String answerOE = questionType3.AnswerKey();
                                        AnswersHash.put(inputOE,answerOE);
                                        QuestionHash.put(questionType3,answers_oe);
                                        System.out.println();
                                        break;
                                    case 4:
                                        System.out.println("For the answer please put in the format of mutiple answers");  
                                        String inputMA = stringLineReader();
                                        Questions questionType4 = new Questions(4,inputMA);
                                        List<String> answers_ma = questionType4.initiateQuestion();
                                        String answerMA = questionType4.AnswerKey();
                                        AnswersHash.put(inputMA,answerMA);
                                        QuestionHash.put(questionType4,answers_ma);
                                        System.out.println();
                                        break;
                                    case 5:
                                        //Quiz file upload
                                        System.out.println("Here are the results");
                                        Iterator it = QuestionHash.entrySet().iterator();
                                        
                                        while (it.hasNext()) {
                                            Map.Entry obj = (Entry)it.next();
                                            System.out.println(obj.getKey()+ " : [Answers] : \t"+obj.getValue());
                                        }
                                        System.out.println();
                                        break;
                                    case 6:
                                        //Quiz Generator to take -> Save to txt file
                                        System.out.println("[Notification]: Successfully Saved Files");
                                        makeFile(QuestionHash,AnswersHash);
                                        value = 1;
                                        System.out.println();
                                        break;
                                    case 0:
                                        value = 1;
                                        break;
                                    default: 
                                        System.out.println("Enter a number please"); 
                                        break;
                                }      
                            }
                            catch(IOException e)
                            {
                                e.printStackTrace(); 
                            }
                        }


                        //////////
                        break;
                    case 2:
                        //System.out.println("[Error]: Still in Development");
                        //System.out.println("");
                        takeQuiz();
                        break;
                    case 3: 
                        //System.out.println("[Error]: File Opener Still in Development");
                        //int userfileInput = stringLineReader();
                        System.out.println("Options : [1] - Question Files \t[2] - Answer Key \t[3] - Student Files \t[4]- Save File");
                        int numFileInput = Integer.parseInt(reader.readLine());
                        switch(numFileInput){
                            case 1: //Access Questions File
                                
                                File folder = new File("QuestionFiles/");
                                File[] listOfFiles = folder.listFiles();
                                for(int i=0; i<listOfFiles.length; i++)
                                {
                                    if(listOfFiles[i].isFile())
                                    {
                                        System.out.println("File "+listOfFiles[i].getName());
                                    }
                                    else if(listOfFiles[i].isDirectory())
                                    {
                                        System.out.println("Directory "+listOfFiles[i].getName());
                                    }
                                }
                                System.out.println("Enter file name");
                                String fileName = stringLineReader();
                                ProcessBuilder pb = new ProcessBuilder("Notepad.exe","QuestionFiles/"+fileName+".txt");
                                pb.start();
                                System.out.println("[Notification]: File Opened Successfully");
                                System.out.println("");
                                break;

                            case 2: //Access Answer Key
                                File folderAnswer = new File("AnswerKey/");
                                File[] listOfFilesAnswer = folderAnswer.listFiles();
                                for(int i=0; i<listOfFilesAnswer.length; i++)
                                {
                                    if(listOfFilesAnswer[i].isFile())
                                    {
                                        System.out.println("File "+listOfFilesAnswer[i].getName());
                                    }
                                    else if(listOfFilesAnswer[i].isDirectory())
                                    {
                                        System.out.println("Directory "+listOfFilesAnswer[i].getName());
                                    }
                                }
                                System.out.println("Enter file name");
                                String fileNameAnswer = stringLineReader();
                                ProcessBuilder pbAnswer = new ProcessBuilder("Notepad.exe","AnswerKey/"+fileNameAnswer+".txt");
                                pbAnswer.start();
                                System.out.println("[Notification]: File Opened Successfully");
                                System.out.println("");
                                break;
                            case 3: //Access Student Files
                                File folderStudent = new File("StudentFiles/");
                                File[] listOfFilesStudent = folderStudent.listFiles();
                                for(int i=0; i<listOfFilesStudent.length; i++)
                                {
                                    if(listOfFilesStudent[i].isFile())
                                    {
                                        System.out.println("File "+listOfFilesStudent[i].getName());
                                    }
                                    else if(listOfFilesStudent[i].isDirectory())
                                    {
                                        System.out.println("Directory "+listOfFilesStudent[i].getName());
                                    }
                                }
                                System.out.println("Enter file name");
                                String fileNameStudent = stringLineReader();
                                System.out.println("Enter student name");
                                String studentName = stringLineReader();
                                ProcessBuilder pbStudent = new ProcessBuilder("Notepad.exe","StudentFiles/"+fileNameStudent+" - "+studentName+".txt");
                                pbStudent.start();
                                System.out.println("[Notification]: File Opened Successfully");
                                System.out.println("");
                                break;
                            case 4: //Access Save File
                                File folderSave = new File("SaveFile/");
                                File[] listOfFilesSave = folderSave.listFiles();
                                for(int i=0; i<listOfFilesSave.length; i++)
                                {
                                    if(listOfFilesSave[i].isFile())
                                    {
                                        System.out.println("File "+listOfFilesSave[i].getName());
                                    }
                                    else if(listOfFilesSave[i].isDirectory())
                                    {
                                        System.out.println("Directory "+listOfFilesSave[i].getName());
                                    }
                                }
                                System.out.println("Enter file name");
                                String fileNameSave = stringLineReader();
                                ProcessBuilder pbSave = new ProcessBuilder("Notepad.exe","SaveFile/"+fileNameSave+".txt");
                                pbSave.start();
                                System.out.println("[Notification]: File Opened Successfully");
                                System.out.println("");
                                break;
                            default: 
                                System.out.println("[Error]: Please enter a valid number");
                                break;
                        }
                        
                        break;
                    default:
                        System.out.println("[Error]: Please Enter a valid number");
                        System.out.println("");
                        break;
                }
            }
            catch(IOException e)
                {
                    e.printStackTrace(); 
                }
        }
        
    }
}

