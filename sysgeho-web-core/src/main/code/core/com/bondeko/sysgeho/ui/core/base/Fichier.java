/**
 * 
 */
package com.bondeko.sysgeho.ui.core.base;

import java.io.IOException;
import java.io.OutputStream;

public class Fichier {
		
	private boolean exist = false;
	private String name;
    private String mime;
    private long length;
    private byte[] data;
    private String type;
    
    
    
    public Fichier(){
 
    }   
    
    
    public byte[] getData() {
        return data;
    }
    
    public void setData(byte[] data) {
    	
    	this.data = data;
    	
    	if(data != null && data.length > 0){
    		setExist(true);
    	}
    	else {
    		setExist(false);
    	}       
    }
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
        int extDot = name.lastIndexOf('.');
        if(extDot > 0){
            String extension = name.substring(extDot +1);
            if("bmp".equals(extension)){
                mime="image/bmp";
            } else if("jpg".equals(extension)){
                mime="image/jpeg";
            } else if("gif".equals(extension)){
                mime="image/gif";
            } else if("png".equals(extension)){
                mime="image/png";
            } 
            else if("pdf".equals(extension)){
            	mime="application/pdf";          	
            }
            else if("doc".equals(extension)){
            	mime="application/msword";          	
            }            
            else if("txt".equals(extension)){
            	mime="txt/plain";          	
            }
            else {
                mime = "image/unknown";
            }
        }
    }
    public long getLength() {
        return length;
    }
    public void setLength(long length) {
        this.length = length;
    }
    
    public String getMime(){
        return mime;
    }	
       
    /**
	 * @return the exist
	 */
	public boolean getExist() {
		return exist;
	}
	
	/**
	 * @param exist the exist to set
	 */
	public void setExist(boolean exist) {
		this.exist = exist;
	}	
	
	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}
	
	public void paint(OutputStream stream, Object object) {
        try {
			stream.write(getData());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    }   
    
    

}
