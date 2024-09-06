import java.awt.*;
import javax.swing.*;
import java.awt.event.*;


public class ReturnBook extends JFrame {
    static ReturnBook frame;
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
}

public class ReturnBook extends JFrame {
    private JPanel contentPane;
    private JTextField textField;
    private JTextField textField_1;
    private static ReturnBook frame;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    frame = new ReturnBook();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public ReturnBook() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 516, 413);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblReturnBook = new JLabel("Return Book");
        lblReturnBook.setForeground(Color.GRAY);
        lblReturnBook.setFont(new Font("Tahoma", Font.PLAIN, 18));
        lblReturnBook.setBounds(200, 11, 116, 22);
        contentPane.add(lblReturnBook);

        JLabel lblBookCallno = new JLabel("Book Callno:");
        lblBookCallno.setBounds(64, 75, 86, 14);
        contentPane.add(lblBookCallno);

        JLabel lblStudentId = new JLabel("Student Id:");
        lblStudentId.setBounds(64, 123, 86, 14);
        contentPane.add(lblStudentId);

        textField = new JTextField();
        textField.setBounds(160, 72, 208, 20);
        contentPane.add(textField);
        textField.setColumns(10);

        textField_1 = new JTextField();
        textField_1.setBounds(160, 120, 208, 20);
        contentPane.add(textField_1);
        textField_1.setColumns(10);

        JButton btnReturnBook = new JButton("Return Book");
        btnReturnBook.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String bookcallno = textField.getText();
                int studentid = Integer.parseInt(textField_1.getText());
                int i = ReturnBookDao.delete(bookcallno, studentid);
                if (i > 0) {
                    JOptionPane.showMessageDialog(ReturnBook.this, "Book returned successfully!");
                    LibrarianSuccess.main(new String[]{});
                    frame.dispose();
                } else {
                    JOptionPane.showMessageDialog(ReturnBook.this, "Sorry, unable to return book!");
                }
            }
        });
        btnReturnBook.setBounds(160, 160, 115, 23);
        contentPane.add(btnReturnBook);

        JLabel lblNewLabel = new JLabel("Note: Check the book properly!");
        lblNewLabel.setForeground(Color.RED);
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 13));
        lblNewLabel.setBounds(160, 200, 200, 14);
        contentPane.add(lblNewLabel);

        JButton btnBack = new JButton("Back");
        btnBack.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                LibrarianSuccess.main(new String[]{});
                frame.dispose();
            }
        });
        btnBack.setBounds(160, 240, 115, 23);
        contentPane.add(btnBack);
    }
}
