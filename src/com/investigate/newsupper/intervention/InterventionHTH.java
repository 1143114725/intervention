package com.investigate.newsupper.intervention;

import java.util.ArrayList;
import java.util.List;

import android.R;
import android.R.integer;
import android.annotation.SuppressLint;
import android.content.Context;
import android.nfc.Tag;
import android.os.Handler;
import android.os.Message;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.investigate.newsupper.bean.Answer;
import com.investigate.newsupper.bean.AnswerMap;
import com.investigate.newsupper.bean.Question;
import com.investigate.newsupper.bean.QuestionItem;
import com.investigate.newsupper.global.MyApp;
import com.investigate.newsupper.util.BaseLog;
import com.investigate.newsupper.util.DialogUtil;
import com.investigate.newsupper.util.ListUtils;

/**
 * 干预-千金裘
 * 
 * @author EraJieZhang
 * @date 2020年4月26日22:03:12
 */
public class InterventionHTH {
	public static final String SURVEYID = "4145";
	public static final String B5 = "101";
	public static final String E19_a1 = "535";
	public static final String E19_b1 = "536";
	public static  int MSG_E19_b1 = 4;
	public static final int MSG_E19_b2 = 6;
	public static final int MSG_E19_b3 = 8;
	public static final String E19_a2 = "537";
	public static final String E19_b2 = "538";
	public static final String E19_a3 = "539";
	public static final String E19_b3 = "540";
	
	private int surveyId;
	private MyApp ma;
	private String uuid;

	private InterventionHTH(MyApp ma, String uuid) {
		super();
		this.surveyId = Integer.parseInt(SURVEYID);
		this.ma = ma;
		this.uuid = uuid;
	}
	
	
	
    private static InterventionHTH mInstance;

    public synchronized static InterventionHTH getInstance(MyApp ma, String uuid) {

        if (mInstance == null) {
            mInstance = new InterventionHTH(ma,uuid);
        }
        return mInstance;
    }
    
    
    public void settext(LinearLayout bodyView,int type){
    	
    	
    	Answer ans = getAnswer(B5);
    	
    	if (ans != null) {
    		double B5 = Double.parseDouble(ans.getAnswerMapArr().get(0).getAnswerText()) * 10000;
		
    		
    		
    		String anstext = new Double(B5 - type).intValue()+"";
    	
    		BaseLog.v("anstext---->>" + anstext);
    		
	    	if (bodyView != null && bodyView.getChildCount() != 0) {
	    		LinearLayout tl = (LinearLayout) bodyView.getChildAt(0);// 获取表格布局
	    		LinearLayout la = (LinearLayout) tl.getChildAt(0);// 获取第一行布局
	    		LinearLayout lac = (LinearLayout) la.getChildAt(0);// 获取第一行第一列布局
	    		LinearLayout rightA = (LinearLayout) lac.getChildAt(1);// 获取第一行第一列右侧布局
	    		EditText eTexta = (EditText) rightA.getChildAt(0);
	    		eTexta.setText(anstext);
	    		eTexta.setFocusable(false);
	    		eTexta.setEnabled(false);
	    	}
    	}

    }

	/**
	 * 获取答案
	 * 
	 * @param index
	 * @return
	 */
	public Answer getAnswer(String index) {
		Answer p4aans = ma.dbService.getAnswer(uuid, index);
		if (p4aans != null && p4aans.getAnswerMapArr() != null) {
			return p4aans;
		}
		return null;

	}
	
	
	
	/**
	 * B19B2   --->>40
	 * @param bodyView
	 * @param handler
	 * @param type
	 */
	public void InterventionB19B2(final LinearLayout bodyView,
			final Handler handler, final int type) {

		
		Answer ans = getAnswer(B5);
    	
    	if (ans != null) {
    		final double anserp4b = (Double.parseDouble(ans.getAnswerMapArr().get(0).getAnswerText()) * 10000 )- type;
		
    	
		for (int j = 0; j < bodyView.getChildCount(); j++) {
			if (bodyView.getChildAt(j) instanceof LinearLayout) {
				LinearLayout rb = (LinearLayout) bodyView.getChildAt(j);

				for (int k = 0; k < rb.getChildCount(); k++) {
					// LinearLayout rbA = (LinearLayout) rb.getChildAt(k);
					//
					// for (int i = 0; i < rbA.getChildCount(); i++) {
					if (rb.getChildAt(k) instanceof CheckBox) {
						CheckBox chb = (CheckBox) rb.getChildAt(k);
						chb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
							@Override
							public void onCheckedChanged(
									CompoundButton buttonView, boolean isChecked) {
								int sum = 0;

								for (int i = 0; i < bodyView.getChildCount(); i++) {
									if (bodyView.getChildAt(i) instanceof LinearLayout) {
										LinearLayout ll = (LinearLayout) bodyView
												.getChildAt(i);
										for (int l = 0; l < ll.getChildCount(); l++) {
											// LinearLayout llc =
											// (LinearLayout) ll
											// .getChildAt(l);
											// for (int m = 0; m < llc
											// .getChildCount(); m++) {
											if (ll.getChildAt(l) instanceof CheckBox) {

												CheckBox ck = (CheckBox) ll
														.getChildAt(l);
												if (ck.isChecked()) {
													QuestionItem item = (QuestionItem) ck
															.getTag();
													switch (item.itemValue) {case 0:
										                sum += 2000;
										                break;
										            case 1:
										                sum += 300;
										                break;
										            case 2:
										                sum += 400;
										                break;
										            case 3:
										                sum += 3900;
										                break;
										            case 4:
										                sum += 600;
										                break;
										            case 5:
										                sum += 700;
										                break;
										            case 6:
										                sum += 1200;
										                break;
										            case 7:
										                sum += 2500;
										                break;
										            case 8:
										                sum += 2000;
										                break;
										            case 9:
										                sum += 600;
										                break;
										            case 10:
										                sum += 500;
										                break;
										            case 11:
										                sum += 500;
										                break;
										            case 12:
										                sum += 300;
										                break;
										            case 13:
										                sum += 600;
										                break;
										            case 14:
										                sum += 800;
										                break;
										            case 15:
										                sum += 1500;
										                break;
										            case 16:
										                sum += 300;
										                break;
										            case 17:
										                sum += 1600;
										                break;
										            case 18:
										                sum += 500;
										                break;
										            case 19:
										                sum += 500;
										                break;
										            case 20:
										                sum += 600;
										                break;
										            case 21:
										                sum += 500;
										                break;
										            case 22:
										                sum += 400;
										                break;
										            case 23:
										                sum += 500;
										                break;
										            case 24:
										                sum += 600;
										                break;
										            case 25:
										                sum += 700;
										                break;
										            case 26:
										                sum += 1800;
										                break;
										            case 27:
										                sum += 900;
										                break;
										            case 28:
										                sum += 1800;
										                break;
										            case 29:
										                sum += 900;
										                break;
										            case 30:
										                sum += 800;
										                break;
										            case 31:
										                sum += 800;
										                break;
										            case 32:
										                sum += 150;
										                break;
										            case 33:
										                sum += 1000;
										                break;
										            case 34:
										                sum += 1500;
										                break;
										            case 35:
										                sum += 500;
										                break;
										            case 36:
										                sum += 300;
										                break;
										            case 37:
										                sum += 2000;
										                break;
										            case 38:
										                sum += 1900;
										                break;
										            case 39:
										                sum += 300;
										                break;
										            case 40:
										                sum += 600;
										                break;
										            default:
										                break;}
													// }
												}
											}

										}

									} else {
										if (bodyView.getChildAt(i) instanceof LinearLayout) {
											LinearLayout ll = (LinearLayout) bodyView
													.getChildAt(i);
											for (int j = 0; j < ll
													.getChildCount(); j++) {
												if (ll.getChildAt(j) instanceof CheckBox) {
													CheckBox ck = (CheckBox) ll
															.getChildAt(j);
													if (ck.isChecked()) {
														QuestionItem item = (QuestionItem) ck
																.getTag();
														switch (item.itemValue) {case 0:
											                sum += 2000;
											                break;
											            case 1:
											                sum += 300;
											                break;
											            case 2:
											                sum += 400;
											                break;
											            case 3:
											                sum += 3900;
											                break;
											            case 4:
											                sum += 600;
											                break;
											            case 5:
											                sum += 700;
											                break;
											            case 6:
											                sum += 1200;
											                break;
											            case 7:
											                sum += 2500;
											                break;
											            case 8:
											                sum += 2000;
											                break;
											            case 9:
											                sum += 600;
											                break;
											            case 10:
											                sum += 500;
											                break;
											            case 11:
											                sum += 500;
											                break;
											            case 12:
											                sum += 300;
											                break;
											            case 13:
											                sum += 600;
											                break;
											            case 14:
											                sum += 800;
											                break;
											            case 15:
											                sum += 1500;
											                break;
											            case 16:
											                sum += 300;
											                break;
											            case 17:
											                sum += 1600;
											                break;
											            case 18:
											                sum += 500;
											                break;
											            case 19:
											                sum += 500;
											                break;
											            case 20:
											                sum += 600;
											                break;
											            case 21:
											                sum += 500;
											                break;
											            case 22:
											                sum += 400;
											                break;
											            case 23:
											                sum += 500;
											                break;
											            case 24:
											                sum += 600;
											                break;
											            case 25:
											                sum += 700;
											                break;
											            case 26:
											                sum += 1800;
											                break;
											            case 27:
											                sum += 900;
											                break;
											            case 28:
											                sum += 1800;
											                break;
											            case 29:
											                sum += 900;
											                break;
											            case 30:
											                sum += 800;
											                break;
											            case 31:
											                sum += 800;
											                break;
											            case 32:
											                sum += 150;
											                break;
											            case 33:
											                sum += 1000;
											                break;
											            case 34:
											                sum += 1500;
											                break;
											            case 35:
											                sum += 500;
											                break;
											            case 36:
											                sum += 300;
											                break;
											            case 37:
											                sum += 2000;
											                break;
											            case 38:
											                sum += 1900;
											                break;
											            case 39:
											                sum += 300;
											                break;
											            case 40:
											                sum += 600;
											                break;
											            default:
											                break;}
													}
												}
											}
										}

									}
								}
//								int anserp4b = 10000;
//								if (type == 444) {
//									anserp4b = 20000;
//								}

								// 发送sum到UI上
								Message msg = new Message();
								int isreturn = 0;
								if (anserp4b < sum) {
									msg.obj = "您已花费" + sum + "元，已超出预算!";
									isreturn = 0;
								} else {
									msg.obj = "您已花费" + sum + "元，当前剩余金额"
											+ (int)(anserp4b - sum) + "元";
									isreturn = 1;
								}

								msg.arg1 = isreturn;
								msg.arg2 = sum;
								msg.what = type;

								handler.sendMessage(msg);
							}

						});
					}
				}
				// }
			}
		}
	}

	}

	
	/**
	 * B19B3----->>>  36
	 * @param bodyView
	 * @param handler
	 * @param type
	 */
	public void InterventionB19B3(final LinearLayout bodyView,
			final Handler handler, final int type) {
Answer ans = getAnswer(B5);
    	
    	if (ans != null) {
    		final double anserp4b = (Double.parseDouble(ans.getAnswerMapArr().get(0).getAnswerText()) * 10000 )- type;
		
		for (int j = 0; j < bodyView.getChildCount(); j++) {
			if (bodyView.getChildAt(j) instanceof LinearLayout) {
				LinearLayout rb = (LinearLayout) bodyView.getChildAt(j);

				for (int k = 0; k < rb.getChildCount(); k++) {
					// LinearLayout rbA = (LinearLayout) rb.getChildAt(k);
					//
					// for (int i = 0; i < rbA.getChildCount(); i++) {
					if (rb.getChildAt(k) instanceof CheckBox) {
						CheckBox chb = (CheckBox) rb.getChildAt(k);
						chb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
							@Override
							public void onCheckedChanged(
									CompoundButton buttonView, boolean isChecked) {
								int sum = 0;

								for (int i = 0; i < bodyView.getChildCount(); i++) {
									if (bodyView.getChildAt(i) instanceof LinearLayout) {
										LinearLayout ll = (LinearLayout) bodyView
												.getChildAt(i);
										for (int l = 0; l < ll.getChildCount(); l++) {
											// LinearLayout llc =
											// (LinearLayout) ll
											// .getChildAt(l);
											// for (int m = 0; m < llc
											// .getChildCount(); m++) {
											if (ll.getChildAt(l) instanceof CheckBox) {

												CheckBox ck = (CheckBox) ll
														.getChildAt(l);
												if (ck.isChecked()) {
													QuestionItem item = (QuestionItem) ck
															.getTag();
													switch (item.itemValue) {
										            case 0:
										                sum += 1000;
										                break;
										            case 1:
										                sum += 1500;
										                break;
										            case 2:
										                sum += 2000;
										                break;
										            case 3:
										                sum += 200;
										                break;
										            case 4:
										                sum += 200;
										                break;
										            case 5:
										                sum += 2000;
										                break;
										            case 6:
										                sum += 300;
										                break;
										            case 7:
										                sum += 700;
										                break;
										            case 8:
										                sum += 3000;
										                break;
										            case 9:
										                sum += 500;
										                break;
										            case 10:
										                sum += 400;
										                break;
										            case 11:
										                sum += 700;
										                break;
										            case 12:
										                sum += 1000;
										                break;
										            case 13:
										                sum += 1800;
										                break;
										            case 14:
										                sum += 2300;
										                break;
										            case 15:
										                sum += 1800;
										                break;
										            case 16:
										                sum += 1500;
										                break;
										            case 17:
										                sum += 600;
										                break;
										            case 18:
										                sum += 400;
										                break;
										            case 19:
										                sum += 500;
										                break;
										            case 20:
										                sum += 350;
										                break;
										            case 21:
										                sum += 300;
										                break;
										            case 22:
										                sum += 500;
										                break;
										            case 23:
										                sum += 600;
										                break;
										            case 24:
										                sum += 1400;
										                break;
										            case 25:
										                sum += 200;
										                break;
										            case 26:
										                sum += 1500;
										                break;
										            case 27:
										                sum += 100;
										                break;
										            case 28:
										                sum += 350;
										                break;
										            case 29:
										                sum += 350;
										                break;
										            case 30:
										                sum += 500;
										                break;
										            case 31:
										                sum += 500;
										                break;
										            case 32:
										                sum += 300;
										                break;
										            case 33:
										                sum += 900;
										                break;
										            case 34:
										                sum += 1800;
										                break;
										            case 35:
										                sum += 900;
										                break;
										            case 36:
										                sum += 200;
										                break;
										            default:
										                break;}
													// }
												}
											}

										}

									} else {
										if (bodyView.getChildAt(i) instanceof LinearLayout) {
											LinearLayout ll = (LinearLayout) bodyView
													.getChildAt(i);
											for (int j = 0; j < ll
													.getChildCount(); j++) {
												if (ll.getChildAt(j) instanceof CheckBox) {
													CheckBox ck = (CheckBox) ll
															.getChildAt(j);
													if (ck.isChecked()) {
														QuestionItem item = (QuestionItem) ck
																.getTag();
														switch (item.itemValue) {
											            case 0:
											                sum += 1000;
											                break;
											            case 1:
											                sum += 1500;
											                break;
											            case 2:
											                sum += 2000;
											                break;
											            case 3:
											                sum += 200;
											                break;
											            case 4:
											                sum += 200;
											                break;
											            case 5:
											                sum += 2000;
											                break;
											            case 6:
											                sum += 300;
											                break;
											            case 7:
											                sum += 700;
											                break;
											            case 8:
											                sum += 3000;
											                break;
											            case 9:
											                sum += 500;
											                break;
											            case 10:
											                sum += 400;
											                break;
											            case 11:
											                sum += 700;
											                break;
											            case 12:
											                sum += 1000;
											                break;
											            case 13:
											                sum += 1800;
											                break;
											            case 14:
											                sum += 2300;
											                break;
											            case 15:
											                sum += 1800;
											                break;
											            case 16:
											                sum += 1500;
											                break;
											            case 17:
											                sum += 600;
											                break;
											            case 18:
											                sum += 400;
											                break;
											            case 19:
											                sum += 500;
											                break;
											            case 20:
											                sum += 350;
											                break;
											            case 21:
											                sum += 300;
											                break;
											            case 22:
											                sum += 500;
											                break;
											            case 23:
											                sum += 600;
											                break;
											            case 24:
											                sum += 1400;
											                break;
											            case 25:
											                sum += 200;
											                break;
											            case 26:
											                sum += 1500;
											                break;
											            case 27:
											                sum += 100;
											                break;
											            case 28:
											                sum += 350;
											                break;
											            case 29:
											                sum += 350;
											                break;
											            case 30:
											                sum += 500;
											                break;
											            case 31:
											                sum += 500;
											                break;
											            case 32:
											                sum += 300;
											                break;
											            case 33:
											                sum += 900;
											                break;
											            case 34:
											                sum += 1800;
											                break;
											            case 35:
											                sum += 900;
											                break;
											            case 36:
											                sum += 200;
											                break;
											            default:
											                break;}
													}
												}
											}
										}

									}
								}
//								int anserp4b = 10000;
//								if (type == 444) {
//									anserp4b = 20000;
//								}

								// 发送sum到UI上
								Message msg = new Message();
								int isreturn = 0;
								if (anserp4b < sum) {
									msg.obj = "您已花费" + sum + "元，已超出预算!";
									isreturn = 0;
								} else {
									msg.obj = "您已花费" + sum + "元，当前剩余金额"
											+ (int)(anserp4b - sum) + "元";
									isreturn = 1;
								}

								msg.arg1 = isreturn;
								msg.arg2 = sum;
								msg.what = type;

								handler.sendMessage(msg);
							}

						});
					}
				}
				// }
			}
		}
    	}
	}
	
	
	/**
	 * B19B1---->>41
	 * @param bodyView
	 * @param handler
	 * @param type
	 */
	public void InterventionB19B1(final LinearLayout bodyView,
			final Handler handler, final int type) {

		
Answer ans = getAnswer(B5);
    	
    	if (ans != null) {
    		final double anserp4b = (Double.parseDouble(ans.getAnswerMapArr().get(0).getAnswerText()) * 10000 )- type;
		
    		
		for (int j = 0; j < bodyView.getChildCount(); j++) {
			if (bodyView.getChildAt(j) instanceof LinearLayout) {
				LinearLayout rb = (LinearLayout) bodyView.getChildAt(j);

				for (int k = 0; k < rb.getChildCount(); k++) {
					// LinearLayout rbA = (LinearLayout) rb.getChildAt(k);
					//
					// for (int i = 0; i < rbA.getChildCount(); i++) {
					if (rb.getChildAt(k) instanceof CheckBox) {
						CheckBox chb = (CheckBox) rb.getChildAt(k);
						chb.setOnCheckedChangeListener(new OnCheckedChangeListener() {
							@Override
							public void onCheckedChanged(
									CompoundButton buttonView, boolean isChecked) {
								int sum = 0;

								for (int i = 0; i < bodyView.getChildCount(); i++) {
									if (bodyView.getChildAt(i) instanceof LinearLayout) {
										LinearLayout ll = (LinearLayout) bodyView
												.getChildAt(i);
										for (int l = 0; l < ll.getChildCount(); l++) {
											// LinearLayout llc =
											// (LinearLayout) ll
											// .getChildAt(l);
											// for (int m = 0; m < llc
											// .getChildCount(); m++) {
											if (ll.getChildAt(l) instanceof CheckBox) {

												CheckBox ck = (CheckBox) ll
														.getChildAt(l);
												if (ck.isChecked()) {
													QuestionItem item = (QuestionItem) ck
															.getTag();
													switch (item.itemValue) {case 0:
										                sum += 2000;
										                break;
										            case 1:
										                sum += 300;
										                break;
										            case 2:
										                sum += 400;
										                break;
										            case 3:
										                sum += 3900;
										                break;
										            case 4:
										                sum += 600;
										                break;
										            case 5:
										                sum += 700;
										                break;
										            case 6:
										                sum += 1200;
										                break;
										            case 7:
										                sum += 2000;
										                break;
										            case 8:
										                sum += 2500;
										                break;
										            case 9:
										                sum += 2000;
										                break;
										            case 10:
										                sum += 600;
										                break;
										            case 11:
										                sum += 500;
										                break;
										            case 12:
										                sum += 500;
										                break;
										            case 13:
										                sum += 300;
										                break;
										            case 14:
										                sum += 600;
										                break;
										            case 15:
										                sum += 800;
										                break;
										            case 16:
										                sum += 1500;
										                break;
										            case 17:
										                sum += 300;
										                break;
										            case 18:
										                sum += 1600;
										                break;
										            case 19:
										                sum += 500;
										                break;
										            case 20:
										                sum += 500;
										                break;
										            case 21:
										                sum += 600;
										                break;
										            case 22:
										                sum += 500;
										                break;
										            case 23:
										                sum += 400;
										                break;
										            case 24:
										                sum += 500;
										                break;
										            case 25:
										                sum += 600;
										                break;
										            case 26:
										                sum += 700;
										                break;
										            case 27:
										                sum += 1800;
										                break;
										            case 28:
										                sum += 900;
										                break;
										            case 29:
										                sum += 1800;
										                break;
										            case 30:
										                sum += 900;
										                break;
										            case 31:
										                sum += 800;
										                break;
										            case 32:
										                sum += 800;
										                break;
										            case 33:
										                sum += 150;
										                break;
										            case 34:
										                sum += 1000;
										                break;
										            case 35:
										                sum += 1500;
										                break;
										            case 36:
										                sum += 500;
										                break;
										            case 37:
										                sum += 300;
										                break;
										            case 38:
										                sum += 2000;
										                break;
										            case 39:
										                sum += 1900;
										                break;
										            case 40:
										                sum += 300;
										                break;
										            case 41:
										                sum += 600;
										                break;
										            default:
										                break;}
													// }
												}
											}

										}

									} else {
										if (bodyView.getChildAt(i) instanceof LinearLayout) {
											LinearLayout ll = (LinearLayout) bodyView
													.getChildAt(i);
											for (int j = 0; j < ll
													.getChildCount(); j++) {
												if (ll.getChildAt(j) instanceof CheckBox) {
													CheckBox ck = (CheckBox) ll
															.getChildAt(j);
													if (ck.isChecked()) {
														QuestionItem item = (QuestionItem) ck
																.getTag();
														switch (item.itemValue) {case 0:
											                sum += 2000;
											                break;
											            case 1:
											                sum += 300;
											                break;
											            case 2:
											                sum += 400;
											                break;
											            case 3:
											                sum += 3900;
											                break;
											            case 4:
											                sum += 600;
											                break;
											            case 5:
											                sum += 700;
											                break;
											            case 6:
											                sum += 1200;
											                break;
											            case 7:
											                sum += 2000;
											                break;
											            case 8:
											                sum += 2500;
											                break;
											            case 9:
											                sum += 2000;
											                break;
											            case 10:
											                sum += 600;
											                break;
											            case 11:
											                sum += 500;
											                break;
											            case 12:
											                sum += 500;
											                break;
											            case 13:
											                sum += 300;
											                break;
											            case 14:
											                sum += 600;
											                break;
											            case 15:
											                sum += 800;
											                break;
											            case 16:
											                sum += 1500;
											                break;
											            case 17:
											                sum += 300;
											                break;
											            case 18:
											                sum += 1600;
											                break;
											            case 19:
											                sum += 500;
											                break;
											            case 20:
											                sum += 500;
											                break;
											            case 21:
											                sum += 600;
											                break;
											            case 22:
											                sum += 500;
											                break;
											            case 23:
											                sum += 400;
											                break;
											            case 24:
											                sum += 500;
											                break;
											            case 25:
											                sum += 600;
											                break;
											            case 26:
											                sum += 700;
											                break;
											            case 27:
											                sum += 1800;
											                break;
											            case 28:
											                sum += 900;
											                break;
											            case 29:
											                sum += 1800;
											                break;
											            case 30:
											                sum += 900;
											                break;
											            case 31:
											                sum += 800;
											                break;
											            case 32:
											                sum += 800;
											                break;
											            case 33:
											                sum += 150;
											                break;
											            case 34:
											                sum += 1000;
											                break;
											            case 35:
											                sum += 1500;
											                break;
											            case 36:
											                sum += 500;
											                break;
											            case 37:
											                sum += 300;
											                break;
											            case 38:
											                sum += 2000;
											                break;
											            case 39:
											                sum += 1900;
											                break;
											            case 40:
											                sum += 300;
											                break;
											            case 41:
											                sum += 600;
											                break;
											            default:
											                break;}
													}
												}
											}
										}

									}
								}
//								int anserp4b = 10000;
//								if (type == 444) {
//									anserp4b = 20000;
//								}

								// 发送sum到UI上
								Message msg = new Message();
								int isreturn = 0;
								if (anserp4b < sum) {
									msg.obj = "您已花费" + sum + "元，已超出预算!";
									isreturn = 0;
								} else {
									msg.obj = "您已花费" + sum + "元，当前剩余金额"
											+ (int)(anserp4b - sum) + "元";
									isreturn = 1;
								}

								msg.arg1 = isreturn;
								msg.arg2 = sum;
								msg.what = type;

								handler.sendMessage(msg);
							}

						});
					}
				}
				// }
			}
		}
    	}
	}
	
}
