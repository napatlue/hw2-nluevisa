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
/** This class annotated the entire document and print the question and ranked score using all evaluation method in the pipeline with precision
 * of the method to the standard out */
public class EvaluatorAnnotator  extends JCasAnnotator_ImplBase{

  @Override
  public void process(JCas aJCas) throws AnalysisEngineProcessException {
    // TODO Auto-generated method stub
    

    
    //Map between method to use and AnswerScore 
    Map<String, Map<AnswerScore, Double>> methodScore = new HashMap<String,Map<AnswerScore, Double>>();
    String questionText = "";
    FSIndex questionIndex = aJCas.getAnnotationIndex(Question.type);
    Iterator questionIter = questionIndex.iterator();
    while (questionIter.hasNext()) {
      Question question = (Question) questionIter.next();
      //System.out.println("Question: " + question.getCoveredText());
      questionText += "Question: " + question.getCoveredText()+"\n";
      
    }

    //Seperate AnswerScores with different method and put them into the map  
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
    
    //print result to the screen
    Iterator it = methodScore.entrySet().iterator();
    while (it.hasNext()) {
      
        String text = "";
        precisionAtN = 0;
        Map.Entry pairs = (Map.Entry)it.next();
        //System.out.println(pairs.getKey() + " = " + pairs.getValue());
        //System.out.println("\n*** Method: "+ pairs.getKey() + " ***");
        String scoringClassId = pairs.getKey().toString();
        
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
            //System.out.print("+ ");
            text+= "+ ";
            
            if (i < precisionAtN) {
              correctAnswerCount++;
            }
          } else {
            //System.out.print("- ");
            text+="- ";
          }
          //System.out.print(String.format("%.2f ", score.getScore()));
          text+=String.format("%.2f ", score.getScore());
          //System.out.println(score.getCoveredText());
          text+=score.getCoveredText()+"\n";
        }
        // print precision
        String precision = String.format("%.2f ", (double) correctAnswerCount / (double) precisionAtN);
        //System.out.println("Precision at " + precisionAtN + ": " + precision);
        text+="Precision at " + precisionAtN + ": " + precision+"\n";
        it.remove(); // avoids a ConcurrentModificationException
        
        //Add evaluator annotation to CAS
        Evaluator annotation = new Evaluator(aJCas);
      
        annotation.setBegin(0);
        annotation.setEnd(aJCas.getDocumentText().length());
        annotation.setQuestionText(questionText);
        annotation.setScoringClassId(scoringClassId);
        annotation.setResultText(text);
        annotation.setNumCorrectAnswer(precisionAtN);
        annotation.setCasProcessorId(this.getClass().toString());
        annotation.setPrecision(Double.parseDouble(precision));
        annotation.setConfidence(1.0f);
        annotation.addToIndexes();
    }
      

    
  }

}
