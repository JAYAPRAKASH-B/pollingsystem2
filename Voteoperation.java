package pollingsystem;

import java.util.Scanner;
import java.sql.*;

public class Voteoperation {
	
		


public void voterLogin() {
try {
		Dbconnection get1=new Dbconnection();
		Connection connect=get1.connectDb();
		Scanner scanner = new Scanner(System.in);
		System.out.println("enter the voterid");
		int voterid=scanner.nextInt();
		System.out.println("enter the voterName");
		String voterName=scanner.next();
		String query="select * from votingsystem where voterid="+voterid;
		Statement stmt=connect.createStatement();
		ResultSet rs=stmt.executeQuery(query);
		if(rs.absolute(1))
		{
			System.out.println("You are already voted ");
			connect.close();
			return;
		}
		else {
			System.out.println("enter your user name ");
			String username=scanner.next();
			System.out.println("enter the password");
			String password=scanner.next();
			String qry=("select * from voter where username='"+username+"' and password='"+password+"'");
			Statement sr=connect.createStatement();
			ResultSet r3=sr.executeQuery(qry);
			while(r3.next())
			{
				
				String username1=r3.getString(3);
				String password1=r3.getString(4);
				if(username1 !=null && password1 !=null)
				{
					System.out.println("Welcome to voting");
					System.out.println("enter value to poll\n01.DK\n02.DMK\n03.ADMK");
					int votingNumber=scanner.nextInt();
					System.out.println("enter the candidate id");
					int candidateid=scanner.nextInt();
					System.out.println("candidate name and party name");	
					String candidatename=scanner.next();
					String partyname=scanner.next();
					String sql="insert into votingsystem values("+voterid+",'"+voterName+"',"+votingNumber+","+candidateid+",'"+candidatename+"','"+partyname+"')";
					int ry=stmt.executeUpdate(sql);
					if(ry==1)
					{
						System.out.println("voted successfully thank you");
					}
					else
					{
						System.out.println("failed to voting");
					}
		}
	}
		}	
	}catch(Exception e) {
		System.out.println("no available");
	}
	}
	
	}