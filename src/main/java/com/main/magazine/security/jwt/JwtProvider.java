package com.main.magazine.security.jwt;

import com.main.magazine.security.services.UserDetailsImpl;
import io.jsonwebtoken.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.time.Instant;;
import java.time.temporal.ChronoUnit;
import java.util.Base64;
import java.util.Date;

@Component
public class JwtProvider {
	private static final Logger logger = LoggerFactory.getLogger(JwtProvider.class);

	PrivateKey privateKey = getPrivateKey();
	PublicKey publicKey = getPublicKey();

	public JwtProvider() throws InvalidKeySpecException, NoSuchAlgorithmException { }

	private PrivateKey getPrivateKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String rsaPrivateKey =
						"-----BEGIN PRIVATE KEY-----" +
						"MIIEvQIBADANBgkqhkiG9w0BAQEFAASCBKcwggSjAgEAAoIBAQDmPYCjbalvBn+3" +
						"uaDKcIWzK9rhn5FDUVazlCO+ub/tjpAZ7RSZc2Uxa3OcL08XD3J3pKr68/fpvy3D" +
						"BBfGW2dJpeZ5VFJxBje8u98BadClMlL3/q+UofrWryaj9pSAuFfXC903vNiGFgfw" +
						"c3kkFACOb2zn6QmxbNzT+qRlEVqZ0ZY/8jqxEXRww3Rv7gwwQDTW8WjNjiHXmB0s" +
						"YY5GCPlTUWHizYnQRiPICqZ826oY9fjPe870X+imJM9R3d57W1X657a1Di3pWaOe" +
						"uY7QbRnN4jK4ODeKNJwcfUGZ23BIUZycg8walfS7v3B/D4bhP2jIWQw27aK7GVRs" +
						"dRpx60mlAgMBAAECggEAJ90QL7ul8V4rsNDIAST4USxPqm7pRMGJhHAqvDQHAgeD" +
						"9akxvtvW8naLPsiGJhT7mbF+FRM2olcCglhsEWD0AjFiNTGfUIhmEBxrISCECoYr" +
						"DVsgZViiSJds1ki0L5E7TDV2qNbemmCoIT6tA80ex4qNTZ3wmrKhjWZBHmqhyC3I" +
						"dIETvE7rz+7o7ZjQIrPzWWTrPKBXiz6SOQudmIdTqF+a1/xDlNFBBKIkTOHj2Q3r" +
						"ok/S/yvKKWBMZk4T6eZ/JIoVB7NtT9Rtbg8MYwy881g0eTd8GvFX0GiaGWLjkfAC" +
						"Env4FBdgng87E1P/Q2IqZVyRRighEH+3uQhuJhNHBQKBgQD9C6/DR3WKTvalXwkm" +
						"y0my4doRDMH14DRIAJ+S5lzMmgvk8lJdwbkR8bXc0sCsr/gpkyaaUkifj+sRuHnU" +
						"j31O01H+buluoC65o56q249bkAwOIg3cnlNaR5qWLdtKFTP2LBjP28cMDEUHKlPM" +
						"x6lVLdVrAqhv7jy/7VUnUlFKtwKBgQDo7ad3fnxZVrB5rwH18UpjbK5f6GyZcRqo" +
						"IA1dzeKK5nSLosdNg1Sl8/NCBurOPHvXqxMYRijaYEh0mcN3i7+AfK4SqItghhDT" +
						"3C+GE+4OA/bFMGTCJqnxaDjdJYryFm1+UIQD7/J4wBYlri+nnScJQjvTf7pUj1e2" +
						"kcG7EghigwKBgQDogSlxO6KTf7R/BJCLFbTU6VKN4fQB8Iz5L6Fvv7y6vjx5k/H8" +
						"dbiP9VDN4tPomBNkV/HbUAmsmvc5pBBFL8bKe77WEqDn5cSpC98JTI4vam65Oa8U" +
						"7GDYDfzLSr04F71TzvbJXj5JIqj2SX0QJtC/FEsJdTrBBdzJ2M8qPye0hwKBgEWU" +
						"YHdAkHK7g6IF1kcamgcTOw+pRW+cqsLYOEXyL58gcmYX7QNJnOqp8duiZ1fOF4x4" +
						"LQ8OPjvlkR9Lo2k9lKoUFIe8U041Hie7WXLq1yzWoEuNRjv9Arz7Tik5gsUIUBLw" +
						"iE8IyVyqvLLq0o92UWfhoi9us0F5RFFkPwPbwidzAoGAJ/lhVj7P3MxIMuzt7dF+" +
						"+JN3JSlnZYR6G92xF52ZDDmwQ+9vBAlpmZgJMVu9fCw0Jp20MPR/uj8k0fWnv/9a" +
						"gM2vrOnJ7kQwP9hGj/Uur3od8ymKq5vq1LuhdCUEyMAvoNjXdJdGnchJ23M/IZk6" +
						"ynRBqh8Jw/Z0HZMM7H88HNw=" +
						"-----END PRIVATE KEY-----";

		rsaPrivateKey = rsaPrivateKey.replace("-----BEGIN PRIVATE KEY-----", "");
		rsaPrivateKey = rsaPrivateKey.replace("-----END PRIVATE KEY-----", "");

		PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(Base64.getDecoder().decode(rsaPrivateKey));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePrivate(keySpec);
	}

	private PublicKey getPublicKey() throws NoSuchAlgorithmException, InvalidKeySpecException {
		String rsaPublicKey =
						"-----BEGIN PUBLIC KEY-----" +
						"MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEA5j2Ao22pbwZ/t7mgynCF" +
						"syva4Z+RQ1FWs5Qjvrm/7Y6QGe0UmXNlMWtznC9PFw9yd6Sq+vP36b8twwQXxltn" +
						"SaXmeVRScQY3vLvfAWnQpTJS9/6vlKH61q8mo/aUgLhX1wvdN7zYhhYH8HN5JBQA" +
						"jm9s5+kJsWzc0/qkZRFamdGWP/I6sRF0cMN0b+4MMEA01vFozY4h15gdLGGORgj5" +
						"U1Fh4s2J0EYjyAqmfNuqGPX4z3vO9F/opiTPUd3ee1tV+ue2tQ4t6VmjnrmO0G0Z" +
						"zeIyuDg3ijScHH1BmdtwSFGcnIPMGpX0u79wfw+G4T9oyFkMNu2iuxlUbHUacetJ" +
						"pQIDAQAB" +
						"-----END PUBLIC KEY-----";

		rsaPublicKey = rsaPublicKey.replace("-----BEGIN PUBLIC KEY-----", "");
		rsaPublicKey = rsaPublicKey.replace("-----END PUBLIC KEY-----", "");

		X509EncodedKeySpec keySpec = new X509EncodedKeySpec(Base64.getDecoder().decode(rsaPublicKey));
		KeyFactory keyFactory = KeyFactory.getInstance("RSA");
		return keyFactory.generatePublic(keySpec);
	}

	// ********************** Token | Generation *********************** //
	public String generateJwtToken(Authentication authentication) {

		// Get the current logged user | Custom UserDetails
		UserDetailsImpl userPrincipal = (UserDetailsImpl) authentication.getPrincipal();

		return Jwts.builder()
				.setSubject((userPrincipal.getUsername()))
				.claim("Id", userPrincipal.getId())
				.claim("Role", userPrincipal.getAuthorities())
				.claim("Email", userPrincipal.getEmail())
				.setIssuedAt(new Date())
				.setExpiration(Date.from(Instant.now().plus(30L, ChronoUnit.MINUTES))) // Valid for 30 mins
				// .setExpiration(java.sql.Date.valueOf(LocalDate.now().plusDays(14)))
				.signWith(SignatureAlgorithm.RS512, privateKey)
				.compact();
	}

	// ********************** Token | Validation *********************** //
	/**
	 * Validating the JWT allows to verify its authenticity.<br />
	 * By checking its digital signature, <br />
	 * We can check that it is not expired and verify that it hasn’t been modified).<br />
	 * We then can get information about the user sending the token : <strong>claims</strong>.<br />
	 * ----------<br />
	 * If the signature is incorrect, the call to parseClaimsJws will throw a <strong>SignatureException</strong>.
	 * More information : <a href="https://stormpath.com/blog/beginners-guide-jwts-in-java">here</a>
	 */
	public boolean validateJwtToken(String token) {
		try {
			// Sign the token and extract the claims from it
			Jwts.parser()
					.setSigningKey(publicKey)
					.parseClaimsJws(token);
			return true;
		} catch (SignatureException e) {
			logger.error("Invalid JWT signature: {}", e.getMessage());
		} catch (MalformedJwtException e) {
			logger.error("Invalid JWT token: {}", e.getMessage());
		} catch (ExpiredJwtException e) {
			logger.error("JWT token is expired: {}", e.getMessage());
		} catch (UnsupportedJwtException e) {
			logger.error("JWT token is unsupported: {}", e.getMessage());
		} catch (IllegalArgumentException e) {
			logger.error("JWT claims string is empty: {}", e.getMessage());
		}
		return false;
	}

	// ******************** Token | Claims Retrieval ********************** //

	/**
	 * <strong>A claim is a piece of information asserted about a Subject | Current user.</strong><br />
	 * Once the token is valid,<br />
	 * 1. And that we successfully signed it,<br />
	 * 2. We retrieve all the claims asserted to a Subject,<br />
	 * 3. And the Subject itself : subject = username.<br />
	 * Which basically means, that we generate the payload.
	 */
	public String getClaimsAndSubjectFromJwtToken(String token) {
		return Jwts.parser()
				.setSigningKey(publicKey) // 1.
				.parseClaimsJws(token).getBody() // 2.
				.getSubject(); // 3.
	}
}

