package me.qingkou.superws;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

public class WordSearch {
    public enum Mode {WRAP, NO_WRAP}
    private WordGrid grid;

    public WordSearch(int rowNum, int colNum, Mode mode, String... strings) throws Exception {
        final Character[][] charArr;
        charArr = new Character[rowNum][colNum];
        for(int i = 0; i < rowNum; i++) {
            charArr[i] = toBoxedCharArray(strings[i].toCharArray());
        }
        switch (mode) {
            case NO_WRAP: grid = new NoWrapWordGrid(charArr); break;
            case WRAP:    grid = new WrapWordGrid(charArr); break;
            default:      throw new Exception("Unsupported mode");
        }
    }

    public List<Position> search(String target) {
        final Character[][] arr = grid.getCharArr();
        for(int i = 0; i < arr.length; i ++) {
            for(int j = 0; j < arr[i].length; j ++) {
                List<Position> list = singleSearch(new Position(i, j), target);
                if(list != null) return list;
            }
        }
        return null;
    }

    private List<Position> singleSearch(final Position pos, final String target) {
        char[] targetArr = target.toCharArray();
        for(Direction direction : Direction.values()) {
            List<Position> result = new ArrayList<Position>();
            for(int i = 0; i < targetArr.length; i ++) {
                Position p = pos.offset(direction, i);
                Character c = grid.getCharByPosition(p);
                if(c == null) break;
                if(result.contains(p)) break;
                if(c == targetArr[i]) result.add(p);
            }
            if(result.size() == targetArr.length) return result;
        }
        return null;
    }

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new FileReader(args[0]));
        // scan row and column
        String rowColumn = br.readLine();
        int rows = Integer.valueOf(rowColumn.split(" ")[0]);
        int cols = Integer.valueOf(rowColumn.split(" ")[1]);
        // scan strings
        String[] sArr = new String[rows];
        for(int i = 0; i < rows; i++) {
            sArr[i] = br.readLine();
        }
        // scan mode
        String m = br.readLine();
        Mode mode = null;
        if(m.equals("WRAP")) {
            mode = Mode.WRAP;
        } else if(m.equals("NO_WRAP")) {
            mode = Mode.NO_WRAP;
        }
        // scan search target number
        int targetNumber = Integer.valueOf(br.readLine());
        // scan target
        String[] targets = new String[targetNumber];
        for(int i = 0; i < targetNumber; i++) {
            targets[i] = br.readLine();
        }
        // begin search
        WordSearch ws = new WordSearch(rows, cols, mode, sArr);
        for(String target : targets) {
            List<Position> result = ws.search(target);
            if(result == null) {
                System.out.println("NOT FOUND");
            } else {
                System.out.print(result.get(0));
                System.out.println(result.get(result.size() - 1));
            }
        }
    }

    private static Character[] toBoxedCharArray(char[] chars) {
        Character[] ch = new Character[chars.length];
        for(int i = 0; i < chars.length; i++) {
            ch[i] = chars[i];
        }
        return ch;
    }
}
