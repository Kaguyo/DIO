const { getEpisodes, createList, deleteList } = require('../services/episodeService');

const handleRequest = (req, res) => {
  const { method, url } = req;

  if (url === '/episodes' && method === 'GET') {
    let body = '';
    req.on('data', chunk => {
      body += chunk;
    });
    req.on('end', () => {
      const { listName } = JSON.parse(body);
      const episodes = getEpisodes(listName);
      if (episodes) {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify(episodes));
      } else {
        res.writeHead(400, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ error: 'Lista não encontrada' }));
      }
    });
  } else if (url === '/episodes' && method === 'POST') {
    let body = '';
    req.on('data', chunk => {
      body += chunk;
    });
    req.on('end', () => {
      const { listName, episodes } = JSON.parse(body);
      createList(listName, episodes);
      res.writeHead(201, { 'Content-Type': 'application/json' });
      res.end(JSON.stringify({ message: 'Lista criada com sucesso' }));
    });
  } else if (url === '/episodes' && method === 'DELETE') {
    let body = '';
    req.on('data', chunk => {
      body += chunk;
    });
    req.on('end', () => {
      const { listName } = JSON.parse(body);
      deleteList(listName);
      res.writeHead(200, { 'Content-Type': 'application/json' });
      res.end(JSON.stringify({ message: 'Lista deletada com sucesso' }));
    });
  } else {
    res.writeHead(404, { 'Content-Type': 'application/json' });
    res.end(JSON.stringify({ error: 'Rota não encontrada' }));
  }
};

module.exports = { handleRequest };
