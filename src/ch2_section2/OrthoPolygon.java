package ch2_section2;

public class OrthoPolygon {
	
	public int n; //꼭지점의 개수
	public Code09_MyPoint2[] vertices; //꼭지점 배열
	
	public OrthoPolygon(int k) {
		n = 0;
		vertices = new Code09_MyPoint2[k];
	}
	
	public void addVertex(Code09_MyPoint2 p) {
		vertices[n++] = p;
	}
	
	public int getMax() {
		int max = vertices[0].x;
		for(int i=0; i<n; i++) {
			if(vertices[i].x>max) {
				max = vertices[i].x;
			}
		}
		return max;
	}
	
	public boolean isInner(Code09_MyPoint2 p) {
		OrthoLine arrow = new OrthoLine(p, new Code09_MyPoint2(getMax()+1 , p.y));
		int count = 0;
		for(int i=0; i<n; i++) {
			OrthoLine edge = new OrthoLine(vertices[i], vertices[ (i+1) % n ]);
			if(arrow.isCrossed(edge)) {
				count++;
			}
		}
		return count % 2 ==1;
	}
}
