package easp.facade;

import easp.UserInterface.EASPCMD;
import easp.UserInterface.EASPCMDEnum;

public class Main {
	
	public static void main(String[] args) {
		Main main = new Main();
		StringBuilder input = main.getCommandLine(args);
		
		String guiFlag = main.getParameterValue(EASPCMDEnum.GUIFLAG, input);
		if (guiFlag.equals("0")){
			main.runCMD();
		} else {
			main.runGUI();
		} 
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
    
	private void runCMD() {
		EASPCMD cmdUI = new EASPCMD();
		cmdUI.start();
	}

	private void runGUI() {
		// TODO Auto-generated method stub
		
	}

}
