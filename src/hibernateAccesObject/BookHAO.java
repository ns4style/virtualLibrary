package hibernateAccesObject;

import hibernateMappingClass.Book;
import hibernateMappingClass.Mark;
import hibernateUtil.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

import javax.swing.JOptionPane;

import org.hibernate.Hibernate;
import org.hibernate.Session;
import org.hibernate.criterion.Projections;
import org.hibernate.metadata.ClassMetadata;

public class BookHAO {

	public void addBook(Book book) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(book);
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

	public void updateBook(Book book) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(book);
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

	public Book getBooktById(int id) throws SQLException {
		Session session = null;
		Book book = null;
		try {
		    HibernateUtil.getSessionFactory().evictEntity("hibernateMappingClass.Book");
			session = HibernateUtil.getSessionFactory().openSession();
			
			book = (Book) session.createQuery("from Book where id=" + id).list().get(0);
			Hibernate.initialize(book.getName());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return book;
	}
	

	public List<Book> getBooksSelection(int first, int count)
			throws SQLException {
		Session session = null;
		List<Book> books = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			books = session.createQuery("from Book").setFirstResult(first)
					.setMaxResults(count).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return books;
	}

	public List<Book> getRandomBooks(int count) throws SQLException {
		Session session = null;
		List<Book> books = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			books = session.createQuery("from Book order by rand()")
					.setMaxResults(count).list(); // hql сам делает join
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return books;
	}

	public List<Book> getAllBooks() throws SQLException {
		Session session = null;
		List<Book> books = new ArrayList<Book>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			books = session.createQuery("from Book").list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return books;
	}

	public Long getBooksCount() throws SQLException {
		Session session = null;
		Long val = (long) 0;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			val = (Long) (session.createQuery("select count(*) from Book")
					.iterate().next());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return val;
	}

	public void deleteBook(Book book) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(book);
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

	public Long countBooks() {
		Session session = null;
		Long count = new Long(-1);
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			count = (Long) session.createCriteria(Book.class)
					.setProjection(Projections.rowCount()).uniqueResult();
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
