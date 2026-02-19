//Ian Handy

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

 

public class Colors extends JFrame implements ActionListener {

        private static final long serialVersionUID = 1L;

        private JButton backgroundButton = new JButton("Background Color");

        private JButton textButton = new JButton("Text Color");

        private JLabel greeting = new JLabel("Goodbye world!  Hello Java!");

        private Color[] bgColors = { Color.cyan, Color.orange, Color.pink };

        private Color[] txtColors = { Color.blue, Color.magenta, Color.red };

        private JPanel backgroundPane = new JPanel();

        private int bgCode = 0;

        private int txtCode = 0;

 

        public Colors() {
               super("Colors");

              

                backgroundPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 30));

               this.add(backgroundPane);

              

        backgroundButton.addActionListener(this);

            backgroundPane.add(backgroundButton);

 

              textButton.addActionListener(this);

                backgroundPane.add(textButton);

 

               Font font = new Font("Helvetica", Font.BOLD, 18);

               greeting.setFont(font);

                backgroundPane.add(greeting);

              

        greeting.setForeground(txtColors[txtCode]);

        backgroundPane.setBackground(bgColors[bgCode]);

              

               this.setSize(325, 200);

               this.setResizable(false);

                this.setLocationByPlatform(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

               this.setVisible(true);

        }

 

       

        public void actionPerformed(ActionEvent e) {

               Object source = e.getSource();

 

               if (source == backgroundButton) {

                       bgCode = ++bgCode % bgColors.length;

                       Color color = bgColors[bgCode];

                    backgroundPane.setBackground(color);

               }

 

               else if (source == textButton) {

                       txtCode = ++txtCode % txtColors.length;

               greeting.setForeground(txtColors[txtCode]);

               }

        }

 

 

        public static void main(String[] args) {

               new Colors();

        }

}
