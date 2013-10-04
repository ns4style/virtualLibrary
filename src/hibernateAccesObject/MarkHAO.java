package hibernateAccesObject;

import hibernateMappingClass.Mark;
import hibernateUtil.HibernateUtil;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import org.hibernate.Session;

public class MarkHAO {
	public void addMark(Mark mark) {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.save(mark);
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

	public void updateMark(Mark mark) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.update(mark);
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

	public Mark getMarkById(int id) throws SQLException {
		Session session = null;
		Mark mark = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			mark = (Mark) session.load(Mark.class, id);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return mark;
	}

	public List<Mark> getAllMarks() throws SQLException {
		Session session = null;
		List<Mark> marks = new ArrayList<Mark>();
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			marks = session.createCriteria(Mark.class).list();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.getMessage(), "Ошибка I/O",
					JOptionPane.OK_OPTION);
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
		return marks;
	}

	public void deleteMark(Mark mark) throws SQLException {
		Session session = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			session.beginTransaction();
			session.delete(mark);
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
}