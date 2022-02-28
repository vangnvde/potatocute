/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import context.DBContext;
import entity.Comment;
import entity.Director;
import entity.Distributor;
import entity.Film;
import entity.FilmType;
import entity.Review;
import entity.Trailer;
import entity.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Vang Nguyen
 */
public class DAO {

    public List<Film> getAllFilm() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "select * from Film";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                listF.add(new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));

            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listF;
    }

    public String getTypeByFilm(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select TypeName from Film a, TypeFilm b where a.idType = b.idType and idFilm = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getString("typeName");
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public String getDirectorByFilm(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select nameDirector from Film a, Director b where a.idDirector = b.idDirector and idFilm = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public String getDistributorByFilm(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select nameDistributor from Film a, Distributor b where a.idDistributor = b.idDistributor and idFilm = ? ";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {

                return rs.getString(1);
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public Film getFilmInfo(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "select * from Film where idFilm = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public User getUserInfo(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from [User] where idUser = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new User(
                        id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getBoolean(5),
                        rs.getBoolean(6)
                );

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public boolean updateLikeReviewFilm(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        List<Film> listF = new ArrayList<>();
        String sql = "update Film set likeReview = likeReview+1 where idFilm = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            ps.close();
        }
        return false;
    }

    public boolean updateUnlikeReviewFilm(String id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        List<Film> listF = new ArrayList<>();
        String sql = "update Film set unlikeReview = unlikeReview + 1 where idFilm = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(id));

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            ps.close();
        }
        return false;
    }

    public User checkLogin(String user, String pass) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        String sql = "select * from [User] where username =? and [password] =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, user);
            ps.setString(2, pass);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new User(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4), rs.getBoolean(5), rs.getBoolean(6));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            ps.close();
        }
        return null;
    }

    public List<Comment> getListCommentFilm(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comment> listC = new ArrayList<>();
        String sql = "SELECT fullComment, nameFilm, fullName,username, poster, Comment.idFilm FROM Comment INNER JOIN Film ON Comment.idFilm = Film.idFilm INNER JOIN [User] ON Comment.idUser = [User].idUser WHERE Comment.idFilm = ? ORDER BY idComment DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            while (rs.next()) {
                int idF = rs.getInt(6);
                listC.add(new Comment(
                        rs.getString(1),
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        id));

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listC;
    }

    public List<Comment> getNewComment() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Comment> listC = new ArrayList<>();
        String sql = "SELECT fullComment, nameFilm, fullName,username, poster, Film.idFilm FROM Comment INNER JOIN Film ON Comment.idFilm = Film.idFilm INNER JOIN [User] ON Comment.idUser = [User].idUser ORDER BY idComment DESC";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(6);
                String comment = rs.getString(1);
                if (comment.length() > 125) {
                    comment = comment.substring(0, 125) + "...";
                } else {
                    comment = comment + "...";
                }
                listC.add(new Comment(
                        comment,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        id));
                System.out.println(comment + "" + rs.getString(2) + "" + rs.getString(3) + "" + rs.getString(4) + "");
            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listC;
    }

    public List<Film> getTopViewFilm() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "SELECT TOP (5) * FROM Film ORDER BY likeReview+unlikeReview DESC;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                listF.add(new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));

            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listF;
    }

    public List<Film> getTopRatingFilm() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "SELECT TOP (5) * FROM Film ORDER BY totalReview DESC;";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                listF.add(new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));

            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listF;
    }

// My New Code
    public List<Film> getSearchFilm(String searchQuery) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "select * from Film WHERE nameFilm LIKE ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, '%' + searchQuery + '%');
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                listF.add(new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));

            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listF;
    }

    public List<FilmType> getAllFilmType() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<FilmType> listFilmType = new ArrayList<>();

        String sql = "select * from TypeFilm";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listFilmType.add(
                        new FilmType(
                                rs.getInt("idType"),
                                rs.getString("TypeName")
                        )
                );
            }
            return listFilmType;
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Distributor> getAllDistributor() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Distributor> listDistributor = new ArrayList<>();

        String sql = "select * from Distributor";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listDistributor.add(
                        new Distributor(
                                rs.getInt("idDistributor"),
                                rs.getString("nameDistributor")
                        )
                );
            }
            return listDistributor;
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public List<Director> getAllDirector() {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Director> listDirector = new ArrayList<>();

        String sql = "select * from Director";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listDirector.add(
                        new Director(
                                rs.getInt("idDirector"),
                                rs.getString("nameDirector")
                        )
                );
            }
            return listDirector;
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                rs.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return null;
    }

    public void deleteCommentInFilm(String filmID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM Comment WHERE idFilm=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, filmID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void deleteCommentByUser(String userID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM [Comment] WHERE idUser=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public void deleteFilmByID(String filmID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM Film WHERE idFilm=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, filmID);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public boolean deleteUserByID(String userID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM [User] WHERE idUser=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean deleteReviewByUserID(String userID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM [Review] WHERE idUser=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean deleteReviewByFilmID(String filmID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM [Review] WHERE idFilm=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, filmID);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public void addFilm(String nameFilm, String descriptionFilm, String poster, String time, String year, String idType, String idDistributor, String idDirector) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO Film (nameFilm,descriptionFilm,poster,time,year,idType,idDistributor,idDirector,likeReview,unlikeReview,totalReview)"
                + " VALUES(?,?,?,?,?,?,?,?,0,0,0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameFilm);
            ps.setString(2, descriptionFilm);
            ps.setString(3, poster);
            ps.setString(4, time);
            ps.setString(5, year);
            ps.setString(6, idType);
            ps.setString(7, idDistributor);
            ps.setString(8, idDirector);
            ps.executeUpdate();
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    public boolean addFilmType(String typeName) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO TypeFilm (typeName)"
                + " VALUES(?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, typeName);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean addDirector(String nameDirector) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO Director (nameDirector)"
                + " VALUES(?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameDirector);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean addDistributor(String nameDistributor) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO Distributor (nameDistributor)"
                + " VALUES(?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameDistributor);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean updateFilm(int idFilm, String nameFilm, String descriptionFilm, String poster, String time, String year, String idType, String idDistributor, String idDirector) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE Film SET nameFilm=?,descriptionFilm=?,poster=?,time=?,year=?,idType=?,idDistributor=?,idDirector=?"
                + " WHERE idFilm=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameFilm);
            ps.setString(2, descriptionFilm);
            ps.setString(3, poster);
            ps.setString(4, time);
            ps.setString(5, year);
            ps.setString(6, idType);
            ps.setString(7, idDistributor);
            ps.setString(8, idDirector);
            ps.setInt(9, idFilm);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("LOIIIIIIIIIIIIIIIIIIII: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean updateUserByAdmin(int id, String username, String fullname, int isExpert, int isAdmin) {
        Connection conn = null;
        PreparedStatement ps = null;

        boolean expert = (isExpert == 1) ? true : false;
        boolean admin = (isAdmin == 1) ? true : false;

        String sql = "UPDATE [User] SET username=?,fullName=?, isExpert=?,isAdmin=?"
                + " WHERE idUser=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, fullname);
            ps.setBoolean(3, expert);
            ps.setBoolean(4, admin);
            ps.setInt(5, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("LOIIIIIIIIIIIIIIIIIIII: " + ex.getMessage());
            }
        }
        return false;
    }

    public List<User> getAllUser() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<User> listUser = new ArrayList<>();
        String sql = "select * from [User]";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            while (rs.next()) {
                listUser.add(
                        new User(
                                rs.getInt("idUser"),
                                rs.getString("username"),
                                rs.getString("password"),
                                rs.getString("fullName"),
                                rs.getBoolean("isExpert"),
                                rs.getBoolean("isAdmin")
                        )
                );
            }
            return listUser;
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public Director getDirectorInfo(int idDirector) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from Director where idDirector = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idDirector);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Director(
                        idDirector,
                        rs.getString("nameDirector")
                );

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public FilmType getFilmTypeInfo(int idFilmType) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from TypeFilm where idType = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idFilmType);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new FilmType(
                        idFilmType,
                        rs.getString("typeName")
                );

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public Distributor getDistributorInfo(int idDistributor) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "select * from Distributor where idDistributor = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idDistributor);
            rs = ps.executeQuery();

            if (rs.next()) {
                return new Distributor(
                        idDistributor,
                        rs.getString("nameDistributor")
                );

            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public boolean updateDirector(int idDirector, String nameDirector) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE Director SET nameDirector=?"
                + " WHERE idDirector=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameDirector);
            ps.setInt(2, idDirector);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("LOIIIIIIIIIIIIIIIIIIII: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean updateFilmType(int idFilmType, String nameFilmType) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE TypeFilm SET TypeName=?"
                + " WHERE idType=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameFilmType);
            ps.setInt(2, idFilmType);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("LOIIIIIIIIIIIIIIIIIIII: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean updateDistributor(int idDistributor, String nameDistributor) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE Distributor SET nameDistributor=?"
                + " WHERE idDistributor=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, nameDistributor);
            ps.setInt(2, idDistributor);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("LOIIIIIIIIIIIIIIIIIIII: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean isUsernameExist(String username) {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        String sql = "SELECT idUser FROM [User]"
                + " WHERE username=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            rs = ps.executeQuery();

            if (rs.next()) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("LOIIIIIIIIIIIIIIIIIIII: " + ex.getMessage());
            }
        }
        return false;
    }

    public List<Film> getFilmByType(String idType) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "select * from Film where idType =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idType));
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                listF.add(new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));

            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listF;
    }

    public List<Film> getFilmByDirector(String idDirector) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "select * from Film where idDirector =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idDirector));
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                listF.add(new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));

            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listF;
    }

    public List<Film> getFilmByDistributor(String idDistributor) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "select * from Film where idDistributor =?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idDistributor));
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                listF.add(new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));

            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listF;
    }

    public boolean insertComment(String idF, String idUser, String fullComment) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        List<Film> listF = new ArrayList<>();
        String sql = "insert Comment (idFilm,idUser,fullComment) values (?,?,?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idF));
            ps.setInt(2, Integer.parseInt(idUser));
            ps.setString(3, fullComment);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            ps.close();
        }
        return false;
    }

    public boolean updateUserReview(String idFilm, String idUser, String review) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO Review VALUES (?, ?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idFilm));
            ps.setInt(2, Integer.parseInt(idUser));
            ps.setString(3, review);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            ps.close();
        }
        return false;
    }

    public Review getListReview(int idF, int idU) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Review> listR = new ArrayList<>();
        String sql = "select isLike from Review where idFilm=? and idUser=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, idF);
            ps.setInt(2, idU);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Review(idF, idU, rs.getInt("isLike"));
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }

    public boolean deleteReview(String idF, String idU, String isLike) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "DELETE FROM Review WHERE idFilm=? AND idUser=? AND isLike=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, idF);
            ps.setString(2, idU);
            ps.setString(3, isLike);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }

    public boolean updateRemoveReviewFilm(String idF, String isLike) {
        Connection conn = null;
        PreparedStatement ps = null;

        List<Film> listF = new ArrayList<>();
        String field = (isLike.equals("1")) ? "likeReview" : "unlikeReview";
        String sql = "update Film set " + field + " = " + field + "-1 where idFilm = ?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idF));

            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                Logger.getLogger(DAO.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return false;
    }

    public int getNumberOfFilm() throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "select count(idFilm)[Count] from Film";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();

            if (rs.next()) {
                return rs.getInt("Count");
            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return 0;
    }

    public List<Film> getAllFilmPagination(int indexBegin, int filmPerPage) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Film> listF = new ArrayList<>();
        String sql = "select * from Film ORDER BY idFilm DESC OFFSET ? ROWS FETCH FIRST ? ROWS ONLY";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, (indexBegin - 1) * filmPerPage);
            ps.setInt(2, filmPerPage);
            rs = ps.executeQuery();

            while (rs.next()) {
                int id = rs.getInt(1);
                listF.add(new Film(id,
                        rs.getString(2),
                        rs.getString(3),
                        rs.getString(4),
                        rs.getString(5),
                        rs.getInt(6),
                        getTypeByFilm(id),
                        getDirectorByFilm(id),
                        getDistributorByFilm(id),
                        rs.getInt(10),
                        rs.getInt(11),
                        rs.getInt(12)));

            }

        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return listF;
    }

    public boolean insertUser(String fullname, String username, String password) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "insert [User] (username,[password],fullName,isExpert,isAdmin) values (?,?,?,0,0)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, username);
            ps.setString(2, password);
            ps.setString(3, fullname);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            ps.close();
        }
        return false;
    }

    public boolean isLoggedIn(HttpSession session) {
        User user = (User) session.getAttribute("User");
        if (user == null) {
            return false;
        }
        return true;
    }

    public void checkAccountUser(HttpSession session, HttpServletResponse response) {
        User user = (User) session.getAttribute("User");
        try {
            if (user == null) {
                response.sendRedirect("LoadLoginPage");
            }
        } catch (Exception ex) {

        }
    }

    public void checkAccountAdmin(HttpSession session, HttpServletResponse response) {
        User user = (User) session.getAttribute("User");
        try {
            checkAccountUser(session, response);

            if (user != null && !user.isIsAdmin()) {
                response.sendRedirect("home");
            }
        } catch (Exception ex) {

        }
    }

    public boolean updateFullnameByUser(int id, String fullname) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE [User] SET fullName=?"
                + " WHERE idUser=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, fullname);
            ps.setInt(2, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("LOIIIIIIIIIIIIIIIIIIII: " + ex.getMessage());
            }
        }
        return false;
    }

    public boolean updatePasswordByUser(int id, String password) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "UPDATE [User] SET password=?"
                + " WHERE idUser=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, password);
            ps.setInt(2, id);

            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println("LOIIIIIIIIIIIIIIIIIIII: " + ex.getMessage());
            }
        }
        return false;
    }
    
    public Trailer getTrailer(int id) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;
        List<Review> listR = new ArrayList<>();
        String sql = "select * from Trailer where idFilm=?";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, id);
            rs = ps.executeQuery();
            if (rs.next()) {
                return new Trailer(rs.getInt(1), rs.getString(2));
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            conn.close();
            rs.close();
            ps.close();
        }
        return null;
    }
    
    public boolean deleteTrailerByID(String userID) {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "delete from Trailer where idFilm=?";
        try {   
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setString(1, userID);
            if (ps.executeUpdate() > 0) {
                return true;
            }
        } catch (Exception e) {
            System.out.println("!!!!!!!!!" + e.getMessage());
        } finally {
            try {
                conn.close();
                ps.close();
            } catch (SQLException ex) {
                System.out.println(ex.getMessage());
            }
        }
        return false;
    }
    
    public boolean addTrailer(String idFilm, String linkTrailer) throws SQLException {
        Connection conn = null;
        PreparedStatement ps = null;

        String sql = "INSERT INTO Trailer VALUES (?, ?)";
        try {
            conn = new DBContext().getConnection();
            ps = conn.prepareStatement(sql);
            ps.setInt(1, Integer.parseInt(idFilm));
            ps.setString(2, linkTrailer);
            if (ps.executeUpdate() > 0) {
                return true;
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        } finally {
            conn.close();
            ps.close();
        }
        return false;
    }

    public static void main(String[] args) throws SQLException {
        DAO dao = new DAO();
//        System.out.println( dao.getAllDistributor());
//        System.out.println( dao.getAllDirector());
        try {
//            System.out.println( dao.getAllFilmPagination());
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

}
