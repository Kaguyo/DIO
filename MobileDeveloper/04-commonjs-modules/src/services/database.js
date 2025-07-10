exports.connectToDatabase = (dbSetName) => {
    console.log("Conectando ao banco de dados " + dbSetName);
}

exports.disconnectFromDatabase = (dbSetName) => {
    console.log("Desconectando do banco de dados " + dbSetName);
}

exports.createUser = async (user) => {
    console.log("Criando usuário: " + user.name);
}

exports.getUser = async (userId) => {
    console.log("Obtendo usuário com ID: " + userId);
}
