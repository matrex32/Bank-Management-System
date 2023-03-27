import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This is the third register frame that implements the data in the singupthree table
 *
 * @author Denis
 */
public class SignUpThree extends JFrame implements ActionListener {

    /**
     * Buttons used to choose account type
     */
    JRadioButton b1, b2, b3, b4;

    /**
     * Buttons used to choose the necessary services you want to have
     */
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    /**
     * Buttons used to complete registration or cancel registration
     */
    JButton finalizare, anulare;
    /**
     * Variable used to enter the number of the form in the database signupthree table in order to identify the user
     */
    String formular;

    SignUpThree(String formular) {

        this.formular = formular;

        setTitle("Umbrella Bank - Cont Nou");

        setLayout(null);


        JLabel l1 = new JLabel("Pagina 3: Detalii cont");
        l1.setFont(new Font("Times New Roman", Font.BOLD, 22));
        l1.setForeground(new Color(0xE30000));
        l1.setBounds(280, 40,400,40);
        add(l1);

        JLabel tip = new JLabel("Tipul contului:");
        tip.setFont(new Font("Times New Roman", Font.BOLD, 22));
        tip.setForeground(new Color(0xE30000));
        tip.setBounds(100, 140,200,30);
        add(tip);

        this.b1 = new JRadioButton("Cont de economii");
        b1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b1.setBounds(100,180,145,20);
        b1.setBackground(new Color(0xE30000));
        b1.setForeground(new Color(0xFFFFFF));
        add(b1);

        this.b2 = new JRadioButton("Cont de credit");
        b2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b2.setBounds(350,180,125,20);
        b2.setBackground(new Color(0xE30000));
        b2.setForeground(new Color(0xFFFFFF));
        add(b2);

        this.b3 = new JRadioButton("Cont de debit");
        b3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b3.setBounds(100,220,120,20);
        b3.setBackground(new Color(0xE30000));
        b3.setForeground(new Color(0xFFFFFF));
        add(b3);

        this.b4 = new JRadioButton("Cont de distribuție");
        b4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        b4.setBounds(350,220,150,20);
        b4.setBackground(new Color(0xE30000));
        b4.setForeground(new Color(0xFFFFFF));
        add(b4);

        ButtonGroup tipButton = new ButtonGroup();
        tipButton.add(b1);
        tipButton.add(b2);
        tipButton.add(b3);
        tipButton.add(b4);

        JLabel card = new JLabel("Număr card:");
        card.setFont(new Font("Times New Roman", Font.BOLD, 22));
        card.setForeground(new Color(0xE30000));
        card.setBounds(100, 300,200,30);
        add(card);

        JLabel numarCard = new JLabel("5564-XXXX-XXXX-XXXX");
        numarCard.setFont(new Font("Times New Roman", Font.BOLD, 22));
        numarCard.setForeground(new Color(0xE30000));
        numarCard.setBounds(330, 300,300,30);
        add(numarCard);

        JLabel cardDet = new JLabel("Numărul cardului dvs.");
        cardDet.setFont(new Font("Times New Roman", Font.BOLD, 12));
        cardDet.setForeground(new Color(0xE30000));
        cardDet.setBounds(100, 330,300,30);
        add(cardDet);

        JLabel pin = new JLabel("PIN:");
        pin.setFont(new Font("Times New Roman", Font.BOLD, 22));
        pin.setForeground(new Color(0xE30000));
        pin.setBounds(100, 370,200,30);
        add(pin);

        JLabel pinNumar = new JLabel("XXXX");
        pinNumar.setFont(new Font("Times New Roman", Font.BOLD, 22));
        pinNumar.setForeground(new Color(0xE30000));
        pinNumar.setBounds(330, 370,300,30);
        add(pinNumar);

        JLabel pinDet = new JLabel("Pinul cardului dvs.");
        pinDet.setFont(new Font("Times New Roman", Font.BOLD, 12));
        pinDet.setForeground(new Color(0xE30000));
        pinDet.setBounds(100, 400,300,30);
        add(pinDet);

        JLabel servicii = new JLabel("Servicii necesare:");
        servicii.setFont(new Font("Times New Roman", Font.BOLD, 22));
        servicii.setForeground(new Color(0xE30000));
        servicii.setBounds(100, 450,200,30);
        add(servicii);

        this.c1 = new JCheckBox("Card bancar");
        c1.setBackground(new Color(0xE30000));
        c1.setForeground(new Color(0xFFFFFF));
        c1.setFont(new Font("Times New Roman", Font.BOLD, 16));
        c1.setBounds(100,500,200,30);
        add(c1);

        this.c2 = new JCheckBox("Internet Banking");
        c2.setBackground(new Color(0xE30000));
        c2.setForeground(new Color(0xFFFFFF));
        c2.setFont(new Font("Times New Roman", Font.BOLD, 16));
        c2.setBounds(350,500,200,30);
        add(c2);

        this.c3 = new JCheckBox("Mobile Banking");
        c3.setBackground(new Color(0xE30000));
        c3.setForeground(new Color(0xFFFFFF));
        c3.setFont(new Font("Times New Roman", Font.BOLD, 16));
        c3.setBounds(100,550,200,30);
        add(c3);

        this.c4 = new JCheckBox("Alerte E-mail & SMS");
        c4.setBackground(new Color(0xE30000));
        c4.setForeground(new Color(0xFFFFFF));
        c4.setFont(new Font("Times New Roman", Font.BOLD, 16));
        c4.setBounds(350,550,200,30);
        add(c4);

        this.c5 = new JCheckBox("Carnet de cecuri");
        c5.setBackground(new Color(0xE30000));
        c5.setForeground(new Color(0xFFFFFF));
        c5.setFont(new Font("Times New Roman", Font.BOLD, 16));
        c5.setBounds(100,600,200,30);
        add(c5);

        this.c6 = new JCheckBox("Declarație electronică");
        c6.setBackground(new Color(0xE30000));
        c6.setForeground(new Color(0xFFFFFF));
        c6.setFont(new Font("Times New Roman", Font.BOLD, 16));
        c6.setBounds(350,600,200,30);
        add(c6);

        this.c7 = new JCheckBox("Declar pe propria răspundere că toate datele introduse în acest formular sunt corecte");
        c7.setBackground(new Color(0xE30000));
        c7.setForeground(new Color(0xFFFFFF));
        c7.setFont(new Font("Times New Roman", Font.BOLD, 16));
        c7.setBounds(100,680,620,30);
        add(c7);

        this.finalizare = new JButton("Finalizare");
        finalizare.setBackground(new Color(0xE30000));
        finalizare.setForeground(new Color(0xFFFFFF));
        finalizare.setFont(new Font("Times New Roman", Font.BOLD, 14));
        finalizare.setBounds(250, 720, 100, 30);
        finalizare.addActionListener(this);
        add(finalizare);

        this.anulare = new JButton("Anulare");
        anulare.setBackground(new Color(0xE30000));
        anulare.setForeground(new Color(0xFFFFFF));
        anulare.setFont(new Font("Times New Roman", Font.BOLD, 14));
        anulare.setBounds(420, 720, 100, 30);
        anulare.addActionListener(this);
        add(anulare);

        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("imagini/umbrela1.jpg"));
        Image i3 = icon3.getImage().getScaledInstance(850,820, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel label2 = new JLabel(i4);
        label2.setSize(850,820);
        add(label2);

        this.setSize(850, 820);
        this.setLocation(350, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);


    }

    /**
     *  Method used to make the frame buttons workable and to insert data into the database
     */
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == finalizare){
            String stip = null;
            if(b1.isSelected()){
                stip = "Cont de economii";
            }else if(b2.isSelected()){
                stip = "Cont de credit";
            }else if(b3.isSelected()){
                stip = "Cont de debit";
            }else if(b4.isSelected()){
                stip = "Cont de distribuție";
            }
            Random rand = new Random();
            String scard = "" + Math.abs((rand.nextLong() % 90000000L) + 5564963000000000L);
            String spin = "" +  Math.abs((rand.nextLong() % 9000L) + 1000L);

            String sfacilitati = "";
            if(c1.isSelected()){
                sfacilitati = sfacilitati + "Card bancar";
            }else if(c2.isSelected()){
                sfacilitati = sfacilitati + "Internet banking";
            }else if(c3.isSelected()){
                sfacilitati = sfacilitati + "Mobile Banking";
            }else if(c4.isSelected()){
                sfacilitati = sfacilitati + "Alerte E-mail & SMS";
            }else if(c5.isSelected()){
                sfacilitati = sfacilitati + "Carnet de cecuri";
            }else if(c6.isSelected()){
                sfacilitati = sfacilitati + "Declarație electronică";
            }

            try{
                if(stip.equals("")){
                    JOptionPane.showMessageDialog(null, "Trebuie să selectați tipul contului!");
                } else {
                    DbConnection c = new DbConnection();

                    StringBuilder query2Builder = new StringBuilder();
                    query2Builder.append("Insert into signupthree values (");
                    query2Builder.append("'").append(formular).append("',");
                    query2Builder.append("'").append(stip).append("',");
                    query2Builder.append("'").append(scard).append("',");
                    query2Builder.append("'").append(spin).append("',");
                    query2Builder.append("'").append(sfacilitati).append("')");

                    StringBuilder query3Builder = new StringBuilder();
                    query3Builder.append("Insert into login values (");
                    query3Builder.append("'").append(formular).append("',");
                    query3Builder.append("'").append(scard).append("',");
                    query3Builder.append("'").append(spin).append("')");

                    c.s.executeUpdate(query2Builder.toString());
                    c.s.executeUpdate(query3Builder.toString());

                    JOptionPane.showMessageDialog(null, "Numărul cardului este: " + scard + "\n Pinul cardului este: " + spin);

                    this.setVisible(false);
                    new Deposit(spin).setVisible(true);
                }
            }catch (Exception ex){
                System.out.println(ex);
            }


        }else if(e.getSource() == anulare){
            this.setVisible(false);
            new Login().setVisible(true);

        }

    }


    public static void main(String [] args){
        new SignUpThree("");
    }
}
