package id.grocery.tunas.security.filter;

import com.auth0.jwt.algorithms.Algorithm;

public class TokenGenerationAlgorithm {
    public static Algorithm algorithm = Algorithm.HMAC256("Secret".getBytes());
}
