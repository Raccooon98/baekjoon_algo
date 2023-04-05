def solution(participant, completion):
    participant.sort()
    completion.sort()
    for c,p in zip(completion,participant):
        if c!=p:
            return p
    
    return participant.pop()