import com.toedter.calendar.JDateChooser;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

/**
 * This is the first registry framework that implements data in the singup table
 *
 * @author Denis
 */
public class SignUp extends JFrame implements ActionListener {
    /**
     * Variable used to generate the form number
     */
    long random;
    /**
     * Next button used to move to the next frame
     */
    JButton next;
    /**
     * Calendar for choosing the birthday using the jcalendar library
     */
    JDateChooser alegerezdn;
    /**
     * Buttons used for choosing gender and marital status
     */
    JRadioButton barbat, femeie, casatorit, necasatorit, divortat;
    /**
     * Text field for the user's name, father's name, address, city, email, postal code and county
     */
    JTextField numetext, tatatext, mailtext, adresatext, orastext, codText, judettext;
    /**
     * Variable used to store the number of the form
     */
    public String formular;

    SignUp(){

        setTitle("Umbrella Bank - Cont Nou");

        setLayout(null);

        Random ran = new Random();
        this.random = Math.abs((ran.nextLong() % 9000) + 1000);


        JLabel formular = new JLabel("Formularul cu Nr. " + random);
        formular.setFont(new Font("Times New Roman", Font.BOLD, 38));
        formular.setBounds(140,20,600,40);
        formular.setForeground(new Color(0xE30000));
        add(formular);

        JLabel detaliiPersonale = new JLabel("Pagina 1: Detalii personale");
        detaliiPersonale.setFont(new Font("Times New Roman", Font.BOLD, 22));
        detaliiPersonale.setBounds(290,80,400,30);
        detaliiPersonale.setForeground(new Color(0xE30000));
        add(detaliiPersonale);

        JLabel nume = new JLabel("Nume și prenume:");
        nume.setFont(new Font("Times New Roman", Font.BOLD, 22));
        nume.setBounds(100,140,200,30);
        nume.setForeground(new Color(0xE30000));
        add(nume);

        this.numetext = new JTextField();
        numetext.setFont(new Font("Times New Roman", Font.BOLD, 14));
        numetext.setBounds(300,140,400,30);
        numetext.setForeground(new Color(0xE30000));
        add(numetext);

        JLabel numeTata = new JLabel("Numele tatălui:");
        numeTata.setFont(new Font("Times New Roman", Font.BOLD, 22));
        numeTata.setBounds(100,190,200,30);
        numeTata.setForeground(new Color(0xE30000));
        add(numeTata);

        this.tatatext = new JTextField();
        tatatext.setFont(new Font("Times New Roman", Font.BOLD, 14));
        tatatext.setBounds(300,190,400,30);
        tatatext.setForeground(new Color(0xE30000));
        add(tatatext);

        JLabel zdn = new JLabel("Zi de naștere:");
        zdn.setFont(new Font("Times New Roman", Font.BOLD, 22));
        zdn.setBounds(100,240,200,30);
        zdn.setForeground(new Color(0xE30000));
        add(zdn);

        this.alegerezdn = new JDateChooser();
        alegerezdn.setBounds(300, 240, 400,30);
        alegerezdn.setBackground(new Color(0xE30000));
        alegerezdn.setFont(new Font("Times New Roman", Font.BOLD, 14));
        add(alegerezdn);

        JLabel sex = new JLabel("Sex:");
        sex.setFont(new Font("Times New Roman", Font.BOLD, 22));
        sex.setBounds(100,290,200,30);
        sex.setForeground(new Color(0xE30000));
        add(sex);

        this.barbat = new JRadioButton("Bărbat");
        barbat.setBounds(300,290,80,30);
        barbat.setBackground(new Color(0xE30000));
        barbat.setForeground(new Color(0xFFFFFF));
        add(barbat);

        this.femeie = new JRadioButton("Femeie");
        femeie.setBounds(450,290,80,30);
        femeie.setBackground(new Color(0xE30000));
        femeie.setForeground(new Color(0xFFFFFF));
        add(femeie);

        ButtonGroup butonsex = new ButtonGroup();
        butonsex.add(barbat);
        butonsex.add(femeie);

        JLabel mail = new JLabel("Adresă de e-mail:");
        mail.setFont(new Font("Times New Roman", Font.BOLD, 22));
        mail.setBounds(100,340,200,30);
        mail.setForeground(new Color(0xE30000));
        add(mail);

        this.mailtext = new JTextField();
        mailtext.setFont(new Font("Times New Roman", Font.BOLD, 14));
        mailtext.setBounds(300,340,400,30);
        mailtext.setForeground(new Color(0xE30000));
        add(mailtext);

        JLabel sc = new JLabel("Stare civilă:");
        sc.setFont(new Font("Times New Roman", Font.BOLD, 22));
        sc.setBounds(100,390,200,30);
        sc.setForeground(new Color(0xE30000));
        add(sc);

        this.casatorit = new JRadioButton("Căsătorit/ă");
        casatorit.setBounds(300,390,90,30);
        casatorit.setBackground(new Color(0xE30000));
        casatorit.setForeground(new Color(0xFFFFFF));
        add(casatorit);

        this.necasatorit = new JRadioButton("Necăsătorit/ă");
        necasatorit.setBounds(450,390,110,30);
        necasatorit.setBackground(new Color(0xE30000));
        necasatorit.setForeground(new Color(0xFFFFFF));
        add(necasatorit);

        this.divortat = new JRadioButton("Divorțat/ă");
        divortat.setBounds(610,390,85,30);
        divortat.setBackground(new Color(0xE30000));
        divortat.setForeground(new Color(0xFFFFFF));
        add( divortat);

        ButtonGroup scb = new ButtonGroup();
        scb.add(casatorit);
        scb.add(necasatorit);
        scb.add(divortat);

        JLabel adresa = new JLabel("Adresă:");
        adresa.setFont(new Font("Times New Roman", Font.BOLD, 22));
        adresa.setBounds(100,440,200,30);
        adresa.setForeground(new Color(0xE30000));
        add(adresa);

        this.adresatext = new JTextField();
        adresatext.setFont(new Font("Times New Roman", Font.BOLD, 14));
        adresatext.setBounds(300,440,400,30);
        adresatext.setForeground(new Color(0xE30000));
        add(adresatext);

        JLabel oras = new JLabel("Oraș:");
        oras.setFont(new Font("Times New Roman", Font.BOLD, 22));
        oras.setBounds(100,490,200,30);
        oras.setForeground(new Color(0xE30000));
        add(oras);

        this.orastext = new JTextField();
        orastext.setFont(new Font("Times New Roman", Font.BOLD, 14));
        orastext.setBounds(300,490,400,30);
        orastext.setForeground(new Color(0xE30000));
        add(orastext);

        JLabel judet = new JLabel("Județ:");
        judet.setFont(new Font("Times New Roman", Font.BOLD, 22));
        judet.setBounds(100,540,200,30);
        judet.setForeground(new Color(0xE30000));
        add(judet);

        this.judettext = new JTextField();
        judettext.setFont(new Font("Times New Roman", Font.BOLD, 14));
        judettext.setBounds(300,540,400,30);
        judettext.setForeground(new Color(0xE30000));
        add(judettext);

        JLabel codPin = new JLabel("Cod poștal:");
        codPin.setFont(new Font("Times New Roman", Font.BOLD, 22));
        codPin.setBounds(100,590,200,30);
        codPin.setForeground(new Color(0xE30000));
        add(codPin);

        this.codText = new JTextField();
        codText.setFont(new Font("Times New Roman", Font.BOLD, 14));
        codText.setBounds(300,590,400,30);
        codText.setForeground(new Color(0xE30000));
        add(codText);

        next = new JButton("Următorul pas");
        next.setBackground(new Color(0xE30000));
        next.setForeground(new Color(0xFFFFFF));
        next.setFont(new Font("Times New Roman", Font.BOLD, 14));
        next.setBounds(620,660,130,30);
        next.addActionListener(this);
        add(next);


        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("imagini/umbrela1.jpg"));
        Image i3 = icon3.getImage().getScaledInstance(850,800, Image.SCALE_DEFAULT);
        ImageIcon i4 = new ImageIcon(i3);
        JLabel label2 = new JLabel(i4);
        label2.setSize(850,800);
        add(label2);

        this.setSize(850,800);
        this.setLocation(350,10);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(false);
        this.setVisible(true);
    }

    /**
     *  Method used to make the frame buttons workable and to insert data into the database
     */
    public void actionPerformed(ActionEvent e){
         this.formular = "" + random;
         String nume = numetext.getText();
         String numeTata = tatatext.getText();
         String zdn = ((JTextField) alegerezdn.getDateEditor().getUiComponent()).getText();
         String sex = null;

         if (barbat.isSelected()){
             sex = "Bărbat";
         }else if(femeie.isSelected()){
             sex = "Femeie";
         }
         String mail = mailtext.getText();
         String sc = null;

         if(casatorit.isSelected()){
             sc = "Căsătorit/ă";
         }else if(necasatorit.isSelected()){
             sc = "Necăsătorit/ă";
         }else if(divortat.isSelected()){
             sc = "Divorțat/ă";
         }
         String adresa = adresatext.getText();
         String oras = orastext.getText();
         String judet = judettext.getText();
         String cod = codText.getText();

         try{
             if(nume.equals("")){
                 JOptionPane.showMessageDialog(null, "Trebuie sa vă introduceți numele!");
             }else {
                 DbConnection c = new DbConnection();

                 StringBuilder queryBuilder = new StringBuilder();
                 queryBuilder.append("Insert into signup values (");
                 queryBuilder.append("'").append(formular).append("',");
                 queryBuilder.append("'").append(nume).append("',");
                 queryBuilder.append("'").append(numeTata).append("',");
                 queryBuilder.append("'").append(zdn).append("',");
                 queryBuilder.append("'").append(sex).append("',");
                 queryBuilder.append("'").append(mail).append("',");
                 queryBuilder.append("'").append(sc).append("',");
                 queryBuilder.append("'").append(adresa).append("',");
                 queryBuilder.append("'").append(oras).append("',");
                 queryBuilder.append("'").append(judet).append("',");
                 queryBuilder.append("'").append(cod).append("')");

                 c.s.executeUpdate(queryBuilder.toString());


                 setVisible(false);
                 new SignUpTwo(formular).setVisible(true);
             }
         }catch (Exception ex){
             System.out.println(ex);
         }


    }
    public static void main(String [] args){

        new SignUp();

    }
}
