/**
 **************************************************************************************
 *** CommentDAO.java                                                                ***
 *** Generator: net.anotheria.asg.generator.model.db.PersistenceServiceDAOGenerator ***
 *** generated by AnoSiteGenerator (ASG), Version: 1.3.3                            ***
 *** Copyright (C) 2005 - 2010 Anotheria.net, www.anotheria.net                     ***
 *** All Rights Reserved.                                                           ***
 **************************************************************************************
 *** Don't edit this code, if you aren't sure                                       ***
 *** that you do exactly know what you are doing!                                   ***
 *** It's better to invest time in the generator, as into the generated code.       ***
 **************************************************************************************
 */

package org.anotheria.moskitodemo.sqltrace.persistence;

import net.anotheria.db.config.JDBCConfig;
import net.anotheria.db.config.JDBCConfigFactory;
import net.anotheria.db.dao.DAO;
import net.anotheria.db.dao.DAOException;
import net.anotheria.db.dao.DAOSQLException;
import net.anotheria.db.dao.RowMapper;
import net.anotheria.util.slicer.Segment;
import org.anotheria.moskitodemo.sqltrace.persistence.data.Comment;
import org.anotheria.moskitodemo.sqltrace.persistence.data.CommentVO;
import org.apache.log4j.Logger;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

public class CommentDAO implements DAO{

	private static Logger log = Logger.getLogger(CommentDAO.class);
	public static final String TABNAME = "comment";

	public static final String ATT_NAME_ID = "id";
	public static final String ATT_NAME_FIRSTNAME 	 = "firstname";
	public static final String ATT_NAME_LASTNAME 	 = "lastname";
	public static final String ATT_NAME_EMAIL 	 = "email";
	public static final String ATT_NAME_TEXT 	 = "text";
	public static final String ATT_NAME_TIMESTAMP 	 = "timestamp";
	public static final String ATT_NAME_WISHESUPDATES 	 = "wishesupdates";

	public static final String  SQL_CREATE_1 	= "INSERT INTO ";
	public static final String  SQL_CREATE_2 	= " ("+ATT_NAME_ID+", "+ATT_NAME_FIRSTNAME+", "+ATT_NAME_LASTNAME+", "+ATT_NAME_EMAIL+", "+ATT_NAME_TEXT+", "+ATT_NAME_TIMESTAMP+", "+ATT_NAME_WISHESUPDATES+", "+ATT_NAME_DAO_CREATED+") VALUES (?,?,?,?,?,?,?,?)";
	public static final String  SQL_UPDATE_1 	= "UPDATE ";
	public static final String  SQL_UPDATE_2 	= " SET " + ATT_NAME_FIRSTNAME + " = ?, " + ATT_NAME_LASTNAME + " = ?, " + ATT_NAME_EMAIL + " = ?, " + ATT_NAME_TEXT + " = ?, " + ATT_NAME_TIMESTAMP + " = ?, " + ATT_NAME_WISHESUPDATES + " = ?, " + ATT_NAME_DAO_UPDATED + " = ?" + " WHERE " + ATT_NAME_ID + " = ?";
	public static final String  SQL_DELETE_1 	= "DELETE FROM ";
	public static final String  SQL_DELETE_2 	= " WHERE " + TABNAME +"." + ATT_NAME_ID + " = ?";
	public static final String  SQL_READ_ONE_1 	= "SELECT "+ATT_NAME_ID+", "+ATT_NAME_FIRSTNAME+", "+ATT_NAME_LASTNAME+", "+ATT_NAME_EMAIL+", "+ATT_NAME_TEXT+", "+ATT_NAME_TIMESTAMP+", "+ATT_NAME_WISHESUPDATES+", "+ATT_NAME_DAO_CREATED+", "+ATT_NAME_DAO_UPDATED+" FROM ";
	public static final String  SQL_READ_ONE_2 	= " WHERE " + TABNAME +"." + ATT_NAME_ID + " = ?";
	public static final String  SQL_READ_ALL_1 	= "SELECT "+ATT_NAME_ID+", "+ATT_NAME_FIRSTNAME+", "+ATT_NAME_LASTNAME+", "+ATT_NAME_EMAIL+", "+ATT_NAME_TEXT+", "+ATT_NAME_TIMESTAMP+", "+ATT_NAME_WISHESUPDATES+", "+ATT_NAME_DAO_CREATED+", "+ATT_NAME_DAO_UPDATED+" FROM ";
	public static final String  SQL_READ_ALL_2 	= " ORDER BY id";
	public static final String  SQL_READ_ALL_BY_PROPERTY_1 	= "SELECT "+ATT_NAME_ID+", "+ATT_NAME_FIRSTNAME+", "+ATT_NAME_LASTNAME+", "+ATT_NAME_EMAIL+", "+ATT_NAME_TEXT+", "+ATT_NAME_TIMESTAMP+", "+ATT_NAME_WISHESUPDATES+", "+ATT_NAME_DAO_CREATED+", "+ATT_NAME_DAO_UPDATED+" FROM ";
	public static final String  SQL_READ_ALL_BY_PROPERTY_2 	= " WHERE ";
	public static final String  SQL_COUNT_1 	= "SELECT COUNT(id) FROM ";
	public static final String  SQL_LIMIT_1 	= " LIMIT ?";
	public static final String  SQL_OFFSET_1 	= " OFFSET ?";

	private RowMapper<Comment> rowMapper = new CommentRowMapper();

	private AtomicLong lastId = new AtomicLong();
	private JDBCConfig dbConfig = JDBCConfigFactory.getJDBCConfig();

	private AtomicLong getLastId(Connection con) throws DAOException {
		return lastId;
	}

	private void adjustLastId(Connection con, long lastIdValue) throws DAOException {
		if (lastId.get()<lastIdValue)
			lastId.set(lastIdValue);
	}

	private String createSQL(String sql1, String sql2){
		StringBuilder sql = new StringBuilder();
		sql.append(sql1).append(TABNAME).append(sql2);
		return sql.toString();
	}

	/**
	 * Returns all Comments objects stored.
	 */
	public List<Comment> getComments(Connection con) throws DAOException {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			con.setAutoCommit(true);
			ps = con.prepareStatement(createSQL(SQL_READ_ALL_1, SQL_READ_ALL_2));
			result = ps.executeQuery();
			ArrayList<Comment> ret = new ArrayList<Comment>();
			while(result.next())
				ret.add(rowMapper.map(result));
			return  ret;
		} catch (SQLException e) {
			log.error("getComments("+con+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(result);
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Deletes a Comment object by id.
	 */
	public void deleteComment(Connection con, String id) throws DAOException {
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(true);
			ps = con.prepareStatement(createSQL(SQL_DELETE_1, SQL_DELETE_2));
			ps.setLong(1, Long.parseLong(id));
			int rows = ps.executeUpdate();
			if (rows!=1 && rows!=0){
				log.warn("Deleted more than one row of Comment: "+id);
			}
		} catch (SQLException e) {
			log.error("deleteComment("+con+", "+id+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Deletes multiple Comment objects.
	 */
	public void deleteComments(Connection con, List<Comment> list) throws DAOException {
		PreparedStatement ps = null;
		try{
			con.setAutoCommit(false);
			ps = con.prepareStatement(createSQL(SQL_DELETE_1, SQL_DELETE_2));
			for (Comment comment : list){
				ps.setLong(1, Long.parseLong(comment.getId()));
				int rows = ps.executeUpdate();
				if (rows!=1 && rows!=0){
					log.warn("Deleted more than one row of Comment: "+comment.getId());
				}
			}
			con.commit();
		} catch (SQLException e) {
			log.error("deleteComments("+con+", "+list+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Returns the Comment object with the specified id.
	 */
	public Comment getComment(Connection con, String id) throws DAOException {
		if(con == null)
			throw new IllegalArgumentException("Null arg: con");
		if(id == null)
			throw new IllegalArgumentException("Null arg: id");
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			con.setAutoCommit(true);
			ps = con.prepareStatement(createSQL(SQL_READ_ONE_1, SQL_READ_ONE_2));
			ps.setLong(1, Long.parseLong(id));
			result = ps.executeQuery();
			if (!result.next())
				throw new CommentDAONoItemForIdFoundException(id);
			return rowMapper.map(result);
		} catch (SQLException e) {
			log.error("getComment("+con+", "+id+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(result);
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Imports a new Comment object.
	 * Returns the imported version.
	 */
	public Comment importComment(Connection con, Comment comment) throws DAOException {
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(true);
			ps = con.prepareStatement(createSQL(SQL_CREATE_1, SQL_CREATE_2));
			ps.setLong(1, Long.parseLong(comment.getId()));
			ps.setString(2, comment.getFirstName());
			ps.setString(3, comment.getLastName());
			ps.setString(4, comment.getEmail());
			ps.setString(5, comment.getText());
			ps.setLong(6, comment.getTimestamp());
			ps.setBoolean(7, comment.getWishesUpdates());
			// set create timestamp
			ps.setLong(8, System.currentTimeMillis());
			int rows = ps.executeUpdate();
			if (rows!=1)
				throw new DAOException("Create failed, updated rows: "+rows);
			CommentVO newComment = new CommentVO(comment.getId());
			newComment.copyAttributesFrom(comment);
			adjustLastId(con, Long.parseLong(comment.getId()));
			return newComment;
		} catch (SQLException e) {
			log.error("importComment("+con+", "+comment+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Imports multiple new Comment objects.
	 * Returns the imported versions.
	 */
	public List<Comment> importComments(Connection con,List<Comment> list) throws DAOException {
		PreparedStatement ps = null;
		try{
			con.setAutoCommit(false);
			ps = con.prepareStatement(createSQL(SQL_CREATE_1, SQL_CREATE_2));
			List<Comment> ret = new ArrayList<Comment>();
			for (Comment comment : list){
				ps.setLong(1, Long.parseLong(comment.getId()));
				ps.setString(2, comment.getFirstName());
				ps.setString(3, comment.getLastName());
				ps.setString(4, comment.getEmail());
				ps.setString(5, comment.getText());
				ps.setLong(6, comment.getTimestamp());
				ps.setBoolean(7, comment.getWishesUpdates());
				// set create timestamp
				ps.setLong(8, System.currentTimeMillis());
				int rows = ps.executeUpdate();
				if (rows!=1)
					throw new DAOException("Create failed, updated rows: "+rows);
				CommentVO newComment = new CommentVO(comment.getId());
				newComment.copyAttributesFrom(comment);
				adjustLastId(con, Long.parseLong(comment.getId()));
				ret.add(newComment);
			}
			con.commit();
			return ret;
		} catch (SQLException e) {
			log.error("import Comments("+con+", "+list+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Creates a new Comment object.
	 * Returns the created version.
	 */
	public Comment createComment(Connection con, Comment comment) throws DAOException {
		java.sql.SQLException throwable = null;
		for (int recoveryAttempt = 1; recoveryAttempt <= dbConfig.getIdRecoveryAttempts(); recoveryAttempt++) {
			PreparedStatement ps = null;
			try {
				con.setAutoCommit(false);
				ps = con.prepareStatement(createSQL(SQL_CREATE_1, SQL_CREATE_2));
				long nextId = getLastId(con).incrementAndGet();
				ps.setLong(1, nextId);
				ps.setString(2, comment.getFirstName());
				ps.setString(3, comment.getLastName());
				ps.setString(4, comment.getEmail());
				ps.setString(5, comment.getText());
				ps.setLong(6, comment.getTimestamp());
				ps.setBoolean(7, comment.getWishesUpdates());
				// set create timestamp
				ps.setLong(8, System.currentTimeMillis());
				int rows = ps.executeUpdate();
				if (rows!=1)
					throw new DAOException("Create failed, updated rows: "+rows);
				CommentVO newComment = new CommentVO(""+nextId);
				newComment.copyAttributesFrom(comment);
				con.commit();
				return newComment;
			} catch (SQLException e) {
				getLastId(con).set(getMaxId(con,TABNAME));
				log.warn("Failed attempt" +recoveryAttempt+ " from " +dbConfig.getIdRecoveryAttempts()+ " to create new entry in "+TABNAME+" table", e);
				throwable = e;
				continue;
			} finally {
				net.anotheria.db.util.JDBCUtil.release(ps);
			}
		}
		log.error("All "+ dbConfig.getIdRecoveryAttempts()+" attempt of id rereading - Failed. "+"createComment("+con+", "+comment+")", throwable);
		throw new DAOSQLException(throwable);
	}

	/**
	 * Creates multiple new Comment objects.
	 * Returns the created versions.
	 */
	public List<Comment> createComments(Connection con, List<Comment> list) throws DAOException {
		java.sql.SQLException throwable = null;
		for (int recoveryAttempt = 1; recoveryAttempt <= dbConfig.getIdRecoveryAttempts(); recoveryAttempt++) {
			PreparedStatement ps = null;
			try{
				con.setAutoCommit(false);
				ps = con.prepareStatement(createSQL(SQL_CREATE_1, SQL_CREATE_2));
				List<Comment> ret = new ArrayList<Comment>();
				for (Comment comment : list){
					long nextId = getLastId(con).incrementAndGet();
					ps.setLong(1, nextId);
					ps.setString(2, comment.getFirstName());
					ps.setString(3, comment.getLastName());
					ps.setString(4, comment.getEmail());
					ps.setString(5, comment.getText());
					ps.setLong(6, comment.getTimestamp());
					ps.setBoolean(7, comment.getWishesUpdates());
					// set create timestamp
					ps.setLong(8, System.currentTimeMillis());
					int rows = ps.executeUpdate();
					if (rows!=1)
						throw new DAOException("Create failed, updated rows: "+rows);
					CommentVO newComment = new CommentVO(""+nextId);
					newComment.copyAttributesFrom(comment);
					ret.add(newComment);
				}
				con.commit();
				return ret;
			} catch (SQLException e) {
				getLastId(con).set(getMaxId(con,TABNAME));
				log.warn("Failed attempt" +recoveryAttempt+ " from " +dbConfig.getIdRecoveryAttempts()+ " to create new entries (list) in "+TABNAME+" table", e);
				throwable = e;
				continue;
			} finally {
				net.anotheria.db.util.JDBCUtil.release(ps);
			}
		}
		log.error("All "+ dbConfig.getIdRecoveryAttempts()+" attempt of id rereading - Failed. "+"createComments("+con+", "+list+")", throwable);
		throw new DAOSQLException(throwable);
	}

	/**
	 * Updates a Comment object.
	 * Returns the updated version.
	 */
	public Comment updateComment(Connection con, Comment comment) throws DAOException {
		PreparedStatement ps = null;
		try {
			con.setAutoCommit(true);
			ps = con.prepareStatement(createSQL(SQL_UPDATE_1, SQL_UPDATE_2));
			ps.setString(1, comment.getFirstName());
			ps.setString(2, comment.getLastName());
			ps.setString(3, comment.getEmail());
			ps.setString(4, comment.getText());
			ps.setLong(5, comment.getTimestamp());
			ps.setBoolean(6, comment.getWishesUpdates());
			// set update timestamp
			ps.setLong(7, System.currentTimeMillis());
			// set id for the where clause
			ps.setLong(8, Long.parseLong(comment.getId()));
			int rows = ps.executeUpdate();
			if (rows!=1)
				throw new DAOException("Update failed, updated rows: "+rows);
			return comment;
		} catch (SQLException e) {
			log.error("updateComment("+con+", "+comment+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Updates multiple new Comment objects.
	 * Returns the updated versions.
	 */
	public List<Comment> updateComments(Connection con, List<Comment> list) throws DAOException {
		PreparedStatement ps = null;
		try{
			con.setAutoCommit(false);
			ps = con.prepareStatement(createSQL(SQL_UPDATE_1, SQL_UPDATE_2));
			List<Comment> ret = new ArrayList<Comment>();
			for (Comment comment : list){
				ps.setString(1, comment.getFirstName());
				ps.setString(2, comment.getLastName());
				ps.setString(3, comment.getEmail());
				ps.setString(4, comment.getText());
				ps.setLong(5, comment.getTimestamp());
				ps.setBoolean(6, comment.getWishesUpdates());
				// set update timestamp
				ps.setLong(7, System.currentTimeMillis());
				// set id for the where clause
				ps.setLong(8, Long.parseLong(comment.getId()));
				int rows = ps.executeUpdate();
				if (rows!=1)
					throw new DAOException("Update failed, updated rows: "+rows);
			}
			con.commit();
			return list;
		} catch (SQLException e) {
			log.error("updateComments("+con+", "+list+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Returns all Comments objects stored which matches given properties.
	 */
	public List<Comment> getCommentsByProperty(Connection con, List<QueryProperty> properties) throws DAOException {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			// //enable caching of statements one day
			String SQL = createSQL(SQL_READ_ALL_BY_PROPERTY_1, SQL_READ_ALL_BY_PROPERTY_2);
			String whereClause = "";
			for (QueryProperty p : properties){
				if (whereClause.length()>0)
					whereClause += " AND ";
				String statement = p.unprepaireable()? (String) p.getValue(): "?";
				whereClause += p.getName().toLowerCase()+p.getComparator()+statement;
			}
			SQL += whereClause;
			ps = con.prepareStatement(SQL);
			int propertyPosition = 0;
			for (QueryProperty property: properties){
				if(property.unprepaireable())
					continue;
				setProperty(++propertyPosition, ps, property);
			}
			result = ps.executeQuery();
			ArrayList<Comment> ret = new ArrayList<Comment>();
			while(result.next())
				ret.add(rowMapper.map(result));
			return  ret;
		} catch (SQLException e) {
			log.error("getCommentsByProperty("+con+","+ properties+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(result);
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Returns Comments objects count.
	 */
	public int getCommentsCount(Connection con) throws DAOException {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			ps = con.prepareStatement(SQL_COUNT_1 + TABNAME);
			result = ps.executeQuery();
			int pCount = 0;
			if (result.next())
				pCount = result.getInt(1);
			return pCount;
		} catch (SQLException e) {
			log.error("getCommentsCount(" + con + ")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(result);
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Returns Comments objects segment.
	 */
	public List<Comment> getComments(Connection con, Segment aSegment) throws DAOException {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			con.setAutoCommit(true);
			ps = con.prepareStatement(createSQL(SQL_READ_ALL_1, SQL_READ_ALL_2) + SQL_LIMIT_1 + SQL_OFFSET_1);
			int pLimit = aSegment.getElementsPerSlice();
			int pOffset = aSegment.getSliceNumber() * aSegment.getElementsPerSlice() - aSegment.getElementsPerSlice();
			ps.setInt(1, pLimit);
			ps.setInt(2, pOffset);
			result = ps.executeQuery();
			ArrayList<Comment> ret = new ArrayList<Comment>();
			while(result.next())
				ret.add(rowMapper.map(result));
			return  ret;
		} catch (SQLException e) {
			log.error("getComments(" + con + ","+ aSegment +")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(result);
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	/**
	 * Returns Comments objects segment which matches given properties.
	 */
	public List<Comment> getCommentsByProperty(Connection con, Segment aSegment, List<QueryProperty> properties) throws DAOException {
		PreparedStatement ps = null;
		ResultSet result = null;
		try {
			// //enable caching of statements one day
			String SQL = createSQL(SQL_READ_ALL_BY_PROPERTY_1, SQL_READ_ALL_BY_PROPERTY_2);
			String whereClause = "";
			for (QueryProperty p : properties){
				if (whereClause.length()>0)
					whereClause += " AND ";
				String statement = p.unprepaireable()? (String) p.getValue(): "?";
				whereClause += p.getName()+p.getComparator()+statement;
			}
			SQL += whereClause;
			SQL += SQL_READ_ALL_2 + SQL_LIMIT_1 + SQL_OFFSET_1;
			ps = con.prepareStatement(SQL);
			int propertyPosition = 0;
			for (QueryProperty property: properties){
				if(property.unprepaireable())
					continue;
				setProperty(++propertyPosition, ps, property);
			}
			int pLimit = aSegment.getElementsPerSlice();
			int pOffset = aSegment.getSliceNumber() * aSegment.getElementsPerSlice() - aSegment.getElementsPerSlice();
			ps.setInt(++propertyPosition, pLimit);
			ps.setInt(++propertyPosition, pOffset);
			result = ps.executeQuery();
			ArrayList<Comment> ret = new ArrayList<Comment>();
			while(result.next())
				ret.add(rowMapper.map(result));
			return  ret;
		} catch (SQLException e) {
			log.error("getCommentsByProperty(" + con + "," + aSegment + "," + properties + ")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(result);
			net.anotheria.db.util.JDBCUtil.release(ps);
		}
	}

	private void setProperty(int position, PreparedStatement ps, QueryProperty property) throws SQLException {
		if(property.unprepaireable()){
			return;
		}
		if (ATT_NAME_FIRSTNAME.equals(property.getName().toLowerCase())){
			ps.setString(position, (String)property.getValue());
			return;
		}
		if (ATT_NAME_LASTNAME.equals(property.getName().toLowerCase())){
			ps.setString(position, (String)property.getValue());
			return;
		}
		if (ATT_NAME_EMAIL.equals(property.getName().toLowerCase())){
			ps.setString(position, (String)property.getValue());
			return;
		}
		if (ATT_NAME_TEXT.equals(property.getName().toLowerCase())){
			ps.setString(position, (String)property.getValue());
			return;
		}
		if (ATT_NAME_TIMESTAMP.equals(property.getName().toLowerCase())){
			ps.setLong(position, (Long)property.getValue());
			return;
		}
		if (ATT_NAME_WISHESUPDATES.equals(property.getName().toLowerCase())){
			ps.setBoolean(position, (Boolean)property.getValue());
			return;
		}
		if (ATT_NAME_ID.equals(property.getName())){
			ps.setLong(position, (Long)property.getValue());
			return;
		}
		if ("dao_created".equals(property.getName())){
			ps.setLong(position, (Long)property.getValue());
			return;
		}
		if ("dao_updated".equals(property.getName())){
			ps.setLong(position, (Long)property.getValue());
			return;
		}
	}
	/* ---------- SQL --------- 
	CREATE TABLE comment(
	id int8 PRIMARY KEY,
	firstname varchar,
	lastname varchar,
	email varchar,
	text varchar,
	timestamp int8,
	wishesupdates boolean,
	dao_created int8,
	dao_updated int8
	)
	   ---------- SQL --------- */
	public void createStructure(Connection connection)  throws DAOException {
		// not implemented
	}

	/* ---------- SQL --------- 
	DROP TABLE comment
	   ---------- SQL --------- */
	public void deleteStructure(Connection connection)  throws DAOException {
		// not implemented
	}

	private long getMaxId(Connection con, String tableName)  throws DAOException {
		Statement st = null;
		ResultSet result = null;
		try {
			con.setAutoCommit(true);
			st = con.createStatement();
			st.execute("SELECT MAX("+ATT_NAME_ID+") FROM "+tableName);
			result = st.getResultSet();
			long maxId = 0;
			if (result.next())
				maxId = result.getLong(1);
			log.info("maxId in table "+tableName+" is "+maxId);
			return maxId;
		} catch (SQLException e) {
			log.error("getMaxId("+con+", "+tableName+")", e);
			throw new DAOSQLException(e);
		} finally {
			net.anotheria.db.util.JDBCUtil.release(result);
			net.anotheria.db.util.JDBCUtil.release(st);
		}
	}

	public void init(Connection con)  throws DAOException {
		log.debug("Called: init("+con+")");
		long maxId = getMaxId(con, TABNAME);
		maxId = maxId >= dbConfig.getStartId() ? maxId : dbConfig.getStartId();
		lastId = new AtomicLong(maxId);
	}
}
