package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

public class CategoryTestCase {

	private static AnnotationConfigApplicationContext context;

	private static CategoryDAO categoryDAO;

	private Category category;

	// we here initialize contest and categoryDAO
	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		categoryDAO = (CategoryDAO) context.getBean("categoryDAO");
	}

//	 to test add method in CategoryDAOImpl
//	 @Test
//	 public void testAddCategory() {
//	
//	 category = new Category();
//	
//	 category.setName("Televsion");
//	 category.setDescription("This is some description for televsion!");
//	 category.setImageURL("CAT_2.png");
//	
//	// // this is the result of test , true param is the return type we expect
//	// from the the addCategory mthod in the
//	// // categoryDAOImp Class .
//	 assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//	
//	 }
	

//	@Test
//	public void testGetCategory() {
//
//		category = categoryDAO.get(3);
//
//		assertEquals("Successfully fetched a single category from the table!", "Mobile", category.getName());
//
//	}
	
//	@Test
//	public void testUpdateCategory() {
//		
//		category = categoryDAO.get(2);
//		
//		category.setName("TV");
//		
//		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
//		
//		
//	}
	
	@Test
	public void testDeleteCategory() {
		
		category = categoryDAO.get(4);		
		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
		
		
	}
	
//	@Test
//	public void testCRUDCategory() {
//		
//		// add operation
//		category = new Category();
//		
//		category.setName("Laptop");
//		category.setDescription("This is some description for laptop!");
//		category.setImageURL("CAT_1.png");
//		
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//		
//		
//		category = new Category();
//		
//		category.setName("Television");
//		category.setDescription("This is some description for television!");
//		category.setImageURL("CAT_2.png");
//		
//		assertEquals("Successfully added a category inside the table!",true,categoryDAO.add(category));
//
//		
//		// fetching and updating the category
//		category = categoryDAO.get(2);
//		
//		category.setName("TV");
//		
//		assertEquals("Successfully updated a single category in the table!",true,categoryDAO.update(category));
//		
//		
//		// delete the category
//		assertEquals("Successfully deleted a single category in the table!",true,categoryDAO.delete(category));
//		
//		
////		//fetching the list
////		assertEquals("Successfully fetched the list of categories from the table!",7,categoryDAO.list().size());		
////				
//		
//	}
	

}
