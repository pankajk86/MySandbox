package google;

import java.util.HashSet;
import java.util.Set;

public class RobotRoomCleaner {

	private static int[][] dirs = { { 1, 0 }, { 0, 1 }, { -1, 0 }, { 0, -1 } };
	
	public static void main(String[] args) {
		Robot robot = new RobotImpl();
		cleanRoom(robot);
	}

	private static void cleanRoom(Robot robot) {
		Set<String> visited = new HashSet<>();
		dfs(robot, visited, 0, 0, 0);
	}

	private static void dfs(Robot robot, Set<String> visited, int x, int y, int dir) {
		String path = x + "-" + y;
		if(visited.contains(path)) return;
		
		visited.add(path);
		robot.clean();
		
		for(int i = 0; i < 4; i++) {
			if(robot.move()) {
				dfs(robot, visited, x + dirs[dir][0], y + dirs[dir][1], dir);
				robot.turnLeft(); robot.turnLeft();
				robot.move();
				robot.turnLeft(); robot.turnLeft();
			}
			robot.turnRight();
			dir = (dir + 1) % 4;
		}
	}
}

class RobotImpl implements Robot {

	@Override
	public boolean move() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public void turnLeft() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void turnRight() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void clean() {
		// TODO Auto-generated method stub
		
	}
	
}

interface Robot {
	public boolean move();
	public void turnLeft();
	public void turnRight();
	public void clean();
}
