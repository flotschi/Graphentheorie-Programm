package model.matrices;

/**
 * Created by Neo on 25.12.2016.
 */
public class SquareMatrix
{
    private final int[][] data;
    public final int nodes;
    //constructor__________________________
    public SquareMatrix( int nodes)
    {
        if(nodes <= 0) throw new IllegalArgumentException("Nodes must be at least 1!!");

        this.data = new int[nodes][nodes];
        this.nodes = nodes;
    }

    //only zum testen
//    public SquareMatrix(int[][]data)
//    {
//        // TODO: should check if data is a squared matrix!
//        this.data = data;
//        this.nodes = data.length;
//    }


    //getter
    public int getNodes()
    {
        return nodes;
    }


    public int[] getRow(int row){
        return data[row];
    }


    public int getValue(int row, int col)
    {
        return data[row][col];
    }

    //setter
    //gespiegelt
    public void setValue(int row, int col, int value)
    {
        //alle Werte spiegeln, da ungerichtet
        data[row][col] = value;
        data[col][row] = value;
    }

    //methods
    public void multiply(SquareMatrix other, SquareMatrix result)
    {
        //für alle Zeilen in this matrix
        for (int row = 0; row < nodes ; row++)
        {
            //für alle Spalten in other matrix
            for (int col = 0; col < nodes ; col++)
            {
                int sum = 0;

                //this matrix -> für alle Zellen in der Zeile
                //other matrix -> für alle Zellen in der Spalte
                for (int index = 0; index < nodes; index++)
                {
                    sum += this.data[row][index] * other.data[index][col];
                }

                result.data[row][col] = sum;
            }
        }
    }

//    @Override
//    public String toString()
//    {
//        StringBuilder sb = new StringBuilder();
//
//        for (int row = 0; row <  nodes; row++)
//        {
//            for (int col = 0; col < nodes; col++)
//            {
//                sb.append(String.format("%3d",data[row][col]));
//            }
//            sb.append("\n");
//        }
//        return sb.toString();
//    }
}
