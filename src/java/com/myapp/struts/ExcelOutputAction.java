/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.myapp.struts;

import java.io.FileInputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.util.Random;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.struts.action.ActionForm;
import org.apache.struts.action.ActionForward;
import org.apache.struts.action.ActionMapping;

/**
 *
 * @author hi9a
 */
public class ExcelOutputAction extends org.apache.struts.action.Action {

    /**
     * This is the action called from the Struts framework.
     *
     * @param mapping The ActionMapping used to select this instance.
     * @param form The optional ActionForm bean for this request.
     * @param request The HTTP Request we are processing.
     * @param response The HTTP Response we are processing.
     * @throws java.lang.Exception
     * @return
     */
    @Override
    public ActionForward execute(ActionMapping mapping, ActionForm form,
            HttpServletRequest request, HttpServletResponse response)
            throws Exception {
        ExcelOutputForm excelForm = null;
        HSSFWorkbook wookbook = null;
        response.setContentType("application/vnd.ms-excel");
        // filename=日本語にしても反映されない。文字コード指定しなければいけない？
        response.setHeader(
            "Content-Disposition", "attachment; filename=unsei.xls");
        try(OutputStream os = response.getOutputStream()) {
            try(InputStream is = 
                    new FileInputStream(
                            "/web/WEB-INF/excel/play.xls")) {
                String cellValue;
                // excelテンプレにformの値を入れる。
                excelForm = (ExcelOutputForm)form;
                wookbook = new HSSFWorkbook(is);
                wookbook.createFont().setFontName("Hiragino Maru Gothic ProN");

                cellValue = getUTFEightOf(excelForm.getName());
                setCellValue(wookbook, 1, 0, cellValue);

                cellValue = getFortune();
                setCellValue(wookbook, 1, 1, cellValue);
                
                wookbook.write(os);
                os.flush();
            }
        }      
        return null;
    }
    
    private void setCellValue(HSSFWorkbook wookbook, 
            int rowIndex, int columnIndex, String cellValue) {
        HSSFSheet sheet = wookbook.getSheet("Sheet1");
        HSSFRow row = sheet.getRow(rowIndex);
        HSSFCell cell = row.getCell(columnIndex);
        cell.setCellValue(cellValue);
    }
    
    /* 
    struts……というかServletだと、
    Formの文字コードをISO-8859-1として取得するらしいっす。
    だからUTF-8に変換するっす。
    */
    private String getUTFEightOf(String string)
            throws UnsupportedEncodingException {
        return new String(string.getBytes("ISO-8859-1"), "UTF-8");
    }
    
    private String getFortune() {
        int i = (new Random().nextInt(5));
        String f;
        switch(i) {
            case 4:
                f = "大吉";
            break;
            case 3:
                f = "凶";
            break;
            default:
                f = "吉";
        }
        return f;
    }
}
