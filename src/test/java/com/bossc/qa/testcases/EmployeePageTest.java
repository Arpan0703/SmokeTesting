package com.bossc.qa.testcases;


import static org.testng.Assert.assertEquals;

import java.io.IOException;
import java.sql.SQLException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.bossc.qa.base.TestBase;
import com.bossc.qa.pages.Employees;
import com.bossc.qa.pages.LoginPage;
import com.bossc.qa.util.TestUtil;

		public class EmployeePageTest extends TestBase{
			LoginPage loginPage;
			Employees employees;
			TestUtil testutil;
		
			
			String sheetName = "AddingEmployee";
			
			public EmployeePageTest(){
				super();
			                         }

			@BeforeMethod
			public void setUp(){
				initialization();
				testutil = new TestUtil();
				loginPage = new LoginPage();
				employees = new Employees();
				testutil = new TestUtil();
			
				loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
				employees.ComeToEmployeeSection();
				
			                    } 
 
			
			@DataProvider(name="LoginData")
			String [][] getData() throws IOException
			   {
				String path=System.getProperty("user.dir")+"/src/main/java/com/bossc/qa/testdata/DataDriven.xlsx";
				
				int rownum=TestUtil.getRowCount(path, "Sheet1");
				int colcount=TestUtil.getCellCount(path,"Sheet1",1);
				
				String logindata[][]=new String[rownum][colcount];
				
				for(int i=1;i<=rownum;i++)
				{
					for(int j=0;j<colcount;j++)
					{
						logindata[i-1][j]=TestUtil.getCellData(path,"Sheet1", i,j);//1 0
					}
						
				}
			return logindata;
			}
			//*
			
			@Test(priority=3,dataProvider="LoginData")
			public void VerifyNewEmployee(String FirstName, String LastName,String JobTitle, String ManagerName,String HiredDate,String AnnualPay) throws InterruptedException, IOException
			{
			employees.AddNewEmployee(FirstName,LastName,JobTitle,ManagerName,HiredDate,AnnualPay);
				
			
				
			} 
			
		//*/
			
			
			//*
			@Test(priority=4)
			public void VerifyNewDepdent() throws InterruptedException{
		    employees.AddNewDependent();
				

			} 
			//*/
			//*
			@Test(priority=5)
			public void VerifyNewBeneficiary() throws InterruptedException{
		    employees.AddNewBeneficiary();
				

			}
			// */
			
			
			
			///*		
			@Test(priority=6)
			public void VerifyAssignWorkFlow() throws InterruptedException {
			
				employees.AssignWorkFlow();
				
				
			}
			//*/
			
			
			///*
			@Test(priority=7,dependsOnMethods={ "VerifyAssignWorkFlow" })
			public void VerifyRunWorkFlow() throws InterruptedException {
			
				employees.Run_Approve_WorkFlow();
				
				
			}
			//*/
			///*
		    @Test(priority=8)
			public void VerifyAssignTask() throws InterruptedException {
			
				employees.AssignTask();
				
				
			}
			// */
			
		  ///*	
			@Test(priority=9,dependsOnMethods={ "VerifyAssignTask" })
			public void VerifyRunTask() throws InterruptedException {
			
				employees.Run_Approve_Task();
				
				
			}
			//*/
			///*	
			@Test(priority=10)
			public void VerifyEditEmployee() throws InterruptedException {
			
				String EditedEmployeeValue = employees.Employee_Edit();
				assertEquals(EditedEmployeeValue,"LordPrabhu");
				
				
			} 
			//*/
			
		///*
			@Test(priority=11)
			public void VerifyEditDependent() throws InterruptedException {
			
				String EditedValue = employees.Dependent_Edit();
				assertEquals(EditedValue,"Edited");
				
				
			} 
		//*/
		//*
			@Test(priority=12)
			public void VerifyAddService() throws InterruptedException {
			
				employees.Add_Service();
				
				
			} 
			//*/
			///*    
			@Test(priority=23)
			public void VerifyGenerate_Document() throws InterruptedException {
			
				boolean flag = employees.Generate_Document();
		       Assert.assertTrue(flag);
				
			}
			 
			//*/
			
	//*
			//@Test(priority=14)
			//public void VerifyUpload_Document() throws InterruptedException {
			
				//boolean flag = employees.Upload_Document();
		      // Assert.assertTrue(flag);
				
		//	}
			
			//*/
			
			
			
			
			
		///*
			@Test(priority=15,dependsOnMethods={ "VerifyAddService" })
			public void Edit_Service() throws InterruptedException {
			
				boolean flag = employees.Edit_Service();
		       Assert.assertTrue(flag);
				
			} 
			//*/
			
			///*
			@Test(priority=16)
			public void VerifyAddNotes() throws InterruptedException {
			
				String Add_Notes = employees.Add_Note();
				assertEquals(Add_Notes,"hi");
				
			} 
			//*/
			
			
			///*
			@Test(priority=17)
			public void VerifyEditColumn() throws InterruptedException {
			
				String Result_Employee_Edit = employees.Edit_Column();
				assertEquals(Result_Employee_Edit,"January 1, 2019");
				
			} 
			//*/
			 

			

			 // @Test
			//public void VerifyDataBaseTesting() throws ClassNotFoundException, SQLException{
			//.selectQuery();
			//	
				
			//}
			
			
			//*
			
			@Test(priority=17)
			public void VerifyAccountPasswordRequirement() throws InterruptedException {
			
		
			boolean flag = employees.AccountPasswordRequirement();
		       Assert.assertTrue(flag);
				
			} 
			
			//*/
			//*
			
			@Test(priority=17)
			public void VerifyAccountUserNamePasswordSave() throws InterruptedException {
			
		
			boolean flag = employees.AccountUserNamePasswordSave();
		       Assert.assertTrue(flag);
				
			} 
			
			//*/
			
			
			//*
			@Test(priority=17)
			public void VerifyLoggedAudit() throws InterruptedException {
			
			
				boolean flag = employees.LoggedAudit();
		       Assert.assertTrue(flag);
				
				
			} 
			//*/
			
		

			/* 
			 @AfterMethod
			public void tearDown(){
				driver.quit();
			}
			*/
          

}
		