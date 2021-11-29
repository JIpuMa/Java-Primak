package com.company.Cw;

import java.util.Scanner;

public class t_04_05_01 {
    public void main() {
        System.out.print("Input text: ");
        Scanner sc_text = new Scanner(System.in);
        String input_text = sc_text.nextLine();
        Text text = new Text(input_text);
        text.printText();
        System.out.print("Add text: ");
        Scanner sc_add = new Scanner(System.in);
        String add_text = sc_add.nextLine();
        text.addText(add_text);
        text.printText();
        System.out.print("Input header: ");
        Scanner sc_header = new Scanner(System.in);
        String input_header = sc_header.next();
        text.setHeader(input_header);
        text.printTextWithHeader();
    }
}

class Word {
    private String text = null;

    public Word() {}

    public Word(String word) {
        setText(word);
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }
}

class Sentence extends Word{
    private int numWords;

    public Sentence() {
        super();
        setNumWords("");
    }

    public Sentence(String sentence) {
        super(sentence);
        setNumWords(sentence);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public String getText() {
        return super.getText();
    }

    public void setNumWords(String sentence) {
        this.numWords = sentence.split(" ").length;
    }

    public int getNumWords() {
        return numWords;
    }
}

class Text extends Sentence {
    private int numSentence;
    private Word header;

    public Text() {
        super();
        this.header = null;
        setNumSentence("");
    }

    public Text(String text) {
        super(text);
        setNumSentence(text);
    }

    @Override
    public void setText(String text) {
        super.setText(text);
    }

    @Override
    public String getText() {
        return super.getText();
    }

    public void setNumSentence(String text) {
        this.numSentence = text.split(".").length;
    }

    public int getNumSentence() {
        return this.numSentence;
    }

    public void addText(String text) {
        setText(this.getText() + " " + text);
        setNumSentence(this.getText() + " " + text);
    }

    public void printText() {
        System.out.println(this.getText());
    }

    public void printTextWithHeader() {
        System.out.println(this.getHeader().getText());
        System.out.println(this.getText());
    }

    public void setHeader(String header) {
        this.header = new Word(header);
    }

    public Word getHeader() {
        return this.header;
    }
}
