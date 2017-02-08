/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.io.File;

import javafx.stage.DirectoryChooser;

public class ProcessCrawler {
	
	// CurrentDirectory
	File currentDirectory;
	
	// Constructor of ProcessCrawler. Initialize currentDirectory to userDirectory
	ProcessCrawler(){
		// Initialize currentDirectory to userDirectory
		currentDirectory = new File(System.getProperty("user.home"));
	}
	
	// Return the path of a directory choose by a DirectoryChooser
    public String getDirectory(){
    	
    	// Initialize Directory Chooser
    	DirectoryChooser directoryChooser = new DirectoryChooser();
    	// Set Initial Directory
    	directoryChooser.setInitialDirectory(currentDirectory);
    	// Wait user's choice
        File selectedDirectory = directoryChooser.showDialog(null);
        
        // Test value of return
        if(selectedDirectory == null){
        	return "";
        }else{
        	// Change currentDirectory and return Path of directory
        	currentDirectory = new File(selectedDirectory.getAbsolutePath());
            return selectedDirectory.getAbsolutePath();
        }
    }
}
