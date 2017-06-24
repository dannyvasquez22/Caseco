package com.admin.resource.utils;

import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.ImageIcon;
import javax.swing.Timer;

/** * @author DANNY VASQUEZ RAFAEL */

public class Global {
    
    public static final SimpleDateFormat FORMAT_DATE_CLIENT = new SimpleDateFormat("dd/MM/yyyy");
    public static final SimpleDateFormat FORMAT_DATE_SQL = new SimpleDateFormat("yyyy-MM-dd");
    public static final SimpleDateFormat FORMAT_TIME_SQL = new SimpleDateFormat("HH:mm:ss");
    public static Calendar CALENDARY;
    public static Timer TIMER;    
    public static Toolkit TOOLKIT = Toolkit.getDefaultToolkit();
    public static Image ICON_IMAGE = new ImageIcon("src/com/admin/resource/images/Casco.jpg").getImage();
    public static ImageIcon CURSOR_IMAGE = new ImageIcon("src/com/admin/resource/images/PALANA.png");
    public static Cursor CURSOR = TOOLKIT.createCustomCursor(CURSOR_IMAGE.getImage(), new Point(2, 2), "CursorPalana");
    
    public static String formatClient(String inputDate) throws ParseException{
        Date date = FORMAT_DATE_SQL.parse(inputDate);
        return FORMAT_DATE_CLIENT.format(date);
    }
    
    public static Date formatDateClient(String inputDate) throws ParseException{
//        System.out.println("asdadasdasdsadasdsadsadas");
        java.util.Date date1 = FORMAT_DATE_SQL.parse(inputDate);
        java.sql.Date date2 = new java.sql.Date(date1.getTime());
//        System.out.println(date1 + "   ---    " + date2);
        return java.sql.Date.valueOf(inputDate);
    }
    
    public static String formatSQL(String inputDate) throws ParseException{
        Date date = FORMAT_DATE_CLIENT.parse(inputDate);
        return FORMAT_DATE_SQL.format(date);
    }
    
}
