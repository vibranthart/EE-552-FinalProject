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
import java.io.OutputStreamWriter;
import java.util.*;


//NOTES
// Hi welcome our program 
// from 1-4  
// take the user input  
// 1 ask them for following: question, choices, and answer
// answer can be put into arraylist which contains all the answer for type true/false
// when time to answer said questions 


public class QuizGenerator {
    
//===================================Questions================================================
    public static class Questions 
    {
        //Types of Questions
        private String questionAsked;
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
                System.out.println("Input the m/c opinion");
                System.out.println("Ex: a) Blackbeard");
                String a = stringLineReader();
                
                System.out.println("Input the m/c opinion");
                System.out.println("Ex: b) Jamie from Joe Rogan Podcase");
                String b = stringLineReader();
                
                System.out.println("Input the m/c opinion");
                System.out.println("Ex: c) Columbus");
                String c = stringLineReader();
    
                System.out.println("Input the m/c opinion");
                System.out.println("Ex: d) Johnny Depp");
                String d = stringLineReader();

                mul.add("a) "+a); 
                mul.add("b) "+b);
                mul.add("c) "+c); 
                mul.add("d) "+d); 

                return mul;
            }
            else if(questionType == 3) // Open end 
            {
                ArrayList<String> opend = new ArrayList<>();
                System.out.println("Input Hints If Neede");
                System.out.println("Ex: Make sure to mention 'Why The British Lost' to get full credit");
                String a = stringLineReader();
                opend.add(a); 

                return opend; 
            }
            else if(questionType == 4) // mutiple answers 
            {
                ArrayList<String> mula = new ArrayList<>();
                System.out.println("Input the m/a opinion");
                //System.out.println("Ex: a) Blackbeard");
                String a = stringLineReader();
                
                System.out.println("Input the m/a opinion");
                //System.out.println("Ex: b) Jamie from Joe Rogan Podcase");
                String b = stringLineReader();
                
                System.out.println("Input the m/a opinion");
                //System.out.println("Ex: c) Columbus");
                String c = stringLineReader();
    
                System.out.println("Input the m/a opinion");
                //System.out.println("Ex: d) Johnny Depp");
                String d = stringLineReader();

                System.out.println("Input a m/a opinion");
                //System.out.println("Ex: e) SpongeBob Squarepants");
                String e = stringLineReader();

                System.out.println("Input a m/a opinion");
                //System.out.println("Ex: f) Patrick Starfish");
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

        @Override
        public String toString()
        {
            //return "[Question Type] : " + questionType + " [Question Asked] : " + questionAsked;
            return "[Question] : "+questionAsked;
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

//===================================Multiple Choice================================================
    public static class MultipleChoice 
    {
        private String mulAnswer;
        private boolean correct;

        MultipleChoice(String mulAnswer)
        {
            this.mulAnswer = mulAnswer;
        }

        // public void inputAnsChoice()
        // {
        //         System.out.println("[How Many Multiple Choice] : ");
        //         int count = intLineReader();

        //         for(int i = 0; i<count; i++)
        //         {
        //             System.out.println("[Enter Answer Choice] : ");
        //             String input = stringLineReader();
        //             MultipleChoice choice = new MultipleChoice(input);
        //             //mul.add(choice);
        //         }
        // }

        public void check(){
            // look if the text file and the user input is the same 
            // if they are they get a point 
            // some thing simple as this 
        }

        @Override
        public String toString()
        {
            return "[Multiple Choice Option] : " + mulAnswer + " (" + correct+")";
        }
    }

    
//===================================Open Ended================================================
    public static class OpenEnded
    {
        private String correct;
        OpenEnded(String correct)
        {
            this.correct = correct;
        }

        @Override
        public String toString()
        {
            return "[Open Ended Question]";
        }
    }


//===================================Multiple Answers================================================
    public static class MutipleAnswers {

        private String mulAnswer;
        private boolean correct;

        MutipleAnswers(String mulAnswer, boolean correct){
            this.mulAnswer = mulAnswer;
            this.correct = correct;
        }

        @Override
        public String toString()
        {
            return "[Multiple Answer Options] : " + mulAnswer + " (" + correct + ")";
        }
    }
    
//===================================Answer Generator================================================
    public static class AnswerGenerator 
    {
        AnswerGenerator()
        {

        }


        @Override
        public String toString()
        {
            return "";
        }
    }

//===================================Write to File===============================================
    public static void makeFile(LinkedHashMap<Questions,List<String>> QuestionHash)
    {
        try 
        {
            System.out.println("");
            System.out.println("Enter File Directory, Name, and File Type");
            String fileName = stringLineReader();
            File newFile = new File("QuestionFiles/"+fileName);
            FileOutputStream is = new FileOutputStream(newFile);
            OutputStreamWriter osw = new OutputStreamWriter(is);
            BufferedWriter w = new BufferedWriter(osw);

            Iterator iterate = QuestionHash.entrySet().iterator();
            while (iterate.hasNext()) {
                Map.Entry obj = (Entry)iterate.next();
                //System.out.println(obj.getKey()+ " : [Answers] : \t"+obj.getValue());
                w.write(""+obj.getKey());
                w.newLine();
                w.newLine();
                w.write("\t[Answers] : "+obj.getValue());
                w.newLine();
                w.newLine();
            }
            w.close();
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

        while(true)
        {
            System.out.println("Insert Question Type : [1] - True/False \t[2] - Multiple Choice \t[3] - Open Ended \t[4] - Multiple Answers \t[5] - Show Questions \t[6] - Generate Amswer Sheet \t[7] - Show Answer Key");

            try 
            {
                int num = Integer.parseInt(reader.readLine()); 
              
                switch(num) 
                {   
                    case 1:
                        // System.out.println("For the answer please put in the format of true or false");  
                        // String input1 = stringLineReader();
                        // Questions question1 = new Questions(1,input1);
                        // QuestionList.add(question1);
                        // question1.initiateQuestion();
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
                        // System.out.println("For the answer please use the following format # of choices possible, choice options, answers to mc ");
                         
                        // System.out.println("Enter your question for m/c" + " (Do not put in a,b,c,d choice yet");
                        // System.out.println("Ex: Who sailed the Ocean during 1492?"); 
                        // String question = stringLineReader(); 
                        
                        // String input2 = stringLineReader();
                        // Questions question2 = new Questions(2,input2);
                        // QuestionList.add(question2);
                        // question2.initiateQuestion();
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
                        // System.out.println("For the answer please put in the format of Open Ended: a variable ");  
                        // String input3 = stringLineReader();
                        // Questions question3 = new Questions(2,input3);
                        // QuestionList.add(question3);
                        // question3.initiateQuestion();    
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
                        // System.out.println("For the answer please put in the format of Multiple Answer"); 
                        // String input4 = stringLineReader();
                        // Questions question4 = new Questions(4,input4);
                        // QuestionList.add(question4);
                        // question4.initiateQuestion();
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
                            // Map.Entry mapElement = (Map.Entry)it.next();
                            // int questions = ((int)mapElement.getValue());   
                            // System.out.println(mapElement.getKey() + " : " + questions);
                            Map.Entry obj = (Entry)it.next();
                            System.out.println(obj.getKey()+ " : [Answers] : \t"+obj.getValue());
                        }
                        break;
                    case 6:
                        //Quiz Generator to take -> Save to txt file
                        makeFile(QuestionHash);
                        break;
                    case 7:
                        //Make Answer Key
                        //Quiz file upload
                        System.out.println("Here are the results");
                        Iterator ity = AnswersHash.entrySet().iterator();
                        
                        while (ity.hasNext()) {
                            // Map.Entry mapElement = (Map.Entry)it.next();
                            // int questions = ((int)mapElement.getValue());   
                            // System.out.println(mapElement.getKey() + " : " + questions);
                            Map.Entry obj = (Entry)ity.next();
                            System.out.println(obj.getKey()+ " : [Answers] : \t"+obj.getValue());
                        }
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
}
}

