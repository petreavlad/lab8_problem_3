package app;

import javax.swing.*;
import java.awt.*;
import java.util.*;
import java.util.List;

public class App {

    private static JFrame jframe;


    private JPanel mPanel;
    private JTextField textField1;
    private JTextField textField2;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JComboBox comboBox3;
    private JLabel mSignUp;
    private JButton enterDataButton;
    private JLabel mSignUpText;


    private App(){
        populateYearComboBox();
        populateFaculty();
        populateFinancing();
        enterDataButton.addActionListener(e -> {
            JPanel pannel=new JPanel();
            pannel.setLayout(new GridLayout());
            jframe.setContentPane(pannel);
            JLabel label=new JLabel(getAllInfo());
            label.setHorizontalAlignment(SwingConstants.CENTER);
            label.setFocusable(false);
            pannel.add(label);
            jframe.pack();
        });
    }

    public static void main(String[] args){
        jframe=new JFrame();
        jframe.setContentPane(new App().mPanel);
        jframe.setPreferredSize(new Dimension(300,350));
        jframe.pack();
        jframe.setVisible(true);

    }

    private String getAllInfo(){
        return "<html>" +"Name:"+textField1.getText()+"\n<br>Surname:"+textField2.getText()+
                "\n<br>Year:"+comboBox1.getSelectedItem()+
                "\n<br>Faculty:"+comboBox2.getSelectedItem()+
                "\n<br>Financing:"+comboBox3.getSelectedItem()+
                "</html>";
    }

    private void populateYearComboBox(){
        List list=new ArrayList<Integer>();

        for(int i=2000;i<2019;i++){
            list.add(i);
        }

        comboBox1.setModel(new DefaultComboBoxModel(list.toArray()));
    }

    private void populateFaculty(){
        List list=new ArrayList<String>();
        list.add("Calculatoare");
        list.add("Telecomunicatii");
        list.add("Automatica");

        comboBox2.setModel(new DefaultComboBoxModel(list.toArray()));
    }

    private void populateFinancing(){
        List list=new ArrayList<String>();
        list.add("Taxa");
        list.add("Buget");

        comboBox3.setModel(new DefaultComboBoxModel(list.toArray()));
    }
}
