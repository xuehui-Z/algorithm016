class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] position = {0, 0};
        int[][] dircs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        int dirc = 0;
        int result = 0;

        Set<String> obstaclesSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesSet.add(obstacles[i][0] + "*" + obstacles[i][1]);
        }

        for (int command : commands) {
            if (command == -1) {
                dirc = (dirc + 1) % 4;
            } else if (command == -2) {
                dirc = (dirc + 3) % 4;
            } else {
                int x = dircs[dirc][0];
                int y = dircs[dirc][1];
                for (int k = 0; k < command; k++) {
                    String post = (position[0] + x) + "*" + (position[1] + y);
                    if (!obstaclesSet.contains(post)) {
                        position[0] += x;
                        position[1] += y;
                        result = Math.max(result, position[0] * position[0] + position[1] * position[1]);
                    }
                }
            }
        }
        return result;
    }

}
