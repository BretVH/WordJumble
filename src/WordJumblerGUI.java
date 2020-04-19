
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.util.*;

/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author 955203223
 */
public final class WordJumblerGUI extends JFrame
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    private JPanel buttonPanel;
    private JPanel comboBoxPanel;
    private JPanel labelPanel;
    private JButton getJumble;
    private JButton testAnswer;
    private JButton seeAnswer;
    private JTextArea niceContrast;
    private JMenuBar menu;
    private JMenu file;
    private JMenuItem loadDictionary;
    private File dictionary = new File("src/Jumble-en-US.dic");
    private String answer;
    private String jumbled;
    private ArrayList<String> answers;
    private ArrayList<String> jumbles;
    
     public static void main(String[] args)
    {
        JFrame GUI = new WordJumblerGUI();
        GUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        GUI.setVisible(true);
    }
     public WordJumblerGUI()
    {
        setTitle("Word Jumbler By: Bret A. Van Hof");
        setLayout(new BorderLayout());
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        createPanels();
        createButtons();
        add(buttonPanel, BorderLayout.SOUTH);
        add(comboBoxPanel, BorderLayout.CENTER);
        add(labelPanel, BorderLayout.NORTH);
        createMenu();
        setJMenuBar(menu);
    }   
    public void createPanels()
    {
        buttonPanel = new JPanel();
        comboBoxPanel = new JPanel();
        labelPanel = new JPanel();
        buttonPanel.setLayout(new BorderLayout());
        comboBoxPanel.setLayout(new FlowLayout());
        labelPanel.setLayout(new FlowLayout());
    }
    public void createButtons()
    {
       niceContrast = new JTextArea("");
       niceContrast.setBackground(Color.green);
       niceContrast.setColumns(FRAME_WIDTH);
       niceContrast.setEditable(false);
       niceContrast.setVisible(true);
       buttonPanel.add(niceContrast, BorderLayout.NORTH);
       seeAnswer = new JButton("See Answer");
       testAnswer = new JButton("Test Answer");
       getJumble = new JButton("Get Jumble");
       buttonPanel.add(getJumble, BorderLayout.WEST);
       buttonPanel.add(testAnswer, BorderLayout.CENTER);
       buttonPanel.add(seeAnswer, BorderLayout.EAST);
    }
    public void createMenu()
    {
        menu = new JMenuBar();
        file = new JMenu("File");
        loadDictionary = new JMenuItem("Load Dictionary");
        menu.add(file);
        file.add(loadDictionary);
        
        class MenuActionListener implements ActionListener 
        {
            @Override
            public void actionPerformed(ActionEvent event)
            {
                JFileChooser dictionaryChooser = new JFileChooser();
                if(dictionaryChooser.showOpenDialog(null) == 
                        JFileChooser.APPROVE_OPTION)
                {
                    dictionary = dictionaryChooser.getSelectedFile();
                }
            }
        }
        MenuActionListener listener = new MenuActionListener();
        loadDictionary.addActionListener(listener); 
    }
    public class getJumbleActionListener implements ActionListener
    {
        @Override
        public void actionPerformed(ActionEvent event)
        {
           generateAnswer();
           jumbles = jumbler.generateJumble();
           checkForOtherAnswers();
        }
    }
    public void generateAnswer()
    {
         try {
                Scanner in = new Scanner(dictionary);
                int i = 0;
                while(in.hasNextLine())
                {
                    i++;
                }
                int wordLine;
                java.util.Random randomChoice = new java.util.Random();
                wordLine = randomChoice.nextInt(++i);
                for(i = 0; i < --wordLine; i++)
                {
                    in.nextLine();
                }
                answer = in.nextLine();
            } 
            catch (FileNotFoundException ex) 
            {
                Logger.getLogger(WordJumblerGUI.class.getName()).log
                        (Level.SEVERE, null, ex);
            }
    }
    public ArrayList<String> generateJumble()
    {
        jumbles = new ArrayList<String>();
        if(answer.length() == 0)
        {
            return jumbles;
        }
        for (int i = 0; i < answer.length(); i++)
        {
            String smallAnswer = answer.substring(0, i)
                + answer.substring(i + 1);
            
        }
    }
    public void checkForOtherAnswers()
    {
        
    }
}

