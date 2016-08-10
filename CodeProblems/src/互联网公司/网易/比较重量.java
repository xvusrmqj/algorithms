package 互联网公司.网易;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * 
 * 小明陪小红去看钻石，他们从一堆钻石中随机抽取两颗并比较她们的重量。
 * 这些钻石的重量各不相同。在他们们比较了一段时间后，它们看中了两颗
 * 钻石g1和g2。现在请你根据之前比较的信息判断这两颗钻石的哪颗更重。
 * 给定两颗钻石的编号g1,g2，编号从1开始，同时给定关系数组vector,其
 * 中元素为一些二元组，第一个元素为一次比较中较重的钻石的编号，第二个
 * 元素为较轻的钻石的编号。最后给定之前的比较次数n。请返回这两颗钻石
 * 的关系，若g1更重返回1，g2更重返回-1，无法判断返回0。输入数据保证
 * 合法，不会有矛盾情况出现。
 * 测试样例：
 * 2,3,[[1,2],[2,4],[1,3],[4,3]],4
 * 返回: 1
 * 
 * @author lv
 */
public class 比较重量 {
	public static void main(String[] args) {
		int g1 = 12;
		int g2 = 2;
		int n = 136;
		int[][] records = { { 5, 5 }, { 2, 4 }, { 8, 6 }, { 12, 10 }, { 12, 12 }, { 6, 12 }, { 2, 3 }, { 8, 5 },
				{ 7, 5 }, { 5, 5 }, { 3, 10 }, { 11, 11 }, { 12, 12 }, { 10, 11 }, { 7, 3 }, { 2, 3 }, { 11, 5 },
				{ 1, 9 }, { 8, 12 }, { 3, 10 }, { 8, 4 }, { 7, 1 }, { 9, 5 }, { 6, 4 }, { 1, 11 }, { 7, 9 }, { 12, 12 },
				{ 4, 11 }, { 8, 6 }, { 2, 3 }, { 12, 5 }, { 2, 7 }, { 4, 11 }, { 4, 11 }, { 3, 3 }, { 4, 11 }, { 3, 4 },
				{ 8, 1 }, { 10, 9 }, { 4, 5 }, { 6, 9 }, { 8, 10 }, { 7, 11 }, { 12, 5 }, { 2, 12 }, { 1, 9 }, { 7, 3 },
				{ 8, 10 }, { 2, 1 }, { 8, 4 }, { 3, 11 }, { 6, 4 }, { 2, 4 }, { 7, 1 }, { 6, 6 }, { 8, 1 }, { 1, 4 },
				{ 3, 5 }, { 12, 10 }, { 1, 5 }, { 2, 4 }, { 6, 3 }, { 7, 12 }, { 6, 10 }, { 6, 11 }, { 7, 12 },
				{ 7, 4 }, { 9, 5 }, { 2, 11 }, { 2, 6 }, { 6, 5 }, { 8, 5 }, { 1, 9 }, { 6, 4 }, { 7, 1 }, { 1, 1 },
				{ 2, 9 }, { 8, 4 }, { 6, 5 }, { 1, 10 }, { 6, 3 }, { 8, 7 }, { 8, 2 }, { 6, 5 }, { 2, 12 }, { 4, 9 },
				{ 7, 11 }, { 4, 9 }, { 2, 10 }, { 8, 10 }, { 12, 10 }, { 6, 3 }, { 2, 10 }, { 12, 9 }, { 8, 4 },
				{ 2, 12 }, { 7, 11 }, { 9, 5 }, { 3, 5 }, { 2, 5 }, { 7, 9 }, { 8, 10 }, { 7, 9 }, { 4, 4 }, { 2, 3 },
				{ 2, 2 }, { 7, 3 }, { 6, 5 }, { 2, 4 }, { 4, 9 }, { 8, 10 }, { 12, 9 }, { 2, 9 }, { 8, 9 }, { 12, 5 },
				{ 8, 2 }, { 3, 12 }, { 1, 12 }, { 1, 12 }, { 8, 2 }, { 2, 5 }, { 1, 10 }, { 12, 5 }, { 3, 4 },
				{ 8, 11 }, { 2, 12 }, { 8, 2 }, { 10, 11 }, { 8, 3 }, { 2, 7 }, { 8, 6 }, { 1, 10 }, { 7, 12 },
				{ 8, 6 }, { 1, 1 }, { 3, 4 } };
		int cmp = cmp(g1, g2, records, n);
		System.out.println(cmp);
	}

	public static int cmp(int g1, int g2, int[][] records, int n) {
		Graph graph = new Graph();
		//生成图
		for (int i = 0; i < records.length; i++) {
			graph.addEdge(records[i][0], records[i][1]);
		}
		// 看g1比g2重吗?
		int findNext1 = findNext(graph, g1, g2);
		// 看g2比g1重吗?
		int findNext2 = findNext(graph, g2, g1);
		if (findNext1 == 1)
			return 1;
		if (findNext2 == 1)
			return -1;
		// 如果都比不出来就无法比较
		return 0;
	}

	//该集合为判断是否有回路的集合.
	static HashMap<Integer, Integer> map = new HashMap<>();

	public static int findNext(Graph graph, int begin, int target) {
		ArrayList<Integer> values = graph.adj(begin);
		if (values == null || values.size() == 0)
			return 0;
		for (int i = 0; i < values.size(); i++) {
			int val = values.get(i);
			// 找到就不再向下找了.
			if (val == target)
				return 1;
			else {
				//在这里判断是不是有回路. 不回路就跳过.
				if (map.get(val) != null && (map.get(val) == 1 || map.get(val) == begin))
					continue;
				map.put(val, 1);
				int findNext = findNext(graph, val, target);
				// 找到就不再向下找了.
				if (findNext == 1)
					return 1;
			}
		}
		return 0;
	}

	static class Graph {
		//图的邻接表
		HashMap<Integer, ArrayList<Integer>> adjacent = new HashMap<Integer, ArrayList<Integer>>();

		//添加弧i->j
		public void addEdge(int i, int j) {
			if (adjacent.get(i) == null) {
				ArrayList<Integer> list = new ArrayList<>();
				adjacent.put(i, list);
			}
			adjacent.get(i).add(j);
		}

		//邻接集合
		public ArrayList<Integer> adj(int i) {
			return adjacent.get(i);
		}
	}

}
