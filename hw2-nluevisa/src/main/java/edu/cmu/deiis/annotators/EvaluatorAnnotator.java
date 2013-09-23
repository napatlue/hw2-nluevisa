package edu.cmu.deiis.annotators;



import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.uima.analysis_component.JCasAnnotator_ImplBase;
import org.apache.uima.analysis_engine.AnalysisEngineProcessException;
import org.apache.uima.cas.FSIndex;
import org.apache.uima.jcas.JCas;

import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.Evaluator;
import edu.cmu.deiis.types.Question;

public class EvaluatorAnnotator  extends JCasAnnotator_ImplBase{

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    //Map<AnswerScore, Double> scoreMap = new HashMap<AnswerScore, Double>();
    
    Map<String, Map<AnswerScore, Double>> methodScore = new HashMap<String,Map<AnswerScore, Double>>();
    
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator questionIter = questionIndex.iterator();
    while (questionIter.hasNext()) {
      Question question = (Question) questionIter.next();
      System.out.println("Question: " + question.getCoveredText());
    }

    //
    FSIndex ScoreIndex = aJCas.getAnnotationIndex(AnswerScore.type);
    Iterator ScoreIter = ScoreIndex.iterator();
    while (ScoreIter.hasNext()) {
      AnswerScore score = (AnswerScore) ScoreIter.next();
      String method = score.getCasProcessorId();
      if(methodScore.containsKey(method))
      {
        methodScore.get(method).put(score, score.getScore());
      }
      else
      {
        Map<AnswerScore, Double> scoreMap = new HashMap<AnswerScore, Double>();
        scoreMap.put(score, score.getScore());
        methodScore.put(method, scoreMap);
      }
      //scoreMap.put(score, score.getScore());
    }
    int precisionAtN=0;
    
    Iterator it = methodScore.entrySet().iterator();
    while (it.hasNext()) {
        precisionAtN = 0;
        Map.Entry pairs = (Map.Entry)it.next();
        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
        System.out.println("\n*** Method: "+ pairs.getKey() + " ***");
        
        Map<AnswerScore, Double> scoreMap = (Map<AnswerScore, Double>)pairs.getValue();
        
        ArrayList<Entry<AnswerScore, Double>> scoreList = new ArrayList<Entry<AnswerScore, Double>>(
                scoreMap.entrySet());
    
        Collections.sort(scoreList, new Comparator<Map.Entry<AnswerScore, Double>>() {
          public int compare(Map.Entry<AnswerScore, Double> o1, Map.Entry<AnswerScore, Double> o2) {
            return (int) (o2.getValue() * 100.0 - o1.getValue() * 100.0);
          }
        });
    
        
        
        for(int i=0;i<scoreList.size();i++){
          if(scoreList.get(i).getKey().getAnswer().getIsCorrect()){
            precisionAtN++;
          }
        }
        
        int correctAnswerCount = 0;
        // print answer
        for (int i = 0; i < scoreList.size(); i++) {
          AnswerScore score = scoreList.get(i).getKey();
          if (score.getAnswer().getIsCorrect()) {
            System.out.print("+ ");
            if (i < precisionAtN) {
              correctAnswerCount++;
            }
          } else {
            System.out.print("- ");
          }
          System.out.print(String.format("%.2f ", score.getScore()));
          System.out.println(score.getCoveredText());
        }
        // print precision
    
        String precision = String.format("%.2f ", (double) correctAnswerCount / (double) precisionAtN);
        System.out.println("Precision at " + precisionAtN + ": " + precision);
        
        it.remove(); // avoids a ConcurrentModificationException
    }
      

    Evaluator annotation = new Evaluator(aJCas);
    annotation.setBegin(0);
    annotation.setEnd(aJCas.getDocumentText().length());
    annotation.setNumCorrectAnswer(precisionAtN);
    //annotation.setPerformance(Double.parseDouble(precision));
    annotation.setCasProcessorId(this.getClass().toString());
    annotation.setConfidence(1.0f);
    annotation.addToIndexes();
  }

}
