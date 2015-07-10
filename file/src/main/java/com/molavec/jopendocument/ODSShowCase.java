package com.molavec.jopendocument;

import java.io.File;
import java.io.IOException;

import org.jopendocument.dom.OOUtils;
import org.jopendocument.dom.spreadsheet.Sheet;
import org.jopendocument.dom.spreadsheet.SpreadSheet;

public class ODSShowCase {

	
	private static String template = "resources/template.ods";
	private static String output = "resources/output.ods";
	private static Sheet sheet;
	
	public static void main(String[] args) throws IOException {
		
		File templateFile = new File(template);
		sheet = SpreadSheet.createFromFile(templateFile).getSheet(0);
		sheet.getCellAt("A1").setValue("New Title");
		
		sheet.getCellAt("A2").setValue("Data 1");
		sheet.getCellAt("B2").setValue("Data 2");

		sheet.getCellAt("A3").setValue(10f);
		sheet.getCellAt("A4").setValue(20f);
		
		// Save to file and open both file to compare.
		File outputFile = new File(output);
		OOUtils.open(sheet.getSpreadSheet().saveAs(outputFile));
		OOUtils.open(templateFile);
		
	}

}
