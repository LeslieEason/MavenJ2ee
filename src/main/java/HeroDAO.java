import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class HeroDAO
{
    private String Sqlusername="root";
    private String Sqluserpassword="admin";
    private PreparedStatement pstmt;
    private Connection con = null;
    String drivername = "com.mysql.jdbc.Driver";
    String url = "jdbc:mysql://127.0.0.1:3306/test?useSLL=false/useUnicode=true&characterEncoding=utf8";
    public HeroDAO() throws ClassNotFoundException, SQLException
    {
        Class.forName(drivername);
        con= DriverManager.getConnection(url,Sqlusername,Sqluserpassword);
    }

    public Hero get(int id) throws SQLException
    {
        Hero hero=null;
        String sql="select * from hero where id =?";
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.executeQuery();
        ResultSet rs=pstmt.getResultSet();
        if(rs.next())
        {
            hero=new Hero(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
        }
        pstmt.close();
        con.close();
        return hero;
    }

    public void add(Hero hero) throws SQLException
    {
        String sql="insert into hero values(?,?,?,?)";
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,hero.id);
        pstmt.setString(2,hero.name);
        pstmt.setFloat(3,hero.hp);
        pstmt.setInt(4,hero.damage);
        pstmt.execute();
        pstmt.close();
        con.close();
    }

    public void delete(int id) throws SQLException
    {
        String sql="delete from hero where id=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,id);
        pstmt.execute();
        pstmt.close();
        con.close();
    }

    public void update(Hero hero) throws SQLException
    {
        String sql="update hero set name=?,hp=?,damage=? where id=?";
        pstmt=con.prepareStatement(sql);
        pstmt.setString(1,hero.name);
        pstmt.setFloat(2, hero.hp);
        pstmt.setInt(3,hero.damage);
        pstmt.setInt(4, hero.id);
        pstmt.execute();
        pstmt.close();
        con.close();
    }

//    查询所有的内容
//    public List<Hero> list() throws SQLException
//    {
//        List<Hero> heroList=new ArrayList<>();
//        String sql="select * from hero";
//        pstmt=con.prepareStatement(sql);
//        pstmt.executeQuery();
//        ResultSet rs=pstmt.getResultSet();
//        while(rs.next())
//        {
//            Hero hero=new Hero(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
//            heroList.add(hero);
//        }
//        return heroList;
//    }

    public int getTotal() throws SQLException
    {
        int total=0;
        String sql = "select count(*) from hero";
        pstmt=con.prepareStatement(sql);
        ResultSet rs = pstmt.executeQuery();
        while (rs.next())
        {
            total = rs.getInt(1);
        }
        System.out.println("total:" + total);
        pstmt.close();
        con.close();
        return total;
    }

    //查询所有内容
    public List<Hero> list() throws SQLException
    {
        return list(0, Short.MAX_VALUE);
    }

    //限定每页条数的查询
    public List<Hero> list(int start,int count) throws SQLException
    {
        List <Hero> heroList=new ArrayList<>();
        String sql="select * from hero order by id desc limit ?,? ";
        pstmt=con.prepareStatement(sql);
        pstmt.setInt(1,start);
        pstmt.setInt(2,count);
        ResultSet rs=pstmt.executeQuery();
        while(rs.next())
        {
            Hero hero=new Hero(rs.getInt(1),rs.getString(2),rs.getFloat(3),rs.getInt(4));
            heroList.add(hero);
        }
        pstmt.close();
        con.close();
        return heroList;
    }
}
