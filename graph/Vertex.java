/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package assignment3;

public class Vertex implements Comparable {
    int name;
    int weight;
    
    public Vertex(int n, int w) {
        name = n;
        weight = w;
    }
    
    public int compareTo(Object o) {
        return -1;
    }

    public int compareTo(Vertex other) {
        return (this.weight - other.weight);
    }
}
