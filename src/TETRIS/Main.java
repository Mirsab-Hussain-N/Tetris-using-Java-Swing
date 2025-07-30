package TETRIS;

import javax.swing.JFrame;
public class Main{
    public static void main(String[] args) {
        JFrame window = new JFrame("TETRIS");
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);      //MAKES IT CLOSABLE
        window.setResizable(false);
        

        //window.setLocation(null);       //make its at center
        

        GamePanel gp = new GamePanel();
        
        window.add(gp);
        window.pack();                  //this window will be set to the fixed gp size we made

        window.setLocationRelativeTo(null); 
        window.setVisible(true);        //quite important if u want to see
        
        gp.launchGame();
    }
}