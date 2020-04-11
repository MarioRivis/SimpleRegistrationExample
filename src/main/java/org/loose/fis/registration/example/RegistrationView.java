package org.loose.fis.registration.example;

import org.loose.fis.registration.example.controllers.RegistrationController;
import org.loose.fis.registration.example.services.UserService;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegistrationView extends JFrame {
	private JButton btnRegister;
	private JTextField txtUsername;
	private JPasswordField txtPassword;
	private JComboBox<String> cmbRole;
	private RegistrationController controller;
	
	public RegistrationView() {
		controller = new RegistrationController(this);
		
		setTitle("MyApp: Registration");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(300, 200);
        
        Container contentPane = this.getContentPane();
        contentPane.setLayout(null);
    	
		JLabel lblUsername = new JLabel("Username:");
        lblUsername.setBounds(10, 10, 120, 25);
        contentPane.add(lblUsername);
        
        txtUsername = new JTextField();
        txtUsername.setBounds(80, 10, 100, 25);
        contentPane.add(txtUsername);
        
        JLabel lblPassword = new JLabel("Password:");
        lblPassword.setBounds(10, 40, 120, 25);
        contentPane.add(lblPassword);
        
        txtPassword = new JPasswordField();
        txtPassword.setBounds(80, 40, 100, 25);
        contentPane.add(txtPassword);
        
        JLabel lblRole = new JLabel("Role:");
        lblRole.setBounds(10, 70, 120, 25);
        contentPane.add(lblRole);
        
        String[] roles = { "Client", "Admin"};
        cmbRole = new JComboBox<>(roles);
        cmbRole.setBounds(45, 70, 110, 25);
        contentPane.add(cmbRole);
		
		btnRegister = new JButton("Register");
		btnRegister.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                if (controller.checkAvailability(txtUsername.getText(), new String(txtPassword.getPassword()), String.valueOf(cmbRole.getSelectedItem()))) {
                    JOptionPane.showMessageDialog(null, "User successfully added", "Adding user", JOptionPane.INFORMATION_MESSAGE);
                } else {
                    JOptionPane.showMessageDialog(null, "User alreay added", "Adding user", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
		btnRegister.setBounds(175, 110, 100, 40);
		
		contentPane.add(btnRegister);
	}
	
	public static void main(String[] args) throws Exception {
		UserService.loadUsersFromFile();
		
		RegistrationView view = new RegistrationView();
        view.setVisible(true);
	}
}
