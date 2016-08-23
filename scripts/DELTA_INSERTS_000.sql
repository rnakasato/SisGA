BEGIN;
	-- INSERTS DE TIPO_VENDA
	INSERT INTO TIPO_VENDA (ID_TIPO_VENDA, DESCRIPTION, INSERTDATE)
	VALUES(1, 'Caixa', NOW());

	-- INSERTS DE TIPO_UNIDADE
	INSERT INTO TIPO_UNIDADE (ID_TIPO_UNIDADE, DESCRIPTION, INSERTDATE)
	VALUES(1, 'Bandeja', NOW());

	INSERT INTO TIPO_UNIDADE (ID_TIPO_UNIDADE, DESCRIPTION, INSERTDATE)
	VALUES(2, 'Lata', NOW());

	-- INSERTS DE TIPO_PRODUCAO
	INSERT INTO TIPO_PRODUCAO (ID_TIPO_PRODUCAO, DESCRIPTION,  INSERTDATE,   ID_TIPO_UNIDADE)
	VALUES(1, 'Mudas', NOW(), 1);

	INSERT INTO TIPO_PRODUCAO (ID_TIPO_PRODUCAO, DESCRIPTION,  INSERTDATE,   ID_TIPO_UNIDADE)
	VALUES(2, 'Sementes', NOW(), 2);
COMMIT;