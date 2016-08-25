package 基础算法.遍历.图遍历;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class Graph {
	Map<String, Set<String>> map = new HashMap<String, Set<String>>();
	private int e = 0;

	public Graph(File f) throws IOException {
		Scanner sc = new Scanner(f);
		int v = Integer.parseInt(sc.nextLine());
		int e = Integer.parseInt(sc.nextLine());
		for (int i = 0; i < e; i++) {
			String[] split = sc.nextLine().split(" ");

			String v1 = split[0];
			String v2 = split[1];
			if (map.get(v1) == null)
				map.put(v1, new HashSet<String>());
			if (map.get(v2) == null)
				map.put(v2, new HashSet<String>());
			addEdge(v1, v2);
		}
		sc.close();
	}

	public int V() {
		return map.keySet().size();
	}

	public int E() {
		return e;
	}

	public void addEdge(String v, String w) {
		map.get(v).add(w);
		map.get(w).add(v);
		e++;
	}
	public Iterable<String> getAllvertexs(){
		return map.keySet();
	}
	public Iterable<String> adj(String v) {
		return map.get(v);
	}

	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("v = " + V() + "\n");
		sb.append("e = " + E() + "\n");
		for (String key : map.keySet()) {
			sb.append(key + ": [ ");
			for (String t : map.get(key)) {
				sb.append(t + " ");
			}
			sb.append("]\n");
		}
		return sb.toString();
	}

}
