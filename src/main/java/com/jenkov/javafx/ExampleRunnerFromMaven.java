package com.jenkov.javafx;

import java.lang.reflect.InvocationTargetException;
import java.util.Arrays;

import com.jenkov.javafx.button.ButtonExample;
import com.jenkov.javafx.webview.WebViewExample;

public class ExampleRunnerFromMaven {

    public static void main(String[] args) {
	try {
	    String[] params = Arrays.copyOfRange(args, 1, args.length);
	    Class.forName(args[0]).getMethod("main", String[].class)
		    .invoke(null, (Object) params);
	} catch (IllegalAccessException | IllegalArgumentException
		| InvocationTargetException | NoSuchMethodException
		| SecurityException | ClassNotFoundException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}

    }

}
