package ch2_section2;

public class OrthoLine {
	
	public Code09_MyPoint2 u;
	public Code09_MyPoint2 v;
	
	public OrthoLine(Code09_MyPoint2 p, Code09_MyPoint2 q) {
		u = p;
		v = q;
		if(u.x > v.x || u.x == v.x && u.y > v.y) { // 좌표는 4사분면이므로 우,하 로 갈 때 커짐
			swap();
		}
	}
	
	public void swap() {
		Code09_MyPoint2 tmp = u;
		u = v;
		v = tmp;
	}

	public boolean isVertical() {
		return u.x == v.x;
	}
	public boolean isCrossed(OrthoLine other) {
		if(isVertical() && !other.isVertical()) {
			return u.x > other.u.x && v.x < other.v.x && u.y < other.u.y && v.y > other.v.y;  
		} else if(!isVertical() && other.isVertical()) {
			return u.x < other.u.x && v.x > other.v.x && u.y > other.u.y && v.y < other.v.y;
		} else {
			return false;
		}
	}
}
