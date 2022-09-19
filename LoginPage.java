import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Random;
import java.io.File;
import java.util.Properties;
import javax.mail.Authenticator;
import javax.mail.*;
import javax.mail.internet.*;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import java.io.IOException;

//import javax.mail.Message;
//import javax.mail.PasswordAuthentication;
//import javax.mail.Session;
//import javax.mail.Transport;
//import javax.mail.internet.InternetAddress;
//import javax.mail.internet.MimeBodyPart;
//import javax.mail.internet.MimeMessage;
//import javax.mail.internet.MimeMultipart;

class Test1 extends Frame implements ActionListener
{
	Button b[]=new Button[10];
	Button b1,b2,b3,b4;
	Label []l=new Label[10];
	Label []m=new Label[11];
	Label la=new Label("No more Mails sent Today");	
	Font t,t1,t2;
	int []a=new int[32];
	String s2;
	Panel p,p1;
	public Test1()
	{
		setTitle("test1");	
		setLayout(null);
		setSize(1370,710);
		setVisible(true);
		for(int i=0;i<10;i++)
		{
			b[i]=new Button("Check");
			b[i].setBounds(1300,40+i*60,50,30);
			add(b[i]);
			b[i].addActionListener(this);
			b[i].setVisible(false);
		}
		p=new Panel();
		p.setBounds(450,285,410,400);
		p.setBackground(Color.GRAY);
		p.setLayout(null);
		p.setVisible(false);
		add(p);
		p1=new Panel();
		p1.setBounds(450,250,410,200);
		p1.setBackground(Color.GRAY);
		p1.setLayout(null);
		p1.setVisible(false);
		add(p1);
			t1=new Font("SERIF",Font.ITALIC,20);	
		t2=new Font("SERIF",Font.ITALIC,30);
		la.setBounds(40,50,350,50);
		la.setFont(t2);
		la.setForeground(Color.black);
		p1.add(la);
	
		b4=new Button("X");
		b4.setBounds(390,4,20,20);
		p1.add(b4);
		b4.addActionListener(this);
		
		for(int i=0;i<11;i++)
		{	
			m[i]=new Label();
			m[i].setFont(t1);
			m[i].setBounds(10,10+i*30,500,30);
			m[i].setForeground(Color.black);
			p.add(m[i]);
		}
		b2=new Button("back");
		b2.setBounds(160,340,60,30);
		p.add(b2);
		b2.addActionListener(this);
		
		b1=new Button("Next");
		b1.setBounds(630,660,60,30);
		add(b1);
		b1.addActionListener(this);
		
		b3=new Button("back");
		b3.setBounds(700,660,60,30);
		add(b3);
		b3.addActionListener(this);
		
		t=new Font("SERIF",Font.ITALIC,30);
		for(int i=0;i<10;i++)
		{
			l[i]=new Label();
			l[i].setFont(t);
			l[i].setBounds(20,30+i*60,1200,40);
			l[i].setForeground(Color.black);
			add(l[i]);
		}
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			});
	}
	public static String [] GetData(int x)
	{	
		String s1[]=new String[11];
		
		try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from customer where slot= "+x);
			set.next();
			s1[0]="Dear "+set.getString(2)+" this message is for ";
			s1[1]="remembering you that your vehicle, "+set.getString(6);
			s1[2]=set.getString(5)+" is park in our Parking Agency ";
			s1[3]="for more than 30 days.";
			s1[4]="We just want to remember you that if you do";
			s1[5]="not exit your vehicle the charges may applied";
			s1[6]="continuously.";
			s1[7]="Thanks for using our services.";
			s1[8]= "For more information contact the Agency.";
			s1[9]="Have a nice day.";
			s1[10]="THANK YOU..... ";
			
			s.close();
			c.close();
		}catch(Exception e){System.out.println(e);}
		return s1;
	} 
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource( )==b[0] )
		{
			p.setVisible(true);
			String q[]=GetData(a[0]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
			
		}
		if(ae.getSource( )==b[1] )
		{
			p.setVisible(true);
			String q[]=GetData(a[1]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[2] )
		{
			p.setVisible(true);
			String q[]=GetData(a[2]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[3] )
		{
			p.setVisible(true);
			String q[]=GetData(a[3]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[4] )
		{
			p.setVisible(true);
			String q[]=GetData(a[4]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[5] )
		{
			p.setVisible(true);
			String q[]=GetData(a[5]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}	
		if(ae.getSource( )==b[6] )
		{
			p.setVisible(true);
			String q[]=GetData(a[6]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[7] )
		{
			p.setVisible(true);
			String q[]=GetData(a[7]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[8] )
		{
			p.setVisible(true);
			String q[]=GetData(a[8]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[9] )
		{
			p.setVisible(true);
			String q[]=GetData(a[9]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b1)
		{
			if(a[10]>0)
			{
				setVisible(false);
				new Test2();
			}
			else
			p1.setVisible (true);
		}
		if(ae.getSource( )==b2)
		{
			p.setVisible(false);
		}
		if(ae.getSource( )==b3)
		{
			setVisible(false);
			new WelPage();
		}
		if(ae.getSource( )==b4)
		{
			p1.setVisible(false);
		}
	}
	public void paint(Graphics g)
	{	
		super.paint(g);
		try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from customer");
			set.next();
			int j=0;
			for (int i=0;i<32;i++)
			{
				if(set.getInt(1)!=0)
				{
					a[j]=set.getInt(7);
					if(j>=0 && j<=9)
					{
						//try{Thread.sleep(200);}catch(InterruptedException e){System.out.println(e);}
						l[j].setText("Mail sent to "+set.getString(2)+" Vehicle No. "+set.getString(5));
						g.drawLine(0,80+j*60,1370,80+j*60);
						b[j].setVisible(true);
					}
					j++;
				}
				set.next();
			}
			s.close();
			c.close();
		}catch(Exception e){System.out.println(e);}
	}
	public static void main(String[]args)
	{
			new Test1();			
	}	

}	

class Test2 extends Frame implements ActionListener
{
	Button b[]=new Button[10];
	Button b1,b2,b3,b4;
	Label []l=new Label[10];
	Label []m=new Label[11];
	Label la=new Label("No more Mails sent Today...");
	Font t,t1,t2;
	int []a=new int[32];
	String s2;
	Panel p,p1;
	public Test2()
	{
		setTitle("test2");	
		setLayout(null);
		setSize(1370,710);
		setVisible(true);
		for(int i=0;i<10;i++)
		{
			b[i]=new Button("Check");
			b[i].setBounds(1300,40+i*60,50,30);
			add(b[i]);
			b[i].addActionListener(this);
			b[i].setVisible(false);
		}
		p=new Panel();
		p.setBounds(450,285,410,400);
		p.setBackground(Color.GRAY);
		p.setLayout(null);
		p.setVisible(false);
		add(p);
		t1=new Font("SERIF",Font.ITALIC,20);
		
		p1=new Panel();
		p1.setBounds(450,250,410,200);
		p1.setBackground(Color.GRAY);
		p1.setLayout(null);
		p1.setVisible(false);
		add(p1);
		t2=new Font("SERIF",Font.ITALIC,30);
		la.setBounds(40,50,350,50);
		la.setFont(t2);
		la.setForeground(Color.black);
		p1.add(la);
	
		b4=new Button("X");
		b4.setBounds(390,4,20,20);
		p1.add(b4);
		b4.addActionListener(this);
	
			
		for(int i=0;i<11;i++)
		{	
			m[i]=new Label();
			m[i].setFont(t1);
			m[i].setBounds(10,10+i*30,500,30);
			m[i].setForeground(Color.black);
			p.add(m[i]);
		}
		b2=new Button("back");
		b2.setBounds(160,340,60,30);
		p.add(b2);
		b2.addActionListener(this);
		
		b1=new Button("Next");
		b1.setBounds(630,660,60,30);
		add(b1);
		b1.addActionListener(this);
		
		b3=new Button("back");
		b3.setBounds(700,660,60,30);
		add(b3);
		b3.addActionListener(this);
		
		t=new Font("SERIF",Font.ITALIC,30);
		for(int i=0;i<10;i++)
		{
			l[i]=new Label();
			l[i].setFont(t);
			l[i].setBounds(20,30+i*60,1200,40);
			l[i].setForeground(Color.black);
			add(l[i]);
		}
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			});
	}
	public static String [] GetData(int x)
	{	
		String s1[]=new String[11];
		
		try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from customer where slot= "+x);
			set.next();
			s1[0]="Dear "+set.getString(2)+" this message is for ";
			s1[1]="remembering you that your vehicle, "+set.getString(6);
			s1[2]=set.getString(5)+" is park in our Parking Agency ";
			s1[3]="for more than 30 days.";
			s1[4]="We just want to remember you that if you do";
			s1[5]="not exit your vehicle the charges may applied";
			s1[6]="continuously.";
			s1[7]="Thanks for using our services.";
			s1[8]= "For more information contact the Agency.";
			s1[9]="Have a nice day.";
			s1[10]="THANK YOU..... ";
			
			s.close();
			c.close();
		}catch(Exception e){System.out.println(e);}
		return s1;
	} 
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource( )==b[0] )
		{
			p.setVisible(true);
			String q[]=GetData(a[10]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
			
		}
		if(ae.getSource( )==b[1] )
		{
			p.setVisible(true);
			String q[]=GetData(a[11]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[2] )
		{
			p.setVisible(true);
			String q[]=GetData(a[12]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[3] )
		{
			p.setVisible(true);
			String q[]=GetData(a[13]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[4] )
		{
			p.setVisible(true);
			String q[]=GetData(a[14]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[5] )
		{
			p.setVisible(true);
			String q[]=GetData(a[15]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}	
		if(ae.getSource( )==b[6] )
		{
			p.setVisible(true);
			String q[]=GetData(a[16]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[7] )
		{
			p.setVisible(true);
			String q[]=GetData(a[17]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[8] )
		{
			p.setVisible(true);
			String q[]=GetData(a[18]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[9] )
		{
			p.setVisible(true);
			String q[]=GetData(a[19]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b1)
		{
			if(a[20]>0)
			{
				setVisible(false);
				new Test3();
			}
			else
			{
				p1.setVisible(true);
			}
		}
		if(ae.getSource( )==b2)
		{
			p.setVisible(false);
		}
		if(ae.getSource( )==b3)
		{
			setVisible(false);
			new Test1();
		}
		if(ae.getSource( )==b4)
		{
			p1.setVisible(false);
		}
	}
	public void paint(Graphics g)
	{	
		super.paint(g);
		try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from customer");
			set.next();
			int j=0;
			for (int i=0;i<32;i++)
			{
				if(set.getInt(1)!=0)
				{
					a[j]=set.getInt(7);
					if(j>=10 &&j<=19)
					{
						//try{Thread.sleep(200);}catch(InterruptedException e){System.out.println(e);}
						l[j-10].setText("Mail sent to "+set.getString(2)+" Vehicle No. "+set.getString(5));
						g.drawLine(0,80+(j-10)*60,1370,80+(j-10)*60);
						b[j-10].setVisible(true);
					}
					j++;
				}
				set.next();
			}
			s.close();
			c.close();
		}catch(Exception e){System.out.println(e);}
	}
	public static void main(String[]args)
	{
			new Test2();			
	}	

}		

class Test3 extends Frame implements ActionListener
{
	Button b[]=new Button[10];
	Button b1,b2,b3,b4;
	Label []l=new Label[10];
	Label []m=new Label[11];
	Label la=new Label("No more Mails sent Today...");
	Font t,t1,t2;
	int []a=new int[32];
	String s2;
	Panel p,p1;
	public Test3()
	{
		setTitle("test2");	
		setLayout(null);
		setSize(1370,710);
		setVisible(true);
		for(int i=0;i<10;i++)
		{
			b[i]=new Button("Check");
			b[i].setBounds(1300,40+i*60,50,30);
			add(b[i]);
			b[i].addActionListener(this);
			b[i].setVisible(false);
		}
		p=new Panel();
		p.setBounds(450,285,410,400);
		p.setBackground(Color.GRAY);
		p.setLayout(null);
		p.setVisible(false);
		add(p);
		t1=new Font("SERIF",Font.ITALIC,20);
		
		p1=new Panel();
		p1.setBounds(450,250,410,200);
		p1.setBackground(Color.GRAY);
		p1.setLayout(null);
		p1.setVisible(false);
		add(p1);
		t2=new Font("SERIF",Font.ITALIC,30);
		la.setBounds(40,50,350,50);
		la.setFont(t2);
		la.setForeground(Color.black);
		p1.add(la);
	
		b4=new Button("X");
		b4.setBounds(390,4,20,20);
		p1.add(b4);
		b4.addActionListener(this);
	
			
		for(int i=0;i<11;i++)
		{	
			m[i]=new Label();
			m[i].setFont(t1);
			m[i].setBounds(10,10+i*30,500,30);
			m[i].setForeground(Color.black);
			p.add(m[i]);
		}
		b2=new Button("back");
		b2.setBounds(160,340,60,30);
		p.add(b2);
		b2.addActionListener(this);
		
		b1=new Button("Next");
		b1.setBounds(630,660,60,30);
		add(b1);
		b1.addActionListener(this);
		
		b3=new Button("back");
		b3.setBounds(700,660,60,30);
		add(b3);
		b3.addActionListener(this);
		
		t=new Font("SERIF",Font.ITALIC,30);
		for(int i=0;i<10;i++)
		{
			l[i]=new Label();
			l[i].setFont(t);
			l[i].setBounds(20,30+i*60,1200,40);
			l[i].setForeground(Color.black);
			add(l[i]);
		}
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			});
	}
	public static String [] GetData(int x)
	{	
		String s1[]=new String[11];
		
		try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from customer where slot= "+x);
			set.next();
			s1[0]="Dear "+set.getString(2)+" this message is for ";
			s1[1]="remembering you that your vehicle, "+set.getString(6);
			s1[2]=set.getString(5)+" is park in our Parking Agency ";
			s1[3]="for more than 30 days.";
			s1[4]="We just want to remember you that if you do";
			s1[5]="not exit your vehicle the charges may applied";
			s1[6]="continuously.";
			s1[7]="Thanks for using our services.";
			s1[8]= "For more information contact the Agency.";
			s1[9]="Have a nice day.";
			s1[10]="THANK YOU..... ";
			
			s.close();
			c.close();
		}catch(Exception e){System.out.println(e);}
		return s1;
	} 
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource( )==b[0] )
		{
			p.setVisible(true);
			String q[]=GetData(a[20]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
			
		}
		if(ae.getSource( )==b[1] )
		{
			p.setVisible(true);
			String q[]=GetData(a[21]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[2] )
		{
			p.setVisible(true);
			String q[]=GetData(a[22]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[3] )
		{
			p.setVisible(true);
			String q[]=GetData(a[23]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[4] )
		{
			p.setVisible(true);
			String q[]=GetData(a[24]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[5] )
		{
			p.setVisible(true);
			String q[]=GetData(a[25]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}	
		if(ae.getSource( )==b[6] )
		{
			p.setVisible(true);
			String q[]=GetData(a[26]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[7] )
		{
			p.setVisible(true);
			String q[]=GetData(a[27]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[8] )
		{
			p.setVisible(true);
			String q[]=GetData(a[28]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b[9] )
		{
			p.setVisible(true);
			String q[]=GetData(a[29]);
			String q1[]=new String[11];
			int i=0;
			for(String str : q)
        			{q1[i]=str;i++;}
			for(int j=0;j<11;j++)
			m[j].setText(q1[j]);
		}
		if(ae.getSource( )==b1)
		{
			if(a[30]>0)
			{
				setVisible(false);
			}
			else
			{
				p1.setVisible(true);
			}
		}
		if(ae.getSource( )==b2)
		{
			p.setVisible(false);
		}
		if(ae.getSource( )==b3)
		{
			setVisible(false);
			new Test1();
		}
		if(ae.getSource( )==b4)
		{
			p1.setVisible(false);
		}
	}
	public void paint(Graphics g)
	{	
		super.paint(g);
		try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from customer");
			set.next();
			int j=0;
			for (int i=0;i<32;i++)
			{
				if(set.getInt(1)!=0)
				{
					a[j]=set.getInt(7);
					if(j>=20 &&j<=29)
					{
						//try{Thread.sleep(200);}catch(InterruptedException e){System.out.println(e);}
						l[j-20].setText("Mail sent to "+set.getString(2)+" Vehicle No. "+set.getString(5));
						g.drawLine(0,80+(j-20)*60,1370,80+(j-20)*60);
						b[j-20].setVisible(true);
					}
					j++;
				}
				set.next();
			}
			s.close();
			c.close();
		}catch(Exception e){System.out.println(e);}
	}
	public static void main(String[]args)
	{
			new Test3();			
	}	

}	

class HistoryPage extends Frame implements ActionListener
{
	Button b1,b2,b3,b4,b5;
	Label []N=new Label[14];
	Label []A=new Label[14];
	Label []P=new Label[14];
	Label []M=new Label[14];
	Label []CI=new Label[14];
	Label []CO=new Label[14];
	Label []B=new Label[14];
	Label la,lb,lc,ld,le,lf,lg,lh,li,lj;
	Font t,t1,t2;
	Panel p;
	TextField tf1,tf2,tf3;
	java.util.Date d=new java.util.Date();
	HistoryPage()
	{
		setSize(1370,710);
		setVisible(true);
		setLayout(null);
		t2=new Font("SERIF",Font.ITALIC,30);
		t1=new Font("SERIF",Font.ITALIC,20);
		
		p=new Panel();
		p.setBounds(1200,638,130,60);
		p.setBackground(Color.GRAY);
		p.setLayout(null);
		p.setVisible(false);
		add(p);
		b5=new Button("X");
		b5.setBounds(115,0,15,15);
		p.add(b5);
		b5.addActionListener(this);
		lj=new Label("Invalid Date");
		lj.setBounds(10,15,120,30);
		lj.setFont(t1);
		lj.setForeground(Color.black);	
		p.add(lj);

		for(int i=0;i<14;i++)
		{
			N[i]=new Label();
			N[i].setBounds(10,73+i*40,195,35);
			N[i].setFont(t1);
			N[i].setForeground(Color.black);	
			add(N[i]);
			
			A[i]=new Label();
			A[i].setBounds(211,73+i*40,295,35);
			A[i].setFont(t1);
			A[i].setForeground(Color.black);	
			add(A[i]);
			
			P[i]=new Label();
			P[i].setBounds(512,73+i*40,145,35);
			P[i].setFont(t1);
			P[i].setForeground(Color.black);	
			add(P[i]);
			
			M[i]=new Label();
			M[i].setBounds(663,73+i*40,225,35);
			M[i].setFont(t1);
			M[i].setForeground(Color.black);	
			add(M[i]);
			
			CI[i]=new Label();
			CI[i].setBounds(894,73+i*40,155,35);
			CI[i].setFont(t1);
			CI[i].setForeground(Color.black);	
			add(CI[i]);
			
			CO[i]=new Label();
			CO[i].setBounds(1055,73+i*40,155,35);
			CO[i].setFont(t1);
			CO[i].setForeground(Color.black);	
			add(CO[i]);
			
			B[i]=new Label();
			B[i].setBounds(1216,73+i*40,138,35);
			B[i].setFont(t1);
			B[i].setForeground(Color.black);	
			add(B[i]);
		}


		la=new Label("Name");
		la.setBounds(10,20,200,50);
		la.setFont(t2);
		la.setBackground(Color.red);
		la.setForeground(Color.black);	
		add(la);
		lb=new Label("Address");
		lb.setBounds(211,20,300,50);
		lb.setFont(t2);
		lb.setBackground(Color.red);
		lb.setForeground(Color.black);	
		add(lb);
		lc=new Label("Ph. No.");
		lc.setBounds(512,20,150,50);
		lc.setFont(t2);
		lc.setBackground(Color.red);
		lc.setForeground(Color.black);	
		add(lc);
		ld=new Label("Model");
		ld.setBounds(663,20,230,50);
		ld.setFont(t2);
		ld.setBackground(Color.red);
		ld.setForeground(Color.black);	
		add(ld);
		le=new Label("Check in");
		le.setBounds(894,20,160,50);
		le.setFont(t2);
		le.setBackground(Color.red);
		le.setForeground(Color.black);	
		add(le);
		lf=new Label("Check out");
		lf.setBounds(1055,20,160,50);
		lf.setFont(t2);
		lf.setBackground(Color.red);
		lf.setForeground(Color.black);	
		add(lf);
		lg=new Label("Bill Paid");
		lg.setBounds(1216,20,142,50);
		lg.setFont(t2);
		lg.setBackground(Color.red);
		lg.setForeground(Color.black);	
		add(lg);
		
		lh=new Label("Page 1");
		lh.setBounds(20,650,142,50);
		lh.setFont(t1);
		lh.setForeground(Color.black);	
		add(lh);
		li=new Label("Enter Date");
		li.setBounds(690,645,140,30);
		li.setFont(t2);
		li.setForeground(Color.black);	
		add(li);
		
		tf1=new TextField(10);
		tf1.setBounds(830,650,30,25);
		add(tf1);
		tf2=new TextField(10);
		tf2.setBounds(865,650,30,25);
		add(tf2);
		tf3=new TextField(10);
		tf3.setBounds(900,650,50,25);
		add(tf3);
		
		b4=new Button("Filter");
		b4.setBounds(1000,650,60,30);
		add(b4);
		b4.addActionListener(this);

		b1=new Button("Next");
		b1.setBounds(350,650,60,30);
		add(b1);
		b1.addActionListener(this);
		
		b2=new Button("Back");
		b2.setBounds(420,650,60,30);
		add(b2);
		b2.addActionListener(this);
		b3=new Button("Go Back");
		b3.setBounds(490,650,90,30);
		add(b3);
		b3.addActionListener(this);
		setAtr(0);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});	
	}
	int i=1; 
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource( )==b1 )
		{		
			setAtr(i*14);
			lh.setText("Page "+(i+1));
			i++;
		}
		if(ae.getSource( )==b2 )
		{
			setAtr((--i)*14-14);
			if(i<=0)
			i=1;
			lh.setText("Page "+i);
		}
		if(ae.getSource( )==b3 )
		{
			setVisible(false);
			new WelPage();
		}
		if(ae.getSource( )==b4 )
		{
			setAtr(0);
		}
		if(ae.getSource( )==b5 )
		{
			p.setVisible(false);
		}
	}
	public void paint(Graphics g)
	{	
		super.paint(g);
		g.drawLine(9,20,9,630);
		g.drawLine(210,20,210,630);
		g.drawLine(511,20,511,630);
		g.drawLine(662,20,662,630);
		g.drawLine(893,20,893,630);
		g.drawLine(1054,20,1054,630);
		g.drawLine(1215,20,1215,630);
		g.drawLine(1358,20,1358,630);
		for (int i=0;i<15;i++)
		{
			g.drawLine(9,70+i*40,1358,70+i*40);
		}	
		
	}
	int CheckDate(int x, int y, int z,int a,int b, int c)
	{
		if(x<1 || y<1 || z<1)
		return 2;
		if(x>31 || y>12)
		return 2;
		if(y==4 || y==6 || y==9 || y==11)
		{
			if(x>30)
			return 2;
		}
		if(y==2)
		{
			if(x>29 && z%4==0)
			return 2;
			if(x>28 && z%4!=0)
			return 2;
		}
		if(z>c)
		return 1;
		else if(z<c)
		return 0;
		else
		{
			if(y>b)
			return 1;
			else if(y<b)
			return 0;
			else
			{
				if(x>a)
				return 1;
				else if(x<a)
				return 0;
				else
				return 1;
			}
		}
		
	}
		
		void setAtr(int x)
		{	
			int result=0;
		try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from history order by name");
			if(tf1.getText().equals("") || tf2.getText().equals("") || tf3.getText().equals(""))
			{
				for(int i=0;i<x;i++)
				{
					set.next();
				}
				for(int i=0;i<14;i++)
				{	
					if(set.next())
					{	
							N[i].setText(set.getString(1));
							A[i].setText(set.getString(2));
							P[i].setText(""+set.getLong(3));
							M[i].setText(set.getString(4)+" "+set.getString(5));
							CI[i].setText(set.getInt(6)+"/"+set.getInt(7)+"/"+set.getInt(8)+"   "+set.getInt(9)+":"+set.getInt(10));
							CO[i].setText(set.getInt(11)+"/"+set.getInt(12)+"/"+set.getInt(13)+"   "+set.getInt(14)+":"+set.getInt(15));
							B[i].setText(""+set.getInt(16));
					}
					else
					{	
						N[i].setText("");
						A[i].setText("");
						P[i].setText("");
						M[i].setText("");
						CI[i].setText("");
						CO[i].setText("");
						B[i].setText("");
					}
				}
			}
			else
			{
				for(int i=0;i<x;i++)
				{
					set.next();
				}
				for(int i=0;i<14;i++)
				{		
					if(set.next())
					{	
						result=CheckDate(Integer.parseInt(tf1.getText()),Integer.parseInt(tf2.getText()),Integer.parseInt(tf3.getText()),set.getInt(11),set.getInt(12),set.getInt(13));
						if(result==0)
						i--;	
						else if(result==2)
						p.setVisible(true);
						else
						{
							N[i].setText(set.getString(1));
							A[i].setText(set.getString(2));
							P[i].setText(""+set.getLong(3));
							M[i].setText(set.getString(4)+" "+set.getString(5));
							CI[i].setText(set.getInt(6)+"/"+set.getInt(7)+"/"+set.getInt(8)+"   "+set.getInt(9)+":"+set.getInt(10));
							CO[i].setText(set.getInt(11)+"/"+set.getInt(12)+"/"+set.getInt(13)+"   "+set.getInt(14)+":"+set.getInt(15));
							B[i].setText(""+set.getInt(16));
						}
					}
					else
					{	
						N[i].setText("");
						A[i].setText("");
						P[i].setText("");
						M[i].setText("");
						CI[i].setText("");
						CO[i].setText("");
						B[i].setText("");
					}
				}
			}	
			s.close();
			c.close();
			}catch(Exception e){System.out.println(e);}
		}

	public static void main(String [] args)
	{
		new HistoryPage();
	}
}	

class ParSlot extends Frame implements ActionListener
{
	
	Button b,b1;
	WelPage wp;
	Font s,t;
	Panel p0,p00;
	Panel []p=new Panel[32];
	Label l0,l00;
	Label []l=new Label[32];
	public ParSlot()
	{

		setTitle("ParSlot");	
		setLayout(null);
		setSize(1370,710);
		setVisible(true);
		p0=new Panel();
		p0.setBounds(150,10,150,60);
		p0.setBackground(Color.GRAY);
		p0.setLayout(null);
		add(p0);
		t=new Font("SERIF",Font.BOLD,20);
		l0=new Label("Two wheeler");
		l0.setFont(t);
		l0.setBounds(20,30,120,25);
		l0.setForeground(Color.white);
		p0.add(l0);
		p00=new Panel();
		p00.setBounds(1000,10,150,60);
		p00.setBackground(Color.GRAY);
		p00.setLayout(null);
		add(p00);
		t=new Font("SERIF",Font.BOLD,20);
		l00=new Label("Four Wheeler");
		l00.setFont(t);
		l00.setBounds(20,30,120,25);
		l00.setForeground(Color.white);
		p00.add(l00);	
		for (int i=0;i<p.length;i++)
		p[i]=new Panel();
		int k=0,u=50;
		for(int j=0;j<2;j++)
		{	
			int g=80;
			for(int i=0;i<=7;i++)
			{
				p[k].setBounds(u,g,150,50);
				k+=1;
				g+=70;
			}
			u+=200;
		}
		int u1=900;
		for(int j=0;j<2;j++)
		{	
			int g=80;
			for(int i=0;i<=7;i++)
			{
				p[k].setBounds(u1,g,150,50);
				k+=1;
				g+=70;
			}
			u1+=200;
		}
		for (int i=0;i<32;i++)
		{
			p[i].setBackground(Color.RED);
		}
		s=new Font("SERIF",Font.BOLD, 25);	
		for(int i=0;i<32;i++)
		{
			l[i]=new Label("Slot "+(i+1));
			l[i].setFont(s);
			l[i].setForeground(Color.white);
		}
		for(int i=0;i<8;i++)
		{
			l[i].setBounds(40,15,70,25);
			p[i].add(l[i]);
		}
		for(int i=8;i<32;i++)
		{
			l[i].setBounds(35,15,70,25);
			p[i].add(l[i]);
		}
		for(int i=0;i<p.length;i++)
		add(p[i]);
		b=new Button("Check-in");
		b.setBounds(580,600,80,35);
		add(b);
		b.addActionListener(this);
		b1=new Button("Check-out");
		b1.setBounds(680,600,80,35);
		add(b1);
		b1.addActionListener(this);
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			});
	}
	public void CheckSlot()
	{
		try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from customer");
			set.next();
			for (int i=0;i<32;i++)
			{
				if(set.getInt(1)!=0)
				p[i].setBackground(Color.green);
				set.next();
			}
			s.close();
			c.close();
		}catch(Exception e){System.out.println(e);}
	}
	
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource( )==b)
		{
			CusDet det=new CusDet( );
			det.wp=this.wp;
			det.setWp( );
			setVisible(false);
		}
		if(ae.getSource()==b1)
		{
			new Vehicle();
			setVisible(false);
		}
	}
}
class BillPay extends Frame implements ActionListener
{ 
	Font b,a;
	Panel p1,p2,p3,p4,p5;
	Label l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,L2,L3,L4,L5,L6,L7,L8,L9;
	Vehicle vh=null;
	Button b1;
	public BillPay()
	{	
		setSize(1370,710);
		setVisible(true);
		setLayout(null);
		setTitle("BillPay");		
		p3=new Panel();
		p3.setBounds(0,0,1370,100);
		p3.setBackground(Color.blue);
		p3.setLayout(null);
		add(p3);
		l0=new Label("CITY STREET PARKING");
		b=new Font("SERIF",Font.BOLD,40);
		l0.setForeground(Color.white);
		l0.setFont(b);
		l0.setBounds(450,50,480,40);
		p3.add(l0);
		p4=new Panel();
		p4.setBounds(1325,0,40,710);
		p4.setBackground(Color.blue);
		add(p4);
		p5=new Panel();
		p5.setBounds(0,670,1370,40);
		p5.setBackground(Color.blue);
		add(p5);                          
		p1=new Panel();
		p1.setBounds(0,0,10,710);
		p1.setBackground(Color.gray);
		add(p1);
		p2=new Panel();
		p2.setBounds(10,10,20,710);
		p2.setBackground(Color.blue);
		add(p2);
		a=new Font("SERIF",Font.BOLD, 20);
		b=new Font("SERIF",Font.BOLD, 40);
		l1=new Label("Bill Payment");
		l1.setFont(b);
		l1.setBounds(510,130,350,40);
		l2=new Label("Vehicle ID:");
		l2.setFont(a);
		l2.setBounds(430,200,100,20);
		l3=new Label("Customer Name:");
		l3.setFont(a);
		l3.setBounds(430,230,150,20);
		l4=new Label("Customer Address:");
		l4.setFont(a);
		l4.setBounds(430,260,150,20);
		l5=new Label("Checkin-time:");
		l5.setFont(a);
		l5.setBounds(430,290,150,20);
		l6=new Label("Checkin-date:");
		l6.setFont(a);
		l6.setBounds(430,320,150,20);
		l7=new Label("Checkout-time:");
		l7.setFont(a);
		l7.setBounds(430,350,150,20);
		l8=new Label("Checkout-date:");
		l8.setFont(a);
		l8.setBounds(430,380,150,20);
		l9=new Label("Total paymnet:");
		l9.setFont(a);
		l9.setBounds(430,410,150,20);
		b1=new Button("back");
		b1.setBounds(580,470,80,40);
		add(l1);
		add(l2);
		add(l3); 
		add(l4); 
		add(l5);
		add(l6);
		add(l7); 
		add(l8); 
		add(l9);
		add(b1);
		b1.addActionListener(this);	
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});				
	}
	public int timeCheck(int i,int j)
	{
		if (i>j)
		return (i-j);
		if(j>i)
		return (j-i);
		return 0;
	}
	public void setAtr()
	{	
		java.util.Date d=new java.util.Date();
		try{
			Connection c;
			ResultSet set;
			Statement s;
			PreparedStatement st;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			st=c.prepareStatement("insert into history values(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)");
			set=s.executeQuery("select * from customer where slot= "+vh.slot);
			set.next();
		L2=new Label(set.getString(5));
		L2.setBounds(700,200,100,20);
		L3=new Label(set.getString(2));
		L3.setBounds(700,230,250,20);
		L4=new Label(set.getString(3));
		L4.setBounds(700,260,500,20);
		L5=new Label(set.getInt(11)+":"+set.getInt(12));
		L5.setBounds(700,290,100,20);
		L6=new Label(set.getInt(8)+"/"+set.getInt(9)+"/"+set.getInt(10));
		L6.setBounds(700,320,100,20);
		L7=new Label(" "+d.getHours()+":"+d.getMinutes());
		L7.setBounds(700,350,100,20);
		L8=new Label(" "+d.getDate()+"/"+(d.getMonth()+1)+"/"+(d.getYear()+1900));
		L8.setBounds(700,380,100,20);
		int total,result;
		result=timeCheck(d.getMinutes(),set.getInt(12))/60+ timeCheck(d.getHours(),set.getInt(11))+ timeCheck(d.getDate(),set.getInt(8))*24+ timeCheck((d.getMonth()+1),set.getInt(9))*30*24+ timeCheck((d.getYear()+1900),set.getInt(10))*365*30*24 ;
		if(result==0)
		total=2;
		else
		total=result*2;
		L9=new Label(" "+total);
		L9.setBounds(700,410,100,20);		
		add(L2);
		add(L3); 
		add(L4); 
		add(L5);
		add(L6);
		add(L7); 
		add(L8); 
		add(L9);
			st.setString(1,set.getString(2));
			st.setString(2,set.getString(3));
			st.setLong(3,set.getLong(4));
			st.setString(4,set.getString(6));
			st.setString(5,set.getString(5));
			st.setInt(6,set.getInt(8));
			st.setInt(7,set.getInt(9));
			st.setInt(8,set.getInt(10));
			st.setInt(9,set.getInt(11));
			st.setInt(10,set.getInt(12));
			st.setInt(11,d.getDate());
			st.setInt(12,d.getMonth()+1);
			st.setInt(13,d.getYear()+1900);
			st.setInt(14,d.getHours());
			st.setInt(15,d.getMinutes());		
			st.setInt(16,total);
			st.setString(17,set.getString(13));
			st.executeUpdate();

			s.close();
			st.close();
			c.close();
			}catch(Exception e){System.out.println(e);}
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try{
				Connection c;
				ResultSet set;
				Statement s;
				Class.forName("oracle.jdbc.driver.OracleDriver");
				c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");			
				s=c.createStatement();
			s.executeUpdate("update customer set cid = "+null+", cname= "  +null
					+ ",cadd ="+null
					+",cph ="+null
					+",vnum="+null
					+",model="+null
					+",checkindate="+null
					+",checkinmonth="+null
					+",checkinyear="+null
					+",checkinhr="+null
					+",checkinmin="+null
					+ ",cmail="+null+" where slot= "+vh.slot);
			s.close();
			c.close();				
			}catch(Exception e){System.out.println(e);}
			new WelPage();
			setVisible(false);
		}
	}
}	
class Vehicle extends Frame implements ActionListener
{
	Font a,b;
	Label l0,l1,l2,l3;
	TextField t1;
	Button b1,b2,b3,b4;
	int slot;
	Panel p,p1,p2,p3,p4,p5,p6;
	public Vehicle()
	{
		setTitle("Vehicle");
		setSize(1370,710);
		setVisible(true);
		setLayout(null);
		p=new Panel();
		p.setBounds(500,200,330,200);
		p.setLayout(null);
		p.setBackground(Color.gray);
		p.setVisible(false);
		add(p);
		p6=new Panel();
		p6.setBounds(500,200,330,200);
		p6.setLayout(null);
		p6.setBackground(Color.gray);
		p6.setVisible(false);
		add(p6);
		p2=new Panel();
		p2.setBounds(10,10,40,710);
		p2.setBackground(Color.blue);
		add(p2);
		p3=new Panel();
		p3.setBounds(0,0,1370,100);
		p3.setBackground(Color.blue);
		p3.setLayout(null);
		add(p3);
		l0=new Label("CITY STREET PARKING");
		b=new Font("SERIF",Font.BOLD,40);
		l0.setForeground(Color.white);
		l0.setFont(b);
		l0.setBounds(450,50,480,40);
		p3.add(l0);
		l2=new Label("::Slot is empty::");
		l2.setForeground(Color.white);
		l2.setBounds(20,70,280,50);
		l2.setFont(b);
		p.add(l2);
		l3=new Label("::Slot is invalid::");
		l3.setForeground(Color.white);
		l3.setBounds(20,70,280,50);
		l3.setFont(b);
		p6.add(l3);
		p4=new Panel();
		p4.setBounds(1325,0,40,710);
		p4.setBackground(Color.blue);
		add(p4);
		p5=new Panel();
		p5.setBounds(0,670,1370,40);
		p5.setBackground(Color.blue);
		add(p5);
		a=new Font("SERIF",Font.BOLD, 20);
		l1=new Label("Enter Slot Number:");
		l1.setFont(a);
		l1.setBounds(400,350,210,30);
		add(l1);
		t1=new TextField(30);
		t1.setBounds(650,350,200,30);
		add(t1);
		t1.setText("0");
		slot=Integer.parseInt(t1.getText());
		b1=new Button("Ok");
		b1.setBounds(520,450,100,30);
		add(b1);
		b2=new Button("back");
		b2.setBounds(700,450,100,30);
		add(b2);
		b3=new Button("X");
		b3.setBounds(305,5,20,20);
		p.add(b3);
		b4=new Button("X");
		b4.setBounds(305,5,20,20);
		p6.add(b4);	
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);	
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	public void actionPerformed(ActionEvent ae)
		{
			if(ae.getSource()==b1)
			{
			try{
			Connection c;
			ResultSet set;
			Statement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();
			set=s.executeQuery("select * from customer where slot= "+Integer.parseInt(t1.getText()));
			set.next();
			if(Integer.parseInt(t1.getText())>=33 || Integer.parseInt(t1.getText())==0 )
			{p6.setVisible(true);}
				if(set.getString(1)==null)
				p.setVisible(true);
				else
				{
					BillPay bp1=new BillPay();
					bp1.vh=this;
					bp1.vh.slot=Integer.parseInt(t1.getText());
					bp1.setAtr();
					setVisible(false);
				}
			s.close();
			c.close();
		}catch(Exception e){System.out.println(e);}						
			}
			if(ae.getSource()==b2)
			{
				new WelPage();
				this.setVisible(false);
			}
			if(ae.getSource()==b3)
			{
				p.setVisible(false);
			}
			if(ae.getSource()==b4)
			{
				p6.setVisible(false);
			}
		}
}
class CusDet extends Frame implements ActionListener
{
	Font a,b,c;
	Label l0,l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11;
	TextField tf1,tf2,tf3,tf4,tf5,tf6,tf7,tf8,tf9;
	Button btn,btn1,btn2,btn3;
	Panel p,p1,p2,p3,p4,p5;
	WelPage wp=null;
	String s1,s2,s3,s4,s5,s6,s7,s8,s9;
	java.util.Date d=new java.util.Date( );
	public CusDet()
	{	
		setTitle("CusDet");
		setSize(1370,710);
		setVisible(true);
		setLayout(null);
		p=new Panel();
		p.setBounds(500,280,300,150);
		p.setLayout(null);
		p.setBackground(Color.gray);
		p.setVisible(false);
		add(p);
		p1=new Panel();
		p1.setBounds(490,290,300,150);
		p1.setLayout(null);
		p1.setBackground(Color.gray);
		p1.setVisible(false);
		add(p1);
		
		p2=new Panel();
		p2.setBounds(10,10,40,710);
		p2.setBackground(Color.blue);
		add(p2);
		p3=new Panel();
		p3.setBounds(0,0,1370,100);
		p3.setBackground(Color.blue);
		p3.setLayout(null);
		add(p3);
		l0=new Label("CITY STREET PARKING");
		b=new Font("SERIF",Font.BOLD,40);
		c=new Font("SERIF",Font.BOLD,25);
		l0.setForeground(Color.white);
		l0.setFont(b);
		l0.setBounds(450,50,480,40);
		p3.add(l0);
		p4=new Panel();
		p4.setBounds(1325,0,40,710);
		p4.setBackground(Color.blue);
		add(p4);
		p5=new Panel();
		p5.setBounds(0,670,1370,40);
		p5.setBackground(Color.blue);
		add(p5);	
		a=new Font("SERIF",Font.BOLD, 20);
		l1=new Label("Customer ID:");
		l1.setBounds(90,200,150,30);
		l1.setFont(a);
		l9=new Label("::Data has been submitted::");
		l9.setForeground(Color.white);
		l9.setBounds(30,70,250,50);
		l9.setFont(a);
		p.add(l9);
		
		l11=new Label("::Enter Proper Data::");
		l11.setForeground(Color.white);
		l11.setBounds(30,50,250,50);
		l11.setFont(c);
		p1.add(l11);
		
		l2=new Label("Customer Name:");
		l2.setBounds(90,240,150,30);
		l2.setFont(a);
		l3=new Label("Customer Address:");
		l3.setBounds(90,280,170,30);
		l3.setFont(a);
		l4=new Label("Customer Contact No:");
		l4.setBounds(90,320,200,30);
		l4.setFont(a);
		l10=new Label("Customer Mail Id:");
		l10.setBounds(90,360,200,30);
		l10.setFont(a);
		tf1=new TextField(35);
		tf1.setBounds(290,200,200,30);
		tf2=new TextField(35);
		tf2.setBounds(290,240,200,30);
		tf3=new TextField(35);
		tf3.setBounds(290,280,200,30);
		tf4=new TextField(35);
		tf4.setBounds(290,320,200,30);
		tf9=new TextField(35);
		tf9.setBounds(290,360,200,30);
		add(l1); 
		add(tf1);
		add(l2);
		add(tf2);
		add(l3); 
		add(tf3);
		add(l4); 
		add(tf4);
		add(l10);
		add(tf9);
		btn=new Button("Submit");
		btn.setFont(a);
		btn.setBounds(580,500,150,40);
		add(btn);
		btn1=new Button("back");
		btn1.setBounds(750,500,100,40);
		btn1.setFont(a);
		add(btn1);
		btn2=new Button("X");
		btn2.setBounds(280,0,20,20);
		btn2.setFont(a);
		p.add(btn2);
		
		btn3=new Button("X");
		btn3.setBounds(280,0,20,20);
		btn3.setFont(a);
		p1.add(btn3);
		
		btn.addActionListener(this);
		btn1.addActionListener(this);
		btn2.addActionListener(this);
		btn3.addActionListener(this);
		l5=new Label("Vehicle Number:");
		l5.setBounds(780,200,150,30);
		l5.setFont(a);
		l6=new Label("Model Name:");
		l6.setBounds(780,240,150,30);
		l6.setFont(a);
		l7=new Label("Slot Number:");
		l7.setBounds(780,280,150,30);
		l7.setFont(a);
		l8=new Label("Vehicle Type:");
		l8.setBounds(780,320,150,30);
		l8.setFont(a);
		tf5=new TextField(35);
		tf5.setBounds(1020,200,200,30);
		tf6=new TextField(35);
		tf6.setBounds(1020,240,200,30);
		tf7=new TextField(35);
		tf7.setBounds(1020,280,200,30);
		tf8=new TextField(35);
		tf8.setBounds(1020,320,200,30);
		add(l5); 
		add(tf5);
		add(l6);
		add(tf6);
		add(l7); 
		add(tf7);
		add(l8); 
		add(tf8);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});				
	}
	public void setStr()
	{
		s1=tf1.getText();
		s2=tf2.getText();
		s3=tf3.getText();
		s4=tf4.getText();
		s5=tf5.getText();
		s6=tf6.getText();
		s7=tf7.getText();
		s8=tf8.getText();
		s9=tf9.getText();	
	}
	public void storeData()
	{
		try{
			Connection c;
			ResultSet set;
			PreparedStatement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");			
			s=c.prepareStatement("update customer set cid=? , cname=? , cadd=? , cph=? , vnum=? , model=? , checkindate=? , checkinmonth=?,checkinyear=?,checkinhr=?,checkinmin=?,cmail=? where slot=?");
			s.setInt(1,Integer.parseInt(s1));
			s.setString(2,s2);
			s.setString(3,s3);
			s.setLong(4,Long.parseLong(s4));
			s.setString(5,s5);
			s.setString(6,s6);
			s.setInt(7,d.getDate());
			s.setInt(8,d.getMonth()+1);
			s.setInt(9,d.getYear()+1900);
			s.setInt(10,d.getHours());
			s.setInt(11,d.getMinutes());
			s.setString(12,s9);
			s.setInt(13,Integer.parseInt(s7));
			s.executeUpdate();
		s.close();
		c.close();
		}catch(Exception e){System.out.println(e);}
	}
	public void setWp()
	{
		tf8.setText(wp.c.getSelectedItem());
		tf8.setEditable(false);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getActionCommand().equals("Submit"))
		{	
			if(tf1.getText().equals("") || tf2.getText().equals(""))
			{
				p1.setVisible(true);
			}
			else
			{
				if(tf3.getText().equals("") || tf4.getText().equals(""))
				{
					p1.setVisible(true);			
				}
				else
				{
					if(tf5.getText().equals("") || tf6.getText().equals(""))
					{
						p1.setVisible(true);			
					}
					else
					{
						if(tf7.getText().equals("") || tf9.getText().equals("") )
						{
							p1.setVisible(true);
						}
						else
						{
							if(Integer.parseInt(tf7.getText())>32||Integer.parseInt(tf7.getText())<=0)
							{
								p1.setVisible(true);
							}
							else
							{ 
								setStr();
								storeData();
								p.setVisible(true);
							}	
						}
					}
				}
				
			}		
		}
		if(ae.getActionCommand().equals("back"))
		{
			new WelPage();
			setVisible(false);	
		}
		//if(ae.getActionCommand().equals("OK"))
		if(ae.getSource()==btn2)
		{
			new WelPage();
			setVisible(false);
		}
		if(ae.getSource()==btn3)
		{
			p1.setVisible(false);
		}
	}
}
class WelPage extends Frame implements ActionListener
{
	Font s,t,b;
	Button b1,b2,bhist,bhist1;
	Panel p,p0,p1,p2,p3,p4;
	Choice c;
	Label l0,l1,l2,l3;
	public WelPage()
	{
		setTitle("WelPage");
		p=new Panel();
		p.setBounds(0,0,1370,120);
		p.setBackground(Color.blue);
		p.setLayout(null);
		add(p);
		p1=new Panel();
		p1.setBounds(0,0,40,710);
		p1.setBackground(Color.blue);
		add(p1);		
		s=new Font("SERIF",Font.BOLD, 40);
		l1=new Label("CITY STREET Parking");
		p.add(l1);
		l1.setFont(s);
		l1.setBounds(500,50,420,80);
		l1.setForeground(Color.white);
		p2=new Panel();
		p2.setBounds(1325,0,40,710);
		p2.setBackground(Color.blue);
		add(p2);
		p3=new Panel();
		p3.setBounds(0,670,1370,40);
		p3.setBackground(Color.blue);
		add(p3);
		t=new Font("SERIF",Font.BOLD, 30);
		l2=new Label("Choose Vehicle");
		l2.setFont(t);
		l2.setBounds(250,400,200,30);
		add(l2);
		c=new Choice();
		c.add("Two Wheeler");
		c.add("Four Wheeler");
		c.setBounds(500,400,200,50);
		add(c);
		b1=new Button("Check-Slot");
		b1.setBounds(450,500,150,30);
		add(b1);	
		b2=new Button("Go Back");
		b2.setBounds(670,500,150,30);
		add(b2);		
		b1.addActionListener(this);
		b2.addActionListener(this);
		bhist=new Button("Sent Mail");
		bhist.setBounds(40,125,100,30);
		add(bhist);		
		bhist.addActionListener(this);		
		bhist1=new Button("Record History");
		bhist1.setBounds(150,125,150,30);
		add(bhist1);		
		bhist1.addActionListener(this);		
		
		setSize(1370,710);
		setLayout(null);
		setVisible(true);
		addWindowListener(new WindowAdapter()
			{
				public void windowClosing(WindowEvent we)
				{
					System.exit(0);
				}
			});				
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource( )==b1)
		{
			ParSlot ps=new ParSlot( );
			ps.wp=this;
			ps.CheckSlot();
			setVisible(false);
		}
		if(ae.getSource()==b2)
		{	
			new LoginPage();
			setVisible(false);
		}
		if(ae.getSource()==bhist)
		{
			new Test1();
			setVisible(false);
		}
		if(ae.getSource()==bhist1)
		{
			new HistoryPage();
			setVisible(false);
		}
	} 
}
public class LoginPage extends Frame implements ActionListener
{
	Button b1,b2,b3,b4,b5,b6,b7,b8,b9,b10,b11,b12,b13,b14;
	TextField tf1,tf2,tf4,tf6,tf7,tf8,tf9,tf10,tf11,tf12,tf13,tf5,tf14,tf15;
	Label l1,l2,l3,l4,l5,l6,l7,l8,l9,l10,l11,l12,l13,l14,l15,l16,l17,l18,l19,l20,l21,l22;
	Font b,a,font1;
	Panel p2,p3,p5,p7,p1,p4,p6,p8,p9,p10,p11;
	String as1,as2,as3,as4,as5,as6;
	java.util.Date d=new java.util.Date( );	
	
	BufferedImage bi;
	
		Random r=new Random();
		int range=10;
		Integer  n1=new Integer (r.nextInt(range));
		Integer  n2=new Integer (r.nextInt(range));
		Integer  n3=new Integer (r.nextInt(range));
		Integer  n4=new Integer (r.nextInt(range));
		String s1=n1.toString();
		String s2=n2.toString();
		String s3=n3.toString();
		String s4=n4.toString();
		String s5=s1+s2+s3+s4;
		String s6=s3+s1+s2+s4;
		static int flag=1;
	LoginPage()
	{	
		try
		{
			bi=ImageIO.read(new File("C:\\Users\\Dell\\Downloads\\parking6.jpg"));
		}catch(IOException e){ System.out.println(e); };
		
		setTitle("LoginPage");
		setVisible(true);
		setSize(1370,710);	
		setLayout(null);
		
		p1=new Panel();
		p1.setBounds(900,110,400,550);
		p1.setBackground(Color.gray);
		p1.setLayout(null);
		p1.setVisible(false);
		add(p1);
		p6=new Panel();
		p6.setBounds(900,110,400,550);
		p6.setBackground(Color.gray);
		p6.setLayout(null);
		p6.setVisible(false);
		add(p6);
		p4=new Panel();
		p4.setBounds(900,110,400,550);
		p4.setBackground(Color.gray);
		p4.setLayout(null);
		p4.setVisible(false);
		add(p4);
		p2=new Panel();
		p2.setBounds(0,0,40,710);
		p2.setBackground(Color.blue);
		p2.setLayout(null);
		add(p2);
		p3=new Panel();
		p3.setBounds(0,0,1370,100);
		p3.setBackground(Color.blue);
		p3.setLayout(null);
		add(p3);
		
		
		font1=new Font("SERIF",Font.BOLD,23);
		



		l5=new Label("CITY STREET PARKING");
		b=new Font("SERIF",Font.BOLD,40);
		l5.setForeground(Color.white);
		l5.setFont(b);
		l5.setBounds(450,50,480,40);
		p3.add(l5);
		l3=new Label("Verification");
		l3.setForeground(Color.black);
		l3.setFont(b);
		l3.setBounds(90,20,480,40);
		l8=new Label("Account Info");
		l8.setForeground(Color.black);
		l8.setFont(b);
		l8.setBounds(90,20,480,40);		
		l4=new Label("Verification");
		l4.setForeground(Color.black);
		l4.setFont(b);
		l4.setBounds(90,20,480,40);
		p1.add(l3);
		p4.add(l4);
		p6.add(l8);
		p8=new Panel();
		p8.setBounds(20,100,350,250);
		p8.setBackground(Color.blue);
		p8.setLayout(null);
		p8.setVisible(false);
		p6.add(p8);		
		p9=new Panel();
		p9.setBounds(20,100,350,250);
		p9.setBackground(Color.blue);
		p9.setLayout(null);
		p9.setVisible(false);
		p6.add(p9);
		p10=new Panel();
		p10.setBounds(20,100,350,250);
		p10.setBackground(Color.blue);
		p10.setLayout(null);
		p10.setVisible(false);
		p1.add(p10);
		p11=new Panel();
		p11.setBounds(20,100,350,250);
		p11.setBackground(Color.blue);
		p11.setLayout(null);
		p11.setVisible(false);
		p4.add(p11);
		p5=new Panel();
		p5.setBounds(1325,0,40,710);
		p5.setBackground(Color.blue);
		add(p5);
		p7=new Panel();
		p7.setBounds(0,670,1370,40);
		p7.setBackground(Color.blue);
		add(p7);
		a=new Font("SERIF",Font.BOLD, 20);
		l1=new Label("User Name");
		l1.setFont(a);
		l1.setBounds(500,300,110,20);
		add(l1);
		l9=new Label("Old User Name :");
		l9.setForeground(Color.black);
		l9.setFont(a);
		l9.setBounds(20,120,180,20);
		p6.add(l9);
		l15=new Label("Your data did not submit.");				
		l15.setForeground(Color.black);
		l15.setFont(font1);
		l15.setBounds(30,80,290,20);
		p8.add(l15);
		l19=new Label("Enter Correct Gmail id.");				
		l19.setForeground(Color.black);
		l19.setFont(font1);
		l19.setBounds(40,100,290,20);
		p10.add(l19);
		l22=new Label("Enter Correct Information.");				
		l22.setForeground(Color.black);
		l22.setFont(a);
		l22.setBounds(40,50,250,20);
		p11.add(l22);
		l16=new Label("check old Id or old Password.");				
		l16.setForeground(Color.black);
		l16.setFont(font1);
		l16.setBounds(30,120,295,20);
		p8.add(l16);
		l17=new Label("Your data has been submitted.");				
		l17.setForeground(Color.black);
		l17.setFont(font1);
		l17.setBounds(20,100,310,20);
		p9.add(l17);
		tf8=new TextField(35);
		tf8.setBounds(200,120,160,20);
		p6.add(tf8);
		l10=new Label("Old Password :");
		l10.setForeground(Color.black);
		l10.setFont(a);
		l10.setBounds(20,150,180,20);
		p6.add(l10);
		tf9=new TextField(35);
		tf9.setBounds(200,150,160,20);
		p6.add(tf9);
		l11=new Label("New User Name :");
		l11.setForeground(Color.black);
		l11.setFont(a);
		l11.setBounds(20,180,180,20);
		p6.add(l11);
		tf10=new TextField(35);
		tf10.setBounds(200,180,160,20);
		p6.add(tf10);
		l12=new Label("New Password :");
		l12.setForeground(Color.black);
		l12.setFont(a);
		l12.setBounds(20,210,180,20);
		p6.add(l12);	
		tf11=new TextField(35);
		tf11.setBounds(200,210,160,20);
		p6.add(tf11);
		l13=new Label("Old Gmail Id :");
		l13.setForeground(Color.black);
		l13.setFont(a);
		l13.setBounds(20,240,180,20);
		p6.add(l13);
		tf12=new TextField(35);
		tf12.setBounds(200,240,160,20);
		p6.add(tf12);
		l14=new Label("New Gmail Id :");
		l14.setForeground(Color.black);
		l14.setFont(a);
		l14.setBounds(20,270,180,20);
		p6.add(l14);
		tf13=new TextField(35);
		tf13.setBounds(200,270,160,20);
		p6.add(tf13);
		b8=new Button("Submit");
		b8.setBounds(100,330,80,30);
		p6.add(b8);
		b9=new Button("back");
		b9.setBounds(190,330,80,30);
		p6.add(b9);
		b10=new Button("X");
		b10.setBounds(325,5,20,20);
		p8.add(b10);
		b11=new Button("X");
		b11.setBounds(325,5,20,20);
		p9.add(b11);
		b13=new Button("X");
		b13.setBounds(325,5,20,20);
		p10.add(b13);	
		l6=new Label("Enter your email address :");
		l6.setForeground(Color.black);
		l6.setFont(a);
		l6.setBounds(30,170,230,40);
		p1.add(l6);
		l21=new Label("New Password :");
		l21.setForeground(Color.black);
		l21.setFont(a);
		l21.setBounds(30,100,220,40);
		p4.add(l21);
		tf15=new TextField(35);
		tf15.setBounds(30,150,220,20);
		p4.add(tf15);
		l20=new Label("Confirm Password :");
		l20.setForeground(Color.black);
		l20.setFont(a);
		l20.setBounds(30,180,220,40);
		p4.add(l20);
		tf14=new TextField(35);
		tf14.setBounds(30,230,220,20);
		p4.add(tf14);
		l7=new Label("Enter your code :");
		l7.setForeground(Color.black);
		l7.setFont(a);
		l7.setBounds(30,260,220,40);
		p4.add(l7);
		tf6=new TextField(35);
		tf6.setBounds(30,220,220,20);
		p1.add(tf6);	
		tf7=new TextField(35);
		tf7.setBounds(30,310,230,20);
		p4.add(tf7);
		tf1=new TextField(35);
		tf1.setBounds(660,300,230,20);
		add(tf1);
		l2=new Label("Password");
		l2.setBounds(500,350,110,20);
		l2.setFont(a);
		add(l2);
		l18=new Label("Verification Code");
		l18.setFont(a);
		l18.setBounds(500,400,150,20);
		add(l18);
		tf2=new TextField(35);
		tf2.setBounds(660,350,230,20);
		add(tf2);
		tf5=new TextField(35);
		tf5.setBounds(660,400,230,20);
		add(tf5);
		b1=new Button("Login");
		b1.setBounds(800,450,80,30);
		add(b1);
		b12=new Button("Create Verification Code");
		b12.setBounds(600,450,180,30);
		add(b12);
		b2=new Button("Update Admin");
		b2.setBounds(600,500,150,30);		
		add(b2);
		b3=new Button("Forgot Password");
		b3.setBounds(760,500,120,30);		
		add(b3);	
		b4=new Button("Enter");
		b4.setBounds(50,260,50,30);		
		p1.add(b4);		
		b5=new Button("Submit");
		b5.setBounds(50,350,50,30);		
		p4.add(b5);
		b6=new Button("Back");
		b6.setBounds(120,260,50,30);		
		p1.add(b6);	
		b7=new Button("Back");
		b7.setBounds(120,350,50,30);		
		p4.add(b7);
		b14=new Button("X");
		b14.setBounds(325,5,20,20);
		p11.add(b14);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		addWindowListener(new WindowAdapter()
		{
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	if(flag==1)	
	//checkMail();
	flag++;		
	}
	public void paint(Graphics g)
	{
		super.paint(g);
		g.drawImage(bi,0,0,getWidth(),getHeight(),null);
	}
	public void actionPerformed(ActionEvent ae)
	{
		if(ae.getSource()==b1)
		{
			try{
			Connection c;
			ResultSet set;
			Statement st;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			st=c.createStatement();
			set=st.executeQuery("select * from admin where slot=1");
			set.next();
			
			if(tf1.getText().equals(set.getString(2)) && tf2.getText().equals(set.getString(3)))
			{
				if(tf5.getText().equals(s6))
				{
					new WelPage();	
					setVisible(false);
				}
			}
			else
			{
				tf1.setText("Wrong id");
				tf2.setText("Wrong password");
			}
			st.close();
			c.close();
			}catch(Exception e){System.out.println(e);}
			
		}
		if(ae.getSource()==b2)	
		{
			p6.setVisible(true);
		}
		if(ae.getSource()==b3)
		{
			p1.setVisible(true);
		}		
		if(ae.getSource()==b4)
		{	
				
			try{
			Connection c;
			ResultSet set;
			Statement st;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");			
			st=c.createStatement();
			set=st.executeQuery("select * from admin where slot=1");
			set.next();
			System.out.println("preparing to send message ...");
			Properties properties = System.getProperties();
			String message = "Hello , Dear, this message for security check.\n your code is "+s5;
			String subject = "Security Tracing : Confirmation:";
			String to=set.getString(4);
			String from = "hunnyvarshney1999@gmail.com";
			String host="smtp.gmail.com";
			Session session=Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {				
			return new PasswordAuthentication("hunnyvarshney1999@gmail.com", "Hunny@!12");
			}
			});	
			//System.out.println("PROPERTIES "+properties);
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port","465");
			properties.put("mail.smtp.ssl.enable","true");
			properties.put("mail.smtp.auth","true");
			session.setDebug(true);
			MimeMessage m = new MimeMessage(session);	
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);		
			m.setText(message);
			if(tf6.getText().equals(set.getString(4)))
			{
				Transport.send(m);
				p4.setVisible(true);
				p1.setVisible(false);
			}
			else
			{
				p10.setVisible(true);
			}	
	
			System.out.println("Sent success................ to ");
			st.close();
			c.close();
			}catch (Exception e) {
			e.printStackTrace();
			}
			
		}
		if(ae.getSource()==b5)
		{
			if(tf14.getText().equals(tf15.getText()) && tf7.getText().equals(s5))
			{	
			try{
			Connection c;
			ResultSet set;
			PreparedStatement s;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");			
			s=c.prepareStatement("update admin set password=? where slot=1");
			s.setString(1,tf14.getText());
			s.executeUpdate();
			s.close();
			c.close();
			}catch(Exception e){System.out.println(e);}
				new WelPage();	
				setVisible(false);
			}
			else
			{
				p11.setVisible(true);
			}
		}
		if(ae.getSource()==b6)
		{
			p1.setVisible(false);
		}
		if(ae.getSource()==b7)
		{
			p4.setVisible(false);
		}
		if(ae.getSource()==b8)	
		{
			as1=tf8.getText();
			as2=tf9.getText();
			as3=tf10.getText();
			as4=tf11.getText();
			as5=tf12.getText();
			as6=tf13.getText();	
			try{
			Connection c;
			ResultSet set;
			PreparedStatement s;
			Statement st;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.prepareStatement("update admin set user_name=?, password=?, id=? where slot=1");			
			st=c.createStatement();
			set=st.executeQuery("select * from admin where slot=1");
			set.next();
			if(set.getString(4).equals(as5)&&set.getString(3).equals(as2))
			{
			s.setString(1,as3);
			s.setString(2,as4);
			s.setString(3,as6);
			s.executeUpdate();
			p9.setVisible(true);
			}
			else
			{
				p8.setVisible(true);
			}
		s.close();
		c.close();
		}catch(Exception e){System.out.println(e);}
		}
		if(ae.getSource()==b9)	
		{
			p6.setVisible(false);
		}
		if(ae.getSource()==b10)	
		{
			p8.setVisible(false);
		}
		if(ae.getSource()==b11)	
		{
			p6.setVisible(false);
		}
		if(ae.getSource()==b12)	
		{
			try{
			Connection c;
			ResultSet set;
			Statement st;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			st=c.createStatement();
			set=st.executeQuery("select * from admin where slot=1");
			set.next();
			System.out.println("preparing to send message ...");
			String message = "Hello Dear, this message is for Verification Code .\n Your Verification Code is "+s6+" .\nThanks for using our Service ."+"\nFor more information click on www.google.com .";
			String subject = "Security Tracing : Confirmation:";
			String to=set.getString(4);
			String from = "hunnyvarshney1999@gmail.com";
			String host="smtp.gmail.com";
			Properties properties = System.getProperties();
			//System.out.println("PROPERTIES "+properties);
			properties.put("mail.smtp.host", host);
			properties.put("mail.smtp.port","465");
			properties.put("mail.smtp.ssl.enable","true");
			properties.put("mail.smtp.auth","true");
			Session session=Session.getInstance(properties, new Authenticator() {
			protected PasswordAuthentication getPasswordAuthentication() {				
			return new PasswordAuthentication("hunnyvarshney1999@gmail.com", "Hunny@!12");
			}
			});
			session.setDebug(true);
			MimeMessage m = new MimeMessage(session);
			m.setFrom(new InternetAddress(from));
			m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
			m.setSubject(subject);		
			m.setText(message);
			Transport.send(m);
			System.out.println("Sent success...................");
			st.close();
			c.close();
			
			}catch(Exception e){System.out.println(e);}
			System.out.println(" use it "+s6);
		
		}
		if(ae.getSource()==b13)
		{
			p10.setVisible(false);
		}
		if(ae.getSource()==b14)
		{
			p11.setVisible(false);
		}
	}	
	public int timeCheck(int i,int j)
	{
		if (i>j)
		return (i-j);
		if(j>i)
		return (j-i);
		return 0;
	}	
	public void checkMail()
	{
		java.util.Date d=new java.util.Date();
		try{
			Connection c;
			ResultSet set;
			Statement s;
			int result;
			Class.forName("oracle.jdbc.driver.OracleDriver");
			c=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe","Gautam","hunny");
			s=c.createStatement();

			set=s.executeQuery("select * from customer");
			set.next();
			for (int k=0;k<32;k++)
			{
				System.out.println("preparing to send message ...");
				String subject = "Regarding the Vehicle Information";
				String from = "hunnyvarshney1999@gmail.com";
				String host="smtp.gmail.com";
				Properties properties = System.getProperties();
				//System.out.println("PROPERTIES "+properties);
				properties.put("mail.smtp.host", host);
				properties.put("mail.smtp.port","465");
				properties.put("mail.smtp.ssl.enable","true");
				properties.put("mail.smtp.auth","true");
				Session session=Session.getInstance(properties, new Authenticator() {
				protected PasswordAuthentication getPasswordAuthentication() {				
				return new PasswordAuthentication("hunnyvarshney1999@gmail.com", "Hunny@!12");
				}
				});
				session.setDebug(true);
				MimeMessage m = new MimeMessage(session);
				m.setFrom(new InternetAddress(from));
				m.setSubject(subject);					
	
				if(set.getString(13)!=null)
				{
					String message = "Dear "+set.getString(2)+" this message is for remembering you that your vehicle, "+set.getString(6)+" "+set.getString(5)+" is park in our Parking Agency for more than 30 days." + "\nWe just want to remember you that if you do not exit your vehicle the charges may applied continuously." + "\n\n\nThanks for using our services." + "\nFor more information contact the Agency.\nHave a nice day\nTHANK YOU..... \n\nFrom:- City Street Parking";
					m.setText(message);
					String to=set.getString(13);
					m.addRecipient(Message.RecipientType.TO, new InternetAddress(to));
					result=timeCheck(d.getMinutes(),set.getInt(12))/60+ timeCheck(d.getHours(),set.getInt(11))+ timeCheck(d.getDate(),set.getInt(8))*24+ timeCheck((d.getMonth()+1),set.getInt(9))*30*24+ timeCheck((d.getYear()+1900),set.getInt(10))*365*30*24 ;
					if(result >=24*45)
					{	
						Transport.send(m);
						System.out.println("\n\nMail Successfully Sent to "+set.getString(2)+"........");
					}
				}
				set.next();
			}				
			s.close();
			c.close();
			}catch(Exception e){//e.printStackTrace();
				System.out.println(e);}
	}
	public static void main(String[]args)
	{
			new LoginPage();			
	}	
}