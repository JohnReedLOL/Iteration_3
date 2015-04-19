/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

import application.Application;

/**
 * This class represents an entire conversation which is composed of nodes. ConversationTree is
 * composed of zero or more ConversationNodeWithChildren objects. Each node consists of one reply
 * and four reply options. Empty strings in a node denote no reply.
 *
 * Internally, this tree uses a reference to keep track of the current node. When nodes are added
 * under one of the four reply options, The reference is updated to point to that child node newly
 * added to the bottom of the tree. New Conversation nodes cannot be added to the middle of the
 * tree, they can only be added at the bottom.
 *
 * @author JohnReedLOL
 */
public class ConversationTree {

    private ConversationNodeWithChildren firstNode_ = null;
    /**
     * This field is a pointer (reference) to the node in the tree that we are currently looking at.
     * This reference can be used to go up the tree to the parent node or down the tree to one of
     * the child nodes. As nodes are added to the tree, the reference will point to those nodes.
     */
    private ConversationNodeWithChildren currentNodeReference_;

    ConversationTree() {
        firstNode_ = null;
        currentNodeReference_ = firstNode_;
    }

    ConversationTree(ConversationNodeWithChildren firstNode) {
        firstNode_ = firstNode;
        currentNodeReference_ = firstNode_;
    }

    /**
     * ONLY USE THIS METHOD IF YOU DID NOT SPECIF A FIRST NODE IN THE CONSTRUCTOR.
     *
     * @param top_parent - Node to be located at the top of the tree.
     */
    void setFirstNodeInTreeIfWasNotSpecifiedInConscructor(ConversationNode top_parent) {
        Application.check(firstNode_ == null,
                "This method can only be used if the first node was not specified in the Tree's constructor");
        Application.check(currentNodeReference_ == firstNode_, "This method can only be used right after the Tree's initialization, "
                + "when the current node is still pointing to the first parent node in the tree");
        firstNode_ = new ConversationNodeWithChildren(top_parent);
        currentNodeReference_ = firstNode_;
    }

    void addNodeUnderFirstReplyOption(ConversationNode to_add) {
        Application.check(currentNodeReference_ != null);
        Application.check(currentNodeReference_.getChildNode1_() == null);
        currentNodeReference_.setChildNode1_(currentNodeReference_ = new ConversationNodeWithChildren(to_add));
    }

    void addNodeUnderSecondReplyOption(ConversationNode to_add) {
        Application.check(currentNodeReference_ != null);
        Application.check(currentNodeReference_.getChildNode2_() == null);
        currentNodeReference_.setChildNode2_(currentNodeReference_ = new ConversationNodeWithChildren(to_add));
    }

    void addNodeUnderThirdReplyOption(ConversationNode to_add) {
        Application.check(currentNodeReference_ != null);
        Application.check(currentNodeReference_.getChildNode3_() == null);
        currentNodeReference_.setChildNode3_(currentNodeReference_ = new ConversationNodeWithChildren(to_add));
    }

    void addNodeUnderFourthReplyOption(ConversationNode to_add) {
        Application.check(currentNodeReference_ != null);
        Application.check(currentNodeReference_.getChildNode4_() == null);
        currentNodeReference_.setChildNode4_(currentNodeReference_ = new ConversationNodeWithChildren(to_add));
    }

    /**
     * Gets the height of this conversation tree. If the tree is completely empty (no initial node
     * specified in constructor), its height is zero. Else, if the tree has the initial node at the
     * top of the tree but no other nodes, its height it one. Else, its height is the number of
     * layers in the tree, with the first node corresponding to the first layer.
     *
     * @return
     */
    int getHeight() {
        if (firstNode_ == null) {
            Application.check(currentNodeReference_ == firstNode_);
            return 0;
        } else {
            if (firstNode_.getChildNode1_() == null && firstNode_.getChildNode2_() == null
                    && firstNode_.getChildNode3_() == null && firstNode_.getChildNode4_() == null) {
                Application.check(currentNodeReference_ == firstNode_);
                return 1;
            }
            else {
                // This reference starts at the bottom of the tree and works its way up.
                ConversationNodeWithChildren tree_height_iterator = currentNodeReference_;
                throw new UnsupportedOperationException("This function is not yet availible");
            }
        }
    }

    public ConversationNodeWithChildren getFirstNode_() {
        return firstNode_;
    }
}
