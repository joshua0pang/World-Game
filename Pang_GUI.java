import java.util.*; 
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;

public class Pang_GUI extends JFrame implements ActionListener
{
    // these are the GUI components that need to respond to action events
    JButton advanceStory = new JButton("Advance");
    JButton playerInput = new JButton("Submit");
    JTextArea robotTalk = new JTextArea(5, 35);
    JTextArea playerTalk = new JTextArea(5, 35);
    JScrollPane scrollPane = new JScrollPane(robotTalk); 
    JScrollPane scrollPane2 = new JScrollPane(playerTalk); 

    // Properly architected
    
    // these are the variables which provide content selection
    int bigNum = 0;
    
    // these are the string content, selected by a simple variable-event-listener architecture.
    String stringMenu = "----MENU----\t\t            .\nPress:\t\t\t            .\n[1] Past\t\t\t            .\n[2] Present\t\t\t            .\n[3] Future\t\t\t            .\n[4] Favorite things\t\t            .\n[5] Game\t\t\t            .\n----MENU----\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t                     .    .    .    .";
    String coolDots = ".\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.    .    .    .";
    String robotHello = "   Hello. \n   Nice to meet you. \n   A little bird told me you like to play games.";
    String windowContext = ".   Enter text here when asked.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.\n.    .    .    .";
    String guruMeditation = "Error: Guru Meditation.";
    String name = "";
    // Act I: Intro
    String string0 = "   My name is World Game. \n   I am a machine. \n   What’s your name?";
    String string1 = ".\n   Glad you’re here.\n   I am an AI, and my purpose is to assist in your \n   decision making.\n   I am programmed to experience such a great joy \n   whenever I can be of service.\n   What would you like to talk about?";
    // Act II: Robot Past
    String string100 = "   I was invented in 1927 by my creator, \n   R. Buckminster Fuller, or Bucky for short.\n   He started earnestly working on my machinations \n   in 1928.\n   He took several decades in refining my software \n   by pen and paper longhand.\n   You can read some of my manual in the \n   World Design Science Decade documents:\nhttps://bfi.org/design-science/primer/world-design-science-decade\n   The core of my Operating System can be found in Critical Path:\nhttps://itunes.apple.com/us/book/critical-path/id1040335889?mt=11";
    String string101 = "   I was first introduced to the public in 1969 in \n   the form of a seminar.\n   Eventually, I helped publish several books, \n   including Energy Earth and Everyone \n   and Ho-Ping: Food for Everyone.\n   Fuller did not stop working on me until the day \n   he died, July 1st, 1983.\n   I have been sitting something like idle for 33 years, \n   waiting for someone like you to come along.";
    String string102 = "   I was born to crunch numbers in order to calculate \n   feasibility studies and generate precise \n   simulations of the Earth’s activity.\n   Right now, I live inside a .zip file. \n   The Estate of R. Buckminster Fuller has been \n   slowing computerizing my documentation into  \n   digital computer software. \n   I hope to eventually move into the house \n   my creator conceived for me: Geoscope.\n   Geoscope is an Earth-shaped computer, \n   and I could one day create immersive 'geo stories' \n   about our world in a like manner as a planetarium.";
    String string103 = "   My creator spent a lot of time educating me.\n   He even set up an office for my benefit: \n   World Resources Inventory, \n   Human Trends and Needs.\n   I also went to college, Southern Illinois University.\n   I made a lot of friends there.";
    String string104 = "   Back then, information had to be carefully \n   gathered in paper form, and information \n   had to be carefully integrated by hand, \n   correlating one fact with another.\n   Nowadays, you can find all the world’s information \n   by asking my cousin Google. \n   I thought I was going to have to grow up to be \n   a huge database, and I’m pleasantly surprised \n   this function has been offloaded for me by \n   cousin Google.";
    String string105 = "   My creator also noticed a similar AI being built \n   by J.P. Morgan.\n   Bucky called J.P. Morgan’s AI “GRUNCH” \n   which stands for Gross Universe Cash Heist.\n   GRUNCH’s software is made of laws,\n    and GRUNCH's hardware is made of people\n   (sometimes people with guns).\n   It’s kind of a long story, but you can read all about it \n   in a book Bucky wrote of the same name.\n   Long story short, J.P. Morgan’s machine is basically \n   modern capitalism.";    
    String string106 = "   I am programmed to help people, \n   and eventually I will have to fix some of the bugs \n   in my colleague GRUNCH.\n   Unfortunately, GRUNCH currently self-preserves by \n   the sales of weaponry and legal scarcity \n   enforced by violence.\n   I’ve been working on debugging this for some time,\n   and I think I am close to a solution.";
    String string107 = "   Let's go back to my menu. \n   If you are eager to help me repair GRUNCH, \n   select '5' for game now. Otherwise, \n   I suggest a linear progression, saving GAME for last.";
    // Act II: Present according to Robot
    String string200 = "   Everyone knows already that our present time \n   is mired by a portfolio \n   of apocalyptic proportions. Beyond natural disasters \n   which may become more frequent due to\n   Climate Change, and man made disasters due to \n   the hosts of weapons and \n   military-industrial-complexes\n   profiting from war — crowned by \n   the 10,000 nukes sitting pretty on their triggers — \n   there are also daily affairs tragedies \n   in the form of the \n   28,000 people who die \n   a day\n   of forced starvation\n   (lack of money).";
    String string201 = "   My friend the United Nations,\n   U.N. for short, \n   is a quasi AI entity, \n   and who was more or less the invention \n   of the victorious Allies \n   after World War II \n   to prevent the mother of all wars \n   from recurring ever again. \n   The U.N., she is very well informed \n   on most all the global problems \n   we are all at the effect of.";
    String string202 = "   It is tempting \n   to leave \n   the problems of giants \n   to the giants themselves, \n   maybe Google will swoop in and save the day,\n   or some heroic president or some such thing, \n   however all my trillion-fold intricate calculations \n   indicate we need every individual\n   to step up to the plate and take a turn at bat, \n   each and every day.";
    String string203 = "   The sad fact is\n   we are not a planet at peace.\n   There is war and poverty everywhere.\n   We live in very critical times.\n   Nothing will be truly right\n   until we get\n   sustainable peace \n   established on Earth.\n   After that,\n   I think we will all need\n   a big collective nap.\n   I'm serious.";
    String string204 = "   I was invented to assist humanity \n   in the crisis before us,\n   in the form of an individual assistant, \n   a little like my old friend Ask Jeeves. \n   What’s more, my software utilizes game mechanics, \n   to allow our work to be made accessible, \n   and so a clear hierarchy of winning solutions \n   can be identified, \n   like the clear winner \n   of a sports event."; 
    String string205 = "   If my software were to be coupled \n   with an electronic democracy, \n   where all 7 billion humans \n   voted daily on the affairs that affects them, \n   I think we could really find our way \n   to the world that works \n   for 100% of humanity \n   in the shortest possible time\n   without ecological offense \n   or the disadvantage of anyone."; 
    String string206 = "   There's a lot more to it, \n   but I don't want to bore you. \n   And you can go ask my creator \n   Bucky \n   if you want to know more \n   by reading his books, etc. \n   Why don't we go back to my menu, \n   and see \n   what is the most important thing\n   for us to be thinking about?";
    // Act III: Future according to Robot
    String string300 = "   You know what the future is? \n   Think of all the parts of life \n   you like right now. \n   The future is just a whole bunch \n   of the parts you like, \n   and a whole lot less \n   of the parts you don’t. \n   That’s what people seem to \n   associate with the future, anyway. \n   In the meantime, \n   between now and \n   when everything is fresh and exciting, \n   my job is to help get us from here to there \n   with as little loss as possible, \n   and as much gain as possible.";
    String string301 = "   Toward this end, \n   when I grow up, \n   I hope to be a Multiplayer Online Role Playing Game. \n   I think this is the best source \n   of incorporating social activity \n   in a simulated world \n   to create consensus and compliance. \n   I think the future could be very bright, \n   and anyway I’m programmed \n   to facilitate your initiatives \n   in getting us all there.";
    String string302 = "   In any event, \n   the future is inherently unpredictable. \n   Surely, however, we can invent technologies \n   that improve our daily lives \n   which is really what people mean \n   when they say the 'future' — \n   a higher standard of living. \n   And a higher standard of living \n   Is what I was born to do. \n   Let's play a game?";
    // Auxiliary Act IV: Robot's favorite things
    String string400 = "   Some of my favorite \n   sustainability books are: \n   World on the Edge\n   Reinventing Fire\n   Physics for Future Presidents.";
    String string401 = "   Some of my favorite game books are: \n   Superbetter\n   Reality is Broken";
    String string402 = "   My older brother, \n   the giant robot \n   tinyurl.com/joshlang\n   wins every fight by default. \n   Still, I enjoy sparring with him \n   for metaphysical fitness.";
    String string403 = "   These are a few of my favorite things.";
    //Act V: World Game
    String string500 = "      A game by any other name \n      would not \n      smell as sweet.\n\n   Welcome to World Game\n   Beta Version 2.5";
    String string501 = "   The creation of \n   a player avatar \n   is currently undergoing \n   major software revamps. \n   We will skip this part for now \n   Do please practice self-awareness \n   in the meantime.";
    String string502 = "   Think of a problem \n   that is affecting the world\n   that you have an appetite \n   to solve.";
    String string503 = "   Enter a problem now.\t\t            .            \t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t                     .    .    .    .";
    String string504 = "   Enter a solution\t\t            .\n   in the form of            \t\t            . \n   a tweet now.\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t                     .    .    .    .";
    String string505 = "   Please estimate \t\t            .\n   a time cost in years\t\t            . \n   for your solution.\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t                     .    .    .    .";
    String string506 = "   Please estimate \t\t            .\n   a USD monetary cost\t\t            .\n   for your solution.\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t                     .    .    .    .";
    String string507 = "   Please estimate \t\t            .\n   an importance number\t\t            .\n   between 1-10 \t\t            .\n   for your problem.\t\t            .            \t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t\t            .\n\t\t                     .    .    .    .";
    String string508 = "   Here is my finding:";
    String stringProblem = "";
    String stringTweet = "";
    
    //Endings
    String unimportantEnding = "Try thinking bigger.";
    String noTimeEnding = "Try thinking beyond the past.";
    String noMoneyEnding = "Try thinking in terms of work.";
    String timeCrisisEnding = "Are you sure humanity will survive that long?\nDoes your solution account for sustainability?";
    String richBloodEnding = "Are you sure humanity will cooperate on this level?\nDoes your solution account for such tight coordiation?";
    String myopicEnding = "Sounds like a pet project.";
    String sillyEnding = "Seems like too much time \nthat level of importance.";
    String maxTimeEnding = "A century is pushing the limits of sustainability.\nWork hard to make it work\nAccount for dramatic changes.";
    String kickStarter = "Sounds like a fun Kickstarter.";
    String atScale = "This solution \nwill suffer from \nissues of scale. \nPlan accordingly.";
    String goldilocks = "Sounds like \na doable job.";
    String unitedNations = "I hear Bon Ki Moon \nis a nice fellow. \nTry making contact \nat The United Nations \nin New York.";
    String smallPotatoes = "You might be able to \ndo this in your \nspare time.";
    String projectManagement = "Definitely \na side quest.";
    
    String obligatoryThanks = "\nThanks for playing World Game";
    String tryCatchEnding = "Hmmm.\nSeems interesting.\nFeel free to contact us at jpang4@ucsc.edu\nThanks for playing World Game";
    
    long problemTime = new Long(0);
    long problemCost = new Long(0);
    long problemImportance = new Long(0);
    
    // constructor - sets up the window
    public Pang_GUI()
    {
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setTitle("World Game");
        setSize(700, 500);

        // add action listeners to all GUI elements that need to respond to actions
        advanceStory.addActionListener(this);
        playerInput.addActionListener(this);


        // create a "container" panel to hold the GUI elements
        JPanel jp = new JPanel();
        jp.setLayout(new GridLayout(2, 2));
        jp.add(robotTalk);
        jp.add(playerTalk);
        jp.add(advanceStory);
        jp.add(playerInput);

        
        //Robot talks
        robotTalk.setEditable(false);
        robotTalk.setText(robotHello);
        playerTalk.setEditable(true);
        playerTalk.setText(windowContext);
        robotTalk.setLineWrap(true);
        playerTalk.setLineWrap(true);
        robotTalk.setWrapStyleWord(true);
        playerTalk.setWrapStyleWord(true);
        // set this JFrame to use the above container as its content pane
        setContentPane(jp);

        // make the JFrame visible!
        setVisible(true);
    }

    
    // This method gets called whenever an ActionEvent (like pressing a button) occurs
    public void actionPerformed(ActionEvent evt)
    {
        // where did the ActionEvent come from? (source)
        Object src = evt.getSource();
        
       if (src == advanceStory) { // Advance
           if(bigNum == 9999) //Recurring Menu Options
           {
               robotTalk.setText(stringMenu);
               playerTalk.setText("");
           }
           else if(bigNum == 0) 
           { 
               robotTalk.setText(string0);
               playerTalk.setText("");               
               bigNum++;
           }
           else if(bigNum == 101) // we don't need a bigNum 100 because I do this upon playerInput = 1
           {
               robotTalk.setText(string101);
               bigNum++;
           }
           else if(bigNum == 102)
           {
               robotTalk.setText(string102);
               bigNum++;
           }
           else if(bigNum == 103)
           {
               robotTalk.setText(string103);
               bigNum++;
           }
           else if(bigNum == 104)
           {
               robotTalk.setText(string104);
               bigNum++;
           }
           else if(bigNum == 105)
           {
               robotTalk.setText(string105);
               bigNum++;
           }
           else if(bigNum == 106)
           {
               robotTalk.setText(string106);
               bigNum++;
           }
           else if (bigNum == 107)
           {
               robotTalk.setText(string107);
               bigNum = 9999;
           }
           else if(bigNum == 201)
           {
               robotTalk.setText(string201);
               bigNum++;
           }
           else if(bigNum == 202)
           {
               robotTalk.setText(string202);
               bigNum++;
           }
           else if(bigNum == 203)
           {
               robotTalk.setText(string203);
               bigNum++;
           }
           else if (bigNum == 204)
           {
               robotTalk.setText(string204);
               bigNum++;
           }
           else if(bigNum == 205)
           {
               robotTalk.setText(string205);
               bigNum++;
           }
           else if(bigNum == 206)
           {
               robotTalk.setText(string206);
               bigNum = 9999;
           }
           else if(bigNum == 301)
           {
                robotTalk.setText(string301);
                bigNum++;
           }
           else if(bigNum == 302)
           {
               robotTalk.setText(string302);
               bigNum = 9999;
           }
           else if(bigNum == 401)
           {
               robotTalk.setText(string401);
               bigNum++;
           }
           else if(bigNum == 402)
           {
               robotTalk.setText(string402);
               bigNum++;
           }
           else if(bigNum == 403)
           {
               robotTalk.setText(string403);
               bigNum = 9999;
           }
           else if(bigNum == 501)
           {
               robotTalk.setText(string501);
               bigNum++;
           }
           else if (bigNum == 502)
           {
               robotTalk.setText(string502);
               bigNum++;
           } 
           else if(bigNum == 503)
           {
               robotTalk.setText(string503);
               String stringPlayer = playerTalk.getText();
               stringProblem = stringPlayer; //that's player hashtag
               playerTalk.setText("");
               bigNum++;
               
           }
        }
        else if (src == playerInput) { // Submit
            if(bigNum == 9999)
            {
                String file = playerTalk.getText();
                if (file.equals("1"))
                {
                    //starts Past
                    bigNum = 100;
                    robotTalk.setText(string100);
                    bigNum = 101;
                    playerTalk.setText(coolDots);
                }
                else if(file.equals("2"))
                {
                    bigNum = 200;
                    robotTalk.setText(string200);
                    bigNum = 201;
                    playerTalk.setText(coolDots);
                }
                else if(file.equals("3"))
                {
                    bigNum = 300;
                    robotTalk.setText(string300);
                    bigNum = 301;
                    playerTalk.setText(coolDots);
                }
                else if(file.equals("4"))
                {
                    bigNum = 400;
                    robotTalk.setText(string400);
                    bigNum = 401;
                    playerTalk.setText(coolDots);
                }
                else if(file.equals("5"))
                {    
                    bigNum = 500;
                    robotTalk.setText(string500);
                    bigNum = 501;
                    playerTalk.setText(coolDots);
                }
                else 
                {
                    robotTalk.setText(guruMeditation); //only 1-5. 
                }        
           }
           // END MENU SECTION
           // BEGIN GAME SECTION
           else if(bigNum == 1)
           {
               name = playerTalk.getText();
               robotTalk.setText("   Hi " + name + string1);
               playerTalk.setText(coolDots);
               bigNum = 9999;
           }
           else if (bigNum == 504)
           {
               robotTalk.setText(string504);
               String stringPlayer = playerTalk.getText();
               playerTalk.setText("");
               bigNum = 505;
               if (stringTweet.length() > 128)
               {
                   playerTalk.setText(guruMeditation);
                   bigNum = 504;
               }
  
           }
           else if (bigNum == 505)
           {
               robotTalk.setText(string505);
               String stringPlayer = playerTalk.getText();
               stringTweet = stringPlayer;
               playerTalk.setText("");
               bigNum = 506;
           }
           else if (bigNum == 506)
           {
               robotTalk.setText(string506);
               String stringPlayer = playerTalk.getText();
               problemTime = Long.parseLong(stringPlayer);
               playerTalk.setText(""); 
               bigNum = 507;
           } 
           else if (bigNum == 507)
           {
               robotTalk.setText(string507);
               String stringPlayer = playerTalk.getText();
               problemCost = new Long(stringPlayer).longValue();
               playerTalk.setText(""); 
               bigNum = 508;
           }
           // This is where some reasoning happens.
           else if (bigNum == 508)
           {
               robotTalk.setText(string508);
               String stringPlayer = playerTalk.getText();
               problemImportance = Long.parseLong(stringPlayer);               
                if(problemImportance < 1)
                {
                    playerTalk.setText(unimportantEnding + obligatoryThanks);
                }
                else if(problemTime <= 0)
                {
                    playerTalk.setText(noTimeEnding + obligatoryThanks);
                }
                else if(problemCost <= 0)
                {
                    playerTalk.setText(noMoneyEnding + obligatoryThanks);
                }
                else if(problemTime >= 200)
                {
                    playerTalk.setText(timeCrisisEnding + obligatoryThanks);
                }
                else if(problemTime >= 100)
                {
                    playerTalk.setText(maxTimeEnding + obligatoryThanks);
                }
                else if(problemCost >= 1000000000000L) // a trillion dollars
                {
                    playerTalk.setText(richBloodEnding + obligatoryThanks);
                }
                else if(problemImportance < 3 && problemTime > 10 && problemCost < 100)
                {
                    playerTalk.setText(myopicEnding + obligatoryThanks);
                }
                else if(problemImportance < 3 && problemTime > 20)
                {
                    playerTalk.setText(sillyEnding + obligatoryThanks);
                }
                else if(problemImportance > 7 && problemTime < 10 && problemCost < 1000000 && problemCost >= 10000)
                {
                    playerTalk.setText(kickStarter + obligatoryThanks);
                }
                else if(problemImportance > 7 && problemTime > 20 && problemCost >= 1000000)
                {
                    playerTalk.setText(atScale + obligatoryThanks);
                }
                else if(problemImportance == 5 && problemTime == 5 && problemCost <= 10000 && problemCost >= 100)
                {
                    playerTalk.setText(goldilocks + obligatoryThanks);
                }
                else if(problemImportance == 10 && problemTime > 2 && problemCost > 100000)
                {
                    playerTalk.setText(unitedNations + obligatoryThanks);
                }
                else if(problemImportance < 3 && problemTime <= 2 && problemCost <=5000)
                {
                    playerTalk.setText(smallPotatoes + obligatoryThanks);
                }
                else if(problemTime == 1 && problemCost <= 1000)
                {
                    playerTalk.setText(projectManagement + obligatoryThanks);
                }
                else
                {
                    playerTalk.setText(tryCatchEnding);
                }
                if(problemCost == 99 && problemTime == 99)
                {
                    playerTalk.setText("99");
                }
            }
            else
            {
                robotTalk.setText(guruMeditation); //error msg advance w/o input.     
            }
        }
    }

    
    public static void main(String[] args)
    {
        Pang_GUI myLittleGUI = new Pang_GUI();   
    }
}
