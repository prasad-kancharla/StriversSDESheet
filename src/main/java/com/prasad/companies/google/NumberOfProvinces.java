package com.prasad.companies.google;

class NumberOfProvinces {
//    public int findCircleNum(int[][] isConnected) {
//        int length = isConnected.length;
//        List<List<Integer>> adjacencyList = new ArrayList<>();
//        boolean[] visited = new boolean[length];
//
//        for (int i = 0; i < length; i++) {
//            adjacencyList.add(new ArrayList<>());
//        }
//
//        for (int i = 0; i < length; i++) {
//            for (int j = 0; j < length; j++) {
//                if (isConnected[i][j] == 1) {
//                    adjacencyList.get(i).add(j);
//                    adjacencyList.get(j).add(i);
//                }
//            }
//        }
//
//        int numberOfProvinces = 0;
//
//        for (int i = 0; i < length; i++) {
//            if (!visited[i]) {
//                dfs(i, adjacencyList, visited);
//                numberOfProvinces++;
//            }
//        }
//
//        return numberOfProvinces;
//    }
//
//    private void dfs(int city, List<List<Integer>> adjacencyList, boolean[] visited) {
//        if (visited[city]) {
//            return;
//        }
//
//        visited[city] = true;
//
//        for (int neighbourCity : adjacencyList.get(city)) {
//            if (!visited[neighbourCity]) {
//                dfs(neighbourCity, adjacencyList, visited);
//            }
//        }
//    }

    public int findCircleNum(int[][] isConnected) {
        int length = isConnected.length;
        boolean[] visited = new boolean[length];

        int numberOfProvinces = 0;

        for (int i = 0; i < length; i++) {
            if (!visited[i]) {
                dfs(i, isConnected, visited);
                numberOfProvinces++;
            }
        }

        return numberOfProvinces;
    }

    private void dfs(int city, int[][] isConnected, boolean[] visited) {
        if (visited[city]) {
            return;
        }

        visited[city] = true;

        for (int i = 0; i < isConnected.length; i++) {
            if (isConnected[city][i] == 1 && !visited[i]) {
                dfs(i, isConnected, visited);
            }
        }
    }
}