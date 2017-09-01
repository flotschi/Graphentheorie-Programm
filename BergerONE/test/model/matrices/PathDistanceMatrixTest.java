package model.matrices;

/**
 * Created by Neo on 01.01.2017.
 */
public class PathDistanceMatrixTest
{
    public static void main(String[] args)
    {
        Matrices adja = new Matrices(5);

        adja.addEdge(0,4);
        adja.addEdge(0,3);
        adja.addEdge(1,2);
        adja.addEdge(1,4);
        adja.addEdge(1,3);

        Matrices path = adja.thePath();
        Matrices dist = adja.theDistance();
        System.out.println( "adja" );
        System.out.println( adja );
        System.out.println( "path" );
        System.out.println( path );
        System.out.println( "dist" );
        System.out.println( dist );

    }
}
