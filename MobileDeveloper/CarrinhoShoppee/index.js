const readline = require('readline');

const rl = readline.createInterface({
  input: process.stdin,
  output: process.stdout
});

// Itens disponíveis com preços fixos
const itensDisponiveis = [
  { id: 1, nome: 'Camiseta', preco: 49.90 },
  { id: 2, nome: 'Calça Jeans', preco: 129.90 },
  { id: 3, nome: 'Tênis Esportivo', preco: 199.90 },
  { id: 4, nome: 'Jaqueta de Couro', preco: 299.90 },
  { id: 5, nome: 'Relógio de Pulso', preco: 89.90 },
  { id: 6, nome: 'Óculos de Sol', preco: 59.90 },
  { id: 7, nome: 'Carteira de Couro', preco: 39.90 },
  { id: 8, nome: 'Mochila', preco: 79.90 },
  { id: 9, nome: 'Fone de Ouvido', preco: 119.90 },
  { id: 10, nome: 'Smartphone', preco: 999.90 },
  { id: 11, nome: 'Tablet', preco: 499.90 },
  { id: 12, nome: 'Notebook', preco: 2499.90 }
];

// Carrinho de compras
let carrinho = [];

// Saldo da conta
let saldo = 1000.00;

// Função para exibir o menu principal
function exibirMenu() {
  console.clear();
  console.log(`Saldo atual: R$ ${saldo.toFixed(2)}`);
  console.log('\nItens no Carrinho:');
  if (carrinho.length > 0) {
    carrinho.forEach(item => {
      console.log(`${item.nome} (${item.quantidade}) - Subtotal: R$ ${(item.preco * item.quantidade).toFixed(2)}`);
    });
  } else {
    console.log('Carrinho vazio.');
  }
  console.log('\nTotal do Carrinho: R$ ' + calcularTotalCarrinho().toFixed(2));
  console.log('\nEscolha uma opção:');
  console.log('1. Adicionar item ao carrinho');
  console.log('2. Remover item do carrinho');
  console.log('3. Comprar itens');
  console.log('4. Sair');
  rl.question('Digite o número da opção desejada: ', (opcao) => {
    switch (opcao) {
      case '1':
        adicionarItem();
        break;
      case '2':
        removerItem();
        break;
      case '3':
        comprarItens();
        break;
      case '4':
        rl.close();
        break;
      default:
        console.log('Opção inválida!');
        exibirMenu();
        break;
    }
  });
}

// Função para adicionar item ao carrinho
function adicionarItem() {
  console.clear();
  console.log('Selecione um item para adicionar ao carrinho:');
  itensDisponiveis.forEach(item => {
    console.log(`${item.id}. ${item.nome} - R$ ${item.preco.toFixed(2)}`);
  });
  rl.question('Digite o número do item: ', (idItem) => {
    const itemSelecionado = itensDisponiveis.find(item => item.id === parseInt(idItem));
    if (itemSelecionado) {
      rl.question('Digite a quantidade: ', (quantidade) => {
        quantidade = parseInt(quantidade);
        if (quantidade > 0) {
          const itemNoCarrinho = carrinho.find(item => item.id === itemSelecionado.id);
          if (itemNoCarrinho) {
            itemNoCarrinho.quantidade += quantidade;
          } else {
            carrinho.push({ ...itemSelecionado, quantidade });
          }
          console.log(`${itemSelecionado.nome} adicionado(s) ao carrinho.`);
        } else {
          console.log('Quantidade inválida!');
        }
        exibirMenu();
      });
    } else {
      console.log('Item não encontrado!');
      exibirMenu();
    }
  });
}

// Função para remover item do carrinho
function removerItem() {
  console.clear();
  console.log('Selecione um item para remover do carrinho:');
  carrinho.forEach(item => {
    console.log(`${item.id}. ${item.nome} (${item.quantidade}) - Subtotal: R$ ${(item.preco * item.quantidade).toFixed(2)}`);
  });
  rl.question('Digite o número do item: ', (idItem) => {
    const itemSelecionado = carrinho.find(item => item.id === parseInt(idItem));
    if (itemSelecionado) {
      rl.question('Digite a quantidade a remover: ', (quantidade) => {
        quantidade = parseInt(quantidade);
        if (quantidade > 0 && quantidade <= itemSelecionado.quantidade) {
          itemSelecionado.quantidade -= quantidade;
          if (itemSelecionado.quantidade === 0) {
            carrinho = carrinho.filter(item => item.id !== itemSelecionado.id);
          }
          console.log(`${quantidade} ${itemSelecionado.nome}(s) removido(s) do carrinho.`);
        } else {
          console.log('Quantidade inválida!');
        }
        exibirMenu();
      });
    } else {
      console.log('Item não encontrado no carrinho!');
      exibirMenu();
    }
  });
}

// Função para calcular o total do carrinho
function calcularTotalCarrinho() {
  return carrinho.reduce((total, item) => total + (item.preco * item.quantidade), 0);
}

// Função para realizar a compra
function comprarItens() {
  const total = calcularTotalCarrinho();
  if (total > saldo) {
    console.log('Saldo insuficiente para realizar a compra.');
  } else {
    saldo -= total;
    carrinho = [];
    console.log('Compra realizada com sucesso!');
  }
  exibirMenu();
}

// Iniciar o sistema
exibirMenu();
