# Definition for singly-linked list.
class ListNode
    attr_accessor :val, :next
    def initialize(val)
        @val = val
        @next = nil
    end
  def to_num
    ret = @val.to_s
    next_node = @next
    while !next_node.nil? do
      ret = ret + '' + next_node.val.to_s
      next_node = next_node.next
    end
    ret
    ret.reverse.to_i
  end
end

def num_2_list_node(num)
  res = []
  num.to_s.split('').reverse.each do |i|
    # (res = i.to_s; next) if res.size == 0
    res << i.to_i
  end
  res
end

# @param {ListNode} l1
# @param {ListNode} l2
# @return {ListNode}
def add_two_numbers(l1, l2)
  num1 = l1.to_num
  num2 = l2.to_num
  num3 = num1 + num2
  num_2_list_node num3
end

def main
  l1 = ListNode.new(5)
  l1.next = ListNode.new(3)
  l1.next.next = ListNode.new(7)
  l2 = ListNode.new(4)
  l2.next = ListNode.new(7)
  l2.next.next = ListNode.new(2)
  p l1.to_num
  p l2.to_num
  l3 = add_two_numbers l1,l2
  p l3
end

main