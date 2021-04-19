Button[] buttons = new Button[3];
PFont f;                           

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
  // Code to setup your scene goes here
  size(600, 600);
  f = createFont("Arial", 56);
  
  for(int i = 0; i < buttons.length; i++){
    buttons[i] = new Button(50, 150 + (150 * i), 500, 50);
  }
}

void draw(){
  // Code here will be run once for each frame.
  // There is no starter code for this assignment because an example is already provided
  // with the Processing Sound Library.  Look for the example located at Sound/SoundFile/Keyboard.
  // Examples can be found in the File menu.
  for(int i = 0; i < buttons.length; i++) {
    buttons[i].display();
  }
  textAlign(CENTER);
  textFont(f,56);
  text("Welcome to QuizMaker!",300,52);
  textFont(f,36);
  text("Please select an option below", 300, 90);
  fill(255);
  text("Make a new quiz",300,190);
  text("Take a quiz",300,340);
  text("View an answer key",300,490);
}

void mousePressed() { //If mouse is pressed on button and its activated, play sound
  for(int i = 0; i < buttons.length; i++) {
    buttons[i].click(mouseX, mouseY);
  }
  
  ////--------------------------Button 1------------------------------
  
  //if(buttons[0].getActivated() == true)
  //{
  //  for(int i=0; i<10;i++)
  //  {
  //    file[i].stop();
  //  }
  //  file[0].play(); 
  //}
  //else
  //{
  //  file[0].stop();
  //}
  
  ////---------------------------Button 2------------------------------
  
  //if(buttons[1].getActivated() == true)
  //{
  //  for(int i=0; i<10;i++)
  //  {
  //    file[i].stop();
  //  }
  //  file[1].play(); 
  //}
  //else
  //{
  //  file[1].stop();
  //}
  
  ////----------------------------Button 3-------------------------------
  
  //if(buttons[2].getActivated() == true)
  //{
  //  for(int i=0; i<10;i++)
  //  {
  //    file[i].stop();
  //  }
  //  file[2].play(); 
  //}
  //else
  //{
  //  file[2].stop();
  //}
}
