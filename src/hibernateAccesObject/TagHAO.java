package hibernateAccesObject;

import hibernateMappingClass.Genre;
import hibernateMappingClass.Tag;
import hibernateUtil.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.hibernate.criterion.Expression;

public class TagHAO {
	public void addTag(Tag tag) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(tag);
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

	public void updateTag(Tag tag) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(tag);
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

	public Tag getTagById(int id) throws SQLException {
		Session session = null;
		Tag tag = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tag = (Tag) session.createQuery("from Tag where id=" + id).list().get(0);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return tag;
	}

	public List<Tag> getAllTags() throws SQLException {
		Session session = null;
		List<Tag> tags = new ArrayList<Tag>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tags = session.createCriteria(Tag.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return tags;
	}

	public void deleteTag(Tag tag) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(tag);
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
	
	public Tag getTagByName(String name) {
		Session session = null;
		List<Tag> tags = new ArrayList<Tag>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			tags = session.createCriteria(Tag.class).add(Expression.like("value", name)).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		if (!tags.isEmpty())
			return tags.get(0);
		else
			return null;
	}
}
