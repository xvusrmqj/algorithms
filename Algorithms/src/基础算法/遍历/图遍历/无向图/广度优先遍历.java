package 基础算法.遍历.图遍历.无向图;

import java.io.File;
import java.io.IOException;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Set;

import 基础算法.遍历.图遍历.Graph;

public class 广度优先遍历 {
	static Set<String> marker = new HashSet<>();
	static LinkedList<String> queue = new LinkedList<>();

	public static void main(String[] args) throws IOException {
		String path = "src/基础算法/遍历/图遍历/tinyG.txt";
		File f = new File(path);
		Graph g = new Graph(f);

		for (String v : g.getAllvertexs()) {
			if (!marker.contains(v)) {
				queue.add(v);
				widthSearch(g, v);
			}
		}
	}

	static void widthSearch(Graph g, String v) {
		while (!queue.isEmpty()) {
			String remove = queue.remove();
			marker.add(remove);
			System.out.println(remove);
			for (String s : g.adj(remove)) {
				if (!marker.contains(s)&&!queue.contains(s))
					queue.add(s);
			}
		}

	}
}
