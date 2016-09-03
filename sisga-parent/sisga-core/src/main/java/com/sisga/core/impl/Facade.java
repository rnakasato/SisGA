package com.sisga.core.impl;

import java.util.ArrayList;
import java.util.List;

import com.sisga.core.IDAO;
import com.sisga.core.IFacade;
import com.sisga.core.IStrategy;
import com.sisga.core.application.Result;
import com.sisga.core.enums.EOperation;
import com.sisga.core.factory.impl.FactoryDAO;
import com.sisga.core.factory.impl.FactoryPostStrategy;
import com.sisga.core.factory.impl.FactoryStrategy;
import com.sisga.domain.AbstractEntity;

public class Facade<T extends AbstractEntity> implements IFacade<T> {

	private Result result;

	public Facade() {

	}

	@Override
	public Result<T> save(T entity) {
		Result<T> result = new Result<T>();
		String msg = runRules(entity, EOperation.SAVE);

		if (msg == null) {

			try {
				IDAO dao = FactoryDAO.build(entity.getClass());
				dao.save(entity);
				List<T> entityList = new ArrayList<T>();
				entityList.add(entity);
				result.setEntityList(entityList);
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("Erro inesperado ao salvar!");
			}
			runPostRules(entity, EOperation.SAVE);
		} else {
			result.setMsg(msg);
		}

		return result;
	}

	@Override
	public Result<T> update(T entity) {
		Result<T> result = new Result<T>();

		String msg = runRules(entity, EOperation.UPDATE);

		if (msg == null) {

			try {
				IDAO dao = FactoryDAO.build(entity.getClass());
				dao.update(entity);
				List<T> entityList = new ArrayList<T>();
				entityList.add(entity);
				result.setEntityList(entityList);
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("Não foi possível realizar a alteração!");
			}
			runPostRules(entity, EOperation.UPDATE);
		} else {
			result.setMsg(msg);
		}

		return result;

	}

	@Override
	public Result<T> delete(T entity) {
		Result<T> result = new Result<T>();

		String msg = runRules(entity, EOperation.DELETE);

		if (msg == null) {
			try {
				IDAO dao = FactoryDAO.build(entity.getClass());
				dao.delete(entity);
				List<T> entityList = new ArrayList<T>();
				entityList.add(entity);
				result.setEntityList(entityList);
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("Não foi possível deletar o item!");
			}
		} else {
			result.setMsg(msg);
		}

		return result;

	}

	@Override
	public Result<T> find(T entity) {
		Result<T> result = new Result<T>();

		String msg = runRules(entity, EOperation.FIND);

		if (msg == null) {
			try {
				IDAO dao = FactoryDAO.build(entity.getClass());
				result.setEntityList(dao.find(entity));
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("Não foi possível realizar a consulta!");
			}
		} else {
			result.setMsg(msg);

		}

		return result;
	}

	@Override
	public Result<T> view(T entity) {
		Result<T> result = new Result<T>();
		result.setEntityList(new ArrayList<T>(1));
		result.getEntityList().add(entity);
		return result;

	}

	private String runRules(T entity, String operation) {
		StringBuilder msg = null;
		List<IStrategy> rules = FactoryStrategy.build(entity, operation);
		if (rules != null) {
			msg = new StringBuilder();
			for (IStrategy s : rules) {
				String m = s.process(entity);
				if (m != null) {
					msg.append(m);
					break;
				}
			}
		}
		String messages = null;
		if (msg.length() > 0) {
			messages = msg.toString();
		}
		return messages;
	}

	private String runPostRules(T entity, String operation) {
		StringBuilder msg = null;
		List<IStrategy> rules = FactoryPostStrategy.build(entity, operation);
		if (rules != null) {
			msg = new StringBuilder();
			for (IStrategy s : rules) {
				String m = s.process(entity);
				if (m != null) {
					msg.append(m);
					break;
				}
			}
		}
		String messages = null;
		if (msg.length() > 0) {
			messages = msg.toString();
		}
		return messages;
	}

	@Override
	public Result<T> findAll(T entity) {
		Result<T> result = new Result<T>();

		String msg = runRules(entity, EOperation.FIND);

		if (msg == null) {
			try {
				IDAO dao = FactoryDAO.build(entity.getClass());
				result.setEntityList(dao.findAll());
			} catch (Exception e) {
				e.printStackTrace();
				result.setMsg("Não foi possível realizar a consulta!");
			}
		} else {
			result.setMsg(msg);

		}

		return result;
	}

	@Override
	public Result<T> doRules(T entity, Integer parameter) {
		// TODO Verificar se vai ser usado
		Result<T> result = new Result<T>();
		StringBuilder msg = null;
//		List<IStrategy> rules = FactoryCustomStrategy.build(entity, parameter);
		List<IStrategy> rules = null;
		if (rules != null) {
			msg = new StringBuilder();
			for (IStrategy s : rules) {
				String m = s.process(entity);
				if (m != null) {
					msg.append(m);
					break;
				}
			}
		}
		String messages = null;
		if (msg.length() > 0) {
			messages = msg.toString();
			result.setMsg(messages);
		}
		return result;
	}

}
