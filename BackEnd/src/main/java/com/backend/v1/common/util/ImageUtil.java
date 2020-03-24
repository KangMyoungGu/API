package com.backend.v1.common.util;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Component;

@Component
public class ImageUtil {
	
	public byte[] executeImageConvertByByteArray(String filePath, String fileNm) throws IOException {
		InputStream imageStream = new FileInputStream(filePath + "\\" + fileNm);
		byte[] imageByteArray = IOUtils.toByteArray(imageStream);
		imageStream.close();
		return imageByteArray;
	}
}
