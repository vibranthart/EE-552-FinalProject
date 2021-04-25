//IMPORTS HERE
import processing.core.*;
Button[] buttons = new Button[3];
TextBox Box1;
PFont f;                           
int NumQuestions;
String typing = "";
String saved = "";
//==================================== BUTTON CLASS CREATION ===============================================
class Button{
  //Location & size
  float x;
  float y;
  float wd;
  float ht;
  boolean on;
  private boolean activated;
  
  //Constructor
  Button(float x1, float y1, float wd1, float ht1){
    x = x1;
    y = y1;
    wd = wd1;
    ht = ht1;
  }
  
  //Button Click Function
  void click(int mx, int my){
    if(mx > x && mx < x + wd && my > y && my < y + ht){
      on = !on;
    }
  }
  
  //Button Display Function
  void display() {
    rectMode(CORNER);
    stroke(2);
    fill(0);
    rect(x, y, wd, ht);
  }
  
  //Button Activation Function
  public boolean getActivated(){
    activated = on;
    return activated;
  }
}

void setup(){
  size(600, 600); //Size of Screen
  
  f = createFont("Arial", 56); //Creates Arial Font instance
  
  selectInput("Select a file to process:", "fileSelected"); //
  
  for(int i = 0; i < buttons.length; i++){ //Create buttons on screen
    buttons[i] = new Button(50, 150 + (150 * i), 500, 50);
  }
  
  Box1 = new TextBox(50, 550, 500, 45);
}

void draw(){
  for(int i = 0; i < buttons.length; i++) { //Calls Display function to show buttons on screen
    buttons[i].display();
  }
  
  
  textAlign(CENTER); //Obvious
  
  textFont(f,56); //Sets up size 56 font
  text("Welcome to QuizMaker!", 300 ,52);
  
  textFont(f,36); //
  text("Please select an option below", 300, 90);
  fill(255);
  text("Make a new quiz",300,190);
  text("Take a quiz",300,340);
  text("View an answer key",300,490);
  buttonPressed();
}

//void fileSelected(File selection) {
//  if (selection == null) {
//    println("Window was closed or the user hit cancel.");
//  } else {
//    println("User selected " + selection.getAbsolutePath());
//  }
//}

void mousePressed() { //If mouse is pressed on button and its activated, play sound
  for(int i = 0; i < buttons.length; i++) {
    buttons[i].click(mouseX, mouseY);
  }
}

void buttonPressed() {
 //--------------------------MakeQuiz------------------------------
  if(buttons[0].getActivated() == true)
  {
    //Take user input on how many questions they want the quiz to be
    fill(0);
    
    Box1.draw();
    
    textAlign(CENTER);
    
    text("How many questions would you like?", 300, 550);
    //Open the Quiz Creator file
    //Call file and send saved (string) to next file to be cast as an int
    //Use PApplet.runSketch() function -> passes String[] + a PApplet!
    
    //PApplet.runSketch(MakeQuiz.pde, null);
  }
  
  //---------------------------TakeQuiz------------------------------
  
  if(buttons[1].getActivated() == true)
  {
    //Get Quiz they are taking
    Box1.draw();
    
    textAlign(CENTER);
    
    text("What quiz would you like to take?", 300, 550);
    //Open the Taking Quiz file
  }
  
  //----------------------------AnswerKey-------------------------------
  
  if(buttons[2].getActivated() == true)
  {
    //Get Answer Key they are using
    Box1.draw();
    
    textAlign(CENTER);
    
    text("Which Answer Key would you like to see?", 300, 550);
   //Open the Answer Key files
  }
}