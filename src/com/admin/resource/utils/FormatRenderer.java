package com.admin.resource.utils;

/** * @author DANNY VASQUEZ RAFAEL */

import java.text.Format;
import java.text.DateFormat;
import javax.swing.table.DefaultTableCellRenderer;
import org.apache.log4j.Logger;

/**	Use a formatter to format the cell Object */
public class FormatRenderer extends DefaultTableCellRenderer {
    final static Logger logger = Logger.getLogger(FormatRenderer.class);
    private final Format formatter;

    /**   Use the specified formatter to format the Object
     * @param formatter */
    public FormatRenderer(Format formatter) {
        this.formatter = formatter;
    }

    @Override
    public void setValue(Object value) {
        //  Format the Object before setting its value in the renderer
        try {
            if (value != null) value = formatter.format(value);
        } catch(IllegalArgumentException e) {
            logger.error(e.toString());
        }

        super.setValue(value);
    }

    /**  Use the default date/time formatter for the default locale
     * @return  */
    public static FormatRenderer getDateTimeRenderer() {
        return new FormatRenderer( DateFormat.getDateTimeInstance() );
    }

    /**  Use the default time formatter for the default locale
     * @return  */
    public static FormatRenderer getTimeRenderer() {
        return new FormatRenderer( DateFormat.getTimeInstance() );
    }
}