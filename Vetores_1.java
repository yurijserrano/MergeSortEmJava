/**
 *
 * @author Yuri
 * Utilizando o formato padrão do vetor  neste exemplo foi utilizado o algoritmo de
 *ordenação Merge Sort para ordenar o vetor.
 */

import java.util.*;

public class Vetores_1
{
    
    public static int[] merge(int v1[],int v2[])
    {
        int [] vet3=new int[v1.length+v2.length];
        
        /*Este for intercala os valores dos dois vetores como pedido pelo 
        * Exercício
        */        
        int aux=0;
        for (int i = 0; i < v1.length; i++) 
        {  
            
                int num1 = v1[i];  
                int num2 = v2[i];  
                vet3[aux]=num1;  
                aux+=1;
                vet3[aux]=num2;  
                aux+=1;                
        } 
        
        mergesort(vet3);  
        
        return vet3;  
    }
    
    public static void mergesort(int v3[])
    {
        if (v3.length > 1) 
        {
            int q = v3.length/2;
            int[] esquerda = Arrays.copyOfRange(v3, 0, q);
            int[] direita = Arrays.copyOfRange(v3,q,v3.length);
            mergesort(esquerda);
            mergesort(direita);
            intercala(v3,esquerda,direita);
        }
    }
    
   public static void intercala(int[] v3,int[] e, int[] d)
    {
        int totElem = e.length + d.length;
        int i=0,li=0,ri=0;
        while ( i < totElem) 
        {
            if ((li < e.length) && (ri<d.length)) 
            {
                if (e[li] < d[ri]) 
                {
                    v3[i] = e[li];
                    i++;
                    li++;
                }
                else 
                {
                    v3[i] = d[ri];
                    i++;
                    ri++;
                }
            }
            else 
            {
                if (li >= e.length) 
                {
                    while (ri < d.length) 
                    {
                        v3[i] = d[ri];
                        i++;
                        ri++;
                    }
                }
                if (ri >= d.length) 
                {
                    while (li < e.length)
                    {
                        v3[i] = e[li];
                        li++;
                        i++;
                    }
                }
            }
        }
        

    }


    
   
    
    
    public static void main(String[] args)
    {
    
        int[] vet={1,3,4,5,9,8,11,10,2};
        int[]vet2={15,17,14,18,19,20,21,23,22};
    
        Arrays.sort(vet);
        Arrays.sort(vet2);
        
        int [] resultado = merge(vet,vet2);
        
        System.out.println(Arrays.toString(resultado));   
          
    
    
    } 
}
    

