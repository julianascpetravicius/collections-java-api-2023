package list.OperacoesBasicas;

import java.util.ArrayList;
import java.util.List;

public class CarrinhoDeCompras {

    private List<Item> carrinhoDeCompras;

    public CarrinhoDeCompras() {
        this.carrinhoDeCompras = new ArrayList<>();
    }

    public void adicionarItem(String nome, double preco, int quantidade){
        Item item = new Item(nome, preco, quantidade);
        this.carrinhoDeCompras.add(item);
    }

    public void removerItem(String nome){
        List<Item> itensParaRemover = new ArrayList<>();
        for(Item i: carrinhoDeCompras) {
            if(i.getNome().equalsIgnoreCase(nome)) {
                itensParaRemover.add(i);
            }
        }
        carrinhoDeCompras.removeAll(itensParaRemover);
    }

    public double obterValorTotal(){
        double valorTotal = 0;
        for(Item i: carrinhoDeCompras) {
            valorTotal += i.getPreco() * i.getQuantidade();
        }
        return valorTotal;
    }

    public void exibirItens(){
        if (!carrinhoDeCompras.isEmpty()) {
            System.out.println(this.carrinhoDeCompras);
        } else {
            System.out.println("O carrinho está vazio");
        }
    }

    @Override
    public String toString() {
        return "CarrinhoDeCompras{" +
                "itens=" + this.carrinhoDeCompras +
                '}';
    }

    public static void main(String[] args) {
        CarrinhoDeCompras carrinhoDeCompras = new CarrinhoDeCompras();
        carrinhoDeCompras.adicionarItem("Bolacha", 2d, 2);
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.adicionarItem("Bolacha", 2d, 2);
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.adicionarItem("Sabão", 2d, 2);
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.removerItem("Bolacha");
        carrinhoDeCompras.exibirItens();
        carrinhoDeCompras.obterValorTotal();
        System.out.println(carrinhoDeCompras.obterValorTotal());
    }
}
