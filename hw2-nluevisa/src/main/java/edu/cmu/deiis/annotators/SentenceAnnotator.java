package edu.cmu.deiis.annotators;

import java.util.Iterator;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;
import org.apache.uima.jcas.cas.FSArray;
import org.apache.uima.tutorial.RoomNumber;

import edu.cmu.deiis.types.Answer;
import edu.cmu.deiis.types.Question;
import edu.cmu.deiis.types.Sentence;
import edu.cmu.deiis.types.Token;
/** This class annotated the sentence in document and associate Sentence with Question and Answer*/
public class SentenceAnnotator extends JCasAnnotator_ImplBase{


  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    FSIndex tokenIndex = aJCas.getAnnotationIndex(Token.type);
    
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator questionIter = questionIndex.iterator();
    
    
    while (questionIter.hasNext()) {
      
      Question question = (Question) questionIter.next();
      
      Sentence annotation = new Sentence(aJCas);
      annotation.setBegin(question.getBegin()+2);
      annotation.setEnd(question.getEnd());
      
      Iterator tokenIter = tokenIndex.iterator();
      FSArray tmpTokenArray = new FSArray(aJCas,tokenIndex.size());
      int count = 0;
      while(tokenIter.hasNext())
      {
        Token token = (Token) tokenIter.next();
        if(token.getEnd() > question.getEnd()-3) //this token is not in the question, also discard ?
        {
          break;
        }
        else if(token.getBegin() >= question.getBegin()+2) //this token is in the question sentence 
        {  tmpTokenArray.set(count, token);
         // annotation.setTokenArray(count, token);
          count++;
        }
      }
      
      
      FSArray tokenArray = new FSArray(aJCas,count); //we want to hold array with the exact size of tokens
      tokenArray.copyFromArray(tmpTokenArray.toArray(), 0, 0, count);
      
      annotation.setTokenArray(tokenArray);
      annotation.setConfidence(1.0);
      annotation.setCasProcessorId(this.getClass().toString());
      annotation.addToIndexes();
      
      question.setSentence(annotation);
      //for my unit test only
      /*
      FSArray arr = annotation.getTokenArray();
      for (int i=0;i<arr.size();i++)
      {
        Token t = (Token)arr.get(i);
        System.out.println(t.getCoveredText()+", ");
      }
      */
    }
    
    FSIndex answerIndex = aJCas.getAnnotationIndex(Answer.type);
    Iterator answerIter = answerIndex.iterator();
    
    
    while (answerIter.hasNext()) {
      
      Answer answer = (Answer) answerIter.next();
      
      Sentence annotation = new Sentence(aJCas);
      annotation.setBegin(answer.getBegin()+4);
      annotation.setEnd(answer.getEnd());
      
      Iterator tokenIter = tokenIndex.iterator();
      FSArray tmpTokenArray = new FSArray(aJCas,tokenIndex.size());
      int count = 0;
      while(tokenIter.hasNext())
      {
        Token token = (Token) tokenIter.next();
        if(token.getEnd() > answer.getEnd()-3) //this token is not in the answer, also discard .
        {
          break;
        }
        else if(token.getBegin() >= answer.getBegin()+4) //this token is in the answer sentence 
        {  tmpTokenArray.set(count, token);
         // annotation.setTokenArray(count, token);
          count++;
        }
      }
      
      
      FSArray tokenArray = new FSArray(aJCas,count); //we want to hold array with the exact size of tokens
      tokenArray.copyFromArray(tmpTokenArray.toArray(), 0, 0, count);
      
      annotation.setTokenArray(tokenArray);
      annotation.setConfidence(1.0);
      annotation.setCasProcessorId(this.getClass().toString());
      annotation.addToIndexes();
      
      answer.setSentence(annotation);
      //for my unit test only
      /*
      FSArray arr = annotation.getTokenArray();
      for (int i=0;i<arr.size();i++)
      {
        Token t = (Token)arr.get(i);
        System.out.println(t.getCoveredText()+", ");
      }
      */
    }
  }

}
