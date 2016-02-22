
/**
 * The only thing we define in the Juggler BeanInfo is a GIF icon.
 */

package sunw.demo.superclock;
// package sunw.demo

import java.beans.*;
import java.beans.PropertyDescriptor;

public class MyClockBeanInfo extends SimpleBeanInfo {

    public java.awt.Image getIcon(int iconKind) {
        if (iconKind == BeanInfo.ICON_COLOR_16x16) {
            java.awt.Image img = loadImage("JugglerIcon.gif");
            return img;
        }
        return null;
    }
}
//
//    public PropertyDescriptor[] getPropertyDescriptors() {
//        try {
//
//            PropertyDescriptor debug =
//                    new PropertyDescriptor("debug", beanClass);
//
//            PropertyDescriptor animationRate =
//                    new PropertyDescriptor("animationRate", beanClass);
//
//            PropertyDescriptor name =
//                    new PropertyDescriptor("name", beanClass);
//
//            debug.setBound(true);
//            animationRate.setBound(true);
//            name.setBound(true);
//
//            PropertyDescriptor rv[] = {debug, animationRate, name};
//
//            //PropertyDescriptor rv[] = {};
//            return rv;
//        } catch( IntrospectionException e) {
//            throw new Error(e.toString());
//        }
//    }
//
//    public int getDefaultPropertyIndex() {
//        // the index for the animationRate property.
//        return 1;
//    }
//
//    private final static Class beanClass = MyClock.class;
//}
