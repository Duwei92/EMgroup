package EMgroup.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * MD5加密类 单例模式(饿汉模式)
 * 
 * @version 1.1
 * @time 2016.11.12
 * @author HAHA
 * @input:String
 * @output:32位加密String
 * 
 */

public class MD5Encryption {

	private static MD5Encryption md5 = new MD5Encryption();

	private MD5Encryption() {// 私有构造
	}

	public static MD5Encryption getInstance() {
		return md5;
	}

	public String encryption(String str) {
		try {
			MessageDigest messageDigest = MessageDigest.getInstance("MD5");
			byte[] inputArray = str.getBytes();
			messageDigest.update(inputArray);
			byte[] resultByteArray = messageDigest.digest();
			return byteArrayToHex(resultByteArray);

		} catch (NoSuchAlgorithmException e) {
			System.out.println("No Such Algorithm Exception");
			e.printStackTrace();
			return null;
		}
	}

	public String byteArrayToHex(byte[] byteArray) {

		char[] hexDigits = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
		char[] resultCharArray = new char[byteArray.length * 2];
		int index = 0;
		for (byte b : byteArray) {
			resultCharArray[index++] = hexDigits[b >>> 4 & 0xf];
			resultCharArray[index++] = hexDigits[b & 0xf];
		}
		return new String(resultCharArray);
	}

}
