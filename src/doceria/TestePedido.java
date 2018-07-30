/* To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package doceria;
import javax.swing.JOptionPane;
/**
 *
 * @author leo2f
 */
public class TestePedido {
    static Pedido arraypedido[]=new Pedido[10];
    
    
    public static void ordenaSelectionSort(int nrocli){
    int posmenor,i,j;
    String nome,nomeposmenor;
    Pedido cliposmenor = new Pedido();
    Pedido cliente = new Pedido();
    Pedido aux=new Pedido();
    for (i=0;i<nrocli;i++){
    posmenor = i;
    cliposmenor=arraypedido[i];
    nomeposmenor = cliposmenor.getNome();
    for (j=i+1; j < nrocli;j++){
    cliente = arraypedido[j];
    nome = cliente.getNome();
    if (nome.compareTo(nomeposmenor)<0){
    posmenor = j;
    nomeposmenor = cliente.getNome();
    }//if
    }//for j
    aux = arraypedido[posmenor];
    arraypedido[posmenor]=arraypedido[i];
    arraypedido[i] = aux;
    }//for i
    }//ordena
    
    public static void main (String[] args){
    Pedido cliente;
    int k, nrocli;
    String s, saida;
    StringBuilder mensagem;
    int q1, q2, q3, q4;
    double faturamento = 0;  
    
   
    for(;;){
    s = JOptionPane.showInputDialog("Quantas pessoas fizeram pedido durante esse mês?");
    try{
    nrocli = Integer.parseInt(s);
    
    if (nrocli<1||nrocli>arraypedido.length){
    JOptionPane.showMessageDialog(null,"Digite um numero de 1 a "+arraypedido.length, "ERRO", JOptionPane.ERROR_MESSAGE);
    continue;
    }//if
    else
           break;
    }catch(NumberFormatException e){
    JOptionPane.showMessageDialog(null,"Não se pode usar caracteres como "+s,"Exceção", JOptionPane.ERROR_MESSAGE);
    continue;
    }//catch
    
    }//for ;;
    
    
    for(k=0; k<nrocli; k++){
    cliente = new Pedido();
           
        cliente.setNome(JOptionPane.showInputDialog("Nome do cliente: "+(k+1)+"?"));    
    
        for (;;){
            s= JOptionPane.showInputDialog("Quantas empadas no valor de R$ 6.50 o " + cliente.getNome() + " comprou? ");
        
            try {
                q1 = Integer.parseInt (s);
                
                if (q1 < 0){
                 
                    JOptionPane.showMessageDialog(null,"Não é permitido numeros negativos","ERRO",JOptionPane.ERROR_MESSAGE);
                  continue;
                }
                else 
                    
                    cliente.setQuant1(q1);
                   
                 break;
            }catch (NumberFormatException e){
                JOptionPane.showMessageDialog(null,"Não se pode usar caracteres como "+s,"ERRO",JOptionPane.ERROR_MESSAGE);
                
            
                
                continue;
            }
            
            
        }// for quant1
        
      
        for(;;){
              s = JOptionPane.showInputDialog("Quantos brigadeiros no valor de R$ 4.00 o " + cliente.getNome() + " comprou? ");
        try{
        q2 = Integer.parseInt (s);
        
        if (q2 >= 0){
        cliente.setQuant2(q2);
        break;
        }else{
              JOptionPane.showMessageDialog(null, "Não é permitido números negativos","ERRO",JOptionPane.ERROR_MESSAGE);
              continue;
        }
        }
        catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"Não se pode usar caracteres como "+s,"ERRO",JOptionPane.ERROR_MESSAGE);
        
        continue;
        }
        
        }
        
        
        for(;;){
        s = JOptionPane.showInputDialog("Quantas coxinhas no valor de R$ 6.00 o " + cliente.getNome() + " comprou? ");
        try{
        q3 = Integer.parseInt(s);
        if(q3 >= 0){
        cliente.setQuant3(q3);
        break;
        }else{
        JOptionPane.showMessageDialog(null,"Não é permitido números negativos","ERRO",JOptionPane.ERROR_MESSAGE);
        
        continue;
        }        
                }catch(NumberFormatException e){
                JOptionPane.showMessageDialog(null,"\"Não se pode usar caracteres como "+s, "ERRO", JOptionPane.ERROR_MESSAGE);
                
                continue;
                }
        }

        
        
        for(;;){
        s = JOptionPane.showInputDialog("Quantos pudins de leite no valor de R$ 4.50 o " + cliente.getNome() + " comprou? ");
        try{
        q4 = Integer.parseInt(s);
        if(q4 >= 0){
        cliente.setQuant4(q4);
        break;
        }else{
        JOptionPane.showMessageDialog(null, "Não é permitido números negativos", "ERRO", JOptionPane.ERROR_MESSAGE);
        
        
        continue;
        
        }
        }catch(NumberFormatException e){
        JOptionPane.showMessageDialog(null,"Não se pode usar caracteres como "+s, "ERRO", JOptionPane.ERROR_MESSAGE);
        
        
        continue;
        
        
        }
        }
   
          cliente.calculaTotal (q1, q2, q3, q4);
         arraypedido[k]=cliente;
         faturamento+= cliente.getTotal();
    }//for
    
    
    cliente = new Pedido();
    mensagem = new StringBuilder();
    for (k=0; k<nrocli; k++){
    cliente = arraypedido[k];  
    
    mensagem.append ("Nome do cliente: "+cliente.getNome()+"\n");
    mensagem.append ("Quantidades de empadas que o clente "+cliente.getNome()+" pediu: "+cliente.getQuant1()+"\n");
    mensagem.append ("Quantidade de coxinhas que o cliente "+cliente.getNome()+" pediu: "+cliente.getQuant2()+"\n");
    mensagem.append ("Quantidade de brigadeiro que o cliente "+cliente.getQuant3()+" pediu: "+cliente.getQuant3()+"\n");
    mensagem.append ("Quantidade de pudim (ns) de leite que o cliente"+cliente.getNome()+"pediu: "+cliente.getQuant4()+"\n");
    mensagem.append("Total da compra: "+cliente.getTotal()+"\n");
    
    
    }
    
    JOptionPane.showMessageDialog(null, mensagem, "clientes mostrados sem ordenação", JOptionPane.INFORMATION_MESSAGE);
    
    ordenaSelectionSort(nrocli);
    
    mensagem=new StringBuilder();
    
    for(k=0;k<nrocli; k++){
    cliente=arraypedido[k];
    
    mensagem.append("Nome do cliente: "+cliente.getNome()+"\n");
    mensagem.append("Quantidade de empadas que o cliente "+cliente.getNome()+" pediu: "+cliente.getQuant1()+"\n");
    mensagem.append("Quantidade de coxinhas que o cliente "+cliente.getNome()+" pediu: "+cliente.getQuant2()+"\n");
    mensagem.append("Quantidade de brigadeiro que o cliente "+cliente.getNome()+" pediu: "+cliente.getQuant3()+"\n");
    mensagem.append("Quantidade de pudim de leite que o cliente "+cliente.getNome()+" pediu: "+cliente.getQuant4()+"\n");
mensagem.append("Total da compra do cliente "+cliente.getNome()+": "+cliente.getTotal()+"\n");
    mensagem.append("O faturamento total da doceria foi:"+faturamento);
  
    
    }//for
      JOptionPane.showMessageDialog(null, mensagem);
    }//main
}//classe
