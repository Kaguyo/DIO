const readlineSync = require('readline-sync');
const qrcode = require('qrcode-terminal');
const dotenv = require('dotenv');
const crypto = require('crypto');

dotenv.config();

// Função para gerar QR Code
function gerarQRCode() {
  const link = readlineSync.question('Digite o link para gerar o QR Code: ');
  try {
    qrcode.generate(link, { small: true });
  } catch (error) {
    console.log('Erro ao gerar QR Code. Certifique-se de que o link é válido.');
  }
}

// Função para gerar senha
function gerarSenha() {
  const minLength = parseInt(process.env.MIN_CHARACTERS);
  const length = parseInt(process.env.PASSWORD_LENGTH);

  if (length < minLength) {
    console.log(`A senha deve ter pelo menos ${minLength} caracteres.`);
    return;
  }

  const lowerCase = process.env.LOWER_CASE === 'true';
  const upperCase = process.env.UPPER_CASE === 'true';
  const numberRequired = process.env.NUMBER_REQUIRED === 'true';
  const specialCharacters = process.env.SPECIAL_CHARACTERS === 'true';

  let charset = '';
  if (lowerCase) charset += 'abcdefghijklmnopqrstuvwxyz';
  if (upperCase) charset += 'ABCDEFGHIJKLMNOPQRSTUVWXYZ';
  if (numberRequired) charset += '0123456789';
  if (specialCharacters) charset += '!@#$%^&*()_+[]{}|;:,.<>?';

  if (!charset) {
    console.log('Nenhuma configuração válida encontrada para gerar a senha.');
    return;
  }

  let senha = '';
  for (let i = 0; i < length; i++) {
    senha += charset.charAt(Math.floor(Math.random() * charset.length));
  }

  console.log(`Senha gerada: ${senha}`);
}

// Menu principal
function menu() {
  console.clear();
  console.log('Escolha uma opção:');
  console.log('1. Gerar QR Code');
  console.log('2. Gerar Senha');
  console.log('3. Sair');

  const opcao = readlineSync.question('Digite o número da opção desejada: ');

  switch (opcao) {
    case '1':
      gerarQRCode();
      break;
    case '2':
      gerarSenha();
      break;
    case '3':
      console.log('Saindo...');
      process.exit();
      break;
    default:
      console.log('Opção inválida. Tente novamente.');
  }

  readlineSync.question('Pressione Enter para continuar...');
  menu();
}

menu();
