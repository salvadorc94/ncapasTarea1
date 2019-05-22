package com.uca.capas.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Repository;

import com.uca.capas.domain.Libro;

@Repository
public class LibroDAOImpl implements LibroDAO {

	@PersistenceContext(unitName = "capas")
	private EntityManager entityManager;
	
	@Override
	public List<Libro> findAll() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("select * from public.libro");
		Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
		List<Libro> resulset= query.getResultList();
		return resulset;
	}
	
	@Override
	public int howMany() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT SUM(existencia) FROM public.libro;");
		Query query = entityManager.createNativeQuery(sb.toString());
		int resultado = Integer.parseInt(query.getResultList().get(0).toString());
		return resultado;
	}
	@Override
	public int authors() throws DataAccessException {
		// TODO Auto-generated method stub
		StringBuffer sb = new StringBuffer();
		sb.append("SELECT DISTINCT autor FROM public.libro;");
		Query query = entityManager.createNativeQuery(sb.toString());
		int resultado = query.getResultList().size();
		return resultado;
	}

	@Override
	public List<Libro> findSome(String text, String param) throws DataAccessException {
		StringBuffer sb = new StringBuffer();
		if(param.equals("genero")) {
			sb.append("select * from public.libro WHERE genero = :texto");
			Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
			query.setParameter("texto", text);
			List<Libro> resulset= query.getResultList();
			return resulset;
		}else if(param.equals("autor")) {
			sb.append("select * from public.libro WHERE autor = :texto");
			Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
			query.setParameter("texto", text);
			List<Libro> resulset= query.getResultList();
			return resulset;
		}else if(param.equals("isbn")) {
			sb.append("select * from public.libro WHERE isbn = :texto");
			Query query = entityManager.createNativeQuery(sb.toString(),Libro.class);
			query.setParameter("texto", text);
			List<Libro> resulset= query.getResultList();
			return resulset;
		}
		return null;
	}

	
}
