-- public.cliente definition

-- Drop table

-- DROP TABLE public.cliente;

CREATE TABLE public.cliente (
	id bigserial NOT NULL,
	nome varchar(255) NOT NULL,
	cpf varchar(255) NOT NULL,
	CONSTRAINT cliente_pkey PRIMARY KEY (id)
);


-- public.vinho definition

-- Drop table

-- DROP TABLE public.vinho;

CREATE TABLE public.vinho (
	codigo bigserial NOT NULL,
	tipo_vinho varchar(255) NOT NULL,
	preco numeric(38, 2) NOT NULL,
	safra varchar(255) NOT NULL,
	ano_compra int4 NOT NULL,
	CONSTRAINT vinho_pkey PRIMARY KEY (codigo)
);


-- public.compra definition

-- Drop table

-- DROP TABLE public.compra;

CREATE TABLE public.compra (
	id bigserial NOT NULL,
	cliente_id int8 NULL,
	ano int4 NULL,
	CONSTRAINT compra_pkey PRIMARY KEY (id),
	CONSTRAINT compra_cliente_id_fkey FOREIGN KEY (cliente_id) REFERENCES public.cliente(id)
);


-- public.compra_vinho definition

-- Drop table

-- DROP TABLE public.compra_vinho;

CREATE TABLE public.compra_vinho (
	compra_id int8 NOT NULL,
	vinho_id int8 NOT NULL,
	quantidade int4 NULL,
	valor_total numeric(38, 2) NULL,
	CONSTRAINT compra_vinho_pkey PRIMARY KEY (compra_id, vinho_id),
	CONSTRAINT fkh6yg417ourj2ekk795uqbjj2d FOREIGN KEY (vinho_id) REFERENCES public.vinho(codigo),
	CONSTRAINT fkspopvs7qtml4ch0nh7wbl3dpd FOREIGN KEY (compra_id) REFERENCES public.compra(id)
);