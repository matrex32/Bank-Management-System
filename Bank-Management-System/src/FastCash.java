import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.util.Date;

/**
 * Within this frame, the user can withdraw a fixed amount
 *
 * @author Denis
 */
public class FastCash extends JFrame implements ActionListener {

    /**
     * Buttons used to withdraw the desired amount of money and return to the transaction frame
     */
    JButton bani1, bani2, bani3, bani4, bani5, bani6, iesire;
    /**
     * The variable used to identify the user in the database
     */
    String pin;

    FastCash(String pin){
        this.pin = pin;

        setLayout(null);
        this.setTitle("ATM - Umbrella Bank");

        JLabel text = new JLabel("Selectați suma dorită!");
        text.setBounds(210,300,700,35);
        text.setFont(new Font("Times New Roman", Font.BOLD, 18));
        text.setForeground(new Color(0xFFFFFF));
        add(text);

        this.bani1 = new JButton("50");
        bani1.setBounds(170,415,150,30);
        bani1.setForeground(new Color(0xFFFFFF));
        bani1.setBackground(new Color(0xFF0000));
        bani1.addActionListener(this);
        add(bani1);

        this.bani2 = new JButton("100");
        bani2.setBounds(355,415,150,30);
        bani2.setForeground(new Color(0xFFFFFF));
        bani2.setBackground(new Color(0xFF0000));
        bani2.addActionListener(this);
        add(bani2);

        this.bani3 = new JButton("250");
        bani3.setBounds(170,450,150,30);
        bani3.setForeground(new Color(0xFFFFFF));
        bani3.setBackground(new Color(0xFF0000));
        bani3.addActionListener(this);
        add(bani3);

        this.bani4 = new JButton("500");
        bani4.setBounds(355,450,150,30);
        bani4.setForeground(new Color(0xFFFFFF));
        bani4.setBackground(new Color(0xFF0000));
        bani4.addActionListener(this);
        add(bani4);

        this.bani5 = new JButton("1000");
        bani5.setBounds(170,485,150,30);
        bani5.setForeground(new Color(0xFFFFFF));
        bani5.setBackground(new Color(0xFF0000));
        bani5.addActionListener(this);
        add(bani5);

        this.bani6 = new JButton("2000");
        bani6.setBounds(355,485,150,30);
        bani6.setForeground(new Color(0xFFFFFF));
        bani6.setBackground(new Color(0xFF0000));
        bani6.addActionListener(this);
        add(bani6);

        this.iesire = new JButton("Înapoi");
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
        label3.setBounds(210,305,170,25);
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
     * Method used to perform the withdrawal action related to the desired amount and save it in the database
     */
    public void actionPerformed(ActionEvent ae){

        if(ae.getSource() == iesire){
            this.setVisible(false);
            new Transactions(pin).setVisible(true);
        }else  {
            String suma = ((JButton)ae.getSource()).getText().substring(0);
            DbConnection c = new DbConnection();

            try{
                ResultSet resultSet = c.s.executeQuery("Select * from bank where pin =  '"+pin+"'");
                        int sold = 0;
                while (resultSet.next()){
                    if(resultSet.getString("type").equals("Depunere")){
                        sold += Integer.parseInt(resultSet.getString("suma"));

                    }else {
                        sold -= Integer.parseInt(resultSet.getString("suma"));

                    }
                    if (ae.getSource() != iesire && sold < Integer.parseInt(suma)){
                        JOptionPane.showMessageDialog(null,"Fonduri insuficiente!");
                        return;
                    }

                    Date date = new Date();

                    StringBuilder query4Builder = new StringBuilder();
                    query4Builder.append("Insert into bank values (");
                    query4Builder.append("'").append(pin).append("',");
                    query4Builder.append("'").append(date).append("',");
                    query4Builder.append("'").append("Retragere").append("',");
                    query4Builder.append("'").append(suma).append("')");

                    c.s.executeUpdate(query4Builder.toString());

                    JOptionPane.showMessageDialog(null, "Ați retras suma de " + suma + " RON cu succes!");

                    setVisible(false);
                    new Transactions(pin).setVisible(true);
                }
            }catch (Exception e){
                System.out.println(e);
            }



        }

    }

    public static void main(String [] args){
        new FastCash("");
    }
}
