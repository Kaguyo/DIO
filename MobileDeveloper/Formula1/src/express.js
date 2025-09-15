// instale com: npm init -y && npm install express
const express = require('express');
const app = express();
const port = 3000;

// dados de exemplo: drivers + seus carros
const drivers = [
  { id: 1, name: 'Max Verstappen', team: 'Red Bull Racing', carBrand: 'Red Bull' },
  { id: 2, name: 'Lewis Hamilton', team: 'Ferrari', carBrand: 'Ferrari' },
  { id: 3, name: 'Charles Leclerc', team: 'Ferrari', carBrand: 'Ferrari' },
  { id: 4, name: 'Sergio Pérez', team: 'Red Bull Racing', carBrand: 'Red Bull' },
  { id: 5, name: 'Lando Norris', team: 'McLaren', carBrand: 'McLaren' },
  // etc.
];

// GET endpoint que recebe parâmetro "lidop"
app.get('/search/:lidop', (req, res) => {
  const lidop = req.params.lidop.toLowerCase();

  // filtra drivers cujo nome ou marca do carro correspondem ao parâmetro
  const results = drivers.filter(driver => {
    return driver.name.toLowerCase().includes(lidop)
      || driver.carBrand.toLowerCase().includes(lidop);
  }).map(driver => {
    return {
      id: driver.id,
      name: driver.name,
      team: driver.team
    };
  });

  res.json(results);
});

app.listen(port, () => {
  console.log(`Servidor rodando em http://localhost:${port}`);
});
