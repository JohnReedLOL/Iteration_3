/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 * This class represents a node in a conversation tree. Entities communicate by passing nodes back and forth.
 * Reply options cannot be null. No reply is represented by the empty String, "".
 * @author JohnReedLOL
 */
public class ConversationNode {

    private final String my_reply_to_what_you_said_to_me_;
    private final String your_first_reply_option_;
    private final String your_second_reply_option_;
    private final String your_third_reply_option_;
    private final String your_fourth_reply_option_;

    /**
     * This constructor will not allow a field to be set to null.
     */
    public ConversationNode(String s1, String s2, String s3, String s4, String s5) {
        if(s1 == null) {
            s1 = "";
        }
        if(s2 == null) {
            s2 = "";
        }
        if(s3 == null) {
            s3 = "";
        }
        if(s4 == null) {
            s4 = "";
        }
        if(s5 == null) {
            s5 = "";
        }
        my_reply_to_what_you_said_to_me_ = s1;
        your_first_reply_option_ = s2;
        your_second_reply_option_ = s3;
        your_third_reply_option_ = s4;
        your_fourth_reply_option_ = s5;
    }

    /**
     * @return the my_reply_to_what_you_said_to_me_
     */
    public String getMyReplyToWhatYouSaidToMe_() {
        return my_reply_to_what_you_said_to_me_;
    }

    /**
     * @return the your_first_reply_option_
     */
    public String getYourFirstReplyOption_() {
        return your_first_reply_option_;
    }

    /**
     * @return the your_second_reply_option_
     */
    public String getYourSecondReplyOption_() {
        return your_second_reply_option_;
    }

    /**
     * @return the your_third_reply_option_
     */
    public String getYourThirdReplyOption_() {
        return your_third_reply_option_;
    }

    /**
     * @return the your_fourth_reply_option_
     */
    public String getYourFourthReplyOption_() {
        return your_fourth_reply_option_;
    }
}
