package com.anucodes.assesmentoneclick

//function that returns the list that has the intersection of all the three lists
fun intersectionFun(nums1: List<Int>,
                 nums2: List<Int>,
                 nums3: List<Int>
): List<Int> {
    //intersect function takes the sets so we cast the list into the set using list.toSet()
    val ans = nums1.toSet().intersect(nums2.toSet()).intersect(nums3.toSet())
    return ans.toList()
}


//function that returns the list that has the union of all the three lists.
fun unionFun(nums1: List<Int>,
                 nums2: List<Int>,
                 nums3: List<Int>
):List<Int>{
    //union function takes the sets so we cast the list into the set using list.toSet()
    val ans = nums1.toSet().union(nums2.toSet()).union(nums3.toSet())
    return ans.toList()
}


//for finding the maximum of numbers from the list.
fun maxi(nums1: List<Int>,
         nums2: List<Int>,
         nums3: List<Int>
): Int {
    //combining the lists so that we don't have to find the maximum number separately for each list.
    val combine = nums1+nums2+nums3
    return combine.max()
}