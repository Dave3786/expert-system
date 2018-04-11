package assignment3;

import java.io.BufferedReader;
import java.io.IOException;
import static java.lang.Integer.parseInt;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.PriorityQueue;

/**
 * @author "Philip Robinson, Vladimir Ten <vladimir.ten@msu.montana.edu>".
 */
public class Assignment3 {
    /**
     * @param args the command line arguments
     */
    int vertices = 5;
    
    public int getMin(int keys[], boolean inMST[]) {
        int min = Integer.MAX_VALUE;
        int min_index = -1;
        
        for (int i = 0; i < vertices; i++) {
            if (inMST[i] == false && keys[i] < min) {
                min = keys[i];
                min_index = i;
            }
        }
        
        return min_index;
    }
    
    public void construct(int matrix[][]) {
        int mst[] = new int[vertices];
        int key[] = new int[vertices];
        boolean inMST[] = new boolean[vertices];
        
        // Initializing all keys to infinity.
        for (int i = 0; i < vertices; i++) {
            key[i] = Integer.MAX_VALUE;
            inMST[i] = false;
        }
        key[0] = 0;
        mst[0] = -1;
        
        for (int j = 0; j < vertices - 1; j++) {
            int min_key = getMin(key, inMST);
            inMST[min_key] = true;
            
            for (int k = 0; k < vertices; k++) {
                if (matrix[min_key][k] != 0 && inMST[k] == false && matrix[min_key][k] < key[k]) {
                    mst[k] = min_key;
                    key[k] = matrix[min_key][k];
                }
            }
        }
    }
    
    public static void main(String[] args) throws IOException {
        Charset charset = Charset.forName("Unicode");
        // Reading relative path to the input file - must be in correct format, otherwise program doesn't handle user errors.
        Path file = Paths.get("input.txt");
        int[][] ee;
        String[] vv;
        try (BufferedReader reader = Files.newBufferedReader(file, charset)) {
            String line = reader.readLine();
            vv = line.split(",");
            ee = new int[vv.length][vv.length];
            
            for (int i = 0; i < vv.length; i++) {
                line = reader.readLine();
                String[] line_array = line.split(",");
                int[] data_array = new int[vv.length];
                for (int k = 0; k < line_array.length; k++) {
                    // Not sure if encoding is working properly, it is supposed to be infinity sign.
                    if (line_array[k].equals("âˆž")) {
                        data_array[k] = Integer.MAX_VALUE;
                    } else {
                        data_array[k] = parseInt(line_array[k]);
                    }
                }
                
                ee[i] = data_array;
            }
            
            for (int j = 0; j < ee.length; j++) {
                for (int m = 0; m < ee.length; m++) {
                    System.out.print(ee[j][m] + " ");
                }
                System.out.println();
            }
            System.out.println();
            
            PriorityQueue<Vertex> MST = new PriorityQueue<Vertex>();
            MST.add(new Vertex(0, 0));
            for (int i = 1; i < vv.length; i++) {
                MST.add(new Vertex(i, Integer.MAX_VALUE));
            }
            
            
        } catch (IOException e) {
            System.err.format("IOException: %s%n", e);
        }
    }
}
