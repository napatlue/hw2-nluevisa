package edu.cmu.deiis.cpe;

import org.apache.uima.util.ProcessTrace;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.uima.cas.CAS;
import org.apache.uima.cas.CASException;
import org.apache.uima.cas.FSIterator;
import org.apache.uima.collection.CasConsumer_ImplBase;
import org.apache.uima.examples.SourceDocumentInformation;
import org.apache.uima.jcas.JCas;
import org.apache.uima.resource.ResourceInitializationException;
import org.apache.uima.resource.ResourceProcessException;
import org.apache.uima.util.CasToInlineXml;

import edu.cmu.deiis.types.AnswerScore;
import edu.cmu.deiis.types.Evaluator;

public class OutputScreenCasConsumer  extends CasConsumer_ImplBase {

  private int casCount;

  private Map<String, Double> averagePrecisionMap;

  public void initialize() throws ResourceInitializationException {
    averagePrecisionMap = new HashMap<String, Double>();
    casCount = 0;
  }

  /**
   * Processes the CasContainer which was populated by by analysis engine. <br>
   * In this case,it populates result gather from evaluator to output screen .
   * 
   * @param aCAS
   *          CasContainer which has been populated by my analysis engine
   * 
   * @throws ResourceProcessException
   *           if there is an error in processing the Resource
   * 
   * @see org.apache.uima.collection.base_cpm.CasObjectProcessor#processCas(org.apache.uima.cas.CAS)
   */
  public void processCas(CAS aCAS) throws ResourceProcessException {
    //Map to store average precision of each method
    
    
    JCas jcas;
    try {
      jcas = aCAS.getJCas();
    } catch (CASException e) {
      throw new ResourceProcessException(e);
    }

    FSIterator it = jcas.getAnnotationIndex(Evaluator.type).iterator();
    
    while(it.hasNext())
    {
      Evaluator eval = (Evaluator) it.next();
      if(eval.getCasProcessorId() == null)
      {
        continue;
      }
      System.out.println(eval.getQuestionText());
      
      String id = eval.getScoringClassId();
      System.out.println("Class producing score: "+ id);
      System.out.println("Result: \n"+eval.getResultText());
      casCount++;
      if(averagePrecisionMap.containsKey(id))
      {
        double sumPrecision = averagePrecisionMap.get(id) + eval.getPrecision();
        averagePrecisionMap.put(id, sumPrecision);
      }
      else
      {
        averagePrecisionMap.put(id, eval.getPrecision());
      }
      
    }

  }
 
  /**
   * Upon completion of collecting all CAS objects, outputs the average precision for all scoring method
   * to the screen.
   */
  @Override
  public void collectionProcessComplete(ProcessTrace arg0) {
    int numQuestion = casCount/averagePrecisionMap.size();
    System.out.println("*********************************************************");
    Iterator<Entry<String, Double>> it = averagePrecisionMap.entrySet().iterator();
    while (it.hasNext()) {
      
        Map.Entry pairs = (Map.Entry)it.next();
        double averagePrec = (Double)pairs.getValue() / numQuestion;
       // double roundedPrec = Math.round(averagePrec * 100D) / 100D;
        System.out.println("Average Precision for  "+ pairs.getKey()+ " :" + String.format("%.2f ", averagePrec));
    }
    
  }

}
