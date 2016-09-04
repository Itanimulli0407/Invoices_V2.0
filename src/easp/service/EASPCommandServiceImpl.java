package easp.service;

import easp.commands.EASPCommand;
import easp.commands.EASPCommandEnum;
import easp.serviceAPI.EASPCommandService;

public class EASPCommandServiceImpl implements EASPCommandService {

	@Override
	public EASPCommand createCommand(String input) {
		EASPCommand result = null;
		switch(input){
		case "exit":
			result = new EASPCommand(EASPCommandEnum.EXIT);
			break;
		default:
			result = new EASPCommand(EASPCommandEnum.DEAULT);
			break;
		}
		return result;
	}

}
