package bibliotheekgui;

import javax.swing.SwingUtilities;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 * Deze klasse representeert een gui voor het beheren
 * van een verzameling boeken. 
 * @author Medewerker OUNL
 *
 */
public class BibliotheekFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel titelLabel = null;
  private JLabel auteurLabel = null;
  private JTextField titelVeld = null;
  private JTextField auteurVeld = null;
  private JButton voegtoeKnop = null;
  private JButton toonAuteurKnop = null;
  private JScrollPane jScrollPane = null;
  private JTextArea titelsArea = null;
  private JButton toonTitelsKnop = null;
  
  /**
   * This is the default constructor
   */
  public BibliotheekFrame() {
    super();
    initialize();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(412, 322);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Mijn bibliotheek");
  }
  
  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      auteurLabel = new JLabel();
      auteurLabel.setBounds(new Rectangle(13, 39, 85, 20));
      auteurLabel.setText("auteur");
      titelLabel = new JLabel();
      titelLabel.setBounds(new Rectangle(13, 18, 74, 15));
      titelLabel.setText("titel");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(titelLabel, null);
      jContentPane.add(auteurLabel, null);
      jContentPane.add(getTitelVeld(), null);
      jContentPane.add(getAuteurVeld(), null);
      jContentPane.add(getVoegtoeKnop(), null);
      jContentPane.add(getToonAuteurKnop(), null);
      jContentPane.add(getJScrollPane(), null);
      jContentPane.add(getToonTitelsKnop(), null);
    }
    return jContentPane;
  }
  
  /**
   * This method initializes titelVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTitelVeld() {
    if (titelVeld == null) {
      titelVeld = new JTextField();
      titelVeld.setBounds(new Rectangle(119, 6, 242, 27));
    }
    return titelVeld;
  }

  /**
   * This method initializes auteurVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getAuteurVeld() {
    if (auteurVeld == null) {
      auteurVeld = new JTextField();
      auteurVeld.setBounds(new Rectangle(119, 35, 242, 25));
    }
    return auteurVeld;
  }

  /**
   * This method initializes voegtoeKnop	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getVoegtoeKnop() {
    if (voegtoeKnop == null) {
      voegtoeKnop = new JButton();
      voegtoeKnop.setBounds(new Rectangle(14, 80, 113, 26));
      voegtoeKnop.setText("voeg boek toe");
              
    }
    return voegtoeKnop;
  } 

  /**
   * This method initializes toonAuteurKnop	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getToonAuteurKnop() {
    if (toonAuteurKnop == null) {
      toonAuteurKnop = new JButton();
      toonAuteurKnop.setBounds(new Rectangle(141, 79, 99, 26));
      toonAuteurKnop.setText("toon auteur");
   }
    return toonAuteurKnop;
  }
  
  /**
   * This method initializes jScrollPane	
   * 	
   * @return javax.swing.JScrollPane	
   */
  private JScrollPane getJScrollPane() {
    if (jScrollPane == null) {
      jScrollPane = new JScrollPane();
      jScrollPane.setBounds(new Rectangle(13, 116, 272, 170));
      jScrollPane.setViewportView(getTitelsArea());
    }
    return jScrollPane;
  }

  /**
   * This method initializes titelsArea	
   * 	
   * @return javax.swing.JTextArea	
   */
  private JTextArea getTitelsArea() {
    if (titelsArea == null) {
      titelsArea = new JTextArea();
    }
    return titelsArea;
  }

  /**
   * This method initializes toonTitelsKnop	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getToonTitelsKnop() {
    if (toonTitelsKnop == null) {
      toonTitelsKnop = new JButton();
      toonTitelsKnop.setBounds(new Rectangle(254, 80, 93, 26));
      toonTitelsKnop.setText("toon titels");      
    }
    return toonTitelsKnop;
  }

  
  /**
   * Creëert en toont een instantie van deze klasse
   */
  public static void main(String[] args) {
    BibliotheekFrame gui = new BibliotheekFrame();
    gui.setVisible(true);
  }

}  
