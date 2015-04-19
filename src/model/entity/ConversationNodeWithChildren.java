/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 * This class represents a node in a conversation (1 reply and 4 reply options), 
 * plus up to 4 interconnected child nodes for use in a tree structure which represents the entire conversation.
 * @author JohnReedLOL
 */
public class ConversationNodeWithChildren {

        private final ConversationNode conversationNode_;
        
        /**
         * These are null when the conversation node has no reply nodes underneath (or above) it.
         */
        private ConversationNodeWithChildren parent_;
        private ConversationNodeWithChildren childNode1_;
        private ConversationNodeWithChildren childNode2_;
        private ConversationNodeWithChildren childNode3_;
        private ConversationNodeWithChildren childNode4_;

        ConversationNodeWithChildren(ConversationNode conversation_node) {
            conversationNode_ = conversation_node;
            parent_ = null;
            childNode1_ = null;
            childNode2_ = null;
            childNode3_ = null;
            childNode4_ = null;
        }

        public ConversationNode getConversationNode_() {
            return conversationNode_;
        }

        public ConversationNodeWithChildren getChildNode1_() {
            return childNode1_;
        }

        public void setChildNode1_(ConversationNodeWithChildren childNode1_) {
            this.childNode1_ = childNode1_;
        }

        public ConversationNodeWithChildren getChildNode2_() {
            return childNode2_;
        }

        public void setChildNode2_(ConversationNodeWithChildren childNode2_) {
            this.childNode2_ = childNode2_;
        }

        public ConversationNodeWithChildren getChildNode3_() {
            return childNode3_;
        }

        public void setChildNode3_(ConversationNodeWithChildren childNode3_) {
            this.childNode3_ = childNode3_;
        }

        public ConversationNodeWithChildren getChildNode4_() {
            return childNode4_;
        }

        public void setChildNode4_(ConversationNodeWithChildren childNode4_) {
            this.childNode4_ = childNode4_;
        }
    }
