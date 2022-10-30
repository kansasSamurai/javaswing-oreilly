import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;
import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.KeyStroke;
import javax.swing.event.ChangeEvent;

/**
 * As found at: https://stackoverflow.com/questions/38020987/java-jtable-how-to-transfer-focus-from-the-current-cell-in-edit-mode-to-the-next
 * 
 *
 */
public class TestTableKeyBinding {

    private final String name = "selectNextColumnCell";

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new TestTableKeyBinding();
        });
    }

    TestTableKeyBinding() {
        JFrame f = new JFrame();
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        String[] headers = new String[]{"apples", "bananas"};
        String[][] data = new String[][]{{"1", "2"}, {"3", "4"}, {"5", "6"}};

        @SuppressWarnings("serial")
        JTable table = new JTable(data, headers) ;
//        {
//            @Override
//            public void editingStopped(ChangeEvent e) {
//                super.editingStopped(e);
//                this.getActionMap().get(name).actionPerformed(
//                    new ActionEvent(this, ActionEvent.ACTION_FIRST, name));
//            }
//        };
//        table.getInputMap(JTable.WHEN_ANCESTOR_OF_FOCUSED_COMPONENT)
//            .put(KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0), name);
//        table.setCellSelectionEnabled(true);
        f.add(new JScrollPane(table));
        f.pack();
        f.setSize(new Dimension(320, 240));
        f.setLocationRelativeTo(null);
        f.setVisible(true);
    }
    
}