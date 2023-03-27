import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;

/**
 * Within this frame, the user can deposit the desired amount of money
 *
 * @author Denis
 */
public class Deposit extends JFrame implements ActionListener {

    /**
     * Text field used to enter the amount the user wants to deposit
     */
    JTextField suma;
    /**
     * Buttons used to perform the deposit operation or to return to the transaction frame
     */
    JButton depunere, inapoi;
    /**
     * The variable used to identify the user
     */
    String pin;

    Deposit(String pin){
        this.pin = pin;

        setLayout(null);

        JLabel text = new JLabel("Introduceți suma pe care doriți să o depuneți!");
        text.setFont(new Font("Times New Roman",Font.BOLD,16));
        text.setForeground(new Color(0xFFFFFF));
        text.setBounds(170,300,400,20);
        add(text);

        this.suma = new JTextField();
        suma.setFont(new Font("Times New Roman", Font.BOLD, 22));
        suma.setBounds(170,350,320,25);
        add(suma);

        this.depunere = new JButton("Depunere");
        depunere.setBounds(355,485,150,30);
        depunere.setForeground(new Color(0xFFFFFF));
        depunere.setBackground(new Color(0xFF0000));
        depunere.addActionListener(this);
        add(depunere);

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
        label3.setBounds(168,298,306,25);
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
     * Method used to make the buttons workable and insert the data entered into the database
     */
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource() == depunere){
            String numar = suma.getText();
            Date date = new Date();
            if(numar.equals("")){
                JOptionPane.showMessageDialog(null,"Introduceți suma pe care doriți să o depuneți!");
            }else {
               try {
                   DbConnection c = new DbConnection();

                   StringBuilder query4Builder = new StringBuilder();
                   query4Builder.append("Insert into bank values (");
                   query4Builder.append("'").append(pin).append("',");
                   query4Builder.append("'").append(date).append("',");
                   query4Builder.append("'").append("Depunere").append("',");
                   query4Builder.append("'").append(numar).append("')");

                   c.s.executeUpdate(query4Builder.toString());
                   JOptionPane.showMessageDialog(null, "Ați depus suma de " + numar + " RON cu succes!");

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
        new Deposit("");
    }
}
