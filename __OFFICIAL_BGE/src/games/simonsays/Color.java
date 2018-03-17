package games.simonsays;
public enum Color {
	RED ("R", new int [] {0,0}),
	BLUE ("B", new int [] {0,1}),
	GREEN ("G", new int [] {0,2}),
	PINK ("P", new int [] {1,0}),
	PURPLE ("PR", new int [] {1,1}),
	YELLOW ("Y", new int [] {1,2}),
	ORANGE ("O", new int [] {2,0}),
	BROWN ("BR", new int [] {2,1}),
	SILVER ("S", new int [] {2,2});
	
	public final String code;
	public final int [] index;
	
	Color(String c, int [] i){
		code = c;
		index = i;
	}
}
