package yahtzeegui;

import java.awt.Color;
import java.awt.Font;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JTextField;

/**
 * Bouwsteen voor de gebruikersinterface van een applet om Yahtzee mee
 * te spelen.
 * @author Medewerker OUNL
 *
 */
public class YahtzeeApplet extends JApplet {  
  //attributen
  
  // de dobbelsteenvelden, scorevelden en scoreknoppen zijn met
  // de hand (niet door de Visual Editor) toegevoegd als arrays
  // Ze zijn in het ontwerpscherm dus ook niet te zien.
  private JTextField[] dobbelVelden = new JTextField[5];
  private JButton[] scoreKnoppen = new JButton[13];
  private JTextField[] scoreVelden = new JTextField[13];

  // gegenereerde attributen
  private JPanel jContentPane = null;
  private JButton gooiKnop = null;
  private JButton nieuwSpelKnop = null;
  private JTextField totaalVeld = null;
  private JLabel totaalLabel = null;
  
  /**
   * This is the xxx default constructor
   */
  public YahtzeeApplet() {
    super();
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  public void init() {
    this.setSize(300, 400);
    this.setContentPane(getJContentPane());
  }
  
  // plaats hier een eventuele methode mijnInit()
 
  // event handlers
  
  /**
   * Event handler voor muisklik op een gegeven dobbelsteenveld.
   * @param index  de index van het veld in de array dobbelVelden 
   */
  private void dobbelVeldAction(int index) {
    System.out.println("Geklikt op dobbelVeld " + index);
    // Plaats hier de code voor het klikken op een dobbelsteenveld
  }
  
  /**
   * Event handler voor het klikken op een scoreknop
   * @param index  de index van de knop in de array scoreKnoppen
   */
  private void scoreKnopAction(int index) {
    System.out.println("Geklikt op scoreKnop " + index);
    // Plaats hier de code voor het klikken op een scoreknop
  }
  
  // Plaats hier uw eigen event handlers
  
  // Plaats hier eventuele andere private methoden

  // Hier begint de code voor het plaatsen van alle componenten
  // in de gui. Deze code is deels gegenereerd; deels door
  // ons toegevoegd.
  
  /**
   * Initialiseert de dobbelVelden en voegt ze aan de contentPane
   * toe. Elk dobbelveld krijgt event handling voor een muisklik
   * op dat veld; bij een klik op dobbelVelden[index] wordt
   * de methode dobbelVeldAction(index) aangeroepen
   */
  private JTextField getDobbelVelden(int i) {
    if (dobbelVelden[i] ==  null) {
      dobbelVelden[i] = new JTextField();
      dobbelVelden[i].setBounds(8 + 58*i, 16, 50, 50);
      dobbelVelden[i].setFont(new Font("Dialog", Font.BOLD, 24));
      dobbelVelden[i].setForeground(Color.BLUE);
      dobbelVelden[i].setBackground(Color.WHITE);   
      dobbelVelden[i].setEditable(false);
      dobbelVelden[i].addMouseListener(new java.awt.event.MouseAdapter() {
        public void mousePressed(java.awt.event.MouseEvent e) {
          JTextField bron = (JTextField)e.getSource();
          int index = (bron.getX() - 8) / 58; 
          dobbelVeldAction(index);
        }
      });
    }
    return dobbelVelden[i];
  }

  /**
   * Initialiseer de scoreVelden.
   */
  private JTextField getScoreVelden(int i) {
    if (scoreVelden[i] == null) {
      int x = (i < 6 ? 114 : 163);
      int y = (i < 6 ? 133 + 27*i : 133 + 27* (i-6));
      scoreVelden[i] = new JTextField();
      scoreVelden[i].setBounds(x, y, 24, 24);
      scoreVelden[i].setFont(new Font("Dialog", Font.BOLD, 14));
      scoreVelden[i].setForeground(Color.blue);
      scoreVelden[i].setEnabled(true);
      scoreVelden[i].setEditable(false);
      scoreVelden[i].setBackground(Color.white);
      scoreVelden[i].setText("");
    }
    return scoreVelden[i];
  }
      
  /**
   * Initialiseer de scoreKnoppen. Elke knop krijgt event handling voor een
   * het klikken op die knop; bij een klik op scoreKnop[index] wordt
   * de methode scoreKnopAction(index) aangeroepen.
   */
  private JButton getScoreKnoppen(int i) {
    String[] opschriften =  
        {"enen", "twee�n", "drie�n", "vieren", "vijven", "zessen",
         "3 dezelfde", "carr�", "full house", 
         "kleine str.", "grote str.", "YAHTZEE!", "chance"};
    if (scoreKnoppen[i] == null) {  
      int x = (i < 6 ? 16 : 194);
      int y = (i < 6 ? 133 + 27*i : 133 + 27* (i-6));
      scoreKnoppen[i] = new JButton();
      scoreKnoppen[i].setBounds(x, y, 92, 24);
      scoreKnoppen[i].setText(opschriften[i]);
      scoreKnoppen[i].addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          JButton bron = (JButton)e.getSource();
          int index = (bron.getY() - 133) / 27;
          if (bron.getX() > 100) {
            index = index + 6;
          }
          scoreKnopAction(index);
        }
      });     
    }
    return scoreKnoppen[i];
  }
  
  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      totaalLabel = new JLabel();
      totaalLabel.setBounds(new Rectangle(17, 295, 67, 25));
      totaalLabel.setText("TOTAAL");    
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getGooiKnop(), null);
      jContentPane.add(getNieuwSpelKnop(), null);
      jContentPane.add(getTotaalVeld(), null);
      jContentPane.add(totaalLabel, null);
      for (int i = 0; i < 5; i++) {
        jContentPane.add(getDobbelVelden(i), null);
      }
      for (int i = 0; i < 13; i++) {
        jContentPane.add(getScoreVelden(i), null);
        jContentPane.add(getScoreKnoppen(i), null);
      }
    }
    return jContentPane;
  }
  
  /**
   * This method initializes gooiKnop   
   *    
   * @return javax.swing.JButton        
   */
  private JButton getGooiKnop() {
    if (gooiKnop == null) {
      gooiKnop = new JButton();
      gooiKnop.setBounds(new Rectangle(96, 75, 99, 34));
      gooiKnop.setText("Gooi");
    }
    return gooiKnop;
  }  
  /**
   * This method initializes nieuwSpelKnop      
   *    
   * @return javax.swing.JButton        
   */
  private JButton getNieuwSpelKnop() {
    if (nieuwSpelKnop == null) {
      nieuwSpelKnop = new JButton();
      nieuwSpelKnop.setBounds(new Rectangle(96, 355, 99, 34));
      nieuwSpelKnop.setText("Nieuw spel");
    }
    return nieuwSpelKnop;
  }

  /**
   * This method initializes totaalVeld 
   *    
   * @return javax.swing.JTextField     
   */
  private JTextField getTotaalVeld() {
    if (totaalVeld == null) {
      totaalVeld = new JTextField();
      totaalVeld.setBounds(new Rectangle(85, 295, 53, 25));
      totaalVeld.setForeground(Color.red);
      totaalVeld.setEditable(false);
      totaalVeld.setBackground(Color.white);
      totaalVeld.setFont(new Font("Dialog", Font.BOLD, 14));
    }
    return totaalVeld;
  }
}
