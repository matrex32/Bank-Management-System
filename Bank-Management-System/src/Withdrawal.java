import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Within this frame, the user can withdraw any amount he wants
 *
 * @author Denis
 */
public class Withdrawal extends JFrame implements ActionListener {

    /**
     * Text field used to enter the amount the user wants to withdraw
     */
    JTextField suma;
    /**
     * Buttons used to perform the withdrawal action or return to the transaction frame
     */
    JButton retragere, inapoi;
    /**
     * The variable used to identify the user in the database
     */
    String pin;

    Withdrawal(String pin){
        this.pin = pin;

        setLayout(null);

        JLabel text = new JLabel("Introduceți suma pe care doriți să o retrageți!");
        text.setFont(new Font("Times New Roman",Font.BOLD,16));
        text.setForeground(new Color(0xFFFFFF));
        text.setBounds(170,300,400,20);
        add(text);

        this.suma = new JTextField();
        suma.setFont(new Font("Times New Roman", Font.BOLD, 22));
        suma.setBounds(170,350,320,25);
        add(suma);

        this.retragere = new JButton("Retragere");
        retragere.setBounds(355,485,150,30);
        retragere.setForeground(new Color(0xFFFFFF));
        retragere.setBackground(new Color(0xFF0000));
        retragere.addActionListener(this);
        add(retragere);

        this.inapoi = new JButton("Înapoi");
        inapoi.setBounds(355,520,150,30);
        inapoi.setForeground(new Color(0xFFFFFF));
        inapoi.setBackground(new Color(0xFF0000));
        inapoi.addActionListener(this);
        add(inapoi);

        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("imagini/red.jpeg"));
        Image i6 = icon5.getImage().getScaledInstance(700,35, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel label3 = new JLabel(i7);
        label3.setSize(700,35);
        label3.setBounds(168,298,310,25);
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


        this.setSize(900,900);
        this.setLocation(300,0);
        this.setResizable(false);
        this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

    /**
     * Method used to retrieve the amount entered by the user and extract it and save the action performed in the database
     */
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == retragere){
            String numar = suma.getText();
            Date date = new Date();
            if(numar.equals("")){
                JOptionPane.showMessageDialog(null,"Introduceți suma pe care doriți să o retrageți!");
            }else {
                try {
                    DbConnection c = new DbConnection();

                    StringBuilder query4Builder = new StringBuilder();
                    query4Builder.append("Insert into bank values (");
                    query4Builder.append("'").append(pin).append("',");
                    query4Builder.append("'").append(date).append("',");
                    query4Builder.append("'").append("Retragere").append("',");
                    query4Builder.append("'").append(numar).append("')");

                    c.s.executeUpdate(query4Builder.toString());
                    JOptionPane.showMessageDialog(null, "Ați retras suma de " + numar + " RON cu succes!");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);

                }catch (Exception e){
                    System.out.println(e);
                }
            }


        }else if(ae.getSource() == inapoi){
            this.setVisible(false);
            new Transactions(pin).setVisible(true);

        }
    }

    public static void main(String [] args){
        new Withdrawal("");
    }
}
