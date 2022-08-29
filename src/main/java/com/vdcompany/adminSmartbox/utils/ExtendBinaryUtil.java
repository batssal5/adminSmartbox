package com.vdcompany.adminSmartbox.utils;



import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.regex.Pattern;

public class ExtendBinaryUtil {
	private static final Pattern pattern = Pattern.compile("[ -]");
	private static final char[] base = new char[]{'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F'};

	public ExtendBinaryUtil() {
	}

	private static int charVal(char a) {
		if ('0' <= a && a <= '9') {
			return a - 48;
		} else if ('a' <= a && a <= 'f') {
			return a - 97 + 10;
		} else if ('A' <= a && a <= 'F') {
			return a - 65 + 10;
		} else {
			throw new RuntimeException("Invalid hex character: " + a);
		}
	}
/*

	public static byte[] decodeHex(String hexstring) {
		String hex = pattern.matcher(hexstring).replaceAll("");
		byte[] bts = new byte[hex.length() / 2];

		for(int i = 0; i < bts.length; ++i) {
			bts[i] = (byte)(charVal(hex.charAt(2 * i)) * 16 + charVal(hex.charAt(2 * i + 1)));
		}

		return bts;
	}

	public static String encodeHex(byte[] bytes) {
		char[] chars = new char[bytes.length * 2];

		for(int i = 0; i < bytes.length; ++i) {
			int b = bytes[i] & 255;
			chars[2 * i] = base[b >>> 4];
			chars[2 * i + 1] = base[b & 15];
		}

		return new String(chars);
	}
*/

	public static byte[] getBytes(String data, String charset, int length) throws UnsupportedEncodingException {
		ByteBuffer buffer = null;

		byte[] var6;
		try {
			buffer = ByteBuffer.allocate(length);
			if (data == null) {
				var6 = buffer.array();
				return var6;
			}

			byte[] bytes = data.getBytes(charset);
			if (bytes.length < length) {
				buffer.put(bytes, 0, bytes.length);
			} else {
				buffer.put(bytes, 0, length);
			}

			var6 = buffer.array();
		} finally {
			buffer.clear();
			buffer = null;
		}

		return var6;
	}

	public static byte[] getBytes(byte[] bytes, int length) throws UnsupportedEncodingException {
		ByteBuffer buffer = null;

		byte[] var4;
		try {
			buffer = ByteBuffer.allocate(length);
			if (bytes != null) {
				if (bytes.length < length) {
					buffer.put(bytes, 0, bytes.length);
				} else {
					buffer.put(bytes, 0, length);
				}

				var4 = buffer.array();
				return var4;
			}

			var4 = buffer.array();
		} finally {
			buffer.clear();
			buffer = null;
		}

		return var4;
	}
/*
	@SneakyThrows
	public static String byteToString(ByteBuffer buffer, int size, String charset) throws IOException {
		int pos = buffer.position();
		Throwable var4 = null;
		Object var5 = null;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();

			Throwable var10000;
			label213: {
				boolean var10001;
				String var21;
				try {
					int idx = 0;

					while(true) {
						if (idx < size) {
							byte b = buffer.get();
							if (b != 0) {
								baos.write(b);
								++idx;
								continue;
							}
						}

						buffer.position(pos + size);
						var21 = new String(baos.toByteArray(), charset);
						break;
					}
				} catch (Throwable var19) {
					var10000 = var19;
					var10001 = false;
					break label213;
				}

				if (baos != null) {
					baos.close();
				}

				label202:
				try {
					return var21;
				} catch (Throwable var18) {
					var10000 = var18;
					var10001 = false;
					break label202;
				}
			}

			var4 = var10000;
			if (baos != null) {
				baos.close();
			}

			throw var4;
		} catch (Throwable var20) {
			if (var4 == null) {
				var4 = var20;
			} else if (var4 != var20) {
				var4.addSuppressed(var20);
			}

			throw var4;
		}
	}*/

	public static byte[] nullPadding(String src, int len) throws Exception {
		byte[] des = new byte[len];
		byte[] srcByte = src.getBytes();
		int size = srcByte.length > len ? len : srcByte.length;

		for(int i = 0; i < size; ++i) {
			des[i] = srcByte[i];
		}

		return des;
	}


	/**
	 * @param data
	 * @param start
	 * @return
	 */
	public static int byteToInt(byte[] data, int start) {
		return byteToInt(data, null, start);

	}

	/**
	 * @param data
	 * @return
	 */
	public static byte[] intToByte(int data) {
		return intToByte(data, null);

	}


	/**
	 * @param data data
	 * @param order order
	 * @param start start
	 * @return int
	 */
	public static int byteToInt(byte[] data, ByteOrder order, int start) {
		int size = Integer.SIZE / 8;
		ByteBuffer buff = ByteBuffer.allocate(size);

		for(short idx=0; idx < size; idx++) {
			if(idx <= data.length - 1) {
				buff.put(data[start + idx]);

			} else {
				buff.put((byte)'\0');

			}


		}

		if(order != null) {
			buff.order(order);

		}

		buff.flip();

		return buff.getInt();

	}


	/**
	 * @param data data
	 * @param order order
	 */
	public static byte[] intToByte(int data, ByteOrder order) {
		int size = Integer.SIZE / 8;
		ByteBuffer buff = ByteBuffer.allocate(size);

		buff.putInt(data);

		if(order != null) {
			buff.order(order);

		}

		buff.flip();

		return buff.array();

	}


	/**
	 * @param value
	 * @return
	 */
	public static String binaryEncode(int value) {
		return String.format("%32s", Integer.toBinaryString(value)).replace(' ', '0');

	}


	/**
	 * @param value value
	 * @return String
	 */
	public static String binaryEncode(long value) {
		return String.format("%64s", Long.toBinaryString(value)).replace(' ', '0');
	}

	public static boolean toBitDigitValue(long value, int bitDigit) {
		long bitVal = (long)Math.pow(2, bitDigit);
		return (value & bitVal) == bitVal;
	}


	public static byte[] shortTobytes(short value, boolean littleEndian) {
		byte[] bytes = new byte[2];
		if(littleEndian) {
			bytes[0] = (byte) value;
			bytes[1] = (byte) (value >> 8);
		} else {
			bytes[0] = (byte) (value >> 8);
			bytes[1] = (byte) value;
		}

		return bytes;
	}
}
