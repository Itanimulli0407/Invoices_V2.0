package easp.service;

import easp.commands.EASPCommand;
import easp.commands.EASPCommandEnum;
import easp.exceptions.EASPException;
import easp.exceptions.EASPExceptionEnum;
import easp.facadeAPI.EASPFacade;
import easp.serviceAPI.EASPCommandService;

public class EASPCommandServiceImpl implements EASPCommandService {

	private EASPFacade facade;

	public EASPCommandServiceImpl(EASPFacade facade) {
		this.facade = facade;
	}

	@Override
	public EASPCommand createCommand(String input) {
		EASPCommand result = null;
		switch (input) {
		case "exit":
			result = new EASPCommand(EASPCommandEnum.EXIT);
			break;
		default:
			result = new EASPCommand(EASPCommandEnum.DEFAULT);
			break;
		}
		return result;
	}

	@Override
	public void executeCommand(EASPCommand command) throws EASPException {
		if (command.getType().equals(EASPCommandEnum.EXIT)) {
			facade.closeUI();
		} else /* unknown command */ {
			throw new EASPException(EASPExceptionEnum.E005, new NullPointerException(), command.getType().toString());
		}
	}

}
