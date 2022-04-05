package y22.m04.d05;

public class DfsUse {
    public static void main(String args[]) {
        Dfs dfs = new Dfs();
        dfs.init();
        dfs.dfsStack(1);
        System.out.println(dfs.result);

        dfs.init();
        dfs.dfsRecursive(1);
        System.out.println(dfs.result);
    }
}
