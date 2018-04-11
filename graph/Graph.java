/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

/**
 *
 * @author vten
 */
public class Graph {
    private final int vertices;
    
    public Graph(int vertices) {
        this.vertices = vertices;
    }
    
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
}
