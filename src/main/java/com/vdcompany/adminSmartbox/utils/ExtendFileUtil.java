package com.vdcompany.adminSmartbox.utils;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URL;
import java.nio.channels.Channels;
import java.nio.channels.ReadableByteChannel;

/**
 * @author Namgyu Park
 * @since 2020.11.20
 * @version 1.0.0
 */
public class ExtendFileUtil{

	/**
	 * @param urlStr urlStr
	 * @param dir dir
	 * @param filename filename
	 * @throws IOException IOException
	 */
	public static void downloadFromURL(String urlStr, String dir, String filename) throws IOException {
		File file = new File(dir);
		
		if(!file.exists()) {
			file.mkdirs();
		}
		
		URL url = new URL(urlStr);
		
        try(ReadableByteChannel rbc = Channels.newChannel(url.openStream());
        	FileOutputStream fos = new FileOutputStream(dir + filename);) {
        	
        	fos.getChannel().transferFrom(rbc, 0, Long.MAX_VALUE);
        	
        }
        
    }
	
	
}
