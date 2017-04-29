import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class HelloWorldGraphical implements ActionListener {

    JFrame frame = new JFrame();
    //  Language selection menu
    JButton button_Deutsch = new JButton("Deutsch");
    JButton button_English = new JButton("English");
    JButton button_French = new JButton("Francais");

    //  Message label
    JLabel label_Message = new JLabel("Message");

    //  Footer with Beenden button
    JButton button_Beenden = new JButton("Beenden");

    public HelloWorldGraphical(){
        createMenu();
    }

    private void createMenu() {


        //  Body Panel (top center)
        JPanel panel_Body = new JPanel(new FlowLayout(FlowLayout.CENTER, 5, 15));
        frame.getContentPane().add(panel_Body, BorderLayout.NORTH);

        //  Language selection panel (inside body panel - center)
        JPanel pLanguageSelection = new JPanel(new GridLayout(0, 1, 0, 10));
        panel_Body.add(pLanguageSelection);

        //  Buttons inside Language selection panel
		button_Deutsch.addActionListener(this);
        pLanguageSelection.add(button_Deutsch);

        button_English.addActionListener(this);
        pLanguageSelection.add(button_English);

        button_French.addActionListener(this);
        pLanguageSelection.add(button_French);

        JPanel panel_Message = new JPanel(new FlowLayout());
        frame.getContentPane().add(panel_Message, BorderLayout.CENTER);

        panel_Message.add(label_Message);

        JPanel panel_Bottom = new JPanel(new FlowLayout(FlowLayout.RIGHT, 10, 10));
        frame.getContentPane().add(panel_Bottom, BorderLayout.SOUTH);

        button_Beenden.addActionListener(this);
        panel_Bottom.add(button_Beenden);

        frame.setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {
        // TODO Auto-generated method stub
        if(e.getSource() == button_Deutsch)
            label_Message.setText("Guten Tag!");
        else if(e.getSource() == button_English)
            label_Message.setText("Good Day!");
        else if(e.getSource() == button_French)
            label_Message.setText("Bonne Journee!");
        else if (e.getSource() == button_Beenden)
            frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
    }

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        HelloWorldGraphical hello = new HelloWorldGraphical();

        JFrame frame = new JFrame("Hello GUI");
        frame.setBounds(100, 100, 450, 300);
        frame.setMinimumSize(new Dimension(250, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

    }

}

