-- Inserir pessoas
INSERT INTO tb_person (name, age, email) VALUES
                                                   ('João Silva', 30, 'joao.silva@email.com'),
                                                   ('Maria Oliveira', 25, 'maria.oliveira@email.com'),
                                                   ('Carlos Santos', 40, 'carlos.santos@email.com'),
                                                   ('Ana Souza', 35, 'ana.souza@email.com');

-- Inserir contatos (telefones)
INSERT INTO tb_contact (number_Phone, person_id) VALUES
                                                          (11987654321, 1),
                                                          (11965432178, 2),
                                                          (11912345678, 3),
                                                          (11987659876, 4);

-- Inserir endereços
INSERT INTO tb_address (address, number, state, city, code_Postal, person_id) VALUES
                                                                                       ('Rua das Flores', 100, 'SP', 'São Paulo', 12345678, 1),
                                                                                       ('Av. Paulista', 2000, 'SP', 'São Paulo', 87654321, 2),
                                                                                       ('Rua das Palmeiras', 50, 'RJ', 'Rio de Janeiro', 12312312, 3),
                                                                                       ('Av. Brasil', 500, 'MG', 'Belo Horizonte', 65432100, 4);
