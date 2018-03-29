import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexPuzzles {
    public static List<String> urlRegex(String[] urls) {
        /* Your code here */
        ArrayList<String> u = new ArrayList<>();
        Pattern pattern = Pattern.compile("\\(.*?(https?://)(\\w+?\\.)+?\\w{2,3}\\/\\w+?\\.html.*?\\)");
        for ( String a : urls) {
            Matcher matcher = pattern.matcher(a);
            if (matcher.matches()) {
                u.add(a);
            }
        }
        return u;
    }

    public static List<String> findStartupName(String[] names) {
        /* Your code here */
        ArrayList<String> lstnames = new ArrayList<>();
        Pattern pattern = Pattern.compile("(Data|App|my|on|un)[A-Za-hj-z0-9]+?(ly|sy|ify|\\.io|\\.fm|\\.tv)");
        for ( String a : names) {
            Matcher matcher = pattern.matcher(a);
            if (matcher.matches()) {
                lstnames.add(a);
            }
        }
        return lstnames;

    }

    public static BufferedImage imageRegex(String filename, int width, int height) {
        BufferedReader br;
        BufferedImage img = null;
        int[][][] hahaha = new int [width] [height][3];
        try {
            br = new BufferedReader(new InputStreamReader(new FileInputStream(filename)));
        } catch (FileNotFoundException e) {
            throw new RuntimeException("No such file found: " + filename);
        }

        // Possible initialization code
        try {
            String line;
            while ((line = br.readLine()) != null) {
                // Code for processing each line
                Pattern p1 = Pattern.compile("\\(([0-9]+),\\s([0-9]+)\\)");
                Pattern p2 = Pattern.compile("\\[([0-9]{1,3}),\\s([0-9]{1,3}),\\s([0-9]{1,3})\\]");

                Matcher p1Matcher = p1.matcher(line);
                p1Matcher.find();
                int X = Integer.parseInt(p1Matcher.group(1));
                int Y = Integer.parseInt(p1Matcher.group(2));

//                hjsdhakjhsaljkdhslakjhlkj
                Matcher p2Matcher = p2.matcher(line);
                p2Matcher.find();
                int R = Integer.parseInt(p2Matcher.group(1));
                int G = Integer.parseInt(p2Matcher.group(2));
                int B = Integer.parseInt(p2Matcher.group(3));

                hahaha[X][Y][0] = R;
                hahaha[X][Y][1] = G;
                hahaha[X][Y][2] = B;

            }
            BufferedImage bfm = arrayToBufferedImage(hahaha);
            return bfm;
        } catch (IOException e) {
            System.err.printf("Input error: %s%n", e.getMessage());
            System.exit(1);
        }
        return img;
    }

    public static BufferedImage arrayToBufferedImage(int[][][] arr) {
        BufferedImage img = new BufferedImage(arr.length, arr[0].length, BufferedImage.TYPE_INT_RGB);
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                int pixel = 0;
                for (int k = 0; k < 3; k++) {
                    pixel += arr[i][j][k] << (16 - 8*k);
                }
                img.setRGB(i, j, pixel);
            }
        }

        return img;
    }

    public static void main(String[] args) {
        /* For testing image regex */
        BufferedImage img = imageRegex("mystery.txt", 400, 400);

        File outputfile = new File("output_img.jpg");
        try {
            ImageIO.write(img, "jpg", outputfile);
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}
