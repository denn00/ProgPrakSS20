package ms1;
import javax.swing.*;
import javax.swing.event.*;
import java.awt.*;
import java.awt.event.*;

public class GUI implements ActionListener,ListSelectionListener,FocusListener {
    DefaultListModel<String> verlauf;
    JTextField input;
    JList<String> liste;
    JLabel status;

    public GUI() {
        JFrame frame = new JFrame("Rechner");
        Font fontmain = new Font("Serif", Font.BOLD, 15);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 400);
        frame.setFont(fontmain);

        Font fontlarge = new Font("Serif", Font.BOLD, 30);
        input = new JTextField();
        input.setFont(fontlarge);
        input.addActionListener(this);

        verlauf = new DefaultListModel<>();
        liste = new JList<>(verlauf);
        liste.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        liste.addListSelectionListener(this);
        liste.addFocusListener(this);
        JScrollPane sp = new JScrollPane();
        sp.setViewportView(liste);

        status = new JLabel("");

        frame.getContentPane().add(BorderLayout.NORTH, input);
        frame.getContentPane().add(BorderLayout.CENTER, sp);
        frame.getContentPane().add(BorderLayout.SOUTH, status);
        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new GUI();
    }

    public void actionPerformed(ActionEvent e) {
        String result = null;
        try {
            result=Postfix.eval(input.getText());
            } catch (Exception ex) {
            status.setText(ex.getMessage());
        }
        if (result != null) {
            verlauf.insertElementAt(input.getText(), 0);
            input.setText(result);
            input.setCaretPosition(0);
            status.setText("");
        }
    }
    public void valueChanged(ListSelectionEvent e) {
        if (!e.getValueIsAdjusting() && liste.getSelectedValue() != null) {
            input.setText(liste.getSelectedValue().toString());
        }
    }
    public void focusGained(FocusEvent e) {
        return;
    }
    public void focusLost(FocusEvent e) {
        liste.clearSelection();
    }
 }
