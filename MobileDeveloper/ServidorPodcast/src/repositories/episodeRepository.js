const episodeRepo = {};

const getEpisodesFromRepo = (listName) => {
  return episodeRepo[listName] || null;
};

const createListInRepo = (listName, episodes) => {
  episodeRepo[listName] = episodes;
};

const deleteListFromRepo = (listName) => {
  delete episodeRepo[listName];
};

module.exports = { getEpisodesFromRepo, createListInRepo, deleteListFromRepo };
