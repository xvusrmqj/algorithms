package 基础算法.遍历.图遍历.无向图;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

import 基础算法.遍历.图遍历.Graph;

public class 深度优先遍历 {
	static Set<String> marker = new HashSet<>();

	public static void main(String[] args) throws IOException {
		String path = "src/基础算法/遍历/图遍历/tinyG.txt";
		File f = new File(path);
		Graph g = new Graph(f);
		for (String v : g.getAllvertexs()) {
			if(!marker.contains(v)){
				depthSearch(g, v);
			}
		}
	}

	static void depthSearch(Graph g, String v) {
		marker.add(v);
		System.out.println(v);
		for (String s : g.adj(v)) {
			if (!marker.contains(s))
				depthSearch(g, s);
		}
	}
}
