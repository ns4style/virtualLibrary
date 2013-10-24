package hibernateAccesObject;

import hibernateMappingClass.Book;
import hibernateMappingClass.User;
import hibernateUtil.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Expression;
import org.hibernate.criterion.Projections;

public class UserHAO {
	
	public void addUser(User user) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public User getUserByMail(String mail) {
		Session session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			users = session.createCriteria(User.class).add(Expression.like("mail", mail)).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (!users.isEmpty())
			return users.get(0);
		else
			return null;
	}

	public void updateUser(User user) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}

	public User getUserById(int id) throws SQLException {
		Session session = null;
		User user = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			user = (User) session.load(User.class, id);
			Hibernate.initialize(user.getPrivileged());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return user;
	}

	public List<User> getAllUsers() throws SQLException {
		Session session = null;
		List<User> users = new ArrayList<User>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			users = session.createCriteria(User.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return users;
	}

	public void deleteUser(User user) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(user);
			session.getTransaction().commit();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
	
	public Long countUsers(){
		Session session = null;
		Long count = new Long(-1);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			count = (Long) session.createCriteria(User.class).setProjection(Projections.rowCount()).uniqueResult();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return count;
	}
}
