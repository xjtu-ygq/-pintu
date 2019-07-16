import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class pintu{
	public static void main(String args[]){
		FWindow fwin = new FWindow();
	}
}

class FWindow extends JFrame implements ActionListener{
	JButton jbsimple,jbmiddle,jbhigh,jbabnormal;	//定义简单，中级、困难、变态四个按钮选择难度
	FWindow(){
		setBounds(500,200,400,600);
		setLayout(null);
		setVisible(true);
		jbsimple = new JButton("简单");
		jbmiddle = new JButton("一般");
		jbhigh = new JButton("困难");
		jbabnormal = new JButton("变态");
		
		jbsimple.setBounds(150,100,100,50);
		jbmiddle.setBounds(150,200,100,50);
		jbhigh.setBounds(150,300,100,50);
		jbabnormal.setBounds(150,400,100,50);
		
		jbsimple.addActionListener(this);
		jbmiddle.addActionListener(this);
		jbhigh.addActionListener(this);
		jbabnormal.addActionListener(this);
		
		
		add(jbsimple);
		add(jbmiddle);
		add(jbhigh);
		add(jbabnormal);
		
		
		
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	public void actionPerformed(ActionEvent e){
		if (e.getSource()==jbsimple){
			SimWindow simwin = new SimWindow();
			dispose();
		}else if(e.getSource()==jbmiddle){
			MidWindow midwin = new MidWindow();
			dispose();
		}else if(e.getSource()==jbhigh){
			HigWindow midwin = new HigWindow();
			dispose();
		}else{
			AbnWindow midwin = new AbnWindow();
			dispose();
		}
	}
}

class MyJButton extends JButton{
	public int xy;
	public int nxy;
	public String picc;
	public ImageIcon iconn;
	
	MyJButton(int i){
		
		xy=i;
		 
	}
	
	public int getxy(){
		return xy;
	}
	public void pic(String iccon){
		iconn = new ImageIcon(iccon);
		setIcon(iconn);
		picc = iccon;
	}
	public void setnxy(int i){
		nxy=i;
		
	}
	public int getnxy(){
		return nxy;
	}
	
	public String reicon(){
		return picc;
	}
}

class SimWindow extends JFrame implements ActionListener{ 
	MyJButton b[];
	JButton bstart,returns;
	Timer time;
	JLabel lab1;
	int numt=1;
	SimWindow(){
		setBounds(500,200,500,650);
		setVisible(true);
		
		time = new Timer(1000,this);
		
		JPanel jpa = new JPanel();
		add(jpa);
		jpa.setBounds(0,0,500,45);
		jpa.setLayout(null);
		lab1 = new JLabel();
		lab1.setHorizontalAlignment(JLabel.CENTER);
		lab1.setFont(new Font("宋体",Font.BOLD,20));
		bstart = new JButton("开始");
		returns = new JButton("返回");
		bstart.setBounds(50,5,100,40);
		returns.setBounds(360,5,100,40);
		lab1.setBounds(210,5,100,40);
		jpa.add(bstart);
		jpa.add(lab1);
		jpa.add(returns);
		
		
		JPanel jpb = new JPanel();
		add(jpb);
		jpb.setBounds(100,45,300,350);
		jpb.setLayout(null);
		b = new MyJButton[9];
		int l=0,t=40;
		for(int i=1;i<=9;i++){
			b[i-1] = new MyJButton(i-1);
			jpb.add(b[i-1]);
			b[i-1].setnxy(i-1);
			b[i-1].pic("sim\\"+String.valueOf(""+i)+".gif");
			b[i-1].setBounds(l,t,100,100);
			b[i-1].addActionListener(this);
			l+=100;
			
			if(i%3==0){
				t+=100;
				l=0;
			}
		}
		begin();
		JPanel jpc = new JPanel();
		add(jpc);
		jpc.setBounds(0,350,500,200);
		jpc.setLayout(null);
		MyJButton yuantu = new MyJButton(33);
		yuantu.pic("sim\\22.gif");
		jpc.add(yuantu);
		yuantu.setBounds(155,395,190,190);
		
		bstart.addActionListener(this);
		returns.addActionListener(this);

		
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	int Upp(int i){
		if(i-3<0) return i;
		else{
			int temp;
			temp = b[i-3].getnxy();
			b[i-3].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-3].reicon();
			b[i-3].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-3;
			}
	}
	
	int Doo(int i){
		if(i+3>8) return i;
		else{
			int temp;
			temp = b[i+3].getnxy();
			b[i+3].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+3].reicon();
			b[i+3].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+3;
			}
	}
	
	int Lee(int i){
		if((i-1)/3 != i/3) return i;
		else{
			int temp;
			temp = b[i-1].getnxy();
			b[i-1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-1].reicon();
			b[i-1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-1;
		}
	}
	
	int Rii(int i){
		if((i+1)/3 != i/3) return i;
		else{
			int temp;
			temp = b[i+1].getnxy();
			b[i+1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+1].reicon();
			b[i+1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+1;
		}
	}
	
	void begin(){
		for(int i=66;i>=0;i--){
			int ri = i%4;
			int rz = (int)(Math.random()*9);
			switch(ri){
				case 0:
					rz=Upp(rz);
				case 1:
					rz=Doo(rz);
				case 2:
					if(rz-1>=0)
						rz=Lee(rz);
				case 3:
					if(rz+1<=8)
						rz=Rii(rz);
			}
		}
	}
	
	boolean isOK(){
		for(int i=0;i<=8;i++){
			if(b[i].getnxy()!=b[i].getxy())
				return false;
		}
		return true;
	}
	
	void End(boolean bl){
		if (bl==true){
			time.stop();
			lab1.setText("成功了!");
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==time){
			lab1.setText(""+numt);
			numt++;
		}else if(e.getSource()==bstart){
			time.start();
		}else if(e.getSource()==returns){
			new FWindow();
			dispose();
		}else{
			MyJButton JTemp = (MyJButton)e.getSource();
			if(JTemp.getxy()-1>=0){
				if(b[JTemp.getxy()-1].getnxy()==8){
					Rii(JTemp.getxy()-1);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()-3>=0){
				if(b[JTemp.getxy()-3].getnxy() == 8){
					Doo(JTemp.getxy()-3);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+3<=8){
				if(b[JTemp.getxy()+3].getnxy() == 8){
					Upp(JTemp.getxy()+3);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+1<=8){
				if(b[JTemp.getxy()+1].getnxy() == 8){
					Lee(JTemp.getxy()+1);
					End(isOK());
					return ;
				}
			}
		}
	}
}



class MidWindow extends JFrame implements ActionListener{ 
	MyJButton b[];
	JButton bstart,returns;
	Timer time;
	JLabel lab1;
	int numt=1;
	MidWindow(){
		setBounds(500,200,650,800);
		setVisible(true);
		
		time = new Timer(1000,this);
		
		JPanel jpa = new JPanel();
		add(jpa);
		jpa.setBounds(0,0,650,45);
		jpa.setLayout(null);
		lab1 = new JLabel();
		lab1.setHorizontalAlignment(JLabel.CENTER);
		lab1.setFont(new Font("宋体",Font.BOLD,20));
		bstart = new JButton("开始");
		returns = new JButton("返回");
		bstart.setBounds(50,5,100,40);
		returns.setBounds(500,5,100,40);
		lab1.setBounds(270,5,100,40);
		jpa.add(bstart);
		jpa.add(lab1);
		jpa.add(returns);
		
		
		JPanel jpb = new JPanel();
		add(jpb);
		jpb.setBounds(125,45,400,450);
		jpb.setLayout(null);
		b = new MyJButton[16];
		int l=0,t=40;
		for(int i=1;i<=16;i++){
			b[i-1] = new MyJButton(i-1);
			jpb.add(b[i-1]);
			b[i-1].setnxy(i-1);
			b[i-1].pic("mid\\"+String.valueOf(""+i)+".gif");
			b[i-1].setBounds(l,t,100,100);
			b[i-1].addActionListener(this);
			l+=100;
			
			if(i%4==0){
				t+=100;
				l=0;
			}
		}
		begin();
		JPanel jpc = new JPanel();
		add(jpc);
		jpc.setBounds(0,350,500,200);
		jpc.setLayout(null);
		MyJButton yuantu = new MyJButton(33);
		yuantu.pic("mid\\22.png");
		jpc.add(yuantu);
		yuantu.setBounds(230,495,190,190);
		
		bstart.addActionListener(this);
		returns.addActionListener(this);

		
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	int Upp(int i){
		if(i-4<0) return i;
		else{
			int temp;
			temp = b[i-4].getnxy();
			b[i-4].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-4].reicon();
			b[i-4].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-4;
			}
	}
	
	int Doo(int i){
		if(i+4>15) return i;
		else{
			int temp;
			temp = b[i+4].getnxy();
			b[i+4].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+4].reicon();
			b[i+4].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+4;
			}
	}
	
	int Lee(int i){
		if((i-1)/4 != i/4) return i;
		else{
			int temp;
			temp = b[i-1].getnxy();
			b[i-1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-1].reicon();
			b[i-1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-1;
		}
	}
	
	int Rii(int i){
		if((i+1)/4 != i/4) return i;
		else{
			int temp;
			temp = b[i+1].getnxy();
			b[i+1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+1].reicon();
			b[i+1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+1;
		}
	}
	
	void begin(){
		for(int i=66;i>=0;i--){
			int ri = i%16;
			int rz = (int)(Math.random()*16);
			switch(ri){
				case 0:
					rz=Upp(rz);
				case 1:
					rz=Doo(rz);
				case 2:
					if(rz-1>=0)
						rz=Lee(rz);
				case 3:
					if(rz+1<=15)
						rz=Rii(rz);
			}
		}
	}
	
	boolean isOK(){
		for(int i=0;i<=15;i++){
			if(b[i].getnxy()!=b[i].getxy())
				return false;
		}
		return true;
	}
	
	void End(boolean bl){
		if (bl==true){
			time.stop();
			lab1.setText("成功了!");
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==time){
			lab1.setText(""+numt);
			numt++;
		}else if(e.getSource()==bstart){
			time.start();
		}else if(e.getSource()==returns){
			new FWindow();
			dispose();
		}else{
			MyJButton JTemp = (MyJButton)e.getSource();
			if(JTemp.getxy()-1>=0){
				if(b[JTemp.getxy()-1].getnxy()==15){
					Rii(JTemp.getxy()-1);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()-4>=0){
				if(b[JTemp.getxy()-4].getnxy() == 15){
					Doo(JTemp.getxy()-4);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+4<=15){
				if(b[JTemp.getxy()+4].getnxy() == 15){
					Upp(JTemp.getxy()+4);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+1<=15){
				if(b[JTemp.getxy()+1].getnxy() == 15){
					Lee(JTemp.getxy()+1);
					End(isOK());
					return ;
				}
			}
		}
	}
}



class HigWindow extends JFrame implements ActionListener{ 
	MyJButton b[];
	JButton bstart,returns;
	Timer time;
	JLabel lab1;
	int numt=1;
	HigWindow(){
		setBounds(500,200,750,900);
		setVisible(true);
		
		time = new Timer(1000,this);
		
		JPanel jpa = new JPanel();
		add(jpa);
		jpa.setBounds(0,0,750,45);
		jpa.setLayout(null);
		lab1 = new JLabel();
		lab1.setHorizontalAlignment(JLabel.CENTER);
		lab1.setFont(new Font("宋体",Font.BOLD,20));
		bstart = new JButton("开始");
		returns = new JButton("返回");
		bstart.setBounds(100,5,100,40);
		returns.setBounds(600,5,100,40);
		lab1.setBounds(320,5,100,40);
		jpa.add(bstart);
		jpa.add(lab1);
		jpa.add(returns);
		
		
		JPanel jpb = new JPanel();
		add(jpb);
		jpb.setBounds(125,45,500,550);
		jpb.setLayout(null);
		b = new MyJButton[25];
		int l=0,t=40;
		for(int i=1;i<=25;i++){
			b[i-1] = new MyJButton(i-1);
			jpb.add(b[i-1]);
			b[i-1].setnxy(i-1);
			b[i-1].pic("hig\\"+String.valueOf(""+i)+".gif");
			b[i-1].setBounds(l,t,100,100);
			b[i-1].addActionListener(this);
			l+=100;
			
			if(i%5==0){
				t+=100;
				l=0;
			}
		}
		begin();
		JPanel jpc = new JPanel();
		add(jpc);
		jpc.setBounds(0,350,500,200);
		jpc.setLayout(null);
		MyJButton yuantu = new MyJButton(33);
		yuantu.pic("hig\\26.png");
		jpc.add(yuantu);
		yuantu.setBounds(270,595,190,190);
		
		bstart.addActionListener(this);
		returns.addActionListener(this);

		
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	int Upp(int i){
		if(i-5<0) return i;
		else{
			int temp;
			temp = b[i-5].getnxy();
			b[i-5].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-5].reicon();
			b[i-5].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-5;
			}
	}
	
	int Doo(int i){
		if(i+5>24) return i;
		else{
			int temp;
			temp = b[i+5].getnxy();
			b[i+5].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+5].reicon();
			b[i+5].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+5;
			}
	}
	
	int Lee(int i){
		if((i-1)/5 != i/5) return i;
		else{
			int temp;
			temp = b[i-1].getnxy();
			b[i-1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-1].reicon();
			b[i-1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-1;
		}
	}
	
	int Rii(int i){
		if((i+1)/5 != i/5) return i;
		else{
			int temp;
			temp = b[i+1].getnxy();
			b[i+1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+1].reicon();
			b[i+1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+1;
		}
	}
	
	void begin(){
		for(int i=100;i>=0;i--){
			int ri = i%25;
			int rz = (int)(Math.random()*25);
			switch(ri){
				case 0:
					rz=Upp(rz);
				case 1:
					rz=Doo(rz);
				case 2:
					if(rz-1>=0)
						rz=Lee(rz);
				case 3:
					if(rz+1<=24)
						rz=Rii(rz);
			}
		}
	}
	
	boolean isOK(){
		for(int i=0;i<=24;i++){
			if(b[i].getnxy()!=b[i].getxy())
				return false;
		}
		return true;
	}
	
	void End(boolean bl){
		if (bl==true){
			time.stop();
			lab1.setText("成功了!");
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==time){
			lab1.setText(""+numt);
			numt++;
		}else if(e.getSource()==bstart){
			time.start();
		}else if(e.getSource()==returns){
			new FWindow();
			dispose();
		}else{
			MyJButton JTemp = (MyJButton)e.getSource();
			if(JTemp.getxy()-1>=0){
				if(b[JTemp.getxy()-1].getnxy()==24){
					Rii(JTemp.getxy()-1);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()-5>=0){
				if(b[JTemp.getxy()-5].getnxy() == 24){
					Doo(JTemp.getxy()-5);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+5<=24){
				if(b[JTemp.getxy()+5].getnxy() == 24){
					Upp(JTemp.getxy()+5);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+1<=24){
				if(b[JTemp.getxy()+1].getnxy() == 24){
					Lee(JTemp.getxy()+1);
					End(isOK());
					return ;
				}
			}
		}
	}
}


class AbnWindow extends JFrame implements ActionListener{ 
	MyJButton b[];
	JButton bstart,returns;
	Timer time;
	JLabel lab1;
	int numt=1;
	AbnWindow(){
		setBounds(250,30,850,1000);
		setVisible(true);
		
		time = new Timer(1000,this);
		
		JPanel jpa = new JPanel();
		add(jpa);
		jpa.setBounds(0,0,850,45);
		jpa.setLayout(null);
		lab1 = new JLabel();
		lab1.setHorizontalAlignment(JLabel.CENTER);
		lab1.setFont(new Font("宋体",Font.BOLD,20));
		bstart = new JButton("开始");
		returns = new JButton("返回");
		bstart.setBounds(150,5,100,40);
		returns.setBounds(650,5,100,40);
		lab1.setBounds(380,5,100,40);
		jpa.add(bstart);
		jpa.add(lab1);
		jpa.add(returns);
		
		
		JPanel jpb = new JPanel();
		add(jpb);
		jpb.setBounds(95,45,660,710);
		jpb.setLayout(null);
		b = new MyJButton[121];
		int l=0,t=40;
		for(int i=1;i<=121;i++){
			b[i-1] = new MyJButton(i-1);
			jpb.add(b[i-1]);
			b[i-1].setnxy(i-1);
			b[i-1].pic("abn\\"+String.valueOf(""+i)+".gif");
			b[i-1].setBounds(l,t,60,60);
			b[i-1].addActionListener(this);
			l+=60;
			
			if(i%11==0){
				t+=60;
				l=0;
			}
		}
		begin();
		JPanel jpc = new JPanel();
		add(jpc);
		jpc.setBounds(0,350,500,200);
		jpc.setLayout(null);
		MyJButton yuantu = new MyJButton(33);
		yuantu.pic("abn\\temple.png");
		jpc.add(yuantu);
		yuantu.setBounds(350,750,190,190);
		
		bstart.addActionListener(this);
		returns.addActionListener(this);

		
		validate();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
	}
	
	int Upp(int i){
		if(i-11<0) return i;
		else{
			int temp;
			temp = b[i-11].getnxy();
			b[i-11].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-11].reicon();
			b[i-11].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-11;
			}
	}
	
	int Doo(int i){
		if(i+11>120) return i;
		else{
			int temp;
			temp = b[i+11].getnxy();
			b[i+11].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+11].reicon();
			b[i+11].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+11;
			}
	}
	
	int Lee(int i){
		if((i-1)/11 != i/11) return i;
		else{
			int temp;
			temp = b[i-1].getnxy();
			b[i-1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i-1].reicon();
			b[i-1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i-1;
		}
	}
	
	int Rii(int i){
		if((i+1)/11 != i/11) return i;
		else{
			int temp;
			temp = b[i+1].getnxy();
			b[i+1].setnxy(b[i].getnxy());
			b[i].setnxy(temp);
			String itemp;
			itemp = b[i+1].reicon();
			b[i+1].pic(b[i].reicon());
			b[i].pic(itemp);
			return i+1;
		}
	}
	
	void begin(){
		for(int i=10000;i>=0;i--){
			int ri = i%121;
			int rz = (int)(Math.random()*121);
			switch(ri){
				case 0:
					rz=Upp(rz);
				case 1:
					rz=Doo(rz);
				case 2:
					if(rz-1>=0)
						rz=Lee(rz);
				case 3:
					if(rz+1<=120)
						rz=Rii(rz);
			}
		}
	}
	
	boolean isOK(){
		for(int i=0;i<=120;i++){
			if(b[i].getnxy()!=b[i].getxy())
				return false;
		}
		return true;
	}
	
	void End(boolean bl){
		if (bl==true){
			time.stop();
			lab1.setText("成功了!");
		}
	}
	
	public void actionPerformed(ActionEvent e){
		if(e.getSource()==time){
			lab1.setText(""+numt);
			numt++;
		}else if(e.getSource()==bstart){
			time.start();
		}else if(e.getSource()==returns){
			new FWindow();
			dispose();
		}else{
			MyJButton JTemp = (MyJButton)e.getSource();
			if(JTemp.getxy()-1>=0){
				if(b[JTemp.getxy()-1].getnxy()==120){
					Rii(JTemp.getxy()-1);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()-11>=0){
				if(b[JTemp.getxy()-11].getnxy() == 120){
					Doo(JTemp.getxy()-11);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+11<=120){
				if(b[JTemp.getxy()+11].getnxy() == 120){
					Upp(JTemp.getxy()+11);
					End(isOK());
					return ;
				}
			}
			if(JTemp.getxy()+1<=120){
				if(b[JTemp.getxy()+1].getnxy() == 120){
					Lee(JTemp.getxy()+1);
					End(isOK());
					return ;
				}
			}
		}
	}
}


























