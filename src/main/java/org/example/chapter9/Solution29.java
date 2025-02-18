package org.example.chapter9;

import java.util.Arrays;

public class Solution29 {
    public static void main(String[] args){
        int[][] nodeinfo = {{5, 3}, {11, 5}, {13, 3}, {3, 5}, {6, 1}, {1, 3}, {8, 6}, {7, 2}, {2, 2}};
        int[][] result = solution(nodeinfo);

        for (int i = 0; i< result.length; i++){
            for (int j = 0; j<result[i].length; j++){
                System.out.print(result[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static int i = 0;

    public static class Tree {
        public int x, y, value;
        public Tree left = null, right = null;

        public Tree(int x, int y, int value){
            this.x = x;
            this.y = y;
            this.value = value;
        }
    }

    public static int[][] solution(int[][] nodeinfo){
        Tree[] trees = new Tree[nodeinfo.length];
        for (int i = 0; i< nodeinfo.length; i++){
            Tree tree = new Tree(nodeinfo[i][0], nodeinfo[i][1], i+1);
            trees[i] = tree;
        }

        Arrays.sort(trees, (o1, o2) -> {
            if(o1.y == o2.y) return Integer.compare(o1.x, o2.x);
            return Integer.compare(o2.y, o1.y);
        });

        /*for (int i = 0; i< trees.length; i++){ // 틀린 풀이(트리 설정)
            Tree curNode = trees[i];
            for (int j = i+1; j< trees.length; j++){
                Tree nextNode = trees[j];
                if(nextNode.y == curNode.y) continue;
                if(nextNode.x< curNode.x && curNode.left == null) curNode.left = nextNode;
                else if (nextNode.x> curNode.x && curNode.right == null) {
                    curNode.right = nextNode;
                    break;
                }
            }
        }*/

        for (int i = 1; i< trees.length; i++){ // 이진 트리를 설정하는 알고리즘(왼쪽과 오른쪽을 나누는 기준이 무엇인지 알아내는 것이 중요!!)
            Tree rootNode = trees[0];
            while (true){
                if(trees[i].x< rootNode.x) {
                    if(rootNode.left == null){
                        rootNode.left = trees[i];
                        break;
                    }
                    else rootNode = rootNode.left;
                }
                else {
                    if(trees[i].x> rootNode.x){
                        if(rootNode.right == null){
                            rootNode.right = trees[i];
                            break;
                        }
                        else rootNode = rootNode.right;
                    }
                }

            }
        }

        int[][] result = new int[2][trees.length];
        preorder(result, trees[0]);
        i = 0;
        postorder(result, trees[0]);

        return result;
    }

    public static void preorder(int[][] result, Tree rootNode){
        if(rootNode == null) return;
        result[0][i] = rootNode.value;
        i++;
        preorder(result, rootNode.left);
        preorder(result, rootNode.right);
    }

    public static void postorder(int[][] result, Tree rootNode){
        if(rootNode == null) return;
        postorder(result, rootNode.left);
        postorder(result, rootNode.right);
        result[1][i] = rootNode.value;
        i++;
    }
}
