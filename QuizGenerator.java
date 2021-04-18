import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class QuizGenerator {
    
    //Questions
    public static class Questions 
    {
        //Types of Questions
        private int questionType;
        private String questionAsked;

        Questions(int questionType, String questionAsked)
        {
            this.questionType = questionType;
            this.questionAsked = questionAsked;
        }

        public void initiateQuestion()
        {
           
            if(questionType == 1) //True or False
            {
                System.out.println("What is the user input: true/false?");
                try
                {
                    BufferedReader userinput1 = new BufferedReader(new InputStreamReader((System.in)));
                    BufferedReader answerinput1 = new BufferedReader(new InputStreamReader((System.in)));

                    String uinput1 = Boolean.parseBoolean(userinput1.readLine());

                    System.out.println("What is the answer: true or false?");
                    
                    boolean answerkey1 = answerinput1.readLine();
                    TrueOrFalse tf = new TrueOrFalse(answerkey1);

                    System.out.println("[Question] : " + questionAsked);
                    System.out.println(tf);
                }
                catch(IOException e){   
                    e.printStackTrace(); 
                }       
            }
            else if(questionType == 2) //Multiple Choice
            {
                
                ArrayList<MultipleChoice> mul = new ArrayList<>();
                MultipleChoice choice = new MultipleChoice("Aug 14, 1999",true);
                MultipleChoice choice2 = new MultipleChoice("Aug 21, 2003",false);
                MultipleChoice choice3 = new MultipleChoice("Sept 30, 1885",false);
                MultipleChoice choice4 = new MultipleChoice("Dec 21, 1965",false);
                mul.add(choice);
                mul.add(choice2);
                mul.add(choice3);
                mul.add(choice4);
                
                System.out.println("[Question] : " + questionAsked);
                System.out.println(mul);
            }
            else if(questionType == 3) //Open Ended
            {
                
            }
            else if(questionType == 4) //Mutiple Answers 
            { 
                ArrayList<MutipleAnswers> mutanswer = new ArrayList<>();
                MutipleAnswers ma1 = new MutipleAnswers("Ryan", true);
                MutipleAnswers ma2 = new MutipleAnswers("Alan",false);
                MutipleAnswers ma3 = new MutipleAnswers("Justin",true);
                MutipleAnswers ma4 = new MutipleAnswers("Hart",true);
                mutanswer.add(ma1);
                mutanswer.add(ma2);
                mutanswer.add(ma3);
                mutanswer.add(ma4); 

                System.out.println("[Question] : " + questionAsked);
                System.out.println(mutanswer);
            }
        }

        @Override
        public String toString()
        {
            return "[Question Type] : " + questionType + " [Question Asked] : " + questionAsked;
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
            return " The answer for this [T/F] question is " + " (" + answer  + ")";
        }
    }
    
    public static class MultipleChoice 
    {
        private String mulAnswer;
        private boolean correct;

        MultipleChoice(String mulAnswer, boolean correct)
        {
            this.mulAnswer = mulAnswer;
            this.correct = correct;
        }

        @Override
        public String toString()
        {
            return "[Multiple Choice Option] : " + mulAnswer + " (" + correct+")";
        }
    }

    
    // Hi welcome our program 
    // from 1-4  
    // take the user input  
    // 1 ask them for following: question, choices, and answer
    // answer can be put into arraylist which contains all the answer for type true/false
    // when time to answer said questions 


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

   


    public static void main(String args[])
    {
    
       
     
        
        
        BufferedReader reader = new BufferedReader(new InputStreamReader((System.in)));
        
        while(true)
        {
            System.out.println("Insert Question Type : [1] - True/False \t[2] - Multiple Choice \t[3] - Open Ended \t[4] Multiple Answers");

        try 
        {
            int num = Integer.parseInt(reader.readLine()); 
        
            switch(num) 
            {
                case 1:
                    System.out.println(" For the answer please put in the format of true or false");  
                    BufferedReader Q1 = new BufferedReader(new InputStreamReader((System.in)));
                    String input1 = Q1.readLine();
                    Questions question1 = new Questions(1,input1);
                    question1.initiateQuestion();

                    break; 
                    
                case 2:
                    System.out.println(" For the answer please use the following format # of choices possible, choice options, answers to mc ");
                    BufferedReader q2  = new BufferedReader(new InputStreamReader(System.in)); 
                    String input2 = q2.readLine(); 
                    Questions question2 = new Questions(2,input2);
                    question2.initiateQuestion();
                    break;

                case 3:
                    System.out.println(" For the answer please put in the format of Open Ended: a variable ");  
                    BufferedReader q3  = new BufferedReader(new InputStreamReader(System.in)); 
                    String input3 = q3.readLine();      
                    Questions question3 = new Questions(2,input3);
                    question3.initiateQuestion();    

                    
                    break;
                case 4:
                    System.out.println(" For the answer please put in the format of Multiple Answer"); 
                    BufferedReader Q4 = new BufferedReader(new InputStreamReader((System.in)));
                    String input4 = Q4.readLine();
                    Questions question4 = new Questions(4,input4);
                    question4.initiateQuestion();

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