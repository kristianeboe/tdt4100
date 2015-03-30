package stateandbehavior;

public class LineEditorProgram {
	private LineEditor le;
	
	public void init(){
		le = new LineEditor();
	}
	public void run(){
		System.out.println(le);
		le.right();
		le.right();
		le.right();
		System.out.println(le.insertionIndex);
		System.out.println(le);
		System.out.println(le.text.length());
		le.deleteRight();
		le.deleteLeft();
		System.out.println(le);
	}
	
	public static void main(String[] args) {
		LineEditorProgram line_editor_program  = new LineEditorProgram();
		line_editor_program.init();
		line_editor_program.run();
	}
}
