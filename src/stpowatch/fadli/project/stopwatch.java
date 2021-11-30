package stpowatch.fadli.project;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class stopwatch extends JFrame implements ActionListener {
    private int jam = 0;
    private int menit = 0;
    private int detik = 0;
    private int mdetik = 0;
    private int delay = 10;
    private Timer timer = null;
    private Label label = new Label ("00:00:00:00");
    private Button btnStart = new Button ("Start");
    private Button btnStop = new Button ("Stop");
    private Button btnReset = new Button ("Reset");
    private Panel panel = new Panel();


    public stopwatch(){
        super("Stopwatch Ahmad Zulfadli & Yaslan Ros");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocation(100,100);
        setSize(500,300);

        btnStart.addActionListener(this);
        btnStart.setBounds(100, 200, 100, 50);
        btnStart.setFont(new Font("Ink Free",Font.PLAIN,20));
        btnStart.setFocusable(false);

        btnStop.addActionListener(this);
        btnStop.setBounds(100, 200, 100, 50);
        btnStop.setFont(new Font("Ink Free",Font.PLAIN,20));
        btnStop.setFocusable(false);

        btnReset.addActionListener(this);
        btnReset.setBounds(100, 200, 100, 50);
        btnReset.setFont(new Font("Ink Free",Font.PLAIN,20));
        btnReset.setFocusable(false);

        panel.add(btnStart);
        panel.add(btnStop);
        panel.add(btnReset);

        label.setFont(new Font("calibre",Font.BOLD,25));
        label.setAlignment(Label.CENTER);
        getContentPane().setLayout(new BorderLayout());
        getContentPane().add(label,BorderLayout.CENTER);
        getContentPane().add(panel,BorderLayout.SOUTH);
        setVisible(true);
        timer = new Timer(delay, display);}

    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == btnStart)
        {
            if(!timer.isRunning()){
                timer.start();
            }
        }
        else if(ae.getSource() == btnStop){
            timer.stop();
        }
        else
        {
            timer.restart();
            jam=menit=detik=mdetik=0;
            label.setText("00:00:00:00");
            timer.stop();
        }
    }

    private ActionListener display = new ActionListener() {
        public void actionPerformed(ActionEvent e){
            String str1 = Integer.toString(jam);
            String str2 = Integer.toString(menit);
            String str3 = Integer.toString(detik);
            String str4 = Integer.toString(mdetik);

            if (jam < 10) str1 = "0" + str1;
            if (menit < 10) str2 = "0" + str2;
            if (detik < 10) str3 = "0" + str3;
            if (mdetik < 100) str4 = "0" + str4;

            label.setText(str1 + ":" + str2 + ":" + str3 + ":" + str4);
            mdetik++;
            if (mdetik == 100){
                mdetik = 0;
                detik++;
                if(detik == 60) {
                    detik = 0;
                    menit++;
                    if (menit == 60) {
                        menit = 0;
                        jam++;
                        if (jam == 24)
                            jam = 0;
                    }
                }
            }
        }
    };
    public static void main (String[]args) {
        new stopwatch();
    }
}
