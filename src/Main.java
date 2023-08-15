import java.util.*;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static List<List<Integer>> findAllPairs(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();

        for (int num : nums) {
            int complement = target - num;
            if (seen.contains(complement)) {
                result.add(Arrays.asList(num, complement));
            }
            seen.add(num);
        }
        if(result.isEmpty()){
            System.out.println("Not found");
//            return null;
        }

        return result;
    }

    public static int findSmallest(int[] arr, int k) {
        if (k > 0 && k <= arr.length) {
            Arrays.sort(arr);
            return arr[k - 1];
        }
        return -1;
    }

    public static List<List<String>> groupAnagrams(String[] words) {
        Map<String, List<String>> anagramGroups = new HashMap<>();

        for (String word : words) {
            char[] charArray = word.toCharArray();
            Arrays.sort(charArray);
            String sortedWord = new String(charArray);

            anagramGroups.computeIfAbsent(sortedWord, k -> new ArrayList<>()).add(word);
        }

        return new ArrayList<>(anagramGroups.values());
    }

    public static void main(String[] args) {
        int[] nums = {8, 7, 2, 5, 3, 1, 5, 3};
        int target = 10;
        List<List<Integer>> pairs = findAllPairs(nums, target);
        for (List<Integer> pair : pairs) {
            System.out.println("Pair found: (" + pair.get(0) + ", " + pair.get(1) + ")");
        };

        int[] arr = {7, 4, 6, 3, 9, 1};
        int k = 3;
        int kthSmallest = findSmallest(arr, k);
        System.out.println("k’th smallest array element is " + kthSmallest);

        String[] words = {
                "actors", "costar",
                "altered", "related",
                "auctioned", "education",
                "aspired", "despair",
                "mastering", "streaming",
                "recurd", "secured"
        };


    }
}