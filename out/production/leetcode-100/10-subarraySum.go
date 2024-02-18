package main

import "fmt"

func subarraySum(nums []int, k int) int {
	count, pre := 0, 0
	// map 键是前n个元素的和，值是和的出现次数
	m := map[int]int{}
	m[0] = 1
	//for循环就是遍历一遍数组，求出map哈希表
	for i := 0; i < len(nums); i++ {
		pre += nums[i]
		// 考虑以 i 结尾的和为 k 的连续子数组个数时只要统计 前面有多少个和为pre[i]−k的即可
		if value, isPresent := m[pre-k]; isPresent {
			count += value
		}
		m[pre] += 1
	}
	return count
}
func main() {
	nums := []int{1, 2, 3}
	k := 3
	fmt.Println(subarraySum(nums, k))
}
