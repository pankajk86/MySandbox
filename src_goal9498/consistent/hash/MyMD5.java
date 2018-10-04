package consistent.hash;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class MyMD5 implements HashFunction {

	@Override
	public int hash(Object key) {
		
		int hash = -1;

		try {
			ByteArrayOutputStream baos = new ByteArrayOutputStream();
		    ObjectOutputStream oos = new ObjectOutputStream(baos);
		    oos.writeObject(key);
		    oos.close();
			
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(baos.toByteArray());
			BigInteger bigInt = new BigInteger(1, md.digest());
			hash = bigInt.intValue();
			
		} catch (NoSuchAlgorithmException | IOException e) {
			e.printStackTrace();
		}
		
		return hash;
	}

}
