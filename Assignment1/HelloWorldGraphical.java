import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import java.awt.BorderLayout;
import javax.swing.JSplitPane;
import javax.swing.BoxLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dimension;

public class HelloWorldGraphical {

    private JFrame frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    HelloWorldGraphical window = new HelloWorldGraphical();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public HelloWorldGraphical() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //  Panels and buttons declaration
        JPanel pBody = new JPanel();
        JPanel pBodySpliter = new JPanel();

        //  Language selection menu
        JPanel pLangSelections = new JPanel();
        JButton btnDeutsch = new JButton("Deutsch");
        JButton btnEnglish = new JButton("English");
        JButton btnFrancais = new JButton("Francais");

        //  Message label
        JPanel pMessage = new JPanel();
        JLabel lblMessage = new JLabel("Message");

        //  Footer with Beenden button
        JPanel pFooter = new JPanel();
        JButton btnBeenden = new JButton("Beenden");

        // Window definition
        frame = new JFrame("Hello GUI");
        frame.setBounds(100, 100, 450, 300);
        frame.setMinimumSize(new Dimension(200, 300));
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(new BorderLayout(0, 0));

        //Window Body
        FlowLayout fl_pBody = (FlowLayout) pBody.getLayout();
        fl_pBody.setVgap(15);
        frame.getContentPane().add(pBody, BorderLayout.CENTER);

        pBody.add(pBodySpliter);
        pBodySpliter.setLayout(new GridLayout(2, 1, 0, 0));

        pBodySpliter.add(pLangSelections);
        pLangSelections.setLayout(new GridLayout(3, 3, 0, 10));
        //1st row


        btnDeutsch.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                lblMessage.setText("Guten Tag!");
            }
        });
        pLangSelections.add(btnDeutsch);


        //2nd row


        btnEnglish.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                lblMessage.setText("Hallo!");
            }
        });
        pLangSelections.add(btnEnglish);

        //3rd row

        btnFrancais.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                lblMessage.setText("Bonjour! (or whatever it is)");
            }
        });
        pLangSelections.add(btnFrancais);

        pBodySpliter.add(pMessage);
        FlowLayout flowLayout = (FlowLayout) pMessage.getLayout();
        flowLayout.setVgap(25);
        pMessage.add(lblMessage);


        //  Beenden button at bottom right
        FlowLayout fl_pFooter = (FlowLayout) pFooter.getLayout();
        fl_pFooter.setVgap(15);
        fl_pFooter.setHgap(15);
        fl_pFooter.setAlignment(FlowLayout.RIGHT);
        frame.getContentPane().add(pFooter, BorderLayout.SOUTH);

        JButton btnBeenden = new JButton("Beenden");
        btnBeenden.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent arg0) {
                frame.dispatchEvent(new WindowEvent(frame, WindowEvent.WINDOW_CLOSING));
            }
        });
        pFooter.add(btnBeenden);
    }

}
