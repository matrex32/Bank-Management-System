import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Transactions extends JFrame implements ActionListener {
    /**
     * Buttons used to open the frames where the respective action is performed
     */
    JButton depunere, retragere, baniRapizi, declarație, schimbarePin, soldCont, iesire;


    /**
     * Variable used to identify the user in the database in the table corresponding to the desired action
     */
    String pin;
    Transactions(String pin){
        this.pin = pin;

        setLayout(null);
        this.setTitle("ATM - Umbrella Bank");

        JLabel text = new JLabel("Selectați tranzacția dumneavoastră");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        text.setForeground(new Color(0xFFFFFF));
        add(text);

        this.depunere = new JButton("Depunere");
        depunere.setBounds(170,415,150,30);
        depunere.setForeground(new Color(0xFFFFFF));
        depunere.setBackground(new Color(0xFF0000));
        depunere.addActionListener(this);
        add(depunere);

        this.retragere = new JButton("Retragere");
        retragere.setBounds(355,415,150,30);
        retragere.setForeground(new Color(0xFFFFFF));
        retragere.setBackground(new Color(0xFF0000));
        retragere.addActionListener(this);
        add(retragere);

        this.baniRapizi = new JButton("Retragere rapidă");
        baniRapizi.setBounds(170,450,150,30);
        baniRapizi.setForeground(new Color(0xFFFFFF));
        baniRapizi.setBackground(new Color(0xFF0000));
        baniRapizi.addActionListener(this);
        add(baniRapizi);

        this.declarație = new JButton("Extras Cont");
        declarație.setBounds(355,450,150,30);
        declarație.setForeground(new Color(0xFFFFFF));
        declarație.setBackground(new Color(0xFF0000));
        declarație.addActionListener(this);
        add(declarație);

        this.schimbarePin = new JButton("Schimbare pin");
        schimbarePin.setBounds(170,485,150,30);
        schimbarePin.setForeground(new Color(0xFFFFFF));
        schimbarePin.setBackground(new Color(0xFF0000));
        schimbarePin.addActionListener(this);
        add(schimbarePin);

        this.soldCont = new JButton("Sold cont");
        soldCont.setBounds(355,485,150,30);
        soldCont.setForeground(new Color(0xFFFFFF));
        soldCont.setBackground(new Color(0xFF0000));
        soldCont.addActionListener(this);
        add(soldCont);

        this.iesire = new JButton("Ieșire");
        iesire.setBounds(355,520,150,30);
        iesire.setForeground(new Color(0xFFFFFF));
        iesire.setBackground(new Color(0xFF0000));
        iesire.addActionListener(this);
        add(iesire);




        ImageIcon icon5 = new ImageIcon(ClassLoader.getSystemResource("imagini/red.jpeg"));
        Image i6 = icon5.getImage().getScaledInstance(700,35, Image.SCALE_DEFAULT);
        ImageIcon i7 = new ImageIcon(i6);
        JLabel label3 = new JLabel(i7);
        label3.setSize(700,35);
        label3.setBounds(210,305,275,25);
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
     * Method used to make the atm buttons open the desired action frame
     */
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == iesire){
            System.exit(0);
        }else if(ae.getSource() == depunere){
            this.setVisible(false);
            new Deposit(pin).setVisible(true);
        }else if(ae.getSource() == retragere){
            this.setVisible(false);
            new Withdrawal(pin).setVisible(true);
        }else if(ae.getSource() == baniRapizi){
            this.setVisible(false);
            new FastCash(pin).setVisible(true);
        }else if(ae.getSource() == schimbarePin){
            this.setVisible(false);
            new PinChange(pin).setVisible(true);
        }else if(ae.getSource() == soldCont){
            this.setVisible(false);
            new Balance(pin);
        }else if(ae.getSource() == declarație){
            this.setVisible(false);
            new Statement(pin).setVisible(true);
        }

    }

    public static void main(String [] args){

        new Transactions("");
    }
}
