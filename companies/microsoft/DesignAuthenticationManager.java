package microsoft;

import java.util.HashMap;
import java.util.Map;

public class DesignAuthenticationManager {

    public static void main(String[] args) {
        AuthenticationManager instance = new AuthenticationManager(5);
        instance.renew("aaa", 1);
        instance.generate("aaa", 2);

        int count = instance.countUnexpiredTokens(6);
        System.out.println(count);

        instance.generate("bbb", 7);
        instance.renew("aaa", 8);
        instance.renew("bbb", 10);

        count = instance.countUnexpiredTokens(15);
        System.out.println(count);
    }
}


class AuthenticationManager {

    private final int ttl;
    private final Map<String, Token> map = new HashMap<>();
    private final Dll list = new Dll();

    public AuthenticationManager(int timeToLive) {
        this.ttl = timeToLive;
    }

    public void generate(String tokenId, int currentTime) {
        int expiryTime = currentTime + ttl;
        Token token = new Token(tokenId, expiryTime);
        map.put(tokenId, token);
        list.add(token);
    }

    public void renew(String tokenId, int currentTime) {
        Token token = map.get(tokenId);
        if (token != null && token.expiryTime > currentTime) {
            list.remove(token);
            token.expiryTime = currentTime + ttl;
            list.add(token);
        }
    }

    public int countUnexpiredTokens(int currentTime) {
        while (list.getHead().expiryTime <= currentTime && list.getHead().expiryTime != -1) {
            Token expiredToken = list.getHead();
            list.remove(expiredToken);
            map.remove(expiredToken.tokenId);
        }
        return map.size();
    }
}


class Token {
    String tokenId;
    int expiryTime;

    Token prev, next;

    public Token(String tokenId, int expiryTime) {
        this.tokenId = tokenId;
        this.expiryTime = expiryTime;
    }
}

class Dll {
    Token head, tail;

    public Dll() {
        head = new Token(null, -1);
        tail = new Token(null, -1);
        head.next = tail;
        tail.prev = head;
    }

    public void add(Token token) {
        token.next = tail;
        token.prev = tail.prev;
        tail.prev.next = token;
        tail.prev = token;
    }

    public void remove(Token token) {
        token.prev.next = token.next;
        token.next.prev = token.prev;
    }

    public Token getHead() {
        return head.next;
    }
}