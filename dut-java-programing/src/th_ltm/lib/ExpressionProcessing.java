package th_ltm.lib;

import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

import trong.net.IStringProcessing;

public class ExpressionProcessing implements IStringProcessing {
	private ScriptEngineManager mEngineMgr = null;
	private ScriptEngine mEngine = null;
	
	public ExpressionProcessing() {
		mEngineMgr = new ScriptEngineManager();
		mEngine = mEngineMgr.getEngineByName("JavaScript");
	}
	@Override
	public String process(String string) {
		String result = null;
		if (string != null && string.length() > 0){
			try {
				result = mEngine.eval(string).toString();
			} catch (ScriptException e) {
				result = "syntax error";
			}
		}
		return result;
	}

}
