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
           
            if(questionType == 1)
            {
                TrueOrFalse tf = new TrueOrFalse();
                System.out.println("[Question] : " + questionAsked);
                System.out.println(tf);
            }
            else if(questionType == 2)
            {
                
                ArrayList<MultipleChoice> mul = new ArrayList<>();
                MultipleChoice choice = new MultipleChoice("Aug 16, 1999");
                MultipleChoice choice2 = new MultipleChoice("Aug 21, 2003");
                MultipleChoice choice3 = new MultipleChoice("Sept 30, 1885");
                MultipleChoice choice4 = new MultipleChoice("Dec 21, 1965");
                mul.add(choice);
                mul.add(choice2);
                mul.add(choice3);
                mul.add(choice4);
                

                System.out.println("[Question] : " + questionAsked);
                System.out.println(mul);
            }
        }

        @Override
        public String toString()
        {
            return "[Question Type] : " + questionType + " [Question Asked] : " + questionAsked;
        }
        

    }

    public static class MultipleChoice 
    {
        private String mulAnswer;

        MultipleChoice(String mulAnswer)
        {
            this.mulAnswer = mulAnswer;
        }

        @Override
        public String toString()
        {
            return "[Multiple Choice Option] : " + mulAnswer;
        }
    }

    public static class TrueOrFalse 
    {
        TrueOrFalse()
        {

        }

        @Override
        public String toString()
        {
            return "[T/F]";
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
        Questions question1 = new Questions(2,"What is my Birthday");
        Questions question2 = new Questions(1,"Is my Birthday Aug 16,1999");

        // ArrayList<Questions.MultipleChoice> array = new ArrayList<>();
        // Questions.MultipleChoice multiplechoice1 = new Questions.MultipleChoice("hello");
        // Questions.MultipleChoice multiplechoice2 = new Questions.MultipleChoice("hello2");
        // array.add(multiplechoice1);
        // array.add(multiplechoice2);
        // Questions.TrueOrFalse trueorfalse1 = new Questions.TrueOrFalse();
        
        //System.out.println(question1);
        // System.out.println(array);
        // System.out.println(trueorfalse1);

        question1.initiateQuestion();
        question2.initiateQuestion();
    }
}