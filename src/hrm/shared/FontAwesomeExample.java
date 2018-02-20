package hrm.shared;

import hrm.core.IconSet;
import hrm.core.IconSet;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.*;

/**
 * Created by dylan on 30.07.17.
 * Awesome example for Font Awesome
 */
public class FontAwesomeExample {

    public FontAwesomeExample(){
        try {
            getFontLabels();
            InputStream is = getClass().getResourceAsStream("/fonts/fontawesome.ttf");
            Font font = Font.createFont(Font.TRUETYPE_FONT, is);
            font = font.deriveFont(Font.PLAIN, 24f);

            JPanel panel = new JPanel();
            panel.setLayout(new FlowLayout());
            java.util.List<JLabel> fontLabels = getFontLabels();
            for (JLabel fontLabel : fontLabels) {
                panel.add(fontLabel);
            }


            JFrame frame = new JFrame("FontAwesome Example");
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setContentPane(panel);
            frame.setSize(new Dimension(600,600));
            frame.setVisible(true);


        } catch (IOException | FontFormatException exp) {
            exp.printStackTrace();
        }
    }

    /**
     * Use reflection to load all the labels
     * @return
     */
    private java.util.List<JLabel> getFontLabels(){
        ClassLoader classLoader = getClass().getClassLoader();
        try {
            Class<?> faClass = classLoader.loadClass("core.IconSet");
            Field[] icons = faClass.getFields();
            java.util.List<JLabel> labels = new ArrayList<>(icons.length);
            for (Field icon : icons) {
                JLabel label = IconSet.FontAwesome.getLabelWithFontAwesomeIcon(icon.get(icon.getName()).toString());
                labels.add(label);
            }
            return labels;
        } catch (ClassNotFoundException | IllegalAccessException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static void main(String[] args) {
        new FontAwesomeExample();
    }
}
