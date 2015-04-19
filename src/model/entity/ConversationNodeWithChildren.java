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
        private ConversationNodeWithChildren parentNode_;
        private ConversationNodeWithChildren childNode1_;
        private ConversationNodeWithChildren childNode2_;
        private ConversationNodeWithChildren childNode3_;
        private ConversationNodeWithChildren childNode4_;

        /**
         * All children are initially null. Parent is null too.
         * @param conversation_node - the Node that this conversation tree element wraps
         */
        ConversationNodeWithChildren(ConversationNode conversation_node) {
            conversationNode_ = conversation_node;
            parentNode_ = null;
            childNode1_ = null;
            childNode2_ = null;
            childNode3_ = null;
            childNode4_ = null;
        }
        
        /**
         * All children are initially null. Parent is set in constructor.
         * @param conversation_node - the Node that this conversation tree element wraps
         * @param parent - the parent of this node in the tree. The node that leads to this node in a conversation.
         */
        ConversationNodeWithChildren(ConversationNode conversation_node, ConversationNodeWithChildren parent) {
            conversationNode_ = conversation_node;
            parentNode_ = parent;
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

    public ConversationNodeWithChildren getParentNode_() {
        return parentNode_;
    }
    }
