package com.company;

import com.company.net.CreateRequest;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class CalcFrame {
    private final String PATH = "D:\\Java\\NORMCALC\\Math.txt";
    private final String ZIPPATH = "D:\\Java\\NORMCALC\\ex-Math.zip";
    private final String EXPATH = "D:\\Java\\NORMCALC\\ex-Math.txt";
    private JTextField display;
    public JFrame mainCalcFrame;
    private String DOUBLESIGN = "Don`t try to enter double arithmetic sign!";

    private Cache cache = new Cache();

    int count = 0;

    public void createMainCalcFrame() {

        final String[] buttonsNames = {"CE", "C", "BACK", "/", "7", "8", "9", "*", "4", "5", "6", "-",
                "1", "2", "3", "+", "±", "0", ",", "="};

        mainCalcFrame = new JFrame("Calculator");
        mainCalcFrame.setSize(400, 400);
        mainCalcFrame.setLayout(new BorderLayout());
        mainCalcFrame.setResizable(false);

        display = new JTextField(15);
        display.setPreferredSize(new Dimension(50,50));
        display.setFont(new Font("Arial", Font.PLAIN, 30));

        mainCalcFrame.add(display, BorderLayout.PAGE_START);

        JPanel buttonsPanel = new JPanel(new GridLayout(5, 4));
        mainCalcFrame.add(buttonsPanel, BorderLayout.CENTER);

        JButton[] buttons = new JButton[buttonsNames.length];
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton(buttonsNames[i]);
        }
        String displayCurrent = "";
        display.setText(displayCurrent);

        for (int i = 0; i < buttons.length; i++) {

            buttons[i].setName(buttonsNames[i]);
            buttons[i].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    try {
                        buttonsActionPerformed(e.getActionCommand());
                    } catch (IOException e1) {
                        e1.printStackTrace();
                    }
                }
            });
            buttonsPanel.add(buttons[i]);
        }
        mainCalcFrame.setVisible(true);
    }

    void buttonsActionPerformed(String actionCommand) throws IOException {
        switch (actionCommand) {
            case "0":
                if (count > 0) {
                    display.setText(display.getText() + "0");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "0");
                    break;
                }
            case "1":
                if (count > 0) {
                    display.setText(display.getText() + "1");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "1");
                    break;
                }
            case "2":
                if (count > 0) {
                    display.setText(display.getText() + "2");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "2");
                    break;
                }
            case "3":
                if (count > 0) {
                    display.setText(display.getText() + "3");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "3");
                    break;
                }
            case "4":
                if (count > 0) {
                    display.setText(display.getText() + "4");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "4");
                    break;
                }
            case "5":
                if (count > 0) {
                    display.setText(display.getText() + "5");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "5");
                    break;
                }
            case "6":
                if (count > 0) {
                    display.setText(display.getText() + "6");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "6");
                    break;
                }
            case "7":
                if (count > 0) {
                    display.setText(display.getText() + "7");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "7");
                    break;
                }
            case "8":
                if (count > 0) {
                    display.setText(display.getText() + "8");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "8");
                    break;
                }
            case "9":
                if (count > 0) {
                    display.setText(display.getText() + "9");
                    count = 0;
                    break;
                } else {
                    display.setText(display.getText() + "9");
                    break;
                }
            case "+":
                if (count == 0) {
                    display.setText(display.getText() + " + ");
                    count++;
                    System.out.println(count);
                } else {
                    JOptionPane.showMessageDialog(mainCalcFrame, DOUBLESIGN, "Error",
                            JOptionPane.DEFAULT_OPTION);
                }
                break;
            case "-":
                if (count == 0) {
                    display.setText(display.getText() + " - ");
                    count++;
                    System.out.println(count);
                } else {
                    JOptionPane.showMessageDialog(mainCalcFrame, DOUBLESIGN, "Error",
                            JOptionPane.DEFAULT_OPTION);
                }
                break;
            case "*":
                if (count == 0) {
                    display.setText(display.getText() + " * ");
                    count++;
                    System.out.println(count);
                } else {
                    JOptionPane.showMessageDialog(mainCalcFrame, DOUBLESIGN, "Error",
                            JOptionPane.DEFAULT_OPTION);
                }
                break;
            case "/":
                if (count == 0) {
                    display.setText(display.getText() + " / ");
                    count++;
                    System.out.println(count);
                } else {
                    JOptionPane.showMessageDialog(mainCalcFrame, DOUBLESIGN, "Error",
                            JOptionPane.DEFAULT_OPTION);
                }
                break;
            case "=":
                if(count == 0){
                    String numbers = display.getText();
                    Parser parser = new Parser();
                    String response = CreateRequest.getRequest(parser.calcString(numbers));

                    if(cache.checkNumber(numbers))
                        numbers = cache.getNumber(numbers);
                    else cache.addNumber(numbers, response);

                    display.setText(response);

                    try {
                        Writer.write("Math.txt", numbers + " = " + response + "\n");
                    } catch (IOException e) {
                        e.printStackTrace();
                    }

                    Thread myThread = new Thread(new Runnable() {
                        @Override
                        public void run() {
                            try {
                                Archive.fullLog(EXPATH,PATH,ZIPPATH);
                                System.out.println("Hello from thread!");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    });

                    myThread.start();

                    break;
            }
                if(count > 0) {
                    display.setText("");
                }
                break;
            case "C":
                display.setText("");
                break;
            case "BACK":
                String temp = display.getText();
                display.setText(temp.substring(0, temp.length() - 1));
                break;
            case "CE":
                display.setText("");
                break;
            case "±":
                if (count == 0) {
                    display.setText("-" + display.getText());
                    count++;
                    } else {
                            JOptionPane.showMessageDialog(mainCalcFrame, "Don`t tap it two times or more!", "Error",
                            JOptionPane.DEFAULT_OPTION);
                }
                break;
            case ",":
                if (!display.getText().equals("") && display.getText().indexOf(".") == -1) {
                    display.setText(display.getText() + ".");
                    count++;
                }
                break;
        }
    }
}
