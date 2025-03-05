-- Inserir pessoas
INSERT INTO tb_person (id, name, age, email) VALUES
                                                   (1, 'João Silva', 30, 'joao.silva@email.com'),
                                                   (2, 'Maria Oliveira', 25, 'maria.oliveira@email.com'),
                                                   (3, 'Carlos Santos', 40, 'carlos.santos@email.com'),
                                                   (4, 'Ana Souza', 35, 'ana.souza@email.com');

-- Inserir contatos (telefones)
INSERT INTO tb_contact (id, number_Phone, person_id) VALUES
                                                          (1, 11987654321, 1),
                                                          (2, 11965432178, 2),
                                                          (3, 11912345678, 3),
                                                          (4, 11987659876, 4);

-- Inserir endereços
INSERT INTO tb_address (id, address, number, state, city, code_Postal, person_id) VALUES
                                                                                       (1, 'Rua das Flores', 100, 'SP', 'São Paulo', 12345678, 1),
                                                                                       (2, 'Av. Paulista', 2000, 'SP', 'São Paulo', 87654321, 2),
                                                                                       (3, 'Rua das Palmeiras', 50, 'RJ', 'Rio de Janeiro', 12312312, 3),
                                                                                       (4, 'Av. Brasil', 500, 'MG', 'Belo Horizonte', 65432100, 4);
