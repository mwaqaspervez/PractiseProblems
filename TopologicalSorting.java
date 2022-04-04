package com.demo.assessment.Problems;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a dependency where for java packages p1,p2,p3
 * p1:{p2,p3}
 * p2:{p3}
 * p3:{}
 * This means p1 can be compiled when compilation of p2 and p3 done
 * p2 can compile when p3 is compiled
 * p3 can start as it does not have any dependence.
 * Figure out strategy to find the order of compilation of processes.
 */
public class TopologicalSorting {

    public static void main(String[] args) {
        Graph graph = new Graph(3);
        graph.add(0, 1);
        graph.add(0, 2);
        graph.add(1, 2);
        graph.print(graph.topologicalSort());
    }

    private static class Graph {
        int vertices;
        List<List<Integer>> edges = new ArrayList<>();

        public Graph(int v) {
            this.vertices = v;
            for (int i = 0; i < v; i++) {
                edges.add(new ArrayList<>());
            }
        }

        public void add(int v, int e) {
            this.edges.get(v).add(e);
        }

        private void topologicalSort(boolean[] visited, int v, Stack<Integer> stack) {
            visited[v] = true;
            for (int i = 0; i < edges.get(v).size(); i++) {
                if (!visited[i]) {
                    topologicalSort(visited, i, stack);
                }
            }
            stack.push(v);
        }

        public Stack<Integer> topologicalSort() {
            int v = this.vertices;
            boolean[] visited = new boolean[v];
            Stack<Integer> stack = new Stack<>();

            for (int i = 0; i < v; i++) {
                if (!visited[i]) {
                    topologicalSort(visited, i, stack);
                }
            }

            return stack;
        }

        public void print(Stack<Integer> stack) {
            Stack<Integer> temp = stack;
            while (!temp.isEmpty()) {
                System.out.println(temp.pop() + "");
            }
        }
    }
}
