package com.util;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
public class Dijkstra {

	public class Node{
		/**
		 * �ڵ�ı�ʶ��
		 */
		private Integer identifier;
		/**
		 * �ýڵ��Ƿ񱻷��ʹ�
		 */
		private boolean visited = false;
		/**
		 * �ýڵ��������ڵ��ӳ���ϵ
		 */
		private Map<Node,Integer> mapping = new HashMap<Node,Integer>();
		
		public Integer getIdentifier() {
			return identifier;
		}
		public void setIdentifier(Integer identifier) {
			this.identifier = identifier;
		}
		public boolean isVisited() {
			return visited;
		}
		public void setVisited(boolean visited) {
			this.visited = visited;
		}
		public Map<Node, Integer> getMapping() {
			return mapping;
		}
	}
	
	/**
	 * Getting optimal path by Dijkstra algorithm
	 * @param src
	 * @param dest
	 * @return
	 */
	public static LinkedList<Node> getOptimalPath(Node src, Node dest){
		return dijkstra(src, dest, 0, 0, new LinkedList<Node>());
	}
	
	/**
	 * Dijkstra algorithm
	 * @param src ��ʼ�ڵ�
	 * @param dest Ŀ��ڵ�
	 * @param adjacentDist ��ʼ�ڵ���Ŀ��ڵ�����ʱ�ľ���
	 * @param optimalDist ���·��Ȩֵ֮��
	 * @param optimalPath ���·��
	 * @return
	 */
	private static LinkedList<Node> dijkstra(Node src, Node dest, int adjacentDist, int optimalDist, LinkedList<Node> optimalPath){
		if(optimalPath.size()==0){
			optimalPath.add(src);
		}
		//��ǰ�ڵ��������ڵ��ӳ���ϵ
		Map<Node,Integer> mapping = src.getMapping();
		//��ǰ�ڵ��������ڽڵ����С����
		int partialMinDist = 0;
		//��ǰԤѡ����һ���Žڵ�
		Node partialOptimalNode = null;
		Iterator<Entry<Node, Integer>> entryIterator = mapping.entrySet().iterator();
		while (entryIterator.hasNext()) {
			Entry<Node, Integer> entry = (Entry<Node, Integer>) entryIterator.next();
			Node nextNode = entry.getKey();
			//�жϸ����ڽڵ��Ƿ񱻷��ʹ�
			if (nextNode.isVisited()) continue;
			//������һ�ڵ�ľ���
			int dist = entry.getValue(); 
			//�յ���������ڣ���δ��·�����
			if(nextNode.getIdentifier() == dest.getIdentifier() && optimalPath.size() == 1) adjacentDist = dist;
			if (partialMinDist != 0) {
				boolean currentIsOptimal = partialMinDist > dist ? false : true;
				if(!currentIsOptimal){
					partialMinDist = dist;
					partialOptimalNode = nextNode;
				}
			}else{
				partialMinDist = dist;
				partialOptimalNode = nextNode;
			}
		}
		//���õ�ǰ�ڵ��ѱ�����
		src.setVisited(true);
		//��������
		optimalPath.add(partialOptimalNode);
		optimalDist += partialMinDist;
		if(partialOptimalNode.getIdentifier()!=dest.getIdentifier()){
			//��δ���յ�ʱ��ǰ����·�������Ѵ����յ���������ڵľ��룬�����·��Ϊ���--->�յ�
			if(adjacentDist != 0 && optimalDist > adjacentDist) {
				src = optimalPath.removeFirst();
				optimalPath.clear();
				optimalPath.add(src);
				optimalPath.add(dest);
				optimalDist = adjacentDist;
				return optimalPath;
			}
			//�����Ե�ǰ�ڵ�ݹ�
			return dijkstra(partialOptimalNode, dest, adjacentDist, optimalDist, optimalPath);
		}else{
			return optimalPath;
		}
	}
}


