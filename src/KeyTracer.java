import java.awt.event.*;
import java.awt.event.KeyListener;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JTextField;


public class KeyTracer extends JFrame implements KeyListener {

    private JTextField textField;
    private Color defaultColor;
    private Color pressedColor = Color.PINK;

    String[] letters = "ABCDEFGHIJKLMNOPQRSTUVWXYZ".split("");
    JButton[] buttons = new JButton[26];
    JButton backspace,spacebar;
    JButton [] numB=new JButton[10];
    String numbers[]="0123456789".split("");

    public KeyTracer() {
        super("Virtual Keyboard");
        setLayout(new FlowLayout());
        for(int i=0;i<numB.length;i++){
            numB[i]=new JButton(numbers[i]);
            numB[i].setBackground(Color.LIGHT_GRAY);
            numB[i].setFocusable(false);
            add(numB[i]);
        }

        backspace=new JButton("Backspace");
        backspace.setBackground(Color.LIGHT_GRAY);
        backspace.setFocusable(false);
        add(backspace);
        spacebar=new JButton("Spacebar");
        spacebar.setBackground(Color.LIGHT_GRAY);
        spacebar.setFocusable(false);
        add(spacebar);
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(letters[i]);

            buttons[i].setBackground(Color.LIGHT_GRAY);
            buttons[i].setFocusable(false);
            add(buttons[i]);
        }

        textField = new JTextField(60);
        textField.setEditable(true);
        add(textField, BorderLayout.NORTH);

        textField.addKeyListener(this);
        defaultColor = Color.LIGHT_GRAY;

    }

    public void keyTyped(KeyEvent e) {

    }

    public void keyPressed(KeyEvent e) {
        try {
            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                backspace.setBackground(pressedColor);
            } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                spacebar.setBackground(pressedColor);
            } else if(e.getKeyCode()>='0' && e.getKeyCode()<='9'){
                numB[e.getKeyCode()-48].setBackground(pressedColor);
            } else {

                buttons[e.getKeyCode()-'A'].setBackground(pressedColor);
            }
        } catch (Exception x){
        }
    }

    public void keyReleased(KeyEvent e) {
        try{
            if(e.getKeyCode() == KeyEvent.VK_BACK_SPACE){
                backspace.setBackground(defaultColor);
            } else if(e.getKeyCode() == KeyEvent.VK_SPACE){
                spacebar.setBackground(defaultColor);
            } else if(e.getKeyCode()>='0' && e.getKeyCode()<='9'){
                numB[e.getKeyCode()-48].setBackground(defaultColor);
            } else {

                buttons[e.getKeyCode()-'A'].setBackground(defaultColor);
            }

        } catch(Exception x){
        }
    }


}
