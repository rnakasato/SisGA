package com.sisga.core.factory.impl;

import java.util.HashMap;
import java.util.Map;

import com.sisga.core.command.impl.Command;
import com.sisga.core.command.impl.CommandDelete;
import com.sisga.core.command.impl.CommandFind;
import com.sisga.core.command.impl.CommandSave;
import com.sisga.core.command.impl.CommandUpdate;
import com.sisga.core.enums.EOperation;
import com.sisga.domain.AbstractDomainEntity;

public class FactoryCommand {
	private static Map < String, Command > commandMap;

	public static Command build( AbstractDomainEntity entity, String operation ) throws ClassNotFoundException {
		if( commandMap == null ) {
			initCommands();
		}
		Command command = commandMap.get( operation );
		if( command != null ) {
			command.setEntity( entity );
		} else {
			throw new ClassNotFoundException();
		}
		return command;
	}

	public static Command build( AbstractDomainEntity entity, String operation, int parameter )
			throws ClassNotFoundException {
		if( commandMap == null ) {
			initCommands();
		}
		Command command = commandMap.get( operation );
		if( command != null ) {
			command.setEntity( entity );
			command.setParameter( parameter );
		} else {
			throw new ClassNotFoundException();
		}
		return command;
	}

	private static void initCommands() {
		commandMap = new HashMap<>();
		commandMap.put( EOperation.SAVE, new CommandSave() );
		commandMap.put( EOperation.UPDATE, new CommandUpdate() );
		commandMap.put( EOperation.DELETE, new CommandDelete() );
		commandMap.put( EOperation.FIND, new CommandFind() );
	}
}
