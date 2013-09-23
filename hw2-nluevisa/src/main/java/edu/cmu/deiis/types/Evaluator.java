package edu.cmu.deiis.types;


/* First created by JCasGen Mon Sep 23 15:30:12 EDT 2013 */

import org.apache.uima.jcas.JCas; 
import org.apache.uima.jcas.JCasRegistry;
import org.apache.uima.jcas.cas.TOP_Type;


/** 
 * Updated by JCasGen Mon Sep 23 15:48:59 EDT 2013
 * XML source: /Users/napatluevisadpaibul/Documents/workspace/hw2-nluevisa/src/main/resources/descriptors/aeDescriptor.xml
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

  /** getter for numCorrectAnswer - gets 
   * @generated */
  public int getNumCorrectAnswer() {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_numCorrectAnswer == null)
      jcasType.jcas.throwFeatMissing("numCorrectAnswer", "edu.cmu.deiis.types.Evaluator");
    return jcasType.ll_cas.ll_getIntValue(addr, ((Evaluator_Type)jcasType).casFeatCode_numCorrectAnswer);}
    
  /** setter for numCorrectAnswer - sets  
   * @generated */
  public void setNumCorrectAnswer(int v) {
    if (Evaluator_Type.featOkTst && ((Evaluator_Type)jcasType).casFeat_numCorrectAnswer == null)
      jcasType.jcas.throwFeatMissing("numCorrectAnswer", "edu.cmu.deiis.types.Evaluator");
    jcasType.ll_cas.ll_setIntValue(addr, ((Evaluator_Type)jcasType).casFeatCode_numCorrectAnswer, v);}    
  }

    