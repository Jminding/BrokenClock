import javax.swing.*;
import java.awt.*;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class GUIArt {
    public static void main(String[] args) {
        JFrame theGUI = new JFrame();
        theGUI.setTitle("Broken Clock");
        theGUI.setSize(500, 500);
        theGUI.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        Container pane = theGUI.getContentPane();
        Draw draw = new Draw(Color.blue);
        pane.add(draw);
        theGUI.setVisible(true);

        while (true) {
            draw.repaint();
        }
    }
}

class Draw extends JPanel {
    public Draw(Color c) {
        setBackground(c);
    }

    public void paint(Graphics g) {
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        String[] times1 = formatter.format(date).split(":");
        int[] times2 = new int[3];
        for (int i = 0; i < 3; i++) times2[i] = Integer.parseInt(times1[i]);
        times2[0] = times2[0] % 12 != 0 ? times2[0] % 12 : times2[0];
        String times[] = new String[3];
        for (int i = 0; i < 3; i++) {
            if (times2[i] < 10) {
                times[i] = "0" + Integer.toString(times2[i]);
            } else times[i] = Integer.toString(times2[i]);
        }
        Font font = new Font("Arial", Font.BOLD, 80);
        Color colors[] = {Color.black, Color.blue, Color.cyan, Color.darkGray, Color.gray, Color.lightGray, Color.magenta, Color.orange, Color.pink, Color.red, Color.white, Color.yellow};
        g.setFont(font);
        g.setColor(Color.white);
        // System.out.println(String.format("%s:%s:%s", times2[0], times2[1], times2[2]));
        g.drawRoundRect(0, 173, 500, 100, 10, 10);
        g.drawString(String.format("%s:%s:%s", times[0], times[1], times[2]), 110, 250);
        Random rand = new Random();
        g.fillOval(220, 300, 50, 50);
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.fillOval(rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500));
        g.drawRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(500), rand.nextInt(500));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.fillRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.fillRect(rand.nextInt(250), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.fillRect(rand.nextInt(500), rand.nextInt(250), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.drawRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.drawRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.drawOval(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.drawOval(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.fillRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.fillRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.fillRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(colors[rand.nextInt(colors.length)]);
        g.fillRect(rand.nextInt(500), rand.nextInt(500), rand.nextInt(250), rand.nextInt(250));
        g.setColor(Color.red);
        g.drawString("WAKE UP", rand.nextInt(250), 100);
    }
}