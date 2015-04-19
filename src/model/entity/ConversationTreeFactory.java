/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.entity;

/**
 * This class contains static functions for generating conversation trees.
 * @author johnmichaelreed2
 */
public class ConversationTreeFactory {
    public static ConversationTree makeMerchantConversationTree() {
        final ConversationTree tree = new ConversationTree();
        tree.setFirstNodeInTreeIfWasNotSpecifiedInConscructor(
                new ConversationNode("Hi. Welcome to my store!", 
                        "What are you selling?", "How goes it?", 
                        "I am sick of your store. Prepare to die, merchant.", "Your store sucks eggs."));
        tree.addNodeUnderFirstReplyOption(
                new ConversationNode("Take a look at my store front!", 
                        "", "", "", ""));
        tree.addNodeUnderThirdReplyOption(
                new ConversationNode("","","","",""
                )
        );
        tree.addNodeUnderFourthReplyOption(
                new ConversationNode("","","","",""
                )
        );
        tree.addNodeUnderSecondReplyOption(
                new ConversationNode("Not so good. No one is buying anything.", 
                        "I'll buy something. Show me your wares.", "Well I won't be buying anything either.", "", ""));
        tree.setCurrentNodeToChildNode2();
        tree.addNodeUnderFirstReplyOption(
                new ConversationNode("Take a look at my store front!", 
                        "", "", "", ""));
        tree.addNodeUnderSecondReplyOption(
                new ConversationNode("You suck eggs.","","","",""
                )
        );
        tree.setCurrentNodeToFirstNode(); // The tree pointer should start out at the top of the tree.
        return tree;
    }
    public static ConversationTree makeMonsterConversationTree() {
        final ConversationTree tree = new ConversationTree();
        tree.setFirstNodeInTreeIfWasNotSpecifiedInConscructor(
                new ConversationNode("Hi. Are you edible? I love people who are edible.", 
                        "Me? No. Not edible at all.", "Kinda edible. Why do you ask?", 
                        "I love monsters who are edible. Are you edible?", "Prepare to die, vile beast."));
        tree.addNodeUnderFirstReplyOption(
                new ConversationNode("Aww. Guess I'll have to go ask around until I find someone else to eat.", 
                        "", "", "", ""));
        tree.addNodeUnderSecondReplyOption(
                new ConversationNode("I am going to kill and eat you now.",
                        "","","",""
                )
        );
        tree.addNodeUnderThirdReplyOption(
                new ConversationNode("No. Not edible at all. *runs*",
                        "","","",""
                )
        );
        tree.addNodeUnderFourthReplyOption(
                new ConversationNode("I am going to kill and eat you now.",
                        "","","",""
                )
        );
        tree.setCurrentNodeToFirstNode(); // The tree pointer should start out at the top of the tree.
        return tree;
    }
    public static ConversationTree makeVillagerConversationTree() {
        final ConversationTree tree = new ConversationTree();
        tree.setFirstNodeInTreeIfWasNotSpecifiedInConscructor(
                new ConversationNode("Hi. How's it going?", 
                        "Pretty good. U?", "Terrible. My mother died and my father was eaten by monsters.", 
                        "I don't really want to talk to you. Prepare to die.", "Du, du hast, Du hast mich."));
        tree.addNodeUnderFirstReplyOption(
                new ConversationNode("Pretty good. Just villaging and farming and what not.", 
                        "", "", "", ""));
        tree.addNodeUnderSecondReplyOption(
                new ConversationNode("I am so sorry to hear that.",
                        "","","",""
                )
        );
        tree.addNodeUnderThirdReplyOption(
                new ConversationNode("Ahhhhhhh!!!!",
                        "","","",""
                )
        );
        tree.addNodeUnderFourthReplyOption(
                new ConversationNode("What the f*ck is wrong with you? This is a medevil fantasy, not f*cking Rammstein.",
                        "","","",""
                )
        );
        tree.setCurrentNodeToFirstNode(); // The tree pointer should start out at the top of the tree.
        return tree;
    }
    public static ConversationTree makeAvatarConversationTree() {
        return makeVillagerConversationTree();
    }
}
