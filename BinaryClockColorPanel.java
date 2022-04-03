import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.io.File;
import java.text.SimpleDateFormat;
import java.util.Date;

// Make sure to import javax.imageio.ImageIO and java.io.File

public class BinaryClockColorPanel extends JPanel {
    /**
     * @param num
     * @return num but in a six-digit binary string
     * This function converts the number into a six-digit binary number
     * Six digits because there's 32, 16, 8, 4, 2, and 1
     */
    public static String toBinary(int num) {
        return "0".repeat(6 - Integer.toBinaryString(num).length() + 1) + Integer.toBinaryString(num);
    }

    public void paint(Graphics g) {
        super.paintComponent(g);
        Image img = null;

        try {
            img = ImageIO.read(new File("background.jpg")); // Make sure that background.jpg is in the same directory
        } catch (Exception e) {
            System.out.println(e.toString());
        }

        g.drawImage(img, 0, 0, null);

        Font font = new Font("Open Sans", Font.BOLD, 50);
        g.setFont(font);

        Dimension size = Toolkit.getDefaultToolkit().getScreenSize(); // Hopefully your screen size is the same as mine, otherwise this will kind of break (if it does break, I can show it to you on my computer)
        int width = (int) size.getWidth();
        int height = (int) size.getHeight();

        g.setColor(Color.blue);
        g.drawString("Binary Clock", width / 2 - 300, 100);
        g.setColor(new Color(21, 230, 42));
        g.drawString("Hours", width - 300, 250);
        g.setColor(new Color(81, 13, 209));
        g.drawString("Minutes", width - 300, 375);
        g.setColor(Color.white);
        g.drawString("Seconds", width - 300, 500);

        String binh, binm, bins;
        SimpleDateFormat formatter = new SimpleDateFormat("HH:mm:ss"); // I used SimpleDateFormat because GregorianCalendar wasn't working for some reason
        Date date = new Date();
        String time[] = formatter.format(date).split(":");

        int h = Integer.parseInt(time[0]);
        int m = Integer.parseInt(time[1]);
        int s = Integer.parseInt(time[2]);

        binh = toBinary(h);
        binm = toBinary(m);
        bins = toBinary(s);

        g.drawString("32", 150, 625);
        g.drawString("16", 150 * 2, 625);
        g.drawString(" 8", 150 * 3, 625);
        g.drawString(" 4", 150 * 4, 625);
        g.drawString(" 2", 150 * 5, 625);
        g.drawString(" 1", 150 * 6, 625);

        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 6; j++) {
                g.fillOval(j * 150, 250 - 50, 50, 50);
                g.fillOval(j * 150, 375 - 50, 50, 50);
                g.fillOval(j * 150, 500 - 50, 50, 50);
            }
        }

        g.setColor(Color.red);

        /**
         * Algorithm:
         * Convert the hour, minute, and second into a six-digit binary string (using the toBinary() method shown below)
         * Each character in the binary string represents a column
         * There are three binary strings
         * Loop through the binary strings (using counter i)
         * Loop through each character in the binary string (using counter j)
         * If the j-th character in the binary string is a 1, then fill in the oval
         * Otherwise, just leave it
         */
        for (int i = 1; i <= 3; i++) {
            for (int j = 1; j <= 6; j++) {
                if (binh.charAt(j) == '1') {
                    g.fillOval(j * 150, 250 - 50, 50, 50);
                }
                if (binm.charAt(j) == '1') {
                    g.fillOval(j * 150, 375 - 50, 50, 50);
                }
                if (bins.charAt(j) == '1') {
                    g.fillOval(j * 150, 500 - 50, 50, 50);
                }
            }
        }

        g.setColor(Color.red);

        //Add a 0 in front of the hour, minute, or second if it's less than 10 (so only has one digit)
        String hour = h < 10 ? "0" + Integer.toString(h) : Integer.toString(h);
        String minute = m < 10 ? "0" + Integer.toString(m) : Integer.toString(m);
        String second = s < 10 ? "0" + Integer.toString(s) : Integer.toString(s);

        g.drawString(String.format("%s:%s:%s", hour, minute, second), 150, 725);
        g.drawString(String.format("%s:%s:%s", Integer.parseInt(hour) % 12, minute, second), 150, 800);
    }
}