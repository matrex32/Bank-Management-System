import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 * An account statement is made within this frame
 */
public class Statement extends JFrame implements ActionListener {

    /**
     * Button used to exit the application
     */
    JButton button;

    Statement(String numarPin){

        setLayout(null);

        this.setTitle("Extras de cont");

        JLabel sold = new JLabel();
        sold.setBounds(20, 500, 300, 20);
        add(sold);


        JLabel bank = new JLabel("Umbrella Bank");
        bank.setBounds(135,20,200,20);
        bank.setFont(new Font("Times New Roman", Font.BOLD, 18));
        bank.setForeground(new Color(0xE30000));
        add(bank);

        JLabel card = new JLabel();
        card.setBounds(20,80,300,20);
        add(card);

        JLabel date = new JLabel();
        date.setBounds(20,100,500,500);
        add(date);

        /**
         * By means of this try-catch block we display the first four digits and the last four digits of the user's card
         */
        try{
            DbConnection c = new DbConnection();
            ResultSet resultSet = c.s.executeQuery("select * from login where pin_card = '"+numarPin+"'");
            while (resultSet.next()){
                card.setText("Număr card: "+ resultSet.getString("numar_card").substring(0,4) +"-XXXX-XXXX-" + resultSet.getString("numar_card").substring(12));
                card.setForeground(new Color(0xE30000));
                card.setFont(new Font("Times New Roman", Font.BOLD, 15));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        /**
         * By means this try-catch block we display the date and time of the action performed by the user, the type of action and the amount withdrawn or deposited
         */
        try{

            DbConnection c = new DbConnection();
            ResultSet resultSet = c.s.executeQuery("select * from bank where pin =  '"+numarPin+"'");
            while (resultSet.next()){
                date.setText(date.getText() + "<html>" + resultSet.getString("date")+ "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" + resultSet.getString("type") + "&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;" +resultSet.getString("suma") + "<br><br><html>" );
                date.setForeground(new Color(0xE30000));
                date.setFont(new Font("Times New Roman", Font.BOLD, 15));
            }

        }catch (Exception e){
            System.out.println(e);
        }

        /**
         * By means of this try-catch block we display the balance of the user
         */

        try{

            DbConnection c = new DbConnection();

            ResultSet resultSet = c.s.executeQuery("Select * from bank where pin =  '" + numarPin + "'");
            int sol = 0;
            while (resultSet.next()) {
                if (resultSet.getString("type").equals("Depunere")) {
                    sol += Integer.parseInt(resultSet.getString("suma"));

                } else {
                    sol -= Integer.parseInt(resultSet.getString("suma"));
                }
                sold.setText("Soldul dumneavostră: " + sol + " RON" );
                sold.setForeground(new Color(0xE30000));
                sold.setFont(new Font("Times New Roman", Font.BOLD, 15));
            }
        }catch (Exception e){
            System.out.println(e);

        }

        this.button = new JButton("Ieșire");
        button.setForeground(new Color(0xFFFFFF));
        button.setBackground(new Color(0xFF0000));
        button.setBounds(360, 500, 100, 25);
        button.addActionListener(this);
        add(button);




        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("imagini/umbrela.jpg"));
        Image i5 = icon3.getImage().getScaledInstance(500,600, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i5);
        JLabel label2 = new JLabel(i4);
        label2.setSize(500,600);
        add(label2);

        this.setSize(500,600);
        this.setLocation(20,20);
        this.setVisible(true);
        this.setResizable(false);
        //this.setUndecorated(true);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    }

    /**
     * Method used to close the application
     */
    public void actionPerformed(ActionEvent ae){
        System.exit(0);
    }

    public static void main(String [] args){
        new Statement("");
    }
}
