package principal;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import entities.Fornecedor;
import entities.Produto;
import interfaces.IFornecedorRepository;
import repositories.FornecedorRepositoryCSV;
import repositories.FornecedorRepositoryTXT;

public class Program {

	public static void main(String[] args) {
		Fornecedor fornecedor = new Fornecedor(1, "\n\nLoja de Infomática\n", "\n38.179.298/0001-11");

		Produto produto1 = new Produto(1, "Notebook Dell", 5000.0, 10);
		Produto protudo2 = new Produto(2, "Mouse Optico", 90.0, 20);
		Produto protudo3 = new Produto(3, "Impressora Laser", 500.0, 15);
		Produto produto4 = new Produto(4, "Teclado sem fio", 150.0, 10);

		List<Produto> produtos = new ArrayList<Produto>();
		produtos.add(produto1);
		produtos.add(protudo2);
		produtos.add(protudo3);
		produtos.add(produto4);

		fornecedor.setProduto(produtos);

		IFornecedorRepository fornecedorRepository = null;

		String opcao = JOptionPane.showInputDialog("Informe CSV ou TXT");

		switch (opcao.toUpperCase()) {
		case "TXT":
			fornecedorRepository = new FornecedorRepositoryTXT();
			break;

		case "CSV":
			fornecedorRepository = new FornecedorRepositoryCSV();
		}
		
		try {
			fornecedorRepository.exportar(fornecedor);
			System.out.println("Dados Gravados com sucesso!");
		}
		catch(Exception e) {
			System.out.println("ERRO: "+ e.getMessage());
		}

	}
}
