package model.Algo;

import model.matrices.Matrices;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Neo on 01.01.2017.
 */
public class AlgoImplTest
{

    public static void main(String[] args) {

        Matrices adja = new Matrices(11);
        adja.addEdge(0,1);
        adja.addEdge(0,2);
      //  adja.addEdge(0,5);
      //  adja.addEdge(1,7);
        adja.addEdge(2,3);
        adja.addEdge(2,4);
        adja.addEdge(3,4);
        adja.addEdge(4,5);
        adja.addEdge(4,6);
        // adja.addEdge(4,10);
        adja.addEdge(6,7);
      //  adja.addEdge(7,8);
        adja.addEdge(10,9);
        adja.addEdge(9,8);



        AlgoImpl result = new AlgoImpl();
        AlgoImpl algo = new AlgoImpl();
        algo.calcDistancePath(adja, result);
        algo.calcComponents(result.getPath(), result); //als 1. calcComponents vor Excentricity
        algo.calcEccentricity(result.getDistance(), result.getNumComponents(), result);
        algo.calcRadius(result.getEccentricity(), result.getNumComponents(), result);
        algo.calcDiameter(result.getEccentricity(), result.getNumComponents(),result);
        algo.calcCenter(result.getEccentricity(), result.getRadius(), result.getNumComponents(), result);
        algo.calcComponents(result.getPath(), result);
        algo.calcBridges(adja, result.getComponents().size(), result);
        algo.calcArticulations(adja,result.getNumComponents(), result);

        System.out.println("Potent");
        System.out.println(result.getPotent());

        System.out.println("Path");
        System.out.println(result.getPath());

        System.out.println("Distance");
        System.out.println(result.getDistance());

        System.out.println("Eccentricities");
        System.out.println(Arrays.toString(result.getEccentricity()));

        System.out.println("\nRadius");
        System.out.println(result.getRadius());

        System.out.println("\nDiameter");
        System.out.println(result.getDiameter());

        System.out.println("\nCenter");
        System.out.println(result.getCenter());

        System.out.println("\nComponents");
        System.out.println(result.getComponents().size());
        prettyPrint (result.getComponents());

        System.out.println("\nBridges");
        prettyPrint(result.getBridges());

        System.out.println("\nArticulations");
        System.out.println(result.getArticulations());
    }

    private static void prettyPrint(List<int[]> list)
    {

        for (int[] arr : list)
        {
            System.out.println( Arrays.toString(arr));
        }
    }

}
