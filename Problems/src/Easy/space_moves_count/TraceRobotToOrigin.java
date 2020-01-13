package Easy.space_moves_count;

/*
There is a robot starting at position (0, 0), the origin, on a 2D plane. Given a sequence of its moves, judge if this
robot ends up at (0, 0) after it completes its moves.

The move sequence is represented by a string, and the character moves[i] represents its ith move. Valid moves are
R (right), L (left), U (up), and D (down). If the robot returns to the origin after it finishes all of its moves, return true.
Otherwise, return false.

Note: The way that the robot is "facing" is irrelevant. "R" will always make the robot move to the right once,
"L" will always make it move left, etc. Also, assume that the magnitude of the robot's movement is the same for each move.

Example 1:

Input: "UD"
Output: true
Explanation: The robot moves up once, and then down once. All moves have the same magnitude, so it ended up at the
origin where it started. Therefore, we return true.
 */

// successful submission on first try - aprox 10 min to solve :)
public class TraceRobotToOrigin {

    public static boolean judgeCircle(String moves) {
        char[] c = moves.toCharArray();
        int vertical = 0, horizontal = 0;

        for(Character ch : c) {   // you can use char c : moves.toCharArray to spare the char[] c array.
            switch(ch) {
                case 'D': {
                    vertical--;
                    break;
                }
                case 'U': {
                    vertical++;
                    break;
                }
                case 'L': {
                    horizontal--;
                    break;
                }
                case 'R': {
                    horizontal++;
                    break;
                }
            }
        }
        if(vertical == 0 && horizontal == 0)   // you can return the condition for less lines
            return true;
        else
            return false;
    }

    /* LeetCode Solution:
     public boolean judgeCircle(String moves) {
        int x = 0, y = 0;
        for (char move: moves.toCharArray()) {
            if (move == 'U') y--;
            else if (move == 'D') y++;
            else if (move == 'L') x--;
            else if (move == 'R') x++;
        }
        return x == 0 && y == 0;
    }
     */

    public static void main(String[] args) {
        String s = new String("DDRRUULL");
        System.out.println(judgeCircle(s));
    }
}
