package isamm.ingenieur.deuxieme.bdmm.bibliothequemultim�dia.utilities;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

public class EncryptUtils {
	public static String base64decode(String text) {
		String key = "FFsdsdOKOD56sdf5KLDJSVL55s@#fdsojQSD";
		try {
			String decoded = new String(dec.decodeBuffer(text),
					DEFAULT_ENCODING);
			decoded = xorMessage(decoded, key);
			return decoded;
		} catch (IOException e) {
			return null;
		}

	}// base64decode

	public static String base64encode(String text) {
		String key = "FFsdsdOKOD56sdf5KLDJSVL55s@#fdsojQSD";
		try {
			text = xorMessage(text, key);
			String rez = enc.encode(text.getBytes(DEFAULT_ENCODING));
			return rez;
		} catch (UnsupportedEncodingException e) {
			return null;
		}
	}

	public static String xorMessage(String message, String key) {
		try {
			if (message == null || key == null)
				return null;

			char[] keys = key.toCharArray();
			char[] mesg = message.toCharArray();

			int ml = mesg.length;
			int kl = keys.length;
			char[] newmsg = new char[ml];

			for (int i = 0; i < ml; i++) {
				newmsg[i] = (char) (mesg[i] ^ keys[i % kl]);
			}// for i
			mesg = null;
			keys = null;
			return new String(newmsg);
		} catch (Exception e) {
			return null;
		}
	}// xorMessage

	private static final String DEFAULT_ENCODING = "UTF-8";

	@SuppressWarnings("restriction")
	private static BASE64Encoder enc = new BASE64Encoder();

	@SuppressWarnings("restriction")
	private static BASE64Decoder dec = new BASE64Decoder();

}// class