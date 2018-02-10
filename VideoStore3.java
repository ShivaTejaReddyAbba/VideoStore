import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
class node
{
	String name;
	int id;
	boolean i=true;
	node next=null;
	node prev=null;
	node par=null;
	node(String name,int id,node next,node prev)
	{
		this.id=id;
		this.name=name;
		this.next=next;
		this.prev=prev;
	}
	public node getnext()
	{
		
		return this.next;
	}
	public void setnext(node n) {
		this.next=n;
		
	}
	public int getid() {
		return this.id;
	}
	public void setprev(node prev2) {
		this.prev=prev2;
		
	}
	public node getprev() {
		return this.prev;
		
	}
	public  void setp(node n)
	{
		this.par=n;
	}
	public  node getp()
	{
		return this.par;
	}
	
	
}
class cus
{
	String name;
	int id;
	int vid=-1;
	boolean i=false;
	cus next=null;
	cus prev=null;
	cus par=null;
	cus(String name,int id,cus next,cus prev,int vid)
	{
		this.name=name;
		this.id=id;
		this.next=next;
		this.prev=prev;
		this.vid=vid;
	}
	public  void setp(cus n)
	{
		this.par=n;
	}
	public cus getp()
	{
		return this.par;
	}
	
	public cus getnext()
	{
		
		return this.next;
	}
	public void setnext(cus n) {
		this.next=n;
		
	}
	public int getid() {
		return this.id;
	}
	public void setprev(cus curr) {
		this.prev=curr;
		
	}
	public cus getprev() {
		return this.prev;
	}
}
class SLL
{
	node nhead=null;
	cus chead=null;
	
	public void addvideo(node n)
	{
		if(nhead==null)
		{
			nhead=n;
			System.out.println("Video Added successfull");
		}
		else
		{
			node curr=nhead;
			while(curr.getnext()!=null)
			{
				curr=curr.getnext();
			}
			curr.setnext(n);
			System.out.println("Video added successfully");
		}
		
	}

	public void delvid(int i) 
	{
		node curr=nhead;
		if(curr.getid()==i)
		{
			nhead=curr.getnext();
		}
		else{
			node prev=curr;
		while(curr!=null)
			{
				int id=curr.getid();
				if(id==i)
				{
					prev.setnext(curr.getnext());
				}
				prev=curr;
				curr=curr.getnext();
			}
		}
		
	}

	public void addcus(cus n) {
		if(chead==null)
		{
			chead=n;
			System.out.println("Customer Added successfull");
		}
		else
		{
			cus curr=chead;
			while(curr.getnext()!=null)
			{
				curr=curr.getnext();
			}
			curr.setnext(n);
			System.out.println("Customer added successfully");
		}
		
	}

	public void delcus(int i) {
		cus curr=chead;
		if(curr.getid()==i)
		{
			chead=curr.getnext();
		}
		else{
			cus prev=curr;
		while(curr!=null)
			{
				int id=curr.getid();
				if(id==i)
				{
					prev.setnext(curr.getnext());
				}
				prev=curr;
				curr=curr.getnext();
			}
		}
	}

	public void checkvid(int id) 
	{
		node curr=nhead;
		int temp=0;
		while(curr!=null)
		{
			if(curr.getid()==id)
			{
				System.out.println("Video available");
				temp=1;
				break;
			}
			curr=curr.getnext();
			
		}
		if(temp==0)
		{
			System.out.println("Video not available");
		}
		
	}

	public void checkoutvid(int id,int i) 
	{
		int temp=0,temp1=0;
		cus curr=chead;
		node cur1=nhead;
		while(curr!=null)
		{
			if(curr.getid()==i)
			{
				curr.vid=id;
				temp=1;
				break;
			}
			curr=curr.getnext();
		}
		while(cur1!=null)
		{
			if(cur1.getid()==i)
			{
				cur1.i=false;
				temp1=1;
				break;
			}
			cur1=cur1.getnext();
		}
		if(temp1==0||temp==0)
		{
			System.out.println("Please check the entered video id or customer id");
		}
		else
		{
			System.out.println("Video Checked out successfully");
		}
	}

	public void chckinvid(int id) 
	{
		node curr=nhead;
		int temp=0;
		while(curr!=null)
		{
			if(curr.getid()==id)
			{
				if(curr.i==false)
				{
				temp=1;
				System.out.println("Video successfully checked in");
				curr.i=true;
				}
				else
				{
					System.out.println("Video successfully checked in");
				}
					
				break;
			}
			curr=curr.getnext();
			
		}
		if(temp==0)
		{
			System.out.println("please enter the correct id to check in the video");
		}
		
		
	}

	public void allcus() 
	{
		int temp=0;
		cus curr=chead;
		while(curr!=null)
		{
			System.out.println(curr.name+"\t"+curr.id);
			temp=1;
			curr=curr.getnext();
		}
		if(temp==0)
		{
			System.out.println("No customer to print");
		}
		
	}

	public void allvid() {
		int temp=0;
		node curr=nhead;
		while(curr!=null)
		{
			System.out.println(curr.name+"\t"+curr.id);
			temp=1;
			curr=curr.getnext();
		}
		if(temp==0)
		{
			System.out.println("No videos to print");
		}
		
	}

	public void instvid() {
		int temp=0;
		node curr=nhead;
		while(curr!=null)
		{
			if(curr.i==true)
			{
			System.out.println(curr.name+"\t"+curr.id);
			temp=1;
			}
			curr=curr.getnext();
		}
		if(temp==0)
		{
			System.out.println("There are no videos in the store");
		}
		
	}

	public void rentvid() {
		int temp=0;
		node curr=nhead;
		while(curr!=null)
		{
			if(curr.i==false)
			{
			System.out.println(curr.name+"\t"+curr.id);
			temp=1;
			}
			curr=curr.getnext();
		}
		if(temp==0)
		{
			System.out.println("There are no rented videos in the store");
		}
	}

	public void vidrent(int id) {
		cus curr=chead;
		node curr1=nhead;
		int temp=0;
		while(curr!=null)
		{
			if(curr.id==id)
			{
				int id1=curr.vid;
				while(curr1!=null)
				{
					if(curr1.id==id1)
					{
						System.out.println("The video reneted by customer is: "+curr1.name);
						temp=1;
						break;
					}
					curr1=curr1.getnext();
				}
			}
			curr=curr.getnext();
		}
		if(temp==0)		
		{
			System.out.println("Please check the information entered ");
		}
	}
	
	

}
class DLL{

	node nhead=null;
	cus chead=null;
	
	public void addvideo(node n)
	{
		if(nhead==null)
		{
			nhead=n;
			System.out.println("Video Added successfull");
		}
		else
		{
			node curr=nhead;
			
			while(curr.getnext()!=null)
			{
				curr=curr.getnext();
				
			}
			curr.setnext(n);
			n.setprev(curr);
			System.out.println("Video added successfully");
		}
		
	}

	public void delvid(int id) {
		node curr=nhead;
		if(curr.getid()==id)
		{
			nhead=curr.getnext();
			nhead.setprev(null);
		}
		else{
			node prev=nhead;
		while(curr!=null)
			{
				int i=curr.getid();
				node temp=curr.getnext();;
				if(id==i)
				{
					if(temp!=null)
					{
					prev.setnext(temp);
					temp.setprev(prev);
					}
					if(temp==null)
					{
						prev.setnext(null);
					}
				}
				prev=curr;
				curr=curr.getnext();
				temp=curr.getnext();
			}
		}
		
	}
	public void delcus(int id) {
		cus curr=chead;
		if(curr.getid()==id)
		{
			chead=curr.getnext();
			chead.setprev(null);
		}
		else{
			cus prev=chead;
		while(curr!=null)
			{
				int i=curr.getid();
				cus temp=curr.getnext();
				if(id==i)
				{ 
					if(temp!=null)
					{
					prev.setnext(temp);
					temp.setprev(prev);
					}
					if(temp==null)
					{
						prev.setnext(null);
					}
				}
				prev=curr;
				curr=curr.getnext();
				temp=curr.getnext();
			}
		}	
	}


	public void addcus(cus n1) {
		if(chead==null)
		{
			chead=n1;
			System.out.println("Customer Added successfull");
		}
		else
		{
			cus curr=chead;
			while(curr.getnext()!=null)
			{
				curr=curr.getnext();
			}
			curr.setnext(n1);
			n1.setprev(curr);
			System.out.println("Customer added successfully");
		}
		
	}


	public void checkvid(int id) {
		node curr=nhead;
		int temp=0;
		while(curr!=null)
		{
			if(curr.getid()==id)
			{
				System.out.println("Video available");
				temp=1;
				break;
			}
			curr=curr.getnext();
			
		}
		if(temp==0)
		{
			System.out.println("Video not available");
		}
		
	}

	public void allcus() {

		int temp=0;
		cus curr=chead;
		while(curr!=null)
		{
			System.out.println(curr.name+"\t"+curr.id);
			temp=1;
			curr=curr.getnext();
		}
		if(temp==0)
		{
			System.out.println("No customer to print");
		}
		
	}

	public void checkoutvid(int id, int id2) {
		

		int temp=0,temp1=0;
		cus curr=chead;
		node cur1=nhead;
		while(curr!=null)
		{
			if(curr.getid()==id2)
			{
				curr.vid=id;
				temp=1;
				break;
			}
			curr=curr.getnext();
		}
		while(cur1!=null)
		{
			if(cur1.getid()==id)
			{
				cur1.i=false;
				temp1=1;
				break;
			}
			cur1=cur1.getnext();
		}
		if(temp1==0||temp==0)
		{
			System.out.println("Please check the entered video id or customer id");
		}
		else
		{
			System.out.println("Video Checked out successfully");
		}		
	}

	public void allvid() {
		int temp=0;
		node curr=nhead;
		while(curr!=null)
		{
			System.out.println(curr.name+"\t"+curr.id);
			temp=1;
			curr=curr.getnext();
		}
		if(temp==0)
		{
			System.out.println("No videos to print");
		}
		
	}

	public void instvid() {
		int temp=0;
		node curr=nhead;
		while(curr!=null)
		{
			if(curr.i==true)
			{
			System.out.println(curr.name+"\t"+curr.id);
			temp=1;
			}
			curr=curr.getnext();
		}
		if(temp==0)
		{
			System.out.println("There are no videos in the store");
		}
		
	}

	public void rentvid() {
		int temp=0;
		node curr=nhead;
		while(curr!=null)
		{
			if(curr.i==false)
			{
			System.out.println(curr.name+"\t"+curr.id);
			temp=1;
			}
			curr=curr.getnext();
		}
		if(temp==0)
		{
			System.out.println("There are no rented videos in the store");
		}
		
	}

	public void vidrent(int id) {
		cus curr=chead;
		node curr1=nhead;
		int temp=0;
		while(curr!=null)
		{
			if(curr.id==id)
			{
				int id1=curr.vid;
				while(curr1!=null)
				{
					if(curr1.id==id1)
					{
						System.out.println("The video reneted by customer is: "+curr1.name);
						temp=1;
						break;
					}
					curr1=curr1.getnext();
				}
			}
			curr=curr.getnext();
		}
		if(temp==0)		
		{
			System.out.println("Please check the information entered ");
		}
		
	}

	public void checkinvid(int id) {
		node curr=nhead;
		int temp=0;
		while(curr!=null)
		{
			if(curr.getid()==id)
			{
				if(curr.i==false)
				{
				temp=1;
				System.out.println("Video successfully checked in");
				curr.i=true;
				}
				else
				{
					System.out.println("Video successfully checked in");
				}
					
				break;
			}
			curr=curr.getnext();
			
		}
		if(temp==0)
		{
			System.out.println("please enter the correct id to check in the video");
		}
		
	}
}
class BST
{
	node nhead=null;
	cus chead=null;

	public void addvideo(node n){ 
	  
		if(nhead==null)
	   {
		   nhead=n;
	   }
	   else
	   {
		   node curr=nhead;
		   node temp=null;
		   while(curr!=null)
		   {
			   temp=curr;
			   if(curr.id<n.id)
			   {
				   curr=curr.next;
				   if(curr==null)
				   {
					   temp.next=n;
					   return ;
				   }
				   
				   
			   }
			   else
			   {
				   curr=curr.prev;
				   if(curr==null)
				   {
					   temp.prev=n;
					   return;
				   }
				   
			   }
		   }
		   
	   }		
	}
	public void addcus(cus n) {
		if(chead==null)
		   {
			   chead=n;
		   }
		   else
		   {
			   cus curr=chead;
			   cus temp=null;
			   while(curr!=null)
			   {
				   temp=curr;
				   if(curr.id<n.id)
				   {
					   curr=curr.next;
					   if(curr==null)
					   {
						   temp.next=n;
						   return ;
					   }
					   
					   
				   }
				   else
				   {
					   curr=curr.prev;
					   if(curr==null)
					   {
						   temp.prev=n;
						   return;
					   }
					   
				   }
			   }
			   
		   }
	}
	public void delvid(int id) 
	{
		node curr=nhead;
		node par=nhead;
		while(curr!=null)
		{
			if(curr.id==id)
			{   
				node rhead=curr.next;
				node lhead=curr.prev;
				node temp=curr;
				if((rhead!=null && lhead!=null) || (rhead!=null & lhead==null ))
				{
					while(rhead.prev!=null)
					{
						temp=rhead;
						rhead=rhead.prev;
					}
					curr.id=rhead.id;
					System.out.println(curr.id);
					if(rhead.next!=null)
					{
						if(temp.id>rhead.id)
						{
							temp.prev=rhead.next;
						}
						else
						{
							temp.next=rhead.next;
						}
					}
					else
					{
						if(temp.id>rhead.id)
						{
							temp.prev=null;
						}
						else
						{
							temp.next=null;
						}
					}
					break;
				}
				else if(rhead==null & lhead!=null)
				{
					lhead=curr.prev;
					temp=lhead;
					while(lhead.next!=null)
					{
						lhead=lhead.next;
					}
					curr.id=lhead.id;
					if(par.id<temp.id)
						par.next=curr.prev;
					else
						par.prev=curr.prev;
					
					break;	
				}
				else if(rhead==null &lhead==null)
				{
					if(par.id>curr.id)
						par.prev=null;
					else
						par.next=null;
				}
				break;
			}
				else if(curr.id<id)
				{
					par=curr;
					curr=curr.next;
				}
				else
				{
					par=curr;
					curr=curr.prev;
				}
			}
			
		}

	public void delcus(int id) {

		cus curr=chead;
		cus par=chead;
		while(curr!=null)
		{
			if(curr.id==id)
			{   
				cus rhead=curr.next;
				cus lhead=curr.prev;
				cus temp=curr;
				if((rhead!=null && lhead!=null) || (rhead!=null & lhead==null ))
				{
					while(rhead.prev!=null)
					{
						temp=rhead;
						rhead=rhead.prev;
					}
					curr.id=rhead.id;
					System.out.println(curr.id);
					if(rhead.next!=null)
					{
						if(temp.id>rhead.id)
						{
							temp.prev=rhead.next;
						}
						else
						{
							temp.next=rhead.next;
						}
					}
					else
					{
						if(temp.id>rhead.id)
						{
							temp.prev=null;
						}
						else
						{
							temp.next=null;
						}
					}
					break;
				}
				else if(rhead==null & lhead!=null)
				{
					lhead=curr.prev;
					temp=lhead;
					while(lhead.next!=null)
					{
						lhead=lhead.next;
					}
					curr.id=lhead.id;
					if(par.id<temp.id)
						par.next=curr.prev;
					else
						par.prev=curr.prev;
					
					break;	
				}
				else if(rhead==null &lhead==null)
				{
					if(par.id>curr.id)
						par.prev=null;
					else
						par.next=null;
				}
				break;
			}
				else if(curr.id<id)
				{
					par=curr;
					curr=curr.next;
				}
				else
				{
					par=curr;
					curr=curr.prev;
				}
			}
			
	}

	public void checkvid(int id) 
	{
		int temp=0;
		node curr=nhead;
		while(curr!=null)
		{
			if(curr.id==id)
			{
				temp=1;
				break;
			}
			else if(curr.id>id)
			{
				curr=curr.prev;				
			}
			else if(curr.id<id)
			{
				curr=curr.next;
			}
		}
		if(temp==1)
		{
			System.out.println("Video Found");
		}
		else
			System.out.println("video not Found");
		
	}

	public void checkoutvid(int vid, int id2) 
	{
		node curr=nhead;
		while(curr!=null)
		{
			if(curr.id==vid)
			{
				cus curr1=chead;
				while(curr1!=null)
				{
					if(curr1.id==id2)
					{
						if(curr.i==true )
						{
							curr.i=false;
							curr1.vid=vid;
							System.out.println("The Video successfully rented");
						}
						else
						{
							System.out.println("Video already rented to other customer");
						}
						break;
					}
					else if(curr1.id>id2)
					{
						curr1=curr1.prev;
						
					}
					else if(curr1.id<id2)
					{
						curr1=curr1.next;
					}
				}
				if(curr1==null)
				{
					System.out.println("No customer available with given id");
					break;
				}
				break;
			}
			else if(curr.id>vid)
			{
				curr=curr.prev;
			}
			else if(curr.id<vid)
			{
				curr=curr.next;
			}
		}
		if(curr==null)
		{
			System.out.println("No video available with given id");
		}
		
	}

	public void chckinvid(int vid,int id) 
	{
	  node curr=nhead;
	  cus  curr1=chead;
	  int temp=0;
	  while(curr!=null)
	  {
		  if(curr.id==vid)
		  {
			  
			   while(curr1!=null)
			   {
				   if(curr1.id==id)
				   {
					   if(curr1.vid==vid && curr.i==false)
					   {
						   curr1.vid=-1;
						   curr.i=true;
						   temp=1;
					   }
				   }
				   else if(curr1.id>id)
				   {
					   curr1=curr1.prev;
				   }
				   else if(curr.id<id)
				   {
					   curr1=curr1.next;
				   }
			   }
		  }
		  else if(curr.id>vid)
		  {
			  curr=curr.prev;
		  }
		  else if(curr.id<vid)
		  {
			  curr=curr.next;
		  }
	  }
	  if(temp==1)
	  {
		  System.out.println("video Successfully checked in");
	  }
	  else if(temp==0)
	  {
		  System.out.println("Details entered are not correct");
	  }
	  
		
	}

	public void allcus() 
	{
		cus curr=chead;
		if(curr==null)
		{
			System.out.println("No customers to print");
		}
		else
		{
			System.out.println(curr.id+"\t "+curr.name);
			cus lhead=curr.prev;
			cus rhead=curr.next;
			if(lhead!=null)
			{
				System.out.println(lhead.id+"\t"+lhead.name);
			}
			if(rhead!=null)
			{
				System.out.println(rhead.id+"\t"+rhead.name);
			}
			if(lhead!=null)
			{
				curr=lhead;
				print(curr);
			}
			if(rhead!=null)
			{
				curr=rhead;
				print(curr);
			}
			
		}
		
	}

	public void print(cus curr) {
		
		cus lhead=curr.prev;
		cus rhead=curr.next;
		if(lhead!=null)
		{
			System.out.println(lhead.id+"\t"+lhead.name);
		}
		if(rhead!=null)
		{
			System.out.println(rhead.id+"\t"+rhead.name);
		}
		if(lhead!=null)
		{
			print(lhead);
		}
		if(rhead!=null)
		{
			print(rhead);
		}
	}

	public void allvid() {
		node curr=nhead;
		if(curr==null)
		{
			System.out.println("No Videos to print");
		}
		else
		{
			System.out.println(curr.id+"\t "+curr.name);
			node lhead=curr.prev;
			node rhead=curr.next;
			if(lhead!=null)
			{
				System.out.println(lhead.id+"\t"+lhead.name);
			}
			if(rhead!=null)
			{
				System.out.println(rhead.id+"\t"+rhead.name);
			}
			if(lhead!=null)
			{
				curr=lhead;
				print1(curr);
			}
			if(rhead!=null)
			{
				curr=rhead;
				print1(curr);
			}
		}
		
	}

	public void print1(node curr) {
		node lhead=curr.prev;
		node rhead=curr.next;
		if(lhead!=null)
		{
			System.out.println(lhead.id+"\t"+lhead.name);
		}
		if(rhead!=null)
		{
			System.out.println(rhead.id+"\t"+rhead.name);
		}
		if(lhead!=null)
		{
			print1(lhead);
		}
		if(rhead!=null)
		{
			print1(rhead);
		}
		
	}

	public void instvid() 
	{
		node curr=nhead;
		if(curr==null)
		{
			System.out.println("No Videos to print");
		}
		else
		{
			if(curr.i==true){
			System.out.println(curr.id+"\t "+curr.name);}
			node lhead=curr.prev;
			node rhead=curr.next;
			if(lhead!=null)
			{
				if(lhead.i==true){
				System.out.println(lhead.id+"\t"+lhead.name);}
			}
			if(rhead!=null)
			{
				if(rhead.i==true){
				System.out.println(rhead.id+"\t"+rhead.name);}
			}
			if(lhead!=null)
			{
				curr=lhead;
				printiv(curr,true);
			}
			if(rhead!=null)
			{
				curr=rhead;
				printiv(curr,true);
			}
		}
		
	}

	private void printiv(node curr,boolean t) {
		node lhead=curr.prev;
		node rhead=curr.next;
		if(lhead!=null)
		{
			if(lhead.i==t){
			System.out.println(lhead.id+"\t"+lhead.name);}
		}
		if(rhead!=null)
		{
			if(rhead.i==t){
			System.out.println(rhead.id+"\t"+rhead.name);}
		}
		if(lhead!=null)
		{
			printiv(lhead,t);
		}
		if(rhead!=null)
		{
			printiv(rhead,t);
		}
		
	}

	public void rentvid() {
		node curr=nhead;
		if(curr==null)
		{
			System.out.println("No Videos to print");
		}
		else
		{
			System.out.println(curr.id+"\t "+curr.name);
			node lhead=curr.prev;
			node rhead=curr.next;
			if(lhead!=null)
			{
				if(lhead.i==false){
				System.out.println(lhead.id+"\t"+lhead.name);}
			}
			if(rhead!=null)
			{
				if(rhead.i==false){
				System.out.println(rhead.id+"\t"+rhead.name);}
			}
			if(lhead!=null)
			{
				curr=lhead;
				printiv(curr,false);
			}
			if(rhead!=null)
			{
				curr=rhead;
				printiv(curr,false);
			}
		}
		
	}

	public void vidrent(int cid) 
	{
		int temp=0;
		cus curr=chead;
		node curr1=nhead;
		while(curr!=null)
		{
			if(curr.id==cid)
			{
				while(curr1!=null)
				{
					if(curr1.id==curr.vid)
					{
						System.out.println("Video rented by customer is "+curr1.name+"\t"+curr1.id);
						temp=1;
					}
					else if(curr1.id<curr.vid)
					{
						curr1=curr1.next;
					}
					else if(curr1.id>curr.vid)
					{
						curr1=curr1.prev;
					}
				}
				
			}
			else if(curr.id>cid)
			{
				curr=curr.prev;
			}
			else if(curr.id<cid)
			{
				curr=curr.next;
			}
			
		}
		if(temp==0)
		{
			System.out.println("Please check the entered details");
		}		
	}
	
}
class AVL
{
	node nhead=null;
	cus chead=null;

	public void addvideo(node n) {
		node par=null;
		if(nhead==null)
		   {
			   nhead=n;
		   }
		   else
		   {
			   node curr=nhead;
			   node temp=null;
			   while(curr!=null)
			   {
				   temp=curr;
				   if(curr.id<n.id)
				   {
					   par=curr;
					   curr=curr.next;
					   if(curr==null)
					   {
						   temp.next=n;
						   n.setp(par);
						   return ;
					   }
					   
					   
				   }
				   else
				   {
					   par=curr;
					   curr=curr.prev;
					   if(curr==null)
					   {
						   temp.prev=n;
						   n.setp(par);
						   return;
					   }
					   
				   }
				   
			   }
			   balance(n);
		   }		
		
	}

	 void balance(node n)
	 {
		node gpar=nhead;
		node par=nhead;
		node curr=nhead;
		
		while(curr!=null)
		{
			if(curr.id==n.id)
			{
				if(gpar!=par)
				{
					if(gpar.next==par && par.next==curr && gpar.prev ==null)
					{
						node temp=gpar.getp();
						if(temp!=null)
						{
							if(temp.next.id==gpar.id)
								temp.setnext(par);
							else
								temp.setprev(par);	
						}
						if(gpar.id!=nhead.id)
						{
							gpar.setp(par);
							gpar.setnext(null);
							par.setp(temp);
							par.setprev(gpar);
							break;
						}
						else
						{
							node temp1=nhead;
							par.setprev(nhead);
							nhead.setnext(null);
							nhead.setp(par);
							nhead=par;
						}
					}
					else if(gpar.prev==par && par.prev==curr && gpar.next==null)
					{
						node temp=gpar.getp();
						if(temp !=null)
						{
							if(temp.next.id==gpar.id)
								temp.setnext(par);
							else
								temp.setprev(par);			
						}
						if(gpar.id!=nhead.id)
						{
							gpar.setp(par);
							gpar.setprev(null);
							par.setp(temp);
							par.setnext(gpar);
							break;
						}
						else
						{
							node temp1=nhead;
							par.setnext(nhead);
							nhead.setprev(null);
							nhead.setp(par);
							nhead=par;
							break;
						}
					}
					else if(gpar.next==par && par.prev==curr && gpar.prev==null)
					{
						node tempgp=gpar.getp();
						
						if(tempgp != null)
						{
							if(tempgp.next.id==gpar.id)
								tempgp.setnext(curr);
							else
								tempgp.setprev(curr);
						}
							
						if(gpar.id !=nhead.id)
						{
						gpar.setp(curr);
						gpar.setnext(null);
						par.setp(curr);
						curr.setnext(par);
						curr.setprev(gpar);
						par.setprev(null);
						curr.setp(tempgp);
						break;
						}
						
						else
						{
							node temp=nhead;
							par.setprev(null);
							nhead.setnext(null);
							curr.setprev(gpar);
							curr.setnext(par);
							curr.setp(null);
							gpar.setp(curr);
							par.setp(curr);
							nhead=curr;
						}
						
					}
					else if(gpar.prev==par && par.next==curr && gpar.next==null)
					{						
						node tempgp=gpar.getp();
						
						
						if(tempgp != null)
						{
							if(tempgp.next.id==gpar.id)
								tempgp.setnext(curr);
							else
								tempgp.setprev(curr);
						}
							
						if(gpar.id!=nhead.id)
						{
						gpar.setp(curr);
						gpar.setprev(null);
						par.setp(curr);
						curr.setnext(gpar);
						curr.setprev(par);
						par.setnext(null);
						curr.setp(tempgp);
						break;
						}
						
						else
						{
							node temp=nhead;
							par.setnext(null);
							nhead.setprev(null);
							curr.setprev(par);
							curr.setnext(gpar);
							par.setp(curr);
							gpar.setp(curr);
							nhead=curr;
						}
					
					}
				}
				break;
			}
			else if(curr.id>n.id)
			{
				
				gpar=par;
				par=curr;
				curr=curr.prev;
			}
			else if(curr.id<n.id)
			{
				
				gpar=par;
				par=curr;
				curr=curr.next;
			}
		}
		
		
	}

	 void delvid(int id)
		{
			node curr=nhead;
			node par=nhead;
			
			while(curr !=null)
			{
						
					
					if(curr.id==id)
					{	
						
						node rhead=curr.next;
						node lhead=curr.prev;
						
						
						node temp=curr;
						//node rem_parent=curr;
						
						if( (rhead !=null && lhead !=null) || (rhead !=null & lhead ==null))
						{
							
								while(rhead.prev != null)
								{
									//rem_parent=rhead;
									temp=rhead;
									rhead=rhead.prev;
								}
								
								curr.id=rhead.id;
															
								
								if(rhead.next != null)
								{
									if(temp.id>rhead.id)
									temp.prev=rhead.next;
								
									else
									temp.next=rhead.next;
								}
								
								else
								{
								
									if(temp.id>rhead.id)
										temp.prev=null;

									else								
										temp.next=null;
								}
								
						System.out.println("Video successfully removed from store !!!");
						break;
						}
						
						
						else if(rhead ==null & lhead !=null)
						{
							lhead=curr.prev;
							temp=lhead;
								while(lhead.next !=null)
								{
									
									lhead=lhead.next;
								}
								
								curr.id=lhead.id;
								if(par.id<temp.id)
									par.next=curr.prev;
								else
									par.prev=curr.prev;
								
						System.out.println("Video successfully removed from store !!!");
						break;		
						}
						else if(rhead ==null & lhead ==null)
						{
							if(par.id > curr.id)
								par.prev=null;
							else
								par.next=null;
							
						}
						System.out.println("Video successfully removed from store !!!");
						break;
						
					}
					else if(curr.id<id){
					
						par =curr;
						curr=curr.next;
					
					}
					
					else
					{
						par=curr;
						curr=curr.prev;			
					}
			}
			
			if(curr==null)
			System.out.println("There is no video with the given details !!!");
		}
		
	 void balance1(cus n)
	 {
		cus gpar=chead;
		cus par=chead;
		cus curr=chead;
		
		while(curr!=null)
		{
			if(curr.id==n.id)
			{
				if(gpar!=par)
				{
					if(gpar.next==par && par.next==curr && gpar.prev ==null)
					{
						cus temp=gpar.getp();
						if(temp!=null)
						{
							if(temp.next.id==gpar.id)
								temp.setnext(par);
							else
								temp.setprev(par);	
						}
						if(gpar.id!=nhead.id)
						{
							gpar.setp(par);
							gpar.setnext(null);
							par.setp(temp);
							par.setprev(gpar);
							break;
						}
						else
						{
							cus temp1=chead;
							par.setprev(chead);
							chead.setnext(null);
							chead.setp(par);
							chead=par;
						}
					}
					else if(gpar.prev==par && par.prev==curr && gpar.next==null)
					{
						cus temp=gpar.getp();
						if(temp !=null)
						{
							if(temp.next.id==gpar.id)
								temp.setnext(par);
							else
								temp.setprev(par);			
						}
						if(gpar.id!=nhead.id)
						{
							gpar.setp(par);
							gpar.setprev(null);
							par.setp(temp);
							par.setnext(gpar);
							break;
						}
						else
						{
							cus temp1=chead;
							par.setnext(chead);
							chead.setprev(null);
							chead.setp(par);
							chead=par;
							break;
						}
					}
					else if(gpar.next==par && par.prev==curr && gpar.prev==null)
					{
						cus tempgp=gpar.getp();
						
						if(tempgp != null)
						{
							if(tempgp.next.id==gpar.id)
								tempgp.setnext(curr);
							else
								tempgp.setprev(curr);
						}
							
						if(gpar.id !=nhead.id)
						{
						gpar.setp(curr);
						gpar.setnext(null);
						par.setp(curr);
						curr.setnext(par);
						curr.setprev(gpar);
						par.setprev(null);
						curr.setp(tempgp);
						break;
						}
						
						else
						{
							cus temp=chead;
							par.setprev(null);
							chead.setnext(null);
							curr.setprev(gpar);
							curr.setnext(par);
							curr.setp(null);
							gpar.setp(curr);
							par.setp(curr);
							chead=curr;
						}
						
					}
					else if(gpar.prev==par && par.next==curr && gpar.next==null)
					{						
						cus tempgp=gpar.getp();
						
						
						if(tempgp != null)
						{
							if(tempgp.next.id==gpar.id)
								tempgp.setnext(curr);
							else
								tempgp.setprev(curr);
						}
							
						if(gpar.id!=nhead.id)
						{
						gpar.setp(curr);
						gpar.setprev(null);
						par.setp(curr);
						curr.setnext(gpar);
						curr.setprev(par);
						par.setnext(null);
						curr.setp(tempgp);
						break;
						}
						
						else
						{
							cus temp=chead;
							par.setnext(null);
							chead.setprev(null);
							curr.setprev(par);
							curr.setnext(gpar);
							par.setp(curr);
							gpar.setp(curr);
							chead=curr;
						}
					
					}
				}
				break;
			}
			else if(curr.id>n.id)
			{
				
				gpar=par;
				par=curr;
				curr=curr.prev;
			}
			else if(curr.id<n.id)
			{
				
				gpar=par;
				par=curr;
				curr=curr.next;
			}
		}
		
		
	}

	public void addcus(cus n) {
		cus par=null;
		if(chead==null)
		   {
			   chead=n;
		   }
		   else
		   {
			   cus curr=chead;
			   cus temp=null;
			   while(curr!=null)
			   {
				   temp=curr;
				   if(curr.id<n.id)
				   {
					   par=curr;
					   curr=curr.next;
					   if(curr==null)
					   {
						   temp.next=n;
						   n.setp(par);
						   return ;
					   }
					   
					   
				   }
				   else
				   {
					   par=curr;
					   curr=curr.prev;
					   if(curr==null)
					   {
						   temp.prev=n;
						   n.setp(par);
						   return;
					   }
					   
				   }
			   }
			   balance1(n);
			   
		   }
		
	}

	public void delcus(int id) {
		cus curr=chead;
		cus par=chead;
		
		while(curr !=null)
		{
					
				
				if(curr.id==id)
				{	
					
					cus rhead=curr.next;
					cus lhead=curr.prev;
					cus temp=curr;
					if( (rhead !=null && lhead !=null) || (rhead !=null & lhead ==null))
					{
						
							while(rhead.prev != null)
							{
								
								temp=rhead;
								rhead=rhead.prev;
							}
							
							curr.id=rhead.id;
														
							
							if(rhead.next != null)
							{
								if(temp.id>rhead.id)
								temp.prev=rhead.next;
							
								else
								temp.next=rhead.next;
							}
							
							else
							{
							
								if(temp.id>rhead.id)
									temp.prev=null;

								else								
									temp.next=null;
							}
							
					System.out.println("Video successfully removed from store !!!");
					break;
					}
					
					
					else if(rhead ==null & lhead !=null)
					{
						lhead=curr.prev;
						temp=lhead;
							while(lhead.next !=null)
							{
								
								lhead=lhead.next;
							}
							
							curr.id=lhead.id;
							if(par.id<temp.id)
								par.next=curr.prev;
							else
								par.prev=curr.prev;
							
					System.out.println("Video successfully removed from store !!!");
					break;		
					}
					else if(rhead ==null & lhead ==null)
					{
						if(par.id > curr.id)
							par.prev=null;
						else
							par.next=null;
						
					}
					System.out.println("Video successfully removed from store !!!");
					break;
					
				}
				else if(curr.id<id){
				
					par =curr;
					curr=curr.next;
				
				}
				
				else
				{
					par=curr;
					curr=curr.prev;			
				}
		}
		
		if(curr==null)
		System.out.println("There is no video with the given details !!!");

		
	}

	public void checkvid(int id) {
		int temp=0;
		node curr=nhead;
		while(curr!=null)
		{
			if(curr.id==id)
			{
				temp=1;
				break;
			}
			else if(curr.id>id)
			{
				curr=curr.prev;				
			}
			else if(curr.id<id)
			{
				curr=curr.next;
			}
		}
		if(temp==1)
		{
			System.out.println("Video Found");
		}
		else
			System.out.println("video not Found");		
	}

	public void checkoutvid(int vid, int id2) {

		node curr=nhead;
		while(curr!=null)
		{
			if(curr.id==vid)
			{
				cus curr1=chead;
				while(curr1!=null)
				{
					if(curr1.id==id2)
					{
						if(curr.i==true )
						{
							curr.i=false;
							curr1.vid=vid;
							System.out.println("The Video successfully rented");
						}
						else
						{
							System.out.println("Video already rented to other customer");
						}
						break;
					}
					else if(curr1.id>id2)
					{
						curr1=curr1.prev;
						
					}
					else if(curr1.id<id2)
					{
						curr1=curr1.next;
					}
				}
				if(curr1==null)
				{
					System.out.println("No customer available with given id");
					break;
				}
				break;
			}
			else if(curr.id>vid)
			{
				curr=curr.prev;
			}
			else if(curr.id<vid)
			{
				curr=curr.next;
			}
		}
		if(curr==null)
		{
			System.out.println("No video available with given id");
		}
		

		
	}

	public void chckinvid(int vid, int id) {
		  node curr=nhead;
		  cus  curr1=chead;
		  int temp=0;
		  while(curr!=null && temp==0)
		  {
			  if(curr.id==vid)
			  {
				  
				   while(curr1!=null && temp==0)
				   {
					   if(curr1.id==id)
					   {
						   if(curr1.vid==vid && curr.i==false)
						   {
							   curr1.vid=-1;
							   curr.i=true;
							   temp=1;
						   }
					   }
					   else if(curr1.id>id)
					   {
						   curr1=curr1.prev;
					   }
					   else if(curr.id<id)
					   {
						   curr1=curr1.next;
					   }
				   }
			  }
			  else if(curr.id>vid)
			  {
				  curr=curr.prev;
			  }
			  else if(curr.id<vid)
			  {
				  curr=curr.next;
			  }
		  }
		  if(temp==1)
		  {
			  System.out.println("video Successfully checked in");
		  }
		  else if(temp==0)
		  {
			  System.out.println("Details entered are not correct");
		  }		
	}

	public void allcus() {

		cus curr=chead;
		if(curr==null)
		{
			System.out.println("No customers to print");
		}
		else
		{
			System.out.println(curr.id+"\t "+curr.name);
			cus lhead=curr.prev;
			cus rhead=curr.next;
			if(lhead!=null)
			{
				System.out.println(lhead.id+"\t"+lhead.name);
			}
			if(rhead!=null)
			{
				System.out.println(rhead.id+"\t"+rhead.name);
			}
			if(lhead!=null)
			{
				curr=lhead;
				print(curr);
			}
			if(rhead!=null)
			{
				curr=rhead;
				print(curr);
			}
			
		}
	}
public void print(cus curr) {
		
		cus lhead=curr.prev;
		cus rhead=curr.next;
		if(lhead!=null)
		{
			System.out.println(lhead.id+"\t"+lhead.name);
		}
		if(rhead!=null)
		{
			System.out.println(rhead.id+"\t"+rhead.name);
		}
		if(lhead!=null)
		{
			print(lhead);
		}
		if(rhead!=null)
		{
			print(rhead);
		}
	}

	public void allvid() {
		node curr=nhead;
		if(curr==null)
		{
			System.out.println("No Videos to print");
		}
		else
		{
			System.out.println(curr.id+"\t "+curr.name);
			node lhead=curr.prev;
			node rhead=curr.next;
			if(lhead!=null)
			{
				System.out.println(lhead.id+"\t"+lhead.name);
			}
			if(rhead!=null)
			{
				System.out.println(rhead.id+"\t"+rhead.name);
			}
			if(lhead!=null)
			{
				curr=lhead;
				print1(curr);
			}
			if(rhead!=null)
			{
				curr=rhead;
				print1(curr);
			}
		}
	}
	
	public void print1(node curr) {
		node lhead=curr.prev;
		node rhead=curr.next;
		if(lhead!=null)
		{
			System.out.println(lhead.id+"\t"+lhead.name);
		}
		if(rhead!=null)
		{
			System.out.println(rhead.id+"\t"+rhead.name);
		}
		if(lhead!=null)
		{
			print1(lhead);
		}
		if(rhead!=null)
		{
			print1(rhead);
		}
		
	}


	public void instvid() {

		node curr=nhead;
		if(curr==null)
		{
			System.out.println("No Videos to print");
		}
		else
		{
			if(curr.i==true){
			     System.out.println(curr.id+"\t "+curr.name);}
			node lhead=curr.prev;
			node rhead=curr.next;
			if(lhead!=null)
			{
				if(lhead.i==true){
				System.out.println(lhead.id+"\t"+lhead.name);}
			}
			if(rhead!=null)
			{
				if(rhead.i==true){
				System.out.println(rhead.id+"\t"+rhead.name);}
			}
			if(lhead!=null)
			{
				curr=lhead;
				printiv(curr,true);
			}
			if(rhead!=null)
			{
				curr=rhead;
				printiv(curr,true);
			}
		}
	
		
	}

	public void rentvid() {
		node curr=nhead;
		if(curr==null)
		{
			System.out.println("No Videos to print");
		}
		else
		{
			System.out.println(curr.id+"\t "+curr.name);
			node lhead=curr.prev;
			node rhead=curr.next;
			if(lhead!=null)
			{
				if(lhead.i==false){
				System.out.println(lhead.id+"\t"+lhead.name);}
			}
			if(rhead!=null)
			{
				if(rhead.i==false){
				System.out.println(rhead.id+"\t"+rhead.name);}
			}
			if(lhead!=null)
			{
				curr=lhead;
				printiv(curr,false);
			}
			if(rhead!=null)
			{
				curr=rhead;
				printiv(curr,false);
			}
		}		
	}
	private void printiv(node curr,boolean t) {
		node lhead=curr.prev;
		node rhead=curr.next;
		if(lhead!=null)
		{
			if(lhead.i==t){
			System.out.println(lhead.id+"\t"+lhead.name);}
		}
		if(rhead!=null)
		{
			if(rhead.i==t){
			System.out.println(rhead.id+"\t"+rhead.name);}
		}
		if(lhead!=null)
		{
			printiv(lhead,t);
		}
		if(rhead!=null)
		{
			printiv(rhead,t);
		}
		
	}


	public void vidrent(int cid) {
		int temp=0;
		cus curr=chead;
		node curr1=nhead;
		while(curr!=null && temp==0 )
		{
			if(curr.id==cid)
			{
				while(curr1!=null && temp==0)
				{
					if(curr1.id==curr.vid)
					{
						System.out.println("Video rented by customer is "+curr1.name+"\t"+curr1.id);
						temp=1;
						
					}
					else if(curr1.id<curr.vid)
					{
						curr1=curr1.next;
					}
					else if(curr1.id>curr.vid)
					{
						curr1=curr1.prev;
					}
				}
				
			}
			else if(curr.id>cid)
			{
				curr=curr.prev;
			}
			else if(curr.id<cid)
			{
				curr=curr.next;
			}
			
		}
		if(temp==0)
		{
			System.out.println("Please check the entered details");
		}		

		
	}
	
}

public class VideoStore3 {
	static SLL sll = new SLL();
	static DLL dll=new DLL();
	static BST bst=new BST();
	static AVL avl=new AVL();
	public static void main(String[] args) throws IOException
	{

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		if(args.length==0)
		{
			System.out.println("Enter valid input");
		}
		else if(args.length==1) 
		{
			if(args[0].equals("SLL"))
			{
				menu();
				int i =Integer.parseInt(br.readLine());;
				while(i!=13)
				{ 
					
					switch (i){
					case 1: 
						System.out.println("Enter the name of the movie: ");
						String name=br.readLine();
						System.out.println("Enter the id of the Video: ");
						int id=Integer.parseInt(br.readLine());
						node n= new node(name,id,null,null);				
						sll.addvideo(n);
						
						break;
					case 2:
						System.out.println("Enter the id to be deleted");
						 id=Integer.parseInt(br.readLine());
						sll.delvid(id);
						break;
					case 3:
						System.out.println("Enter the name of the customer: ");
					    name=br.readLine();
						System.out.println("Enter the id of the customer: ");
						 id=Integer.parseInt(br.readLine());
						cus n1= new cus(name,id,null,null,0);
						sll.addcus(n1);	
						break;
					case 4:
					     System.out.println("Enter the id to be deleted");
						 id=Integer.parseInt(br.readLine());
						 sll.delcus(id);
						break;
					case 5:
						 System.out.println("Enter the id of video to check");
						 id=Integer.parseInt(br.readLine());
						 sll.checkvid(id);
						break;
					case 6:
						 System.out.println("Enter the id of video to check out");
						 id=Integer.parseInt(br.readLine());
						 System.out.println("Enter the id customer that check out");
						 int id2=Integer.parseInt(br.readLine());
						sll.checkoutvid(id,id2);
						break;
					case 7:
						 System.out.println("Enter the id of video to check in");
						 id=Integer.parseInt(br.readLine());
						 sll.chckinvid(id);
						break;
					case 8:
						sll.allcus();
						break;
					case 9:
						 sll.allvid();
						break;
					case  10:
						 sll.instvid();
						break;
					case 11:
						sll.rentvid();
						break;
					case 12:
						System.out.println("Enter the id of the customer");
						id=Integer.parseInt(br.readLine());
						sll.vidrent(id);
						break;
					case 13:
						System.out.println("Good Bye");
						break;
					default:
						System.out.println("Enter valid input");
						break;
					}
					menu();
					i =Integer.parseInt(br.readLine());;
				}
			}
			else if(args[0].equals("DLL"))
			{
				menu();
				int i =Integer.parseInt(br.readLine());;
				while(i!=13)
				{ 
					
					switch (i){
					case 1: 
						System.out.println("Enter the name of the movie: ");
						String name=br.readLine();
						System.out.println("Enter the id of the Video: ");
						int id=Integer.parseInt(br.readLine());
						node n= new node(name,id,null,null);				
						dll.addvideo(n);
						break;
					case 2:
						System.out.println("Enter the id to be deleted");
						 id=Integer.parseInt(br.readLine());
						dll.delvid(id);
						break;
					case 3:
						System.out.println("Enter the name of the customer: ");
					    name=br.readLine();
						System.out.println("Enter the id of the customer: ");
						 id=Integer.parseInt(br.readLine());
						cus n1= new cus(name,id,null,null,0);
						dll.addcus(n1);	
						break;
					case 4:
					     System.out.println("Enter the id to be deleted");
						 id=Integer.parseInt(br.readLine());
						 dll.delcus(id);
						break;
					case 5:
						 System.out.println("Enter the id of video to check");
						 id=Integer.parseInt(br.readLine());
						 dll.checkvid(id);
						break;
					case 6:
						 System.out.println("Enter the id of video to check out");
						 id=Integer.parseInt(br.readLine());
						 System.out.println("Enter the id customer that check out");
						 int id2=Integer.parseInt(br.readLine());
						dll.checkoutvid(id,id2);
						break;
					case 7:
						 System.out.println("Enter the id of video to check in");
						 id=Integer.parseInt(br.readLine());
						 dll.checkinvid(id);
						break;
					case 8:
						dll.allcus();
						break;
					case 9:
						 dll.allvid();
						break;
					case  10:
						 dll.instvid();
						break;
					case 11:
						dll.rentvid();
						break;
					case 12:
						System.out.println("Enter the id of the customer");
						id=Integer.parseInt(br.readLine());
						dll.vidrent(id);
						break;
					case 13:
						System.out.println("Good Bye");
						break;
					default:
						System.out.println("Enter valid input");
						break;
					}
					menu();
					i =Integer.parseInt(br.readLine());;
				}
				
			}
			else if(args[0].equals("BST"))
			{
				menu();
				int i =Integer.parseInt(br.readLine());;
				while(i!=13)
				{ 
					
					switch (i){
					case 1: 
						System.out.println("Enter the name of the movie: ");
						String name=br.readLine();
						System.out.println("Enter the id of the Video: ");
						int id=Integer.parseInt(br.readLine());
						node n= new node(name,id,null,null);				
						bst.addvideo(n);
						
						break;
					case 2:
						System.out.println("Enter the id to be deleted");
						 id=Integer.parseInt(br.readLine());
						bst.delvid(id);
						break;
					case 3:
						System.out.println("Enter the name of the customer: ");
					    name=br.readLine();
						System.out.println("Enter the id of the customer: ");
						 id=Integer.parseInt(br.readLine());
						cus n1= new cus(name,id,null,null,0);
						bst.addcus(n1);	
						break;
					case 4:
					     System.out.println("Enter the id to be deleted");
						 id=Integer.parseInt(br.readLine());
						 bst.delcus(id);
						break;
					case 5:
						 System.out.println("Enter the id of video to check");
						 id=Integer.parseInt(br.readLine());
						 bst.checkvid(id);
						break;
					case 6:
						 System.out.println("Enter the id of video to check out");
						 id=Integer.parseInt(br.readLine());
						 System.out.println("Enter the id customer that check out");
						 int id2=Integer.parseInt(br.readLine());
						bst.checkoutvid(id,id2);
						break;
					case 7:
						 System.out.println("Enter the id of video to check in");
						 id=Integer.parseInt(br.readLine());
						 System.out.println("Enter the id customer that check out"); 
						 id2=Integer.parseInt(br.readLine());
						 bst.chckinvid(id,id2);
						break;
					case 8:
						bst.allcus();
						break;
					case 9:
						 bst.allvid();
						break;
					case  10:
						 bst.instvid();
						break;
					case 11:
						bst.rentvid();
						break;
					case 12:
						System.out.println("Enter the id of the customer");
						id=Integer.parseInt(br.readLine());
						bst.vidrent(id);
						break;
					case 13:
						System.out.println("Good Bye");
						break;
					default:
						System.out.println("Enter valid input");
						break;
					}
					menu();
					i =Integer.parseInt(br.readLine());;
				}
			}
			else if(args[0].equals("AVL"))
			{
				menu();
				int i =Integer.parseInt(br.readLine());;
				while(i!=13)
				{ 
					
					switch (i){
					case 1: 
						System.out.println("Enter the name of the movie: ");
						String name=br.readLine();
						System.out.println("Enter the id of the Video: ");
						int id=Integer.parseInt(br.readLine());
						node n= new node(name,id,null,null);				
						avl.addvideo(n);
						
						break;
					case 2:
						System.out.println("Enter the id to be deleted");
						 id=Integer.parseInt(br.readLine());
						avl.delvid(id);
						break;
					case 3:
						System.out.println("Enter the name of the customer: ");
					    name=br.readLine();
						System.out.println("Enter the id of the customer: ");
						 id=Integer.parseInt(br.readLine());
						cus n1= new cus(name,id,null,null,0);
						avl.addcus(n1);	
						break;
					case 4:
					     System.out.println("Enter the id to be deleted");
						 id=Integer.parseInt(br.readLine());
						 avl.delcus(id);
						break;
					case 5:
						 System.out.println("Enter the id of video to check");
						 id=Integer.parseInt(br.readLine());
						 avl.checkvid(id);
						break;
					case 6:
						 System.out.println("Enter the id of video to check out");
						 id=Integer.parseInt(br.readLine());
						 System.out.println("Enter the id customer that check out");
						 int id2=Integer.parseInt(br.readLine());
						avl.checkoutvid(id,id2);
						break;
					case 7:
						 System.out.println("Enter the id of video to check in");
						 id=Integer.parseInt(br.readLine());
						 System.out.println("Enter the id customer that check out"); 
						 id2=Integer.parseInt(br.readLine());
						 avl.chckinvid(id,id2);
						break;
					case 8:
						avl.allcus();
						break;
					case 9:
						 avl.allvid();
						break;
					case  10:
						 avl.instvid();
						break;
					case 11:
						avl.rentvid();
						break;
					case 12:
						System.out.println("Enter the id of the customer");
						id=Integer.parseInt(br.readLine());
						avl.vidrent(id);
						break;
					case 13:
						System.out.println("Good Bye");
						break;
					default:
						System.out.println("Enter valid input");
						break;
					}
					menu();
					i =Integer.parseInt(br.readLine());;
				}
			
			}
		}
		else if(args.length==4)
		{
			int i1=Integer.parseInt(args[1]);
			int j1=Integer.parseInt(args[2]);
			int k1=Integer.parseInt(args[3]);
			for(int i=0;i<i1;i++)
			{
				String name="name"+i;
				int id=i;
				node n=new node(name,id,null,null);
				if(args[0].equals("SLL"))
				{
					sll.addvideo(n);
				}
				if(args[0].equals("DLL"))
				{
					dll.addvideo(n);
				}
				if(args[0].equals("BST"))
				{
					bst.addvideo(n);
				}
				if(args[0].equals("AVL"))
				{
					avl.addvideo(n);
				}	
			}
			for(int j=0;j<j1;j++)
			{
				String name="name"+j;
				int id=j;
				cus n=new cus(name,id,null,null,0);
				if(args[0].equals("SLL"))
				{
					sll.addcus(n);
				}
				if(args[0].equals("DLL"))
				{
					dll.addcus(n);
				}
				if(args[0].equals("BST"))
				{
					bst.addcus(n);
				}
				if(args[0].equals("AVL"))
				{
					avl.addcus(n);
				}	
			}
			long time=System.currentTimeMillis();
			ArrayList<Integer> tran=new ArrayList<Integer>();
			for(int k=0;k<k1;k++)
			{
				if(args[0].equals("SLL"))
				{
					sll.checkvid(k);
				}
				if(args[0].equals("DLL"))
				{
					dll.checkvid(k);
				}
				if(args[0].equals("BST"))
				{
					bst.checkvid(k);
				}
				if(args[0].equals("AVL"))
				{
					avl.checkvid(k);
				}
				tran.add(k);
			}
			for(int k=0;k<tran.size();k++)
			{
				tran.remove(0);
			}
			long time1=System.currentTimeMillis();
			
			long result=time1-time;
			System.out.println("Service Time taken for the data strucutre is "+result+"ms");
		}
	}

	public static void menu() throws IOException {
		    System.out.println("1.  Add a video ");
	        System.out.println("2.  Delete a video ");
	        System.out.println("3.  Add a customer");
	        System.out.println("4.  Delete a customer");
	        System.out.println("5.  Check if a video is in the store");
	        System.out.println("6.  Check out a video ");
	        System.out.println("7.  Check in a video");
	        System.out.println("8.  Print all customers");
	        System.out.println("9.  Print all videos");
	        System.out.println("10. Print in store videos");
	        System.out.println("11. Print all rent videos ");
	        System.out.println("12. Print the videos rent by a customer");
	        System.out.println("13. Exit");
		
	}

}
