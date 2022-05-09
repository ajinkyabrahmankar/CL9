import java.util.Scanner;

public class BullyAlgo {
	static int num_proc;
	static boolean[] state=null;
	static int cordinator;
	public static void Up(int id)
	{
		if(state[id])
		{
			System.out.println("Process is already UP");
		}
		else
		{
			state[id]=true;
			Elect(id);
		}
	}
	public static void Down(int id)
	{
		if(!state[id])
		{
			System.out.println("Process is already DOWN");
		}
		else
		{
			state[id]=false;
		}
	}
	public static int nextUp(int id)
	{
		do
		{
			id++;
			id=id%num_proc;
		}while(!state[id]);
		
		return id;
		
	}
	public static void Elect(int id) {
		int tmpcoord = -1;
		for(int i=id;i<num_proc;i++)
		{
			if(state[i])
			{
				for (int j = i + 1; j < num_proc; j++)
				{
					System.out.println("Proccess "+ i + " sent message to"+ j);
				}
				for (int j = i + 1; j < num_proc; j++)
				{
					if(state[j])
					{
						System.out.println("Proccess "+ j + " sent OK to"+ j);
						tmpcoord=j;
					}
				}
			}
		}
		cordinator=tmpcoord;
		System.out.println("New co-ordinator is "+cordinator);
	}
	public static void display()
	{
		for(int i=0;i<num_proc;i++)
		{
			System.out.print(state[i] + " ");
		}
		System.out.println();
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in=new Scanner(System.in);
		System.out.println("Enter the number of processes : ");
		num_proc = in.nextInt();
		state=new boolean[num_proc];
		System.out.print("Setting all States:");
		for(int i=0;i<num_proc;i++)
		{
			state[i]=true;
		}
		
		int inp=0;
		do
		{
			System.out.println("\n1.Activate process");
			System.out.println("2.Deactivate process");
			System.out.println("3.Election");
			System.out.println("0.Quit");
			inp=in.nextInt();
			int proc;
			switch(inp)
			{
				case 1:
				{
					System.out.println("Enter id:");
					proc=in.nextInt();
					Up(proc);
					break;
				}
				case 2:
				{
					System.out.println("Enter id:");
					proc=in.nextInt();
					Down(proc);
					break;
				}
				case 3:
				{
					System.out.println("Enter id:");
					proc=in.nextInt();
					Elect(proc);
					break;
				}
				case 4:
				{
					display();
					break;
				}
				case  0:
					break;
				default:
					System.out.println("Enter valid opion");
			}
		}while(inp!=0);
	}

}
