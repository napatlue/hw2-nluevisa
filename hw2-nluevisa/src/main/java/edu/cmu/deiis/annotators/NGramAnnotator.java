package edu.cmu.deiis.annotators;


import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.tutorial.RoomNumber;

import edu.cmu.deiis.types.NGram;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Sentence;
import edu.cmu.deiis.types.Token;

import java.util.Iterator;
/** This class annotated all the sentences in document and generate Unigram, Bigram and Trigram (all are of NGram type)*/
public class NGramAnnotator extends JCasAnnotator_ImplBase {

  static final int N = 3; //Set to do Unigram,Bigram and Trigram

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    // Create NGram array for all sentences
    FSIndex sentenceIndex = aJCas.getAnnotationIndex(Sentence.type);
    Iterator sentenceIter = sentenceIndex.iterator();
    while (sentenceIter.hasNext()) {
      Sentence sentence = (Sentence) sentenceIter.next();
      
      FSArray tokenArray = sentence.getTokenArray();
      FSArray ngramArray = new FSArray(aJCas, tokenArray.size() * this.N - this.N * (this.N - 1)
              / 2);
      

      int count = 0;

      for (int gramSize = 1; gramSize <= this.N; gramSize++) {
        for (int startPosition = 0; startPosition < tokenArray.size() - gramSize + 1; startPosition++) {
          NGram annotation = new NGram(aJCas);
 
          FSArray array = new FSArray(aJCas, gramSize);
          annotation.setElements(array);
          for (int i = 0; i < gramSize; i++) {
            Token token = (Token) tokenArray.get(startPosition + i);
            array.set(i, token);
          }
          annotation.setElements(array);
          Token beginToken = (Token) tokenArray.get(startPosition);
          Token endToken = (Token) tokenArray.get(startPosition + gramSize - 1);
          annotation.setBegin(beginToken.getBegin());
          annotation.setEnd(endToken.getEnd());
          annotation.setCasProcessorId(this.getClass().toString());
          annotation.setConfidence(1.0);
          annotation.setElementType(Token.class.toString());
          annotation.addToIndexes();
 
          ngramArray.set(count++, annotation);
        }
      }
      sentence.setNGramArray(ngramArray);
    }
  }

}
