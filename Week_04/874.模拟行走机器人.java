/**
	思路：遍历数组依次执行指令
*/
class Solution {
    public int robotSim(int[] commands, int[][] obstacles) {
        int[] position = {0, 0};
        int[][] dircs = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}}; //定义四个方向，↑ → ↓ ←，按顺时针方向排布。
        int dirc = 0;
        int result = 0;

        Set<String> obstaclesSet = new HashSet<>();
        for (int i = 0; i < obstacles.length; i++) {
            obstaclesSet.add(obstacles[i][0] + "*" + obstacles[i][1]);
        }

        for (int command : commands) {
            if (command == -1) { //右转
                dirc = (dirc + 1) % 4;  //即下一个方向，在数组中就是下标加一，如果是最后一个则变成第一个。
            } else if (command == -2) {
                dirc = (dirc + 3) % 4;
            } else { //不转方向，前进
                int x = dircs[dirc][0];
                int y = dircs[dirc][1];
                for (int k = 0; k < command; k++) { //预判下一个格子是不是障碍物
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
