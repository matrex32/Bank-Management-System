import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * This is the second register frame that implements the data in the singuptwo table
 *
 * @author Denis
 */

public class SignUpTwo extends JFrame implements ActionListener {

    /**
     * Next button used to move to the next frame
     */
    JButton next;
    /**
     * Buttons used to confirm if you are an adult citizen and if you have already created an account
     */
    JRadioButton da, nu, da1, nu1;
    /**
     * Text field used for CNP and phone number
     */
    JTextField cnpText, numarText;
    /**
     * Field used to declare the number of heirs, if you are a natural or legal person, income, level of education and occupation
     */
    JComboBox mostenitoriList, persoanaList, venitList, educatieList, ocupatieList;
    /**
     * Variable used to enter the number of the form in the database singuptwo table in order to identify the user
     */
    String formular;
    SignUpTwo(String formular){

        this.formular = formular;

        setTitle("Umbrella Bank - Cont Nou");

        setLayout(null);


        JLabel detaliiSuplimentare = new JLabel("Pagina 2: Detalii suplimentare");
        detaliiSuplimentare.setFont(new Font("Times New Roman", Font.BOLD, 22));
        detaliiSuplimentare.setBounds(290,50,400,40);
        detaliiSuplimentare.setForeground(new Color(0xE30000));
        add(detaliiSuplimentare);

        JLabel mostenitori = new JLabel("Moștenitori:");
        mostenitori.setFont(new Font("Times New Roman", Font.BOLD, 22));
        mostenitori.setBounds(100,140,200,30);
        mostenitori.setForeground(new Color(0xE30000));
        add(mostenitori);

        String [] valMostenitori = {" ", "Nu am", "Am un moștenitor", "Am doi moștenitori", "Am trei moștenitori", "Am trei moștenitori", "Am patru moștenitori", "Am cinci moștenitori","Am mai mult de cinci moștenitori"};
        this.mostenitoriList = new JComboBox<>(valMostenitori);
        mostenitoriList.setBounds(300,140,400,30);
        mostenitoriList.setForeground(new Color(0xE30000));
        add(mostenitoriList);

        JLabel persoana = new JLabel("Persoană:");
        persoana.setFont(new Font("Times New Roman", Font.BOLD, 22));
        persoana.setBounds(100,190,200,30);
        persoana.setForeground(new Color(0xE30000));
        add(persoana);

        String [] valPersoana = {"", "Fizică", "Juridică"};
        this.persoanaList = new JComboBox(valPersoana);
        persoanaList.setBounds(300,190,400,30);
        persoanaList.setForeground(new Color(0xE30000));
        add(persoanaList);

        JLabel venit = new JLabel("Venit lunar:");
        venit.setFont(new Font("Times New Roman", Font.BOLD, 22));
        venit.setBounds(100,240,200,30);
        venit.setForeground(new Color(0xE30000));
        add(venit);

        String [] valVenit = {" ", " Nu am venit", " < 1.000 RON", " < 3.000 RON", " < 5.000 RON", "< 10.000 RON", "< 15.000 RON", "< 20.000 RON", " < 40.000 RON", " < 80.000 RON" };
        this.venitList = new JComboBox(valVenit);
        venitList.setBounds(300, 240, 400,30);
        venitList.setForeground(new Color(0xE30000));
        add(venitList);

        JLabel educatie = new JLabel("Educație:");
        educatie.setFont(new Font("Times New Roman", Font.BOLD, 22));
        educatie.setBounds(100,315,200,30);
        educatie.setForeground(new Color(0xE30000));
        add(educatie);

        String [] valEducatie = {"", "8 clase", "10 clase", "12 clase", "Bacalaureat", "Student",  "Postuniversitar", "Masterat", "Doctorat", "Altele" };
        this.educatieList = new JComboBox<>(valEducatie);
        educatieList.setBounds(300, 315, 400,30);
        educatieList.setForeground(new Color(0xE30000));
        add(educatieList);

        JLabel ocupatie = new JLabel("Ocupație:");
        ocupatie.setFont(new Font("Times New Roman", Font.BOLD, 22));
        ocupatie.setBounds(100,390,200,30);
        ocupatie.setForeground(new Color(0xE30000));
        add(ocupatie);

        String [] valOcupatie = {"", "Elev", "Student", "Angajat", "Liber profesionist",  "Afacerist", "Pensionar", "Altele"};
        this.ocupatieList = new JComboBox<>(valOcupatie);
        ocupatieList.setBounds(300, 390, 400,30);
        ocupatieList.setForeground(new Color(0xE30000));
        add(ocupatieList);

        JLabel cnp = new JLabel("CNP:");
        cnp.setFont(new Font("Times New Roman", Font.BOLD, 22));
        cnp.setBounds(100,440,200,30);
        cnp.setForeground(new Color(0xE30000));
        add(cnp);

        this.cnpText = new JTextField();
        cnpText.setFont(new Font("Times New Roman", Font.BOLD, 14));
        cnpText.setBounds(300,440,400,30);
        cnpText.setForeground(new Color(0xE30000));
        add(cnpText);

        JLabel numar = new JLabel("Număr telefon:");
        numar.setFont(new Font("Times New Roman", Font.BOLD, 22));
        numar.setBounds(100,490,200,30);
        numar.setForeground(new Color(0xE30000));
        add(numar);

        this.numarText = new JTextField();
        numarText.setFont(new Font("Times New Roman", Font.BOLD, 14));
        numarText.setBounds(300,490,400,30);
        numarText.setForeground(new Color(0xE30000));
        add(numarText);

        JLabel major = new JLabel("Cetățean major:");
        major.setFont(new Font("Times New Roman", Font.BOLD, 22));
        major.setBounds(100,540,200,30);
        major.setForeground(new Color(0xE30000));
        add(major);

        this.da = new JRadioButton("Da");
        da.setBounds(300,540,50,30);
        da.setBackground(new Color(0xE30000));
        da.setForeground(new Color(0xFFFFFF));
        add(da);

        this.nu = new JRadioButton("Nu");
        nu.setBounds(450,540,50,30);
        nu.setBackground(new Color(0xE30000));
        nu.setForeground(new Color(0xFFFFFF));
        add(nu);

        ButtonGroup buton = new ButtonGroup();
        buton.add(da);
        buton.add(nu);

        JLabel cont = new JLabel("Cont existent:");
        cont.setFont(new Font("Times New Roman", Font.BOLD, 22));
        cont.setBounds(100,590,200,30);
        cont.setForeground(new Color(0xE30000));
        add(cont);

        this.da1 = new JRadioButton("Da");
        da1.setBounds(300,590,50,30);
        da1.setBackground(new Color(0xE30000));
        da1.setForeground(new Color(0xFFFFFF));
        add(da1);

        this.nu1 = new JRadioButton("Nu");
        nu1.setBounds(450,590,50,30);
        nu1.setBackground(new Color(0xE30000));
        nu1.setForeground(new Color(0xFFFFFF));
        add(nu1);

        ButtonGroup buton1 = new ButtonGroup();
        buton1.add(da1);
        buton1.add(nu1);

        this.next = new JButton("Următorul pas");
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
        String smostenitori = (String) mostenitoriList.getSelectedItem();
        String spersoana = (String) persoanaList.getSelectedItem();
        String svenit = (String) venitList.getSelectedItem();
        String seducatie = (String) educatieList.getSelectedItem();
        String socupatie = (String) ocupatieList.getSelectedItem();
        String smajor = null;

        if (da.isSelected()){
            smajor = "Da";
        }else if(nu.isSelected()){
            smajor = "Nu";
        }
        String scontExistent = null;

        if(da1.isSelected()){
            scontExistent = "Da";
        }else if(nu1.isSelected()){
            scontExistent = "Nu";
        }

        String scnp = cnpText.getText();
        String snumar = numarText.getText();

        try{
            if(scnp.equals("")){
                JOptionPane.showMessageDialog(null, "Trebuie sa vă introduceți CNP-ul!");
            }else {
                DbConnection c = new DbConnection();
                StringBuilder queryBuilder1 = new StringBuilder();
                queryBuilder1.append("Insert into signuptwo values (");
                queryBuilder1.append("'").append(formular).append("',");
                queryBuilder1.append("'").append(smostenitori).append("',");
                queryBuilder1.append("'").append(spersoana).append("',");
                queryBuilder1.append("'").append(svenit).append("',");
                queryBuilder1.append("'").append(seducatie).append("',");
                queryBuilder1.append("'").append(socupatie).append("',");
                queryBuilder1.append("'").append(scnp).append("',");
                queryBuilder1.append("'").append(snumar).append("',");
                queryBuilder1.append("'").append(smajor).append("',");
                queryBuilder1.append("'").append(scontExistent).append("')");

                c.s.executeUpdate(queryBuilder1.toString());

                this.setVisible(false);
                new SignUpThree(formular).setVisible(true);
            }
        }catch (Exception ex){
            System.out.println(ex);
        }


    }


    public static void main(String [] args){

        new SignUpTwo("");

    }
}
