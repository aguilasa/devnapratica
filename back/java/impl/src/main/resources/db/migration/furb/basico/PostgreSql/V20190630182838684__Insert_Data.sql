delete from shopping_list_items;
delete from item_list;
delete from shopping_list;
delete from product;
delete from category;


INSERT INTO category (id,description) VALUES 
('f522fc1a-f7f7-4bee-8693-858f3e5179be','Bazar e limpeza')
,('46df924c-5076-49eb-8bb4-754788dbeb52','Hortifrutigranjeiros')
,('be2d42c2-3ba8-490d-8b36-f7fd3e4bc4f7','Importados')
,('e0801827-cdf6-4b54-a61a-1b14c8ef80ba','Mercearia')
,('8cb1e709-199c-4222-b7de-2ec6df7e033b','Padaria')
,('983109bd-21d4-4ada-9983-eb3c994d2a62','Saúde e Beleza')
,('1de450ca-e0a4-4631-943d-56a7857188df','Sem categoria')
,('f225086c-d130-4f0c-beef-4cb4325d32be','Bebidas')
,('a84de458-8892-45e2-8463-c94b25042523','Carnes')
,('c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a','Frios, Leites e Derivados')
;

INSERT INTO product (id,description,unit,category) VALUES 
('f1c29bea-f4b4-4d03-b288-341c89b4c5bf','Acém',4,'a84de458-8892-45e2-8463-c94b25042523')
,('fbc3e7fa-390f-4ff6-838b-cfcb2f3496a0','Alcatra',4,'a84de458-8892-45e2-8463-c94b25042523')
,('dac71898-d122-4a11-957b-36db54e234f1','Capa do coxão mole',4,'a84de458-8892-45e2-8463-c94b25042523')
,('33318eb9-025f-4757-af71-f3c15664a2fd','Contrafilé',4,'a84de458-8892-45e2-8463-c94b25042523')
,('2ffec034-d292-4206-a389-6c30ec8b03fd','Coração de alcatra',4,'a84de458-8892-45e2-8463-c94b25042523')
,('a97b7ce4-1bbd-427f-8d32-5fc5c530a8a5','Costela',4,'a84de458-8892-45e2-8463-c94b25042523')
,('6d0b92d8-14ec-4117-8530-f87b13b25630','Coxão duro',4,'a84de458-8892-45e2-8463-c94b25042523')
,('d88535b8-efa5-40aa-a25d-66f4a8c36756','Coxão mole',4,'a84de458-8892-45e2-8463-c94b25042523')
,('303512f3-832a-4697-a9f6-319c6f968a9d','Filé mignon',4,'a84de458-8892-45e2-8463-c94b25042523')
,('a17eb08c-0b62-4118-8cf4-3164e99ecf8e','Granito',4,'a84de458-8892-45e2-8463-c94b25042523')
;
INSERT INTO product (id,description,unit,category) VALUES 
('50d93f55-f25a-4261-8fd3-22c8bccfee10','Lagarto',4,'a84de458-8892-45e2-8463-c94b25042523')
,('71b971ec-d53b-4382-a9b3-36eb60996c5b','Maminha',4,'a84de458-8892-45e2-8463-c94b25042523')
,('0c572864-bab2-401b-8fd4-2a371f2fe62b','Patinho',4,'a84de458-8892-45e2-8463-c94b25042523')
,('02847ab0-ed05-4a8f-b37f-b1998d24cc97','Picanha',4,'a84de458-8892-45e2-8463-c94b25042523')
,('398a9613-0e35-4afd-8422-ef79624740c3','Fraldinha',4,'a84de458-8892-45e2-8463-c94b25042523')
,('9a5217cd-4c7b-4c98-9a0c-860847875470','Omasso',4,'a84de458-8892-45e2-8463-c94b25042523')
,('22394675-7365-40a8-81f6-f3a740ae25ac','Paleta',4,'a84de458-8892-45e2-8463-c94b25042523')
,('a7e04ce4-9f17-4f58-962e-efac8ec899b0','Peito',4,'a84de458-8892-45e2-8463-c94b25042523')
,('35bc634f-fc24-486a-b685-7cd1f8e4e473','Abacate',4,'a84de458-8892-45e2-8463-c94b25042523')
,('c84ca982-85bc-4939-b523-4f078302b2b6','Sabão em pó',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
;
INSERT INTO product (id,description,unit,category) VALUES 
('6974e9f1-f245-4ae8-8bcb-9f673e12be5e','Amaciante',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('19362988-7d59-486e-881a-7e29a11176be','Detergente',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('746cb4ab-5543-4793-825b-865769ede5f2','Água sanitária',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('fd163ee5-611d-4a30-bf2b-a53208e14639','Esponja de aço',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('2e888d99-4a6e-46a4-ad91-db6ca057515a','Buchinha de pia',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('3a8af1ee-237a-4264-84ca-5849138bfed2','Sabão em pedra',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('ddaf9594-8bc6-4ccc-8264-8a18fab9cf36','Sabonete',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('68a45d60-2a38-44ee-845d-17b30c942991','Shampo',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('125d8724-118d-4ec9-a578-6b82132a7ea6','Condicionador',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('11fb85d9-c428-483f-874b-9d6580566b7b','Desinfetante',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
;
INSERT INTO product (id,description,unit,category) VALUES 
('02adb4d0-fae6-485b-b958-38a12b947d99','Lustra móveis',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('b41e9fa3-7f83-4d97-a711-d1d767a7dae0','Tira manchas',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('6f5010d6-bb64-47bb-a571-081351887ec9','Limpa vidros',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('2c535101-8cbd-4968-a096-b5d9bd25f416','Alcool',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('2231afe1-0479-488c-8d4a-fc4a7605f27c','Saco de lixo 30l',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('31207098-0580-47a0-81c6-e19e35efeed4','Saco de lixo 50l',0,'f522fc1a-f7f7-4bee-8693-858f3e5179be')
,('ab328599-7672-4e65-a628-a817dc359d01','Refrigerante',3,'f225086c-d130-4f0c-beef-4cb4325d32be')
,('1db13610-0c26-488e-b09c-75f7caac66ec','Suco garrafa',3,'f225086c-d130-4f0c-beef-4cb4325d32be')
,('d0bcaf2e-b347-480e-a87e-fd9c8c9a427e','Suco caixinha 500ml',2,'f225086c-d130-4f0c-beef-4cb4325d32be')
,('041b3106-08a4-439a-a4e8-cb4750265eec','Suco sachê',0,'f225086c-d130-4f0c-beef-4cb4325d32be')
;
INSERT INTO product (id,description,unit,category) VALUES 
('dca61570-8f22-4777-9175-a5a398a6c8b9','Leite integral',3,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('9d2bd7c7-4c51-4de6-be2e-e8a4dd766e4d','Leite desnatado',3,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('95690b4f-2129-490c-bfc7-573304ed09f6','Arroz',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('f46133c1-d23e-4db0-bc2a-93ebeaa8319d','Feijão',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('a10580a7-d7d8-4068-8e2f-b8279c6a7046','Macarrão',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('652b24af-b77b-4298-84a8-2499ea4f57dd','Extrato de tomate',0,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('ddfa481b-8fab-41e8-976d-6e4ce97145de','Molho de tomate',0,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('0306d56b-8281-4564-9139-4f5d0775d3cf','Sal',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('fde775c2-e199-4d60-a62c-c7c16eca3fd1','Açucar',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('dade3876-bda9-47b5-a86c-dc175b575e39','Achocolatado',0,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
;
INSERT INTO product (id,description,unit,category) VALUES 
('960b02c1-490c-4246-ad25-06bc3d33937b','Bolacha',11,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('24a3ff59-b8c2-47bf-b0b0-a4ba78894457','Café',0,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('5b0b276f-f9b4-48fe-8b55-870299d9138c','Farofa',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('367af093-48d8-4500-8fea-35e33e233bee','Fubá',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('61f0665e-31a5-4ac3-a1dc-d5a95893a441','Farinha de trigo',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('31938106-ee21-4faf-8314-655a915950fb','Farinha de milho',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('8bf5ae51-1c34-4ee3-9124-6fd79bef0798','Farinha de mandioca',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('b431b18d-5163-4217-8cf6-260b75adbbec','Sardinha',10,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('e9a71303-3d0d-491f-8001-61309b747c47','Atum',10,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('02f54391-870e-4cfc-bca4-3c84b0a8d6f1','Maionese',0,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
;
INSERT INTO product (id,description,unit,category) VALUES 
('86483a13-bb95-483b-a33c-26bf202d8d82','Molho de pimenta',0,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('f28f033a-a779-444e-8ca0-b84f9229b58d','Ervilha',10,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('724fcf96-d240-424a-a17e-be0da6bda9bc','Milho verde',10,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('7f50f499-e07b-4fa1-b9c9-8927ae16eb6e','Doce de leite',10,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('43d0555b-be11-4bb9-8df6-b1d9c8ec70f0','Goiabada',10,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('7d0208ca-495b-4e6c-8c78-451e9084bcde','Milho de pipoca',4,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('65af691b-6db1-41e3-bf28-c6cba908cd51','Óleo de cozinha',9,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('9c2b00db-fd8a-49ab-addd-f93804b368a8','Leite em pó',10,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('d07a91f4-8d18-4a0d-b1bf-655d2ee1083a','Creme de leite',6,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('b1e980e2-b73f-43ad-935c-6e7ac685f05f','Leite condensado',6,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
;
INSERT INTO product (id,description,unit,category) VALUES 
('c4df50e4-03a6-424d-b155-1c44487bb74a','Pão de forma',0,'e0801827-cdf6-4b54-a61a-1b14c8ef80ba')
,('8b3b6fe7-d8db-4b8f-ad11-fa57667fc475','Couve',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('91b4b3d7-3c1f-44dd-a517-17722b1a7c92','Batata',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('03193470-d52c-4f2e-a2f8-afefa71e5d97','Tomate',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('b61f2ca8-e823-4492-9d21-b18436ed249d','Cenoura',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('880276bc-296f-4a29-9532-e7a0aa9a09d3','Beterraba',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('6b92175f-846f-4356-bb1f-be6ed8cdad18','Chicória',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('876b719c-c0d6-425e-904f-624212a4c258','Mandioca',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('e58ba93b-6404-43ed-aa55-1c5071ffce2c','Chuchu',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('f70e8da8-be36-4ac4-865e-70c05488832d','Espinafre',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
;
INSERT INTO product (id,description,unit,category) VALUES 
('ffba12fa-09ae-4a99-b70c-785924a7a401','Banana',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('67834f40-8945-46a7-80ef-fefffc51ccce','Ovos',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('4f0a3cb6-6443-474e-901f-a7386a6ad99d','Uva',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('b17145fd-d48f-422c-9567-f7f2802418ba','Mamão',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('37204ee0-2253-485a-95e6-bee0e1d65ff8','Melancia',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('e01ea206-2128-4da3-b43d-1cceae7a0379','Melão',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('1f7878cf-39fe-41fe-8814-195d5a675900','Jiló',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('c7f68901-4aa8-4cfa-bbe0-a3425f18dcf6','Quiabo',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('7aeca6a3-966d-415d-b76b-7319fb9cb9d2','Salsa',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
;
INSERT INTO product (id,description,unit,category) VALUES 
('e85b1de9-f11c-4400-a470-e7303882da79','Cheiro verde',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('3e2e318c-0ee5-434f-91dd-e852330cc3de','Cebola',4,'46df924c-5076-49eb-8bb4-754788dbeb52')
,('93d1b0f7-6f2a-4346-b877-75d2b86bc7ff','Queijo Minas',11,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('94c66cf0-fc17-454a-842f-065fa864c438','Queijo Mussarela',11,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('009e6a10-b1dd-4497-a224-0fb70e974115','Manteiga',0,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('24dd9972-2ed3-4311-adbc-7af689d85b5a','Margarina',0,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('259a1b2b-809e-42af-a9e6-dae9d340cb6b','Iogurte',3,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('afa6e8f1-3a3e-440a-8ec3-88d85da5b2b8','Presunto',5,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('8b5aec72-7990-431a-9413-90ef1e3de371','Salsicha',11,'c2bd0719-7dbb-4f76-9d2e-d5f7d959cd2a')
,('cb641a9a-c2d7-44c5-ac0a-b91956b24bbf','Peixe',4,'a84de458-8892-45e2-8463-c94b25042523')
;
INSERT INTO product (id,description,unit,category) VALUES 
('8bc40de4-ab97-4894-99ea-e01ce1e7a703','Frango',4,'a84de458-8892-45e2-8463-c94b25042523')
;