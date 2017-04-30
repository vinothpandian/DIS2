/*
DIS2 - Assignment 01
A simple Graphical UI program

Group 12:
    Arijit Gupta
    Vincentius Renaldi
    Vinoth Pandian Sermuga Pandian
*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HelloWorldGraphical implements ActionListener {

    // Main GUI window frame
    JFrame frame = new JFrame();

    //  Buttons for language selection menu
    JButton button_Deutsch = new JButton("Deutsch");
    JButton button_English = new JButton("English");
    JButton button_French = new JButton("Francais");

    //  Message label
    JLabel label_Message = new JLabel("Welcome!");

    //  Beenden button for quit
    JButton button_Beenden = new JButton("Beenden");

    //  constructor to call language selection menu
    public HelloWorldGraphical(){
        createGUI();
    }

    //  GUI Application - provides a list of language buttons for user to choose
    private void createGUI() {

        // Attributes of GUI window
        frame.setTitle("Hello GUI");
        frame.setBounds(100, 100, 450, 300);
        frame.setMinimumSize(new Dimension(250, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        //  Body Panel (top center)
        JPanel panel_Body = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 15));
        frame.getContentPane().add(panel_Body, BorderLayout.NORTH);

        //  Language selection panel (inside body panel - center)
        JPanel pLanguageSelection = new JPanel(new GridLayout(0, 1, 0, 10));
        panel_Body.add(pLanguageSelection);

        //  German button
		button_Deutsch.addActionListener(this);
        pLanguageSelection.add(button_Deutsch);

        //  English button
        button_English.addActionListener(this);
        pLanguageSelection.add(button_English);

        //  French button
        button_French.addActionListener(this);
        pLanguageSelection.add(button_French);

        //  Message display panel with message label
        JPanel panel_Message = new JPanel(new FlowLayout());
        frame.getContentPane().add(panel_Message, BorderLayout.CENTER);
        panel_Message.add(label_Message);

        //  Bottom panel with Quit button
        JPanel panel_Bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        frame.getContentPane().add(panel_Bottom, BorderLayout.SOUTH);
        button_Beenden.addActionListener(this);
        panel_Bottom.add(button_Beenden);

        //  set frame as visible
        frame.setVisible(true);
    }

    //  Action listener call to check which button was pressed and set appropritate message value
    public void actionPerformed(ActionEvent e) {
        
        if(e.getSource() == button_Deutsch)
            label_Message.setText("Guten Tag!");
        else if(e.getSource() == button_English)
            label_Message.setText("Good Day!");
        else if(e.getSource() == button_French)
            label_Message.setText("Bonne Journee!");
        else if (e.getSource() == button_Beenden)
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    //  Main function to call GUI application class
    public static void main(String[] args) {
        HelloWorldGraphical hello = new HelloWorldGraphical();
    }

}