import javax.swing.BorderFactory;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import javax.swing.border.Border;

import java.awt.*;

/**
 * BookCellRenderer.java
 * A custom cell renderer for BookEntry objects.
 * 
 * This originally extends JLabel... I think it might
 * be better to extend DefaultListCellRenderer (which
 * also extends JLabel but has certain overloaded
 * methods to improve performance)
 *  
 * extends JLabel implements ListCellRenderer 
 *  
 * @author Rick Wellman
 *
 */
@SuppressWarnings({ "rawtypes", "serial" })
public class BookCellRenderer extends DefaultListCellRenderer {
	
    private static final Color HIGHLIGHT_COLOR = new Color(0x7395AE); // new Color(0, 0, 128); // modified

    private static final Border BORDER = BorderFactory.createEmptyBorder(4,4,4,4);
    
    public BookCellRenderer() {
        setOpaque(true);
        setIconTextGap(12);
        
        //Have to move this line now that we are extending DefaultListCellRenderer
        //because it overrides our setting in its implementation of getListCellRendererComponent()
        //setBorder(BORDER); // new
    }

    public Component getListCellRendererComponent(
        JList list,
        Object value,
        int index,
        boolean isSelected,
        boolean cellHasFocus)
    {
    	super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    	
        final BookEntry entry = (BookEntry)value;
        setText(entry.getTitle());
        setIcon(entry.getImage());
        
        setBorder(BORDER); // new
        
        if (isSelected) {
            setBackground(HIGHLIGHT_COLOR);
            setForeground(Color.white);
        } else {
            setBackground(Color.white);
            setForeground(Color.black);
        }
        
        return this;
    }
    
}
