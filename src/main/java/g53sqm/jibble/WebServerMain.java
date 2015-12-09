package g53sqm.jibble;

import java.io.File;
import java.io.IOException;

/* 
Copyright Paul James Mutton, 2001-2004, http://www.jibble.org/

This file is part of Jibble Web Server / WebServerLite.

This software is dual-licensed, allowing you to choose between the GNU
General Public License (GPL) and the www.jibble.org Commercial License.
Since the GPL may be too restrictive for use in a proprietary application,
a commercial license is also provided. Full license information can be
found at http://www.jibble.org/licenses/

$Author: pjm2 $
$Id: WebServerMain.java,v 1.2 2004/02/01 13:37:35 pjm2 Exp $

*/


/**
 * This class contains the main method for the Jibble Web Server.
 * 
 * @author Copyright Paul Mutton, http://www.jibble.org/
 */
public class WebServerMain {

    public static void main(String[] args) throws IOException {
    	SLF4J logger =  new SLF4J();
    	
    	
    	
    	 try
         {
             
             File myFile = new File("C:/./../workspace/sqm.cw2/webfiles");
             String path = myFile.getCanonicalPath();

             // If the file exists, display it's full path.
             
             {
            	 System.out.println("Jibble web server (modified by Mohd Khairul Syafiq bin Muhammad Zakaria(011172) for G53SQM)");
                 System.out.println("root directory " + path);
                 System.out.println("port:8088");
                 
                 
             }
             logger.info("Log information");
         }
    	 
         catch (IOException ex)
         {
             System.out.println(ex.toString());
         }
    	 
    	 WebProperty properties = new WebProperty();
 		properties.getPropValues();
        
        String rootDir = WebServerConfig.DEFAULT_ROOT_DIRECTORY;
        int port = WebServerConfig.DEFAULT_PORT;
        
        if (args.length > 0) {
            rootDir = args[0];
        }
        
        if (args.length > 1) {
            try {
                port = Integer.parseInt(args[1]);
            }
            catch (NumberFormatException e) {
                // Stick with the default value.
            }
        }
        
        try {
            WebServer server = new WebServer(rootDir, port);
            server.activate();
        }
        catch (WebServerException e) {
            System.out.println(e.toString());
        }
    }

}