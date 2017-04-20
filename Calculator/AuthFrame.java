package com.company;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.security.NoSuchAlgorithmException;

public class AuthFrame {

    public JFrame mainAuthFrame;
    private final String AUTHSUCCESS = "Hello, my friend, again";
    private final String AUTHFAILED = "Login or password wrong!";
    private final String REGSUCCESS = "Registration success!";


    public void createAuthFrame()
    {
        mainAuthFrame = new JFrame();
        mainAuthFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainAuthFrame.setLocationRelativeTo(null);
        mainAuthFrame.setSize(250, 150);
        mainAuthFrame.setResizable(false);
        mainAuthFrame.setLayout(new FlowLayout());

        JLabel loginLabel = new JLabel("Login :        ");
        JLabel passwordLabel = new JLabel("Password :");

        JTextField loginTextField = new JTextField(10);
        JPasswordField passwordField = new JPasswordField(10);

        JButton login = new JButton("Enter");

        JPanel logins = new JPanel(new FlowLayout());

        logins.add(loginLabel);
        logins.add(loginTextField);

        JPanel passwords = new JPanel(new FlowLayout());

        passwords.add(passwordLabel);
        passwords.add(passwordField);

        JPanel buttons = new JPanel(new FlowLayout());

        buttons.add(login);

        login.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Authentication auth = new Authentication(loginTextField.getText().toString(), passwordField.getText().toString());
                try {
                    CalcFrame cFrame = new CalcFrame();
                    switch (auth.authChecker()) {
                        case 0:
                            JOptionPane.showMessageDialog(mainAuthFrame, REGSUCCESS, "Успешная Регистрация",
                                    JOptionPane.DEFAULT_OPTION);
                            auth.registrationOfNewUser();
                            mainAuthFrame.setVisible(false);
                            cFrame.createMainCalcFrame();
                            break;
                        case 1:
                            JOptionPane.showMessageDialog(mainAuthFrame, AUTHSUCCESS, "Успешная Авторизация",
                                    JOptionPane.DEFAULT_OPTION);
                            cFrame.createMainCalcFrame();
                            mainAuthFrame.setVisible(false);
                            break;
                        case -1:
                            JOptionPane.showMessageDialog(mainAuthFrame, AUTHFAILED, "Неудачная Авторизация",
                                    JOptionPane.DEFAULT_OPTION);
                            loginTextField.setText("");
                            passwordField.setText("");
                            break;
                    }
            } catch (NoSuchAlgorithmException e1) {
                    e1.printStackTrace();
                } catch (IOException e1) {
                    e1.printStackTrace();
                }
            }
        });

        mainAuthFrame.add(logins);
        mainAuthFrame.add(passwords);
        mainAuthFrame.add(buttons);
        mainAuthFrame.setVisible(true);
    }
}
