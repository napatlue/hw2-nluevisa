package edu.cmu.deiis.types;


/* First created by JCasGen Mon Sep 23 15:30:12 EDT 2013 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;


/** Hold information of the method used for scoring and result. This type is intended to be used by casConsumer
 * Updated by JCasGen Mon Oct 07 02:34:05 EDT 2013
 * XML source: /Users/napatluevisadpaibul/git/hw2-nluevisa/hw2-nluevisa/src/main/resources/hw3-nluevisa-aae.xml
 * @generated */
public class Evaluator extends Annotation {
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int typeIndexID = JCasRegistry.register(Evaluator.class);
  /** @generated
   * @ordered 
   */
  @SuppressWarnings ("hiding")
  public final static int type = typeIndexID;
  /** @generated  */
  @Override
  public              int getTypeIndexID() {return typeIndexID;}
 
  /** Never called.  Disable default constructor
   * @generated */
  protected Evaluator() {/* intentionally empty block */}
    
  /** Internal - constructor used by generator 
   * @generated */
  public Evaluator(int addr, TOP_Type type) {
    super(addr, type);
    readObject();
  }
  
  /** @generated */
  public Evaluator(JCas jcas) {
    super(jcas);
    readObject();   
  } 

  /** @generated */  
  public Evaluator(JCas jcas, int begin, int end) {
    super(jcas);
    setBegin(begin);
    setEnd(end);
    readObject();
  }   

  /** <!-- begin-user-doc -->
    * Write your own initialization here
    * <!-- end-user-doc -->
  @generated modifiable */
  private void readObject() {/*default - does nothing empty block */}
     
 
    
  //*--------------*
  //* Feature: numCorrectAnswer

  /** getter for numCorrectAnswer - gets number of correct answer in the processing file
   * @generated */
  public int getNumCorrectAnswer() {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_numCorrectAnswer == null)
      jcasType.jcas.throwFeatMissing("numCorrectAnswer", "edu.cmu.deiis.types.Evaluator");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Evaluator_Type)jcasType).casFeatCode_numCorrectAnswer);}
    
  /** setter for numCorrectAnswer - sets number of correct answer in the processing file 
   * @generated */
  public void setNumCorrectAnswer(int v) {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_numCorrectAnswer == null)
      jcasType.jcas.throwFeatMissing("numCorrectAnswer", "edu.cmu.deiis.types.Evaluator");
    jcasType.ll_cas.ll_setIntValue(addr, ((Evaluator_Type)jcasType).casFeatCode_numCorrectAnswer, v);}    
   
    
  //*--------------*
  //* Feature: resultText

  /** getter for resultText - gets output text
   * @generated */
  public String getResultText() {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_resultText == null)
      jcasType.jcas.throwFeatMissing("resultText", "edu.cmu.deiis.types.Evaluator");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Evaluator_Type)jcasType).casFeatCode_resultText);}
    
  /** setter for resultText - sets output text 
   * @generated */
  public void setResultText(String v) {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_resultText == null)
      jcasType.jcas.throwFeatMissing("resultText", "edu.cmu.deiis.types.Evaluator");
    jcasType.ll_cas.ll_setStringValue(addr, ((Evaluator_Type)jcasType).casFeatCode_resultText, v);}    
   
    
  //*--------------*
  //* Feature: scoringClassId

  /** getter for scoringClassId - gets Id of the class we use for this scoring
   * @generated */
  public String getScoringClassId() {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_scoringClassId == null)
      jcasType.jcas.throwFeatMissing("scoringClassId", "edu.cmu.deiis.types.Evaluator");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Evaluator_Type)jcasType).casFeatCode_scoringClassId);}
    
  /** setter for scoringClassId - sets Id of the class we use for this scoring 
   * @generated */
  public void setScoringClassId(String v) {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_scoringClassId == null)
      jcasType.jcas.throwFeatMissing("scoringClassId", "edu.cmu.deiis.types.Evaluator");
    jcasType.ll_cas.ll_setStringValue(addr, ((Evaluator_Type)jcasType).casFeatCode_scoringClassId, v);}    
   
    
  //*--------------*
  //* Feature: questionText

  /** getter for questionText - gets formatted output text of question that we are processing
   * @generated */
  public String getQuestionText() {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_questionText == null)
      jcasType.jcas.throwFeatMissing("questionText", "edu.cmu.deiis.types.Evaluator");
    return jcasType.ll_cas.ll_getStringValue(addr, ((Evaluator_Type)jcasType).casFeatCode_questionText);}
    
  /** setter for questionText - sets formatted output text of question that we are processing 
   * @generated */
  public void setQuestionText(String v) {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_questionText == null)
      jcasType.jcas.throwFeatMissing("questionText", "edu.cmu.deiis.types.Evaluator");
    jcasType.ll_cas.ll_setStringValue(addr, ((Evaluator_Type)jcasType).casFeatCode_questionText, v);}    
   
    
  //*--------------*
  //* Feature: precision

  /** getter for precision - gets Precision value at Top N for this scoring method
   * @generated */
  public double getPrecision() {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_precision == null)
      jcasType.jcas.throwFeatMissing("precision", "edu.cmu.deiis.types.Evaluator");
    return jcasType.ll_cas.ll_getDoubleValue(addr, ((Evaluator_Type)jcasType).casFeatCode_precision);}
    
  /** setter for precision - sets Precision value at Top N for this scoring method 
   * @generated */
  public void setPrecision(double v) {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_precision == null)
      jcasType.jcas.throwFeatMissing("precision", "edu.cmu.deiis.types.Evaluator");
    jcasType.ll_cas.ll_setDoubleValue(addr, ((Evaluator_Type)jcasType).casFeatCode_precision, v);}    
  }

    