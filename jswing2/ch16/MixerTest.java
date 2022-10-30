import java.awt.*;
import javax.swing.*;

/**
 * MixerTest.java
 * 
 * A test application for showing Volume data in a JTable using the
 * custom VolumneRenderer class.
 *
 */
public class MixerTest extends JFrame {

    private static final long serialVersionUID = 1L;

    public MixerTest() {
        super("Custom Editor Test");
        setSize(600, 160);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MixerModel test = new MixerModel();
        test.dump();
        JTable jt = new JTable(test);
        jt.setDefaultRenderer(Volume.class, new VolumeRenderer());
        JScrollPane jsp = new JScrollPane(jt);
        getContentPane().add(jsp, BorderLayout.CENTER);
    }

    public static void main(String args[]) {
        MixerTest mt = new MixerTest();
        mt.setVisible(true);
    }

}
