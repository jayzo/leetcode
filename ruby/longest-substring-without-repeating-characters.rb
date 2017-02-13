
# @param {String} s
# @return {Integer}
def length_of_longest_substring(s)
  ret = {}
  hash = {}
  length = s.size
  (0..length-1).each do |i|
    hash[s[i]] = [] if hash[s[i]].nil?
    hash[s[i]] << i
  end
  # p hash
  (0..length-1).each do |i|
    ret[i] = {} if ret[i].nil?
    if hash[s[i]][1].nil?
      ret[i][:next] = s.size
    else
      ret[i][:next] = hash[s[i]][1]
      hash[s[i]].delete_at 1
    end
  end
  ret[length] = {
      :next => length,
      :first => length,
  }
  (0..length-1).each do |i|
    j = length - i - 1
    ret[j] = {} if ret[j].nil?
    ret[j][:first] = ret[j][:next] < ret[j+1][:first] ? ret[j][:next] : ret[j+1][:first]
  end
  longest = 0
  (0..length-1).each do |i|
    longest = ret[i][:first] - i if longest < ret[i][:first] - i
  end
  p longest
  # p hash
  # p ret
  longest
end

def main
  s = "ababca"
  length_of_longest_substring s
end

main