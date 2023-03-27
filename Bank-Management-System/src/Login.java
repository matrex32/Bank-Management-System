import Utils.Messages;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * Login frame used to validate data and login into app
 *
 * @author Denis
 */
public class Login extends JFrame implements ActionListener {

    /**
     * Text for buttons
     */
    JButton login, signup, clear;
    /**
     * Text for the card Name
     */
    JTextField cardText;

    /**
     * Hidden text for pin
     */
    JPasswordField pinText;

    Login(){

        setTitle("Umbrella Bank");

        setLayout(null);

        addLabelToFrame();


        JLabel text = new JLabel(Messages.WELCOME_STRING);
        text.setFont(new Font( "Times New Roman", Font.BOLD, 38));
        text.setBounds(200,40,600,40);
        text.setForeground(new Color(0xE30000));
        add(text);

        JLabel card = new JLabel("Număr card:");
        card.setFont(new Font( "Times New Roman", Font.BOLD, 28));
        card.setBounds(120,150,250,30);
        card.setForeground(new Color(0xE30000));
        add(card);

        cardText = new JTextField();
        cardText.setVisible(true);
        cardText.setBounds(300,150,230,30);
        cardText.setFont(new Font("Times New Roman", Font.BOLD, 14));
        cardText.setForeground(new Color(0xE30000));
        add(cardText);

        JLabel pin = new JLabel("PIN card:");
        pin.setFont(new Font( "Times New Roman", Font.BOLD, 28));
        pin.setBounds(120,220,250,30);
        pin.setForeground(new Color(0xE30000));
        add(pin);

        pinText = new JPasswordField();
        pinText.setVisible(true);
        pinText.setBounds(300,220,230,30);
        pinText.setFont(new Font("Times New Roman", Font.BOLD, 14));
        pinText.setForeground(new Color(0xE30000));
        add(pinText);

        login = new JButton("LOGARE");
        login.setBounds(300, 300, 100, 30);
        login.setBackground(new Color(0xE30000));
        login.setForeground(new Color(0xFFFFFF));
        login.addActionListener(this);
        add(login);

        clear = new JButton("ȘTERGE");
        clear.setBounds(430, 300, 100, 30);
        clear.setBackground(new Color(0xE30000));
        clear.setForeground(new Color(0xFFFFFF));
        clear.addActionListener(this);
        add(clear);

        signup = new JButton("ÎNREGISTRARE");
        signup.setBounds(300, 350, 230, 30);
        signup.setBackground(new Color(0xE30000));
        signup.setForeground(new Color(0xFFFFFF));
        signup.addActionListener(this);
        add(signup);


        /**
         * Image used to create the background of the frame
         */

        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("imagini/umbrela.jpg"));
        Image i3 = icon3.getImage().getScaledInstance(800,480, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel label2 = new JLabel(i4);
        label2.setSize(800,480);
        add(label2);

        this.setSize(800, 480);
        this.setVisible(true);
        this.setLocation(350,200);
        this.setResizable(false);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    /**
     * Method used to add the Label to the login Frame
     */
    private void addLabelToFrame() {
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("imagini/redbank.png"));
        Image i2 = icon1.getImage().getScaledInstance(100,100, Image.SCALE_DEFAULT);
        ImageIcon icon2 = new ImageIcon(i2);
        JLabel label = new JLabel(icon2);
        label.setBounds(70, 10, 100, 100);
        add(label);
    }

    /**
     *  Method used to make the frame buttons workable and to search in the database if the data entered by the user are valid
     */
    public void actionPerformed(ActionEvent e){

        if(e.getSource() == clear){
            cardText.setText("");
            pinText.setText("");
        } else if(e.getSource() == login){
            DbConnection c = new DbConnection();
            String scard = cardText.getText();
            String spin = pinText.getText();
            String query = "Select * from login where numar_card =  '"+scard+"' and pin_card = '"+spin+"'";

            try{
                ResultSet resultSet = c.s.executeQuery(query);
                if(resultSet.next()){
                    setVisible(false);
                    new Transactions(spin).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Ați introdus un număr de card sau un pin greșit!");
                }
            }catch (Exception exp){
                System.out.println(exp);
            }

        } else if(e.getSource() == signup){
            setVisible(false);
            new SignUp().setVisible(true);

        }


    }
    public static void main (String [] args){


        new Login();
    }

}
