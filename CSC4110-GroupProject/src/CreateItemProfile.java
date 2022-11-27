import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class CreateItemProfile {
    private JButton Create;
    private JPanel MainPanel;
    private JTextField setItemName;
    private JTextField textField3;
    private JTextField textField4;
    private JTextField textField2;
    private JTextField textField5;
    private JComboBox comboBox1;
    private JComboBox comboBox2;
    private JButton cancelButton;

    public CreateItemProfile() {
        Create.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Item create successfully!");
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null,"Item create successfully!");
            }
        });
    }

    public class myFrame extends Frame{

    }

    public static void main(String[] args) {
        itemProfileFactory itemFactory = new itemProfileFactory();
        JFrame myFrame = new JFrame("Create Item Profile");
        myFrame.setContentPane(new CreateItemProfile().MainPanel);
        myFrame.setMinimumSize(new Dimension(550,400));
        myFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        myFrame.pack();
        myFrame.setVisible(true);

    }
}
