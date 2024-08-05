INSERT INTO public.cliente (nome,cpf) VALUES
	 ('Geraldo Pedro Julio Nascimento','05870189179'),
	 ('Vitória Alícia Mendes','20623850567'),
	 ('Teresinha Daniela Galvão','04372012950'),
	 ('Gabriel Rafael Dias','85067950013'),
	 ('Andreia Emanuelly da Mata','27737287426'),
	 ('Natália Sandra da Cruz','03763001590'),
	 ('Catarina Sebastiana Analu Almeida','88901767767'),
	 ('Hadassa Daniela Sales','1051252612'),
	 ('Kaique Danilo Alves','20634031392'),
	 ('Pietra Antônia Brenda Silva','74302668512');
INSERT INTO public.cliente (nome,cpf) VALUES
	 ('Maitê Kamilly Corte Real','022484638124'),
	 ('Isis Isis Ramos','29457224965'),
	 ('Fabiana Melissa Nunes','824643755772'),
	 ('Ian Joaquim Giovanni Santos','96718391344');



INSERT INTO public.compra (cliente_id,ano) VALUES
	 (11,2021),
	 (1,2018),
	 (1,2022),
	 (1,2021),
	 (1,2022),
	 (1,2019),
	 (2,2018),
	 (3,2021),
	 (3,2021),
	 (3,2021);
INSERT INTO public.compra (cliente_id,ano) VALUES
	 (4,2018),
	 (4,2020),
	 (5,2022),
	 (5,2021),
	 (5,2020),
	 (5,2018),
	 (5,2020),
	 (5,2021),
	 (6,2017),
	 (6,2021);
INSERT INTO public.compra (cliente_id,ano) VALUES
	 (7,2017),
	 (7,2019),
	 (8,2020),
	 (8,2018),
	 (8,2019),
	 (9,2019),
	 (10,2020),
	 (11,2022),
	 (12,2019),
	 (12,2018);
INSERT INTO public.compra (cliente_id,ano) VALUES
	 (13,2019),
	 (13,2021),
	 (14,2022),
	 (14,2021),
	 (14,2020),
	 (14,2018),
	 (14,2020);


INSERT INTO public.compra_vinho (compra_id,vinho_id,quantidade,valor_total) VALUES
	 (38,1,6,1379.94),
	 (42,2,5,632.5),
	 (41,5,3,386.97),
	 (40,10,2,261.5),
	 (39,15,4,755.96),
	 (43,1,8,1839.92),
	 (46,4,2,268.5),
	 (44,14,3,402.75),
	 (45,20,3,392.25),
	 (47,17,6,751.5);
INSERT INTO public.compra_vinho (compra_id,vinho_id,quantidade,valor_total) VALUES
	 (48,19,4,542.0),
	 (51,3,2,243.5),
	 (50,4,4,537.0),
	 (49,5,6,773.94),
	 (53,13,5,608.75),
	 (54,14,5,671.25),
	 (52,17,3,375.75),
	 (56,4,4,537.0),
	 (55,6,6,1965.0),
	 (58,2,4,506.0);
INSERT INTO public.compra_vinho (compra_id,vinho_id,quantidade,valor_total) VALUES
	 (57,16,6,765.0),
	 (59,19,6,406.5),
	 (60,17,6,375.75),
	 (61,12,6,213.0),
	 (62,8,3,362.97),
	 (63,3,3,365.25),
	 (65,15,4,755.96),
	 (54,19,6,813.0),
	 (67,1,4,919.96),
	 (66,18,6,725.94);
INSERT INTO public.compra_vinho (compra_id,vinho_id,quantidade,valor_total) VALUES
	 (69,10,10,1307.5),
	 (68,18,2,241.98),
	 (70,15,6,1133.94),
	 (71,14,4,537.0),
	 (72,3,20,2435.0),
	 (73,17,13,1628.25),
	 (74,3,15,1897.5),
	 (64,19,6,813.0);
INSERT INTO public.vinho (tipo_vinho,preco,safra,ano_compra) VALUES
	 ('Tinto',229.99,'2017',2018),
	 ('Branco',126.50,'2018',2019),
	 ('Rosé',121.75,'2019',2020),
	 ('Espumante',134.25,'2020',2021),
	 ('Chardonnay',128.99,'2021',2022),
	 ('Tinto',327.50,'2016',2017),
	 ('Branco',125.25,'2017',2018),
	 ('Rosé',120.99,'2018',2019),
	 ('Espumante',135.50,'2019',2020),
	 ('Chardonnay',130.75,'2020',2021);
INSERT INTO public.vinho (tipo_vinho,preco,safra,ano_compra) VALUES
	 ('Tinto',128.99,'2017',2018),
	 ('Branco',106.50,'2018',2019),
	 ('Rosé',121.75,'2019',2020),
	 ('Espumante',134.25,'2020',2021),
	 ('Chardonnay',188.99,'2021',2022),
	 ('Tinto',127.50,'2016',2017),
	 ('Branco',125.25,'2017',2018),
	 ('Rosé',120.99,'2018',2019),
	 ('Espumante',135.50,'2019',2020),
	 ('Chardonnay',130.75,'2020',2021);
