package com.sisga.domain.user;

import com.sisga.domain.DomainSpecificEntity;

public class UserOperation extends DomainSpecificEntity {
	public static final String CADASTRO_USUARIO = "ADD";
	public static final String ALTERACAO_USUARIO = "ALT";
	public static final String EXCLUSAO_USUARIO = "DEL";
	public static final String DESATIVACAO_USUARIO = "DES";
}
