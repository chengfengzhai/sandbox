import java.util.Date;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtsTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();
		String result = encoder.encode("Alice");
		System.out.println("Encoded password of Alice: " + result);

		result = encoder.encode("Bob");
		System.out.println("Encoded password of Bob: " + result);

		String jwtSecret="admindemoSecretKey";
		String jwtToken = Jwts.builder()
        .setSubject(("test"))
        .setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + 3600*24*1000))
        .signWith(SignatureAlgorithm.HS512, jwtSecret)
        .compact();
		System.out.println("Jwt token: " + jwtToken);
		
		//String authToken = "eyJhbGciOiJIUzUxMiJ9.eyJzdWIiOiJBbGljZSIsImlhdCI6MTY0NDAyNTI3NiwiZXhwIjoxNjQ0MDYxMjc2fQ.-spKbHPJdnpRLcli6FPMZclU_ubioaQZVa3t8GkmDwBObbc1kak0zIuIbN8MRe9xueuxxRanZJmkzOPegOiobw";
		try {
			Jws<Claims> claim = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(jwtToken);
			System.out.println("Signature: " + claim.getSignature());
			System.out.println("body: " + claim.getBody());
			System.out.println("header: " + claim.getHeader());
		} catch(Exception e) {
			e.printStackTrace();
		}
	}

}
