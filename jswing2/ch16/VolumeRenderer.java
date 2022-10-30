import java.awt.Component;

import javax.swing.BorderFactory;
import javax.swing.JComponent;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.border.Border;
import javax.swing.table.TableCellRenderer;

/**
 * VolumeRenderer.java
 * 
 * A slider renderer for volume values in a table.
 *
 */
public class VolumeRenderer extends JSlider implements TableCellRenderer {

    private static final long serialVersionUID = 1L;

    private static final Border EMPTY = BorderFactory.createEmptyBorder(1,1,1,1);

    public VolumeRenderer() {
        super(SwingConstants.HORIZONTAL);

        // set a starting size...some 1.2/1.3 systems need this
        // setSize(115, 15);
    }

    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected, boolean hasFocus,
            int row, int column) {
        if (value == null) {
            return this;
        }

        if (value instanceof Volume) {
            setValue(((Volume) value).getVolume());
        } else {
            setValue(0);
        }

    if (hasFocus) {
        // Note that this customization knows that cell 0,0 is using a DefaultTableCellRenderer which 
        // is what we want because it has the focused border that we want to duplicate.
        TableCellRenderer renderer = table.getCellRenderer(0, 0);
        JComponent c = (JComponent) renderer.getTableCellRendererComponent(table, value, false, true, 0, 0);
        if (c instanceof JComponent) {
            this.setBorder(c.getBorder());
        }
    } else {
        this.setBorder(EMPTY);
    }

    return this;
  }

}
