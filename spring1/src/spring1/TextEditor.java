package spring1;

public class TextEditor {
	private SpellChecker spellchecker;
	public TextEditor(SpellChecker spellchecker){
		System.out.println("inside texteditor constructor");
		this.spellchecker=spellchecker;
	}
	public void spellcheck()
	{
		spellchecker.checkSpelling();
	}

}
