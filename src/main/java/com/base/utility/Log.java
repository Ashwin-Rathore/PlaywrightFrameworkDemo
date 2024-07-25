/**
 * Author : Ashwin Rathore
 * Date : 25-07-2024
 * Email - ashwin.rathore001@gmail.com
 */

package com.base.utility;


import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;
public class Log {
        static Logger Log = Logger.getLogger(Log.class.getName());

        public static void INFO(String message) {
            DOMConfigurator.configure("log4j.xml");
            Log.info(message);
        }

        public static void ERROR(String message) {
            DOMConfigurator.configure("log4j.xml");
            Log.error(message);
        }

        public static void DEBUG(String message) {
            DOMConfigurator.configure("log4j.xml");
            Log.debug(message);
        }
}
