import javax.swing.*;
import java.awt.*;

public class RegistrationForm extends JFrame {

    JTextField nameField, mobileField;
    JRadioButton maleButton, femaleButton;
    JComboBox<String> dateBox, monthBox, yearBox;
    JTextArea addressArea, outputArea;
    JCheckBox termsBox;
    JButton submitButton, resetButton;
    JLabel messageLabel;

    public RegistrationForm() {
        setTitle("Registration Form");
        setSize(850, 500); // Increased height to fit message
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(null);

        //Set Title as "Registration Form"
        JLabel formTitle = new JLabel("Registration Form");
        formTitle.setFont(new Font("Arial", Font.BOLD, 24));
        formTitle.setBounds(300, 0, 300, 40);
        add(formTitle);

        // Labels for elements
        JLabel nameLabel = new JLabel("Name");
        JLabel mobileLabel = new JLabel("Mobile");
        JLabel genderLabel = new JLabel("Gender");
        JLabel dobLabel = new JLabel("DOB");
        JLabel addressLabel = new JLabel("Address");

        nameLabel.setBounds(30, 50, 100, 30);
        mobileLabel.setBounds(30, 90, 100, 30);
        genderLabel.setBounds(30, 130, 100, 30);
        dobLabel.setBounds(30, 170, 100, 30);
        addressLabel.setBounds(30, 210, 100, 30);

        // Set Fields
        nameField = new JTextField();
        nameField.setBounds(130, 50, 200, 30);

        mobileField = new JTextField();
        mobileField.setBounds(130, 90, 200, 30);

        maleButton = new JRadioButton("Male");
        femaleButton = new JRadioButton("Female");
        maleButton.setBounds(130, 130, 70, 30);
        femaleButton.setBounds(200, 130, 100, 30);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(maleButton);
        genderGroup.add(femaleButton);

        String[] days = new String[31];
        for (int i = 1; i <= 31; i++) days[i - 1] = String.valueOf(i);
        dateBox = new JComboBox<>(days);
        dateBox.setBounds(130, 170, 60, 30);

        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        monthBox = new JComboBox<>(months);
        monthBox.setBounds(200, 170, 80, 30);

        String[] years = new String[50];
        for (int i = 1975; i <= 2024; i++) years[i - 1975] = String.valueOf(i);
        yearBox = new JComboBox<>(years);
        yearBox.setBounds(290, 170, 80, 30);

        addressArea = new JTextArea();
        addressArea.setBounds(130, 210, 240, 60);

        termsBox = new JCheckBox("Accept Terms And Conditions.");
        termsBox.setBounds(130, 280, 250, 30);

        submitButton = new JButton("Submit");
        resetButton = new JButton("Reset");

        submitButton.setBounds(130, 320, 100, 30);
        resetButton.setBounds(250, 320, 100, 30);

        // Error message Label
        messageLabel = new JLabel("");
        messageLabel.setBounds(130, 360, 400, 30);
        messageLabel.setForeground(Color.BLACK);
        messageLabel.setFont(new Font("Arial", Font.BOLD, 14));

        // Output Text area
        outputArea = new JTextArea();
        outputArea.setEditable(false);
        outputArea.setBackground(Color.WHITE);
        JScrollPane scrollPane = new JScrollPane(outputArea);
        scrollPane.setBounds(420, 50, 380, 340);
        scrollPane.setBorder(BorderFactory.createLineBorder(Color.GRAY));

        // Components
        add(nameLabel);
        add(mobileLabel);
        add(genderLabel);
        add(dobLabel);
        add(addressLabel);
        add(nameField);
        add(mobileField);
        add(maleButton);
        add(femaleButton);
        add(dateBox);
        add(monthBox);
        add(yearBox);
        add(addressArea);
        add(termsBox);
        add(submitButton);
        add(resetButton);
        add(messageLabel);
        add(scrollPane);

        // Button actions
        submitButton.addActionListener(e -> {
            if (!termsBox.isSelected()) {
                messageLabel.setText("Please accept the terms and conditions.");
            } else {
                messageLabel.setText(""); // Clear message if accepted

                //Data To output area
                String name = nameField.getText();
                String mobile = mobileField.getText();
                String gender = maleButton.isSelected() ? "Male" : femaleButton.isSelected() ? "Female" : "Not specified";
                String dob = dateBox.getSelectedItem() + " " + monthBox.getSelectedItem() + " " + yearBox.getSelectedItem();
                String address = addressArea.getText();

                //Output on Right text area
                String output = "----- Registered Information -----\n"
                        + "Name: " + name + "\n"
                        + "Mobile: " + mobile + "\n"
                        + "Gender: " + gender + "\n"
                        + "DOB: " + dob + "\n"
                        + "Address: " + address + "\n";

                outputArea.setText(output);
            }
        });

        //Reset button
        resetButton.addActionListener(e -> {
            nameField.setText("");
            mobileField.setText("");
            genderGroup.clearSelection();
            dateBox.setSelectedIndex(0);
            monthBox.setSelectedIndex(0);
            yearBox.setSelectedIndex(0);
            addressArea.setText("");
            termsBox.setSelected(false);
            outputArea.setText("");
            messageLabel.setText("");
        });
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new RegistrationForm().setVisible(true));
    }
}
