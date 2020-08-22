package com.backend.v1.common.util;

import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.util.Iterator;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.tomcat.util.codec.binary.Base64;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.stereotype.Component;

import com.google.gson.Gson;

@Component
public class CipherUtil {
	private static String iv;
	private static Key keySpec;
	
	private final static String securityKey = "asdfashdfkajsdkl;fj;aklsjd;lfkjasdf";
	
	public CipherUtil() throws UnsupportedEncodingException {
		this.iv = securityKey.substring(0,6);
		byte[] keyBytes = new byte[16];
		byte[] b = securityKey.getBytes("UTF-8");
		int len = b.length;
		if(len > keyBytes.length)
			len = keyBytes.length;
		
		System.arraycopy(b, 0, keyBytes, 0, len);
		SecretKeySpec keySpec = new SecretKeySpec(keyBytes, "AES");
		
		this.keySpec = keySpec;
	}
	
	// 암호화
	public String encrypt(String str) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
		byte[] encrypted = cipher.doFinal(str.getBytes("UTF-8"));
		String enStr = new String(Base64.decodeBase64(encrypted));
		return enStr;
	}
	
	// 복호화
	public String decrypt(String str) throws NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException {
		Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
		cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
		byte[] byteStr = Base64.decodeBase64(str.getBytes());
		return new String(cipher.doFinal(byteStr), "UTF-8");
	}
	
	// 암호화 문자열인지 판단
	public boolean isEncrypt(String str) {
		try {
			Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
			cipher.init(Cipher.DECRYPT_MODE, keySpec, new IvParameterSpec(iv.getBytes()));
			byte[] byteStr = Base64.decodeBase64(str.getBytes());
			new String(cipher.doFinal(byteStr), "UTF-8");
			
			return true;
		} catch (NoSuchAlgorithmException e) {
			return false;
		} catch(NoSuchPaddingException e) {
			return false;
		} catch(InvalidKeyException e) {
			return false;
		} catch(InvalidAlgorithmParameterException e) {
			return false;
		} catch(UnsupportedEncodingException e) {
			return false;
		} catch(IllegalBlockSizeException e) {
			return false;
		} catch(BadPaddingException e) {
			return false;
		}
	}
	
	// 오브젝트 중, 암호화된 데이터가 있을 경우 복호화 한다.
	public JSONObject decryptObject(Object paramObj) throws ParseException, NoSuchAlgorithmException, GeneralSecurityException, UnsupportedEncodingException{
		JSONObject jsonObj = (JSONObject) new JSONParser().parse(new Gson().toJson(paramObj));
		
		String[] encryptKey = {};
		Iterator iter = jsonObj.keySet().iterator();

		while(iter.hasNext()) {
			String key = (String) iter.next();
			String value = (String) jsonObj.get(key);
			
			if(this.isEncrypt(value)) {
				jsonObj.put(key, this.decrypt(value));
			}
		}
		
		return jsonObj;
	}

}
