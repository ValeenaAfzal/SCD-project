/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */
package com.mycompany.scdproject;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import javax.swing.JPanel;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author Valeena Afzal
 */
public class EntryOperatorTest {
    
    public EntryOperatorTest() {
    }

    /**
     * Test of ListInventory method, of class EntryOperator.
     */
    @Test
    public void testListInventory() {
        
    }

    /**
     * Test of ListOrder method, of class EntryOperator.
     */
    @Test
    public void testListOrder() 
    {
        
    }

    /**
     * Test of GenerateOPdf method, of class EntryOperator.
     */
    @Test
    public void testGenerateOPdf() {
        EntryOperator NewOp= new EntryOperator();
        NewOp.GeneratePdf();
        File tempFile = new File("myPdf.pdf");
        boolean exists = tempFile.exists();
        
    }

    /**
     * Test of GeneratePdf method, of class EntryOperator.
     */
    @Test
    public void testGeneratePdf() {
        
    }

    /**
     * Test of SwitchPanels method, of class EntryOperator.
     */
    @Test
    public void testSwitchPanels() {
        
    }

    /**
     * Test of main method, of class EntryOperator.
     */
    @Test
    public void testMain() {
        
    }
    
}
