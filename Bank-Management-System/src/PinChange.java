import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Within this frame, the user can change his card pin
 *
 * @author Denis
 */
public class PinChange extends JFrame implements ActionListener {

    /**
     * Text field used to enter the new password
     */
    JTextField tpin, repin;
    /**
     * Buttons used to perform the password change action or return to the transaction frame
     */
    JButton back, change;
    /**
     * The variable used to identify the user in the database
     */
    String pinChange;

    PinChange(String pinChange){

        this.pinChange = pinChange;

        setLayout(null);


        JLabel text = new JLabel("Schimbare PIN");
        text.setBounds(285,300,700,35);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        text.setForeground(new Color(0xFFFFFF));
        add(text);


         JLabel pintext = new JLabel("PIN nou:");
        pintext.setBounds(165,335,180,25);
        pintext.setFont(new Font("Times New Roman", Font.BOLD, 20));
        pintext.setForeground(new Color(0xFF0000));
        add(pintext);

        this.tpin = new JTextField();
        tpin.setBounds(330,335,180,25);
        tpin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(tpin);


        JLabel repintext = new JLabel("Confirmare PIN:");
        repintext.setBounds(165,375,180,25);
        repintext.setFont(new Font("Times New Roman", Font.BOLD, 20));
        repintext.setForeground(new Color(0xFF0000));
        add(repintext);

        this.repin = new JTextField();
        repin.setBounds(330,375,180,25);
        repin.setFont(new Font("Times New Roman", Font.BOLD, 20));
        add(repin);

        this.change = new JButton("Confirmare");
        change.setBounds(355,485,150,30);
        change.setForeground(new Color(0xFFFFFF));
        change.setBackground(new Color(0xFF0000));
        change.addActionListener(this);
        add(change);

        this.back = new JButton("Înapoi");
        back.setBounds(355,520,150,30);
        back.setForeground(new Color(0xFFFFFF));
        back.setBackground(new Color(0xFF0000));
        back.addActionListener(this);
        add(back);

        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("imagini/red.jpeg"));
        Image i6 = icon5.getImage().getScaledInstance(700,35, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel label3 = new JLabel(i7);
        label3.setSize(700,35);
        label3.setBounds(270,305,150,25);
        add(label3);




        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("imagini/umbrela.jpg"));
        Image i5 = icon3.getImage().getScaledInstance(800,480, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i5);
        JLabel label2 = new JLabel(i4);
        label2.setSize(800,480);
        label2.setBounds(150,282,370,270);
        add(label2);

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("imagini/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0,0,900,900);
        add(image);



        this.setSize(900, 900);
        this.setLocation(300, 0);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(true);
        this.setResizable(false);
        this.setVisible(true);



    }

    /**
     * Method used to perform the desired action through the buttons and save the new password in the database
     */

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == back) {
            this.setVisible(false);
            new Transactions("").setVisible(true);

        }else if(e.getSource() == change){
            try{
                String spin = tpin.getText();
                String rpin = repin.getText();

                if(!spin.equals(rpin)){
                    JOptionPane.showMessageDialog(null, "PIN-urile introduse nu corespund!");
                }

                if(spin.equals("")){
                    JOptionPane.showMessageDialog(null,"Introduceți noul PIN-ul!");
                }

                if(repin.equals("")){
                    JOptionPane.showMessageDialog(null,"Reintroduceți noul PIN-ul!");
                }

               if(spin.equals(rpin)) {
                   DbConnection c = new DbConnection();
                   String query1 = "update bank set pin = '" + spin + "' where pin = '" + pinChange + "'";
                   String query2 = "update login set pin_card = '" + spin + "' where pin_card = '" + pinChange + "'";
                   String query3 = "update signupthree set pin_card = '" + spin + "' where pin_card = '" + pinChange + "'";

                   c.s.executeUpdate(query1);
                   c.s.executeUpdate(query2);
                   c.s.executeUpdate(query3);

                   JOptionPane.showMessageDialog(null, "PIN-ul a fost schimbat cu succes!");

                   setVisible(false);
                   new Transactions(spin).setVisible(true);
               }

            }catch (Exception ae){
                System.out.println(ae);
            }
        }
    }

    public static void main(String [] args){
        new PinChange("");
    }

}
