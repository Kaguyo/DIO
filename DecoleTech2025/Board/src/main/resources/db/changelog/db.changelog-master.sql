--liquibase formatted sql
--changeset kaguyo:202504121649
--comment: Criação das tabelas boards e cards

-- Criação da tabela BOARDS
CREATE TABLE BOARDS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL
) ENGINE=InnoDB;

-- Criação da tabela CARDS
CREATE TABLE CARDS (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    description VARCHAR(255) NOT NULL,
    status ENUM('pendente', 'concluido', 'cancelado') NOT NULL DEFAULT 'pendente',
    blocked BOOLEAN NOT NULL DEFAULT FALSE,
    board_id BIGINT NOT NULL,
    FOREIGN KEY (board_id) REFERENCES BOARDS(id) ON DELETE CASCADE
) ENGINE=InnoDB;

--rollback: 
-- Caso precise reverter as migrações, você pode adicionar o rollback para as tabelas

