package model.matrices;

/**
 * Created by Neo on 01.01.2017.
 */
public class MultiplyTest
{
    public static void main(String[] args) {


        Matrices adja = new Matrices(4);
        // adja.setValue( 0,1,1);
        // adja.setValue( 0,2,1);
        adja.addEdge(0, 1);
        adja.addEdge(1, 2);
        adja.addEdge(2, 3);
        // adja.addEdge(3, 4);
        //System.out.println(adja);


        Matrices result = new Matrices(4);
        Matrices potent = new Matrices(4);
        Matrices tmp = potent;

        //p2
        adja.multiply(adja, potent);
        //  System.out.println(result);

        //p3
        potent.multiply(adja, result);
        //    tmp = potent;
        //    potent = result;
        //    result = tmp;

        //p4
        //   potent.multiply(adja, result);


        System.out.println(result);

        result = new Matrices(4);
        potent = new Matrices(4);

        // Loop based
        //multiply till pn-1
        adja.multiply(adja, potent);
        for (int i = 0; i < adja.getNodes()-2; i++)
        {
            potent.multiply(adja, result);
            tmp = potent;
            potent = result;
            result = tmp;
        }
        System.out.println(result);

    }

}
