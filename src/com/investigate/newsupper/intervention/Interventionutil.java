package com.investigate.newsupper.intervention;

import android.content.Context;
import android.view.View;

import com.investigate.newsupper.bean.Answer;
import com.investigate.newsupper.bean.AnswerMap;
import com.investigate.newsupper.global.MyApp;
import com.investigate.newsupper.util.BaseLog;
import com.investigate.newsupper.util.DialogUtil;
import com.investigate.newsupper.util.Util;

import java.util.ArrayList;

/**
 * 常驻干预
 * @author EraJi
 * @date 2020年4月26日22:03:12
 *
 */
public class Interventionutil {
	public  int surveyId;
	public  MyApp ma;
	public  String uuid;
//	SE10：184
//	RE10：319
//	E18：389
//	GU8a：408【插入位置】  
//	GU8.1：409【显示结果】
//
//	QU8a：427【插入位置】
//	QU8.2：428【显示结果】
//	4177和4178

    /*********** 千金裘 *********************/
    public static final int SURVEY_ID_DTG1 = 4177;
    public static final int SURVEY_ID_DTG2 = 4178;

    public static final int INTERVENTION_SE10 = 184;
    public static final int INTERVENTION_RE10 = 319;
    public static final int INTERVENTION_E18 = 389;
    public static final int INTERVENTION_SU81 = 409;
    public static final int INTERVENTION_SU8a = 408;
    public static final int INTERVENTION_QU8a = 427;
    public static final int INTERVENTION_QU82 = 428;


    private static Interventionutil mInstance;

    public synchronized static Interventionutil getInstance(int surveyId, MyApp ma, String uuid) {

        if (mInstance == null) {
            mInstance = new Interventionutil(surveyId,ma,uuid);
        }else{
            mInstance.surveyId = surveyId;
            mInstance.ma = ma;
            mInstance.uuid = uuid;
        }
        return mInstance;
    }

    public Interventionutil(int surveyId, MyApp ma, String uuid) {
		super();
		this.surveyId = surveyId;
		this.ma = ma;
		this.uuid = uuid;
	}
	
	/**
	 * 获取答案
	 * 
	 * @param index
	 * @return
	 */
	public Answer getanswer(String index) {
		Answer p4aans = ma.dbService.getAnswer(uuid, index);
		if (p4aans != null && p4aans.getAnswerMapArr() != null) {
			return p4aans;
		}
		return null;

	}
	
	public String getRowText(String str){
		String rowtext = "";
		String s[] = str.split("@@");
		
		Answer ans = getanswer(s[0]);
		if (ans != null) {
			for (int i = 0; i < ans.getAnswerMapArr().size(); i++) {
				AnswerMap ansmaperlist = ans.getAnswerMapArr().get(i);
				if (ansmaperlist.getAnswerValue().equals(s[1])) {
					rowtext = ansmaperlist.getAnswerText();
				}
			}
		}
		return rowtext;
	}


    /**
     * 动态生成题干 后面调用
     * @param qIndex
     * @param vs
     */
    public void createQuestionBodyViewBefore(int qIndex, ArrayList<View> vs) {

        switch (surveyId) {
            case SURVEY_ID_DTG1:
            case SURVEY_ID_DTG2:
                InterventionDTG(qIndex, vs);
                break;

            default:
                break;
        }
    }

    private void InterventionDTG(int qIndex,ArrayList<View> vs) {



        switch (qIndex) {
            case INTERVENTION_SU81:

                InterventionDTG.getInstance(surveyId,ma, uuid).insertsortO(vs, INTERVENTION_E18+"", INTERVENTION_SU8a+"");

                break;
            case INTERVENTION_QU82:

            	InterventionDTG.getInstance(surveyId,ma, uuid).insertsortO(vs, INTERVENTION_SU81+"", INTERVENTION_QU8a+"");

                break;


            default:
                break;
        }

    }




    /**
     * 下一页的时候判断
     */
    public boolean nextpage(int qIndex, ArrayList<View> vs, Context context, String uuid){

    	BaseLog.v("nextpage");
    	boolean isresult = true;
        switch (surveyId) {
            case SURVEY_ID_DTG1:
            case SURVEY_ID_DTG2:

//                if (INTERVENTION_E18 == qIndex) {
//                    String  result = InterventionDTG.getInstance(surveyId, ma, uuid)
//                            .sortCorrespondence(INTERVENTION_E18, INTERVENTION_SE10,"和SE10答案排序不一致！",0);
//                    if(!Util.isEmpty(result)){
//                        DialogUtil.newdialog(context, result);
//                        isresult = false;
//                    }
//                    String  result2 = InterventionDTG.getInstance(surveyId, ma, uuid)
//                            .sortCorrespondence(INTERVENTION_E18, INTERVENTION_RE10,"和RE10答案排序不一致！",1);
//                    if(!Util.isEmpty(result2)){
//                        DialogUtil.newdialog(context, result2);
//                        isresult = false;
//                    }
//                }

                break;

            default:
                break;
        }
        return isresult;
    }
}
