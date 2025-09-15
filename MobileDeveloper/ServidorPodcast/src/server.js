require('dotenv').config();

const http = require('http');
const { handleRequest } = require('./controllers/episodeController');

const port = process.env.PORT || 3000;

const server = http.createServer(handleRequest);

server.listen(port, () => {
  console.log(`Servidor rodando na porta ${port}`);
});
