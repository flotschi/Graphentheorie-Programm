package model.matrices;

/**
 * Created by Neo on 01.01.2017.
 */
public class AdjacencyTest
{
    public static void main(String[] args)
    {
        Matrices adja = new Matrices(5);
        // adja.setValue( 0,1,1);
        // adja.setValue( 0,2,1);
        adja.addEdge(0, 1);
        adja.addEdge(0, 2);
        adja.addEdge(0, 3);
        System.out.println(adja);

    }
}
