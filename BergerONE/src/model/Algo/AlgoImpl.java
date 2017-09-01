package model.Algo;

import model.matrices.Matrices;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Neo on 01.01.2017.
 */
public class AlgoImpl
{
    private Matrices distance;
    private Matrices path;
    private Matrices potent;
    private int[] eccentricity;
    private int radius;
    private int diameter;
    private List<Integer> center;
    private List<int[]> components;
    private List<int[]> bridges;
    private List<Integer> articulations;


    //setter
    public void setDistance(Matrices distance) {
        this.distance = distance;
    }

    public void setPath(Matrices path) {
        this.path = path;
    }

    public void setPotent(Matrices potent) {
        this.potent = this.potent;
    }

    public void setEccentricity(int[] eccentricity) {
        this.eccentricity = eccentricity;
    }

    public void setRadius(int radius) { this.radius = radius; }

    public void setDiameter(int diameter) { this.diameter = diameter; }

    public void setCenter(List<Integer> center) { this.center = center; }

    public void setComponents(List<int[]> components) { this.components = components;}

    public void setBridges(List<int[]> bridges) {
        this.bridges = bridges;
    }

    public void setArticulations(List<Integer> articulations) {
        this.articulations = articulations;
    }




    //getter
    public Matrices getPath() {
        return path;
    }

    public Matrices getDistance() { return distance; }

    public Matrices getPotent() {
        return potent;
    }

    public int[] getEccentricity() { return eccentricity; }

    public int getRadius() { return radius; }

    public int getDiameter() { return diameter; }

    public List<Integer> getCenter() { return center; }

    public List<int[]> getComponents() { return components; }

    public List<int[]> getBridges() {
        return bridges;
    }

    public List<Integer> getArticulations() {
        return articulations;
    }


    //Constructor
    public AlgoImpl()
    {

    }

    public int getNumComponents() {return components.size();}

    public int getNumBridges() {return  bridges.size();}

    public int getNumArticulations() {return articulations.size();}

    public int getNumCenter() {return center.size();}


    public void calcDistancePath(Matrices adja, AlgoImpl bergerResult)
    {
        //init PathMatrix and DistMatrix
        Matrices path = adja.thePath();
        Matrices distance = adja.theDistance();

        // wir brauchen nur dann multiplizieren, wenn wir mind. 3 Knoten haben
        if (adja.nodes >= 3)
        {
            //define variables
            Matrices potent = new Matrices(adja.nodes);
            Matrices result = new Matrices(adja.nodes);

            //multiply p2
            adja.multiply(adja, potent); //=> p hoch 2!!!!!!!!!!
            update(path, distance, potent, 2);

            //multiply pn-1
            for (int i = 3; i < adja.nodes; i++)
            {
                potent.multiply(adja, result);

                //update
                update(path, distance, result, i);

                //swap
                Matrices tmp = potent;
                potent = result;
                result = tmp;
            }
        }

       // bergerResult.setPotent(result); // weil vertauscht wurde oben, deswegen result und nicht potent
        bergerResult.setPath(path);
        bergerResult.setDistance(distance);
    }

    private void update(Matrices path, Matrices distance, Matrices potent, int n)
    {
        for (int row = 0; row < path.nodes; row++)
        {
            for (int col = row+1; col < path.nodes; col++)
            {
                //bis jetzt noch kein Weg
                if (path.getValue(row, col) == 0)
                {
                    //haben wir möglichkeiten von a nach b zu kommen
                    if (potent.getValue(row, col) > 0)
                    {
                        path.setValue(row, col, 1);
                        distance.setValue(row, col, n);
                    }
                }
            }
        }
    }

    public void calcComponents(Matrices path, AlgoImpl bergerResult)
    {
        List<int[]> foundComponents = new ArrayList<>();

        for (int row = 0; row < path.nodes; row++)
        {
            // hol die nächste row von path matrix
            int[] rowNew = path.getRow(row);
            int[] row1 = rowNew.clone();

            //System.out.println(Arrays.toString(row1));

            for (int j = 0; j < rowNew.length ; j++)
            {
               // System.out.println(Arrays.toString(new int[]{path.getValue(row, j)}));
                if(row1[j]==1)
                {
                    row1[j]=j+1;
                }
            }
            //  wenn die row nicht in foundcomponents ist, haben wir eine neue Komponente gefunden
            if(!contains(foundComponents, row1))
            {
                foundComponents.add(row1);
            }
        }

        bergerResult.setComponents(foundComponents);
    }

    //Prüft ab ob die Zeile in der Liste enthalten ist oder nicht!!!
    private static boolean contains(List<int[]> foundComponents, int[] row)
    {
        for(int[] component: foundComponents)
        {
            if (Arrays.equals( component, row ))
            {
                return true;
            }
            //  System.out.println(Arrays.toString(component));
        }
        return false;
    }

    public void calcEccentricity(Matrices distance, int numComponents, AlgoImpl bergerResult)
    {
        int[] eccentricity = new int[distance.nodes];

        // Nur durchführen, wenn es nur 1 Komponente gibt
        if (numComponents == 1)
        {
            for (int row = 0; row < distance.nodes; row++)
            {
                int maxValue = -1;
                for (int col = 0; col < distance.nodes; col++)
                {
                    int value = distance.getValue(row, col);
                    if (value > maxValue)
                    {
                        maxValue = value;
                    }
                }
                eccentricity[row] = maxValue;
            }
        }
        else
        {
            //mit minus 1 füllen um unendlichkeit darzustellen
            // weil jeder Knoten minus 1 als exzentrizität hat
            Arrays.fill(eccentricity, -1);
        }
        bergerResult.setEccentricity(eccentricity);
    }


    public void calcRadius(int[] eccentricity, int numComponents, AlgoImpl bergerResult)
    {
        int radius = 999;

        if(numComponents == 1)
        {
            for (int i = 0; i < eccentricity.length; i++)
            {
                if (eccentricity[i] < radius)
                {
                    radius = eccentricity[i];
                }
            }
        }
        else
        {
            radius = -1;
        }

        bergerResult.setRadius(radius);
    }


    public void calcDiameter(int[] eccentricity, int numComponents, AlgoImpl bergerResult)
    {
        int diameter = -1;

        if(numComponents == 1)
        {
            for (int i = 0; i < eccentricity.length; i++)
            {
                if (eccentricity[i] > diameter)
                {
                    diameter = eccentricity[i];
                }
            }
        }
        else
        {
            diameter = -1;
        }

        bergerResult.setDiameter(diameter);
    }


    public void calcCenter(int[] eccentricity, int radius, int numComponents, AlgoImpl bergerResult)
    {
        List<Integer> center = new ArrayList<>();

        if(numComponents == 1)
        {
            for (int i = 0; i < eccentricity.length; i++)
            {

                if(eccentricity[i] == radius)
                {
                    center.add(i+1);
                }
            }
        }

        bergerResult.setCenter(center);
    }


    public void calcBridges(Matrices adja, int numComponents, AlgoImpl bergerResult)
    {
        AlgoImpl newBergerResult = new AlgoImpl();
        List<int[]> bridges = new ArrayList<>();

        for (int row = 0; row < adja.nodes; row++)
        {
            for (int col = row+1; col < adja.nodes; col++)
            {
                // gibt es überhaupt eine Kante
                if(adja.getValue(row, col) == 1)
                {
                    // 2.1 löschen der Kante
                    adja.deleteEdge(row, col);

                    // 2.2 neu berechnen der path und distanceMatrix
                    calcDistancePath(adja, newBergerResult);

                    // 2.3 neu berechnen der components
                    calcComponents(newBergerResult.getPath(), newBergerResult);

                    // 2.4 Existieren mehr Komponenten, wurde eine Brücke gefunden
                    if (numComponents < newBergerResult.getNumComponents())
                    {
                        bridges.add(new int[]{row + 1, col + 1});
                    }

                    // 2.5 die gelöschte Kante wieder hinzufügen
                    adja.addEdge(row, col);
                }
            }
        }
        bergerResult.setBridges(bridges);
    }


    public void calcArticulations(Matrices adja, int numComponents, AlgoImpl bergerResult)
    {
        List<Integer> articulations = new ArrayList<>();
        AlgoImpl newBergerResult = new AlgoImpl();

        for (int row = 0; row < adja.nodes; row++)
        {
            // 2.1 Lösche den Knoten(bzw. isolieren des Knotens) und merke dir die Zeile
            int[] saveRow = new int[adja.nodes];

            for (int col = 0; col < adja.nodes; col++)
            {
                // hol die nächste Zelle und merke dir den Wert
                saveRow[col] = adja.getValue(row, col);
                //nun lösche die Kante
                adja.deleteEdge(row, col);
            }

            // 2.2 neuberechnung
            calcDistancePath(adja, newBergerResult);

            // 2.3 neuberechnung Komponenten
            calcComponents(newBergerResult.getPath(), newBergerResult);

            // 2.4 existieren mehr Komponenten, wurde eine Artikulation gefunden
            if ( numComponents < newBergerResult.getNumComponents()-1 )
            {
                articulations.add(row+1);
            }

            //2.5 gelöschten "Knoten" wieder hinzufügen
            for (int col = 0; col < adja.nodes; col++)
            {
                // kopiere den Wert von row[i] nach data[node][i] und data[i][node]
                adja.setValue(row, col, saveRow[col]);
            }
        }

        bergerResult.setArticulations(articulations);
    }


}
