import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Within this frame, the user can find out his account balance
 *
 * @author Denis
 */
public class Balance extends JFrame implements ActionListener {

    /**
     * Button used to return to the transaction frame
     */
    JButton inapoi;
    /**
     * The variable used to identify the user in the database
     */
    String numarPin;

    Balance(String numarPin){
        this.numarPin = numarPin;

        setLayout(null);



        this.inapoi = new JButton("Înapoi");
        inapoi.setBounds(355,520,150,30);
        inapoi.setForeground(new Color(0xFFFFFF));
        inapoi.setBackground(new Color(0xFF0000));
        inapoi.addActionListener(this);
        add(inapoi);

        DbConnection c = new DbConnection();

        int sold = 0;
        /**
         * Within this try-catch block, the balance is found
         */

        try {
            ResultSet resultSet = c.s.executeQuery("Select * from bank where pin =  '" + numarPin + "'");
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Depunere")) {
                    sold += Integer.parseInt(resultSet.getString("suma"));

                } else {
                    sold -= Integer.parseInt(resultSet.getString("suma"));
                }
            }
        }catch (Exception e){
            System.out.println(e);
        }

        JLabel text = new JLabel("Soldul dumneavostră este " + sold + " RON");
        text.setFont(new Font("Times New Roman", Font.BOLD, 19));
        text.setBounds(170,300,400,30);
        text.setForeground(new Color(0xFFFFFF));
        text.setBackground(new Color(0xFF0000));
        add(text);

        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("imagini/red.jpeg"));
        Image i6 = icon5.getImage().getScaledInstance(700,35, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel label3 = new JLabel(i7);
        label3.setSize(700,35);
        label3.setBounds(170,303,320,25);
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
     * In this method we set the action of returning back to the transaction frame via the button
     */
    public void actionPerformed(ActionEvent e) {
        this.setVisible(false);
        new Transactions(numarPin).setVisible(true);
    }

    public static void main(String [] args){
        new Balance("");
    }

}
