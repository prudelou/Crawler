/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crawler;

import java.awt.image.BufferedImage;
import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.NetworkInterface;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.print.attribute.AttributeSet;
import javax.swing.text.html.HTML;
import javax.swing.text.html.HTMLDocument;
import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import javafx.beans.property.DoubleProperty;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
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
    
    // Launch download process
    public void download(String urlString, String pathDirectory,boolean hasProfondeur, String profondeur, boolean withMedia, ProgressDownload pd){

    	new Thread(){ public void run(){pd.setDownloadProgress(0.00);}}.start();

    	URL url;
        InputStream is = null;
        BufferedReader br;
        PrintWriter writer;
        File file;
        String fileName ="";


        try {
        	// Test Connection. If You're not connection : display error box and cancel download
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            NetworkInterface networkInterface = interfaces.nextElement();
            if (!networkInterface.isUp()){
            	openErrorDialog("no connection", "No connection", "Please use a true connection...");
            	new Thread(){ public void run(){pd.setDownloadProgress(0.00);}}.start();
            	return;
            }

        	
        	//Test if URL exists
        	new Thread(){ public void run(){pd.setDownloadProgress(0.10);}}.start();

        	if (urlExists(urlString)){

            	new Thread(){ public void run(){pd.setDownloadProgress(0.20);}}.start();

              	url =  new URL(urlString);
                is = url.openStream();  // throws an IOException
                br = new BufferedReader(new InputStreamReader(is));
                
                fileName = formatUrlForName(urlString);
                System.out.println("FileName = " + fileName);
                
                file = new File(pathDirectory+"/"+fileName+".html");
                file.getParentFile().mkdirs(); 
                file.createNewFile();
                writer = new PrintWriter(file.getPath(), "UTF-8");
                
                // Search which process we will use
            	new Thread(){ public void run(){pd.setDownloadProgress(0.30);}}.start();
                if (!hasProfondeur){
                	
                	// Use Standard Process : Without Image and Video
            		simpleDownload(pd, br, writer );
            		
                	new Thread(){ public void run(){pd.setDownloadProgress(0.40);}}.start();
                	
                	if (withMedia){

                		createDirectory(pathDirectory, fileName);
                        URLConnection connection = url.openConnection();
                        InputStream is1 = connection.getInputStream();
                        InputStreamReader isr = new InputStreamReader(is1);
                        BufferedReader br1 = new BufferedReader(isr);

                        HTMLEditorKit htmlKit = new HTMLEditorKit();
                        HTMLDocument htmlDoc = (HTMLDocument) htmlKit.createDefaultDocument();
                        HTMLEditorKit.Parser parser = new ParserDelegator();
                        HTMLEditorKit.ParserCallback callback = htmlDoc.getReader(0);
                        parser.parse(br1, callback, true);

                        for (HTMLDocument.Iterator iterator = htmlDoc.getIterator(HTML.Tag.IMG); iterator.isValid(); iterator.next()) {
                            javax.swing.text.AttributeSet attributes = iterator.getAttributes();
                            String imgSrc = (String) ((javax.swing.text.AttributeSet) attributes).getAttribute(HTML.Attribute.SRC);

                            if (imgSrc != null && (imgSrc.endsWith(".jpg") || (imgSrc.endsWith(".png")) || (imgSrc.endsWith(".jpeg")) || (imgSrc.endsWith(".bmp")) || (imgSrc.endsWith(".ico")) || (imgSrc.endsWith(".gif")))) {
                                try {
                                    String imagePath = downloadImage(urlString ,imgSrc, pathDirectory+"/"+fileName);
                                    System.out.println("ImagePath = " + imagePath);
                                	System.out.println("ImageURL = " + imgSrc);

                                	Path path = Paths.get(file.getPath());
                                	Charset charset = StandardCharsets.UTF_8;

                                	String content = new String(Files.readAllBytes(path), charset);
                                	content = content.replaceAll(imgSrc, "file://"+imagePath);
                                	Files.write(path, content.getBytes(charset));
                                	
                                } catch (IOException ex) {
                                    System.out.println(ex.getMessage());
                                }
                            }
                        }
                	
                	}
                }
                
                else{
                	// Désolé nous n'avons pas eu le temps de mettre cette fonctionnalité.             	
                }
            	new Thread(){ public void run(){pd.setDownloadProgress(0.90);}}.start();
                writer.close();
            	new Thread(){ public void run(){pd.setDownloadProgress(1.0);}}.start();


        	}

            
        } catch (MalformedURLException ioe) {
            pd.setDownloadProgress(0.00);
             ioe.printStackTrace();
         	

	    } catch (Exception ioe) { ioe.printStackTrace(); pd.setDownloadProgress(0.00);


	   } finally {
            try {
                if (is != null) is.close();
            } catch (IOException ioe) {
                ioe.printStackTrace();
                pd.setDownloadProgress(0.00);

            }
        }
    }

    // Open an error dialog which could be personalize with parameters
    public void openErrorDialog(String title, String header, String text){
    	Alert alert = new Alert(AlertType.ERROR);
    	alert.setTitle("Error " + title);
    	alert.setHeaderText(header);
    	alert.setContentText(text);
    	alert.showAndWait();
    }
    
    public boolean urlExists(String url){
    
        try {
            HttpURLConnection.setFollowRedirects(false);
            HttpURLConnection con = (HttpURLConnection) new URL(url).openConnection();
            con.setRequestMethod("GET");
            if (con.getResponseCode() == HttpURLConnection.HTTP_OK) return true;
            else openErrorDialog(con.getResponseCode()+"", url +"\n Code erreur " + con.getResponseCode(), "Please choose another URL.");

          }
          catch (Exception e) {
        	 openErrorDialog("", url +"\n Not found. ", "Please choose another URL.");
        	 
             return false;
          }
 
        
        
        return false;
   } 
    
    public String formatUrlForName(String url){
    	String fileName = url;
        String fileName2 = fileName;
        if (fileName.startsWith("https://")) fileName2 = fileName.substring(fileName.indexOf("https://")+8);
        else if (fileName.startsWith("http://")) fileName2 = fileName.substring(fileName.indexOf("http://")+7);
        return fileName2.replaceAll("/", "_");
    }
    
    public void simpleDownload(ProgressDownload pd, BufferedReader br, PrintWriter writer) throws IOException{
    	String line = "";
        pd.setDownloadProgress(0.50);
        while ((line = br.readLine()) != null) {
            writer.println(line); 
            pd.setDownloadProgress(pd.getDownloadProgress().get()+0.05);

        }
    }

    
    public String createDirectory(String path, String name){
    	// if the directory does not exist, create it
    	File theDir = new File(path+"/"+name);
    	if (!theDir.exists()) {
    	    System.out.println("creating directory: " + name);
    	    boolean result = false;

    	    try{
    	        theDir.mkdir();
    	        result = true;
    	    } 
    	    catch(SecurityException se){
    	        //handle it
    	    }        
    	    if(result) {    
    	        System.out.println("DIR created");  
    	    }
    	}
	    return theDir.getPath();
    }
    
    private  String downloadImage(String url, String imgSrc, String directory) throws IOException {
        BufferedImage image = null;
        try {
            if (!(imgSrc.startsWith("http"))) {
                url = url + imgSrc;
            } else {
                url = imgSrc;
            }
            imgSrc = imgSrc.substring(imgSrc.lastIndexOf("/") + 1);
            String imageFormat = null;
            imageFormat = imgSrc.substring(imgSrc.lastIndexOf(".") + 1);
            String imgPath = null;
            imgPath = directory+"/";
            System.out.println(imgPath);
            URL imageUrl = new URL(url);
            image = ImageIO.read(imageUrl);
            if (image != null) {
                File file = new File(imgPath+url.substring(url.lastIndexOf("/")+1));
                ImageIO.write(image, imageFormat, file);
                return file.getPath();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return "";

    }
    
}
