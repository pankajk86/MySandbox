package consistent.hash;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ConsistentHashTest {

	public static void main(String[] args) {
		List<Server> servers = getServers();
		int replicas = 4;
		HashFunction hashFunction = new MyMD5();
		
		ConsistentHash<Server> conHash = new ConsistentHash<>(hashFunction, replicas, servers);
		System.out.println(conHash.size());
		
	}

	private static List<Server> getServers() {
		Server s1 = new BaseServerImpl("n1234");
		Server s2 = new BaseServerImpl("n2345");
		Server s3 = new BaseServerImpl("n3456");
		Server s4 = new BaseServerImpl("n4567");
		Server s5 = new BaseServerImpl("n5678");
		
		List<Server> servers = new ArrayList<>();
		servers.addAll(Arrays.asList(s1, s2, s3, s4, s5));
		return servers;
	}
	
}
