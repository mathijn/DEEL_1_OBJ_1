import java.awt.BorderLayout;
import javax.swing.JPanel;
import javax.swing.JFrame;
import java.awt.Dimension;
import javax.swing.JLabel;
import java.awt.Rectangle;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JComboBox;

/**
 * Deze gui-klasse bevat een label, een knop, een tekstveld,
 * een tekstgebied en een keuzelijst; puur om te laten zien
 * hoe die er uit zien.
 * @author Medewerker OUNL
 *
 */
public class VoorbeeldFrame extends JFrame {

  private static final long serialVersionUID = 1L;
  private JPanel jContentPane = null;
  private JLabel voorbeeldLabel = null;
  private JTextField voorbeeldVeld = null;
  private JTextArea voorbeeldGebied = null;
  private JButton voorbeeldKnop = null;
  private JComboBox voorbeeldKeuze = null;

  /**
   * This is the default constructor
   */
  public VoorbeeldFrame() {
    super();
    initialize();
    mijnInit();
  }
  
  /**
   * Plaatst enkele regels tekst in het tekstgebied
   * en enkele keuzes in de keuzelijst
   */
  private void mijnInit(){
    voorbeeldGebied.append("Dit is een tekstgebied\n");
    voorbeeldGebied.append("Er kunnen verschillende regels\n");
    voorbeeldGebied.append("tekst in getoond worden.\n");
    voorbeeldGebied.append("Een tekstgebied kan ook als invoer\n");
    voorbeeldGebied.append("gebruikt worden\n");
    
    voorbeeldKeuze.addItem("Dit is keuze1 in een keuzelijst");
    voorbeeldKeuze.addItem("Keuze2");
    voorbeeldKeuze.addItem("Of keuze3");
    voorbeeldKeuze.addItem("Zoveel u wilt");
  }


  /**
   * This method initializes this
   * 
   * @return void
   */
  private void initialize() {
    this.setSize(336, 306);
    this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    this.setContentPane(getJContentPane());
    this.setTitle("Enkele Swing-componenten");
  }

  /**
   * This method initializes jContentPane
   * 
   * @return javax.swing.JPanel
   */
  private JPanel getJContentPane() {
    if (jContentPane == null) {
      voorbeeldLabel = new JLabel();
      voorbeeldLabel.setBounds(new Rectangle(14, 13, 97, 31));
      voorbeeldLabel.setText("Dit is een label");
      jContentPane = new JPanel();
      jContentPane.setLayout(null);
      jContentPane.add(voorbeeldLabel, null);
      jContentPane.add(getVoorbeeldVeld(), null);
      jContentPane.add(getVoorbeeldGebied(), null);
      jContentPane.add(getVoorbeeldKnop(), null);
      jContentPane.add(getVoorbeeldKeuze(), null);
    }
    return jContentPane;
  }

  /**
   * This method initializes voorbeeldVeld	
   * 	
   * @return javax.swing.JTextField	
   */
  private JTextField getVoorbeeldVeld() {
    if (voorbeeldVeld == null) {
      voorbeeldVeld = new JTextField();
      voorbeeldVeld.setBounds(new Rectangle(15, 59, 247, 32));
      voorbeeldVeld.setText("Dit is een tekstveld. U kunt er tekst in typen");
    }
    return voorbeeldVeld;
  }
  
  /**
   * This method initializes voorbeeldGebied	
   * 	
   * @return javax.swing.JTextArea	
   */
  private JTextArea getVoorbeeldGebied() {
    if (voorbeeldGebied == null) {
      voorbeeldGebied = new JTextArea();
      voorbeeldGebied.setBounds(new Rectangle(16, 105, 244, 90));
      voorbeeldGebied.setText("");
    }
    return voorbeeldGebied;
  }
  
  /**
   * This method initializes voorbeeldKnop	
   * 	
   * @return javax.swing.JButton	
   */
  private JButton getVoorbeeldKnop() {
    if (voorbeeldKnop == null) {
      voorbeeldKnop = new JButton();
      voorbeeldKnop.setBounds(new Rectangle(122, 12, 137, 34));
      voorbeeldKnop.setText("Dit is een knop");
    }
    return voorbeeldKnop;
  }

  /**
   * This method initializes voorbeeldKeuze	
   * 	
   * @return javax.swing.JComboBox	
   */
  private JComboBox getVoorbeeldKeuze() {
    if (voorbeeldKeuze == null) {
      voorbeeldKeuze = new JComboBox();
      voorbeeldKeuze.setBounds(new Rectangle(15, 211, 242, 29));
    }
    return voorbeeldKeuze;
  }
  
  /**
   * Maakt en toont een instantie van deze klasse
   */
  public static void main(String[] args){
    VoorbeeldFrame gui = new VoorbeeldFrame();
    gui.setVisible(true);
  }

}  //  @jve:decl-index=0:visual-constraint="10,10"
