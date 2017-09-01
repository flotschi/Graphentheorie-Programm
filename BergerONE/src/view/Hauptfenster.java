package view;

import model.Algo.AlgoImpl;
import model.matrices.Matrices;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Arrays;

/**
 * Created by Neo on 4.02.2017.
 */
public class Hauptfenster extends JFrame
{

    private JMenuBar menuBar;

    private JMenu file;
    private JMenuItem exit;

    ////////////
    private JLabel lbl;
    private JLabel lbl_1;
    private JLabel lbl_2;
    private JLabel lbl_3;
    private JLabel lbl_4;

    //KnotenMenu
    private JMenuItem knoten;
    private JMenuItem knoten3, knoten4, knoten5, knoten6, knoten7, knoten8, knoten9, knoten10, knoten11,
                      knoten12, knoten13, knoten14, knoten15, knoten100;

    //Buttons
    private JPanel btn_Panel;
    private JPanel btn_PanelPath;
    private AdjaButton[][] buttons;
    private PathButton[][] buttons1;
    private PathButton[][] buttons2;

    //ausgabe des Graphen
    private JEditorPane result;


    private JEditorPane pane;
    private JEditorPane pane1;
    private JEditorPane pane2;
   // private JEditorPane paneMatrix;

    private JEditorPane panePath;
    private JEditorPane paneDistance;

    private JPanel panel;
    private JPanel pnlMatrix;

    private JPanel pathAndDistance;
    private JPanel pnl_Path;
    private JPanel pnl_Distance;

    //Model / Algorithmus
    private static final int KnotenBegins = 4;
    private Matrices adja;

    private Matrices path;

    private AlgoImpl algo;
    private AlgoImpl resulto;



    public Hauptfenster()
    {
        initFenster();
        initComponents();
        addComponents();
        addListeners();
        initModel(KnotenBegins);
        generatePane(KnotenBegins);
        setVisible(true);
    }

    private void initModel(int knoten)
    {
        try
        {
            adja = new Matrices(knoten);
            path = new Matrices(knoten);
            algo = new AlgoImpl();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    private void  initFenster()
    {
        setTitle("The-Program");
        setSize(1200, 850);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLayout(new BorderLayout());
    }


    private void initComponents()
    {
        menuBar = new JMenuBar();
        file = new JMenu("File");
        lbl_4 = new JLabel("       ");
        exit = new JMenuItem("Beenden");

        lbl = new JLabel("        ");
        lbl_1 = new JLabel("4");
        lbl_2 = new JLabel(" ausgewählte Knoten");
        lbl_3 = new JLabel("                      ~  =  -1  in Distancematrix -> it means infinite");
        lbl_3.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 16));

        //KnotenMenu
        knoten = new JMenu("Knoten");
        knoten3 = new JMenuItem("3 Knoten");
        knoten4 = new JMenuItem("4 Knoten");
        knoten5 = new JMenuItem("5 Knoten");
        knoten6 = new JMenuItem("6 Knoten");
        knoten7 = new JMenuItem("7 Knoten");
        knoten8 = new JMenuItem("8 Knoten");
        knoten9 = new JMenuItem("9 Knoten");
        knoten10 = new JMenuItem("10 Knoten");
        knoten11 = new JMenuItem("11 Knoten");
        knoten12 = new JMenuItem("12 Knoten");
        knoten13 = new JMenuItem("13 Knoten");
        knoten14 = new JMenuItem("14 Knoten");
        knoten15 = new JMenuItem("15 Knoten");
        knoten100 = new JMenuItem("100 Knoten");

        //Button
        btn_Panel = new JPanel();
        btn_PanelPath = new JPanel();

        //Output
       result = new JEditorPane();
       result.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
       result.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 13));

       panel = new JPanel();

       pathAndDistance = new JPanel();

       pnl_Path = new JPanel();

       pnl_Distance = new JPanel();


       pnlMatrix = new JPanel();
//       paneMatrix = new JEditorPane();
//       paneMatrix.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
//       paneMatrix.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 13));

       pane = new JEditorPane();

       pane1 = new JEditorPane();
       pane1.putClientProperty(JEditorPane.W3C_LENGTH_UNITS, Boolean.TRUE);
       pane1.setFont(new Font("Segoe UI", Font.LAYOUT_RIGHT_TO_LEFT, 13));

       pane2 = new JEditorPane();
       pane2.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
       pane2.setFont(new Font("Segoe UI", Font.LAYOUT_RIGHT_TO_LEFT, 13));

       panePath = new JEditorPane();
       panePath.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
       panePath.setFont(new Font("Segoe UI", Font.LAYOUT_RIGHT_TO_LEFT, 13));
       panePath.setForeground(Color.red);


       paneDistance = new JEditorPane();
       paneDistance.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
       paneDistance.setFont(new Font("Segoe UI", Font.LAYOUT_RIGHT_TO_LEFT, 13));
       paneDistance.setForeground(Color.blue);

    }



    private void addComponents()
    {
        setJMenuBar(menuBar);
        menuBar.add(file);
        menuBar.add(lbl_4);
        file.add(exit);

        menuBar.add(knoten);

        menuBar.add(lbl);
        menuBar.add(lbl_1);
        menuBar.add(lbl_2);
        menuBar.add(lbl_3);

        knoten.add(knoten3);
        knoten.add(knoten4);
        knoten.add(knoten5);
        knoten.add(knoten6);
        knoten.add(knoten7);
        knoten.add(knoten8);
        knoten.add(knoten9);
        knoten.add(knoten10);
        knoten.add(knoten11);
        knoten.add(knoten12);
        knoten.add(knoten13);
        knoten.add(knoten14);
        knoten.add(knoten15);
        knoten.add(knoten100);

        //Output
       // add(scroll, BorderLayout.EAST);

//        panel.add(pane);
//        panel.add(pane1);
//        panel.add(pane2);
//        add(panel, BorderLayout.SOUTH);

    }

    private void addListeners()
    {
        exit.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {System.exit(0);}});

        knoten3.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(3); } });
        knoten4.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(4); } });
        knoten5.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(5); } });
        knoten6.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(6); } });
        knoten7.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(7); } });
        knoten8.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(8); } });
        knoten9.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(9); } });
        knoten10.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(10); } });
        knoten11.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(11); } });
        knoten12.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(12); } });
        knoten13.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(13); } });
        knoten14.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(14); } });
        knoten15.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(15); } });
        knoten100.addActionListener(new ActionListener() { public void actionPerformed(ActionEvent e) {handleKnoten(100); } });
    }

    private void handleKnoten(int knoten)
    {
        initModel(knoten);

        // init Gui
        generatePane(knoten);
        result.setText("");
        pane.setText("");
        pane1.setText("");
        pane2.setText("");

        anzKnoten(knoten);
    }

    private String anzKnoten(int knoten)
    {
        String anzahl = "";
        anzahl = String.valueOf(knoten);

        lbl_1.setText(""+anzahl);
        return anzahl;
    }

    class PathButton extends JButton
    {
        int row, col;

        public PathButton(String text, int row, int col)
        {
            super(text);
            this.row = row;
            this.col = col;
        }
    }


    private void generatePane(int anz)
    {
      //  System.out.println(anz);

            // 1. löschen der alten Pane
            remove(btn_Panel);
            remove(panel);
            remove(pnlMatrix);
            remove(btn_PanelPath);
            remove(pathAndDistance);

        // 2. neue Pane instantieren
        btn_Panel = new JPanel(new GridLayout(anz, anz));

        pathAndDistance = new JPanel(new GridLayout(2,1));
        pathAndDistance.setPreferredSize(new Dimension(360,550));

     //////////////////////////////////////////////
        pnl_Path = new JPanel(new BorderLayout());
        pnl_Distance = new JPanel(new BorderLayout());


        btn_PanelPath = new JPanel(new GridLayout(anz, anz));
      //  btn_PanelPath.setPreferredSize(new Dimension(500, 500));


        pnlMatrix = new JPanel(new GridLayout(anz, anz));
     //   pnlMatrix.setPreferredSize(new Dimension(500, 550));

        buttons1 = new PathButton[anz][anz];
        buttons2 = new PathButton[anz][anz];


        buttons = new AdjaButton[anz][anz];
        panel = new JPanel(new GridLayout(1,3));

        // 3. add Buttons
        for (int row = 0; row < anz ; row++)
        {
            for (int col = 0; col < anz ; col++)
            {
                AdjaButton button = new AdjaButton("0", row, col);
                buttons[row][col] = button;
                PathButton button1 = new PathButton("", row, col);
                PathButton button2 = new PathButton("", row, col);
                buttons1[row][col] = button1;
                buttons2[row][col] = button2;
               // button1.setEnabled(false);
             //   pathAndDistance.add(btn_PanelPath);
             //   pathAndDistance.add(pnlMatrix);
                pathAndDistance.add(pnl_Path);
                pathAndDistance.add(pnl_Distance);
                pnl_Path.add(btn_PanelPath, BorderLayout.CENTER);
                pnl_Path.add(panePath, BorderLayout.NORTH);
                panePath.setText("      Path");
                pnl_Distance.add(pnlMatrix, BorderLayout.CENTER);
                pnl_Distance.add(paneDistance, BorderLayout.NORTH);
                paneDistance.setText("      Distance");

                if(row == col)
                {
                    button.setText("");
                    button.setBackground(Color.black);
                }
                button.setMargin(new java.awt.Insets(1, 2, 1, 2));
                button1.setMargin(new java.awt.Insets(1, 2, 1, 2));
                button2.setMargin(new java.awt.Insets(1, 2, 1, 2));
                btn_Panel.add(button);
                btn_PanelPath.add(button1);
                pnlMatrix.add(button2);
                panel.add(pane);
                panel.add(pane1);
                panel.add(pane2);
             //   pathAndDistance
            //    pnlMatrix.add(result);
            //    pnlMatrix.add(paneMatrix);
            }
        }


        // 4. add Pane to BorderLayout
        add(pathAndDistance,BorderLayout.EAST);
        add(btn_Panel, BorderLayout.CENTER);
        add(panel, BorderLayout.SOUTH);
        panel.setPreferredSize(new Dimension(300,260));
    //    add(pnlMatrix, BorderLayout.EAST);
    //    pnlMatrix.setPreferredSize(new Dimension(500, 550));
        //pnlMatrix.setSize(new Dimension(600,550));

    //    add(btn_PanelPath, BorderLayout.WEST);

        revalidate();
    }


    class AdjaButton extends JButton
    {
        int row, col;

        public AdjaButton(String text, int row, int col)
        {
            super(text);
            this.row = row;
            this.col = col;

            if (row != col)
            {
                addActionListener(new ActionListener()
                {
                    @Override
                    public void actionPerformed(ActionEvent e)
                    {
                        int value = 0;
                        buttons[row][col].setBackground(null);
                        buttons[col][row].setBackground(null);
                        if (getText().equals("0"))
                        {
                            value = 1;
                            buttons[row][col].setBackground(Color.cyan);
                            buttons[col][row].setBackground(Color.cyan);
                        }

                        //GUI updaten
                        setText("" + value);
                        buttons[col][row].setText("" + value);
                    //    buttons[row][col].setMargin(new java.awt.Insets(1, 2, 1, 2));

                        //model updaten
                        adja.setValue(row, col, value);
                        path.setValue(row, col, value);

                        //run the algorithm
                        resulto = new AlgoImpl();
                        algo.calcDistancePath(adja, resulto);
                        for (int row = 0; row < adja.nodes ; row++)
                        {
                            for (int col = 0; col < adja.nodes; col++)
                            {
                                if(row==col)
                                {
                                //    buttons1[row][col].setText("1");
                                //    buttons1[row][col].setMargin(new java.awt.Insets(1, 2, 1, 2));
                                 //   buttons1[row][col].setBorderPainted(false);
                                 //   buttons1[row][col].setEnabled(false);

                                    buttons1[row][col].setBackground(Color.orange);
                                 //   buttons2[row][col].setText("0");
                                    buttons2[row][col].setBackground(Color.orange);
                                //    buttons2[row][col].setMargin(new java.awt.Insets(1, 2, 1, 2));
                                }
                                else
                                {
                                 //   buttons1[row][col].setText("" + resulto.getPath().getValue(row, col));
                                    buttons1[row][col].setBackground(Color.pink);

                                   // buttons2[row][col].setText("" + resulto.getDistance().getValue(row, col));
                                 //   if(buttons2[row][col].getText().equals("-1"))
                                 //   {
                                 //       buttons2[row][col].setText("~");
                                 //   }
                                    buttons2[row][col].setBackground(Color.lightGray);
                                //    buttons2[row][col].setMargin(new java.awt.Insets(1, 2, 1, 2));
                                }
                                buttons1[row][col].setText("" + resulto.getPath().getValue(row, col));
                                buttons2[row][col].setText("" + resulto.getDistance().getValue(row, col));
                                if(buttons2[row][col].getText().equals("-1"))
                                {
                                    buttons2[row][col].setText("~");
                                }
                            }
                        }
                     //   generatePathMatrix();
                        algo.calcComponents(resulto.getPath(), resulto); //als 1. calcComponents vor Excentricity
                        algo.calcEccentricity(resulto.getDistance(), resulto.getNumComponents(), resulto);
                        algo.calcRadius(resulto.getEccentricity(), resulto.getNumComponents(), resulto);
                        algo.calcDiameter(resulto.getEccentricity(), resulto.getNumComponents(), resulto);
                        algo.calcCenter(resulto.getEccentricity(), resulto.getRadius(), resulto.getNumComponents(), resulto);
                        //    algo.calcComponents(resulto.getPath(), resulto);
                        algo.calcBridges(adja, resulto.getComponents().size(), resulto);
                        algo.calcArticulations(adja, resulto.getNumComponents(), resulto);

                        //ausgabe am schirm
                      //  result.setText(stringifyResult(resulto));
                        if(resulto.getNumComponents()>10)
                        {
                            pane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
                            pane.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 12));
                            if(resulto.getNumComponents()>13)
                            {
                                pane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
                                pane.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 11));
                                if(resulto.getNumComponents()>14)
                                {
                                    pane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
                                    pane.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 10));
                                }
                            }
                        }
                        else
                        {
                            pane.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
                            pane.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 13));
                        }
                        pane.setText(printResult1(resulto));
                        pane1.setText(printResult2(resulto));
                        pane2.setText(printResult3(resulto));
//                        if(lbl_1.getText().equals("15")|| lbl_1.getText().equals("14"))
//                        {
//                            paneMatrix.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
//                            paneMatrix.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 10));
//                            result.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
//                            result.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 10));
//                        }
//                        else if(lbl_1.getText().equals("13")|| lbl_1.getText().equals("12")|| lbl_1.getText().equals("11"))
//                        {
//                            paneMatrix.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
//                            paneMatrix.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 12));
//                            result.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
//                            result.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 12));
//                        }
//                        else
//                        {
//                            paneMatrix.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
//                            paneMatrix.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 15));
//                            result.putClientProperty(JEditorPane.HONOR_DISPLAY_PROPERTIES, Boolean.TRUE);
//                            result.setFont(new Font("Segoe UI", Font.CENTER_BASELINE, 15));
//                        }
//                        paneMatrix.setText(printResult(resulto));
                    }
                });
            }
        }

//        private String stringifyResult(AlgoImpl resulto)
//        {
//            StringBuilder sb = new StringBuilder(1000);
//            sb.append("Path Matrix\n");
//            sb.append(resulto.getPath().toString().replace("0"," 0").replace("1"," 1"));
//            sb.append("\n\n");
//            return sb.toString();
//        }

//        private String printResult(AlgoImpl resulto)
//        {
//            StringBuilder sb = new StringBuilder(1000);
//            sb.append("DistanceMatrix\n");
//            sb.append(resulto.getDistance().toString().replace("0", " 0").replace("1"," 1").replace("2"," 2").replace("3"," 3")
//                    .replace("4", " 4").replace("5", " 5").replace("6", " 6").replace("7", " 7").replace("8", " 8").replace("9", " 9")
//                    .replace(" 1 0","10").replace(" 1 1", "11").replace(" 1 2","12").replace(" 1 3", "13")
//                    .replace(" 1 4","14").replace("- 1", "  #"));
//            sb.append("\n\n");
//            return sb.toString();
//        }

        private String printResult1(AlgoImpl resulto)
        {
            StringBuilder sb = new StringBuilder(1000);

           // sb.append("\n\n");
            sb.append("Components\n");
            sb.append(printo1(resulto.getComponents()).replace("]","]\n").replace(", 0","").replace("[0, ","["));
            if(resulto.getNumComponents() <= 11)
            {
                sb.append("\n");
            }
            sb.append("NumberOfComponents\n");
            sb.append(resulto.getNumComponents());
            sb.append("\n\n");
            return sb.toString();
        }

        private String printResult2(AlgoImpl resulto)
        {
            StringBuilder sb = new StringBuilder(1000);
            sb.append("Articulations\n");
            if(resulto.getNumArticulations() == 0)
            {
                sb.append("!!No Articulations!!");
            }
            else
            {
                sb.append(resulto.getArticulations());
            }
            sb.append("\n\n");
            sb.append("NumberOfArticulations\n");
            sb.append(resulto.getNumArticulations());
            sb.append("\n\n");
            sb.append("Center\n");
            if(resulto.getNumCenter() == 0)
            {
                sb.append("!!No Center!!");
            }
            else
            {
                sb.append(resulto.getCenter());
            }
            sb.append("\n\n");
            sb.append("Eccentricity\n");
            if(resulto.getNumComponents()==1)
            {
                sb.append(Arrays.toString(resulto.getEccentricity()));
            }
            else
            {
                sb.append("!!Infinite Eccentricity!!");
            }
            sb.append("\n\n");

            return sb.toString();
        }


        private String printResult3(AlgoImpl resulto)
        {
            StringBuilder sb = new StringBuilder(1000);
            sb.append("Bridges\n");
            if(resulto.getNumBridges() == 0)
            {
                sb.append("!!No Bridges!!");
            }
            sb.append(printo(resulto.getBridges()));
            sb.append("\n\n");
            sb.append("NumberOfBridges\n");
            sb.append(resulto.getNumBridges());
            sb.append("\n\n");
            sb.append("Diameter\n");
            if(resulto.getDiameter()==-1)
            {
                sb.append("!!Infinite Diameter!!");
            }
            else
            {
                sb.append(resulto.getDiameter());
            }
            sb.append("\n\n");
            sb.append("Radius\n");
            if(resulto.getRadius()==-1)
            {
                sb.append("!!Infinite Radius!!");
            }
            else
            {
                sb.append(resulto.getRadius());
            }
            sb.append("\n\n");

            return sb.toString();
        }


        private String printo(java.util.List<int[]> list)
        {
            StringBuilder sb = new StringBuilder();

            for (int[] array : list)
            {
                sb.append( Arrays.toString(array));
            }
            return sb.toString();
        }

        private String printo1(java.util.List<int[]> list)
        {
            StringBuilder sb = new StringBuilder();

            for (int[] array : list)
            {
                sb.append((list.indexOf(array)+1) +" "+ Arrays.toString(array));
            }
            return sb.toString();
        }

    }

    public static void main(String[] args)
    {
//        try {
//           UIManager.setLookAndFeel("com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel");
//        //    UIManager.setLookAndFeel(UIManager.getCrossPlatformLookAndFeelClassName());
//        //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
//        //      UIManager.setLookAndFeel("com.sun.java.swing.plaf.gtk.GTKLookAndFeel");
//        //        UIManager.setLookAndFeel("javax.swing.plaf.metal.MetalLookAndFeel");
//        //    UIManager.setLookAndFeel("com.sun.java.swing.plaf.motif.MotifLookAndFeel");
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        } catch (InstantiationException e) {
//            e.printStackTrace();
//        } catch (IllegalAccessException e) {
//            e.printStackTrace();
//        } catch (UnsupportedLookAndFeelException e) {
//            e.printStackTrace();
//        }
        new Hauptfenster();
    }

}
