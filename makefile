test: MarkdownParseTestPatoo.class MarkdownParsePatoo.class
	java -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar org.junit.runner.JUnitCore MarkdownParseTestPatoo
MarkdownParsePatoo.class: MarkdownParsePatoo.java
	javac MarkdownParsePatoo.java
MarkdownParseTestPatoo.class: MarkdownParseTestPatoo.java
	javac -cp .:lib/junit-4.13.2.jar:lib/hamcrest-core-1.3.jar MarkdownParseTestPatoo.java
clean:
	rm *.class
