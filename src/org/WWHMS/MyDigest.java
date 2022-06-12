package org.WWHMS;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.UUID;

/*����sha256ժҪ�㷨�洢����*/
public class MyDigest {

	public static void main(String[] args) {
		
		String salt=usingUUID(),password="123456";
		int time=10000;
		String sha=PBKDF2(password, salt,  time);
		System.out.println(sha);
	}

	private static String digest(String str) {
		MessageDigest messageDigest;
		String encodeStr = "";
		try {
			messageDigest = MessageDigest.getInstance("SHA-256");
			messageDigest.update(str.getBytes("UTF-8"));
			encodeStr = byte2Hex(messageDigest.digest());
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
		return encodeStr;
	}

	private static String byte2Hex(byte[] bytes) {
		StringBuffer stringBuffer = new StringBuffer();
		String temp = null;
		for (int i = 0; i < bytes.length; i++) {
			temp = Integer.toHexString(bytes[i] & 0xFF);
			if (temp.length() == 1) {
				// 1�õ�һλ�Ľ��в�0����
				stringBuffer.append("0");
			}
			stringBuffer.append(temp);
		}
		return stringBuffer.toString();

	}

	public static String usingUUID() {//������
		UUID randomUUID = UUID.randomUUID();
		return randomUUID.toString().replaceAll("-", "");
	}

	public static String PBKDF2(String password, String salt, int time) {//���ѭ��
		for (int i = 0; i < time; i++)
			password = digest(password + salt);
		return password;
	}

}
