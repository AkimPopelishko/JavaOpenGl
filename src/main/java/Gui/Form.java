package Gui;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

// форма нашего приложения
public class Form extends JFrame {

    private static final String FILE_NAME = "points.txt";

    // панель для отображения OpenGL
    private JPanel GLPlaceholder;
    private JPanel root;
    final Timer timer;
    private JButton button1;
    private JButton button2;

    // рисовалка OpenGL
    private final RendererGL renderer;

    // Конструктор формы
    public Form() {
        super("OpenGL Tutorial");
        // инициализируем OpenGL
        renderer = new RendererGL();
        // связываем элемент на форме с рисовалкой OpenGL
        GLPlaceholder.setLayout(new BorderLayout());
        GLPlaceholder.add(renderer.getCanvas());
        // указываем главный элемент формы
        getContentPane().add(root);
        // задаём размер формы
        setSize(getPreferredSize());
        // показываем форму
        setVisible(true);
        // обработчик зарытия формы
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new Thread(() -> {
                    renderer.close();
                    timer.stop();
                    System.exit(0);
                }).start();
            }
        });
        // тинициализация таймера, срабатывающего раз в 100 мсек
        timer = new Timer(100, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                onTime();
            }
        });
        timer.start();
        initWidgets();
    }

    private void initWidgets() {

    }

    private void onTime() {
        // события по таймеру
    }

    // преобразование в html
    private static String convertToMultiline(String orig) {
        return "<html>" + orig.replaceAll("\n", "<br>");
    }

    private static final String problemStr = "ПОСТАНОВКА ЗАДАЧИ:\nЗаданы два множества точек в пространстве.\n Требуется построить пересечения и разность этих множеств";

    public static void main(String[] args) {
        new Form();
    }

}
