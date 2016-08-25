CREATE TABLE STATUS_PEDIDO
(
	ID_STATUS_PEDIDO serial NOT NULL,
	DESCRIPTION character varying(250) NOT NULL,  
	CODE character varying(4) NOT NULL,  
	INSERTDATE date NOT NULL,
	CONSTRAINT STATUS_PEDIDO_PK PRIMARY KEY (ID_STATUS_PEDIDO)
	
);

CREATE TABLE PEDIDO
(
	ID_PEDIDO serial NOT NULL,
    CODE character varying(8) NOT NULL, 
	INSERTDATE date NOT NULL,
	VALOR_PEDIDO NUMERIC(8,2) not null,
	DATA_ENTREGA date NOT NULL,
	CONSTRAINT PEDIDO_PK PRIMARY KEY (ID_PEDIDO),
	CONSTRAINT PRODUTO_FK FOREIGN KEY(ID_PRODUTO)
    REFERENCES PRODUTO (ID_PRODUTO) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,	
	CONSTRAINT STATUS_PEDIDO_FK FOREIGN KEY(ID_STATUS_PEDIDO)
    REFERENCES STATUS_PEDIDO (ID_STATUS_PEDIDO) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION	
);

CREATE TABLE PRODUTO_PEDIDO
(
	ID_PRODUTO_PEDIDO serial NOT NULL,
	ID_PRODUTO integer NOT NULL,
	ID_STATUS_PEDIDO integer NOT NULL,
	ID_PEDIDO integer NOT NULL,
	INSERTDATE date NOT NULL,
	QUANTIDADE integer not null,
	VALOR NUMERIC(5,2) not null,
	CONSTRAINT PRODUTO_PEDIDO_PK PRIMARY KEY (ID_PRODUTO_PEDIDO),
	CONSTRAINT PRODUTO_FK FOREIGN KEY(ID_PRODUTO)
    REFERENCES PRODUTO (ID_PRODUTO) MATCH SIMPLE
      ON UPDATE NO ACTION ON DELETE NO ACTION,	
	CONSTRAINT STATUS_PEDIDO_FK FOREIGN KEY(ID_STATUS_PEDIDO)
      REFERENCES STATUS_PEDIDO (ID_STATUS_PEDIDO) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION,
	CONSTRAINT PEDIDO_FK FOREIGN KEY(ID_PEDIDO)
      REFERENCES PEDIDO (ID_PEDIDO) MATCH SIMPLE
        ON UPDATE NO ACTION ON DELETE NO ACTION		  
);

-- SEQUENCES
CREATE SEQUENCE SQ_STATUS_PEDIDO START 1;
CREATE SEQUENCE SQ_PEDIDO START 1;
CREATE SEQUENCE SQ_PRODUTO_PEDIDO START 1;

