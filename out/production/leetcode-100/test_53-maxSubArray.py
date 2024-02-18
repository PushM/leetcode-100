import unittest
from maxSubArray import Solution

class TestSolution(unittest.TestCase):

    def test_maxSubArray(self):
        solution = Solution()

        # Test case 1
        nums1 = [-2, 1, -3, 4, -1, 2, 1, -5, 4]
        expected1 = 6
        self.assertEqual(solution.maxSubArray(nums1), expected1)

        # Test case 2
        nums2 = [1]
        expected2 = 1
        self.assertEqual(solution.maxSubArray(nums2), expected2)

        # Test case 3
        nums3 = [0]
        expected3 = 0
        self.assertEqual(solution.maxSubArray(nums3), expected3)

        # Test case 4
        nums4 = [-1]
        expected4 = -1
        self.assertEqual(solution.maxSubArray(nums4), expected4)

        # Test case 5
        nums5 = [-100000]
        expected5 = -100000
        self.assertEqual(solution.maxSubArray(nums5), expected5)

if __name__ == '__main__':
    unittest.main()