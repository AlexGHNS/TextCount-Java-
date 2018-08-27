package NA.TextCount;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import org.junit.jupiter.api.Test;
import junit.framework.Assert;

class AppTest {

	//Тест обработки исключений при неправильном пути к файлу
	@Test
	void testPathVoid() {
		String path="";
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			Assert.fail();
		} catch (IOException e) {}
	}
	
	//Тест обработки исключений при пути к файлу равному null
	@Test
	void testPathNull() {
		String path=null;
		try {
			BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(path),"UTF-8"));
			Assert.fail();
		} catch (Exception e) {}
	}
	
	//Тест обработки исключений при reader=null
	@Test
	void testAddStringArrNull() {
		BufferedReader reader = null;
		try {
			App.AddStringArr(reader);
			Assert.fail();
		} catch (Exception e) {}
	}
}
