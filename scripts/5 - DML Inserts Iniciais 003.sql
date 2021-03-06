-- INSERTS DE TB_CUSTOMER_OPERATION

BEGIN TRANSACTION;

INSERT INTO TB_CUSTOMER_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_CUSTOMER_OPERATION' ), 'ADD', 'CADASTRO DE CLIENTE');

INSERT INTO TB_CUSTOMER_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_CUSTOMER_OPERATION' ), 'ALT', 'ALTERACAO DE CLIENTE');

INSERT INTO TB_CUSTOMER_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_CUSTOMER_OPERATION' ), 'DEL', 'EXCLUSAO DE CLIENTE');

COMMIT;


-- INSERTS DE TB_PROVIDER_OPERATION

BEGIN TRANSACTION;

INSERT INTO TB_PROVIDER_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_PROVIDER_OPERATION' ), 'ADD', 'CADASTRO DE FORNECEDOR');

INSERT INTO TB_PROVIDER_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_PROVIDER_OPERATION' ), 'ALT', 'ALTERACAO DE FORNECEDOR');

INSERT INTO TB_PROVIDER_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_PROVIDER_OPERATION' ), 'DEL', 'EXCLUSAO DE FORNECEDOR');

COMMIT;

-- INSERTS DE TB_EMPLOYEE_OPERATION

BEGIN TRANSACTION;

INSERT INTO TB_EMPLOYEE_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_EMPLOYEE_OPERATION' ), 'ADD', 'CADASTRO DE FUNCIONARIO');

INSERT INTO TB_EMPLOYEE_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_EMPLOYEE_OPERATION' ), 'ALT', 'ALTERACAO DE FUNCIONARIO');

INSERT INTO TB_EMPLOYEE_OPERATION(IDOPERATION,CODE,DESCRIPTION)
VALUES ( nextval ( 'SQ_EMPLOYEE_OPERATION' ), 'DEL', 'EXCLUSAO DE FUNCIONARIO');

COMMIT;
