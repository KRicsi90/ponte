package hu.ponte.hr;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyFactory;
import java.security.Signature;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Base64;


public class SignatureGenerator {
	public String createSign() throws Exception {
		String input = "{\"head\":\"SomeJsonData\"}";
		byte[] keyBytes = Files.readAllBytes(Paths.get("src/main/resources/config/keys/key.private"));
        String base64Signature = signSHA256RSA(input,keyBytes);
        System.out.println("Signature="+base64Signature);
		return base64Signature;
	}
	private static String signSHA256RSA(String input, byte[] keyBytes) throws Exception {
        byte[] b1 = Base64.getEncoder().encode(keyBytes);
        PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(b1);
        KeyFactory kf = KeyFactory.getInstance("RSA");
 
        Signature privateSignature = Signature.getInstance("SHA256withRSA");
        privateSignature.initSign(kf.generatePrivate(spec));
        byte[] s = privateSignature.sign();
        return Base64.getEncoder().encodeToString(s);
    }
}