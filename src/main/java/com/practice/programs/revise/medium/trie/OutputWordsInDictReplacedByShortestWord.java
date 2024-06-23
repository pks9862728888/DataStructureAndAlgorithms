package com.practice.programs.revise.medium.trie;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class OutputWordsInDictReplacedByShortestWord {

    public static void main(String[] args) {
        String res = replaceWords(Arrays.asList("df qbhrb wxwqowktgqjzxmdqcwnnssxkbxmprqlypbudzfwy hvrsgkskwprrlqextilfrmhi ouikh znhlvhazrticoqkofiouorbwwankivwefxwlszsrrisk hwhqhicxkbgnizkvyzhfvtsyzqaculq xvfooyfjhwtgdsoo hjgtwsvoclikbfaytjlqukmogqtddqveuj tguju xdjrwgaekuobceprddlfyaarwjfzu blylutzwkgkmwfotzfnxiknvydi hkjkxqbgux qfpqlvidpobfugttnqopaxahuvgzthrehdzrixoib qwbdjnvqr gdc lnichwnbeh dbevutzjpkvrbnwljavjyhpqhgdaygsqbbniemy pywjlkmwsahdalcldpszksxqpchoetbcvyptrluhvkcb aovxyolgnxvewgwyfgttufhcyjpnzdisikpttmqepr wmcvgfkbozwxzcpukqqhajhahlbutwrzwe tkcqpgqcnlt ogdswhgcx wvoboubrxkghooskoakkewavtrzq qviwgvztoumxdxrisabbxbzvwdndt xcwtsfofqn azvmfflnfvegrgladbtmvsqwny ilovevtfprkhvlwxyz pjowckbaqbcddndvaadopmkdnllodxtswqhbqgil spcktm ogaekzhzvmsorhydivrsdlfhnnwjdpei r nljycavaeiibfugpubigicvgedwfedcdbkjerinqv acpxadzepfzynpenjostvyobicjfbpptrrsdmzgyagcghhbsm rdcajvsejbtguygmxcbxgrfypogtaaktbcq zrdoechwmhoziwbfrddbsclkwu ldgtvbkbunxkurrulennyegk tvanjxerulqih atslh gzdkjrfpinxydcfcz gpqlsitmgujtoshrudkescevlejwdwoeryowdobygzokknnms iapkbjlktlrykwoofzdshyjnmmqy zjfwwxiymvjloqu mrxtoopkcdcz uazdujhrvvkonclnpdijfedjmpqazuwcejlfjb pyymyyclyazfogyj qkruqdsbfwf lxfztmskntdiylpgnrtfttevpbeawgoygszkrmbehh fuwmdyocxy vxsstixdkftrfxzryzwomlighjhmvogxboboatbaetnvxsmwrv qtewmiettvyakvvrxfljbkhswtfsqkquzxemhncuxrnzucvukx t bhzdvhemqtosbvcnbjpmuozvodovtijzysftggwdmsyqonue ijfxksvvlvpcyxmpyceflnwugb jsgtnpbjxzjvijspcprjserzgznelmxijqfrigvjj weebrjnoirsiwigobcwakgkr mmhdwekzhmmboonyeqzcxcrzmdmacahh m vhuwzdzaynyfvchvigbcjcivwxekrhzuyutszuvqjqlduor mwzqlpbgwpxcdqmxrtlogshgnnktspivslegyphhg xdhkmxtyxhktezekujygl yscldyclrm rptjondnxvnnzgtlefmzrzcvkfsnoyn ssrlxsvsdtw si fwjelncjzhqfxvflspyvuxyo zrqfabnvqejehrlaahejielahquulvqotzam acgoulvudgkzfrltlgzmaiqpqcdxcawdqm tx tpetsciboknylcilwtvju zustwjdowupnftqebam xbvuvnofrggozruznccgtcyakffoctziffkgihyeoow rwzxkclogpkguotyorimzsyzjg vjpbhpdhblnjbjidjfdi jwgnkxdjhzz oaxshxfaelvmpvyyzhzncytkocprcvboc jjkxrhppcjwffkwtwmdafpxukvdeapxreffkoadpgtnmfmnwab snwvzzaccatemhl ufndpsrhczzufmksltteywfmaztrdyrxxoanwxsyhl unndhvbzsbtnjbqwqagnpzwqzctva usgbzeaucxtwjqhnbbywjkxgknybaqqkozxnxigkpdiubgro zkqdalpiyxxov nmrgfqoejqeo uujgzvfzb gqbkzoczhxguchsl azhfkfluwuaghkbxdyqpvfprajts zysziqebgdppxflezflse bwniyvwjnjfbjp iftksyndoslwppymrsdocvkuograuyshpgkftiifaytekd qdiusbwjmmvnfryfbhglcvnsxqfmjmtxpnw  ".split(" ")),
                "wvoboubrxkghooskoakkewavtrzqedgknvqqrtyqjderlpfuysjejljrmaizbobypzrchpsrapqqjcfnuceyoorrdzkyyovjfre pywjlkmwsahdalcldpszksxqpchoetbcvyptrluhvkcbfdcdvkobytvwqtrdzrgrhpdzo causnfitrnusvvhipebmhhyaqqfsnnaoulufwynnynsdttlaxgdsonqauovuxvulwqoifr cbgckkuoxbelwtychzeugrdakbcpqmlgsmdjjvlmezexkgbbmscwbvgdkgfoauxfrumlvggbamaftybwxgehhcxuqaciduj mmhdwekzhmmboonyeqzcxcrzmdmacahh lxfztmskntdiylpgnrtfttevpbeawnhfjanxptskkqdfmuygpspmaqmerwjevxrovkau ldgtvbkbunxkurrulennyegkyeiykypugkjyijaddiimilunytwanwnshquoz qtewmiettvyakvvrxfljbkhswtfsqkquzxemhncuxrnzucvukxjpyuoqewaftjpmlbdfbwnxnomssgtklduxsmuk csvctthocrlje usgbzeaucxtwjqhnxqvso fuwmdyocxygpeifiyufwwvvhmlibuqkpjymjiqndeymby cwmkicdjsawswtbcytxdoxhpwtdaqpbhccyvhqwtcympk hwhqhicxkbgnizkvyzhfvtsyzqaculqezrfb gqbkzoczhxguchsltgjvtriiovbzcfcmqrrhgaiytcjpikyheuxpjjqnebzmtyzolrhgaiqsevqspmzjkqifcijeox jwgnkxdjhzzbowcfxwi eiqtezdebxcqcwxptbsgdctcgkosidpv iftksyndoslwppymrsdocvkuograuyshpgkftiifaytekdxuw ekufoyshmddodwdyswdbwjyecbrotggxsrorcouzretpjfhocvfamvvawv ");
        String expRes = "wvoboubrxkghooskoakkewavtrzq pywjlkmwsahdalcldpszksxqpchoetbcvyptrluhvkcb causnfitrnusvvhipebmhhyaqqfsnnaoulufwynnynsdttlaxgdsonqauovuxvulwqoifr cbgckkuoxbelwtychzeugrdakbcpqmlgsmdjjvlmezexkgbbmscwbvgdkgfoauxfrumlvggbamaftybwxgehhcxuqaciduj m lxfztmskntdiylpgnrtfttevpbeawnhfjanxptskkqdfmuygpspmaqmerwjevxrovkau ldgtvbkbunxkurrulennyegk qtewmiettvyakvvrxfljbkhswtfsqkquzxemhncuxrnzucvukx csvctthocrlje usgbzeaucxtwjqhnxqvso fuwmdyocxy cwmkicdjsawswtbcytxdoxhpwtdaqpbhccyvhqwtcympk hwhqhicxkbgnizkvyzhfvtsyzqaculq gqbkzoczhxguchsl jwgnkxdjhzz eiqtezdebxcqcwxptbsgdctcgkosidpv iftksyndoslwppymrsdocvkuograuyshpgkftiifaytekd ekufoyshmddodwdyswdbwjyecbrotggxsrorcouzretpjfhocvfamvvawv ";
        boolean equals = res.equals(expRes);
        System.out.println(equals);
        System.out.println(res);
        System.out.println(expRes);
    }

    /**
     * Replace word with prefix, if multiple words exists, return word having lowest prefix
     * TC: O(no words * len(words)), or O(L) where L = length of sentence
     * AS: O(no words * len(words))
     * Input:
     * cat bat rat
     * the cattle was battled by the rattle
     * Output:
     * the cat was bat by the rat
     * Concepts:
     * TRIE
     * PREFIX_SEARCH
     */
    public static String replaceWords(List<String> dict, String sentence){
        // Form trie ds with the words in dict
        TrieNode root = buildTrie(dict);
        // Iterate through words in sentence & replace words
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            Optional<String> shortestPrefixWord = TrieNode.findPrefixWord(root, word);
            if (shortestPrefixWord.isPresent()) {
                words[i] = shortestPrefixWord.get();
            }
        }
        // Reconstruct string
        String reconstructedWord = String.join(" ", words);
        return sentence.endsWith(" ") ? reconstructedWord + " " : reconstructedWord;
    }

    private static TrieNode buildTrie(List<String> words) {
        TrieNode root = new TrieNode();
        for (String word: words) {
            TrieNode.addWord(root, word);
        }
        return root;
    }

    private static class TrieNode {
        char ch;
        TrieNode[] next;
        boolean end;
        public TrieNode() {
            this.next = new TrieNode[26];
        }
        public static void addWord(TrieNode root, String word) {
            TrieNode prev = root;
            int n = word.length();
            for (int i = 0; i < n; i++) {
                char ch = word.charAt(i);
                int idx = ch - 'a';
                if (prev.next[idx] == null) {
                    prev.next[idx] = new TrieNode();
                }
                prev = prev.next[idx];
            }
            prev.end = true;
        }
        public static Optional<String> findPrefixWord(TrieNode root, String word) {
            int n = word.length();
            TrieNode prev = root;
            for (int i = 0; i < n; i++) {
                if (prev.isEnd()) { // condition to return word having lowest prefix
                    return Optional.of(word.substring(0, i));
                }
                // Search if any word with ch exists
                char ch = word.charAt(i);
                TrieNode nextNode = prev.get(ch);
                if (nextNode != null) {
                    prev = nextNode;
                } else {
                    break;
                }
            }
            return Optional.empty();
        }

        public TrieNode get(char ch) {
            return next[ch - 'a'];
        }
        public boolean isEnd() {
            return this.end;
        }
    }
}
