import java.awt.*;
import javax.swing.*;

/**
 *  The BagelPanel class allows the user to select either
 *  a white or whole wheat bagel.
 */

public class BagelPanel extends JPanel
{
   // The following constants are used to indicate
   // the cost of each type of bagel.
   public final double WHITE_BAGEL = 1.25;
   public final double WHEAT_BAGEL = 1.50;
   public final double GARLIC_BAGEL = 1.75;
   public final double GF_BAGEL = 2.00;

   // The following variables will reference radio
   // buttons for white and whole wheat bagels.
   private JRadioButton whiteBagel;
   private JRadioButton wheatBagel;
   private JRadioButton garlicBagel;
   private JRadioButton gfBagel;
   
   // The following variable will reference a
   // ButtonGroup object to group the radio buttons.
   private ButtonGroup bg;

   /**
    *  Constructor
    */

   public BagelPanel()
   {
      // Create a GridLayout manager with 
      // two rows and one column.
      setLayout(new GridLayout(4, 1));

      // Create the radio buttons.
      whiteBagel = new JRadioButton("White", true);
      wheatBagel = new JRadioButton("Wheat");
      garlicBagel = new JRadioButton("Garlic");
      gfBagel = new JRadioButton("GF");

      // Group the radio buttons.
      bg = new ButtonGroup();
      bg.add(whiteBagel);
      bg.add(wheatBagel);
      bg.add(garlicBagel);
      bg.add(gfBagel);

      // Add a border around the panel.
      setBorder(BorderFactory.createTitledBorder("Bagel"));

      // Add the radio buttons to this panel.
      add(whiteBagel);
      add(wheatBagel);
      add(garlicBagel);
      add(gfBagel);

   }

   /**
    *  The getBagelCost method returns the cost of
    *  the selected bagel.
    */

   public double getBagelCost()
   {
      // The following variable will hold the cost
      // of the selected bagel.
      double bagelCost = 0.0;

      // Determine which bagel is selected.
      if (whiteBagel.isSelected())
         bagelCost = WHITE_BAGEL;
      if (wheatBagel.isSelected())
         bagelCost = WHEAT_BAGEL;
      if (garlicBagel.isSelected())
         bagelCost = GARLIC_BAGEL;
      else
         bagelCost = GF_BAGEL;

      // Return the cost of the selected bagel.
      return bagelCost;
   }
}