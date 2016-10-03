package easp;

import easp.facade.EASPFacadeImpl;
import easp.facadeAPI.EASPFacade;
import easp.userInterface.EASPCMD;
import easp.userInterface.EASPCMDEnum;
import easp.userInterface.EASPGUI;
import easp.userInterfaceAPI.EASPUserInterface;

public class EASPMain {
	
	public static void main(String[] args) {
		EASPMain main = new EASPMain();
		StringBuilder input = main.getCommandLine(args);
		
		String guiFlag = main.getParameterValue(EASPCMDEnum.GUIFLAG, input);
		EASPUserInterface ui;
		if (guiFlag.equals("0")){
			ui = new EASPCMD();
		} else {
			ui = new EASPGUI();
		} 
		EASPFacade facade = new EASPFacadeImpl();
		facade.startUI(ui);
	}

	private StringBuilder getCommandLine(String[] args){
		StringBuilder stringBuilder = new StringBuilder(100);
		final int size = args.length;
		for (int i = 0; i<size; i++){
			stringBuilder.append(args[i]);
		}
		return stringBuilder;
	}
	
	private int findNextCut(int index, EASPCMDEnum cmdEnum, StringBuilder input) {
        int currentIndex = 0;
        int localMinimum = input.length();
        for (EASPCMDEnum tempCMDEnum : EASPCMDEnum.values()) {
            if(tempCMDEnum != cmdEnum) {
                currentIndex = input.indexOf(tempCMDEnum.getIdentifier());
                localMinimum = ((currentIndex > index) && (currentIndex < localMinimum)) ? currentIndex : localMinimum;
            }
        }
        return localMinimum;
    }    
    
    private String getParameterValue(EASPCMDEnum cmdEnum, StringBuilder input) {
        String result = null;
        int index = input.indexOf(cmdEnum.getIdentifier());
        if(index > -1) {
           int delta = cmdEnum.getIdentifier().length();
           result =  input.substring(index + delta, findNextCut(index, cmdEnum, input)).trim();
        }
        return result;
    }

}
