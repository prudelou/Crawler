/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import javafx.beans.property.DoubleProperty;
import javafx.beans.property.SimpleDoubleProperty;


public class ProgressDownload {
	
	// Indicator of download process
	DoubleProperty downloadProgress;
	
	// Get the value of downloadProgress
	public DoubleProperty getDownloadProgress() {
		return downloadProgress;
	}

	// Set the value of downloadProgress
	public void setDownloadProgress(DoubleProperty downloadProgress) {
		this.downloadProgress = downloadProgress;
	}

	//Constructor of ProgressDownload. Allows to instantiate downloadProgress.
	ProgressDownload(){
		downloadProgress = new SimpleDoubleProperty(0.2);
	}
	
	
}
