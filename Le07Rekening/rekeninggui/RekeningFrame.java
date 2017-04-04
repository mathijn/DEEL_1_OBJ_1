package rekeninggui;

import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JTextField;
import java.awt.Rectangle;
import java.awt.Color;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import rekening.Rekening;

public class RekeningFrame extends JFrame {
  private Rekening rekening = new Rekening("OUNL", 1111);
  
  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JButton stortKnop = null;
  private JButton neemOpKnop = null;  
  private JTextField nummerVeld = null;
  private JTextField naamVeld = null;
  private JTextField saldoVeld = null;
  private JTextField bedragVeld = null;
  private JLabel rekeningLabel = null;
  private JLabel naamLabel = null;
  private JLabel saldoLabel = null;
  private JLabel bedragLabel = null;
  private JLabel titelLabel = null;
 
 
  /**
   * This is the default constructor
   */
  public RekeningFrame() {
    super();
    initialize();
    mijnInit();
  }
  
  /**
   * Initialiseert het attribuut rekening en plaatst beginwaarden 
   * in de velden voor naam, nummer en bedrag
   *
   */
  private void mijnInit(){
    nummerVeld.setText("" + rekening.getNummer());
    naamVeld.setText(rekening.getNaam());
    saldoVeld.setText("" + rekening.getSaldo());
    bedragVeld.setText("0.0");   
  }

  /**
   * Eventhandler van stortKnop. Zorgt dat het ingevoerde bedrag
   * wordt gestort op de rekening en toont het saldo
   *
   */
  private void stortKnopAction(){
    double bedrag = 
      Double.parseDouble(bedragVeld.getText());
    rekening.stort(bedrag);
    saldoVeld.setText("" + rekening.getSaldo() );   
    bedragVeld.setText("0.0");  
  }
  
  /**
   * Eventhandler van neemOpKnop. Zorgt dat het ingevoerde bedrag
   * wordt opgenomen van de rekening en toont het saldo
   *
   */
  private void neemOpKnopAction(){
    double bedrag = 
      Double.parseDouble(bedragVeld.getText());
    rekening.neemOp(bedrag);
    saldoVeld.setText("" + rekening.getSaldo()); 
    bedragVeld.setText("0.0");
  }

  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(298, 315);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("RekeningApplicatie");
  }
  
  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      titelLabel = new JLabel();
      titelLabel.setBounds(new Rectangle(61, 15, 149, 24));
      titelLabel.setHorizontalAlignment(SwingConstants.CENTER);
      titelLabel.setText("Internet Bankrekening");
      bedragLabel = new JLabel();
      bedragLabel.setBounds(new Rectangle(35, 148, 82, 22));
      bedragLabel.setText("Bedrag:");
      saldoLabel = new JLabel();
      saldoLabel.setBounds(new Rectangle(37, 115, 80, 23));
      saldoLabel.setText("Saldo:");
      naamLabel = new JLabel();
      naamLabel.setBounds(new Rectangle(37, 86, 80, 21));
      naamLabel.setText("Naam:");
      rekeningLabel = new JLabel();
      rekeningLabel.setBounds(new Rectangle(8, 59, 109, 21));
      rekeningLabel.setText("Rekeningnummer:");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.setBackground(new Color(204, 204, 255));
      jContentPane.add(getStortKnop(), null);
      jContentPane.add(getNeemOpKnop(), null);
      jContentPane.add(getNummerVeld(), null);
      jContentPane.add(getNaamVeld(), null);
      jContentPane.add(getSaldoVeld(), null);
      jContentPane.add(getBedragVeld(), null);
      jContentPane.add(rekeningLabel, null);
      jContentPane.add(naamLabel, null);
      jContentPane.add(saldoLabel, null);
      jContentPane.add(bedragLabel, null);
      jContentPane.add(titelLabel, null);
    }
    return jContentPane;
  }

  /**
   * This method initializes stortKnop  
   *    
   * @return javax.swing.JButton        
   */
  private JButton getStortKnop() {
    if (stortKnop == null) {
      stortKnop = new JButton();
      stortKnop.setBounds(new Rectangle(16, 220, 110, 35));
      stortKnop.setActionCommand("stort");
      stortKnop.setText("stort ");
      stortKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          stortKnopAction();
        }
      });
    }
    return stortKnop;
  }

  /**
   * This method initializes neemOpKnop 
   *    
   * @return javax.swing.JButton        
   */
  private JButton getNeemOpKnop() {
    if (neemOpKnop == null) {
      neemOpKnop = new JButton();
      neemOpKnop.setBounds(new Rectangle(149, 221, 107, 35));
      neemOpKnop.setActionCommand("neem op");
      neemOpKnop.setText("neem op");
      neemOpKnop.addActionListener(new java.awt.event.ActionListener() {
        public void actionPerformed(java.awt.event.ActionEvent e) {
          neemOpKnopAction();
        }
      });
    }
    return neemOpKnop;
  }

  /**
   * This method initializes nummerVeld 
   *    
   * @return javax.swing.JTextField     
   */
  private JTextField getNummerVeld() {
    if (nummerVeld == null) {
      nummerVeld = new JTextField();
      nummerVeld.setBounds(new Rectangle(134, 60, 75, 20));
      nummerVeld.setEditable(false);
      nummerVeld.setBackground(new Color(204, 204, 255));
    }
    return nummerVeld;
  }

  /**
   * This method initializes naamTextField1     
   *    
   * @return javax.swing.JTextField     
   */
  private JTextField getNaamVeld() {
    if (naamVeld == null) {
      naamVeld = new JTextField();
      naamVeld.setBounds(new Rectangle(134, 87, 75, 20));
      naamVeld.setEditable(false);
      naamVeld.setBackground(new Color(204, 204, 255));
    }
    return naamVeld;
  }

  /**
   * This method initializes saldoTextField11   
   *    
   * @return javax.swing.JTextField     
   */
  private JTextField getSaldoVeld() {
    if (saldoVeld == null) {
      saldoVeld = new JTextField();
      saldoVeld.setBounds(new Rectangle(134, 118, 76, 20));
      saldoVeld.setEditable(false);
      saldoVeld.setBackground(new Color(204, 204, 255));
    }
    return saldoVeld;
  }
 
  /**
   * This method initializes bedragVeld     
   *    
   * @return javax.swing.JTextField      
   */
  private JTextField getBedragVeld() {
    if (bedragVeld == null) {
      bedragVeld = new JTextField();
      bedragVeld.setBounds(new Rectangle(134, 148, 76, 22));
    }
    return bedragVeld;
  }

  public static void main(String[] args) {
        RekeningFrame gui = new RekeningFrame();
        gui.setVisible(true);
  }

}  //  @jve:decl-index=0:visual-constraint="7,-1"
