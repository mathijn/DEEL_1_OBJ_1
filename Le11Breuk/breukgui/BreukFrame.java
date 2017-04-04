package breukgui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Rectangle;
import javax.swing.JButton;
import javax.swing.JLabel;

import breuk.Breuk;

import java.awt.Font;
import java.awt.Color;

/*
 * Deze klasse biedt een gebruikersinterface op de klasse Breuk.
 * De gebruiker kan een teller en een noemer invoeren en
 * de breuk laten vereenvoudigen.
 */
public class BreukFrame extends JFrame {
  
  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JTextField tellerVeld = null;
  private JTextField noemerVeld = null;
  private JButton vereenvoudigKnop = null;
  private JLabel streep = null;
  private JLabel foutLabel = null;

  /**
   * This is the default constructor
   */
  public BreukFrame() {
    super();
    initialize();
  }
  
  /*
   * Maakt een breuk aan met de teller en noemer uit tellerVeld en
   * noemerVeld, roept daarop de methode vereenvoudig aan en toont
   * teller en noemer in hun respecievelijke velden.
   * Als de teller negatief is of de noemer niet positief, volgt een
   * foutmelding.
   */
  private void vereenvoudigAction() {
    foutLabel.setText("");
    int teller = Integer.parseInt(tellerVeld.getText());
    int noemer = Integer.parseInt(noemerVeld.getText());
    if (noemer <= 0) {
      foutLabel.setText("Noemer moet positief zijn");
    }
    else if (teller < 0) {
      foutLabel.setText("Teller mag niet negatief zijn");
    }
    else {
      Breuk breuk = new Breuk(teller, noemer);    
      if (breuk != null) {
        breuk.vereenvoudig();
        tellerVeld.setText(breuk.getTeller() + "");
        noemerVeld.setText(breuk.getNoemer() + "");
      }
    }
  }
  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(253, 175);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Breuken vereenvoudigen");
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      foutLabel = new JLabel();
      foutLabel.setBounds(new Rectangle(0, 120, 249, 25));
      foutLabel.setForeground(Color.red);
      foutLabel.setText("");
      streep = new JLabel();
      streep.setBounds(new Rectangle(5, 30, 98, 41));
      streep.setFont(new Font("Elephant", Font.BOLD, 24));
      streep.setText("_______");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(getTellerVeld(), null);
      jContentPane.add(getNoemerVeld(), null);
      jContentPane.add(getVereenvoudigKnop(), null);
      jContentPane.add(streep, null);
      jContentPane.add(foutLabel, null);
    }
    return jContentPane;
  }

  /**
   * This method initializes tellerVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getTellerVeld() {
    if (tellerVeld == null) {
      tellerVeld = new JTextField();
      tellerVeld.setBounds(new Rectangle(17, 15, 74, 35));
    }
    return tellerVeld;
  }

  /**
   * This method initializes noemerVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getNoemerVeld() {
    if (noemerVeld == null) {
      noemerVeld = new JTextField();
      noemerVeld.setBounds(new Rectangle(17, 75, 75, 35));
    }
    return noemerVeld;
  }

  /**
   * This method initializes vereenvoudigKnop	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getVereenvoudigKnop() {
    if (vereenvoudigKnop == null) {
      vereenvoudigKnop = new JButton();
      vereenvoudigKnop.setBounds(new Rectangle(118, 15, 122, 29));
      vereenvoudigKnop.setText("Vereenvoudig");
      vereenvoudigKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          vereenvoudigAction();
        }
      });
    }
    return vereenvoudigKnop;
  }
  
  public static void main(String[] args) {
    BreukFrame gui = new BreukFrame();
    gui.setVisible(true);
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
