const { getEpisodesFromRepo, createListInRepo, deleteListFromRepo } = require('../repositories/episodeRepository');

const getEpisodes = (listName) => {
  return getEpisodesFromRepo(listName);
};

const createList = (listName, episodes) => {
  createListInRepo(listName, episodes);
};

const deleteList = (listName) => {
  deleteListFromRepo(listName);
};

module.exports = { getEpisodes, createList, deleteList };
