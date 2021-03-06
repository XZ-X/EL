package elimGame2;
//2.	玩家可以置换相邻两块宝石的位置，只有三个或三个以上相同宝石在同一行或同一列才能消除成功，如果置换后未能消除成功则两块宝石回到初始位置。
public class CommonGem {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		CommonGem cg =new CommonGem(BlockEnum.BLUE,0,0);
		CommonGem Lg =new CommonGem(BlockEnum.BLUE,1,1);
		
		System.out.println(cg.equals(Lg));
	}
	//######################################
	//######################################
	//横坐标
	protected int abscissa ;
	//纵坐标
	protected int ordinate ;
	public final BlockEnum color ;
	//消除时的一起消除的方块个数.可以用来产生不同的特效宝石
	
	int countAB = 0;
	int countOR = 0;
	//当前状态下是否处于可消除状态
	boolean isElim = false;
	//是否可以成为特效宝石
	boolean canLevelUp = false;
	//该方块应该掉落多少
	private int needMove = 0;
	//
	public CommonGem(BlockEnum c,int i,int j) {
		// TODO Auto-generated constructor stub
		abscissa = i;
		ordinate=j;
		color=c;
	}

	/*
	 * 返回该方块应该移动的距离
	 * 移动是指在坐标上从上往下的距离
	 */
	public int move(){
		int move =needMove;
		needMove= 0;
		return move;
		
	}
	public CommonGem elim(){
		
			if(canLevelUp){
				if(countAB>4||countOR>4)
				{
					//you dian wen ti
					return new ColorizedGem(color, abscissa, ordinate);
				}
				
				if((countAB==4&&countOR==3)||(countAB==3&&countOR==4))
				{
					return new CrossedGem(color, abscissa, ordinate);
				}
				
				if(countAB==4||countOR==4)	
				{
					return new LinearGem(color, abscissa, ordinate);
				}	
				
				if(countAB==3&&countOR==3)
				{
					return new LShapeGem(color, abscissa, ordinate);
				}
				
			}
			return null;
	}
	
	 @Override
	public boolean equals(Object arg0) {
		 if(arg0 instanceof CommonGem){
			 if(this.color==((CommonGem)arg0).color)
				 return true;
		 }
		// TODO Auto-generated method stub
		 
		return false;
	}
	 
	 
	public String getColor(){
		return this.color.colour+"色";
	} 
}
