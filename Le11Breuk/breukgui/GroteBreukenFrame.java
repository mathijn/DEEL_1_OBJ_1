package breukgui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;
import breuk.Breuk;
import java.awt.Dimension;

/**
 * User interface voor vereenvoudiging van enkele breuken
 * met grote teller en noemer, met het doel de efficiency van
 * twee algoritmen voor vereenvoudiging te onderzoeken.
 * De eerste twee breuken zijn gekozen als ongunstige gevallen
 * voor een naïef vereenvoudigingsalgoritme. De derde breuk is
 * een ongunstig geval voor het algoritme van Euclides.
 * Elke breuk heeft een knop die de vereenvoudiging start.
 * De knoppen voor de tweede en derde breuk zijn om te beginnen
 * disabled.
 */
public class GroteBreukenFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;  //  @jve:decl-index=0:visual-constraint="10,10"
  private JButton groot1Knop = null;
  private JButton groot2Knop = null;
  private JLabel tijd1Label = null;
  private JLabel tijd2Label = null;
  private JButton groot3Knop = null;
  private JLabel tijd3Label = null;

  /**
   * This is the default constructor
   */
  public GroteBreukenFrame() {
    super();
    initialize();
  }
  
  /**
   * Deze methode probeert een breuk te vereenvoudigen met teller
   * en noemer in de buurt van Integer.MAX_VALUE en toont
   * vervolgens hoelang dat heeft geduurd. Teller en noemer
   * zijn relatief priem; de ggd is dus 1. 
   */
  private void groot1KnopAction() {
    groteBreuk(2147482661, 2147473697, tijd1Label);
  }
  
  /**
   * Deze methode probeert een breuk te vereenvoudigen met teller
   * en noemer in de buurt van Long.MAX_VALUE en toont
   * vervolgens hoelang dat heeft geduurd. Teller en noemer
   * zijn relatief priem; de ggd is dus 1. 
   */
  private void groot2KnopAction() {
    groteBreuk(9223372036854774893L, 9223372036854765809L, tijd2Label);
  }

  /**
   * Deze methode probeert een breuk te vereenvoudigen met teller
   * en noemer het 91-e respectievelijk het 92-e fibonaccigetal
   * (dit zijn de grootste fibonaccigetallen die in het type
   * long passen). Fibonaccigetallen zijn het meest ongunstige geval
   * voor het algoritme van Euclides.
   */
  private void groot3KnopAction() {
    groteBreuk(4660046610375530309L, 7540113804746346429L, tijd3Label);
  }
  
  /**
   * Private methode die een breuk maakt met de gegeven teller en
   * de gegeven noemer. De verstreken systeemtijd wordt getoond in
   * het gegeven label.
   * @param teller  de teller van de te vereenvoudigen breuk
   * @param noemer  de teller van de te vereenvoudigen breuk
   * @param tijdLabel  het label waarin de tijd moet worden getoond
   */
  private void groteBreuk(long teller, long noemer, JLabel tijdLabel) {
    Breuk breuk = new Breuk(teller, noemer);
    long start = System.currentTimeMillis();
    breuk.vereenvoudig();
    long eind = System.currentTimeMillis();
    tijdLabel.setText("Tijd: " + (eind - start));    
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(370, 182);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Grote breuken vereenvoudigen");
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      tijd3Label = new JLabel();
      tijd3Label.setBounds(new Rectangle(210, 100, 134, 32));
      tijd3Label.setText("Tijd:");
      tijd2Label = new JLabel();
      tijd2Label.setBounds(new Rectangle(210, 55, 137, 31));
      tijd2Label.setText("Tijd:");
      tijd1Label = new JLabel();
      tijd1Label.setBounds(new Rectangle(210, 10, 138, 31));
      tijd1Label.setText("Tijd:");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.setSize(new Dimension(348, 121));
      jContentPane.add(getGroot1Knop(), null);
      jContentPane.add(getGroot2Knop(), null);
      jContentPane.add(tijd1Label, null);
      jContentPane.add(tijd2Label, null);
      jContentPane.add(getGroot3Knop(), null);
      jContentPane.add(tijd3Label, null);
    }
    return jContentPane;
  }
  
  /**
   * This method initializes groot1Knop 
   *    
   * @return javax.swing.JButton        
   */
  private JButton getGroot1Knop() {
    if (groot1Knop == null) {
      groot1Knop = new JButton();
      groot1Knop.setBounds(new Rectangle(16, 10, 122, 35));
      groot1Knop.setText("<html>2147482661 / <br>2147473697</html>");
      groot1Knop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          groot1KnopAction();
        }
      });
    }
    return groot1Knop;
  }

  /**
   * This method initializes groot2Knop 
   *    
   * @return javax.swing.JButton        
   */
  private JButton getGroot2Knop() {
    if (groot2Knop == null) {
      groot2Knop = new JButton();
      groot2Knop.setBounds(new Rectangle(16, 55, 180, 35));
      groot2Knop.setEnabled(false);
      groot2Knop.setText("<html> 9223372036854774893 /<br>9223372036854765809</html>");
      groot2Knop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          groot2KnopAction();
        }
      });
    }
    return groot2Knop;
  }
  
  /**
   * This method initializes groot3Knop 
   *    
   * @return javax.swing.JButton        
   */
  private JButton getGroot3Knop() {
    if (groot3Knop == null) {
      groot3Knop = new JButton();
      groot3Knop.setBounds(new Rectangle(16, 100, 179, 35));
      groot3Knop.setEnabled(false);
      groot3Knop.setText("<html>4660046610375530309 / <br>7540113804746346429</html>");
      groot3Knop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          groot3KnopAction();
        }
      });
    }
    return groot3Knop;
  }
  
  public static void main(String[] args) {
    GroteBreukenFrame gui = new GroteBreukenFrame();
    gui.setVisible(true);
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
