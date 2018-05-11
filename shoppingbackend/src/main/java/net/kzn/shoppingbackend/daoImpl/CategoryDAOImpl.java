package net.kzn.shoppingbackend.daoImpl;


import java.util.List;

import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import net.kzn.shoppingbackend.dao.CategoryDAO;
import net.kzn.shoppingbackend.dto.Category;

@Repository("categoryDAO")
@Transactional
public class CategoryDAOImpl implements CategoryDAO {

	@Autowired(required = true)
	private SessionFactory sessionFactory;

	
//	public static List<Category> categories = new ArrayList<>() ; 
//	
//	static {
//		
//		Category category = new Category() ; 
//		
//		category.setId(1);
//		category.setName("Television");
//		category.setDescription("TV IS GOOD");
//		
//		categories.add(category);
//
//	    category = new Category() ; 
//		
//		category.setId(2);
//		category.setName("Mobile");
//		category.setDescription("MOBILE IS GOOD");
//		
//		categories.add(category);
//		
//
//		category = new Category() ; 
//		
//		category.setId(3);
//		category.setName("Labtop");
//		category.setDescription("LAPTOP IS GOOD");
//		
//		categories.add(category);
//	}
	
	@Override
	public List<Category> list() {
		
		String selectActiveCategory = "FROM Category WHERE active = :active";
		
		Query query = sessionFactory.getCurrentSession().createQuery(selectActiveCategory);
				
		query.setParameter("active", true);
						
		return query.getResultList();
	}

	/*
	 * Getting single category based on id
	 */
	@Override
	public Category get(int id) {
		return sessionFactory.getCurrentSession().get(Category.class, id) ; 
		}

	@Override
	public boolean add(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().persist(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}

	}

	/*
	 * Updating a single category
	 */
	@Override
	public boolean update(Category category) {

		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

	@Override
	public boolean delete(Category category) {
		
		category.setActive(false);
		
		try {
			// add the category to the database table
			sessionFactory.getCurrentSession().update(category);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}

}
