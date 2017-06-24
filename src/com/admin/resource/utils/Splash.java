package com.admin.resource.utils;

import com.sun.awt.AWTUtilities;
import javax.swing.JFrame;

public class Splash {

    public void TransCompFrame(JFrame frame) {
        frame.setUndecorated(true);
        AWTUtilities.setWindowOpaque(frame, false);
    }
}
