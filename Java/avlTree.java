package avl_tree;
import java.util.*;

class node
{
	String cust_name;
	long phone;
	int h;
	node left;
	node right;
	
	node(String cust_name,long phone)
	{
		this.cust_name=cust_name;
		this.phone=phone;
		h=0;
		left=null;
		right=null;
	}
}

class tree
{
	node root;
	
	
	node rr(node root)  //left rotation
	{
		System.out.println("============================================");
		levelOrder(this.root);
		System.out.println("============================================");
		node ptr,temp;
		ptr=root;
		temp=ptr.right;
		ptr.right=temp.left;
		temp.left=ptr;
		temp.h=height(temp);
		ptr.h=height(temp);
		System.out.println("RR is done");
		return temp;
	}
	
	node ll(node root)   //right rotation
	
	{
		System.out.println("============================================");
		levelOrder(this.root);
		System.out.println("============================================");
		node ptr,temp;
		ptr=root;
		temp=ptr.left;
		ptr.left=temp.right;
		temp.right=ptr;
		temp.h=height(temp);
		ptr.h=height(temp);
		System.out.println("LL is done");

		return(temp);
	}
	
	node lr(node root)
	{
		System.out.println("============================================");
		levelOrder(this.root);
		System.out.println("============================================");
		root.left=rr(root.left);
		root=ll(root);
		//System.out.println("LR is required");

		return root;
	}
	
	node rl(node root)
	{
		System.out.println("============================================");
		levelOrder(this.root);
		System.out.println("============================================");
		root.right=ll(root.right);
		root=rr(root);
		//System.out.println("RL is required");/System.out.println(\"5.Delete\");

		return root;
	}


	 int height(node t)
	 {
		
		 if(t==null)
			{
				return 0;
			}
			else
			{
				int l_h=height(t.left);
				int r_h=height(t.right);
				if(l_h>r_h)
				{
					return (l_h+1);
					
				}
				else
				{
					return (r_h+1);
				}
			}
	}
	 node add(node localroot,String cn,long pn)
	 {
		
		 
		if (localroot == null) {
			return new node(cn, pn);
		} else {

			if (localroot.cust_name.compareToIgnoreCase(cn) < 0) 
			{
				localroot.right = add(localroot.right, cn, pn);
			}
			else if (localroot.cust_name.compareToIgnoreCase(cn) > 0)
			{
				localroot.left = add(localroot.left, cn, pn);
			}

		}

		int bf = bf(localroot);
		if (bf > 1) {
			if (cn.compareToIgnoreCase(localroot.left.cust_name) < 0) 
			{
				//levelOrder(root);
				System.out.println("Balance factor of "+localroot.cust_name+" is "+bf);
				return ll(localroot);
			} 
			else
			{
				//levelOrder(root);
				System.out.println("LR required");
				System.out.println("Balance factor of "+localroot.cust_name+" is "+bf);
				return lr(localroot);
			}
		} else if (bf < -1) 
		{
			if (cn.compareToIgnoreCase(localroot.right.cust_name) > 0)
			{
				//levelOrder(root);
				
				System.out.println("Balance factor of "+localroot.cust_name+" is "+bf);
				return rr(localroot);
			}
			else 
			{
				System.out.println("RL required");
				//levelOrder(root);
				System.out.println("Balance factor of "+localroot.cust_name+" is "+bf);
				return rl(localroot);
			}
		}
	
		return localroot;
		 
	 }
	 
	/*
	 * int max(int a ,int b) { if(a>b) return a; else return b; }
	 */
	 
	 void display(node lroot)
	 {   //display alphabetically
			if (lroot != null) {
				display(lroot.left);
				System.out.print(lroot.cust_name + "->");
				System.out.print(lroot.phone + " ");
				System.out.println();
				display(lroot.right);
			}
		}
	 void levelOrder(node n) //print tree levelwise
		{
			Queue<node> q = new LinkedList<node>();
			q.add(n);
			
			while(true)
			{
				int c=q.size();
				if(c==0)
					break;
				while(c>0)
				{ //display alphabetically
					n=q.remove();
					System.out.print(" "+n.cust_name+" => "+n.phone+" ");
					if(n.left!=null)
						q.add(n.left);
					if(n.right!=null)
						q.add(n.right);
					if(q.isEmpty())
					{
						n=null;
					}
					c--;
					
				}
				System.out.println();
				
			}
			}

	 int bf(node root2) {
		
		 
		return height(root2.left)-height(root2.right);
	}
	 
	void search(node localroot) {
		Scanner sc = new Scanner(System.in);
		node ptr;
		String n;
		int flag = 0;
		System.out.println("Enter the name of customer you want to search: ");
		n = sc.next();

		ptr = localroot;
		while (ptr != null) {
			if ((n).compareToIgnoreCase(ptr.cust_name) == 0) //
			{
				flag = 1;
				break;
			} else if ((n).compareToIgnoreCase(ptr.cust_name) < 0)// move to left
			{
				ptr = ptr.left;
			} else {
				ptr = ptr.right;// move to right
			}
		}
		if (flag == 0) {
			System.out.println("No data found !!!");
		} else {
			System.out.println(ptr.cust_name + " : " + ptr.phone);
		}

	}

	void update() {
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		long update;
		String n;
		System.out.println("Enter the customer name whose no. you want to update");
		n = sc.next();
		node ptr = root;
		while (ptr != null) 
		{
			if ((n).compareToIgnoreCase(ptr.cust_name) == 0)
{
				System.out.println("Customer is present");
				flag = 1;
				break;
			} 
			else 
				if ((n).compareToIgnoreCase(ptr.cust_name) < 0)// move to left
				{
				ptr = ptr.left;
				} 
				else 
				{
				ptr = ptr.right;// move to right
			}
		}
		if (flag == 0) {
			System.out.println("No data found !!!");
		} else {
			System.out.println("Enter the updated phone number : ");
			update = sc.nextLong();
			ptr.phone = update;
			System.out.println("Update successful!!!");
			System.out.println(ptr.cust_name + " : " + ptr.phone);

		}

	}

	void delete() 
	{
		node ptr;
		Scanner sc = new Scanner(System.in);
		int flag = 0;
		String n;
		Stack<node> s = new Stack();
		Stack<Integer> flagStack = new Stack();  
		node prev = null;
		System.out.println("Enter the name you want to delete : ");
		n = sc.next();
		ptr = root;
		while (ptr != null) 
		{
			if ((n).compareToIgnoreCase(ptr.cust_name) == 0) 
			{
				flag = 1;
				break;
			} 
			else
				if ((n).compareToIgnoreCase(ptr.cust_name) < 0)
				{
				flagStack.push(0);
				s.push(ptr);
				prev = ptr;
				ptr = ptr.left;// move to leftphone_no
			} 
				else
				{
					flagStack.push(1);
					s.push(ptr);
				prev = ptr;
				ptr = ptr.right;// move to right
			}
		}
		if (flag == 0) 
		{
			System.out.println("No data found !!!");
		}
		else
		{
			while (ptr != null)
			{
				// when node to be deleted is a leaf node
				if (ptr.left == null && ptr.right == null)
				{
					if (((prev.left).cust_name).compareTo(n) == 0)
					{
						prev.left = null;
					} 
					else 
					{
						prev.right = null;
					}
					break;
				}
				// When the node to be deleted only has left child

				if (ptr.left != null && ptr.right == null)
				{
					if (((prev.left).cust_name).compareTo(n) == 0) 
					{
						prev.left = ptr.left;
					}
					else
					{
						prev.right = ptr.left;
					}
					break;
				}
				// When node to be deleted has right child only

				if (ptr.left == null && ptr.right != null)
				{
					if (((prev.left).cust_name).compareTo(n) == 0)
					
					{
						prev.left = ptr.right;
					} 
					else 
					{
						prev.right = ptr.right;
					}
					break;
				}
				// when node be deleted has both the children

				if (ptr.left != null && ptr.right != null) 
				{
					node temp = ptr.left;
					prev = null;
					while (temp.right != null) 
					{
						prev = temp;
						temp = temp.right;
					}
					ptr.cust_name = temp.cust_name;
					ptr.phone = temp.phone;
					if (prev != null) 
					{
						prev.right = temp.left;
					}
					break;
				}

			}
		}
		//update tree after deletion
		
		while(!s.isEmpty())
		{
			node ptrUn = s.pop();
			int bal = bf(ptrUn);
			if(bal>1||bal<-1)
			{
				int a = flagStack.pop();
				int b= flagStack.pop();
				if(b==0&&a==0)
				{
					ptrUn = ll(ptrUn);
				}
				else
					if(b==1&&a==1)
					{
						rr(ptrUn);
					}
					else
						if(b==0&&a==1)
						{
							ll(ptrUn);
						}
						else
							if(b==1&&a==0)
							{
								ll(ptrUn);
							}
			
			}
			else
			{
				flagStack.pop();
			}
		}
	}
		
	
	void create()
	{
		Scanner sc = new Scanner(System.in);
	char ch=0;
	String name;
	long ph_no;
	do
		{
			System.out.println("Enter the name :");
			name=sc.next();
			System.out.println("Enter the phone number ");
			ph_no=sc.nextLong();
			root= add(root,name,ph_no);
			System.out.println("============================================");
			levelOrder(root);
			System.out.println("============================================");
		
			System.out.println("Do you want to enter more Customers? ");
			ch=sc.next().charAt(0);


		}while(ch=='y'||ch=='Y');
	}
}
public class avl {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		int choice = 0;
		String cn;
		long pn;
		tree t = null;
		do {  //Dsiplay menu
			System.out.println();
			System.out.println("============================================");
			System.out.println("1.Create AVL tree");
			System.out.println("2.Insert word");
			System.out.println("3.Search");
			System.out.println("4.Update");
			//System.out.println("5.Delete");
			System.out.println("5.Display");
			System.out.println("6.Level wise Display");
			System.out.println("============================================");

			choice = sc.nextInt();
			switch (choice) {
			case 1:
				t = new tree();
				char c = '\0';
				t.create();
				
				break;
			case 2:if(t!=null)
			{
				System.out.println("Enter Customer name");
				cn=sc.next();
				System.out.println("Enter Phone name");
				pn=sc.nextLong();
				t.add(t.root, cn, pn);
			}
			else
			{
				System.out.println("Tree has not been created.");
			}
			break;
		
			case 3:System.out.println("============================================");
				if(t!=null)
				{
					t.search(t.root);
				}
				else
				{
					System.out.println("Tree has not been created.");
				}
				System.out.println("============================================");
				break;
		
				case 4:	
					System.out.println("============================================");if(t!=null)
				{
					t.update();		
				}
				else
				{
					System.out.println("Tree has not been created.");
				}
					System.out.println("============================================");
					
				break;
			/*case 5:
				System.out.println("============================================");
				if(t!=null)
				{
				t.delete();
				}
				else
				{
					System.out.println("Tree has not been created.");
				}
				break;
				System.out.println("============================================");*/
			case 5:System.out.println("============================================");
				if(t!=null)
				{
					t.delete();
				}
				else
				{
					System.out.println("Tree has not been created.");
				}
				System.out.println("============================================");
				break;
				
			case 6:System.out.println("============================================");
				if(t!=null)
				{
					t.levelOrder(t.root);	
				}
				else
				{
					System.out.println("Tree has not been created.");
				}
				System.out.println("============================================");
			    break;
			}
		} while (choice >= 1 && choice <= 7);
	}



}