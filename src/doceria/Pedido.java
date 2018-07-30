/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doceria;

/**
 *
 * @author leo2f
 */
public class Pedido {
    private String nome;
    private int quant1;
    private int quant2;
    private int quant3;
    private int quant4;
    private double total;
    
    public String getNome(){
    return nome;
    }
    public void setNome(String nome){
    this.nome = nome;
    }
    public int getQuant1(){
    return quant1;
    }
    public void setQuant1(int quant1){
    this.quant1 = quant1;
    }
    public int getQuant2(){
    return quant2;
    }
    public void setQuant2(int quant2){
    this.quant2 = quant2;
    }
    public int getQuant3(){
    return quant3;
    }
    public void setQuant3(int quant3){
    this.quant3 = quant3;
    }
    public int getQuant4(){
    return quant4;
    }
    public void setQuant4(int quant4){
    this.quant4 = quant4;
    }
    public double getTotal (){
    return total;    
    } 
    
    public void calculaTotal(int  quant1, int quant2, int quant3, int quant4){
          this.total =(quant1 * 6.50 + quant2 * 6.00 + quant3 * 4.00 + quant4 * 4.50);
    }
    
    
}
