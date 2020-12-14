package com.csc.flame.selenium.keywords;

import java.io.IOException;
import java.io.StringReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


import com.csc.flame.selenium.HtmlObject;
import com.csc.flame.selenium.KeywordResult;
import com.csc.fsg.flame.model.common.ComponentModel;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.springframework.stereotype.Service;

@Service("AnshikaSelectValue")
public class AnshikaSelectValueKeywordHandler implements KeywordHandler {

	public KeywordResult process(WebDriver driver, HtmlObject htmlObject, ComponentModel componentModel, Map testData) {
		KeywordResult result = new KeywordResult();
		String values = testData.get(componentModel.getParam1()).toString();		
		StringReader stringReader = new StringReader(values);
		
		try {
			if (testData.get(componentModel.getParam1() == null || testData.get(componentModel.getParam1()).equals("")){
                            result.setResult(true);
                                result.setmessage(ComponentModel.getkeyword() +"Skiped");
                                  return result;
                                    }
					
				else{
                                  WebElement object1 = HtmlObject.getElement();
                                   
                                  Select oSelect = new oSelect(object1);
                                  oSelect.selectByVisibleText(value);
                                  result.setResult(true);
                                  result.setmessage(ComponentModel.getchild() +"Selected In");
			}
					
			
		} catch (Exception e) {
			e.printStackTrace();
			result.setResult(false);
			result.setMessage(values+" could not be selected in "+componentModel.getChild()
					+" Reason: "+e.getMessage());
		}
		
		return result;
	}

}
