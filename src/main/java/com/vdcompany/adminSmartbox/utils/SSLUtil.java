package com.vdcompany.adminSmartbox.utils;

import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLSocketFactory;
import javax.net.ssl.TrustManagerFactory;
import java.io.*;
import java.security.KeyManagementException;
import java.security.KeyStore;
import java.security.KeyStoreException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.Certificate;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;

/**
 * @author han, sung-ku
 * @since 2017. 9. 14.
 * @version 1.0
 */
public class SSLUtil {
	
	/**
	 * @return
	 * @throws CertificateException 
	 * @throws IOException 
	 * @throws KeyStoreException 
	 * @throws NoSuchAlgorithmException 
	 * @throws KeyManagementException 
	 */
	public static SSLSocketFactory buildSslSocketFactory(String certPath) throws CertificateException, IOException, KeyStoreException, NoSuchAlgorithmException, KeyManagementException {
		CertificateFactory cf = CertificateFactory.getInstance("X.509");
		Certificate ca;

		try(InputStream caInput = new BufferedInputStream(new FileInputStream(new File(certPath)));) {
			ca = cf.generateCertificate(caInput);
		}

		String keyStoreType = KeyStore.getDefaultType();
		KeyStore keyStore = KeyStore.getInstance(keyStoreType);
		keyStore.load(null, null);
		keyStore.setCertificateEntry("ca", ca);

		String tmfAlgorithm = TrustManagerFactory.getDefaultAlgorithm();
		TrustManagerFactory tmf = TrustManagerFactory.getInstance(tmfAlgorithm);
		tmf.init(keyStore);

		SSLContext context = SSLContext.getInstance("TLS");
		context.init(null, tmf.getTrustManagers(), null);
		return context.getSocketFactory();

	}



}
